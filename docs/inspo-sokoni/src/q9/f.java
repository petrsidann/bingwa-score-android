package q9;

import android.content.Context;
import android.content.res.Configuration;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
public class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14902a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f14903b;

    public f(Context context) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        this.f14903b = context;
        e(context);
    }

    @Override // q9.a
    public byte[] a(Key key) throws Exception {
        PublicKey publicKeyH = h();
        Cipher cipherI = i();
        cipherI.init(3, publicKeyH, f());
        return cipherI.wrap(key);
    }

    @Override // q9.a
    public Key b(byte[] bArr, String str) throws Exception {
        PrivateKey privateKeyG = g();
        Cipher cipherI = i();
        cipherI.init(4, privateKeyG, f());
        return cipherI.unwrap(bArr, str, 3);
    }

    public String c() {
        return this.f14903b.getPackageName() + ".FlutterSecureStoragePluginKey";
    }

    public final void d(Context context) {
        Locale locale = Locale.getDefault();
        try {
            k(Locale.ENGLISH);
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 25);
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            keyPairGenerator.initialize(j(context, calendar, calendar2));
            keyPairGenerator.generateKeyPair();
        } finally {
            k(locale);
        }
    }

    public final void e(Context context) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        if (keyStore.getKey(this.f14902a, null) == null) {
            d(context);
        }
    }

    public AlgorithmParameterSpec f() {
        return null;
    }

    public final PrivateKey g() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        Key key = keyStore.getKey(this.f14902a, null);
        if (key != null) {
            if (key instanceof PrivateKey) {
                return (PrivateKey) key;
            }
            throw new Exception("Not an instance of a PrivateKey");
        }
        throw new Exception("No key found under alias: " + this.f14902a);
    }

    public final PublicKey h() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        Certificate certificate = keyStore.getCertificate(this.f14902a);
        if (certificate == null) {
            throw new Exception("No certificate found under alias: " + this.f14902a);
        }
        PublicKey publicKey = certificate.getPublicKey();
        if (publicKey != null) {
            return publicKey;
        }
        throw new Exception("No key found under alias: " + this.f14902a);
    }

    public Cipher i() {
        return Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidKeyStoreBCWorkaround");
    }

    public AlgorithmParameterSpec j(Context context, Calendar calendar, Calendar calendar2) {
        return new KeyGenParameterSpec.Builder(this.f14902a, 3).setCertificateSubject(new X500Principal("CN=" + this.f14902a)).setDigests("SHA-256").setBlockModes("ECB").setEncryptionPaddings("PKCS1Padding").setCertificateSerialNumber(BigInteger.valueOf(1L)).setCertificateNotBefore(calendar.getTime()).setCertificateNotAfter(calendar2.getTime()).build();
    }

    public final void k(Locale locale) {
        Locale.setDefault(locale);
        Configuration configuration = this.f14903b.getResources().getConfiguration();
        configuration.setLocale(locale);
        this.f14903b.createConfigurationContext(configuration);
    }
}
