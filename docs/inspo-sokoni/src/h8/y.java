package h8;

import com.google.protobuf.f1;
import com.google.protobuf.u1;
import d9.d0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import l8.g0;

/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f9783a = d0.B0().L(Double.NaN).build();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0 f9784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d0 f9785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d0 f9786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d0 f9787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d0 f9788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d0 f9789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static d0 f9790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static d0 f9791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static d0 f9792j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static d0 f9793k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static d0 f9794l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static d0 f9795m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static d0 f9796n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static d0 f9797o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static d0 f9798p;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9799a;

        static {
            int[] iArr = new int[d0.c.values().length];
            f9799a = iArr;
            try {
                iArr[d0.c.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9799a[d0.c.BOOLEAN_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9799a[d0.c.INTEGER_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9799a[d0.c.DOUBLE_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9799a[d0.c.TIMESTAMP_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9799a[d0.c.STRING_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9799a[d0.c.BYTES_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9799a[d0.c.REFERENCE_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9799a[d0.c.GEO_POINT_VALUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9799a[d0.c.ARRAY_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f9799a[d0.c.MAP_VALUE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    static {
        d0 d0VarBuild = d0.B0().Q(f1.NULL_VALUE).build();
        f9784b = d0VarBuild;
        f9785c = d0VarBuild;
        d0 d0VarBuild2 = d0.B0().S("__max__").build();
        f9786d = d0VarBuild2;
        f9787e = d0.B0().O(d9.u.n0().H("__type__", d0VarBuild2)).build();
        d0 d0VarBuild3 = d0.B0().S("__vector__").build();
        f9788f = d0VarBuild3;
        f9789g = d0.B0().O(d9.u.n0().H("__type__", d0VarBuild3).H("value", d0.B0().F(d9.b.n0()).build())).build();
        f9790h = d0.B0().I(false).build();
        f9791i = d0.B0().L(Double.NaN).build();
        f9792j = d0.B0().T(u1.j0().F(Long.MIN_VALUE)).build();
        f9793k = d0.B0().S("").build();
        f9794l = d0.B0().K(com.google.protobuf.i.f5753b).build();
        f9795m = H(f.f9738c, k.i());
        f9796n = d0.B0().M(o9.a.j0().E(-90.0d).F(-180.0d)).build();
        f9797o = d0.B0().H(d9.b.k0()).build();
        f9798p = d0.B0().P(d9.u.f0()).build();
    }

    public static boolean A(d0 d0Var) {
        return d0Var != null && d0Var.A0() == d0.c.NULL_VALUE;
    }

    public static boolean B(d0 d0Var) {
        return w(d0Var) || v(d0Var);
    }

    public static boolean C(d0 d0Var) {
        return d0Var != null && d0Var.A0() == d0.c.REFERENCE_VALUE;
    }

    public static boolean D(d0 d0Var) {
        return f9788f.equals(d0Var.w0().h0().get("__type__"));
    }

    public static int E(d0 d0Var, boolean z10, d0 d0Var2, boolean z11) {
        int i10 = i(d0Var, d0Var2);
        if (i10 != 0) {
            return i10;
        }
        if (!z10 || z11) {
            return (z10 || !z11) ? 0 : 1;
        }
        return -1;
    }

    public static boolean F(d0 d0Var, d0 d0Var2) {
        d0.c cVarA0 = d0Var.A0();
        d0.c cVar = d0.c.INTEGER_VALUE;
        if (cVarA0 == cVar && d0Var2.A0() == cVar) {
            return d0Var.v0() == d0Var2.v0();
        }
        d0.c cVarA1 = d0Var.A0();
        d0.c cVar2 = d0.c.DOUBLE_VALUE;
        return cVarA1 == cVar2 && d0Var2.A0() == cVar2 && Double.doubleToLongBits(d0Var.t0()) == Double.doubleToLongBits(d0Var2.t0());
    }

    public static boolean G(d0 d0Var, d0 d0Var2) {
        d9.u uVarW0 = d0Var.w0();
        d9.u uVarW1 = d0Var2.w0();
        if (uVarW0.g0() != uVarW1.g0()) {
            return false;
        }
        for (Map.Entry<String, d0> entry : uVarW0.h0().entrySet()) {
            if (!r(entry.getValue(), uVarW1.h0().get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static d0 H(f fVar, k kVar) {
        return d0.B0().R(String.format("projects/%s/databases/%s/documents/%s", fVar.l(), fVar.k(), kVar.toString())).build();
    }

    public static int I(d0 d0Var) {
        switch (a.f9799a[d0Var.A0().ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
            case 4:
                return 2;
            case 5:
                return 3;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case 9:
                return 8;
            case 10:
                return 9;
            case 11:
                if (u.c(d0Var)) {
                    return 4;
                }
                if (y(d0Var)) {
                    return com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;
                }
                return D(d0Var) ? 10 : 11;
            default:
                throw l8.b.a("Invalid value type: " + d0Var.A0(), new Object[0]);
        }
    }

    public static int J(d0 d0Var, boolean z10, d0 d0Var2, boolean z11) {
        int i10 = i(d0Var, d0Var2);
        if (i10 != 0) {
            return i10;
        }
        if (!z10 || z11) {
            return (z10 || !z11) ? 0 : -1;
        }
        return 1;
    }

    public static boolean a(d0 d0Var, d0 d0Var2) {
        d9.b bVarP0 = d0Var.p0();
        d9.b bVarP1 = d0Var2.p0();
        if (bVarP0.m0() != bVarP1.m0()) {
            return false;
        }
        for (int i10 = 0; i10 < bVarP0.m0(); i10++) {
            if (!r(bVarP0.l0(i10), bVarP1.l0(i10))) {
                return false;
            }
        }
        return true;
    }

    public static String b(d0 d0Var) {
        StringBuilder sb2 = new StringBuilder();
        h(sb2, d0Var);
        return sb2.toString();
    }

    public static void c(StringBuilder sb2, d9.b bVar) {
        sb2.append("[");
        for (int i10 = 0; i10 < bVar.m0(); i10++) {
            h(sb2, bVar.l0(i10));
            if (i10 != bVar.m0() - 1) {
                sb2.append(",");
            }
        }
        sb2.append("]");
    }

    public static void d(StringBuilder sb2, o9.a aVar) {
        sb2.append(String.format("geo(%s,%s)", Double.valueOf(aVar.h0()), Double.valueOf(aVar.i0())));
    }

    public static void e(StringBuilder sb2, d9.u uVar) {
        ArrayList<String> arrayList = new ArrayList(uVar.h0().keySet());
        Collections.sort(arrayList);
        sb2.append("{");
        boolean z10 = true;
        for (String str : arrayList) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(",");
            }
            sb2.append(str);
            sb2.append(":");
            h(sb2, uVar.j0(str));
        }
        sb2.append("}");
    }

    public static void f(StringBuilder sb2, d0 d0Var) {
        l8.b.d(C(d0Var), "Value should be a ReferenceValue", new Object[0]);
        sb2.append(k.l(d0Var.x0()));
    }

    public static void g(StringBuilder sb2, u1 u1Var) {
        sb2.append(String.format("time(%s,%s)", Long.valueOf(u1Var.i0()), Integer.valueOf(u1Var.h0())));
    }

    public static void h(StringBuilder sb2, d0 d0Var) {
        String strY0;
        switch (a.f9799a[d0Var.A0().ordinal()]) {
            case 1:
                strY0 = "null";
                break;
            case 2:
                sb2.append(d0Var.q0());
                return;
            case 3:
                sb2.append(d0Var.v0());
                return;
            case 4:
                sb2.append(d0Var.t0());
                return;
            case 5:
                g(sb2, d0Var.z0());
                return;
            case 6:
                strY0 = d0Var.y0();
                break;
            case 7:
                strY0 = g0.B(d0Var.r0());
                break;
            case 8:
                f(sb2, d0Var);
                return;
            case 9:
                d(sb2, d0Var.u0());
                return;
            case 10:
                c(sb2, d0Var.p0());
                return;
            case 11:
                e(sb2, d0Var.w0());
                return;
            default:
                throw l8.b.a("Invalid value type: " + d0Var.A0(), new Object[0]);
        }
        sb2.append(strY0);
    }

    public static int i(d0 d0Var, d0 d0Var2) {
        int I = I(d0Var);
        int I2 = I(d0Var2);
        if (I != I2) {
            return g0.l(I, I2);
        }
        if (I != Integer.MAX_VALUE) {
            switch (I) {
                case 0:
                    break;
                case 1:
                    return g0.h(d0Var.q0(), d0Var2.q0());
                case 2:
                    return m(d0Var, d0Var2);
                case 3:
                    return o(d0Var.z0(), d0Var2.z0());
                case 4:
                    return o(u.a(d0Var), u.a(d0Var2));
                case 5:
                    return g0.o(d0Var.y0(), d0Var2.y0());
                case 6:
                    return g0.j(d0Var.r0(), d0Var2.r0());
                case 7:
                    return n(d0Var.x0(), d0Var2.x0());
                case 8:
                    return k(d0Var.u0(), d0Var2.u0());
                case 9:
                    return j(d0Var.p0(), d0Var2.p0());
                case 10:
                    return p(d0Var.w0(), d0Var2.w0());
                case 11:
                    return l(d0Var.w0(), d0Var2.w0());
                default:
                    throw l8.b.a("Invalid value type: " + I, new Object[0]);
            }
        }
        return 0;
    }

    public static int j(d9.b bVar, d9.b bVar2) {
        int iMin = Math.min(bVar.m0(), bVar2.m0());
        for (int i10 = 0; i10 < iMin; i10++) {
            int i11 = i(bVar.l0(i10), bVar2.l0(i10));
            if (i11 != 0) {
                return i11;
            }
        }
        return g0.l(bVar.m0(), bVar2.m0());
    }

    public static int k(o9.a aVar, o9.a aVar2) {
        int iK = g0.k(aVar.h0(), aVar2.h0());
        return iK == 0 ? g0.k(aVar.i0(), aVar2.i0()) : iK;
    }

    public static int l(d9.u uVar, d9.u uVar2) {
        Iterator it = new TreeMap(uVar.h0()).entrySet().iterator();
        Iterator it2 = new TreeMap(uVar2.h0()).entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            int iO = g0.o((String) entry.getKey(), (String) entry2.getKey());
            if (iO != 0) {
                return iO;
            }
            int i10 = i((d0) entry.getValue(), (d0) entry2.getValue());
            if (i10 != 0) {
                return i10;
            }
        }
        return g0.h(it.hasNext(), it2.hasNext());
    }

    public static int m(d0 d0Var, d0 d0Var2) {
        d0.c cVarA0 = d0Var.A0();
        d0.c cVar = d0.c.DOUBLE_VALUE;
        if (cVarA0 == cVar) {
            double dT0 = d0Var.t0();
            if (d0Var2.A0() == cVar) {
                return g0.k(dT0, d0Var2.t0());
            }
            if (d0Var2.A0() == d0.c.INTEGER_VALUE) {
                return g0.n(dT0, d0Var2.v0());
            }
        } else {
            d0.c cVarA1 = d0Var.A0();
            d0.c cVar2 = d0.c.INTEGER_VALUE;
            if (cVarA1 == cVar2) {
                long jV0 = d0Var.v0();
                if (d0Var2.A0() == cVar2) {
                    return g0.m(jV0, d0Var2.v0());
                }
                if (d0Var2.A0() == cVar) {
                    return g0.n(d0Var2.t0(), jV0) * (-1);
                }
            }
        }
        throw l8.b.a("Unexpected values: %s vs %s", d0Var, d0Var2);
    }

    public static int n(String str, String str2) {
        String[] strArrSplit = str.split("/", -1);
        String[] strArrSplit2 = str2.split("/", -1);
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        for (int i10 = 0; i10 < iMin; i10++) {
            int iCompareTo = strArrSplit[i10].compareTo(strArrSplit2[i10]);
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return g0.l(strArrSplit.length, strArrSplit2.length);
    }

    public static int o(u1 u1Var, u1 u1Var2) {
        int iM = g0.m(u1Var.i0(), u1Var2.i0());
        return iM != 0 ? iM : g0.l(u1Var.h0(), u1Var2.h0());
    }

    public static int p(d9.u uVar, d9.u uVar2) {
        Map<String, d0> mapH0 = uVar.h0();
        Map<String, d0> mapH1 = uVar2.h0();
        d9.b bVarP0 = mapH0.get("value").p0();
        d9.b bVarP1 = mapH1.get("value").p0();
        int iL = g0.l(bVarP0.m0(), bVarP1.m0());
        return iL != 0 ? iL : j(bVarP0, bVarP1);
    }

    public static boolean q(d9.c cVar, d0 d0Var) {
        Iterator<d0> it = cVar.m().iterator();
        while (it.hasNext()) {
            if (r(it.next(), d0Var)) {
                return true;
            }
        }
        return false;
    }

    public static boolean r(d0 d0Var, d0 d0Var2) {
        int I;
        if (d0Var == d0Var2) {
            return true;
        }
        if (d0Var == null || d0Var2 == null || (I = I(d0Var)) != I(d0Var2)) {
            return false;
        }
        if (I == 2) {
            return F(d0Var, d0Var2);
        }
        if (I == 4) {
            return u.a(d0Var).equals(u.a(d0Var2));
        }
        if (I == Integer.MAX_VALUE) {
            return true;
        }
        switch (I) {
            case 9:
                return a(d0Var, d0Var2);
            case 10:
            case 11:
                return G(d0Var, d0Var2);
            default:
                return d0Var.equals(d0Var2);
        }
    }

    public static d0 s(d0 d0Var) {
        switch (a.f9799a[d0Var.A0().ordinal()]) {
            case 1:
                return f9784b;
            case 2:
                return f9790h;
            case 3:
            case 4:
                return f9791i;
            case 5:
                return f9792j;
            case 6:
                return f9793k;
            case 7:
                return f9794l;
            case 8:
                return f9795m;
            case 9:
                return f9796n;
            case 10:
                return f9797o;
            case 11:
                return D(d0Var) ? f9789g : f9798p;
            default:
                throw new IllegalArgumentException("Unknown value type: " + d0Var.A0());
        }
    }

    public static d0 t(d0 d0Var) {
        switch (a.f9799a[d0Var.A0().ordinal()]) {
            case 1:
                return f9790h;
            case 2:
                return f9791i;
            case 3:
            case 4:
                return f9792j;
            case 5:
                return f9793k;
            case 6:
                return f9794l;
            case 7:
                return f9795m;
            case 8:
                return f9796n;
            case 9:
                return f9797o;
            case 10:
                return f9789g;
            case 11:
                return D(d0Var) ? f9798p : f9787e;
            default:
                throw new IllegalArgumentException("Unknown value type: " + d0Var.A0());
        }
    }

    public static boolean u(d0 d0Var) {
        return d0Var != null && d0Var.A0() == d0.c.ARRAY_VALUE;
    }

    public static boolean v(d0 d0Var) {
        return d0Var != null && d0Var.A0() == d0.c.DOUBLE_VALUE;
    }

    public static boolean w(d0 d0Var) {
        return d0Var != null && d0Var.A0() == d0.c.INTEGER_VALUE;
    }

    public static boolean x(d0 d0Var) {
        return d0Var != null && d0Var.A0() == d0.c.MAP_VALUE;
    }

    public static boolean y(d0 d0Var) {
        return f9786d.equals(d0Var.w0().h0().get("__type__"));
    }

    public static boolean z(d0 d0Var) {
        return d0Var != null && Double.isNaN(d0Var.t0());
    }
}
