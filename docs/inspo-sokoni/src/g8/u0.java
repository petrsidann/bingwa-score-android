package g8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class u0 implements m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n1 f8960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b1 f8961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<h8.k> f8962c;

    public u0(b1 b1Var) {
        this.f8961b = b1Var;
    }

    public final boolean a(h8.k kVar) {
        if (this.f8961b.i().k(kVar) || e(kVar)) {
            return true;
        }
        n1 n1Var = this.f8960a;
        return n1Var != null && n1Var.c(kVar);
    }

    @Override // g8.m1
    public void b(h8.k kVar) {
        this.f8962c.add(kVar);
    }

    @Override // g8.m1
    public void c(h8.k kVar) {
        if (a(kVar)) {
            this.f8962c.remove(kVar);
        } else {
            this.f8962c.add(kVar);
        }
    }

    @Override // g8.m1
    public void d() {
        c1 c1VarH = this.f8961b.h();
        ArrayList arrayList = new ArrayList();
        for (h8.k kVar : this.f8962c) {
            if (!a(kVar)) {
                arrayList.add(kVar);
            }
        }
        c1VarH.removeAll(arrayList);
        this.f8962c = null;
    }

    public final boolean e(h8.k kVar) {
        Iterator<z0> it = this.f8961b.r().iterator();
        while (it.hasNext()) {
            if (it.next().l(kVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // g8.m1
    public void f() {
        this.f8962c = new HashSet();
    }

    @Override // g8.m1
    public long h() {
        return -1L;
    }

    @Override // g8.m1
    public void i(n4 n4Var) {
        d1 d1VarI = this.f8961b.i();
        Iterator<h8.k> it = d1VarI.d(n4Var.h()).iterator();
        while (it.hasNext()) {
            this.f8962c.add(it.next());
        }
        d1VarI.q(n4Var);
    }

    @Override // g8.m1
    public void l(n1 n1Var) {
        this.f8960a = n1Var;
    }

    @Override // g8.m1
    public void n(h8.k kVar) {
        this.f8962c.remove(kVar);
    }

    @Override // g8.m1
    public void p(h8.k kVar) {
        this.f8962c.add(kVar);
    }
}
