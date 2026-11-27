package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w2 f9268a = new w2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<i1> f9269b = ld.m0.a(new ld.h0("ThreadLocalEventLoop"));

    public final i1 a() {
        return f9269b.get();
    }

    public final i1 b() {
        ThreadLocal<i1> threadLocal = f9269b;
        i1 i1Var = threadLocal.get();
        if (i1Var != null) {
            return i1Var;
        }
        i1 i1VarA = l1.a();
        threadLocal.set(i1VarA);
        return i1VarA;
    }

    public final void c() {
        f9269b.set(null);
    }

    public final void d(i1 i1Var) {
        f9269b.set(i1Var);
    }
}
