package jd;

/* JADX INFO: loaded from: classes2.dex */
public final class b<T> extends c<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xc.p<id.r<? super T>, oc.e<? super lc.q>, Object> f11351e;

    @qc.f(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", l = {334}, m = "collectTo")
    public static final class a extends qc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f11352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f11353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b<T> f11354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11355d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b<T> bVar, oc.e<? super a> eVar) {
            super(eVar);
            this.f11354c = bVar;
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f11353b = obj;
            this.f11355d |= Integer.MIN_VALUE;
            return this.f11354c.e(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(xc.p<? super id.r<? super T>, ? super oc.e<? super lc.q>, ? extends Object> pVar, oc.i iVar, int i10, id.a aVar) {
        super(pVar, iVar, i10, aVar);
        this.f11351e = pVar;
    }

    public /* synthetic */ b(xc.p pVar, oc.i iVar, int i10, id.a aVar, int i11, kotlin.jvm.internal.g gVar) {
        this(pVar, (i11 & 2) != 0 ? oc.j.f13812a : iVar, (i11 & 4) != 0 ? -2 : i10, (i11 & 8) != 0 ? id.a.SUSPEND : aVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // jd.c, kd.e
    public Object e(id.r<? super T> rVar, oc.e<? super lc.q> eVar) throws Throwable {
        a aVar;
        if (eVar instanceof a) {
            aVar = (a) eVar;
            int i10 = aVar.f11355d;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.f11355d = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, eVar);
            }
        } else {
            aVar = new a(this, eVar);
        }
        Object obj = aVar.f11353b;
        Object objC = pc.c.c();
        int i11 = aVar.f11355d;
        if (i11 == 0) {
            lc.k.b(obj);
            aVar.f11352a = rVar;
            aVar.f11355d = 1;
            if (super.e(rVar, aVar) == objC) {
                return objC;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            rVar = (id.r) aVar.f11352a;
            lc.k.b(obj);
        }
        if (rVar.m()) {
            return lc.q.f12711a;
        }
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    }

    @Override // kd.e
    public kd.e<T> f(oc.i iVar, int i10, id.a aVar) {
        return new b(this.f11351e, iVar, i10, aVar);
    }
}
