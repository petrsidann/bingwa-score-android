package f8;

import com.google.protobuf.u1;
import d9.d0;
import d9.u;
import h8.t;
import h8.y;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8246a = new c();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8247a;

        static {
            int[] iArr = new int[d0.c.values().length];
            f8247a = iArr;
            try {
                iArr[d0.c.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8247a[d0.c.BOOLEAN_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8247a[d0.c.DOUBLE_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8247a[d0.c.INTEGER_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8247a[d0.c.TIMESTAMP_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8247a[d0.c.STRING_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8247a[d0.c.BYTES_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8247a[d0.c.REFERENCE_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8247a[d0.c.GEO_POINT_VALUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8247a[d0.c.MAP_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8247a[d0.c.ARRAY_VALUE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public final void a(d9.b bVar, b bVar2) {
        j(bVar2, 50);
        Iterator<d0> it = bVar.m().iterator();
        while (it.hasNext()) {
            f(it.next(), bVar2);
        }
    }

    public final void b(String str, b bVar) {
        j(bVar, 37);
        t tVarZ = t.z(str);
        int iU = tVarZ.u();
        for (int i10 = 5; i10 < iU; i10++) {
            String strQ = tVarZ.q(i10);
            j(bVar, 60);
            i(strQ, bVar);
        }
    }

    public final void c(u uVar, b bVar) {
        j(bVar, 55);
        for (Map.Entry<String, d0> entry : uVar.h0().entrySet()) {
            String key = entry.getKey();
            d0 value = entry.getValue();
            d(key, bVar);
            f(value, bVar);
        }
    }

    public final void d(String str, b bVar) {
        j(bVar, 25);
        i(str, bVar);
    }

    public void e(d0 d0Var, b bVar) {
        f(d0Var, bVar);
        bVar.c();
    }

    public final void f(d0 d0Var, b bVar) {
        int i10;
        long jH0;
        double dV0;
        switch (a.f8247a[d0Var.A0().ordinal()]) {
            case 1:
                i10 = 5;
                j(bVar, i10);
                return;
            case 2:
                j(bVar, 10);
                jH0 = d0Var.q0() ? 1L : 0L;
                bVar.d(jH0);
                return;
            case 3:
                double dT0 = d0Var.t0();
                if (Double.isNaN(dT0)) {
                    i10 = 13;
                    j(bVar, i10);
                    return;
                }
                j(bVar, 15);
                if (dT0 != -0.0d) {
                    bVar.b(dT0);
                    return;
                } else {
                    dV0 = 0.0d;
                    bVar.b(dV0);
                    return;
                }
            case 4:
                j(bVar, 15);
                dV0 = d0Var.v0();
                bVar.b(dV0);
                return;
            case 5:
                u1 u1VarZ0 = d0Var.z0();
                j(bVar, 20);
                bVar.d(u1VarZ0.i0());
                jH0 = u1VarZ0.h0();
                bVar.d(jH0);
                return;
            case 6:
                d(d0Var.y0(), bVar);
                h(bVar);
                return;
            case 7:
                j(bVar, 30);
                bVar.a(d0Var.r0());
                h(bVar);
                return;
            case 8:
                b(d0Var.x0(), bVar);
                return;
            case 9:
                o9.a aVarU0 = d0Var.u0();
                j(bVar, 45);
                bVar.b(aVarU0.h0());
                dV0 = aVarU0.i0();
                bVar.b(dV0);
                return;
            case 10:
                if (y.y(d0Var)) {
                    i10 = com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;
                    j(bVar, i10);
                    return;
                }
                boolean zD = y.D(d0Var);
                u uVarW0 = d0Var.w0();
                if (zD) {
                    g(uVarW0, bVar);
                    return;
                } else {
                    c(uVarW0, bVar);
                    h(bVar);
                    return;
                }
            case 11:
                a(d0Var.p0(), bVar);
                h(bVar);
                return;
            default:
                throw new IllegalArgumentException("unknown index value type " + d0Var.A0());
        }
    }

    public final void g(u uVar, b bVar) {
        Map<String, d0> mapH0 = uVar.h0();
        j(bVar, 53);
        int iM0 = mapH0.get("value").p0().m0();
        j(bVar, 15);
        bVar.d(iM0);
        d("value", bVar);
        f(mapH0.get("value"), bVar);
    }

    public final void h(b bVar) {
        bVar.d(2L);
    }

    public final void i(String str, b bVar) {
        bVar.e(str);
    }

    public final void j(b bVar, int i10) {
        bVar.d(i10);
    }
}
