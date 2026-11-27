package f7;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class s implements r6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t6.h f8241a;

    public s(byte[] bArr) {
        this.f8241a = new t6.h(bArr);
    }

    @Override // r6.a
    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 24 + 16);
        byte[] bArrC = p.c(24);
        byteBufferAllocate.put(bArrC);
        this.f8241a.b(byteBufferAllocate, bArrC, bArr, bArr2);
        return byteBufferAllocate.array();
    }

    @Override // r6.a
    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 40) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 24);
        return this.f8241a.a(ByteBuffer.wrap(bArr, 24, bArr.length - 24), bArrCopyOf, bArr2);
    }
}
