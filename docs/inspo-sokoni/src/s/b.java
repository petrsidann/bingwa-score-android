package s;

import android.content.res.ColorStateList;

/* JADX INFO: loaded from: classes.dex */
public class b implements d {
    @Override // s.d
    public void a(c cVar, float f10) {
        cVar.e().setElevation(f10);
    }

    @Override // s.d
    public float b(c cVar) {
        return n(cVar).d();
    }

    @Override // s.d
    public float c(c cVar) {
        return b(cVar) * 2.0f;
    }

    @Override // s.d
    public void d(c cVar) {
        l(cVar, e(cVar));
    }

    @Override // s.d
    public float e(c cVar) {
        return n(cVar).c();
    }

    @Override // s.d
    public void f(c cVar) {
        l(cVar, e(cVar));
    }

    @Override // s.d
    public float g(c cVar) {
        return b(cVar) * 2.0f;
    }

    @Override // s.d
    public float h(c cVar) {
        return cVar.e().getElevation();
    }

    @Override // s.d
    public void i() {
    }

    @Override // s.d
    public void j(c cVar, float f10) {
        n(cVar).h(f10);
    }

    @Override // s.d
    public ColorStateList k(c cVar) {
        return n(cVar).b();
    }

    @Override // s.d
    public void l(c cVar, float f10) {
        n(cVar).g(f10, cVar.c(), cVar.b());
        o(cVar);
    }

    @Override // s.d
    public void m(c cVar, ColorStateList colorStateList) {
        n(cVar).f(colorStateList);
    }

    public final e n(c cVar) {
        return (e) cVar.d();
    }

    public void o(c cVar) {
        if (!cVar.c()) {
            cVar.a(0, 0, 0, 0);
            return;
        }
        float fE = e(cVar);
        float fB = b(cVar);
        int iCeil = (int) Math.ceil(f.a(fE, fB, cVar.b()));
        int iCeil2 = (int) Math.ceil(f.b(fE, fB, cVar.b()));
        cVar.a(iCeil, iCeil2, iCeil, iCeil2);
    }
}
