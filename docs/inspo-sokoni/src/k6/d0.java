package k6;

/* JADX INFO: loaded from: classes.dex */
public final class d0 {
    public static boolean a(c0<?, ?> c0Var, Object obj) {
        if (obj == c0Var) {
            return true;
        }
        if (obj instanceof c0) {
            return c0Var.a().equals(((c0) obj).a());
        }
        return false;
    }
}
