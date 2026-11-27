package ld;

import gd.v2;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f12738a = new h0("NO_THREAD_ELEMENTS");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final xc.p<Object, oc.i.b, Object> f12739b = a.f12742a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final xc.p<v2<?>, oc.i.b, v2<?>> f12740c = b.f12743a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final xc.p<p0, oc.i.b, p0> f12741d = c.f12744a;

    public static final class a extends kotlin.jvm.internal.l implements xc.p<Object, oc.i.b, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12742a = new a();

        public a() {
            super(2);
        }

        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, oc.i.b bVar) {
            if (!(bVar instanceof v2)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
        }
    }

    public static final class b extends kotlin.jvm.internal.l implements xc.p<v2<?>, oc.i.b, v2<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f12743a = new b();

        public b() {
            super(2);
        }

        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final v2<?> invoke(v2<?> v2Var, oc.i.b bVar) {
            if (v2Var != null) {
                return v2Var;
            }
            if (bVar instanceof v2) {
                return (v2) bVar;
            }
            return null;
        }
    }

    public static final class c extends kotlin.jvm.internal.l implements xc.p<p0, oc.i.b, p0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f12744a = new c();

        public c() {
            super(2);
        }

        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p0 invoke(p0 p0Var, oc.i.b bVar) {
            if (bVar instanceof v2) {
                v2<?> v2Var = (v2) bVar;
                p0Var.a(v2Var, v2Var.B(p0Var.f12756a));
            }
            return p0Var;
        }
    }

    public static final void a(oc.i iVar, Object obj) {
        if (obj == f12738a) {
            return;
        }
        if (obj instanceof p0) {
            ((p0) obj).b(iVar);
            return;
        }
        Object objFold = iVar.fold(null, f12740c);
        kotlin.jvm.internal.k.c(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((v2) objFold).O(iVar, obj);
    }

    public static final Object b(oc.i iVar) {
        Object objFold = iVar.fold(0, f12739b);
        kotlin.jvm.internal.k.b(objFold);
        return objFold;
    }

    public static final Object c(oc.i iVar, Object obj) {
        if (obj == null) {
            obj = b(iVar);
        }
        if (obj == 0) {
            return f12738a;
        }
        if (obj instanceof Integer) {
            return iVar.fold(new p0(iVar, ((Number) obj).intValue()), f12741d);
        }
        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((v2) obj).B(iVar);
    }
}
