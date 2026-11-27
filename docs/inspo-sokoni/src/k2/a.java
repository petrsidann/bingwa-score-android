package k2;

import gd.m0;
import gd.n0;
import gd.q1;
import gd.y1;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import jd.d;
import kotlin.jvm.internal.k;
import lc.q;
import oc.e;
import qc.f;
import qc.l;
import xc.p;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f11438a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<o0.a<?>, y1> f11439b = new LinkedHashMap();

    /* JADX INFO: renamed from: k2.a$a, reason: collision with other inner class name */
    @f(c = "androidx.window.java.core.CallbackToFlowAdapter$connect$1$1", f = "CallbackToFlowAdapter.kt", l = {46}, m = "invokeSuspend")
    public static final class C0192a extends l implements p<m0, e<? super q>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d<T> f11441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o0.a<T> f11442c;

        /* JADX INFO: renamed from: k2.a$a$a, reason: collision with other inner class name */
        public static final class C0193a<T> implements jd.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ o0.a<T> f11443a;

            public C0193a(o0.a<T> aVar) {
                this.f11443a = aVar;
            }

            @Override // jd.e
            public final Object b(T t10, e<? super q> eVar) {
                this.f11443a.accept(t10);
                return q.f12711a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0192a(d<? extends T> dVar, o0.a<T> aVar, e<? super C0192a> eVar) {
            super(2, eVar);
            this.f11441b = dVar;
            this.f11442c = aVar;
        }

        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(m0 m0Var, e<? super q> eVar) {
            return ((C0192a) create(m0Var, eVar)).invokeSuspend(q.f12711a);
        }

        @Override // qc.a
        public final e<q> create(Object obj, e<?> eVar) {
            return new C0192a(this.f11441b, this.f11442c, eVar);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type oc.e to k2.a$a for r4v1 'this'  oc.e
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // qc.a
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = pc.c.c()
                int r1 = r4.f11440a
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                lc.k.b(r5)
                goto L2c
            Lf:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L17:
                lc.k.b(r5)
                jd.d<T> r5 = r4.f11441b
                k2.a$a$a r1 = new k2.a$a$a
                o0.a<T> r3 = r4.f11442c
                r1.<init>(r3)
                r4.f11440a = r2
                java.lang.Object r5 = r5.a(r1, r4)
                if (r5 != r0) goto L2c
                return r0
            L2c:
                lc.q r5 = lc.q.f12711a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: k2.a.C0192a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final <T> void a(Executor executor, o0.a<T> consumer, d<? extends T> flow) {
        k.e(executor, "executor");
        k.e(consumer, "consumer");
        k.e(flow, "flow");
        ReentrantLock reentrantLock = this.f11438a;
        reentrantLock.lock();
        try {
            if (this.f11439b.get(consumer) == null) {
                this.f11439b.put(consumer, gd.k.d(n0.a(q1.a(executor)), null, null, new C0192a(flow, consumer, null), 3, null));
            }
            q qVar = q.f12711a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void b(o0.a<?> consumer) {
        k.e(consumer, "consumer");
        ReentrantLock reentrantLock = this.f11438a;
        reentrantLock.lock();
        try {
            y1 y1Var = this.f11439b.get(consumer);
            if (y1Var != null) {
                y1.a.b(y1Var, null, 1, null);
            }
            this.f11439b.remove(consumer);
        } finally {
            reentrantLock.unlock();
        }
    }
}
