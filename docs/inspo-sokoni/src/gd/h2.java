package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ld.h0 f9203a = new ld.h0("COMPLETING_ALREADY");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ld.h0 f9204b = new ld.h0("COMPLETING_WAITING_CHILDREN");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ld.h0 f9205c = new ld.h0("COMPLETING_RETRY");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ld.h0 f9206d = new ld.h0("TOO_LATE_TO_CANCEL");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ld.h0 f9207e = new ld.h0("SEALED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h1 f9208f = new h1(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final h1 f9209g = new h1(true);

    public static final Object g(Object obj) {
        return obj instanceof t1 ? new u1((t1) obj) : obj;
    }

    public static final Object h(Object obj) {
        t1 t1Var;
        u1 u1Var = obj instanceof u1 ? (u1) obj : null;
        return (u1Var == null || (t1Var = u1Var.f9263a) == null) ? obj : t1Var;
    }
}
