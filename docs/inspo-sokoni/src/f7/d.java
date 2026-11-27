package f7;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class d implements r6.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final w6.b.EnumC0311b f8188c = w6.b.EnumC0311b.f17650a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Collection<Integer> f8189d = Arrays.asList(64);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f8190e = new byte[16];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f8191f = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f8192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f8193b;

    public d(byte[] bArr) throws GeneralSecurityException {
        if (!f8188c.d()) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        if (f8189d.contains(Integer.valueOf(bArr.length))) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
            this.f8193b = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
            this.f8192a = new m(bArrCopyOfRange);
        } else {
            throw new InvalidKeyException("invalid key size: " + bArr.length + " bytes; key must have 64 bytes");
        }
    }

    @Override // r6.d
    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483631) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Cipher cipherA = i.f8218e.a("AES/CTR/NoPadding");
        byte[] bArrC = c(bArr2, bArr);
        byte[] bArr3 = (byte[]) bArrC.clone();
        bArr3[8] = (byte) (bArr3[8] & 127);
        bArr3[12] = (byte) (bArr3[12] & 127);
        cipherA.init(1, new SecretKeySpec(this.f8193b, "AES"), new IvParameterSpec(bArr3));
        return f.a(bArrC, cipherA.doFinal(bArr));
    }

    @Override // r6.d
    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 16) {
            throw new GeneralSecurityException("Ciphertext too short.");
        }
        Cipher cipherA = i.f8218e.a("AES/CTR/NoPadding");
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 16);
        byte[] bArr3 = (byte[]) bArrCopyOfRange.clone();
        bArr3[8] = (byte) (bArr3[8] & 127);
        bArr3[12] = (byte) (bArr3[12] & 127);
        cipherA.init(2, new SecretKeySpec(this.f8193b, "AES"), new IvParameterSpec(bArr3));
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, 16, bArr.length);
        byte[] bArrDoFinal = cipherA.doFinal(bArrCopyOfRange2);
        if (bArrCopyOfRange2.length == 0 && bArrDoFinal == null && q.b()) {
            bArrDoFinal = new byte[0];
        }
        if (f.b(bArrCopyOfRange, c(bArr2, bArrDoFinal))) {
            return bArrDoFinal;
        }
        throw new AEADBadTagException("Integrity check failed.");
    }

    public final byte[] c(byte[]... bArr) throws GeneralSecurityException {
        if (bArr.length == 0) {
            return this.f8192a.a(f8191f, 16);
        }
        byte[] bArrA = this.f8192a.a(f8190e, 16);
        for (int i10 = 0; i10 < bArr.length - 1; i10++) {
            byte[] bArr2 = bArr[i10];
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            bArrA = f.e(b7.a.b(bArrA), this.f8192a.a(bArr2, 16));
        }
        byte[] bArr3 = bArr[bArr.length - 1];
        return this.f8192a.a(bArr3.length >= 16 ? f.f(bArr3, bArrA) : f.e(b7.a.a(bArr3), b7.a.b(bArrA)), 16);
    }
}
