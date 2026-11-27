package vb;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c.C0304c<Long> f17392a = c.C0304c.b("io.grpc.ClientStreamTracer.NAME_RESOLUTION_DELAYED");

    public static abstract class a {
        public k a(b bVar, a1 a1Var) {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f17393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f17395c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public c f17396a = c.f17279k;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f17397b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f17398c;

            public b a() {
                return new b(this.f17396a, this.f17397b, this.f17398c);
            }

            public a b(c cVar) {
                this.f17396a = (c) j6.m.p(cVar, "callOptions cannot be null");
                return this;
            }

            public a c(boolean z10) {
                this.f17398c = z10;
                return this;
            }

            public a d(int i10) {
                this.f17397b = i10;
                return this;
            }
        }

        public b(c cVar, int i10, boolean z10) {
            this.f17393a = (c) j6.m.p(cVar, "callOptions");
            this.f17394b = i10;
            this.f17395c = z10;
        }

        public static a a() {
            return new a();
        }

        public String toString() {
            return j6.g.b(this).d("callOptions", this.f17393a).b("previousAttempts", this.f17394b).e("isTransparentRetry", this.f17395c).toString();
        }
    }

    public void j() {
    }

    public void k() {
    }

    public void l(a1 a1Var) {
    }

    public void m() {
    }

    public void n(vb.a aVar, a1 a1Var) {
    }
}
