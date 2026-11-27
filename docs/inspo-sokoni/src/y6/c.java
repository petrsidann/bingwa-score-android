package y6;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import f7.p;
import f7.r;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.KeyGenerator;
import r6.q;

/* JADX INFO: loaded from: classes.dex */
public final class c implements q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f19403c = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public KeyStore f19405b;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19406a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public KeyStore f19407b;

        public b() {
            this.f19407b = null;
            if (!c.f()) {
                throw new IllegalStateException("need Android Keystore on Android M or newer");
            }
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.f19407b = keyStore;
                keyStore.load(null);
            } catch (IOException | GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }

        public c a() {
            return new c(this);
        }

        public b b(KeyStore keyStore) {
            if (keyStore == null) {
                throw new IllegalArgumentException("val cannot be null");
            }
            this.f19407b = keyStore;
            return this;
        }
    }

    public c() {
        this(new b());
    }

    public c(b bVar) {
        this.f19404a = bVar.f19406a;
        this.f19405b = bVar.f19407b;
    }

    public static void d(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        if (new c().e(str)) {
            throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", str));
        }
        String strB = r.b("android-keystore://", str);
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        keyGenerator.init(new KeyGenParameterSpec.Builder(strB, 3).setKeySize(256).setBlockModes("GCM").setEncryptionPaddings("NoPadding").build());
        keyGenerator.generateKey();
    }

    public static boolean f() {
        return true;
    }

    public static r6.a g(r6.a aVar) throws KeyStoreException {
        byte[] bArrC = p.c(10);
        byte[] bArr = new byte[0];
        if (Arrays.equals(bArrC, aVar.b(aVar.a(bArrC, bArr), bArr))) {
            return aVar;
        }
        throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
    }

    @Override // r6.q
    public synchronized boolean a(String str) {
        String str2 = this.f19404a;
        if (str2 == null || !str2.equals(str)) {
            return this.f19404a == null && str.toLowerCase(Locale.US).startsWith("android-keystore://");
        }
        return true;
    }

    @Override // r6.q
    public synchronized r6.a b(String str) {
        String str2 = this.f19404a;
        if (str2 != null && !str2.equals(str)) {
            throw new GeneralSecurityException(String.format("this client is bound to %s, cannot load keys bound to %s", this.f19404a, str));
        }
        return g(new y6.b(r.b("android-keystore://", str), this.f19405b));
    }

    public synchronized boolean e(String str) {
        String strB;
        strB = r.b("android-keystore://", str);
        try {
        } catch (NullPointerException unused) {
            Log.w(f19403c, "Keystore is temporarily unavailable, wait 20ms, reinitialize Keystore and try again.");
            try {
                Thread.sleep(20L);
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.f19405b = keyStore;
                keyStore.load(null);
            } catch (IOException e10) {
                throw new GeneralSecurityException(e10);
            } catch (InterruptedException unused2) {
            }
            return this.f19405b.containsAlias(strB);
        }
        return this.f19405b.containsAlias(strB);
    }
}
