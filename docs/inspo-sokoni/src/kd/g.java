package kd;

import gd.i0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g<S, T> extends e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jd.d<S> f12333d;

    @qc.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", l = {152}, m = "invokeSuspend")
    public static final class a extends qc.l implements xc.p<jd.e<? super T>, oc.e<? super lc.q>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f12335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g<S, T> f12336c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g<S, T> gVar, oc.e<? super a> eVar) {
            super(2, eVar);
            this.f12336c = gVar;
        }

        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(jd.e<? super T> eVar, oc.e<? super lc.q> eVar2) {
            return ((a) create(eVar, eVar2)).invokeSuspend(lc.q.f12711a);
        }

        @Override // qc.a
        public final oc.e<lc.q> create(Object obj, oc.e<?> eVar) {
            a aVar = new a(this.f12336c, eVar);
            aVar.f12335b = obj;
            return aVar;
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = pc.c.c();
            int i10 = this.f12334a;
            if (i10 == 0) {
                lc.k.b(obj);
                jd.e<? super T> eVar = (jd.e) this.f12335b;
                g<S, T> gVar = this.f12336c;
                this.f12334a = 1;
                if (gVar.m(eVar, this) == objC) {
                    return objC;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lc.k.b(obj);
            }
            return lc.q.f12711a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(jd.d<? extends S> dVar, oc.i iVar, int i10, id.a aVar) {
        super(iVar, i10, aVar);
        this.f12333d = dVar;
    }

    public static /* synthetic */ <S, T> Object j(g<S, T> gVar, jd.e<? super T> eVar, oc.e<? super lc.q> eVar2) {
        if (gVar.f12324b == -3) {
            oc.i context = eVar2.getContext();
            oc.i iVarE = i0.e(context, gVar.f12323a);
            if (kotlin.jvm.internal.k.a(iVarE, context)) {
                Object objM = gVar.m(eVar, eVar2);
                return objM == pc.c.c() ? objM : lc.q.f12711a;
            }
            oc.f.b bVar = oc.f.f13810k;
            if (kotlin.jvm.internal.k.a(iVarE.get(bVar), context.get(bVar))) {
                Object objL = gVar.l(eVar, iVarE, eVar2);
                return objL == pc.c.c() ? objL : lc.q.f12711a;
            }
        }
        Object objA = super.a(eVar, eVar2);
        return objA == pc.c.c() ? objA : lc.q.f12711a;
    }

    public static /* synthetic */ <S, T> Object k(g<S, T> gVar, id.r<? super T> rVar, oc.e<? super lc.q> eVar) {
        Object objM = gVar.m(new q(rVar), eVar);
        return objM == pc.c.c() ? objM : lc.q.f12711a;
    }

    @Override // kd.e, jd.d
    public Object a(jd.e<? super T> eVar, oc.e<? super lc.q> eVar2) {
        return j(this, eVar, eVar2);
    }

    @Override // kd.e
    public Object e(id.r<? super T> rVar, oc.e<? super lc.q> eVar) {
        return k(this, rVar, eVar);
    }

    public final Object l(jd.e<? super T> eVar, oc.i iVar, oc.e<? super lc.q> eVar2) {
        Object objC = f.c(iVar, f.d(eVar, eVar2.getContext()), null, new a(this, null), eVar2, 4, null);
        return objC == pc.c.c() ? objC : lc.q.f12711a;
    }

    public abstract Object m(jd.e<? super T> eVar, oc.e<? super lc.q> eVar2);

    @Override // kd.e
    public String toString() {
        return this.f12333d + " -> " + super.toString();
    }
}
