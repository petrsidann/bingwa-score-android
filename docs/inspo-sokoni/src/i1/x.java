package i1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z<?> f10453a;

    public x(z<?> zVar) {
        this.f10453a = zVar;
    }

    public static x b(z<?> zVar) {
        return new x((z) o0.h.h(zVar, "callbacks == null"));
    }

    public void a(p pVar) {
        h0 h0VarQ = this.f10453a.q();
        z<?> zVar = this.f10453a;
        h0VarQ.l(zVar, zVar, pVar);
    }

    public void c() {
        this.f10453a.q().x();
    }

    public boolean d(MenuItem menuItem) {
        return this.f10453a.q().A(menuItem);
    }

    public void e() {
        this.f10453a.q().B();
    }

    public void f() {
        this.f10453a.q().D();
    }

    public void g() {
        this.f10453a.q().M();
    }

    public void h() {
        this.f10453a.q().Q();
    }

    public void i() {
        this.f10453a.q().R();
    }

    public void j() {
        this.f10453a.q().T();
    }

    public boolean k() {
        return this.f10453a.q().a0(true);
    }

    public h0 l() {
        return this.f10453a.q();
    }

    public void m() {
        this.f10453a.q().X0();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f10453a.q().w0().onCreateView(view, str, context, attributeSet);
    }
}
