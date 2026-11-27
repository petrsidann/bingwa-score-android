package g8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class z0 implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i8.g> f9021a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s7.e<e> f9022b = new s7.e<>(Collections.emptyList(), e.f8707c);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9023c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.google.protobuf.i f9024d = k8.b1.f11651v;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b1 f9025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w0 f9026f;

    public z0(b1 b1Var, c8.j jVar) {
        this.f9025e = b1Var;
        this.f9026f = b1Var.d(jVar);
    }

    @Override // g8.e1
    public void a() {
        if (this.f9021a.isEmpty()) {
            l8.b.d(this.f9022b.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty.", new Object[0]);
        }
    }

    @Override // g8.e1
    public List<i8.g> b(Iterable<h8.k> iterable) {
        s7.e<Integer> eVar = new s7.e<>(Collections.emptyList(), l8.g0.g());
        for (h8.k kVar : iterable) {
            Iterator<e> itJ = this.f9022b.j(new e(kVar, 0));
            while (itJ.hasNext()) {
                e next = itJ.next();
                if (!kVar.equals(next.d())) {
                    break;
                }
                eVar = eVar.i(Integer.valueOf(next.c()));
            }
        }
        return q(eVar);
    }

    @Override // g8.e1
    public i8.g c(h7.q qVar, List<i8.f> list, List<i8.f> list2) {
        l8.b.d(!list2.isEmpty(), "Mutation batches should not be empty", new Object[0]);
        int i10 = this.f9023c;
        this.f9023c = i10 + 1;
        int size = this.f9021a.size();
        if (size > 0) {
            l8.b.d(this.f9021a.get(size - 1).e() < i10, "Mutation batchIds must be monotonically increasing order", new Object[0]);
        }
        i8.g gVar = new i8.g(i10, qVar, list, list2);
        this.f9021a.add(gVar);
        for (i8.f fVar : list2) {
            this.f9022b = this.f9022b.i(new e(fVar.g(), i10));
            this.f9026f.a(fVar.g().q());
        }
        return gVar;
    }

    @Override // g8.e1
    public void d(com.google.protobuf.i iVar) {
        this.f9024d = (com.google.protobuf.i) l8.x.b(iVar);
    }

    @Override // g8.e1
    public void e(i8.g gVar) {
        l8.b.d(o(gVar.e(), "removed") == 0, "Can only remove the first entry of the mutation queue", new Object[0]);
        this.f9021a.remove(0);
        s7.e<e> eVarK = this.f9022b;
        Iterator<i8.f> it = gVar.h().iterator();
        while (it.hasNext()) {
            h8.k kVarG = it.next().g();
            this.f9025e.g().b(kVarG);
            eVarK = eVarK.k(new e(kVarG, gVar.e()));
        }
        this.f9022b = eVarK;
    }

    @Override // g8.e1
    public void f(i8.g gVar, com.google.protobuf.i iVar) {
        int iE = gVar.e();
        int iO = o(iE, "acknowledged");
        l8.b.d(iO == 0, "Can only acknowledge the first batch in the mutation queue", new Object[0]);
        i8.g gVar2 = this.f9021a.get(iO);
        l8.b.d(iE == gVar2.e(), "Queue ordering failure: expected batch %d, got batch %d", Integer.valueOf(iE), Integer.valueOf(gVar2.e()));
        this.f9024d = (com.google.protobuf.i) l8.x.b(iVar);
    }

    @Override // g8.e1
    public i8.g g(int i10) {
        int iN = n(i10 + 1);
        if (iN < 0) {
            iN = 0;
        }
        if (this.f9021a.size() > iN) {
            return this.f9021a.get(iN);
        }
        return null;
    }

    @Override // g8.e1
    public int h() {
        if (this.f9021a.isEmpty()) {
            return -1;
        }
        return this.f9023c - 1;
    }

    @Override // g8.e1
    public i8.g i(int i10) {
        int iN = n(i10);
        if (iN < 0 || iN >= this.f9021a.size()) {
            return null;
        }
        i8.g gVar = this.f9021a.get(iN);
        l8.b.d(gVar.e() == i10, "If found batch must match", new Object[0]);
        return gVar;
    }

    @Override // g8.e1
    public com.google.protobuf.i j() {
        return this.f9024d;
    }

    @Override // g8.e1
    public List<i8.g> k() {
        return Collections.unmodifiableList(this.f9021a);
    }

    public boolean l(h8.k kVar) {
        Iterator<e> itJ = this.f9022b.j(new e(kVar, 0));
        if (itJ.hasNext()) {
            return itJ.next().d().equals(kVar);
        }
        return false;
    }

    public long m(p pVar) {
        Iterator<i8.g> it = this.f9021a.iterator();
        long jD = 0;
        while (it.hasNext()) {
            jD += (long) pVar.o(it.next()).d();
        }
        return jD;
    }

    public final int n(int i10) {
        if (this.f9021a.isEmpty()) {
            return 0;
        }
        return i10 - this.f9021a.get(0).e();
    }

    public final int o(int i10, String str) {
        int iN = n(i10);
        l8.b.d(iN >= 0 && iN < this.f9021a.size(), "Batches must exist to be %s", str);
        return iN;
    }

    public boolean p() {
        return this.f9021a.isEmpty();
    }

    public final List<i8.g> q(s7.e<Integer> eVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = eVar.iterator();
        while (it.hasNext()) {
            i8.g gVarI = i(it.next().intValue());
            if (gVarI != null) {
                arrayList.add(gVarI);
            }
        }
        return arrayList;
    }

    @Override // g8.e1
    public void start() {
        if (p()) {
            this.f9023c = 1;
        }
    }
}
