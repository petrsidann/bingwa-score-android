package jd;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h {

    @qc.f(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", l = {36, 37}, m = "emitAllImpl$FlowKt__ChannelsKt")
    public static final class a<T> extends qc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f11357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f11358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f11359c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f11360d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f11361e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11362f;

        public a(oc.e<? super a> eVar) {
            super(eVar);
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f11361e = obj;
            this.f11362f |= Integer.MIN_VALUE;
            return h.c(null, null, false, this);
        }
    }

    public static final <T> Object b(e<? super T> eVar, id.t<? extends T> tVar, oc.e<? super lc.q> eVar2) throws Throwable {
        Object objC = c(eVar, tVar, true, eVar2);
        return objC == pc.c.c() ? objC : lc.q.f12711a;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0070 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0071  */
    /* JADX WARN: Code duplicated, block: B:28:0x007d A[Catch: all -> 0x009b, TRY_LEAVE, TryCatch #0 {all -> 0x009b, blocks: (B:13:0x0036, B:22:0x0060, B:26:0x0075, B:28:0x007d, B:18:0x0052, B:21:0x005c), top: B:41:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0091 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x0092 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0094  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008f -> B:14:0x0039). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final <T> java.lang.Object c(jd.e<? super T> r6, id.t<? extends T> r7, boolean r8, oc.e<? super lc.q> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof jd.h.a
            if (r0 == 0) goto L13
            r0 = r9
            jd.h$a r0 = (jd.h.a) r0
            int r1 = r0.f11362f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f11362f = r1
            goto L18
        L13:
            jd.h$a r0 = new jd.h$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f11361e
            java.lang.Object r1 = pc.c.c()
            int r2 = r0.f11362f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L56
            if (r2 == r4) goto L44
            if (r2 != r3) goto L3c
            boolean r8 = r0.f11360d
            java.lang.Object r6 = r0.f11359c
            id.f r6 = (id.f) r6
            java.lang.Object r7 = r0.f11358b
            id.t r7 = (id.t) r7
            java.lang.Object r2 = r0.f11357a
            jd.e r2 = (jd.e) r2
            lc.k.b(r9)     // Catch: java.lang.Throwable -> L9b
        L39:
            r9 = r6
            r6 = r2
            goto L60
        L3c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L44:
            boolean r8 = r0.f11360d
            java.lang.Object r6 = r0.f11359c
            id.f r6 = (id.f) r6
            java.lang.Object r7 = r0.f11358b
            id.t r7 = (id.t) r7
            java.lang.Object r2 = r0.f11357a
            jd.e r2 = (jd.e) r2
            lc.k.b(r9)     // Catch: java.lang.Throwable -> L9b
            goto L75
        L56:
            lc.k.b(r9)
            jd.f.e(r6)
            id.f r9 = r7.iterator()     // Catch: java.lang.Throwable -> L9b
        L60:
            r0.f11357a = r6     // Catch: java.lang.Throwable -> L9b
            r0.f11358b = r7     // Catch: java.lang.Throwable -> L9b
            r0.f11359c = r9     // Catch: java.lang.Throwable -> L9b
            r0.f11360d = r8     // Catch: java.lang.Throwable -> L9b
            r0.f11362f = r4     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r2 = r9.a(r0)     // Catch: java.lang.Throwable -> L9b
            if (r2 != r1) goto L71
            return r1
        L71:
            r5 = r2
            r2 = r6
            r6 = r9
            r9 = r5
        L75:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L9b
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L9b
            if (r9 == 0) goto L92
            java.lang.Object r9 = r6.next()     // Catch: java.lang.Throwable -> L9b
            r0.f11357a = r2     // Catch: java.lang.Throwable -> L9b
            r0.f11358b = r7     // Catch: java.lang.Throwable -> L9b
            r0.f11359c = r6     // Catch: java.lang.Throwable -> L9b
            r0.f11360d = r8     // Catch: java.lang.Throwable -> L9b
            r0.f11362f = r3     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r9 = r2.b(r9, r0)     // Catch: java.lang.Throwable -> L9b
            if (r9 != r1) goto L39
            return r1
        L92:
            if (r8 == 0) goto L98
            r6 = 0
            id.k.a(r7, r6)
        L98:
            lc.q r6 = lc.q.f12711a
            return r6
        L9b:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> L9d
        L9d:
            r9 = move-exception
            if (r8 == 0) goto La3
            id.k.a(r7, r6)
        La3:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: jd.h.c(jd.e, id.t, boolean, oc.e):java.lang.Object");
    }
}
