package xb;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class v1 extends vb.u0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f19025b;

    static {
        f19025b = !j6.q.a(System.getenv("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST")) && Boolean.parseBoolean(System.getenv("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST"));
    }

    @Override // vb.t0.c
    public vb.t0 a(vb.t0.e eVar) {
        return f19025b ? new s1(eVar) : new u1(eVar);
    }

    @Override // vb.u0
    public String b() {
        return "pick_first";
    }

    @Override // vb.u0
    public int c() {
        return 5;
    }

    @Override // vb.u0
    public boolean d() {
        return true;
    }

    @Override // vb.u0
    public vb.c1.c e(Map<String, ?> map) {
        try {
            return vb.c1.c.a(new u1.c(b1.d(map, "shuffleAddressList")));
        } catch (RuntimeException e10) {
            return vb.c1.c.b(vb.l1.f17420t.p(e10).q("Failed parsing configuration for " + b()));
        }
    }
}
