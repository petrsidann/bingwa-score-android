package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 {

    public static final class a extends kotlin.jvm.internal.l implements xc.p<oc.i, oc.i.b, oc.i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9210a = new a();

        public a() {
            super(2);
        }

        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final oc.i invoke(oc.i iVar, oc.i.b bVar) {
            return bVar instanceof h0 ? iVar.plus(((h0) bVar).C()) : iVar.plus(bVar);
        }
    }

    public static final class b extends kotlin.jvm.internal.l implements xc.p<oc.i, oc.i.b, oc.i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.t<oc.i> f9211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f9212b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kotlin.jvm.internal.t<oc.i> tVar, boolean z10) {
            super(2);
            this.f9211a = tVar;
            this.f9212b = z10;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [T, oc.i] */
        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final oc.i invoke(oc.i iVar, oc.i.b bVar) {
            if (!(bVar instanceof h0)) {
                return iVar.plus(bVar);
            }
            oc.i.b bVar2 = this.f9211a.f12381a.get(bVar.getKey());
            if (bVar2 != null) {
                kotlin.jvm.internal.t<oc.i> tVar = this.f9211a;
                tVar.f12381a = tVar.f12381a.minusKey(bVar.getKey());
                return iVar.plus(((h0) bVar).Q(bVar2));
            }
            h0 h0VarC = (h0) bVar;
            if (this.f9212b) {
                h0VarC = h0VarC.C();
            }
            return iVar.plus(h0VarC);
        }
    }

    public static final class c extends kotlin.jvm.internal.l implements xc.p<Boolean, oc.i.b, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f9213a = new c();

        public c() {
            super(2);
        }

        public final Boolean a(boolean z10, oc.i.b bVar) {
            return Boolean.valueOf(z10 || (bVar instanceof h0));
        }

        @Override // xc.p
        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool, oc.i.b bVar) {
            return a(bool.booleanValue(), bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final oc.i a(oc.i iVar, oc.i iVar2, boolean z10) {
        boolean zC = c(iVar);
        boolean zC2 = c(iVar2);
        if (!zC && !zC2) {
            return iVar.plus(iVar2);
        }
        kotlin.jvm.internal.t tVar = new kotlin.jvm.internal.t();
        tVar.f12381a = iVar2;
        oc.j jVar = oc.j.f13812a;
        oc.i iVar3 = (oc.i) iVar.fold(jVar, new b(tVar, z10));
        if (zC2) {
            tVar.f12381a = ((oc.i) tVar.f12381a).fold(jVar, a.f9210a);
        }
        return iVar3.plus((oc.i) tVar.f12381a);
    }

    public static final String b(oc.i iVar) {
        return null;
    }

    public static final boolean c(oc.i iVar) {
        return ((Boolean) iVar.fold(Boolean.FALSE, c.f9213a)).booleanValue();
    }

    public static final oc.i d(m0 m0Var, oc.i iVar) {
        oc.i iVarA = a(m0Var.f(), iVar, true);
        return (iVarA == c1.a() || iVarA.get(oc.f.f13810k) != null) ? iVarA : iVarA.plus(c1.a());
    }

    public static final oc.i e(oc.i iVar, oc.i iVar2) {
        return !c(iVar2) ? iVar.plus(iVar2) : a(iVar, iVar2, false);
    }

    public static final b3<?> f(qc.e eVar) {
        while (!(eVar instanceof y0) && (eVar = eVar.getCallerFrame()) != null) {
            if (eVar instanceof b3) {
                return (b3) eVar;
            }
        }
        return null;
    }

    public static final b3<?> g(oc.e<?> eVar, oc.i iVar, Object obj) {
        if (!(eVar instanceof qc.e)) {
            return null;
        }
        if (!(iVar.get(c3.f9148a) != null)) {
            return null;
        }
        b3<?> b3VarF = f((qc.e) eVar);
        if (b3VarF != null) {
            b3VarF.R0(iVar, obj);
        }
        return b3VarF;
    }
}
