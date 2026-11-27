package a1;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;
import lc.q;
import xc.p;

/* JADX INFO: loaded from: classes.dex */
public final class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f202a = new a(null);

    public static final class a {

        /* JADX INFO: renamed from: a1.e$a$a, reason: collision with other inner class name */
        @qc.f(c = "androidx.datastore.core.DataMigrationInitializer$Companion$getInitializer$1", f = "DataMigrationInitializer.kt", l = {33}, m = "invokeSuspend")
        public static final class C0001a extends qc.l implements p<i<T>, oc.e<? super q>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f203a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f204b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ List<d<T>> f205c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0001a(List<? extends d<T>> list, oc.e<? super C0001a> eVar) {
                super(2, eVar);
                this.f205c = list;
            }

            @Override // xc.p
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(i<T> iVar, oc.e<? super q> eVar) {
                return ((C0001a) create(iVar, eVar)).invokeSuspend(q.f12711a);
            }

            @Override // qc.a
            public final oc.e<q> create(Object obj, oc.e<?> eVar) {
                C0001a c0001a = new C0001a(this.f205c, eVar);
                c0001a.f204b = obj;
                return c0001a;
            }

            @Override // qc.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objC = pc.c.c();
                int i10 = this.f203a;
                if (i10 == 0) {
                    lc.k.b(obj);
                    i iVar = (i) this.f204b;
                    a aVar = e.f202a;
                    List<d<T>> list = this.f205c;
                    this.f203a = 1;
                    if (aVar.c(list, iVar, this) == objC) {
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

        @qc.f(c = "androidx.datastore.core.DataMigrationInitializer$Companion", f = "DataMigrationInitializer.kt", l = {42, 57}, m = "runMigrations")
        public static final class b<T> extends qc.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f206a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f207b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public /* synthetic */ Object f208c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f210e;

            public b(oc.e<? super b> eVar) {
                super(eVar);
            }

            @Override // qc.a
            public final Object invokeSuspend(Object obj) {
                this.f208c = obj;
                this.f210e |= Integer.MIN_VALUE;
                return a.this.c(null, null, this);
            }
        }

        @qc.f(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", l = {44, 46}, m = "invokeSuspend")
        public static final class c extends qc.l implements p<T, oc.e<? super T>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f211a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f212b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object f213c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f214d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public /* synthetic */ Object f215e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ List<d<T>> f216f;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ List<xc.l<oc.e<? super q>, Object>> f217l;

            /* JADX INFO: renamed from: a1.e$a$c$a, reason: collision with other inner class name */
            @qc.f(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1", f = "DataMigrationInitializer.kt", l = {45}, m = "invokeSuspend")
            public static final class C0002a extends qc.l implements xc.l<oc.e<? super q>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f218a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ d<T> f219b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0002a(d<T> dVar, oc.e<? super C0002a> eVar) {
                    super(1, eVar);
                    this.f219b = dVar;
                }

                @Override // xc.l
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(oc.e<? super q> eVar) {
                    return ((C0002a) create(eVar)).invokeSuspend(q.f12711a);
                }

                @Override // qc.a
                public final oc.e<q> create(oc.e<?> eVar) {
                    return new C0002a(this.f219b, eVar);
                }

                @Override // qc.a
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objC = pc.c.c();
                    int i10 = this.f218a;
                    if (i10 == 0) {
                        lc.k.b(obj);
                        d<T> dVar = this.f219b;
                        this.f218a = 1;
                        if (dVar.c(this) == objC) {
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public c(List<? extends d<T>> list, List<xc.l<oc.e<? super q>, Object>> list2, oc.e<? super c> eVar) {
                super(2, eVar);
                this.f216f = list;
                this.f217l = list2;
            }

            @Override // xc.p
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(T t10, oc.e<? super T> eVar) {
                return ((c) create(t10, eVar)).invokeSuspend(q.f12711a);
            }

            @Override // qc.a
            public final oc.e<q> create(Object obj, oc.e<?> eVar) {
                c cVar = new c(this.f216f, this.f217l, eVar);
                cVar.f215e = obj;
                return cVar;
            }

            /* JADX WARN: Code duplicated, block: B:13:0x0050  */
            /* JADX WARN: Code duplicated, block: B:15:0x0066 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:16:0x0067  */
            /* JADX WARN: Code duplicated, block: B:19:0x0074  */
            /* JADX WARN: Code duplicated, block: B:21:0x008d A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:23:0x0090  */
            /* JADX WARN: Code duplicated, block: B:24:0x0091  */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // qc.a
            public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                /*
                    r10 = this;
                    java.lang.Object r0 = pc.c.c()
                    int r1 = r10.f214d
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L3a
                    if (r1 == r3) goto L24
                    if (r1 != r2) goto L1c
                    java.lang.Object r1 = r10.f211a
                    java.util.Iterator r1 = (java.util.Iterator) r1
                    java.lang.Object r4 = r10.f215e
                    java.util.List r4 = (java.util.List) r4
                    lc.k.b(r11)
                    r7 = r10
                    goto L8e
                L1c:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r0)
                    throw r11
                L24:
                    java.lang.Object r1 = r10.f213c
                    java.lang.Object r4 = r10.f212b
                    a1.d r4 = (a1.d) r4
                    java.lang.Object r5 = r10.f211a
                    java.util.Iterator r5 = (java.util.Iterator) r5
                    java.lang.Object r6 = r10.f215e
                    java.util.List r6 = (java.util.List) r6
                    lc.k.b(r11)
                    r7 = r10
                    r9 = r6
                    r6 = r4
                    r4 = r9
                    goto L6c
                L3a:
                    lc.k.b(r11)
                    java.lang.Object r11 = r10.f215e
                    java.util.List<a1.d<T>> r1 = r10.f216f
                    java.lang.Iterable r1 = (java.lang.Iterable) r1
                    java.util.List<xc.l<oc.e<? super lc.q>, java.lang.Object>> r4 = r10.f217l
                    java.util.Iterator r1 = r1.iterator()
                    r5 = r10
                L4a:
                    boolean r6 = r1.hasNext()
                    if (r6 == 0) goto L93
                    java.lang.Object r6 = r1.next()
                    a1.d r6 = (a1.d) r6
                    r5.f215e = r4
                    r5.f211a = r1
                    r5.f212b = r6
                    r5.f213c = r11
                    r5.f214d = r3
                    java.lang.Object r7 = r6.a(r11, r5)
                    if (r7 != r0) goto L67
                    return r0
                L67:
                    r9 = r1
                    r1 = r11
                    r11 = r7
                    r7 = r5
                    r5 = r9
                L6c:
                    java.lang.Boolean r11 = (java.lang.Boolean) r11
                    boolean r11 = r11.booleanValue()
                    if (r11 == 0) goto L90
                    a1.e$a$c$a r11 = new a1.e$a$c$a
                    r8 = 0
                    r11.<init>(r6, r8)
                    r4.add(r11)
                    r7.f215e = r4
                    r7.f211a = r5
                    r7.f212b = r8
                    r7.f213c = r8
                    r7.f214d = r2
                    java.lang.Object r11 = r6.b(r1, r7)
                    if (r11 != r0) goto L91
                    return r0
                L8e:
                    r5 = r7
                    goto L4a
                L90:
                    r11 = r1
                L91:
                    r1 = r5
                    goto L8e
                L93:
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: a1.e.a.c.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final <T> p<i<T>, oc.e<? super q>, Object> b(List<? extends d<T>> migrations) {
            kotlin.jvm.internal.k.e(migrations, "migrations");
            return new C0001a(migrations, null);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0071  */
        /* JADX WARN: Code duplicated, block: B:37:0x009c  */
        /* JADX WARN: Code duplicated, block: B:39:0x009f  */
        /* JADX WARN: Code duplicated, block: B:43:0x0083 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:45:? A[LOOP:0: B:25:0x006b->B:45:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r9v3, types: [T, java.lang.Throwable] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0088 -> B:25:0x006b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x008b -> B:25:0x006b). Please report as a decompilation issue!!! */
        public final <T> Object c(List<? extends d<T>> list, i<T> iVar, oc.e<? super q> eVar) throws Throwable {
            b bVar;
            List list2;
            t tVar;
            Iterator<T> it;
            Throwable th;
            xc.l lVar;
            if (eVar instanceof b) {
                bVar = (b) eVar;
                int i10 = bVar.f210e;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    bVar.f210e = i10 - Integer.MIN_VALUE;
                } else {
                    bVar = new b(eVar);
                }
            } else {
                bVar = new b(eVar);
            }
            Object obj = bVar.f208c;
            Object objC = pc.c.c();
            int i11 = bVar.f210e;
            if (i11 != 0) {
                if (i11 == 1) {
                    list2 = (List) bVar.f206a;
                    lc.k.b(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) bVar.f207b;
                    tVar = (t) bVar.f206a;
                    try {
                        lc.k.b(obj);
                    } catch (Throwable 
                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because "ssaVar" is null
                        	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:372)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:335)
                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        */
                    /*
                        this = this;
                        boolean r0 = r9 instanceof a1.e.a.b
                        if (r0 == 0) goto L13
                        r0 = r9
                        a1.e$a$b r0 = (a1.e.a.b) r0
                        int r1 = r0.f210e
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f210e = r1
                        goto L18
                    L13:
                        a1.e$a$b r0 = new a1.e$a$b
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.f208c
                        java.lang.Object r1 = pc.c.c()
                        int r2 = r0.f210e
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L46
                        if (r2 == r4) goto L3e
                        if (r2 != r3) goto L36
                        java.lang.Object r7 = r0.f207b
                        java.util.Iterator r7 = (java.util.Iterator) r7
                        java.lang.Object r8 = r0.f206a
                        kotlin.jvm.internal.t r8 = (kotlin.jvm.internal.t) r8
                        lc.k.b(r9)     // Catch: java.lang.Throwable -> L34
                        goto L6b
                    L34:
                        r9 = move-exception
                        goto L84
                    L36:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L3e:
                        java.lang.Object r7 = r0.f206a
                        java.util.List r7 = (java.util.List) r7
                        lc.k.b(r9)
                        goto L60
                    L46:
                        lc.k.b(r9)
                        java.util.ArrayList r9 = new java.util.ArrayList
                        r9.<init>()
                        a1.e$a$c r2 = new a1.e$a$c
                        r5 = 0
                        r2.<init>(r7, r9, r5)
                        r0.f206a = r9
                        r0.f210e = r4
                        java.lang.Object r7 = r8.a(r2, r0)
                        if (r7 != r1) goto L5f
                        return r1
                    L5f:
                        r7 = r9
                    L60:
                        kotlin.jvm.internal.t r8 = new kotlin.jvm.internal.t
                        r8.<init>()
                        java.lang.Iterable r7 = (java.lang.Iterable) r7
                        java.util.Iterator r7 = r7.iterator()
                    L6b:
                        boolean r9 = r7.hasNext()
                        if (r9 == 0) goto L96
                        java.lang.Object r9 = r7.next()
                        xc.l r9 = (xc.l) r9
                        r0.f206a = r8     // Catch: java.lang.Throwable -> L34
                        r0.f207b = r7     // Catch: java.lang.Throwable -> L34
                        r0.f210e = r3     // Catch: java.lang.Throwable -> L34
                        java.lang.Object r9 = r9.invoke(r0)     // Catch: java.lang.Throwable -> L34
                        if (r9 != r1) goto L6b
                        return r1
                    L84:
                        T r2 = r8.f12381a
                        if (r2 != 0) goto L8b
                        r8.f12381a = r9
                        goto L6b
                    L8b:
                        kotlin.jvm.internal.k.b(r2)
                        T r2 = r8.f12381a
                        java.lang.Throwable r2 = (java.lang.Throwable) r2
                        lc.a.a(r2, r9)
                        goto L6b
                    L96:
                        T r7 = r8.f12381a
                        java.lang.Throwable r7 = (java.lang.Throwable) r7
                        if (r7 != 0) goto L9f
                        lc.q r7 = lc.q.f12711a
                        return r7
                    L9f:
                        throw r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: a1.e.a.c(java.util.List, a1.i, oc.e):java.lang.Object");
                }
            }
        }
