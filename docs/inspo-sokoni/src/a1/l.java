package a1;

import gd.m0;
import gd.y1;
import java.util.concurrent.atomic.AtomicInteger;
import lc.q;
import xc.p;

/* JADX INFO: loaded from: classes.dex */
public final class l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p<T, oc.e<? super q>, Object> f224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final id.d<T> f225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f226d;

    public static final class a extends kotlin.jvm.internal.l implements xc.l<Throwable, q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ xc.l<Throwable, q> f227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l<T> f228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ p<T, Throwable, q> f229c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(xc.l<? super Throwable, q> lVar, l<T> lVar2, p<? super T, ? super Throwable, q> pVar) {
            super(1);
            this.f227a = lVar;
            this.f228b = lVar2;
            this.f229c = pVar;
        }

        public final void a(Throwable th) {
            q qVar;
            this.f227a.invoke(th);
            this.f228b.f225c.e(th);
            do {
                Object objF = id.h.f(this.f228b.f225c.a());
                if (objF == null) {
                    qVar = null;
                } else {
                    this.f229c.invoke((T) objF, th);
                    qVar = q.f12711a;
                }
            } while (qVar != null);
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ q invoke(Throwable th) {
            a(th);
            return q.f12711a;
        }
    }

    @qc.f(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {122, 122}, m = "invokeSuspend")
    public static final class b extends qc.l implements p<m0, oc.e<? super q>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l<T> f232c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l<T> lVar, oc.e<? super b> eVar) {
            super(2, eVar);
            this.f232c = lVar;
        }

        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(m0 m0Var, oc.e<? super q> eVar) {
            return ((b) create(m0Var, eVar)).invokeSuspend(q.f12711a);
        }

        @Override // qc.a
        public final oc.e<q> create(Object obj, oc.e<?> eVar) {
            return new b(this.f232c, eVar);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x005a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:19:0x005b  */
        /* JADX WARN: Code duplicated, block: B:22:0x006b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x006c  */
        /* JADX WARN: Code duplicated, block: B:26:0x007a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006c -> B:24:0x006e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // qc.a
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = pc.c.c()
                int r1 = r7.f231b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L26
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                lc.k.b(r8)
                r8 = r7
                goto L6e
            L13:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1b:
                java.lang.Object r1 = r7.f230a
                xc.p r1 = (xc.p) r1
                lc.k.b(r8)
                r4 = r1
                r1 = r0
                r0 = r7
                goto L60
            L26:
                lc.k.b(r8)
                a1.l<T> r8 = r7.f232c
                java.util.concurrent.atomic.AtomicInteger r8 = a1.l.c(r8)
                int r8 = r8.get()
                if (r8 <= 0) goto L37
                r8 = r3
                goto L38
            L37:
                r8 = 0
            L38:
                if (r8 == 0) goto L7d
                r8 = r7
            L3b:
                a1.l<T> r1 = r8.f232c
                gd.m0 r1 = a1.l.d(r1)
                gd.n0.d(r1)
                a1.l<T> r1 = r8.f232c
                xc.p r1 = a1.l.a(r1)
                a1.l<T> r4 = r8.f232c
                id.d r4 = a1.l.b(r4)
                r8.f230a = r1
                r8.f231b = r3
                java.lang.Object r4 = r4.b(r8)
                if (r4 != r0) goto L5b
                return r0
            L5b:
                r6 = r0
                r0 = r8
                r8 = r4
                r4 = r1
                r1 = r6
            L60:
                r5 = 0
                r0.f230a = r5
                r0.f231b = r2
                java.lang.Object r8 = r4.invoke(r8, r0)
                if (r8 != r1) goto L6c
                return r1
            L6c:
                r8 = r0
                r0 = r1
            L6e:
                a1.l<T> r1 = r8.f232c
                java.util.concurrent.atomic.AtomicInteger r1 = a1.l.c(r1)
                int r1 = r1.decrementAndGet()
                if (r1 != 0) goto L3b
                lc.q r8 = lc.q.f12711a
                return r8
            L7d:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "Check failed."
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: a1.l.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(m0 scope, xc.l<? super Throwable, q> onComplete, p<? super T, ? super Throwable, q> onUndeliveredElement, p<? super T, ? super oc.e<? super q>, ? extends Object> consumeMessage) {
        kotlin.jvm.internal.k.e(scope, "scope");
        kotlin.jvm.internal.k.e(onComplete, "onComplete");
        kotlin.jvm.internal.k.e(onUndeliveredElement, "onUndeliveredElement");
        kotlin.jvm.internal.k.e(consumeMessage, "consumeMessage");
        this.f223a = scope;
        this.f224b = consumeMessage;
        this.f225c = id.g.b(com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER, null, null, 6, null);
        this.f226d = new AtomicInteger(0);
        y1 y1Var = (y1) scope.f().get(y1.f9273i);
        if (y1Var == null) {
            return;
        }
        y1Var.invokeOnCompletion(new a(onComplete, this, onUndeliveredElement));
    }

    public final void e(T t10) throws Throwable {
        Object objL = this.f225c.l(t10);
        if (objL instanceof id.h.a) {
            Throwable thE = id.h.e(objL);
            if (thE != null) {
                throw thE;
            }
            throw new id.n("Channel was closed normally");
        }
        if (!id.h.i(objL)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (this.f226d.getAndIncrement() == 0) {
            gd.k.d(this.f223a, null, null, new b(this, null), 3, null);
        }
    }
}
