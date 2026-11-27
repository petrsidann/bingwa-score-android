package jd;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f11363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ xc.p f11364b;

        public a(d dVar, xc.p pVar) {
            this.f11363a = dVar;
            this.f11364b = pVar;
        }

        @Override // jd.d
        public Object a(e<? super T> eVar, oc.e<? super lc.q> eVar2) {
            Object objA = this.f11363a.a(new b(new kotlin.jvm.internal.s(), eVar, this.f11364b), eVar2);
            return objA == pc.c.c() ? objA : lc.q.f12711a;
        }
    }

    public static final class b<T> implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.s f11365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e<T> f11366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ xc.p<T, oc.e<? super Boolean>, Object> f11367c;

        @qc.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1", f = "Limit.kt", l = {37, 38, 40}, m = "emit")
        public static final class a extends qc.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f11368a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f11369b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public /* synthetic */ Object f11370c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ b<T> f11371d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f11372e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(b<? super T> bVar, oc.e<? super a> eVar) {
                super(eVar);
                this.f11371d = bVar;
            }

            @Override // qc.a
            public final Object invokeSuspend(Object obj) {
                this.f11370c = obj;
                this.f11372e |= Integer.MIN_VALUE;
                return this.f11371d.b(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(kotlin.jvm.internal.s sVar, e<? super T> eVar, xc.p<? super T, ? super oc.e<? super Boolean>, ? extends Object> pVar) {
            this.f11365a = sVar;
            this.f11366b = eVar;
            this.f11367c = pVar;
        }

        /* JADX WARN: Code duplicated, block: B:31:0x0074  */
        /* JADX WARN: Code duplicated, block: B:33:0x0087 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:36:0x008b  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // jd.e
        public final Object b(T t10, oc.e<? super lc.q> eVar) throws Throwable {
            a aVar;
            b<T> bVar;
            e<T> eVar2;
            if (eVar instanceof a) {
                aVar = (a) eVar;
                int i10 = aVar.f11372e;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    aVar.f11372e = i10 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, eVar);
                }
            } else {
                aVar = new a(this, eVar);
            }
            Object objInvoke = aVar.f11370c;
            Object objC = pc.c.c();
            int i11 = aVar.f11372e;
            if (i11 == 0) {
                lc.k.b(objInvoke);
                if (this.f11365a.f12380a) {
                    e<T> eVar3 = this.f11366b;
                    aVar.f11372e = 1;
                    if (eVar3.b(t10, aVar) == objC) {
                        return objC;
                    }
                    return lc.q.f12711a;
                }
                xc.p<T, oc.e<? super Boolean>, Object> pVar = this.f11367c;
                aVar.f11368a = this;
                aVar.f11369b = t10;
                aVar.f11372e = 2;
                objInvoke = pVar.invoke(t10, aVar);
                if (objInvoke == objC) {
                    return objC;
                }
                bVar = this;
                if (!((Boolean) objInvoke).booleanValue()) {
                    return lc.q.f12711a;
                }
                bVar.f11365a.f12380a = true;
                eVar2 = bVar.f11366b;
                aVar.f11368a = null;
                aVar.f11369b = null;
                aVar.f11372e = 3;
                if (eVar2.b(t10, aVar) == objC) {
                    return objC;
                }
            } else {
                if (i11 == 1) {
                    lc.k.b(objInvoke);
                    return lc.q.f12711a;
                }
                if (i11 == 2) {
                    t10 = (T) aVar.f11369b;
                    bVar = (b) aVar.f11368a;
                    lc.k.b(objInvoke);
                    if (!((Boolean) objInvoke).booleanValue()) {
                        return lc.q.f12711a;
                    }
                    bVar.f11365a.f12380a = true;
                    eVar2 = bVar.f11366b;
                    aVar.f11368a = null;
                    aVar.f11369b = null;
                    aVar.f11372e = 3;
                    if (eVar2.b(t10, aVar) == objC) {
                        return objC;
                    }
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lc.k.b(objInvoke);
                }
            }
            return lc.q.f12711a;
        }
    }

    public static final <T> d<T> a(d<? extends T> dVar, xc.p<? super T, ? super oc.e<? super Boolean>, ? extends Object> pVar) {
        return new a(dVar, pVar);
    }
}
