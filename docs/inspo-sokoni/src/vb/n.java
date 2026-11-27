package vb;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends vb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb.b f17453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vb.b f17454b;

    public static final class a extends vb.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.b.a f17455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a1 f17456b;

        public a(vb.b.a aVar, a1 a1Var) {
            this.f17455a = aVar;
            this.f17456b = a1Var;
        }

        @Override // vb.b.a
        public void a(a1 a1Var) {
            j6.m.p(a1Var, "headers");
            a1 a1Var2 = new a1();
            a1Var2.m(this.f17456b);
            a1Var2.m(a1Var);
            this.f17455a.a(a1Var2);
        }

        @Override // vb.b.a
        public void b(l1 l1Var) {
            this.f17455a.b(l1Var);
        }
    }

    public final class b extends vb.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.b.AbstractC0303b f17457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f17458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final vb.b.a f17459c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final s f17460d;

        public b(vb.b.AbstractC0303b abstractC0303b, Executor executor, vb.b.a aVar, s sVar) {
            this.f17457a = abstractC0303b;
            this.f17458b = executor;
            this.f17459c = (vb.b.a) j6.m.p(aVar, "delegate");
            this.f17460d = (s) j6.m.p(sVar, "context");
        }

        @Override // vb.b.a
        public void a(a1 a1Var) {
            j6.m.p(a1Var, "headers");
            s sVarB = this.f17460d.b();
            try {
                n.this.f17454b.a(this.f17457a, this.f17458b, new a(this.f17459c, a1Var));
            } finally {
                this.f17460d.f(sVarB);
            }
        }

        @Override // vb.b.a
        public void b(l1 l1Var) {
            this.f17459c.b(l1Var);
        }
    }

    public n(vb.b bVar, vb.b bVar2) {
        this.f17453a = (vb.b) j6.m.p(bVar, "creds1");
        this.f17454b = (vb.b) j6.m.p(bVar2, "creds2");
    }

    @Override // vb.b
    public void a(vb.b.AbstractC0303b abstractC0303b, Executor executor, vb.b.a aVar) {
        this.f17453a.a(abstractC0303b, executor, new b(abstractC0303b, executor, aVar, s.e()));
    }
}
