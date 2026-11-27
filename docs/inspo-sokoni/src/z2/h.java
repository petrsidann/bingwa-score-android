package z2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class h extends d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f19771j;

    public h(boolean z10, i iVar) {
        this.f19756a = z10;
        this.f19771j = iVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(z10 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f19757b = iVar.z(byteBufferAllocate, 16L);
        this.f19758c = iVar.B(byteBufferAllocate, 32L);
        this.f19759d = iVar.B(byteBufferAllocate, 40L);
        this.f19760e = iVar.z(byteBufferAllocate, 54L);
        this.f19761f = iVar.z(byteBufferAllocate, 56L);
        this.f19762g = iVar.z(byteBufferAllocate, 58L);
        this.f19763h = iVar.z(byteBufferAllocate, 60L);
        this.f19764i = iVar.z(byteBufferAllocate, 62L);
    }

    @Override // z2.d
    public c a(long j10, int i10) {
        return new b(this.f19771j, this, j10, i10);
    }

    @Override // z2.d
    public e b(long j10) {
        return new k(this.f19771j, this, j10);
    }

    @Override // z2.d
    public f c(int i10) {
        return new m(this.f19771j, this, i10);
    }
}
