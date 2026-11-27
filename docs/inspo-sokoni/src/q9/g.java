package q9;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import java.math.BigInteger;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
public class g extends f {
    public g(Context context) {
        super(context);
    }

    @Override // q9.f, q9.a
    public /* bridge */ /* synthetic */ byte[] a(Key key) {
        return super.a(key);
    }

    @Override // q9.f, q9.a
    public /* bridge */ /* synthetic */ Key b(byte[] bArr, String str) {
        return super.b(bArr, str);
    }

    @Override // q9.f
    public String c() {
        return this.f14903b.getPackageName() + ".FlutterSecureStoragePluginKeyOAEP";
    }

    @Override // q9.f
    public AlgorithmParameterSpec f() {
        return new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
    }

    @Override // q9.f
    public Cipher i() {
        return Cipher.getInstance("RSA/ECB/OAEPPadding", "AndroidKeyStoreBCWorkaround");
    }

    @Override // q9.f
    public AlgorithmParameterSpec j(Context context, Calendar calendar, Calendar calendar2) {
        return new KeyGenParameterSpec.Builder(this.f14902a, 3).setCertificateSubject(new X500Principal("CN=" + this.f14902a)).setDigests("SHA-256").setBlockModes("ECB").setEncryptionPaddings("OAEPPadding").setCertificateSerialNumber(BigInteger.valueOf(1L)).setCertificateNotBefore(calendar.getTime()).setCertificateNotAfter(calendar2.getTime()).build();
    }
}
