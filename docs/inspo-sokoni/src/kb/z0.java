package kb;

/* JADX INFO: loaded from: classes2.dex */
public class z0 implements a1.l {
    @Override // kb.a1.l
    public void b(String str, String str2, a1.g0 g0Var) {
        y0.f12301a.get(str).h(str2);
        g0Var.a();
    }

    @Override // kb.a1.l
    public void i(String str, String str2, String str3, a1.f0<String> f0Var) {
        o7.y0 y0Var = y0.f12301a.get(str);
        f0Var.a((str2 == null || str3 == null) ? y0Var.e() : y0Var.c(str2, str3));
    }
}
