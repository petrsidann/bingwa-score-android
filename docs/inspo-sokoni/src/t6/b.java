package t6;

import f7.q;
import f7.r;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final w6.b.EnumC0311b f15847c = w6.b.EnumC0311b.f17651b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<Cipher> f15848d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecretKey f15849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15850b;

    public class a extends ThreadLocal<Cipher> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cipher initialValue() {
            try {
                return f7.i.f8218e.a("AES/GCM/NoPadding");
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    public b(byte[] bArr, boolean z10) throws GeneralSecurityException {
        if (!f15847c.d()) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        r.a(bArr.length);
        this.f15849a = new SecretKeySpec(bArr, "AES");
        this.f15850b = z10;
    }

    public static AlgorithmParameterSpec c(byte[] bArr) {
        return d(bArr, 0, bArr.length);
    }

    public static AlgorithmParameterSpec d(byte[] bArr, int i10, int i11) {
        return (!q.b() || q.a() > 19) ? new GCMParameterSpec(128, bArr, i10, i11) : new IvParameterSpec(bArr, i10, i11);
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (bArr.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        }
        boolean z10 = this.f15850b;
        if (bArr2.length < (z10 ? 28 : 16)) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (z10 && !ByteBuffer.wrap(bArr).equals(ByteBuffer.wrap(bArr2, 0, 12))) {
            throw new GeneralSecurityException("iv does not match prepended iv");
        }
        AlgorithmParameterSpec algorithmParameterSpecC = c(bArr);
        ThreadLocal<Cipher> threadLocal = f15848d;
        threadLocal.get().init(2, this.f15849a, algorithmParameterSpecC);
        if (bArr3 != null && bArr3.length != 0) {
            threadLocal.get().updateAAD(bArr3);
        }
        boolean z11 = this.f15850b;
        return threadLocal.get().doFinal(bArr2, z11 ? 12 : 0, z11 ? bArr2.length - 12 : bArr2.length);
    }

    public byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (bArr.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        }
        if (bArr2.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        boolean z10 = this.f15850b;
        int length = bArr2.length;
        if (z10) {
            length += 12;
        }
        byte[] bArr4 = new byte[length + 16];
        if (z10) {
            System.arraycopy(bArr, 0, bArr4, 0, 12);
        }
        AlgorithmParameterSpec algorithmParameterSpecC = c(bArr);
        ThreadLocal<Cipher> threadLocal = f15848d;
        threadLocal.get().init(1, this.f15849a, algorithmParameterSpecC);
        if (bArr3 != null && bArr3.length != 0) {
            threadLocal.get().updateAAD(bArr3);
        }
        int iDoFinal = threadLocal.get().doFinal(bArr2, 0, bArr2.length, bArr4, this.f15850b ? 12 : 0);
        if (iDoFinal == bArr2.length + 16) {
            return bArr4;
        }
        throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(iDoFinal - bArr2.length)));
    }
}
