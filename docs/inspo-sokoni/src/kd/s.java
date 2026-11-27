package kd;

import ld.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class s<T> implements jd.e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oc.i f12356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xc.p<T, oc.e<? super lc.q>, Object> f12358c;

    @qc.f(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", l = {212}, m = "invokeSuspend")
    public static final class a extends qc.l implements xc.p<T, oc.e<? super lc.q>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f12360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ jd.e<T> f12361c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(jd.e<? super T> eVar, oc.e<? super a> eVar2) {
            super(2, eVar2);
            this.f12361c = eVar;
        }

        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(T t10, oc.e<? super lc.q> eVar) {
            return ((a) create(t10, eVar)).invokeSuspend(lc.q.f12711a);
        }

        @Override // qc.a
        public final oc.e<lc.q> create(Object obj, oc.e<?> eVar) {
            a aVar = new a(this.f12361c, eVar);
            aVar.f12360b = obj;
            return aVar;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type oc.e to kd.s$a for r3v1 'this'  oc.e
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // qc.a
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r0 = pc.c.c()
                int r1 = r3.f12359a
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                lc.k.b(r4)
                goto L27
            Lf:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            L17:
                lc.k.b(r4)
                java.lang.Object r4 = r3.f12360b
                jd.e<T> r1 = r3.f12361c
                r3.f12359a = r2
                java.lang.Object r4 = r1.b(r4, r3)
                if (r4 != r0) goto L27
                return r0
            L27:
                lc.q r4 = lc.q.f12711a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kd.s.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public s(jd.e<? super T> eVar, oc.i iVar) {
        this.f12356a = iVar;
        this.f12357b = l0.b(iVar);
        this.f12358c = new a(eVar, null);
    }

    @Override // jd.e
    public Object b(T t10, oc.e<? super lc.q> eVar) {
        Object objB = f.b(this.f12356a, t10, this.f12357b, this.f12358c, eVar);
        return objB == pc.c.c() ? objB : lc.q.f12711a;
    }
}
