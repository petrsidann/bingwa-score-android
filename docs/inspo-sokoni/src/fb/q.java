package fb;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f8299b = new q(p.f8296a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f8300a;

    public q(p pVar) {
        this.f8300a = pVar;
    }

    @Override // fb.k
    public ByteBuffer a(i iVar) {
        p.a aVar = new p.a();
        this.f8300a.p(aVar, iVar.f8284a);
        this.f8300a.p(aVar, iVar.f8285b);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.d(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // fb.k
    public i b(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        Object objF = this.f8300a.f(byteBuffer);
        Object objF2 = this.f8300a.f(byteBuffer);
        if (!(objF instanceof String) || byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Method call corrupted");
        }
        return new i((String) objF, objF2);
    }

    @Override // fb.k
    public ByteBuffer c(Object obj) throws IOException {
        p.a aVar = new p.a();
        aVar.write(0);
        this.f8300a.p(aVar, obj);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.d(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // fb.k
    public ByteBuffer d(String str, String str2, Object obj, String str3) throws IOException {
        p.a aVar = new p.a();
        aVar.write(1);
        this.f8300a.p(aVar, str);
        this.f8300a.p(aVar, str2);
        if (obj instanceof Throwable) {
            this.f8300a.p(aVar, qa.b.d((Throwable) obj));
        } else {
            this.f8300a.p(aVar, obj);
        }
        this.f8300a.p(aVar, str3);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.d(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // fb.k
    public ByteBuffer e(String str, String str2, Object obj) throws IOException {
        p.a aVar = new p.a();
        aVar.write(1);
        this.f8300a.p(aVar, str);
        this.f8300a.p(aVar, str2);
        if (obj instanceof Throwable) {
            this.f8300a.p(aVar, qa.b.d((Throwable) obj));
        } else {
            this.f8300a.p(aVar, obj);
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.d(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // fb.k
    public Object f(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        byte b10 = byteBuffer.get();
        if (b10 != 0) {
            if (b10 == 1) {
            }
            throw new IllegalArgumentException("Envelope corrupted");
        }
        Object objF = this.f8300a.f(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return objF;
        }
        Object objF2 = this.f8300a.f(byteBuffer);
        Object objF3 = this.f8300a.f(byteBuffer);
        Object objF4 = this.f8300a.f(byteBuffer);
        if ((objF2 instanceof String) && ((objF3 == null || (objF3 instanceof String)) && !byteBuffer.hasRemaining())) {
            throw new d((String) objF2, (String) objF3, objF4);
        }
        throw new IllegalArgumentException("Envelope corrupted");
    }
}
