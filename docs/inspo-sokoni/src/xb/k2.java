package xb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class k2 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, ?> f18677b;

        public a(String str, Map<String, ?> map) {
            this.f18676a = (String) j6.m.p(str, "policyName");
            this.f18677b = (Map) j6.m.p(map, "rawConfigValue");
        }

        public String a() {
            return this.f18676a;
        }

        public Map<String, ?> b() {
            return this.f18677b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f18676a.equals(aVar.f18676a) && this.f18677b.equals(aVar.f18677b);
        }

        public int hashCode() {
            return j6.i.b(this.f18676a, this.f18677b);
        }

        public String toString() {
            return j6.g.b(this).d("policyName", this.f18676a).d("rawConfigValue", this.f18677b).toString();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.u0 f18678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f18679b;

        public b(vb.u0 u0Var, Object obj) {
            this.f18678a = (vb.u0) j6.m.p(u0Var, "provider");
            this.f18679b = obj;
        }

        public Object a() {
            return this.f18679b;
        }

        public vb.u0 b() {
            return this.f18678a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return j6.i.a(this.f18678a, bVar.f18678a) && j6.i.a(this.f18679b, bVar.f18679b);
        }

        public int hashCode() {
            return j6.i.b(this.f18678a, this.f18679b);
        }

        public String toString() {
            return j6.g.b(this).d("provider", this.f18678a).d("config", this.f18679b).toString();
        }
    }

    public static List<a> A(List<Map<String, ?>> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map<String, ?>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(z(it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Double a(Map<String, ?> map) {
        return b1.h(map, "backoffMultiplier");
    }

    public static Map<String, ?> b(Map<String, ?> map) {
        if (map == null) {
            return null;
        }
        return b1.j(map, "healthCheckConfig");
    }

    public static Long c(Map<String, ?> map) {
        return b1.l(map, "hedgingDelay");
    }

    public static Map<String, ?> d(Map<String, ?> map) {
        return b1.j(map, "hedgingPolicy");
    }

    public static Long e(Map<String, ?> map) {
        return b1.l(map, "initialBackoff");
    }

    public static Set<vb.l1.b> f(Map<String, ?> map, String str) {
        List<?> listE = b1.e(map, str);
        if (listE == null) {
            return null;
        }
        return u(listE);
    }

    public static List<Map<String, ?>> g(Map<String, ?> map) {
        String strK;
        ArrayList arrayList = new ArrayList();
        if (map.containsKey("loadBalancingConfig")) {
            arrayList.addAll(b1.f(map, "loadBalancingConfig"));
        }
        if (arrayList.isEmpty() && (strK = b1.k(map, "loadBalancingPolicy")) != null) {
            arrayList.add(Collections.singletonMap(strK.toLowerCase(Locale.ROOT), Collections.emptyMap()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Integer h(Map<String, ?> map) {
        return b1.i(map, "maxAttempts");
    }

    public static Integer i(Map<String, ?> map) {
        return b1.i(map, "maxAttempts");
    }

    public static Long j(Map<String, ?> map) {
        return b1.l(map, "maxBackoff");
    }

    public static Integer k(Map<String, ?> map) {
        return b1.i(map, "maxRequestMessageBytes");
    }

    public static Integer l(Map<String, ?> map) {
        return b1.i(map, "maxResponseMessageBytes");
    }

    public static List<Map<String, ?>> m(Map<String, ?> map) {
        return b1.f(map, "methodConfig");
    }

    public static String n(Map<String, ?> map) {
        return b1.k(map, "method");
    }

    public static List<Map<String, ?>> o(Map<String, ?> map) {
        return b1.f(map, "name");
    }

    public static Set<vb.l1.b> p(Map<String, ?> map) {
        Set<vb.l1.b> setF = f(map, "nonFatalStatusCodes");
        if (setF == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(vb.l1.b.class));
        }
        j6.w.a(!setF.contains(vb.l1.b.OK), "%s must not contain OK", "nonFatalStatusCodes");
        return setF;
    }

    public static Long q(Map<String, ?> map) {
        return b1.l(map, "perAttemptRecvTimeout");
    }

    public static Map<String, ?> r(Map<String, ?> map) {
        return b1.j(map, "retryPolicy");
    }

    public static Set<vb.l1.b> s(Map<String, ?> map) {
        Set<vb.l1.b> setF = f(map, "retryableStatusCodes");
        j6.w.a(setF != null, "%s is required in retry policy", "retryableStatusCodes");
        j6.w.a(true ^ setF.contains(vb.l1.b.OK), "%s must not contain OK", "retryableStatusCodes");
        return setF;
    }

    public static String t(Map<String, ?> map) {
        return b1.k(map, "service");
    }

    public static Set<vb.l1.b> u(List<?> list) {
        vb.l1.b bVarValueOf;
        EnumSet enumSetNoneOf = EnumSet.noneOf(vb.l1.b.class);
        for (Object obj : list) {
            if (obj instanceof Double) {
                Double d10 = (Double) obj;
                int iIntValue = d10.intValue();
                j6.w.a(((double) iIntValue) == d10.doubleValue(), "Status code %s is not integral", obj);
                bVarValueOf = vb.l1.h(iIntValue).m();
                j6.w.a(bVarValueOf.i() == d10.intValue(), "Status code %s is not valid", obj);
            } else {
                if (!(obj instanceof String)) {
                    throw new j6.x("Can not convert status code " + obj + " to Status.Code, because its type is " + obj.getClass());
                }
                try {
                    bVarValueOf = vb.l1.b.valueOf((String) obj);
                } catch (IllegalArgumentException e10) {
                    throw new j6.x("Status code " + obj + " is not valid", e10);
                }
            }
            enumSetNoneOf.add(bVarValueOf);
        }
        return Collections.unmodifiableSet(enumSetNoneOf);
    }

    public static c2.d0 v(Map<String, ?> map) {
        Map<String, ?> mapJ;
        if (map == null || (mapJ = b1.j(map, "retryThrottling")) == null) {
            return null;
        }
        float fFloatValue = b1.h(mapJ, "maxTokens").floatValue();
        float fFloatValue2 = b1.h(mapJ, "tokenRatio").floatValue();
        j6.m.v(fFloatValue > 0.0f, "maxToken should be greater than zero");
        j6.m.v(fFloatValue2 > 0.0f, "tokenRatio should be greater than zero");
        return new c2.d0(fFloatValue, fFloatValue2);
    }

    public static Long w(Map<String, ?> map) {
        return b1.l(map, "timeout");
    }

    public static Boolean x(Map<String, ?> map) {
        return b1.d(map, "waitForReady");
    }

    public static vb.c1.c y(List<a> list, vb.v0 v0Var) {
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            String strA = aVar.a();
            vb.u0 u0VarD = v0Var.d(strA);
            if (u0VarD != null) {
                if (!arrayList.isEmpty()) {
                    Logger.getLogger(k2.class.getName()).log(Level.FINEST, "{0} specified by Service Config are not available", arrayList);
                }
                vb.c1.c cVarE = u0VarD.e(aVar.b());
                return cVarE.d() != null ? cVarE : vb.c1.c.a(new b(u0VarD, cVarE.c()));
            }
            arrayList.add(strA);
        }
        return vb.c1.c.b(vb.l1.f17407g.q("None of " + arrayList + " specified by Service Config are available."));
    }

    public static a z(Map<String, ?> map) {
        if (map.size() == 1) {
            String key = map.entrySet().iterator().next().getKey();
            return new a(key, b1.j(map, key));
        }
        throw new RuntimeException("There are " + map.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + map);
    }
}
