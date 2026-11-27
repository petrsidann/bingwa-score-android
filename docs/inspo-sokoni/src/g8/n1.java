package g8;

import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s7.e<e> f8878a = new s7.e<>(Collections.emptyList(), e.f8707c);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s7.e<e> f8879b = new s7.e<>(Collections.emptyList(), e.f8708d);

    public void a(h8.k kVar, int i10) {
        e eVar = new e(kVar, i10);
        this.f8878a = this.f8878a.i(eVar);
        this.f8879b = this.f8879b.i(eVar);
    }

    public void b(s7.e<h8.k> eVar, int i10) {
        Iterator<h8.k> it = eVar.iterator();
        while (it.hasNext()) {
            a(it.next(), i10);
        }
    }

    public boolean c(h8.k kVar) {
        Iterator<e> itJ = this.f8878a.j(new e(kVar, 0));
        if (itJ.hasNext()) {
            return itJ.next().d().equals(kVar);
        }
        return false;
    }

    public s7.e<h8.k> d(int i10) {
        Iterator<e> itJ = this.f8879b.j(new e(h8.k.i(), i10));
        s7.e<h8.k> eVarK = h8.k.k();
        while (itJ.hasNext()) {
            e next = itJ.next();
            if (next.c() != i10) {
                break;
            }
            eVarK = eVarK.i(next.d());
        }
        return eVarK;
    }

    public final void e(e eVar) {
        this.f8878a = this.f8878a.k(eVar);
        this.f8879b = this.f8879b.k(eVar);
    }

    public void f(h8.k kVar, int i10) {
        e(new e(kVar, i10));
    }

    public void g(s7.e<h8.k> eVar, int i10) {
        Iterator<h8.k> it = eVar.iterator();
        while (it.hasNext()) {
            f(it.next(), i10);
        }
    }

    public s7.e<h8.k> h(int i10) {
        Iterator<e> itJ = this.f8879b.j(new e(h8.k.i(), i10));
        s7.e<h8.k> eVarK = h8.k.k();
        while (itJ.hasNext()) {
            e next = itJ.next();
            if (next.c() != i10) {
                break;
            }
            eVarK = eVarK.i(next.d());
            e(next);
        }
        return eVarK;
    }
}
