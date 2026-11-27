package p0;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f14067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<y> f14068b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<y, a> f14069c = new HashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.lifecycle.g f14070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.lifecycle.i f14071b;

        public void a() {
            this.f14070a.c(this.f14071b);
            this.f14071b = null;
        }
    }

    public w(Runnable runnable) {
        this.f14067a = runnable;
    }

    public void a(y yVar) {
        this.f14068b.add(yVar);
        this.f14067a.run();
    }

    public void b(Menu menu, MenuInflater menuInflater) {
        Iterator<y> it = this.f14068b.iterator();
        while (it.hasNext()) {
            it.next().c(menu, menuInflater);
        }
    }

    public void c(Menu menu) {
        Iterator<y> it = this.f14068b.iterator();
        while (it.hasNext()) {
            it.next().b(menu);
        }
    }

    public boolean d(MenuItem menuItem) {
        Iterator<y> it = this.f14068b.iterator();
        while (it.hasNext()) {
            if (it.next().a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void e(Menu menu) {
        Iterator<y> it = this.f14068b.iterator();
        while (it.hasNext()) {
            it.next().d(menu);
        }
    }

    public void f(y yVar) {
        this.f14068b.remove(yVar);
        a aVarRemove = this.f14069c.remove(yVar);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.f14067a.run();
    }
}
