package yb;

import java.util.ArrayList;
import java.util.List;
import vb.a1;
import vb.o0;
import xb.r0;
import xb.s2;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ac.d f19496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ac.d f19497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ac.d f19498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ac.d f19499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ac.d f19500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ac.d f19501f;

    static {
        oe.g gVar = ac.d.f448g;
        f19496a = new ac.d(gVar, "https");
        f19497b = new ac.d(gVar, "http");
        oe.g gVar2 = ac.d.f446e;
        f19498c = new ac.d(gVar2, "POST");
        f19499d = new ac.d(gVar2, "GET");
        f19500e = new ac.d(r0.f18864j.d(), "application/grpc");
        f19501f = new ac.d("te", "trailers");
    }

    public static List<ac.d> a(List<ac.d> list, a1 a1Var) {
        byte[][] bArrD = s2.d(a1Var);
        for (int i10 = 0; i10 < bArrD.length; i10 += 2) {
            oe.g gVarT = oe.g.t(bArrD[i10]);
            if (gVarT.y() != 0 && gVarT.k(0) != 58) {
                list.add(new ac.d(gVarT, oe.g.t(bArrD[i10 + 1])));
            }
        }
        return list;
    }

    public static List<ac.d> b(a1 a1Var, String str, String str2, String str3, boolean z10, boolean z11) {
        j6.m.p(a1Var, "headers");
        j6.m.p(str, "defaultPath");
        j6.m.p(str2, "authority");
        c(a1Var);
        ArrayList arrayList = new ArrayList(o0.a(a1Var) + 7);
        arrayList.add(z11 ? f19497b : f19496a);
        arrayList.add(z10 ? f19499d : f19498c);
        arrayList.add(new ac.d(ac.d.f449h, str2));
        arrayList.add(new ac.d(ac.d.f447f, str));
        arrayList.add(new ac.d(r0.f18866l.d(), str3));
        arrayList.add(f19500e);
        arrayList.add(f19501f);
        return a(arrayList, a1Var);
    }

    public static void c(a1 a1Var) {
        a1Var.e(r0.f18864j);
        a1Var.e(r0.f18865k);
        a1Var.e(r0.f18866l);
    }
}
