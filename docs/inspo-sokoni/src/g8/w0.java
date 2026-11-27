package g8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class w0 implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f8982a = new a();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<String, HashSet<h8.t>> f8983a = new HashMap<>();

        public boolean a(h8.t tVar) {
            l8.b.d(tVar.u() % 2 == 1, "Expected a collection path.", new Object[0]);
            String strP = tVar.p();
            h8.t tVarW = tVar.w();
            HashSet<h8.t> hashSet = this.f8983a.get(strP);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.f8983a.put(strP, hashSet);
            }
            return hashSet.add(tVarW);
        }

        public List<h8.t> b(String str) {
            HashSet<h8.t> hashSet = this.f8983a.get(str);
            return hashSet != null ? new ArrayList(hashSet) : Collections.emptyList();
        }
    }

    @Override // g8.m
    public void a(h8.t tVar) {
        this.f8982a.a(tVar);
    }

    @Override // g8.m
    public void b(e8.g1 g1Var) {
    }

    @Override // g8.m
    public void c(h8.p pVar) {
    }

    @Override // g8.m
    public List<h8.k> d(e8.g1 g1Var) {
        return null;
    }

    @Override // g8.m
    public void e(s7.c<h8.k, h8.h> cVar) {
    }

    @Override // g8.m
    public Collection<h8.p> f() {
        return Collections.emptyList();
    }

    @Override // g8.m
    public String g() {
        return null;
    }

    @Override // g8.m
    public List<h8.t> h(String str) {
        return this.f8982a.b(str);
    }

    @Override // g8.m
    public void i() {
    }

    @Override // g8.m
    public void j(String str, h8.p.a aVar) {
    }

    @Override // g8.m
    public m.a k(e8.g1 g1Var) {
        return m.a.NONE;
    }

    @Override // g8.m
    public h8.p.a l(String str) {
        return h8.p.a.f9751a;
    }

    @Override // g8.m
    public h8.p.a m(e8.g1 g1Var) {
        return h8.p.a.f9751a;
    }

    @Override // g8.m
    public void n(h8.p pVar) {
    }

    @Override // g8.m
    public void start() {
    }
}
