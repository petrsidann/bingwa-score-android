package m2;

import android.app.Activity;
import gd.c1;
import id.r;
import lc.q;
import xc.p;

/* JADX INFO: loaded from: classes.dex */
public final class i implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f12936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n2.a f12937c;

    @qc.f(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$2", f = "WindowInfoTrackerImpl.kt", l = {63}, m = "invokeSuspend")
    public static final class a extends qc.l implements p<r<? super j>, oc.e<? super q>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f12939b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Activity f12941d;

        /* JADX INFO: renamed from: m2.i$a$a, reason: collision with other inner class name */
        public static final class C0215a extends kotlin.jvm.internal.l implements xc.a<q> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f12942a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ o0.a<j> f12943b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0215a(i iVar, o0.a<j> aVar) {
                super(0);
                this.f12942a = iVar;
                this.f12943b = aVar;
            }

            public final void a() {
                this.f12942a.f12937c.b(this.f12943b);
            }

            @Override // xc.a
            public /* bridge */ /* synthetic */ q invoke() {
                a();
                return q.f12711a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Activity activity, oc.e<? super a> eVar) {
            super(2, eVar);
            this.f12941d = activity;
        }

        public static final void j(r rVar, j jVar) {
            rVar.l(jVar);
        }

        @Override // qc.a
        public final oc.e<q> create(Object obj, oc.e<?> eVar) {
            a aVar = i.this.new a(this.f12941d, eVar);
            aVar.f12939b = obj;
            return aVar;
        }

        @Override // xc.p
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public final Object invoke(r<? super j> rVar, oc.e<? super q> eVar) {
            return ((a) create(rVar, eVar)).invokeSuspend(q.f12711a);
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = pc.c.c();
            int i10 = this.f12938a;
            if (i10 == 0) {
                lc.k.b(obj);
                final r rVar = (r) this.f12939b;
                o0.a<j> aVar = new o0.a() { // from class: m2.h
                    @Override // o0.a
                    public final void accept(Object obj2) {
                        i.a.j(rVar, (j) obj2);
                    }
                };
                i.this.f12937c.a(this.f12941d, new x1.b(), aVar);
                C0215a c0215a = new C0215a(i.this, aVar);
                this.f12938a = 1;
                if (id.p.a(rVar, c0215a, this) == objC) {
                    return objC;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lc.k.b(obj);
            }
            return q.f12711a;
        }
    }

    public i(l windowMetricsCalculator, n2.a windowBackend) {
        kotlin.jvm.internal.k.e(windowMetricsCalculator, "windowMetricsCalculator");
        kotlin.jvm.internal.k.e(windowBackend, "windowBackend");
        this.f12936b = windowMetricsCalculator;
        this.f12937c = windowBackend;
    }

    @Override // m2.f
    public jd.d<j> a(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        return jd.f.h(jd.f.a(new a(activity, null)), c1.c());
    }
}
