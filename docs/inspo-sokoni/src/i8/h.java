package i8;

import h8.v;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f10534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f10535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<i> f10536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.protobuf.i f10537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s7.c<h8.k, v> f10538e;

    public h(g gVar, v vVar, List<i> list, com.google.protobuf.i iVar, s7.c<h8.k, v> cVar) {
        this.f10534a = gVar;
        this.f10535b = vVar;
        this.f10536c = list;
        this.f10537d = iVar;
        this.f10538e = cVar;
    }

    public static h a(g gVar, v vVar, List<i> list, com.google.protobuf.i iVar) {
        l8.b.d(gVar.h().size() == list.size(), "Mutations sent %d must equal results received %d", Integer.valueOf(gVar.h().size()), Integer.valueOf(list.size()));
        s7.c<h8.k, v> cVarC = h8.i.c();
        List<f> listH = gVar.h();
        s7.c<h8.k, v> cVarL = cVarC;
        for (int i10 = 0; i10 < listH.size(); i10++) {
            cVarL = cVarL.l(listH.get(i10).g(), list.get(i10).b());
        }
        return new h(gVar, vVar, list, iVar, cVarL);
    }

    public g b() {
        return this.f10534a;
    }

    public v c() {
        return this.f10535b;
    }

    public s7.c<h8.k, v> d() {
        return this.f10538e;
    }

    public List<i> e() {
        return this.f10536c;
    }

    public com.google.protobuf.i f() {
        return this.f10537d;
    }
}
