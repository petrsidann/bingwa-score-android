package f7;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class m implements d7.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final w6.b.EnumC0311b f8226d = w6.b.EnumC0311b.f17650a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecretKey f8227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f8228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f8229c;

    public m(byte[] bArr) throws GeneralSecurityException {
        r.a(bArr.length);
        this.f8227a = new SecretKeySpec(bArr, "AES");
        b();
    }

    public static Cipher c() throws GeneralSecurityException {
        if (f8226d.d()) {
            return i.f8218e.a("AES/ECB/NoPadding");
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    @Override // d7.a
    public byte[] a(byte[] bArr, int i10) throws GeneralSecurityException {
        if (i10 > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        Cipher cipherC = c();
        cipherC.init(1, this.f8227a);
        int iMax = Math.max(1, (int) Math.ceil(((double) bArr.length) / 16.0d));
        byte[] bArrD = iMax * 16 == bArr.length ? f.d(bArr, (iMax - 1) * 16, this.f8228b, 0, 16) : f.e(b7.a.a(Arrays.copyOfRange(bArr, (iMax - 1) * 16, bArr.length)), this.f8229c);
        byte[] bArrDoFinal = new byte[16];
        for (int i11 = 0; i11 < iMax - 1; i11++) {
            bArrDoFinal = cipherC.doFinal(f.d(bArrDoFinal, 0, bArr, i11 * 16, 16));
        }
        return Arrays.copyOf(cipherC.doFinal(f.e(bArrD, bArrDoFinal)), i10);
    }

    public final void b() throws GeneralSecurityException {
        Cipher cipherC = c();
        cipherC.init(1, this.f8227a);
        byte[] bArrB = b7.a.b(cipherC.doFinal(new byte[16]));
        this.f8228b = bArrB;
        this.f8229c = b7.a.b(bArrB);
    }
}
