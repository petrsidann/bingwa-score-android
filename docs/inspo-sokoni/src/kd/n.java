package kd;

import gd.c2;

/* JADX INFO: loaded from: classes2.dex */
public final class n<T> extends qc.d implements jd.e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jd.e<T> f12344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final oc.i f12345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public oc.i f12347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public oc.e<? super lc.q> f12348e;

    public static final class a extends kotlin.jvm.internal.l implements xc.p<Integer, oc.i.b, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12349a = new a();

        public a() {
            super(2);
        }

        public final Integer a(int i10, oc.i.b bVar) {
            return Integer.valueOf(i10 + 1);
        }

        @Override // xc.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, oc.i.b bVar) {
            return a(num.intValue(), bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(jd.e<? super T> eVar, oc.i iVar) {
        super(l.f12339a, oc.j.f13812a);
        this.f12344a = eVar;
        this.f12345b = iVar;
        this.f12346c = ((Number) iVar.fold(0, a.f12349a)).intValue();
    }

    public final void a(oc.i iVar, oc.i iVar2, T t10) {
        if (iVar2 instanceof i) {
            j((i) iVar2, t10);
        }
        p.a(this, iVar);
    }

    @Override // jd.e
    public Object b(T t10, oc.e<? super lc.q> eVar) {
        try {
            Object objD = d(eVar, t10);
            if (objD == pc.c.c()) {
                qc.h.c(eVar);
            }
            return objD == pc.c.c() ? objD : lc.q.f12711a;
        } catch (Throwable th) {
            this.f12347d = new i(th, eVar.getContext());
            throw th;
        }
    }

    public final Object d(oc.e<? super lc.q> eVar, T t10) {
        oc.i context = eVar.getContext();
        c2.i(context);
        oc.i iVar = this.f12347d;
        if (iVar != context) {
            a(context, iVar, t10);
            this.f12347d = context;
        }
        this.f12348e = eVar;
        xc.q qVar = o.f12350a;
        jd.e<T> eVar2 = this.f12344a;
        kotlin.jvm.internal.k.c(eVar2, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        kotlin.jvm.internal.k.c(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objE = qVar.e(eVar2, t10, this);
        if (!kotlin.jvm.internal.k.a(objE, pc.c.c())) {
            this.f12348e = null;
        }
        return objE;
    }

    @Override // qc.a, qc.e
    public qc.e getCallerFrame() {
        oc.e<? super lc.q> eVar = this.f12348e;
        if (eVar instanceof qc.e) {
            return (qc.e) eVar;
        }
        return null;
    }

    @Override // qc.d, oc.e
    public oc.i getContext() {
        oc.i iVar = this.f12347d;
        return iVar == null ? oc.j.f13812a : iVar;
    }

    @Override // qc.a
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // qc.a
    public Object invokeSuspend(Object obj) {
        Throwable thD = lc.j.d(obj);
        if (thD != null) {
            this.f12347d = new i(thD, getContext());
        }
        oc.e<? super lc.q> eVar = this.f12348e;
        if (eVar != null) {
            eVar.resumeWith(obj);
        }
        return pc.c.c();
    }

    public final void j(i iVar, Object obj) {
        throw new IllegalStateException(ed.j.i("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + iVar.f12337a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // qc.d, qc.a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
