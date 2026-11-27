package d1;

import a1.k;
import c1.h;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lc.q;
import mc.w;

/* JADX INFO: loaded from: classes.dex */
public final class g implements k<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f6272a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f6273b = "preferences_pb";

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6274a;

        static {
            int[] iArr = new int[h.b.values().length];
            iArr[h.b.BOOLEAN.ordinal()] = 1;
            iArr[h.b.FLOAT.ordinal()] = 2;
            iArr[h.b.DOUBLE.ordinal()] = 3;
            iArr[h.b.INTEGER.ordinal()] = 4;
            iArr[h.b.LONG.ordinal()] = 5;
            iArr[h.b.STRING.ordinal()] = 6;
            iArr[h.b.STRING_SET.ordinal()] = 7;
            iArr[h.b.VALUE_NOT_SET.ordinal()] = 8;
            f6274a = iArr;
        }
    }

    @Override // a1.k
    public Object c(InputStream inputStream, oc.e<? super d> eVar) throws a1.a {
        c1.f fVarA = c1.d.f3126a.a(inputStream);
        d1.a aVarB = e.b(new d.b[0]);
        Map<String, h> mapN = fVarA.N();
        kotlin.jvm.internal.k.d(mapN, "preferencesProto.preferencesMap");
        for (Map.Entry<String, h> entry : mapN.entrySet()) {
            String name = entry.getKey();
            h value = entry.getValue();
            g gVar = f6272a;
            kotlin.jvm.internal.k.d(name, "name");
            kotlin.jvm.internal.k.d(value, "value");
            gVar.d(name, value, aVarB);
        }
        return aVarB.c();
    }

    public final void d(String str, h hVar, d1.a aVar) throws a1.a {
        Object objA;
        Object objValueOf;
        h.b bVarA0 = hVar.a0();
        switch (bVarA0 == null ? -1 : a.f6274a[bVarA0.ordinal()]) {
            case -1:
                throw new a1.a("Value case is null.", null, 2, null);
            case 0:
            default:
                throw new lc.h();
            case 1:
                objA = f.a(str);
                objValueOf = Boolean.valueOf(hVar.S());
                break;
            case 2:
                objA = f.c(str);
                objValueOf = Float.valueOf(hVar.V());
                break;
            case 3:
                objA = f.b(str);
                objValueOf = Double.valueOf(hVar.U());
                break;
            case 4:
                objA = f.d(str);
                objValueOf = Integer.valueOf(hVar.W());
                break;
            case 5:
                objA = f.e(str);
                objValueOf = Long.valueOf(hVar.X());
                break;
            case 6:
                objA = f.f(str);
                objValueOf = hVar.Y();
                kotlin.jvm.internal.k.d(objValueOf, "value.string");
                break;
            case 7:
                objA = f.g(str);
                List<String> listP = hVar.Z().P();
                kotlin.jvm.internal.k.d(listP, "value.stringSet.stringsList");
                objValueOf = w.P(listP);
                break;
            case 8:
                throw new a1.a("Value not set.", null, 2, null);
        }
        aVar.g(objA, objValueOf);
    }

    @Override // a1.k
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public d a() {
        return e.a();
    }

    public final String f() {
        return f6273b;
    }

    public final h g(Object obj) {
        h hVarBuild;
        String str;
        if (obj instanceof Boolean) {
            hVarBuild = h.b0().x(((Boolean) obj).booleanValue()).build();
            str = "newBuilder().setBoolean(value).build()";
        } else if (obj instanceof Float) {
            hVarBuild = h.b0().z(((Number) obj).floatValue()).build();
            str = "newBuilder().setFloat(value).build()";
        } else if (obj instanceof Double) {
            hVarBuild = h.b0().y(((Number) obj).doubleValue()).build();
            str = "newBuilder().setDouble(value).build()";
        } else if (obj instanceof Integer) {
            hVarBuild = h.b0().A(((Number) obj).intValue()).build();
            str = "newBuilder().setInteger(value).build()";
        } else if (obj instanceof Long) {
            hVarBuild = h.b0().C(((Number) obj).longValue()).build();
            str = "newBuilder().setLong(value).build()";
        } else if (obj instanceof String) {
            hVarBuild = h.b0().D((String) obj).build();
            str = "newBuilder().setString(value).build()";
        } else {
            if (!(obj instanceof Set)) {
                throw new IllegalStateException(kotlin.jvm.internal.k.j("PreferencesSerializer does not support type: ", obj.getClass().getName()));
            }
            hVarBuild = h.b0().E(c1.g.Q().x((Set) obj)).build();
            str = "newBuilder().setStringSet(\n                    StringSet.newBuilder().addAllStrings(value as Set<String>)\n                ).build()";
        }
        kotlin.jvm.internal.k.d(hVarBuild, str);
        return hVarBuild;
    }

    @Override // a1.k
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Object b(d dVar, OutputStream outputStream, oc.e<? super q> eVar) {
        Map<d.a<?>, Object> mapA = dVar.a();
        c1.f.a aVarQ = c1.f.Q();
        for (Map.Entry<d.a<?>, Object> entry : mapA.entrySet()) {
            aVarQ.x(entry.getKey().a(), g(entry.getValue()));
        }
        aVarQ.build().q(outputStream);
        return q.f12711a;
    }
}
