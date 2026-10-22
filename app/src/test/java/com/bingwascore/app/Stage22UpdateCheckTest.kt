package com.bingwascore.app

import com.bingwascore.app.BuildConfig
import com.bingwascore.app.updates.UpdateChecker
import com.bingwascore.app.updates.isNewer
import com.bingwascore.app.updates.parseUpdateManifest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Stage 22 — CHECK FOR UPDATES + the 1.9.1 release.
 *
 * The app reads ONE document — the release manifest at `/updates/latest.json` —
 * and compares it to the build it is running. The document ships inside the
 * APK today (the local mock); the day a server hosts it, the same file is
 * fetched and nothing else changes.
 */
class Stage22UpdateCheckTest {

    private val repoRoot: File = sequenceOf(
        File(System.getProperty("user.dir")),
        File(System.getProperty("user.dir")).parentFile,
    ).firstOrNull {
        File(it, "app/src/main/java/com/bingwascore/app").exists()
    } ?: error("repo root not found from user.dir=${System.getProperty("user.dir")}")

    private fun manifestAsset(): String =
        File(repoRoot, "app/src/main/assets/${UpdateChecker.ASSET_PATH}").readText()

    // ── The release ──────────────────────────────────────────────────────────

    @Test
    fun `the build is 1 9 1 at version code 11`() {
        assertEquals("1.9.1", BuildConfig.VERSION_NAME)
        assertEquals("1.9.1", BuildConfig.APP_VERSION)
        assertEquals(11, BuildConfig.VERSION_CODE)
    }

    // ── The manifest ─────────────────────────────────────────────────────────

    @Test
    fun `the bundled manifest parses`() {
        val manifest = parseUpdateManifest(manifestAsset())
        assertNotNull("the bundled manifest must parse", manifest)
        assertEquals("1.9.1", manifest!!.versionName)
        assertEquals(11, manifest.versionCode)
        assertTrue("the manifest must carry a download url", manifest.downloadUrl.isNotBlank())
        assertTrue("the manifest must carry release notes", manifest.changelog.isNotBlank())
    }

    @Test
    fun `the bundled manifest matches the build`() {
        val manifest = parseUpdateManifest(manifestAsset())!!
        assertFalse(
            "the bundled manifest must not claim a newer build than the one shipped",
            manifest.isNewerThan(BuildConfig.VERSION_NAME)
        )
    }

    @Test
    fun `a newer manifest is detected`() {
        val manifest = parseUpdateManifest(manifestAsset())!!
        assertTrue(manifest.isNewerThan("1.9.0"))
        assertFalse(manifest.isNewerThan("1.9.1"))
        assertTrue(isNewer("1.9.1", "1.10.0"))
    }

    @Test
    fun `an unusable manifest is rejected`() {
        assertNull(parseUpdateManifest(""))
        assertNull(parseUpdateManifest("   "))
        assertNull(parseUpdateManifest("not json at all"))
        assertNull(parseUpdateManifest("""{"versionCode": 11}"""))
        // A "v" prefix is tolerated, exactly like the release tags.
        assertEquals("1.9.2", parseUpdateManifest("""{"versionName": "v1.9.2"}""")!!.versionName)
    }

    @Test
    fun `the manifest lives at the updates path`() {
        assertEquals("updates/latest.json", UpdateChecker.ASSET_PATH)
        assertTrue(
            "the manifest must exist in the app assets",
            File(repoRoot, "app/src/main/assets/${UpdateChecker.ASSET_PATH}").exists()
        )
    }
}
