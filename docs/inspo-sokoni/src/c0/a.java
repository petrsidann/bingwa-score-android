package c0;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import o0.e;
import o0.f;
import t.g;

/* JADX INFO: loaded from: classes.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e<ArrayList<T>> f3112a = new f(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g<T, ArrayList<T>> f3113b = new g<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<T> f3114c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<T> f3115d = new HashSet<>();

    public void a(T t10, T t11) {
        if (!this.f3113b.containsKey(t10) || !this.f3113b.containsKey(t11)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayListF = this.f3113b.get(t10);
        if (arrayListF == null) {
            arrayListF = f();
            this.f3113b.put(t10, arrayListF);
        }
        arrayListF.add(t11);
    }

    public void b(T t10) {
        if (this.f3113b.containsKey(t10)) {
            return;
        }
        this.f3113b.put(t10, null);
    }

    public void c() {
        int size = this.f3113b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> arrayListM = this.f3113b.m(i10);
            if (arrayListM != null) {
                k(arrayListM);
            }
        }
        this.f3113b.clear();
    }

    public boolean d(T t10) {
        return this.f3113b.containsKey(t10);
    }

    public final void e(T t10, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t10)) {
            return;
        }
        if (hashSet.contains(t10)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t10);
        ArrayList<T> arrayList2 = this.f3113b.get(t10);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i10 = 0; i10 < size; i10++) {
                e(arrayList2.get(i10), arrayList, hashSet);
            }
        }
        hashSet.remove(t10);
        arrayList.add(t10);
    }

    public final ArrayList<T> f() {
        ArrayList<T> arrayListB = this.f3112a.b();
        return arrayListB == null ? new ArrayList<>() : arrayListB;
    }

    public List g(T t10) {
        return this.f3113b.get(t10);
    }

    public List<T> h(T t10) {
        int size = this.f3113b.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> arrayListM = this.f3113b.m(i10);
            if (arrayListM != null && arrayListM.contains(t10)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f3113b.i(i10));
            }
        }
        return arrayList;
    }

    public ArrayList<T> i() {
        this.f3114c.clear();
        this.f3115d.clear();
        int size = this.f3113b.size();
        for (int i10 = 0; i10 < size; i10++) {
            e(this.f3113b.i(i10), this.f3114c, this.f3115d);
        }
        return this.f3114c;
    }

    public boolean j(T t10) {
        int size = this.f3113b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> arrayListM = this.f3113b.m(i10);
            if (arrayListM != null && arrayListM.contains(t10)) {
                return true;
            }
        }
        return false;
    }

    public final void k(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f3112a.a(arrayList);
    }
}
