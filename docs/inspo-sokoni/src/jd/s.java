package jd;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ld.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class s<T> extends kd.b<u> implements n<T>, d, kd.k<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f11380e = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_state");
    private volatile Object _state;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11381d;

    @qc.f(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {384, 396, 401}, m = "collect")
    public static final class a extends qc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f11382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f11383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f11384c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f11385d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f11386e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public /* synthetic */ Object f11387f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ s<T> f11388l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11389m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(s<T> sVar, oc.e<? super a> eVar) {
            super(eVar);
            this.f11388l = sVar;
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f11387f = obj;
            this.f11389m |= Integer.MIN_VALUE;
            return this.f11388l.a(null, this);
        }
    }

    public s(Object obj) {
        this._state = obj;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00ae A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00ae, B:38:0x00b3, B:48:0x00d4, B:50:0x00da, B:40:0x00b9, B:44:0x00c0, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00b3 A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00ae, B:38:0x00b3, B:48:0x00d4, B:50:0x00da, B:40:0x00b9, B:44:0x00c0, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b9 A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00ae, B:38:0x00b3, B:48:0x00d4, B:50:0x00da, B:40:0x00b9, B:44:0x00c0, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:43:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:50:0x00da A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00ae, B:38:0x00b3, B:48:0x00d4, B:50:0x00da, B:40:0x00b9, B:44:0x00c0, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00ec A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kd.d] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object, jd.u] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object, jd.e] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00d8 -> B:34:0x00a6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00ea -> B:34:0x00a6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0026
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // jd.d
    public java.lang.Object a(jd.e<? super T> r11, oc.e<?> r12) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jd.s.a(jd.e, oc.e):java.lang.Object");
    }

    @Override // jd.e
    public Object b(T t10, oc.e<? super lc.q> eVar) {
        setValue(t10);
        return lc.q.f12711a;
    }

    @Override // kd.k
    public d<T> c(oc.i iVar, int i10, id.a aVar) {
        return t.d(this, iVar, i10, aVar);
    }

    @Override // jd.n
    public T getValue() {
        h0 h0Var = kd.m.f12341a;
        T t10 = (T) f11380e.get(this);
        if (t10 == h0Var) {
            return null;
        }
        return t10;
    }

    @Override // kd.b
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public u e() {
        return new u();
    }

    @Override // kd.b
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public u[] f(int i10) {
        return new u[i10];
    }

    public final boolean k(Object obj, Object obj2) {
        int i10;
        u[] uVarArrH;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11380e;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !kotlin.jvm.internal.k.a(obj3, obj)) {
                return false;
            }
            if (kotlin.jvm.internal.k.a(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i11 = this.f11381d;
            if ((i11 & 1) != 0) {
                this.f11381d = i11 + 2;
                return true;
            }
            int i12 = i11 + 1;
            this.f11381d = i12;
            u[] uVarArrH2 = h();
            lc.q qVar = lc.q.f12711a;
            while (true) {
                u[] uVarArr = uVarArrH2;
                if (uVarArr != null) {
                    for (u uVar : uVarArr) {
                        if (uVar != null) {
                            uVar.g();
                        }
                    }
                }
                synchronized (this) {
                    i10 = this.f11381d;
                    if (i10 == i12) {
                        this.f11381d = i12 + 1;
                        return true;
                    }
                    uVarArrH = h();
                    lc.q qVar2 = lc.q.f12711a;
                }
                uVarArrH2 = uVarArrH;
                i12 = i10;
            }
        }
    }

    @Override // jd.n
    public void setValue(T t10) {
        if (t10 == null) {
            t10 = (T) kd.m.f12341a;
        }
        k(null, t10);
    }
}
