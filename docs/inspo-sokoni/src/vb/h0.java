package vb;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vb.a.c<h0> f17379a = vb.a.c.a("internal:io.grpc.config-selector");

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l1 f17380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f17381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h f17382c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f17383a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public h f17384b;

            public a() {
            }

            public b a() {
                j6.m.v(this.f17383a != null, "config is not set");
                return new b(l1.f17405e, this.f17383a, this.f17384b);
            }

            public a b(Object obj) {
                this.f17383a = j6.m.p(obj, "config");
                return this;
            }
        }

        public b(l1 l1Var, Object obj, h hVar) {
            this.f17380a = (l1) j6.m.p(l1Var, "status");
            this.f17381b = obj;
            this.f17382c = hVar;
        }

        public static a d() {
            return new a();
        }

        public Object a() {
            return this.f17381b;
        }

        public h b() {
            return this.f17382c;
        }

        public l1 c() {
            return this.f17380a;
        }
    }

    public abstract b a(t0.g gVar);
}
