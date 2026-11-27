package xb;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f18143a = Logger.getLogger(a1.class.getName());

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18144a;

        static {
            int[] iArr = new int[m9.b.values().length];
            f18144a = iArr;
            try {
                iArr[m9.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18144a[m9.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18144a[m9.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18144a[m9.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18144a[m9.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18144a[m9.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static Object a(String str) {
        m9.a aVar = new m9.a(new StringReader(str));
        try {
            return e(aVar);
        } finally {
            try {
                aVar.close();
            } catch (IOException e10) {
                f18143a.log(Level.WARNING, "Failed to close", (Throwable) e10);
            }
        }
    }

    public static List<?> b(m9.a aVar) throws IOException {
        aVar.d();
        ArrayList arrayList = new ArrayList();
        while (aVar.I()) {
            arrayList.add(e(aVar));
        }
        j6.m.v(aVar.l0() == m9.b.END_ARRAY, "Bad token: " + aVar.D());
        aVar.z();
        return Collections.unmodifiableList(arrayList);
    }

    public static Void c(m9.a aVar) throws IOException {
        aVar.h0();
        return null;
    }

    public static Map<String, ?> d(m9.a aVar) throws IOException {
        aVar.e();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (aVar.I()) {
            linkedHashMap.put(aVar.f0(), e(aVar));
        }
        j6.m.v(aVar.l0() == m9.b.END_OBJECT, "Bad token: " + aVar.D());
        aVar.B();
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static Object e(m9.a aVar) {
        j6.m.v(aVar.I(), "unexpected end of JSON");
        switch (a.f18144a[aVar.l0().ordinal()]) {
            case 1:
                return b(aVar);
            case 2:
                return d(aVar);
            case 3:
                return aVar.j0();
            case 4:
                return Double.valueOf(aVar.c0());
            case 5:
                return Boolean.valueOf(aVar.Q());
            case 6:
                return c(aVar);
            default:
                throw new IllegalStateException("Bad token: " + aVar.D());
        }
    }
}
