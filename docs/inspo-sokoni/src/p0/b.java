package p0;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f13928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0241b f13929c;

    public interface a {
    }

    /* JADX INFO: renamed from: p0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0241b {
        void onActionProviderVisibilityChanged(boolean z10);
    }

    public b(Context context) {
        this.f13927a = context;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.f13929c = null;
        this.f13928b = null;
    }

    public void i(a aVar) {
        this.f13928b = aVar;
    }

    public void j(InterfaceC0241b interfaceC0241b) {
        if (this.f13929c != null && interfaceC0241b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f13929c = interfaceC0241b;
    }
}
