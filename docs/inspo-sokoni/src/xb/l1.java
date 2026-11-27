package xb;

import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.zip.DataFormatException;

/* JADX INFO: loaded from: classes2.dex */
public class l1 implements Closeable, z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f18686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o2 f18688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u2 f18689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public vb.v f18690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s0 f18691f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f18692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f18693m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f18696p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public v f18697q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f18699s;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f18702v;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e f18694n = e.HEADER;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f18695o = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public v f18698r = new v();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f18700t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f18701u = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f18703w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f18704x = false;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18705a;

        static {
            int[] iArr = new int[e.values().length];
            f18705a = iArr;
            try {
                iArr[e.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18705a[e.BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public interface b {
        void a(q2.a aVar);

        void c(boolean z10);

        void d(int i10);

        void e(Throwable th);
    }

    public static class c implements q2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InputStream f18706a;

        public c(InputStream inputStream) {
            this.f18706a = inputStream;
        }

        public /* synthetic */ c(InputStream inputStream, a aVar) {
            this(inputStream);
        }

        @Override // xb.q2.a
        public InputStream next() {
            InputStream inputStream = this.f18706a;
            this.f18706a = null;
            return inputStream;
        }
    }

    public static final class d extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o2 f18708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f18709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f18710d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f18711e;

        public d(InputStream inputStream, int i10, o2 o2Var) {
            super(inputStream);
            this.f18711e = -1L;
            this.f18707a = i10;
            this.f18708b = o2Var;
        }

        public final void d() {
            long j10 = this.f18710d;
            long j11 = this.f18709c;
            if (j10 > j11) {
                this.f18708b.f(j10 - j11);
                this.f18709c = this.f18710d;
            }
        }

        public final void e() {
            if (this.f18710d <= this.f18707a) {
                return;
            }
            throw vb.l1.f17414n.q("Decompressed gRPC message exceeds maximum size " + this.f18707a).d();
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i10) {
            ((FilterInputStream) this).in.mark(i10);
            this.f18711e = this.f18710d;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i10 = ((FilterInputStream) this).in.read();
            if (i10 != -1) {
                this.f18710d++;
            }
            e();
            d();
            return i10;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            int i12 = ((FilterInputStream) this).in.read(bArr, i10, i11);
            if (i12 != -1) {
                this.f18710d += (long) i12;
            }
            e();
            d();
            return i12;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f18711e == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f18710d = this.f18711e;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j10) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(j10);
            this.f18710d += jSkip;
            e();
            d();
            return jSkip;
        }
    }

    public enum e {
        HEADER,
        BODY
    }

    public l1(b bVar, vb.v vVar, int i10, o2 o2Var, u2 u2Var) {
        this.f18686a = (b) j6.m.p(bVar, "sink");
        this.f18690e = (vb.v) j6.m.p(vVar, "decompressor");
        this.f18687b = i10;
        this.f18688c = (o2) j6.m.p(o2Var, "statsTraceCtx");
        this.f18689d = (u2) j6.m.p(u2Var, "transportTracer");
    }

    public final InputStream B() {
        vb.v vVar = this.f18690e;
        if (vVar == vb.m.b.f17449a) {
            throw vb.l1.f17419s.q("Can't decode compressed gRPC message as compression not configured").d();
        }
        try {
            return new d(vVar.b(z1.c(this.f18697q, true)), this.f18687b, this.f18688c);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final InputStream C() {
        this.f18688c.f(this.f18697q.a());
        return z1.c(this.f18697q, true);
    }

    public final boolean D() {
        return isClosed() || this.f18703w;
    }

    public final boolean E() {
        s0 s0Var = this.f18691f;
        if (s0Var != null) {
            return s0Var.Q();
        }
        return this.f18698r.a() == 0;
    }

    public final void G() {
        this.f18688c.e(this.f18701u, this.f18702v, -1L);
        this.f18702v = 0;
        InputStream inputStreamB = this.f18696p ? B() : C();
        this.f18697q.K();
        this.f18697q = null;
        this.f18686a.a(new c(inputStreamB, null));
        this.f18694n = e.HEADER;
        this.f18695o = 5;
    }

    public final void I() {
        int unsignedByte = this.f18697q.readUnsignedByte();
        if ((unsignedByte & 254) != 0) {
            throw vb.l1.f17419s.q("gRPC frame header malformed: reserved bits not zero").d();
        }
        this.f18696p = (unsignedByte & 1) != 0;
        int i10 = this.f18697q.readInt();
        this.f18695o = i10;
        if (i10 < 0 || i10 > this.f18687b) {
            throw vb.l1.f17414n.q(String.format(Locale.US, "gRPC message exceeds maximum size %d: %d", Integer.valueOf(this.f18687b), Integer.valueOf(this.f18695o))).d();
        }
        int i11 = this.f18701u + 1;
        this.f18701u = i11;
        this.f18688c.d(i11);
        this.f18689d.d();
        this.f18694n = e.BODY;
    }

    public final boolean J() throws Throwable {
        int iG;
        int i10;
        int i11 = 0;
        try {
            if (this.f18697q == null) {
                this.f18697q = new v();
            }
            int iE = 0;
            iG = 0;
            while (true) {
                try {
                    int iA = this.f18695o - this.f18697q.a();
                    if (iA <= 0) {
                        if (iE <= 0) {
                            return true;
                        }
                        this.f18686a.d(iE);
                        if (this.f18694n != e.BODY) {
                            return true;
                        }
                        if (this.f18691f != null) {
                            this.f18688c.g(iG);
                            i10 = this.f18702v + iG;
                        } else {
                            this.f18688c.g(iE);
                            i10 = this.f18702v + iE;
                        }
                        this.f18702v = i10;
                        return true;
                    }
                    if (this.f18691f != null) {
                        try {
                            byte[] bArr = this.f18692l;
                            if (bArr == null || this.f18693m == bArr.length) {
                                this.f18692l = new byte[Math.min(iA, 2097152)];
                                this.f18693m = 0;
                            }
                            int iL = this.f18691f.L(this.f18692l, this.f18693m, Math.min(iA, this.f18692l.length - this.f18693m));
                            iE += this.f18691f.E();
                            iG += this.f18691f.G();
                            if (iL == 0) {
                                if (iE > 0) {
                                    this.f18686a.d(iE);
                                    if (this.f18694n == e.BODY) {
                                        if (this.f18691f != null) {
                                            this.f18688c.g(iG);
                                            this.f18702v += iG;
                                        } else {
                                            this.f18688c.g(iE);
                                            this.f18702v += iE;
                                        }
                                    }
                                }
                                return false;
                            }
                            this.f18697q.e(z1.f(this.f18692l, this.f18693m, iL));
                            this.f18693m += iL;
                        } catch (IOException e10) {
                            throw new RuntimeException(e10);
                        } catch (DataFormatException e11) {
                            throw new RuntimeException(e11);
                        }
                    } else {
                        if (this.f18698r.a() == 0) {
                            if (iE > 0) {
                                this.f18686a.d(iE);
                                if (this.f18694n == e.BODY) {
                                    if (this.f18691f != null) {
                                        this.f18688c.g(iG);
                                        this.f18702v += iG;
                                    } else {
                                        this.f18688c.g(iE);
                                        this.f18702v += iE;
                                    }
                                }
                            }
                            return false;
                        }
                        int iMin = Math.min(iA, this.f18698r.a());
                        iE += iMin;
                        this.f18697q.e(this.f18698r.l(iMin));
                    }
                } catch (Throwable th) {
                    int i12 = iE;
                    th = th;
                    i11 = i12;
                    if (i11 > 0) {
                        this.f18686a.d(i11);
                        if (this.f18694n == e.BODY) {
                            if (this.f18691f != null) {
                                this.f18688c.g(iG);
                                this.f18702v += iG;
                            } else {
                                this.f18688c.g(i11);
                                this.f18702v += i11;
                            }
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            iG = 0;
        }
    }

    public void L(s0 s0Var) {
        j6.m.v(this.f18690e == vb.m.b.f17449a, "per-message decompressor already set");
        j6.m.v(this.f18691f == null, "full stream decompressor already set");
        this.f18691f = (s0) j6.m.p(s0Var, "Can't pass a null full stream decompressor");
        this.f18698r = null;
    }

    public void O(b bVar) {
        this.f18686a = bVar;
    }

    public void Q() {
        this.f18704x = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, xb.z
    public void close() {
        if (isClosed()) {
            return;
        }
        v vVar = this.f18697q;
        boolean z10 = true;
        boolean z11 = vVar != null && vVar.a() > 0;
        try {
            s0 s0Var = this.f18691f;
            if (s0Var != null) {
                if (!z11 && !s0Var.I()) {
                    z10 = false;
                }
                this.f18691f.close();
                z11 = z10;
            }
            v vVar2 = this.f18698r;
            if (vVar2 != null) {
                vVar2.close();
            }
            v vVar3 = this.f18697q;
            if (vVar3 != null) {
                vVar3.close();
            }
            this.f18691f = null;
            this.f18698r = null;
            this.f18697q = null;
            this.f18686a.c(z11);
        } catch (Throwable th) {
            this.f18691f = null;
            this.f18698r = null;
            this.f18697q = null;
            throw th;
        }
    }

    @Override // xb.z
    public void d(int i10) {
        j6.m.e(i10 > 0, "numMessages must be > 0");
        if (isClosed()) {
            return;
        }
        this.f18699s += (long) i10;
        z();
    }

    @Override // xb.z
    public void e(int i10) {
        this.f18687b = i10;
    }

    public boolean isClosed() {
        return this.f18698r == null && this.f18691f == null;
    }

    @Override // xb.z
    public void k() {
        if (isClosed()) {
            return;
        }
        if (E()) {
            close();
        } else {
            this.f18703w = true;
        }
    }

    @Override // xb.z
    public void t(y1 y1Var) {
        j6.m.p(y1Var, "data");
        boolean z10 = true;
        try {
            if (!D()) {
                s0 s0Var = this.f18691f;
                if (s0Var != null) {
                    s0Var.C(y1Var);
                } else {
                    this.f18698r.e(y1Var);
                }
                z10 = false;
                z();
            }
        } finally {
            if (z10) {
                y1Var.close();
            }
        }
    }

    @Override // xb.z
    public void v(vb.v vVar) {
        j6.m.v(this.f18691f == null, "Already set full stream decompressor");
        this.f18690e = (vb.v) j6.m.p(vVar, "Can't pass an empty decompressor");
    }

    public final void z() {
        if (this.f18700t) {
            return;
        }
        this.f18700t = true;
        while (!this.f18704x && this.f18699s > 0 && J()) {
            try {
                int i10 = a.f18705a[this.f18694n.ordinal()];
                if (i10 == 1) {
                    I();
                } else {
                    if (i10 != 2) {
                        throw new AssertionError("Invalid state: " + this.f18694n);
                    }
                    G();
                    this.f18699s--;
                }
            } catch (Throwable th) {
                this.f18700t = false;
                throw th;
            }
        }
        if (this.f18704x) {
            close();
            this.f18700t = false;
        } else {
            if (this.f18703w && E()) {
                close();
            }
            this.f18700t = false;
        }
    }
}
