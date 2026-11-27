package ld;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public final class z {

    public static final class a extends kotlin.jvm.internal.l implements xc.l<Throwable, lc.q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ xc.l<E, lc.q> f12782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ E f12783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ oc.i f12784c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(xc.l<? super E, lc.q> lVar, E e10, oc.i iVar) {
            super(1);
            this.f12782a = lVar;
            this.f12783b = e10;
            this.f12784c = iVar;
        }

        public final void a(Throwable th) throws IllegalAccessException, InvocationTargetException {
            z.b(this.f12782a, this.f12783b, this.f12784c);
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) throws IllegalAccessException, InvocationTargetException {
            a(th);
            return lc.q.f12711a;
        }
    }

    public static final <E> xc.l<Throwable, lc.q> a(xc.l<? super E, lc.q> lVar, E e10, oc.i iVar) {
        return new a(lVar, e10, iVar);
    }

    public static final <E> void b(xc.l<? super E, lc.q> lVar, E e10, oc.i iVar) throws IllegalAccessException, InvocationTargetException {
        q0 q0VarC = c(lVar, e10, null);
        if (q0VarC != null) {
            gd.l0.a(iVar, q0VarC);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> q0 c(xc.l<? super E, lc.q> lVar, E e10, q0 q0Var) throws IllegalAccessException, InvocationTargetException {
        try {
            lVar.invoke(e10);
        } catch (Throwable th) {
            if (q0Var == null || q0Var.getCause() == th) {
                return new q0("Exception in undelivered element handler for " + e10, th);
            }
            lc.a.a(q0Var, th);
        }
        return q0Var;
    }

    public static /* synthetic */ q0 d(xc.l lVar, Object obj, q0 q0Var, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            q0Var = null;
        }
        return c(lVar, obj, q0Var);
    }
}
