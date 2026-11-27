package jd;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> implements d<T> {

    /* JADX INFO: renamed from: jd.a$a, reason: collision with other inner class name */
    @qc.f(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {230}, m = "collect")
    public static final class C0191a extends qc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f11347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f11348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a<T> f11349c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11350d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0191a(a<T> aVar, oc.e<? super C0191a> eVar) {
            super(eVar);
            this.f11349c = aVar;
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f11348b = obj;
            this.f11350d |= Integer.MIN_VALUE;
            return this.f11349c.a(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // jd.d
    public final Object a(e<? super T> eVar, oc.e<? super lc.q> eVar2) throws Throwable {
        C0191a c0191a;
        Throwable th;
        kd.n nVar;
        if (eVar2 instanceof C0191a) {
            c0191a = (C0191a) eVar2;
            int i10 = c0191a.f11350d;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0191a.f11350d = i10 - Integer.MIN_VALUE;
            } else {
                c0191a = new C0191a(this, eVar2);
            }
        } else {
            c0191a = new C0191a(this, eVar2);
        }
        Object obj = c0191a.f11348b;
        Object objC = pc.c.c();
        int i11 = c0191a.f11350d;
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            nVar = (kd.n) c0191a.f11347a;
            try {
                lc.k.b(obj);
                nVar.releaseIntercepted();
                return lc.q.f12711a;
            } catch (Throwable th2) {
                th = th2;
                nVar.releaseIntercepted();
                throw th;
            }
        }
        lc.k.b(obj);
        kd.n nVar2 = new kd.n(eVar, c0191a.getContext());
        try {
            c0191a.f11347a = nVar2;
            c0191a.f11350d = 1;
            if (b(nVar2, c0191a) == objC) {
                return objC;
            }
            nVar = nVar2;
            nVar.releaseIntercepted();
            return lc.q.f12711a;
        } catch (Throwable th3) {
            th = th3;
            nVar = nVar2;
            nVar.releaseIntercepted();
            throw th;
        }
    }

    public abstract Object b(e<? super T> eVar, oc.e<? super lc.q> eVar2);
}
