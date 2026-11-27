package i;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import e0.n1;
import i1.u;

/* JADX INFO: loaded from: classes.dex */
public class b extends u implements c, n1.a {
    public e E;
    public Resources F;

    public class a implements b2.d.c {
        public a() {
        }

        @Override // b2.d.c
        public Bundle a() {
            Bundle bundle = new Bundle();
            b.this.d0().B(bundle);
            return bundle;
        }
    }

    /* JADX INFO: renamed from: i.b$b, reason: collision with other inner class name */
    public class C0166b implements e.b {
        public C0166b() {
        }

        @Override // e.b
        public void a(Context context) {
            e eVarD0 = b.this.d0();
            eVarD0.s();
            eVarD0.x(b.this.v().b("androidx:appcompat"));
        }
    }

    public b() {
        f0();
    }

    @Override // d.h, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        g0();
        d0().e(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(d0().g(context));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        i.a aVarE0 = e0();
        if (getWindow().hasFeature(0)) {
            if (aVarE0 == null || !aVarE0.f()) {
                super.closeOptionsMenu();
            }
        }
    }

    public e d0() {
        if (this.E == null) {
            this.E = e.h(this, this);
        }
        return this.E;
    }

    @Override // e0.k, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        i.a aVarE0 = e0();
        if (keyCode == 82 && aVarE0 != null && aVarE0.o(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public i.a e0() {
        return d0().r();
    }

    @Override // i.c
    public void f(m.b bVar) {
    }

    public final void f0() {
        v().h("androidx:appcompat", new a());
        D(new C0166b());
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i10) {
        return (T) d0().j(i10);
    }

    public final void g0() {
        k0.a(getWindow().getDecorView(), this);
        l0.a(getWindow().getDecorView(), this);
        b2.g.a(getWindow().getDecorView(), this);
        d.u.a(getWindow().getDecorView(), this);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return d0().p();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.F == null && androidx.appcompat.widget.n1.c()) {
            this.F = new androidx.appcompat.widget.n1(this, super.getResources());
        }
        Resources resources = this.F;
        return resources == null ? super.getResources() : resources;
    }

    public void h0(n1 n1Var) {
        n1Var.h(this);
    }

    public void i0(l0.j jVar) {
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        d0().t();
    }

    public void j0(int i10) {
    }

    public void k0(n1 n1Var) {
    }

    @Override // e0.n1.a
    public Intent l() {
        return e0.o.a(this);
    }

    @Deprecated
    public void l0() {
    }

    public boolean m0() {
        Intent intentL = l();
        if (intentL == null) {
            return false;
        }
        if (!p0(intentL)) {
            o0(intentL);
            return true;
        }
        n1 n1VarJ = n1.j(this);
        h0(n1VarJ);
        k0(n1VarJ);
        n1VarJ.k();
        try {
            e0.b.b(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    public final boolean n0(KeyEvent keyEvent) {
        return false;
    }

    @Override // i.c
    public void o(m.b bVar) {
    }

    public void o0(Intent intent) {
        e0.o.e(this, intent);
    }

    @Override // d.h, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d0().w(configuration);
        if (this.F != null) {
            this.F.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        l0();
    }

    @Override // i1.u, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d0().y();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (n0(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // i1.u, d.h, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        i.a aVarE0 = e0();
        if (menuItem.getItemId() != 16908332 || aVarE0 == null || (aVarE0.i() & 4) == 0) {
            return false;
        }
        return m0();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i10, Menu menu) {
        return super.onMenuOpened(i10, menu);
    }

    @Override // d.h, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        d0().z(bundle);
    }

    @Override // i1.u, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        d0().A();
    }

    @Override // i1.u, android.app.Activity
    public void onStart() {
        super.onStart();
        d0().C();
    }

    @Override // i1.u, android.app.Activity
    public void onStop() {
        super.onStop();
        d0().D();
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i10) {
        super.onTitleChanged(charSequence, i10);
        d0().M(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        i.a aVarE0 = e0();
        if (getWindow().hasFeature(0)) {
            if (aVarE0 == null || !aVarE0.p()) {
                super.openOptionsMenu();
            }
        }
    }

    public boolean p0(Intent intent) {
        return e0.o.f(this, intent);
    }

    @Override // i.c
    public m.b q(m.b.a aVar) {
        return null;
    }

    @Override // d.h, android.app.Activity
    public void setContentView(int i10) {
        g0();
        d0().H(i10);
    }

    @Override // d.h, android.app.Activity
    public void setContentView(View view) {
        g0();
        d0().I(view);
    }

    @Override // d.h, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        g0();
        d0().J(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        super.setTheme(i10);
        d0().L(i10);
    }
}
