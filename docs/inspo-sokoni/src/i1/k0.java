package i1;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class k0 extends androidx.lifecycle.f0 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final androidx.lifecycle.g0.b f10257k = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f10261g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, p> f10258d = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, k0> f10259e = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, androidx.lifecycle.i0> f10260f = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10262h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10263i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10264j = false;

    public class a implements androidx.lifecycle.g0.b {
        @Override // androidx.lifecycle.g0.b
        public <T extends androidx.lifecycle.f0> T a(Class<T> cls) {
            return new k0(true);
        }
    }

    public k0(boolean z10) {
        this.f10261g = z10;
    }

    public static k0 j(androidx.lifecycle.i0 i0Var) {
        return (k0) new androidx.lifecycle.g0(i0Var, f10257k).a(k0.class);
    }

    @Override // androidx.lifecycle.f0
    public void c() {
        if (h0.I0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f10262h = true;
    }

    public void d(p pVar) {
        if (this.f10264j) {
            if (h0.I0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f10258d.containsKey(pVar.f10328f)) {
                return;
            }
            this.f10258d.put(pVar.f10328f, pVar);
            if (h0.I0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + pVar);
            }
        }
    }

    public void e(p pVar, boolean z10) {
        if (h0.I0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + pVar);
        }
        g(pVar.f10328f, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k0.class != obj.getClass()) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return this.f10258d.equals(k0Var.f10258d) && this.f10259e.equals(k0Var.f10259e) && this.f10260f.equals(k0Var.f10260f);
    }

    public void f(String str, boolean z10) {
        if (h0.I0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        g(str, z10);
    }

    public final void g(String str, boolean z10) {
        k0 k0Var = this.f10259e.get(str);
        if (k0Var != null) {
            if (z10) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(k0Var.f10259e.keySet());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    k0Var.f((String) it.next(), true);
                }
            }
            k0Var.c();
            this.f10259e.remove(str);
        }
        androidx.lifecycle.i0 i0Var = this.f10260f.get(str);
        if (i0Var != null) {
            i0Var.a();
            this.f10260f.remove(str);
        }
    }

    public p h(String str) {
        return this.f10258d.get(str);
    }

    public int hashCode() {
        return (((this.f10258d.hashCode() * 31) + this.f10259e.hashCode()) * 31) + this.f10260f.hashCode();
    }

    public k0 i(p pVar) {
        k0 k0Var = this.f10259e.get(pVar.f10328f);
        if (k0Var != null) {
            return k0Var;
        }
        k0 k0Var2 = new k0(this.f10261g);
        this.f10259e.put(pVar.f10328f, k0Var2);
        return k0Var2;
    }

    public Collection<p> k() {
        return new ArrayList(this.f10258d.values());
    }

    public androidx.lifecycle.i0 l(p pVar) {
        androidx.lifecycle.i0 i0Var = this.f10260f.get(pVar.f10328f);
        if (i0Var != null) {
            return i0Var;
        }
        androidx.lifecycle.i0 i0Var2 = new androidx.lifecycle.i0();
        this.f10260f.put(pVar.f10328f, i0Var2);
        return i0Var2;
    }

    public boolean m() {
        return this.f10262h;
    }

    public void n(p pVar) {
        if (this.f10264j) {
            if (h0.I0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        if ((this.f10258d.remove(pVar.f10328f) != null) && h0.I0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + pVar);
        }
    }

    public void o(boolean z10) {
        this.f10264j = z10;
    }

    public boolean p(p pVar) {
        if (this.f10258d.containsKey(pVar.f10328f)) {
            return this.f10261g ? this.f10262h : !this.f10263i;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator<p> it = this.f10258d.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator<String> it2 = this.f10259e.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator<String> it3 = this.f10260f.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append(it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
