package m;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class e extends b implements androidx.appcompat.view.menu.e.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f12798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionBarContextView f12799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b.a f12800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<View> f12801f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f12802l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12803m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public androidx.appcompat.view.menu.e f12804n;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z10) {
        this.f12798c = context;
        this.f12799d = actionBarContextView;
        this.f12800e = aVar;
        androidx.appcompat.view.menu.e eVarS = new androidx.appcompat.view.menu.e(actionBarContextView.getContext()).S(1);
        this.f12804n = eVarS;
        eVarS.R(this);
        this.f12803m = z10;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        return this.f12800e.d(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        k();
        this.f12799d.l();
    }

    @Override // m.b
    public void c() {
        if (this.f12802l) {
            return;
        }
        this.f12802l = true;
        this.f12800e.a(this);
    }

    @Override // m.b
    public View d() {
        WeakReference<View> weakReference = this.f12801f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // m.b
    public Menu e() {
        return this.f12804n;
    }

    @Override // m.b
    public MenuInflater f() {
        return new g(this.f12799d.getContext());
    }

    @Override // m.b
    public CharSequence g() {
        return this.f12799d.getSubtitle();
    }

    @Override // m.b
    public CharSequence i() {
        return this.f12799d.getTitle();
    }

    @Override // m.b
    public void k() {
        this.f12800e.b(this, this.f12804n);
    }

    @Override // m.b
    public boolean l() {
        return this.f12799d.j();
    }

    @Override // m.b
    public void m(View view) {
        this.f12799d.setCustomView(view);
        this.f12801f = view != null ? new WeakReference<>(view) : null;
    }

    @Override // m.b
    public void n(int i10) {
        o(this.f12798c.getString(i10));
    }

    @Override // m.b
    public void o(CharSequence charSequence) {
        this.f12799d.setSubtitle(charSequence);
    }

    @Override // m.b
    public void q(int i10) {
        r(this.f12798c.getString(i10));
    }

    @Override // m.b
    public void r(CharSequence charSequence) {
        this.f12799d.setTitle(charSequence);
    }

    @Override // m.b
    public void s(boolean z10) {
        super.s(z10);
        this.f12799d.setTitleOptional(z10);
    }
}
