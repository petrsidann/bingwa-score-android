package s6;

import e7.a0;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import r6.w;

/* JADX INFO: loaded from: classes.dex */
public final class j implements r6.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f15581c = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f15582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r6.a f15583b;

    public j(a0 a0Var, r6.a aVar) {
        this.f15582a = a0Var;
        this.f15583b = aVar;
    }

    @Override // r6.a
    public byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArrI = w.i(this.f15582a).i();
        return c(this.f15583b.a(bArrI, f15581c), ((r6.a) w.f(this.f15582a.S(), bArrI, r6.a.class)).a(bArr, bArr2));
    }

    @Override // r6.a
    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i10 = byteBufferWrap.getInt();
            if (i10 <= 0 || i10 > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i10];
            byteBufferWrap.get(bArr3, 0, i10);
            byte[] bArr4 = new byte[byteBufferWrap.remaining()];
            byteBufferWrap.get(bArr4, 0, byteBufferWrap.remaining());
            return ((r6.a) w.f(this.f15582a.S(), this.f15583b.b(bArr3, f15581c), r6.a.class)).b(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e10) {
            throw new GeneralSecurityException("invalid ciphertext", e10);
        }
    }

    public final byte[] c(byte[] bArr, byte[] bArr2) {
        return ByteBuffer.allocate(bArr.length + 4 + bArr2.length).putInt(bArr.length).put(bArr).put(bArr2).array();
    }
}
