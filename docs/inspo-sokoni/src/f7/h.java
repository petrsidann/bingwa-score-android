package f7;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class h implements r6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f8212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r6.s f8213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8214c;

    public h(l lVar, r6.s sVar, int i10) {
        this.f8212a = lVar;
        this.f8213b = sVar;
        this.f8214c = i10;
    }

    @Override // r6.a
    public byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArrA = this.f8212a.a(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return f.a(bArrA, this.f8213b.b(f.a(bArr2, bArrA, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8))));
    }

    @Override // r6.a
    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i10 = this.f8214c;
        if (length < i10) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length - i10);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - this.f8214c, bArr.length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        this.f8213b.a(bArrCopyOfRange2, f.a(bArr2, bArrCopyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8)));
        return this.f8212a.b(bArrCopyOfRange);
    }
}
