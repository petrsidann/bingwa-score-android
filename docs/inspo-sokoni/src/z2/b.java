package z2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class b extends c {
    public b(i iVar, d dVar, long j10, int i10) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVar.f19756a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j11 = j10 + ((long) (i10 * 16));
        this.f19754a = iVar.B(byteBufferAllocate, j11);
        this.f19755b = iVar.B(byteBufferAllocate, j11 + 8);
    }
}
