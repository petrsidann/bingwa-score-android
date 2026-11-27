package ec;

import j6.m;
import vb.r;
import vb.t0;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t0.e f7797a;

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t0.i f7798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final t0.k f7799b;

        /* JADX INFO: renamed from: ec.f$a$a, reason: collision with other inner class name */
        public class C0130a implements t0.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ t0.k f7800a;

            public C0130a(t0.k kVar) {
                this.f7800a = kVar;
            }

            @Override // vb.t0.k
            public void a(r rVar) {
                this.f7800a.a(rVar);
                a.this.f7799b.a(rVar);
            }
        }

        public a(t0.i iVar, t0.k kVar) {
            this.f7798a = (t0.i) m.p(iVar, "delegate");
            this.f7799b = (t0.k) m.p(kVar, "healthListener");
        }

        @Override // ec.d, vb.t0.i
        public vb.a c() {
            return super.c().d().d(t0.f17506d, Boolean.TRUE).a();
        }

        @Override // ec.d, vb.t0.i
        public void h(t0.k kVar) {
            this.f7798a.h(new C0130a(kVar));
        }

        @Override // ec.d
        public t0.i j() {
            return this.f7798a;
        }
    }

    public f(t0.e eVar) {
        this.f7797a = (t0.e) m.p(eVar, "helper");
    }

    @Override // ec.c, vb.t0.e
    public t0.i a(t0.b bVar) {
        t0.k kVar = (t0.k) bVar.c(t0.f17505c);
        t0.i iVarA = super.a(bVar);
        return !(kVar != null && iVarA.c().b(t0.f17506d) == null) ? iVarA : new a(iVarA, kVar);
    }

    @Override // ec.c
    public t0.e g() {
        return this.f7797a;
    }
}
