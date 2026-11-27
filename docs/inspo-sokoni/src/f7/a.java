package f7;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class a implements l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final w6.b.EnumC0311b f8174d = w6.b.EnumC0311b.f17651b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ThreadLocal<Cipher> f8175e = new C0137a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f8176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8178c;

    /* JADX INFO: renamed from: f7.a$a, reason: collision with other inner class name */
    public class C0137a extends ThreadLocal<Cipher> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cipher initialValue() {
            try {
                return i.f8218e.a("AES/CTR/NoPadding");
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    public a(byte[] bArr, int i10) throws GeneralSecurityException {
        if (!f8174d.d()) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        r.a(bArr.length);
        this.f8176a = new SecretKeySpec(bArr, "AES");
        int blockSize = f8175e.get().getBlockSize();
        this.f8178c = blockSize;
        if (i10 < 12 || i10 > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.f8177b = i10;
    }

    @Override // f7.l
    public byte[] a(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i10 = this.f8177b;
        if (length > com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER - i10) {
            throw new GeneralSecurityException("plaintext length can not exceed " + (com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER - this.f8177b));
        }
        byte[] bArr2 = new byte[bArr.length + i10];
        byte[] bArrC = p.c(i10);
        System.arraycopy(bArrC, 0, bArr2, 0, this.f8177b);
        c(bArr, 0, bArr.length, bArr2, this.f8177b, bArrC, true);
        return bArr2;
    }

    @Override // f7.l
    public byte[] b(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i10 = this.f8177b;
        if (length < i10) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, 0, bArr2, 0, i10);
        int length2 = bArr.length;
        int i11 = this.f8177b;
        byte[] bArr3 = new byte[length2 - i11];
        c(bArr, i11, bArr.length - i11, bArr3, 0, bArr2, false);
        return bArr3;
    }

    public final void c(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, byte[] bArr3, boolean z10) throws GeneralSecurityException {
        Cipher cipher = f8175e.get();
        byte[] bArr4 = new byte[this.f8178c];
        System.arraycopy(bArr3, 0, bArr4, 0, this.f8177b);
        cipher.init(z10 ? 1 : 2, this.f8176a, new IvParameterSpec(bArr4));
        if (cipher.doFinal(bArr, i10, i11, bArr2, i12) != i11) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }
}
