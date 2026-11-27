package vb;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y0 {

    public static final class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static y0 d() {
        y0 y0VarD = z0.b().d();
        if (y0VarD != null) {
            return y0VarD;
        }
        throw new a("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
    }

    public abstract x0<?> a(String str);

    public abstract boolean b();

    public abstract int c();
}
