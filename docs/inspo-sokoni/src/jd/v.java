package jd;

/* JADX INFO: loaded from: classes2.dex */
public final class v<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e<T> f11393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xc.p<e<? super T>, oc.e<? super lc.q>, Object> f11394b;

    @qc.f(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {419, 423}, m = "onSubscription")
    public static final class a extends qc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f11395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f11396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f11397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ v<T> f11398d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11399e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(v<T> vVar, oc.e<? super a> eVar) {
            super(eVar);
            this.f11398d = vVar;
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f11397c = obj;
            this.f11399e |= Integer.MIN_VALUE;
            return this.f11398d.a(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kd.n] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    public final Object a(oc.e<? super lc.q> eVar) throws Throwable {
        a aVar;
        kd.n nVar;
        v<T> vVar;
        if (eVar instanceof a) {
            aVar = (a) eVar;
            int i10 = aVar.f11399e;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.f11399e = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, eVar);
            }
        } else {
            aVar = new a(this, eVar);
        }
        Object obj = aVar.f11397c;
        Object objC = pc.c.c();
        ?? r10 = aVar.f11399e;
        try {
            if (r10 != 0) {
                if (r10 == 1) {
                    nVar = (kd.n) aVar.f11396b;
                    vVar = (v) aVar.f11395a;
                    lc.k.b(obj);
                } else {
                    if (r10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lc.k.b(obj);
                }
                return lc.q.f12711a;
            }
            lc.k.b(obj);
            nVar = new kd.n(this.f11393a, aVar.getContext());
            xc.p<e<? super T>, oc.e<? super lc.q>, Object> pVar = this.f11394b;
            aVar.f11395a = this;
            aVar.f11396b = nVar;
            aVar.f11399e = 1;
            if (pVar.invoke(nVar, aVar) == objC) {
                return objC;
            }
            vVar = this;
            nVar.releaseIntercepted();
            e<T> eVar2 = vVar.f11393a;
            r10 = eVar2 instanceof v;
            if (r10 == 0) {
                return lc.q.f12711a;
            }
            aVar.f11395a = null;
            aVar.f11396b = null;
            aVar.f11399e = 2;
            if (((v) eVar2).a(aVar) == objC) {
                return objC;
            }
            return lc.q.f12711a;
        } catch (Throwable th) {
            r10.releaseIntercepted();
            throw th;
        }
    }

    @Override // jd.e
    public Object b(T t10, oc.e<? super lc.q> eVar) {
        return this.f11393a.b(t10, eVar);
    }
}
