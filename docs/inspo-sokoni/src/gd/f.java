package gd;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    @qc.f(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", l = {54}, m = "joinAll")
    public static final class a extends qc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f9163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9165c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f9166d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9167e;

        public a(oc.e<? super a> eVar) {
            super(eVar);
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f9166d = obj;
            this.f9167e |= Integer.MIN_VALUE;
            return f.c(null, this);
        }
    }

    @qc.f(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", l = {66}, m = "joinAll")
    public static final class b extends qc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f9168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f9169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9170c;

        public b(oc.e<? super b> eVar) {
            super(eVar);
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f9169b = obj;
            this.f9170c |= Integer.MIN_VALUE;
            return f.b(null, this);
        }
    }

    public static final <T> Object a(t0<? extends T>[] t0VarArr, oc.e<? super List<? extends T>> eVar) {
        return t0VarArr.length == 0 ? mc.o.g() : new e(t0VarArr).c(eVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object b(Collection<? extends y1> collection, oc.e<? super lc.q> eVar) throws Throwable {
        b bVar;
        Iterator it;
        if (eVar instanceof b) {
            bVar = (b) eVar;
            int i10 = bVar.f9170c;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar.f9170c = i10 - Integer.MIN_VALUE;
            } else {
                bVar = new b(eVar);
            }
        } else {
            bVar = new b(eVar);
        }
        Object obj = bVar.f9169b;
        Object objC = pc.c.c();
        int i11 = bVar.f9170c;
        if (i11 == 0) {
            lc.k.b(obj);
            it = collection.iterator();
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) bVar.f9168a;
            lc.k.b(obj);
        }
        while (it.hasNext()) {
            y1 y1Var = (y1) it.next();
            bVar.f9168a = it;
            bVar.f9170c = 1;
            if (y1Var.join(bVar) == objC) {
                return objC;
            }
        }
        return lc.q.f12711a;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0044  */
    /* JADX WARN: Code duplicated, block: B:18:0x0054 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0052 -> B:19:0x0055). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object c(gd.y1[] r6, oc.e<? super lc.q> r7) {
        /*
            boolean r0 = r7 instanceof gd.f.a
            if (r0 == 0) goto L13
            r0 = r7
            gd.f$a r0 = (gd.f.a) r0
            int r1 = r0.f9167e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9167e = r1
            goto L18
        L13:
            gd.f$a r0 = new gd.f$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f9166d
            java.lang.Object r1 = pc.c.c()
            int r2 = r0.f9167e
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            int r6 = r0.f9165c
            int r2 = r0.f9164b
            java.lang.Object r4 = r0.f9163a
            gd.y1[] r4 = (gd.y1[]) r4
            lc.k.b(r7)
            r7 = r4
            goto L55
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            lc.k.b(r7)
            int r7 = r6.length
            r2 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L42:
            if (r2 >= r6) goto L57
            r4 = r7[r2]
            r0.f9163a = r7
            r0.f9164b = r2
            r0.f9165c = r6
            r0.f9167e = r3
            java.lang.Object r4 = r4.join(r0)
            if (r4 != r1) goto L55
            return r1
        L55:
            int r2 = r2 + r3
            goto L42
        L57:
            lc.q r6 = lc.q.f12711a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: gd.f.c(gd.y1[], oc.e):java.lang.Object");
    }
}
