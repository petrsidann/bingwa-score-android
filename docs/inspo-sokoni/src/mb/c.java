package mb;

import android.util.Log;
import b8.i1;
import b8.t1;
import b8.x0;
import b8.y0;
import b8.z1;
import com.google.firebase.firestore.FirebaseFirestore;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class c extends fb.p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f13035d = new c();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f13037b;

        static {
            int[] iArr = new int[b8.w0.a.values().length];
            f13037b = iArr;
            try {
                iArr[b8.w0.a.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13037b[b8.w0.a.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13037b[b8.w0.a.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[b8.g.b.values().length];
            f13036a = iArr2;
            try {
                iArr2[b8.g.b.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13036a[b8.g.b.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13036a[b8.g.b.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // fb.p
    public Object g(byte b10, ByteBuffer byteBuffer) {
        switch (b10) {
            case -76:
                return new Date(byteBuffer.getLong());
            case -75:
                fb.p.c(byteBuffer, 8);
                return new b8.q0(byteBuffer.getDouble(), byteBuffer.getDouble());
            case -74:
                return ((FirebaseFirestore) f(byteBuffer)).y((String) f(byteBuffer));
            case -73:
                return b8.e.i(fb.p.d(byteBuffer));
            case -72:
                return b8.u.b(u(f(byteBuffer)));
            case -71:
                return b8.u.a(u(f(byteBuffer)));
            case -70:
                return b8.u.c();
            case -69:
                return b8.u.g();
            case -68:
                return new h7.q(byteBuffer.getLong(), byteBuffer.getInt());
            case -67:
                return b8.u.e(((Number) f(byteBuffer)).doubleValue());
            case -66:
                return b8.u.f(((Number) f(byteBuffer)).intValue());
            case -65:
                return b8.t.a();
            case -64:
                int iE = fb.p.e(byteBuffer);
                ArrayList arrayList = new ArrayList(iE);
                for (int i10 = 0; i10 < iE; i10++) {
                    arrayList.add(f(byteBuffer));
                }
                return b8.t.d((String[]) arrayList.toArray(new String[0]));
            case -63:
                return Double.valueOf(Double.NaN);
            case -62:
                return Double.valueOf(Double.POSITIVE_INFINITY);
            case -61:
                return Double.valueOf(Double.NEGATIVE_INFINITY);
            case -60:
                return r(byteBuffer);
            case -59:
                return s(byteBuffer);
            case -58:
                return t(byteBuffer);
            case -57:
                ArrayList arrayList2 = (ArrayList) f(byteBuffer);
                double[] dArr = new double[arrayList2.size()];
                for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                    Double d10 = (Double) arrayList2.get(i11);
                    Objects.requireNonNull(d10, "Null value at index " + i11);
                    dArr[i11] = d10.doubleValue();
                }
                return b8.u.h(dArr);
            default:
                return super.g(b10, byteBuffer);
        }
    }

    @Override // fb.p
    public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        int i10;
        String strA;
        if (obj instanceof Date) {
            byteArrayOutputStream.write(-76);
            fb.p.n(byteArrayOutputStream, ((Date) obj).getTime());
            return;
        }
        if (obj instanceof h7.q) {
            byteArrayOutputStream.write(-68);
            h7.q qVar = (h7.q) obj;
            fb.p.n(byteArrayOutputStream, qVar.k());
            fb.p.m(byteArrayOutputStream, qVar.h());
            return;
        }
        if (obj instanceof b8.q0) {
            byteArrayOutputStream.write(-75);
            fb.p.h(byteArrayOutputStream, 8);
            b8.q0 q0Var = (b8.q0) obj;
            fb.p.k(byteArrayOutputStream, q0Var.h());
            fb.p.k(byteArrayOutputStream, q0Var.i());
            return;
        }
        if (obj instanceof z1) {
            byteArrayOutputStream.write(-57);
            p(byteArrayOutputStream, ((z1) obj).a());
            return;
        }
        if (obj instanceof com.google.firebase.firestore.c) {
            byteArrayOutputStream.write(-74);
            com.google.firebase.firestore.c cVar = (com.google.firebase.firestore.c) obj;
            FirebaseFirestore firebaseFirestoreP = cVar.p();
            p(byteArrayOutputStream, firebaseFirestoreP.A().q());
            p(byteArrayOutputStream, cVar.r());
            synchronized (x.f13116m) {
                strA = x.Q0(firebaseFirestoreP).a();
            }
            p(byteArrayOutputStream, strA);
            return;
        }
        if (obj instanceof com.google.firebase.firestore.d) {
            w(byteArrayOutputStream, (com.google.firebase.firestore.d) obj);
            return;
        }
        if (obj instanceof com.google.firebase.firestore.k) {
            y(byteArrayOutputStream, (com.google.firebase.firestore.k) obj);
            return;
        }
        if (obj instanceof b8.g) {
            v(byteArrayOutputStream, (b8.g) obj);
            return;
        }
        if (obj instanceof b8.w0) {
            x(byteArrayOutputStream, (b8.w0) obj);
            return;
        }
        if (obj instanceof t1) {
            z(byteArrayOutputStream, (t1) obj);
            return;
        }
        if (obj instanceof b8.e) {
            byteArrayOutputStream.write(-73);
            fb.p.i(byteArrayOutputStream, ((b8.e) obj).l());
            return;
        }
        if (obj instanceof Double) {
            Double d10 = (Double) obj;
            if (Double.isNaN(d10.doubleValue())) {
                i10 = -63;
            } else if (d10.equals(Double.valueOf(Double.NEGATIVE_INFINITY))) {
                i10 = -61;
            } else if (d10.equals(Double.valueOf(Double.POSITIVE_INFINITY))) {
                i10 = -62;
            }
            byteArrayOutputStream.write(i10);
            return;
        }
        super.p(byteArrayOutputStream, obj);
    }

    public final com.google.firebase.firestore.e q(Map<String, Object> map) {
        if (!map.containsKey("fieldPath")) {
            String str = (String) map.get("op");
            List list = (List) map.get("queries");
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(q((Map) it.next()));
            }
            if (str.equals("OR")) {
                return com.google.firebase.firestore.e.l((com.google.firebase.firestore.e[]) arrayList.toArray(new com.google.firebase.firestore.e[0]));
            }
            if (str.equals("AND")) {
                return com.google.firebase.firestore.e.a((com.google.firebase.firestore.e[]) arrayList.toArray(new com.google.firebase.firestore.e[0]));
            }
            throw new Error("Invalid operator");
        }
        String str2 = (String) map.get("op");
        b8.t tVar = (b8.t) map.get("fieldPath");
        Object obj = map.get("value");
        str2.hashCode();
        switch (str2) {
            case "not-in":
                return com.google.firebase.firestore.e.k(tVar, (List) obj);
            case "<":
                return com.google.firebase.firestore.e.h(tVar, obj);
            case ">":
                return com.google.firebase.firestore.e.e(tVar, obj);
            case "!=":
                return com.google.firebase.firestore.e.j(tVar, obj);
            case "<=":
                return com.google.firebase.firestore.e.i(tVar, obj);
            case "==":
                return com.google.firebase.firestore.e.d(tVar, obj);
            case ">=":
                return com.google.firebase.firestore.e.f(tVar, obj);
            case "in":
                return com.google.firebase.firestore.e.g(tVar, (List) obj);
            case "array-contains":
                return com.google.firebase.firestore.e.b(tVar, obj);
            case "array-contains-any":
                return com.google.firebase.firestore.e.c(tVar, (List) obj);
            default:
                throw new Error("Invalid operator");
        }
    }

    public final FirebaseFirestore r(ByteBuffer byteBuffer) {
        String str = (String) f(byteBuffer);
        String str2 = (String) f(byteBuffer);
        com.google.firebase.firestore.g gVar = (com.google.firebase.firestore.g) f(byteBuffer);
        synchronized (x.f13116m) {
            FirebaseFirestore firebaseFirestoreS0 = x.S0(str, str2);
            if (firebaseFirestoreS0 != null) {
                return firebaseFirestoreS0;
            }
            FirebaseFirestore firebaseFirestoreC = FirebaseFirestore.C(h7.f.p(str), str2);
            firebaseFirestoreC.Z(gVar);
            x.s1(firebaseFirestoreC, str2);
            return firebaseFirestoreC;
        }
    }

    public final com.google.firebase.firestore.i s(ByteBuffer byteBuffer) {
        try {
            Map map = (Map) f(byteBuffer);
            Object obj = map.get("firestore");
            Objects.requireNonNull(obj);
            FirebaseFirestore firebaseFirestore = (FirebaseFirestore) obj;
            Object obj2 = map.get("path");
            Objects.requireNonNull(obj2);
            String str = (String) obj2;
            boolean zBooleanValue = ((Boolean) map.get("isCollectionGroup")).booleanValue();
            Map map2 = (Map) map.get("parameters");
            com.google.firebase.firestore.i iVarW = zBooleanValue ? firebaseFirestore.w(str) : firebaseFirestore.v(str);
            if (map2 == null) {
                return iVarW;
            }
            if (map2.containsKey("filters")) {
                Object obj3 = map2.get("filters");
                Objects.requireNonNull(obj3);
                iVarW = iVarW.M(q((Map) obj3));
            }
            Object obj4 = map2.get("where");
            Objects.requireNonNull(obj4);
            for (List list : (List) obj4) {
                b8.t tVar = (b8.t) list.get(0);
                String str2 = (String) list.get(1);
                Object obj5 = list.get(2);
                if ("==".equals(str2)) {
                    iVarW = iVarW.P(tVar, obj5);
                } else if ("!=".equals(str2)) {
                    iVarW = iVarW.V(tVar, obj5);
                } else if ("<".equals(str2)) {
                    iVarW = iVarW.T(tVar, obj5);
                } else if ("<=".equals(str2)) {
                    iVarW = iVarW.U(tVar, obj5);
                } else if (">".equals(str2)) {
                    iVarW = iVarW.Q(tVar, obj5);
                } else if (">=".equals(str2)) {
                    iVarW = iVarW.R(tVar, obj5);
                } else if ("array-contains".equals(str2)) {
                    iVarW = iVarW.N(tVar, obj5);
                } else if ("array-contains-any".equals(str2)) {
                    iVarW = iVarW.O(tVar, (List) obj5);
                } else if ("in".equals(str2)) {
                    iVarW = iVarW.S(tVar, (List) obj5);
                } else if ("not-in".equals(str2)) {
                    iVarW = iVarW.W(tVar, (List) obj5);
                } else {
                    Log.w("FLTFirestoreMsgCodec", "An invalid query operator " + str2 + " was received but not handled.");
                }
            }
            Number number = (Number) map2.get("limit");
            if (number != null) {
                iVarW = iVarW.y(number.longValue());
            }
            Number number2 = (Number) map2.get("limitToLast");
            if (number2 != null) {
                iVarW = iVarW.z(number2.longValue());
            }
            List<List> list2 = (List) map2.get("orderBy");
            if (list2 == null) {
                return iVarW;
            }
            for (List list3 : list2) {
                iVarW = iVarW.A((b8.t) list3.get(0), ((Boolean) list3.get(1)).booleanValue() ? com.google.firebase.firestore.i.c.DESCENDING : com.google.firebase.firestore.i.c.ASCENDING);
            }
            List list4 = (List) map2.get("startAt");
            if (list4 != null) {
                Object[] array = list4.toArray();
                Objects.requireNonNull(array);
                iVarW = iVarW.H(array);
            }
            List list5 = (List) map2.get("startAfter");
            if (list5 != null) {
                Object[] array2 = list5.toArray();
                Objects.requireNonNull(array2);
                iVarW = iVarW.G(array2);
            }
            List list6 = (List) map2.get("endAt");
            if (list6 != null) {
                Object[] array3 = list6.toArray();
                Objects.requireNonNull(array3);
                iVarW = iVarW.l(array3);
            }
            List list7 = (List) map2.get("endBefore");
            if (list7 == null) {
                return iVarW;
            }
            Object[] array4 = list7.toArray();
            Objects.requireNonNull(array4);
            return iVarW.m(array4);
        } catch (Exception e10) {
            Log.e("FLTFirestoreMsgCodec", "An error occurred while parsing query arguments, this is most likely an error with this SDK.", e10);
            return null;
        }
    }

    public final com.google.firebase.firestore.g t(ByteBuffer byteBuffer) {
        x0 x0VarA;
        Map map = (Map) f(byteBuffer);
        com.google.firebase.firestore.g.b bVar = new com.google.firebase.firestore.g.b();
        if (map.get("persistenceEnabled") != null) {
            if (Boolean.TRUE.equals((Boolean) map.get("persistenceEnabled"))) {
                i1.b bVarB = i1.b();
                if (map.get("cacheSizeBytes") != null) {
                    Long lValueOf = 104857600L;
                    Object obj = map.get("cacheSizeBytes");
                    if (obj instanceof Long) {
                        lValueOf = (Long) obj;
                    } else if (obj instanceof Integer) {
                        lValueOf = Long.valueOf(((Integer) obj).intValue());
                    }
                    if (lValueOf.longValue() == -1) {
                        bVarB.b(-1L);
                    } else {
                        bVarB.b(lValueOf.longValue());
                    }
                }
                x0VarA = bVarB.a();
            } else {
                x0VarA = y0.b().a();
            }
            bVar.h(x0VarA);
        }
        if (map.get("host") != null) {
            Object obj2 = map.get("host");
            Objects.requireNonNull(obj2);
            bVar.g((String) obj2);
            if (map.get("sslEnabled") != null) {
                Object obj3 = map.get("sslEnabled");
                Objects.requireNonNull(obj3);
                bVar.i(((Boolean) obj3).booleanValue());
            }
        }
        return bVar.f();
    }

    public final Object[] u(Object obj) {
        if (obj instanceof List) {
            return ((List) obj).toArray();
        }
        if (obj == null) {
            return new ArrayList().toArray();
        }
        throw new IllegalArgumentException(String.format("java.util.List was expected, unable to convert '%s' to an object array", obj.getClass().getCanonicalName()));
    }

    public final void v(ByteArrayOutputStream byteArrayOutputStream, b8.g gVar) {
        String str;
        HashMap map = new HashMap();
        int i10 = a.f13036a[gVar.e().ordinal()];
        if (i10 == 1) {
            str = "DocumentChangeType.added";
        } else if (i10 != 2) {
            str = i10 != 3 ? null : "DocumentChangeType.removed";
        } else {
            str = "DocumentChangeType.modified";
        }
        map.put("type", str);
        map.put("data", gVar.b().d());
        map.put("path", gVar.b().g().r());
        map.put("oldIndex", Integer.valueOf(gVar.d()));
        map.put("newIndex", Integer.valueOf(gVar.c()));
        map.put("metadata", gVar.b().f());
        p(byteArrayOutputStream, map);
    }

    public final void w(ByteArrayOutputStream byteArrayOutputStream, com.google.firebase.firestore.d dVar) {
        Map<String, Object> mapE;
        HashMap map = new HashMap();
        map.put("path", dVar.g().r());
        if (dVar.a()) {
            com.google.firebase.firestore.d.a aVar = x.f13117n.get(Integer.valueOf(dVar.hashCode()));
            mapE = aVar != null ? dVar.e(aVar) : dVar.d();
        } else {
            mapE = null;
        }
        map.put("data", mapE);
        map.put("metadata", dVar.f());
        x.f13117n.remove(Integer.valueOf(dVar.hashCode()));
        p(byteArrayOutputStream, map);
    }

    public final void x(ByteArrayOutputStream byteArrayOutputStream, b8.w0 w0Var) {
        HashMap map = new HashMap();
        map.put("bytesLoaded", Long.valueOf(w0Var.c()));
        map.put("documentsLoaded", Integer.valueOf(w0Var.d()));
        map.put("totalBytes", Long.valueOf(w0Var.f()));
        map.put("totalDocuments", Integer.valueOf(w0Var.g()));
        int i10 = a.f13037b[w0Var.e().ordinal()];
        String str = "running";
        if (i10 != 1) {
            if (i10 == 2) {
                str = "success";
            } else if (i10 == 3) {
                str = "error";
            }
        }
        map.put("taskState", str);
        p(byteArrayOutputStream, map);
    }

    public final void y(ByteArrayOutputStream byteArrayOutputStream, com.google.firebase.firestore.k kVar) {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        com.google.firebase.firestore.d.a aVar = x.f13117n.get(Integer.valueOf(kVar.hashCode()));
        for (com.google.firebase.firestore.d dVar : kVar.k()) {
            arrayList.add(dVar.g().r());
            arrayList2.add(aVar != null ? dVar.e(aVar) : dVar.d());
            arrayList3.add(dVar.f());
        }
        map.put("paths", arrayList);
        map.put("documents", arrayList2);
        map.put("metadatas", arrayList3);
        map.put("documentChanges", kVar.i());
        map.put("metadata", kVar.l());
        x.f13117n.remove(Integer.valueOf(kVar.hashCode()));
        p(byteArrayOutputStream, map);
    }

    public final void z(ByteArrayOutputStream byteArrayOutputStream, t1 t1Var) {
        HashMap map = new HashMap();
        map.put("hasPendingWrites", Boolean.valueOf(t1Var.a()));
        map.put("isFromCache", Boolean.valueOf(t1Var.b()));
        p(byteArrayOutputStream, map);
    }
}
