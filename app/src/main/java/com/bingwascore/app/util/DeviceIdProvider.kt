package com.bingwascore.app.util

import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import java.security.KeyPairGenerator
import java.security.KeyStore
import java.security.MessageDigest
import java.security.spec.ECGenParameterSpec
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

/**
 * Parity F — permanent device identity.
 *
 * The Mesh screen used to show a *random* `BSC-XXXXX` string, so the id changed
 * on every install and two devices could collide. This provider derives a
 * stable id from an **AndroidKeyStore** key pair: the public key of a
 * hardware-backed key is hashed with SHA-256 and the first 12 hex characters
 * become the visible id (`BSC-4F9A1C2B7E30`).
 *
 * - The key pair is generated once per install and never leaves the keystore.
 * - The derived id is cached in SharedPreferences so later launches are cheap
 *   and the id stays stable even if the keystore key is rotated by the system.
 * - If the keystore is unavailable (locked/older OEM quirk) we fall back to a
 *   persisted random id so the Mesh screen always has *something* to show.
 */
@Singleton
class DeviceIdProvider @Inject constructor(
    @ApplicationContext private val context: Context
) {

    @Volatile
    private var cached: String? = null

    /** The device's permanent id, e.g. `BSC-4F9A1C2B7E30`. */
    fun deviceId(): String {
        cached?.let { return it }
        synchronized(this) {
            cached?.let { return it }
            val resolved = readCached() ?: deriveFromKeystore() ?: randomFallback()
            persist(resolved)
            cached = resolved
            return resolved
        }
    }

    private fun readCached(): String? = try {
        prefs().getString(KEY_CACHED_ID, null)?.takeIf { it.isNotBlank() }
    } catch (t: Throwable) {
        Timber.e(t, "DeviceIdProvider: could not read the cached device id")
        null
    }

    /** SHA-256 of the AndroidKeyStore public key, truncated to the visible id. */
    private fun deriveFromKeystore(): String? = try {
        val keyStore = KeyStore.getInstance(ANDROID_KEYSTORE).apply { load(null) }
        val publicKey = if (keyStore.containsAlias(KEY_ALIAS)) {
            keyStore.getCertificate(KEY_ALIAS)?.publicKey
        } else {
            val generator = KeyPairGenerator.getInstance(
                KeyProperties.KEY_ALGORITHM_EC,
                ANDROID_KEYSTORE
            )
            generator.initialize(
                KeyGenParameterSpec.Builder(
                    KEY_ALIAS,
                    KeyProperties.PURPOSE_SIGN or KeyProperties.PURPOSE_VERIFY
                )
                    .setAlgorithmParameterSpec(ECGenParameterSpec("secp256r1"))
                    .setDigests(KeyProperties.DIGEST_SHA256)
                    .build()
            )
            generator.generateKeyPair().public
        }
        publicKey?.encoded?.let { encoded ->
            val digest = MessageDigest.getInstance(DIGEST).digest(encoded)
            "BSC-" + digest.joinToString("") { byte ->
                "%02X".format(byte)
            }.take(ID_LENGTH)
        }
    } catch (t: Throwable) {
        Timber.e(t, "DeviceIdProvider: keystore key pair unavailable")
        null
    }

    /** Last resort (keystore unusable): a persisted random id, still stable. */
    private fun randomFallback(): String {
        val charset = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789"
        val suffix = (1..ID_LENGTH).map { charset[Random.nextInt(charset.length)] }
            .joinToString("")
        return "BSC-$suffix"
    }

    private fun persist(id: String) {
        try {
            prefs().edit().putString(KEY_CACHED_ID, id).apply()
        } catch (t: Throwable) {
            Timber.e(t, "DeviceIdProvider: could not cache the device id")
        }
    }

    private fun prefs() = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)

    private companion object {
        const val ANDROID_KEYSTORE = "AndroidKeyStore"
        const val KEY_ALIAS = "bingwa_device_identity"
        const val PREFS = "bingwa_device_identity"
        const val KEY_CACHED_ID = "device_id"
        const val DIGEST = "SHA-256"

        /** Hex characters kept from the digest — 12 reads as a device fingerprint. */
        const val ID_LENGTH = 12
    }
}