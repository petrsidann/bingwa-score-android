package z2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class g extends d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f19770j;

    public g(boolean z10, i iVar) {
        this.f19756a = z10;
        this.f19770j = iVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(z10 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f19757b = iVar.z(byteBufferAllocate, 16L);
        this.f19758c = iVar.D(byteBufferAllocate, 28L);
        this.f19759d = iVar.D(byteBufferAllocate, 32L);
        this.f19760e = iVar.z(byteBufferAllocate, 42L);
        this.f19761f = iVar.z(byteBufferAllocate, 44L);
        this.f19762g = iVar.z(byteBufferAllocate, 46L);
        this.f19763h = iVar.z(byteBufferAllocate, 48L);
        this.f19764i = iVar.z(byteBufferAllocate, 50L);
    }

    @Override // z2.d
    public c a(long j10, int i10) {
        return new a(this.f19770j, this, j10, i10);
    }

    @Override // z2.d
    public e b(long j10) {
        return new j(this.f19770j, this, j10);
    }

    @Override // z2.d
    public f c(int i10) {
        return new l(this.f19770j, this, i10);
    }
}
