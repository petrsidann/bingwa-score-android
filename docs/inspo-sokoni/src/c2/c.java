package c2;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KeyGenParameterSpec f3165b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public KeyGenParameterSpec f3167b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f3168c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f3169d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3170e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f3171f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Context f3172g;

        /* JADX INFO: renamed from: c2.c$a$a, reason: collision with other inner class name */
        public static class C0061a {

            /* JADX INFO: renamed from: c2.c$a$a$a, reason: collision with other inner class name */
            public static class C0062a {
                public static void a(KeyGenParameterSpec.Builder builder) {
                    builder.setIsStrongBoxBacked(true);
                }
            }

            /* JADX INFO: renamed from: c2.c$a$a$b */
            public static class b {
                public static void a(KeyGenParameterSpec.Builder builder, int i10, int i11) {
                    builder.setUserAuthenticationParameters(i10, i11);
                }
            }

            public static c a(a aVar) {
                b bVar = aVar.f3168c;
                if (bVar == null && aVar.f3167b == null) {
                    throw new IllegalArgumentException("build() called before setKeyGenParameterSpec or setKeyScheme.");
                }
                if (bVar == b.AES256_GCM) {
                    KeyGenParameterSpec.Builder keySize = new KeyGenParameterSpec.Builder(aVar.f3166a, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256);
                    if (aVar.f3169d) {
                        keySize.setUserAuthenticationRequired(true);
                        if (Build.VERSION.SDK_INT >= 30) {
                            b.a(keySize, aVar.f3170e, 3);
                        } else {
                            keySize.setUserAuthenticationValidityDurationSeconds(aVar.f3170e);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 28 && aVar.f3171f && aVar.f3172g.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore")) {
                        C0062a.a(keySize);
                    }
                    aVar.f3167b = keySize.build();
                }
                KeyGenParameterSpec keyGenParameterSpec = aVar.f3167b;
                if (keyGenParameterSpec != null) {
                    return new c(e.c(keyGenParameterSpec), aVar.f3167b);
                }
                throw new NullPointerException("KeyGenParameterSpec was null after build() check");
            }

            public static String b(KeyGenParameterSpec keyGenParameterSpec) {
                return keyGenParameterSpec.getKeystoreAlias();
            }
        }

        public a(Context context) {
            this(context, "_androidx_security_master_key_");
        }

        public a(Context context, String str) {
            this.f3172g = context.getApplicationContext();
            this.f3166a = str;
        }

        public c a() {
            return C0061a.a(this);
        }

        public a b(KeyGenParameterSpec keyGenParameterSpec) {
            if (this.f3168c != null) {
                throw new IllegalArgumentException("KeyGenParamSpec set after setting a KeyScheme");
            }
            if (this.f3166a.equals(C0061a.b(keyGenParameterSpec))) {
                this.f3167b = keyGenParameterSpec;
                return this;
            }
            throw new IllegalArgumentException("KeyGenParamSpec's key alias does not match provided alias (" + this.f3166a + " vs " + C0061a.b(keyGenParameterSpec));
        }
    }

    public enum b {
        AES256_GCM
    }

    public c(String str, Object obj) {
        this.f3164a = str;
        this.f3165b = (KeyGenParameterSpec) obj;
    }

    public String a() {
        return this.f3164a;
    }

    public boolean b() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.containsAlias(this.f3164a);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException unused) {
            return false;
        }
    }

    public String toString() {
        return "MasterKey{keyAlias=" + this.f3164a + ", isKeyStoreBacked=" + b() + "}";
    }
}
