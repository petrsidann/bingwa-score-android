package id;

import gd.i0;
import gd.m0;
import gd.o0;
import gd.y1;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    @qc.f(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", l = {153}, m = "awaitClose")
    public static final class a extends qc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f10633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f10634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f10635c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f10636d;

        public a(oc.e<? super a> eVar) {
            super(eVar);
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f10635c = obj;
            this.f10636d |= Integer.MIN_VALUE;
            return p.a(null, null, this);
        }
    }

    public static final class b extends kotlin.jvm.internal.l implements xc.l<Throwable, lc.q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gd.o<lc.q> f10637a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(gd.o<? super lc.q> oVar) {
            super(1);
            this.f10637a = oVar;
        }

        public final void a(Throwable th) {
            gd.o<lc.q> oVar = this.f10637a;
            lc.j.a aVar = lc.j.f12703b;
            oVar.resumeWith(lc.j.b(lc.q.f12711a));
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
            a(th);
            return lc.q.f12711a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(r<?> rVar, xc.a<lc.q> aVar, oc.e<? super lc.q> eVar) throws Throwable {
        a aVar2;
        if (eVar instanceof a) {
            aVar2 = (a) eVar;
            int i10 = aVar2.f10636d;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar2.f10636d = i10 - Integer.MIN_VALUE;
            } else {
                aVar2 = new a(eVar);
            }
        } else {
            aVar2 = new a(eVar);
        }
        Object obj = aVar2.f10635c;
        Object objC = pc.c.c();
        int i11 = aVar2.f10636d;
        try {
            if (i11 == 0) {
                lc.k.b(obj);
                if (!(aVar2.getContext().get(y1.f9273i) == rVar)) {
                    throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
                }
                aVar2.f10633a = rVar;
                aVar2.f10634b = aVar;
                aVar2.f10636d = 1;
                gd.p pVar = new gd.p(pc.b.b(aVar2), 1);
                pVar.B();
                rVar.j(new b(pVar));
                Object objY = pVar.y();
                if (objY == pc.c.c()) {
                    qc.h.c(aVar2);
                }
                if (objY == objC) {
                    return objC;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aVar = (xc.a) aVar2.f10634b;
                lc.k.b(obj);
            }
            aVar.invoke();
            return lc.q.f12711a;
        } catch (Throwable th) {
            aVar.invoke();
            throw th;
        }
    }

    public static final <E> t<E> b(m0 m0Var, oc.i iVar, int i10, id.a aVar, o0 o0Var, xc.l<? super Throwable, lc.q> lVar, xc.p<? super r<? super E>, ? super oc.e<? super lc.q>, ? extends Object> pVar) {
        q qVar = new q(i0.d(m0Var, iVar), g.b(i10, aVar, null, 4, null));
        if (lVar != null) {
            qVar.invokeOnCompletion(lVar);
        }
        qVar.P0(o0Var, qVar, pVar);
        return qVar;
    }

    public static /* synthetic */ t c(m0 m0Var, oc.i iVar, int i10, id.a aVar, o0 o0Var, xc.l lVar, xc.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            iVar = oc.j.f13812a;
        }
        oc.i iVar2 = iVar;
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            aVar = id.a.SUSPEND;
        }
        id.a aVar2 = aVar;
        if ((i11 & 8) != 0) {
            o0Var = o0.DEFAULT;
        }
        o0 o0Var2 = o0Var;
        if ((i11 & 16) != 0) {
            lVar = null;
        }
        return b(m0Var, iVar2, i12, aVar2, o0Var2, lVar, pVar);
    }
}
