package xb;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class m1 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f18742a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v2 f18744c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w2 f18749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final o2 f18750i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f18751j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f18752k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f18754m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18743b = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public vb.o f18745d = vb.m.b.f17449a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f18746e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f18747f = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ByteBuffer f18748g = ByteBuffer.allocate(5);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f18753l = -1;

    public final class b extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<v2> f18755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public v2 f18756b;

        public b() {
            this.f18755a = new ArrayList();
        }

        public final int a() {
            Iterator<v2> it = this.f18755a.iterator();
            int iA = 0;
            while (it.hasNext()) {
                iA += it.next().a();
            }
            return iA;
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            v2 v2Var = this.f18756b;
            if (v2Var == null || v2Var.b() <= 0) {
                write(new byte[]{(byte) i10}, 0, 1);
            } else {
                this.f18756b.c((byte) i10);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            if (this.f18756b == null) {
                v2 v2VarA = m1.this.f18749h.a(i11);
                this.f18756b = v2VarA;
                this.f18755a.add(v2VarA);
            }
            while (i11 > 0) {
                int iMin = Math.min(i11, this.f18756b.b());
                if (iMin == 0) {
                    v2 v2VarA2 = m1.this.f18749h.a(Math.max(i11, this.f18756b.a() * 2));
                    this.f18756b = v2VarA2;
                    this.f18755a.add(v2VarA2);
                } else {
                    this.f18756b.write(bArr, i10, iMin);
                    i10 += iMin;
                    i11 -= iMin;
                }
            }
        }
    }

    public class c extends OutputStream {
        public c() {
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            write(new byte[]{(byte) i10}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            m1.this.n(bArr, i10, i11);
        }
    }

    public interface d {
        void m(v2 v2Var, boolean z10, boolean z11, int i10);
    }

    public m1(d dVar, w2 w2Var, o2 o2Var) {
        this.f18742a = (d) j6.m.p(dVar, "sink");
        this.f18749h = (w2) j6.m.p(w2Var, "bufferAllocator");
        this.f18750i = (o2) j6.m.p(o2Var, "statsTraceCtx");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int o(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream instanceof vb.x) {
            return ((vb.x) inputStream).d(outputStream);
        }
        long jB = l6.b.b(inputStream, outputStream);
        j6.m.j(jB <= 2147483647L, "Message size overflow: %s", jB);
        return (int) jB;
    }

    @Override // xb.p0
    public void c(InputStream inputStream) {
        j();
        this.f18752k++;
        int i10 = this.f18753l + 1;
        this.f18753l = i10;
        this.f18754m = 0L;
        this.f18750i.i(i10);
        boolean z10 = this.f18746e && this.f18745d != vb.m.b.f17449a;
        try {
            int iG = g(inputStream);
            int iP = (iG == 0 || !z10) ? p(inputStream, iG) : l(inputStream, iG);
            if (iG != -1 && iP != iG) {
                throw vb.l1.f17419s.q(String.format("Message length inaccurate %s != %s", Integer.valueOf(iP), Integer.valueOf(iG))).d();
            }
            long j10 = iP;
            this.f18750i.k(j10);
            this.f18750i.l(this.f18754m);
            this.f18750i.j(this.f18753l, this.f18754m, j10);
        } catch (IOException e10) {
            throw vb.l1.f17419s.q("Failed to frame message").p(e10).d();
        } catch (vb.n1 e11) {
            throw e11;
        } catch (RuntimeException e12) {
            throw vb.l1.f17419s.q("Failed to frame message").p(e12).d();
        }
    }

    @Override // xb.p0
    public void close() {
        if (isClosed()) {
            return;
        }
        this.f18751j = true;
        v2 v2Var = this.f18744c;
        if (v2Var != null && v2Var.a() == 0) {
            h();
        }
        e(true, true);
    }

    public final void e(boolean z10, boolean z11) {
        v2 v2Var = this.f18744c;
        this.f18744c = null;
        this.f18742a.m(v2Var, z10, z11, this.f18752k);
        this.f18752k = 0;
    }

    @Override // xb.p0
    public void f(int i10) {
        j6.m.v(this.f18743b == -1, "max size already set");
        this.f18743b = i10;
    }

    @Override // xb.p0
    public void flush() {
        v2 v2Var = this.f18744c;
        if (v2Var == null || v2Var.a() <= 0) {
            return;
        }
        e(false, true);
    }

    public final int g(InputStream inputStream) {
        if ((inputStream instanceof vb.s0) || (inputStream instanceof ByteArrayInputStream)) {
            return inputStream.available();
        }
        return -1;
    }

    public final void h() {
        v2 v2Var = this.f18744c;
        if (v2Var != null) {
            v2Var.release();
            this.f18744c = null;
        }
    }

    @Override // xb.p0
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public m1 b(vb.o oVar) {
        this.f18745d = (vb.o) j6.m.p(oVar, "Can't pass an empty compressor");
        return this;
    }

    @Override // xb.p0
    public boolean isClosed() {
        return this.f18751j;
    }

    public final void j() {
        if (isClosed()) {
            throw new IllegalStateException("Framer already closed");
        }
    }

    public final void k(b bVar, boolean z10) {
        int iA = bVar.a();
        int i10 = this.f18743b;
        if (i10 >= 0 && iA > i10) {
            throw vb.l1.f17414n.q(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iA), Integer.valueOf(this.f18743b))).d();
        }
        this.f18748g.clear();
        this.f18748g.put(z10 ? (byte) 1 : (byte) 0).putInt(iA);
        v2 v2VarA = this.f18749h.a(5);
        v2VarA.write(this.f18748g.array(), 0, this.f18748g.position());
        if (iA == 0) {
            this.f18744c = v2VarA;
            return;
        }
        this.f18742a.m(v2VarA, false, false, this.f18752k - 1);
        this.f18752k = 1;
        List list = bVar.f18755a;
        for (int i11 = 0; i11 < list.size() - 1; i11++) {
            this.f18742a.m((v2) list.get(i11), false, false, 0);
        }
        this.f18744c = (v2) list.get(list.size() - 1);
        this.f18754m = iA;
    }

    public final int l(InputStream inputStream, int i10) throws IOException {
        b bVar = new b();
        OutputStream outputStreamC = this.f18745d.c(bVar);
        try {
            int iO = o(inputStream, outputStreamC);
            outputStreamC.close();
            int i11 = this.f18743b;
            if (i11 >= 0 && iO > i11) {
                throw vb.l1.f17414n.q(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iO), Integer.valueOf(this.f18743b))).d();
            }
            k(bVar, true);
            return iO;
        } catch (Throwable th) {
            outputStreamC.close();
            throw th;
        }
    }

    public final int m(InputStream inputStream, int i10) {
        int i11 = this.f18743b;
        if (i11 >= 0 && i10 > i11) {
            throw vb.l1.f17414n.q(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(i10), Integer.valueOf(this.f18743b))).d();
        }
        this.f18748g.clear();
        this.f18748g.put((byte) 0).putInt(i10);
        if (this.f18744c == null) {
            this.f18744c = this.f18749h.a(this.f18748g.position() + i10);
        }
        n(this.f18748g.array(), 0, this.f18748g.position());
        return o(inputStream, this.f18747f);
    }

    public final void n(byte[] bArr, int i10, int i11) {
        while (i11 > 0) {
            v2 v2Var = this.f18744c;
            if (v2Var != null && v2Var.b() == 0) {
                e(false, false);
            }
            if (this.f18744c == null) {
                this.f18744c = this.f18749h.a(i11);
            }
            int iMin = Math.min(i11, this.f18744c.b());
            this.f18744c.write(bArr, i10, iMin);
            i10 += iMin;
            i11 -= iMin;
        }
    }

    public final int p(InputStream inputStream, int i10) throws IOException {
        if (i10 != -1) {
            this.f18754m = i10;
            return m(inputStream, i10);
        }
        b bVar = new b();
        int iO = o(inputStream, bVar);
        k(bVar, false);
        return iO;
    }
}
