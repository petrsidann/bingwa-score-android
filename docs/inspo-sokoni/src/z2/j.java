package z2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class j extends e {
    public j(i iVar, d dVar, long j10) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f19756a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j11 = dVar.f19758c + (j10 * ((long) dVar.f19760e));
        this.f19765a = iVar.D(byteBufferAllocate, j11);
        this.f19766b = iVar.D(byteBufferAllocate, 4 + j11);
        this.f19767c = iVar.D(byteBufferAllocate, 8 + j11);
        this.f19768d = iVar.D(byteBufferAllocate, j11 + 20);
    }
}
