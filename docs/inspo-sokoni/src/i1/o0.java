package i1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<p> f10313a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, n0> f10314b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Bundle> f10315c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k0 f10316d;

    public void A(k0 k0Var) {
        this.f10316d = k0Var;
    }

    public Bundle B(String str, Bundle bundle) {
        return bundle != null ? this.f10315c.put(str, bundle) : this.f10315c.remove(str);
    }

    public void a(p pVar) {
        if (this.f10313a.contains(pVar)) {
            throw new IllegalStateException("Fragment already added: " + pVar);
        }
        synchronized (this.f10313a) {
            this.f10313a.add(pVar);
        }
        pVar.f10337q = true;
    }

    public void b() {
        this.f10314b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(String str) {
        return this.f10314b.get(str) != null;
    }

    public void d(int i10) {
        for (n0 n0Var : this.f10314b.values()) {
            if (n0Var != null) {
                n0Var.s(i10);
            }
        }
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f10314b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (n0 n0Var : this.f10314b.values()) {
                printWriter.print(str);
                if (n0Var != null) {
                    p pVarK = n0Var.k();
                    printWriter.println(pVarK);
                    pVarK.i(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f10313a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i10 = 0; i10 < size; i10++) {
                p pVar = this.f10313a.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(pVar.toString());
            }
        }
    }

    public p f(String str) {
        n0 n0Var = this.f10314b.get(str);
        if (n0Var != null) {
            return n0Var.k();
        }
        return null;
    }

    public p g(int i10) {
        for (int size = this.f10313a.size() - 1; size >= 0; size--) {
            p pVar = this.f10313a.get(size);
            if (pVar != null && pVar.D == i10) {
                return pVar;
            }
        }
        for (n0 n0Var : this.f10314b.values()) {
            if (n0Var != null) {
                p pVarK = n0Var.k();
                if (pVarK.D == i10) {
                    return pVarK;
                }
            }
        }
        return null;
    }

    public p h(String str) {
        if (str != null) {
            for (int size = this.f10313a.size() - 1; size >= 0; size--) {
                p pVar = this.f10313a.get(size);
                if (pVar != null && str.equals(pVar.F)) {
                    return pVar;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (n0 n0Var : this.f10314b.values()) {
            if (n0Var != null) {
                p pVarK = n0Var.k();
                if (str.equals(pVarK.F)) {
                    return pVarK;
                }
            }
        }
        return null;
    }

    public p i(String str) {
        p pVarL;
        for (n0 n0Var : this.f10314b.values()) {
            if (n0Var != null && (pVarL = n0Var.k().l(str)) != null) {
                return pVarL;
            }
        }
        return null;
    }

    public int j(p pVar) {
        View view;
        View view2;
        ViewGroup viewGroup = pVar.N;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f10313a.indexOf(pVar);
        for (int i10 = iIndexOf - 1; i10 >= 0; i10--) {
            p pVar2 = this.f10313a.get(i10);
            if (pVar2.N == viewGroup && (view2 = pVar2.O) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f10313a.size()) {
                return -1;
            }
            p pVar3 = this.f10313a.get(iIndexOf);
            if (pVar3.N == viewGroup && (view = pVar3.O) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public List<n0> k() {
        ArrayList arrayList = new ArrayList();
        for (n0 n0Var : this.f10314b.values()) {
            if (n0Var != null) {
                arrayList.add(n0Var);
            }
        }
        return arrayList;
    }

    public List<p> l() {
        ArrayList arrayList = new ArrayList();
        Iterator<n0> it = this.f10314b.values().iterator();
        while (it.hasNext()) {
            n0 next = it.next();
            arrayList.add(next != null ? next.k() : null);
        }
        return arrayList;
    }

    public HashMap<String, Bundle> m() {
        return this.f10315c;
    }

    public n0 n(String str) {
        return this.f10314b.get(str);
    }

    public List<p> o() {
        ArrayList arrayList;
        if (this.f10313a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f10313a) {
            arrayList = new ArrayList(this.f10313a);
        }
        return arrayList;
    }

    public k0 p() {
        return this.f10316d;
    }

    public Bundle q(String str) {
        return this.f10315c.get(str);
    }

    public void r(n0 n0Var) {
        p pVarK = n0Var.k();
        if (c(pVarK.f10328f)) {
            return;
        }
        this.f10314b.put(pVarK.f10328f, n0Var);
        if (pVarK.J) {
            if (pVarK.I) {
                this.f10316d.d(pVarK);
            } else {
                this.f10316d.n(pVarK);
            }
            pVarK.J = false;
        }
        if (h0.I0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + pVarK);
        }
    }

    public void s(n0 n0Var) {
        p pVarK = n0Var.k();
        if (pVarK.I) {
            this.f10316d.n(pVarK);
        }
        if (this.f10314b.get(pVarK.f10328f) == n0Var && this.f10314b.put(pVarK.f10328f, null) != null && h0.I0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + pVarK);
        }
    }

    public void t() {
        Iterator<p> it = this.f10313a.iterator();
        while (it.hasNext()) {
            n0 n0Var = this.f10314b.get(it.next().f10328f);
            if (n0Var != null) {
                n0Var.m();
            }
        }
        for (n0 n0Var2 : this.f10314b.values()) {
            if (n0Var2 != null) {
                n0Var2.m();
                p pVarK = n0Var2.k();
                if (pVarK.f10338r && !pVarK.c0()) {
                    if (pVarK.f10340t && !this.f10315c.containsKey(pVarK.f10328f)) {
                        B(pVarK.f10328f, n0Var2.q());
                    }
                    s(n0Var2);
                }
            }
        }
    }

    public void u(p pVar) {
        synchronized (this.f10313a) {
            this.f10313a.remove(pVar);
        }
        pVar.f10337q = false;
    }

    public void v() {
        this.f10314b.clear();
    }

    public void w(List<String> list) {
        this.f10313a.clear();
        if (list != null) {
            for (String str : list) {
                p pVarF = f(str);
                if (pVarF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (h0.I0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + pVarF);
                }
                a(pVarF);
            }
        }
    }

    public void x(HashMap<String, Bundle> map) {
        this.f10315c.clear();
        this.f10315c.putAll(map);
    }

    public ArrayList<String> y() {
        ArrayList<String> arrayList = new ArrayList<>(this.f10314b.size());
        for (n0 n0Var : this.f10314b.values()) {
            if (n0Var != null) {
                p pVarK = n0Var.k();
                B(pVarK.f10328f, n0Var.q());
                arrayList.add(pVarK.f10328f);
                if (h0.I0(2)) {
                    Log.v("FragmentManager", "Saved state of " + pVarK + ": " + pVarK.f10320b);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<String> z() {
        synchronized (this.f10313a) {
            if (this.f10313a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f10313a.size());
            for (p pVar : this.f10313a) {
                arrayList.add(pVar.f10328f);
                if (h0.I0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + pVar.f10328f + "): " + pVar);
                }
            }
            return arrayList;
        }
    }
}
