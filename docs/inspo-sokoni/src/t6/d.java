package t6;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f15851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15852b;

    public d(byte[] bArr, int i10) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.f15851a = a.e(bArr);
        this.f15852b = i10;
    }

    public ByteBuffer a(byte[] bArr, int i10) {
        int[] iArrB = b(a.e(bArr), i10);
        int[] iArr = (int[]) iArrB.clone();
        a.d(iArr);
        for (int i11 = 0; i11 < iArrB.length; i11++) {
            iArrB[i11] = iArrB[i11] + iArr[i11];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrB, 0, 16);
        return byteBufferOrder;
    }

    public abstract int[] b(int[] iArr, int i10);

    public byte[] c(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        f(bArr, byteBufferAllocate, byteBuffer);
        return byteBufferAllocate.array();
    }

    public void d(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() < bArr2.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        f(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
    }

    public abstract int e();

    public final void f(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        if (bArr.length != e()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + e());
        }
        int iRemaining = byteBuffer2.remaining();
        int i10 = (iRemaining / 64) + 1;
        for (int i11 = 0; i11 < i10; i11++) {
            ByteBuffer byteBufferA = a(bArr, this.f15852b + i11);
            if (i11 == i10 - 1) {
                f7.f.c(byteBuffer, byteBuffer2, byteBufferA, iRemaining % 64);
            } else {
                f7.f.c(byteBuffer, byteBuffer2, byteBufferA, 64);
            }
        }
    }
}
