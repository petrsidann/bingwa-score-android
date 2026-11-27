package ob;

import android.util.Log;
import b8.d;
import b8.g;
import b8.s0;
import b8.t;
import b8.t1;
import b8.u1;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.e;
import com.google.firebase.firestore.i;
import com.google.firebase.firestore.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import mb.z;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f13801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f13802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f13803d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f13804e;

        static {
            int[] iArr = new int[z.c.values().length];
            f13804e = iArr;
            try {
                iArr[z.c.SERVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[z.k.values().length];
            f13803d = iArr2;
            try {
                iArr2[z.k.DEFAULT_SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13803d[z.k.CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr3 = new int[g.b.values().length];
            f13802c = iArr3;
            try {
                iArr3[g.b.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13802c[g.b.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13802c[g.b.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr4 = new int[z.y.values().length];
            f13801b = iArr4;
            try {
                iArr4[z.y.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13801b[z.y.ESTIMATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13801b[z.y.PREVIOUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr5 = new int[z.EnumC0222z.values().length];
            f13800a = iArr5;
            try {
                iArr5[z.EnumC0222z.CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13800a[z.EnumC0222z.SERVER_AND_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f13800a[z.EnumC0222z.SERVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static e a(Map<String, Object> map) {
        if (!map.containsKey("fieldPath")) {
            String str = (String) map.get("op");
            List list = (List) map.get("queries");
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a((Map) it.next()));
            }
            if (str.equals("OR")) {
                return e.l((e[]) arrayList.toArray(new e[0]));
            }
            if (str.equals("AND")) {
                return e.a((e[]) arrayList.toArray(new e[0]));
            }
            throw new Error("Invalid operator");
        }
        String str2 = (String) map.get("op");
        t tVar = (t) map.get("fieldPath");
        Object obj = map.get("value");
        str2.hashCode();
        switch (str2) {
            case "not-in":
                return e.k(tVar, (List) obj);
            case "<":
                return e.h(tVar, obj);
            case ">":
                return e.e(tVar, obj);
            case "!=":
                return e.j(tVar, obj);
            case "<=":
                return e.i(tVar, obj);
            case "==":
                return e.d(tVar, obj);
            case ">=":
                return e.f(tVar, obj);
            case "in":
                return e.g(tVar, (List) obj);
            case "array-contains":
                return e.b(tVar, obj);
            case "array-contains-any":
                return e.c(tVar, (List) obj);
            default:
                throw new Error("Invalid operator");
        }
    }

    public static d b(z.c cVar) {
        if (a.f13804e[cVar.ordinal()] == 1) {
            return d.SERVER;
        }
        throw new IllegalArgumentException("Unknown AggregateSource value: " + cVar);
    }

    public static List<t> c(List<List<String>> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<List<String>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(t.d((String[]) it.next().toArray(new String[0])));
        }
        return arrayList;
    }

    public static s0 d(z.k kVar) {
        int i10 = a.f13803d[kVar.ordinal()];
        if (i10 == 1) {
            return s0.DEFAULT;
        }
        if (i10 == 2) {
            return s0.CACHE;
        }
        throw new IllegalArgumentException("Unknown ListenSource value: " + kVar);
    }

    public static com.google.firebase.firestore.d.a e(z.y yVar) {
        int i10;
        if (yVar != null && (i10 = a.f13801b[yVar.ordinal()]) != 1) {
            if (i10 == 2) {
                return com.google.firebase.firestore.d.a.ESTIMATE;
            }
            if (i10 == 3) {
                return com.google.firebase.firestore.d.a.PREVIOUS;
            }
            throw new IllegalArgumentException("Unknown server timestamp behavior: " + yVar);
        }
        return com.google.firebase.firestore.d.a.NONE;
    }

    public static u1 f(z.EnumC0222z enumC0222z) {
        int i10 = a.f13800a[enumC0222z.ordinal()];
        if (i10 == 1) {
            return u1.CACHE;
        }
        if (i10 == 2) {
            return u1.DEFAULT;
        }
        if (i10 == 3) {
            return u1.SERVER;
        }
        throw new IllegalArgumentException("Unknown source: " + enumC0222z);
    }

    public static i g(FirebaseFirestore firebaseFirestore, String str, boolean z10, z.r rVar) {
        try {
            i iVarW = z10 ? firebaseFirestore.w(str) : firebaseFirestore.v(str);
            if (rVar == null) {
                return iVarW;
            }
            if (rVar.d() != null) {
                iVarW = iVarW.M(a(rVar.d()));
            }
            List<List<Object>> listJ = rVar.j();
            Objects.requireNonNull(listJ);
            for (List<Object> list : listJ) {
                t tVar = (t) list.get(0);
                String str2 = (String) list.get(1);
                Object obj = list.get(2);
                if ("==".equals(str2)) {
                    iVarW = iVarW.P(tVar, obj);
                } else if ("!=".equals(str2)) {
                    iVarW = iVarW.V(tVar, obj);
                } else if ("<".equals(str2)) {
                    iVarW = iVarW.T(tVar, obj);
                } else if ("<=".equals(str2)) {
                    iVarW = iVarW.U(tVar, obj);
                } else if (">".equals(str2)) {
                    iVarW = iVarW.Q(tVar, obj);
                } else if (">=".equals(str2)) {
                    iVarW = iVarW.R(tVar, obj);
                } else if ("array-contains".equals(str2)) {
                    iVarW = iVarW.N(tVar, obj);
                } else if ("array-contains-any".equals(str2)) {
                    iVarW = iVarW.O(tVar, (List) obj);
                } else if ("in".equals(str2)) {
                    iVarW = iVarW.S(tVar, (List) obj);
                } else if ("not-in".equals(str2)) {
                    iVarW = iVarW.W(tVar, (List) obj);
                } else {
                    Log.w("FLTFirestoreMsgCodec", "An invalid query operator " + str2 + " was received but not handled.");
                }
            }
            Long lE = rVar.e();
            if (lE != null) {
                iVarW = iVarW.y(lE.longValue());
            }
            Long lF = rVar.f();
            if (lF != null) {
                iVarW = iVarW.z(lF.longValue());
            }
            List<List<Object>> listG = rVar.g();
            if (listG == null) {
                return iVarW;
            }
            for (List<Object> list2 : listG) {
                iVarW = iVarW.A((t) list2.get(0), ((Boolean) list2.get(1)).booleanValue() ? i.c.DESCENDING : i.c.ASCENDING);
            }
            List<Object> listI = rVar.i();
            if (listI != null) {
                Object[] array = listI.toArray();
                Objects.requireNonNull(array);
                iVarW = iVarW.H(array);
            }
            List<Object> listH = rVar.h();
            if (listH != null) {
                Object[] array2 = listH.toArray();
                Objects.requireNonNull(array2);
                iVarW = iVarW.G(array2);
            }
            List<Object> listB = rVar.b();
            if (listB != null) {
                Object[] array3 = listB.toArray();
                Objects.requireNonNull(array3);
                iVarW = iVarW.l(array3);
            }
            List<Object> listC = rVar.c();
            if (listC == null) {
                return iVarW;
            }
            Object[] array4 = listC.toArray();
            Objects.requireNonNull(array4);
            return iVarW.m(array4);
        } catch (Exception e10) {
            Log.e("FLTFirestoreMsgCodec", "An error occurred while parsing query arguments, this is most likely an error with this SDK.", e10);
            return null;
        }
    }

    public static z.m h(g gVar, com.google.firebase.firestore.d.a aVar) {
        z.m.a aVar2 = new z.m.a();
        aVar2.e(i(gVar.e()));
        aVar2.d(Long.valueOf(gVar.d()));
        aVar2.c(Long.valueOf(gVar.c()));
        aVar2.b(k(gVar.b(), aVar));
        return aVar2.a();
    }

    public static z.e i(g.b bVar) {
        int i10 = a.f13802c[bVar.ordinal()];
        if (i10 == 1) {
            return z.e.ADDED;
        }
        if (i10 == 2) {
            return z.e.MODIFIED;
        }
        if (i10 == 3) {
            return z.e.REMOVED;
        }
        throw new IllegalArgumentException("Unknown change type: " + bVar);
    }

    public static List<z.m> j(List<g> list, com.google.firebase.firestore.d.a aVar) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(h(it.next(), aVar));
        }
        return arrayList;
    }

    public static z.o k(com.google.firebase.firestore.d dVar, com.google.firebase.firestore.d.a aVar) {
        z.o.a aVar2 = new z.o.a();
        aVar2.c(n(dVar.f()));
        aVar2.b(dVar.e(aVar));
        aVar2.d(dVar.g().r());
        return aVar2.a();
    }

    public static List<z.o> l(List<com.google.firebase.firestore.d> list, com.google.firebase.firestore.d.a aVar) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<com.google.firebase.firestore.d> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(k(it.next(), aVar));
        }
        return arrayList;
    }

    public static z.s m(k kVar, com.google.firebase.firestore.d.a aVar) {
        z.s.a aVar2 = new z.s.a();
        aVar2.d(n(kVar.l()));
        aVar2.b(j(kVar.i(), aVar));
        aVar2.c(l(kVar.k(), aVar));
        return aVar2.a();
    }

    public static z.t n(t1 t1Var) {
        z.t.a aVar = new z.t.a();
        aVar.b(Boolean.valueOf(t1Var.a()));
        aVar.c(Boolean.valueOf(t1Var.b()));
        return aVar.a();
    }
}
