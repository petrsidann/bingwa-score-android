package n;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t.g<j0.b, MenuItem> f13358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t.g<j0.c, SubMenu> f13359c;

    public b(Context context) {
        this.f13357a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof j0.b)) {
            return menuItem;
        }
        j0.b bVar = (j0.b) menuItem;
        if (this.f13358b == null) {
            this.f13358b = new t.g<>();
        }
        MenuItem menuItem2 = this.f13358b.get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        c cVar = new c(this.f13357a, bVar);
        this.f13358b.put(bVar, cVar);
        return cVar;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof j0.c)) {
            return subMenu;
        }
        j0.c cVar = (j0.c) subMenu;
        if (this.f13359c == null) {
            this.f13359c = new t.g<>();
        }
        SubMenu subMenu2 = this.f13359c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        g gVar = new g(this.f13357a, cVar);
        this.f13359c.put(cVar, gVar);
        return gVar;
    }

    public final void e() {
        t.g<j0.b, MenuItem> gVar = this.f13358b;
        if (gVar != null) {
            gVar.clear();
        }
        t.g<j0.c, SubMenu> gVar2 = this.f13359c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    public final void f(int i10) {
        if (this.f13358b == null) {
            return;
        }
        int i11 = 0;
        while (i11 < this.f13358b.size()) {
            if (this.f13358b.i(i11).getGroupId() == i10) {
                this.f13358b.k(i11);
                i11--;
            }
            i11++;
        }
    }

    public final void g(int i10) {
        if (this.f13358b == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f13358b.size(); i11++) {
            if (this.f13358b.i(i11).getItemId() == i10) {
                this.f13358b.k(i11);
                return;
            }
        }
    }
}
