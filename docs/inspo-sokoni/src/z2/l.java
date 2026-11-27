package z2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class l extends f {
    public l(i iVar, d dVar, int i10) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(dVar.f19756a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f19769a = iVar.D(byteBufferAllocate, dVar.f19759d + ((long) (i10 * dVar.f19762g)) + 28);
    }
}
