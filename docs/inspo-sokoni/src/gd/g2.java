package gd;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public class g2 implements y1, w, o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f9176a = AtomicReferenceFieldUpdater.newUpdater(g2.class, Object.class, "_state");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f9177b = AtomicReferenceFieldUpdater.newUpdater(g2.class, Object.class, "_parentHandle");
    private volatile Object _parentHandle;
    private volatile Object _state;

    public static final class a<T> extends p<T> {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final g2 f9178n;

        public a(oc.e<? super T> eVar, g2 g2Var) {
            super(eVar, 1);
            this.f9178n = g2Var;
        }

        @Override // gd.p
        public String H() {
            return "AwaitContinuation";
        }

        @Override // gd.p
        public Throwable w(y1 y1Var) {
            Throwable thE;
            Object objD0 = this.f9178n.d0();
            if (!(objD0 instanceof c) || (thE = ((c) objD0).e()) == null) {
                return objD0 instanceof c0 ? ((c0) objD0).f9143a : y1Var.getCancellationException();
            }
            return thE;
        }
    }

    public static final class b extends f2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final g2 f9179e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c f9180f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final v f9181l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Object f9182m;

        public b(g2 g2Var, c cVar, v vVar, Object obj) {
            this.f9179e = g2Var;
            this.f9180f = cVar;
            this.f9181l = vVar;
            this.f9182m = obj;
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
            t(th);
            return lc.q.f12711a;
        }

        @Override // gd.e0
        public void t(Throwable th) {
            this.f9179e.R(this.f9180f, this.f9181l, this.f9182m);
        }
    }

    public static final class c implements t1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f9183b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f9184c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f9185d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder");
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l2 f9186a;

        public c(l2 l2Var, boolean z10, Throwable th) {
            this.f9186a = l2Var;
            this._isCompleting = z10 ? 1 : 0;
            this._rootCause = th;
        }

        @Override // gd.t1
        public l2 a() {
            return this.f9186a;
        }

        public final void b(Throwable th) {
            Throwable thE = e();
            if (thE == null) {
                l(th);
                return;
            }
            if (th == thE) {
                return;
            }
            Object objD = d();
            if (objD == null) {
                k(th);
                return;
            }
            if (objD instanceof Throwable) {
                if (th == objD) {
                    return;
                }
                ArrayList<Throwable> arrayListC = c();
                arrayListC.add(objD);
                arrayListC.add(th);
                k(arrayListC);
                return;
            }
            if (objD instanceof ArrayList) {
                ((ArrayList) objD).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + objD).toString());
        }

        public final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        public final Object d() {
            return f9185d.get(this);
        }

        public final Throwable e() {
            return (Throwable) f9184c.get(this);
        }

        public final boolean f() {
            return e() != null;
        }

        public final boolean g() {
            return f9183b.get(this) != 0;
        }

        public final boolean h() {
            return d() == h2.f9207e;
        }

        public final List<Throwable> i(Throwable th) {
            ArrayList<Throwable> arrayListC;
            Object objD = d();
            if (objD == null) {
                arrayListC = c();
            } else if (objD instanceof Throwable) {
                ArrayList<Throwable> arrayListC2 = c();
                arrayListC2.add(objD);
                arrayListC = arrayListC2;
            } else {
                if (!(objD instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + objD).toString());
                }
                arrayListC = (ArrayList) objD;
            }
            Throwable thE = e();
            if (thE != null) {
                arrayListC.add(0, thE);
            }
            if (th != null && !kotlin.jvm.internal.k.a(th, thE)) {
                arrayListC.add(th);
            }
            k(h2.f9207e);
            return arrayListC;
        }

        @Override // gd.t1
        public boolean isActive() {
            return e() == null;
        }

        public final void j(boolean z10) {
            f9183b.set(this, z10 ? 1 : 0);
        }

        public final void k(Object obj) {
            f9185d.set(this, obj);
        }

        public final void l(Throwable th) {
            f9184c.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + a() + ']';
        }
    }

    public final class d extends f2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final od.f<?> f9187e;

        public d(od.f<?> fVar) {
            this.f9187e = fVar;
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
            t(th);
            return lc.q.f12711a;
        }

        @Override // gd.e0
        public void t(Throwable th) {
            Object objD0 = g2.this.d0();
            if (!(objD0 instanceof c0)) {
                objD0 = h2.h(objD0);
            }
            this.f9187e.c(g2.this, objD0);
        }
    }

    public final class e extends f2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final od.f<?> f9189e;

        public e(od.f<?> fVar) {
            this.f9189e = fVar;
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
            t(th);
            return lc.q.f12711a;
        }

        @Override // gd.e0
        public void t(Throwable th) {
            this.f9189e.c(g2.this, lc.q.f12711a);
        }
    }

    public static final class f extends ld.s.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g2 f9191d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f9192e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ld.s sVar, g2 g2Var, Object obj) {
            super(sVar);
            this.f9191d = g2Var;
            this.f9192e = obj;
        }

        @Override // ld.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Object d(ld.s sVar) {
            if (this.f9191d.d0() == this.f9192e) {
                return null;
            }
            return ld.r.a();
        }
    }

    @qc.f(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", l = {956, 958}, m = "invokeSuspend")
    public static final class g extends qc.k implements xc.p<dd.d<? super y1>, oc.e<? super lc.q>, Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f9193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f9194c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f9195d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f9196e;

        public g(oc.e<? super g> eVar) {
            super(2, eVar);
        }

        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(dd.d<? super y1> dVar, oc.e<? super lc.q> eVar) {
            return ((g) create(dVar, eVar)).invokeSuspend(lc.q.f12711a);
        }

        @Override // qc.a
        public final oc.e<lc.q> create(Object obj, oc.e<?> eVar) {
            g gVar = g2.this.new g(eVar);
            gVar.f9196e = obj;
            return gVar;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x006b  */
        /* JADX WARN: Code duplicated, block: B:24:0x006f  */
        /* JADX WARN: Code duplicated, block: B:26:0x0082 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:27:0x0083). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0080 -> B:27:0x0083). Please report as a decompilation issue!!! */
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
                int r1 = r7.f9195d
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2b
                if (r1 == r3) goto L27
                if (r1 != r2) goto L1f
                java.lang.Object r1 = r7.f9194c
                ld.s r1 = (ld.s) r1
                java.lang.Object r3 = r7.f9193b
                ld.q r3 = (ld.q) r3
                java.lang.Object r4 = r7.f9196e
                dd.d r4 = (dd.d) r4
                lc.k.b(r8)
                r8 = r7
                goto L83
            L1f:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L27:
                lc.k.b(r8)
                goto L88
            L2b:
                lc.k.b(r8)
                java.lang.Object r8 = r7.f9196e
                dd.d r8 = (dd.d) r8
                gd.g2 r1 = gd.g2.this
                java.lang.Object r1 = r1.d0()
                boolean r4 = r1 instanceof gd.v
                if (r4 == 0) goto L49
                gd.v r1 = (gd.v) r1
                gd.w r1 = r1.f9264e
                r7.f9195d = r3
                java.lang.Object r8 = r8.b(r1, r7)
                if (r8 != r0) goto L88
                return r0
            L49:
                boolean r3 = r1 instanceof gd.t1
                if (r3 == 0) goto L88
                gd.t1 r1 = (gd.t1) r1
                gd.l2 r1 = r1.a()
                if (r1 == 0) goto L88
                java.lang.Object r3 = r1.l()
                java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
                kotlin.jvm.internal.k.c(r3, r4)
                ld.s r3 = (ld.s) r3
                r4 = r8
                r8 = r7
                r6 = r3
                r3 = r1
                r1 = r6
            L65:
                boolean r5 = kotlin.jvm.internal.k.a(r1, r3)
                if (r5 != 0) goto L88
                boolean r5 = r1 instanceof gd.v
                if (r5 == 0) goto L83
                r5 = r1
                gd.v r5 = (gd.v) r5
                gd.w r5 = r5.f9264e
                r8.f9196e = r4
                r8.f9193b = r3
                r8.f9194c = r1
                r8.f9195d = r2
                java.lang.Object r5 = r4.b(r5, r8)
                if (r5 != r0) goto L83
                return r0
            L83:
                ld.s r1 = r1.m()
                goto L65
            L88:
                lc.q r8 = lc.q.f12711a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: gd.g2.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public /* synthetic */ class h extends kotlin.jvm.internal.j implements xc.q<g2, od.f<?>, Object, lc.q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f9198a = new h();

        public h() {
            super(3, g2.class, "onAwaitInternalRegFunc", "onAwaitInternalRegFunc(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        public final void d(g2 g2Var, od.f<?> fVar, Object obj) {
            g2Var.t0(fVar, obj);
        }

        @Override // xc.q
        public /* bridge */ /* synthetic */ lc.q e(g2 g2Var, od.f<?> fVar, Object obj) {
            d(g2Var, fVar, obj);
            return lc.q.f12711a;
        }
    }

    public /* synthetic */ class i extends kotlin.jvm.internal.j implements xc.q<g2, Object, Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f9199a = new i();

        public i() {
            super(3, g2.class, "onAwaitInternalProcessResFunc", "onAwaitInternalProcessResFunc(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // xc.q
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public final Object e(g2 g2Var, Object obj, Object obj2) {
            return g2Var.s0(obj, obj2);
        }
    }

    public /* synthetic */ class j extends kotlin.jvm.internal.j implements xc.q<g2, od.f<?>, Object, lc.q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f9200a = new j();

        public j() {
            super(3, g2.class, "registerSelectForOnJoin", "registerSelectForOnJoin(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        public final void d(g2 g2Var, od.f<?> fVar, Object obj) {
            g2Var.z0(fVar, obj);
        }

        @Override // xc.q
        public /* bridge */ /* synthetic */ lc.q e(g2 g2Var, od.f<?> fVar, Object obj) {
            d(g2Var, fVar, obj);
            return lc.q.f12711a;
        }
    }

    public g2(boolean z10) {
        this._state = z10 ? h2.f9209g : h2.f9208f;
    }

    public static /* synthetic */ CancellationException F0(g2 g2Var, Throwable th, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        return g2Var.E0(th, str);
    }

    public final Object A(oc.e<Object> eVar) {
        a aVar = new a(pc.b.b(eVar), this);
        aVar.B();
        r.a(aVar, invokeOnCompletion(new p2(aVar)));
        Object objY = aVar.y();
        if (objY == pc.c.c()) {
            qc.h.c(eVar);
        }
        return objY;
    }

    public final void A0(f2 f2Var) {
        Object objD0;
        do {
            objD0 = d0();
            if (!(objD0 instanceof f2)) {
                if (!(objD0 instanceof t1) || ((t1) objD0).a() == null) {
                    return;
                }
                f2Var.p();
                return;
            }
            if (objD0 != f2Var) {
                return;
            }
        } while (!u.b.a(f9176a, this, objD0, h2.f9209g));
    }

    public final void B0(u uVar) {
        f9177b.set(this, uVar);
    }

    public final int C0(Object obj) {
        if (obj instanceof h1) {
            if (((h1) obj).isActive()) {
                return 0;
            }
            if (!u.b.a(f9176a, this, obj, h2.f9209g)) {
                return -1;
            }
            w0();
            return 1;
        }
        if (!(obj instanceof s1)) {
            return 0;
        }
        if (!u.b.a(f9176a, this, obj, ((s1) obj).a())) {
            return -1;
        }
        w0();
        return 1;
    }

    public final boolean D(Throwable th) {
        return F(th);
    }

    public final String D0(Object obj) {
        if (!(obj instanceof c)) {
            if (obj instanceof t1) {
                return ((t1) obj).isActive() ? "Active" : "New";
            }
            return obj instanceof c0 ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        if (cVar.f()) {
            return "Cancelling";
        }
        return cVar.g() ? "Completing" : "Active";
    }

    public final CancellationException E0(Throwable th, String str) {
        CancellationException z1Var = th instanceof CancellationException ? (CancellationException) th : null;
        if (z1Var == null) {
            if (str == null) {
                str = M();
            }
            z1Var = new z1(str, th, this);
        }
        return z1Var;
    }

    public final boolean F(Object obj) throws Throwable {
        Object objK0 = h2.f9203a;
        if (a0() && (objK0 = J(obj)) == h2.f9204b) {
            return true;
        }
        if (objK0 == h2.f9203a) {
            objK0 = k0(obj);
        }
        if (objK0 == h2.f9203a || objK0 == h2.f9204b) {
            return true;
        }
        if (objK0 == h2.f9206d) {
            return false;
        }
        x(objK0);
        return true;
    }

    public final String G0() {
        return o0() + '{' + D0(d0()) + '}';
    }

    public void H(Throwable th) throws Throwable {
        F(th);
    }

    public final boolean H0(t1 t1Var, Object obj) throws Throwable {
        if (!u.b.a(f9176a, this, t1Var, h2.g(obj))) {
            return false;
        }
        u0(null);
        v0(obj);
        P(t1Var, obj);
        return true;
    }

    public final boolean I0(t1 t1Var, Throwable th) throws Throwable {
        l2 l2VarB0 = b0(t1Var);
        if (l2VarB0 == null) {
            return false;
        }
        if (!u.b.a(f9176a, this, t1Var, new c(l2VarB0, false, th))) {
            return false;
        }
        q0(l2VarB0, th);
        return true;
    }

    public final Object J(Object obj) {
        Object objJ0;
        do {
            Object objD0 = d0();
            if (!(objD0 instanceof t1) || ((objD0 instanceof c) && ((c) objD0).g())) {
                return h2.f9203a;
            }
            objJ0 = J0(objD0, new c0(S(obj), false, 2, null));
        } while (objJ0 == h2.f9205c);
        return objJ0;
    }

    public final Object J0(Object obj, Object obj2) {
        if (!(obj instanceof t1)) {
            return h2.f9203a;
        }
        if ((!(obj instanceof h1) && !(obj instanceof f2)) || (obj instanceof v) || (obj2 instanceof c0)) {
            return K0((t1) obj, obj2);
        }
        return H0((t1) obj, obj2) ? obj2 : h2.f9205c;
    }

    public final boolean K(Throwable th) {
        if (h0()) {
            return true;
        }
        boolean z10 = th instanceof CancellationException;
        u uVarC0 = c0();
        if (uVarC0 == null || uVarC0 == m2.f9235a) {
            return z10;
        }
        return uVarC0.h(th) || z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final Object K0(t1 t1Var, Object obj) throws Throwable {
        l2 l2VarB0 = b0(t1Var);
        if (l2VarB0 == null) {
            return h2.f9205c;
        }
        c cVar = t1Var instanceof c ? (c) t1Var : null;
        if (cVar == null) {
            cVar = new c(l2VarB0, false, null);
        }
        kotlin.jvm.internal.t tVar = new kotlin.jvm.internal.t();
        synchronized (cVar) {
            if (cVar.g()) {
                return h2.f9203a;
            }
            cVar.j(true);
            if (cVar != t1Var && !u.b.a(f9176a, this, t1Var, cVar)) {
                return h2.f9205c;
            }
            boolean zF = cVar.f();
            c0 c0Var = obj instanceof c0 ? (c0) obj : null;
            if (c0Var != null) {
                cVar.b(c0Var.f9143a);
            }
            ?? E = Boolean.valueOf(zF ? false : true).booleanValue() ? cVar.e() : 0;
            tVar.f12381a = E;
            lc.q qVar = lc.q.f12711a;
            if (E != 0) {
                q0(l2VarB0, E);
            }
            v vVarU = U(t1Var);
            return (vVarU == null || !L0(cVar, vVarU, obj)) ? T(cVar, obj) : h2.f9204b;
        }
    }

    @Override // gd.o2
    public CancellationException L() {
        Throwable thE;
        Object objD0 = d0();
        if (objD0 instanceof c) {
            thE = ((c) objD0).e();
        } else if (objD0 instanceof c0) {
            thE = ((c0) objD0).f9143a;
        } else {
            if (objD0 instanceof t1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objD0).toString());
            }
            thE = null;
        }
        CancellationException cancellationException = thE instanceof CancellationException ? (CancellationException) thE : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new z1("Parent job is " + D0(objD0), thE, this);
    }

    public final boolean L0(c cVar, v vVar, Object obj) {
        while (y1.a.e(vVar.f9264e, false, false, new b(this, cVar, vVar, obj), 1, null) == m2.f9235a) {
            vVar = p0(vVar);
            if (vVar == null) {
                return false;
            }
        }
        return true;
    }

    public String M() {
        return "Job was cancelled";
    }

    public boolean N(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return F(th) && Y();
    }

    public final void P(t1 t1Var, Object obj) throws Throwable {
        u uVarC0 = c0();
        if (uVarC0 != null) {
            uVarC0.d();
            B0(m2.f9235a);
        }
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        Throwable th = c0Var != null ? c0Var.f9143a : null;
        if (!(t1Var instanceof f2)) {
            l2 l2VarA = t1Var.a();
            if (l2VarA != null) {
                r0(l2VarA, th);
                return;
            }
            return;
        }
        try {
            ((f2) t1Var).t(th);
        } catch (Throwable th2) {
            f0(new f0("Exception in completion handler " + t1Var + " for " + this, th2));
        }
    }

    public final void R(c cVar, v vVar, Object obj) {
        v vVarP0 = p0(vVar);
        if (vVarP0 == null || !L0(cVar, vVarP0, obj)) {
            x(T(cVar, obj));
        }
    }

    public final Throwable S(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new z1(M(), null, this) : th;
        }
        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((o2) obj).L();
    }

    public final Object T(c cVar, Object obj) throws Throwable {
        boolean zF;
        Throwable thX;
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        Throwable th = c0Var != null ? c0Var.f9143a : null;
        synchronized (cVar) {
            zF = cVar.f();
            List<Throwable> listI = cVar.i(th);
            thX = X(cVar, listI);
            if (thX != null) {
                w(thX, listI);
            }
        }
        if (thX != null && thX != th) {
            obj = new c0(thX, false, 2, null);
        }
        if (thX != null) {
            if (K(thX) || e0(thX)) {
                kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                ((c0) obj).b();
            }
        }
        if (!zF) {
            u0(thX);
        }
        v0(obj);
        u.b.a(f9176a, this, cVar, h2.g(obj));
        P(cVar, obj);
        return obj;
    }

    public final v U(t1 t1Var) {
        v vVar = t1Var instanceof v ? (v) t1Var : null;
        if (vVar != null) {
            return vVar;
        }
        l2 l2VarA = t1Var.a();
        if (l2VarA != null) {
            return p0(l2VarA);
        }
        return null;
    }

    public final Object V() throws Throwable {
        Object objD0 = d0();
        if (!(!(objD0 instanceof t1))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        }
        if (objD0 instanceof c0) {
            throw ((c0) objD0).f9143a;
        }
        return h2.h(objD0);
    }

    public final Throwable W(Object obj) {
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        if (c0Var != null) {
            return c0Var.f9143a;
        }
        return null;
    }

    public final Throwable X(c cVar, List<? extends Throwable> list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (cVar.f()) {
                return new z1(M(), null, this);
            }
            return null;
        }
        List<? extends Throwable> list2 = list;
        Iterator<T> it = list2.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(!(((Throwable) next) instanceof CancellationException)));
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof x2) {
            for (Object obj2 : list2) {
                Throwable th3 = (Throwable) obj2;
                if (th3 != th2 && (th3 instanceof x2)) {
                    obj = obj2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean Y() {
        return true;
    }

    public final od.c<?> Z() {
        h hVar = h.f9198a;
        kotlin.jvm.internal.k.c(hVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        xc.q qVar = (xc.q) kotlin.jvm.internal.x.a(hVar, 3);
        i iVar = i.f9199a;
        kotlin.jvm.internal.k.c(iVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new od.d(this, qVar, (xc.q) kotlin.jvm.internal.x.a(iVar, 3), null, 8, null);
    }

    public boolean a0() {
        return false;
    }

    @Override // gd.y1
    public final u attachChild(w wVar) {
        e1 e1VarE = y1.a.e(this, true, false, new v(wVar), 2, null);
        kotlin.jvm.internal.k.c(e1VarE, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (u) e1VarE;
    }

    public final l2 b0(t1 t1Var) {
        l2 l2VarA = t1Var.a();
        if (l2VarA != null) {
            return l2VarA;
        }
        if (t1Var instanceof h1) {
            return new l2();
        }
        if (t1Var instanceof f2) {
            y0((f2) t1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + t1Var).toString());
    }

    public final u c0() {
        return (u) f9177b.get(this);
    }

    @Override // gd.y1
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    @Override // gd.y1
    public void cancel(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new z1(M(), null, this);
        }
        H(cancellationException);
    }

    @Override // gd.y1
    public /* synthetic */ boolean cancel(Throwable th) throws Throwable {
        Throwable z1Var;
        if (th == null || (z1Var = F0(this, th, null, 1, null)) == null) {
            z1Var = new z1(M(), null, this);
        }
        H(z1Var);
        return true;
    }

    public final Object d0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9176a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof ld.a0)) {
                return obj;
            }
            ((ld.a0) obj).a(this);
        }
    }

    public boolean e0(Throwable th) {
        return false;
    }

    public void f0(Throwable th) throws Throwable {
        throw th;
    }

    @Override // oc.i.b, oc.i
    public <R> R fold(R r10, xc.p<? super R, ? super oc.i.b, ? extends R> pVar) {
        return (R) y1.a.c(this, r10, pVar);
    }

    public final void g0(y1 y1Var) {
        if (y1Var == null) {
            B0(m2.f9235a);
            return;
        }
        y1Var.start();
        u uVarAttachChild = y1Var.attachChild(this);
        B0(uVarAttachChild);
        if (isCompleted()) {
            uVarAttachChild.d();
            B0(m2.f9235a);
        }
    }

    @Override // oc.i.b, oc.i
    public <E extends oc.i.b> E get(oc.i.c<E> cVar) {
        return (E) y1.a.d(this, cVar);
    }

    @Override // gd.y1
    public final CancellationException getCancellationException() {
        Object objD0 = d0();
        if (!(objD0 instanceof c)) {
            if (objD0 instanceof t1) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (objD0 instanceof c0) {
                return F0(this, ((c0) objD0).f9143a, null, 1, null);
            }
            return new z1(q0.a(this) + " has completed normally", null, this);
        }
        Throwable thE = ((c) objD0).e();
        if (thE != null) {
            CancellationException cancellationExceptionE0 = E0(thE, q0.a(this) + " is cancelling");
            if (cancellationExceptionE0 != null) {
                return cancellationExceptionE0;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // gd.y1
    public final dd.b<y1> getChildren() {
        return dd.e.b(new g(null));
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object objD0 = d0();
        if (!(objD0 instanceof t1)) {
            return W(objD0);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    @Override // oc.i.b
    public final oc.i.c<?> getKey() {
        return y1.f9273i;
    }

    @Override // gd.y1
    public final od.a getOnJoin() {
        j jVar = j.f9200a;
        kotlin.jvm.internal.k.c(jVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new od.b(this, (xc.q) kotlin.jvm.internal.x.a(jVar, 3), null, 4, null);
    }

    @Override // gd.y1
    public y1 getParent() {
        u uVarC0 = c0();
        if (uVarC0 != null) {
            return uVarC0.getParent();
        }
        return null;
    }

    public boolean h0() {
        return false;
    }

    public final boolean i0() {
        Object objD0;
        do {
            objD0 = d0();
            if (!(objD0 instanceof t1)) {
                return false;
            }
        } while (C0(objD0) < 0);
        return true;
    }

    @Override // gd.y1
    public final e1 invokeOnCompletion(xc.l<? super Throwable, lc.q> lVar) {
        return invokeOnCompletion(false, true, lVar);
    }

    @Override // gd.y1
    public final e1 invokeOnCompletion(boolean z10, boolean z11, xc.l<? super Throwable, lc.q> lVar) {
        f2 f2VarN0 = n0(lVar, z10);
        while (true) {
            Object objD0 = d0();
            if (objD0 instanceof h1) {
                h1 h1Var = (h1) objD0;
                if (!h1Var.isActive()) {
                    x0(h1Var);
                } else if (u.b.a(f9176a, this, objD0, f2VarN0)) {
                    return f2VarN0;
                }
            } else {
                Throwable thE = null;
                if (!(objD0 instanceof t1)) {
                    if (z11) {
                        c0 c0Var = objD0 instanceof c0 ? (c0) objD0 : null;
                        lVar.invoke(c0Var != null ? c0Var.f9143a : null);
                    }
                    return m2.f9235a;
                }
                l2 l2VarA = ((t1) objD0).a();
                if (l2VarA == null) {
                    kotlin.jvm.internal.k.c(objD0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    y0((f2) objD0);
                } else {
                    e1 e1Var = m2.f9235a;
                    if (z10 && (objD0 instanceof c)) {
                        synchronized (objD0) {
                            thE = ((c) objD0).e();
                            if (thE == null || ((lVar instanceof v) && !((c) objD0).g())) {
                                if (u(objD0, l2VarA, f2VarN0)) {
                                    if (thE == null) {
                                        return f2VarN0;
                                    }
                                    e1Var = f2VarN0;
                                }
                            }
                            lc.q qVar = lc.q.f12711a;
                        }
                    }
                    if (thE != null) {
                        if (z11) {
                            lVar.invoke(thE);
                        }
                        return e1Var;
                    }
                    if (u(objD0, l2VarA, f2VarN0)) {
                        return f2VarN0;
                    }
                }
            }
        }
    }

    @Override // gd.y1
    public boolean isActive() {
        Object objD0 = d0();
        return (objD0 instanceof t1) && ((t1) objD0).isActive();
    }

    @Override // gd.y1
    public final boolean isCancelled() {
        Object objD0 = d0();
        return (objD0 instanceof c0) || ((objD0 instanceof c) && ((c) objD0).f());
    }

    @Override // gd.y1
    public final boolean isCompleted() {
        return !(d0() instanceof t1);
    }

    public final Object j0(oc.e<? super lc.q> eVar) {
        p pVar = new p(pc.b.b(eVar), 1);
        pVar.B();
        r.a(pVar, invokeOnCompletion(new q2(pVar)));
        Object objY = pVar.y();
        if (objY == pc.c.c()) {
            qc.h.c(eVar);
        }
        return objY == pc.c.c() ? objY : lc.q.f12711a;
    }

    @Override // gd.y1
    public final Object join(oc.e<? super lc.q> eVar) {
        if (i0()) {
            Object objJ0 = j0(eVar);
            return objJ0 == pc.c.c() ? objJ0 : lc.q.f12711a;
        }
        c2.i(eVar.getContext());
        return lc.q.f12711a;
    }

    public final Object k0(Object obj) throws Throwable {
        Throwable thS = null;
        while (true) {
            Object objD0 = d0();
            if (objD0 instanceof c) {
                synchronized (objD0) {
                    if (((c) objD0).h()) {
                        return h2.f9206d;
                    }
                    boolean zF = ((c) objD0).f();
                    if (obj != null || !zF) {
                        if (thS == null) {
                            thS = S(obj);
                        }
                        ((c) objD0).b(thS);
                    }
                    Throwable thE = zF ^ true ? ((c) objD0).e() : null;
                    if (thE != null) {
                        q0(((c) objD0).a(), thE);
                    }
                    return h2.f9203a;
                }
            }
            if (!(objD0 instanceof t1)) {
                return h2.f9206d;
            }
            if (thS == null) {
                thS = S(obj);
            }
            t1 t1Var = (t1) objD0;
            if (!t1Var.isActive()) {
                Object objJ0 = J0(objD0, new c0(thS, false, 2, null));
                if (objJ0 == h2.f9203a) {
                    throw new IllegalStateException(("Cannot happen in " + objD0).toString());
                }
                if (objJ0 != h2.f9205c) {
                    return objJ0;
                }
            } else if (I0(t1Var, thS)) {
                return h2.f9203a;
            }
        }
    }

    public final boolean l0(Object obj) {
        Object objJ0;
        do {
            objJ0 = J0(d0(), obj);
            if (objJ0 == h2.f9203a) {
                return false;
            }
            if (objJ0 == h2.f9204b) {
                return true;
            }
        } while (objJ0 == h2.f9205c);
        x(objJ0);
        return true;
    }

    public final Object m0(Object obj) {
        Object objJ0;
        do {
            objJ0 = J0(d0(), obj);
            if (objJ0 == h2.f9203a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, W(obj));
            }
        } while (objJ0 == h2.f9205c);
        return objJ0;
    }

    @Override // oc.i.b, oc.i
    public oc.i minusKey(oc.i.c<?> cVar) {
        return y1.a.f(this, cVar);
    }

    public final f2 n0(xc.l<? super Throwable, lc.q> lVar, boolean z10) {
        f2 x1Var;
        if (z10) {
            x1Var = lVar instanceof a2 ? (a2) lVar : null;
            if (x1Var == null) {
                x1Var = new w1(lVar);
            }
        } else {
            x1Var = lVar instanceof f2 ? (f2) lVar : null;
            if (x1Var == null) {
                x1Var = new x1(lVar);
            }
        }
        x1Var.v(this);
        return x1Var;
    }

    public String o0() {
        return q0.a(this);
    }

    public final v p0(ld.s sVar) {
        while (sVar.o()) {
            sVar = sVar.n();
        }
        while (true) {
            sVar = sVar.m();
            if (!sVar.o()) {
                if (sVar instanceof v) {
                    return (v) sVar;
                }
                if (sVar instanceof l2) {
                    return null;
                }
            }
        }
    }

    @Override // gd.y1
    public y1 plus(y1 y1Var) {
        return y1.a.g(this, y1Var);
    }

    @Override // oc.i
    public oc.i plus(oc.i iVar) {
        return y1.a.h(this, iVar);
    }

    public final void q0(l2 l2Var, Throwable th) throws Throwable {
        u0(th);
        Object objL = l2Var.l();
        kotlin.jvm.internal.k.c(objL, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        f0 f0Var = null;
        for (ld.s sVarM = (ld.s) objL; !kotlin.jvm.internal.k.a(sVarM, l2Var); sVarM = sVarM.m()) {
            if (sVarM instanceof a2) {
                f2 f2Var = (f2) sVarM;
                try {
                    f2Var.t(th);
                } catch (Throwable th2) {
                    if (f0Var != null) {
                        lc.a.a(f0Var, th2);
                    } else {
                        f0Var = new f0("Exception in completion handler " + f2Var + " for " + this, th2);
                        lc.q qVar = lc.q.f12711a;
                    }
                }
            }
        }
        if (f0Var != null) {
            f0(f0Var);
        }
        K(th);
    }

    public final void r0(l2 l2Var, Throwable th) throws Throwable {
        Object objL = l2Var.l();
        kotlin.jvm.internal.k.c(objL, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        f0 f0Var = null;
        for (ld.s sVarM = (ld.s) objL; !kotlin.jvm.internal.k.a(sVarM, l2Var); sVarM = sVarM.m()) {
            if (sVarM instanceof f2) {
                f2 f2Var = (f2) sVarM;
                try {
                    f2Var.t(th);
                } catch (Throwable th2) {
                    if (f0Var != null) {
                        lc.a.a(f0Var, th2);
                    } else {
                        f0Var = new f0("Exception in completion handler " + f2Var + " for " + this, th2);
                        lc.q qVar = lc.q.f12711a;
                    }
                }
            }
        }
        if (f0Var != null) {
            f0(f0Var);
        }
    }

    public final Object s0(Object obj, Object obj2) throws Throwable {
        if (obj2 instanceof c0) {
            throw ((c0) obj2).f9143a;
        }
        return obj2;
    }

    @Override // gd.y1
    public final boolean start() {
        int iC0;
        do {
            iC0 = C0(d0());
            if (iC0 == 0) {
                return false;
            }
        } while (iC0 != 1);
        return true;
    }

    public final void t0(od.f<?> fVar, Object obj) {
        Object objD0;
        do {
            objD0 = d0();
            if (!(objD0 instanceof t1)) {
                if (!(objD0 instanceof c0)) {
                    objD0 = h2.h(objD0);
                }
                fVar.d(objD0);
                return;
            }
        } while (C0(objD0) < 0);
        fVar.a(invokeOnCompletion(new d(fVar)));
    }

    public String toString() {
        return G0() + '@' + q0.b(this);
    }

    public final boolean u(Object obj, l2 l2Var, f2 f2Var) {
        int iS;
        f fVar = new f(f2Var, this, obj);
        do {
            iS = l2Var.n().s(f2Var, l2Var, fVar);
            if (iS == 1) {
                return true;
            }
        } while (iS != 2);
        return false;
    }

    public void u0(Throwable th) {
    }

    public void v0(Object obj) {
    }

    public final void w(Throwable th, List<? extends Throwable> list) throws IllegalAccessException, InvocationTargetException {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th2 : list) {
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                lc.a.a(th, th2);
            }
        }
    }

    public void w0() {
    }

    public void x(Object obj) {
    }

    public final void x0(h1 h1Var) {
        l2 l2Var = new l2();
        Object s1Var = l2Var;
        if (!h1Var.isActive()) {
            s1Var = new s1(l2Var);
        }
        u.b.a(f9176a, this, h1Var, s1Var);
    }

    public final Object y(oc.e<Object> eVar) throws Throwable {
        Object objD0;
        do {
            objD0 = d0();
            if (!(objD0 instanceof t1)) {
                if (objD0 instanceof c0) {
                    throw ((c0) objD0).f9143a;
                }
                return h2.h(objD0);
            }
        } while (C0(objD0) < 0);
        return A(eVar);
    }

    public final void y0(f2 f2Var) {
        f2Var.g(new l2());
        u.b.a(f9176a, this, f2Var, f2Var.m());
    }

    @Override // gd.w
    public final void z(o2 o2Var) throws Throwable {
        F(o2Var);
    }

    public final void z0(od.f<?> fVar, Object obj) {
        if (i0()) {
            fVar.a(invokeOnCompletion(new e(fVar)));
        } else {
            fVar.d(lc.q.f12711a);
        }
    }
}
