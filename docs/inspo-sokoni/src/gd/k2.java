package gd;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k2 extends j0 {
    public abstract k2 f0();

    public final String g0() {
        k2 k2VarF0;
        k2 k2VarC = c1.c();
        if (this == k2VarC) {
            return "Dispatchers.Main";
        }
        try {
            k2VarF0 = k2VarC.f0();
        } catch (UnsupportedOperationException unused) {
            k2VarF0 = null;
        }
        if (this == k2VarF0) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // gd.j0
    public String toString() {
        String strG0 = g0();
        if (strG0 != null) {
            return strG0;
        }
        return q0.a(this) + '@' + q0.b(this);
    }
}
