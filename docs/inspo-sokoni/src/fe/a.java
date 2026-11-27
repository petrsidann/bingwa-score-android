package fe;

import android.content.Context;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import je.n;
import je.o;
import zd.p;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Map<String, Object> f8326d = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e9.e f8329c = new e9.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f8327a = n.c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f8328b = o.c();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: fe.a$a, reason: collision with other inner class name */
    public class C0145a<T> extends o6.b<List<T>> {
        public C0145a() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    public class b<K, T> extends o6.b<Map<T, K>> {
        public b() {
        }
    }

    public <T, K> Map<T, K> A(Map<String, Object> map, String str, Map<T, K> map2) {
        Object obj = map.get(str);
        if (obj == null) {
            return map2;
        }
        Type typeB = new b().b();
        try {
            e9.e eVar = this.f8329c;
            Map<T, K> map3 = (Map) eVar.h(eVar.r(obj), typeB);
            return map3 != null ? map3 : map2;
        } catch (Exception unused) {
            return map2;
        }
    }

    public void C(String str, Map<String, Object> map, a aVar) {
        if (aVar == null) {
            return;
        }
        map.put(str, aVar.O());
    }

    public void D(String str, Map<String, Object> map, Serializable serializable) {
        if (serializable == null) {
            return;
        }
        if (serializable instanceof p) {
            K(str, map, (p) serializable);
        } else {
            map.put(str, serializable);
        }
    }

    public void E(String str, Map<String, Object> map, Calendar calendar) {
        if (calendar == null) {
            return;
        }
        map.put(str, this.f8327a.d(calendar));
    }

    public void F(String str, Map<String, Object> map, List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object objO : list) {
            if (objO instanceof a) {
                objO = ((a) objO).O();
            } else if (objO instanceof p) {
                objO = ((p) objO).h();
            } else if (objO instanceof Calendar) {
                objO = n.c().d((Calendar) objO);
            } else if (objO instanceof Serializable) {
            }
            arrayList.add(objO);
        }
        map.put(str, arrayList);
    }

    public void H(String str, Map<String, Object> map, Map map2) {
        if (map2 == null || map2.isEmpty()) {
            return;
        }
        HashMap map3 = new HashMap();
        for (Map.Entry entry : map2.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                boolean z10 = value instanceof a;
                String str2 = (String) entry.getKey();
                if (z10) {
                    value = ((a) value).O();
                }
                map3.put(str2, value);
            }
        }
        map.put(str, map3);
    }

    public void I(String str, Map<String, Object> map, TimeZone timeZone) {
        if (timeZone == null) {
            return;
        }
        map.put(str, this.f8327a.e(timeZone));
    }

    public final void K(String str, Map<String, Object> map, p pVar) {
        if (pVar == null) {
            return;
        }
        map.put(str, pVar.h());
    }

    public a L(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return b(je.j.e(str));
    }

    public String M() {
        return je.j.g(O());
    }

    public abstract String N();

    public abstract Map<String, Object> O();

    public abstract void P(Context context);

    public abstract a a(String str);

    public abstract a b(Map<String, Object> map);

    public Boolean c(Map<String, Object> map, String str, Class<Boolean> cls, Boolean bool) {
        Object obj = map.get(str);
        return (obj != null && (obj instanceof Boolean)) ? (Boolean) obj : bool;
    }

    public Float d(Map<String, Object> map, String str, Class<Float> cls, Float f10) {
        Object obj = map.get(str);
        return (obj != null && (obj instanceof Number)) ? Float.valueOf(((Number) obj).floatValue()) : f10;
    }

    public Integer f(Map<String, Object> map, String str, Class<Integer> cls, Integer num) {
        Object obj = map.get(str);
        return (obj != null && (obj instanceof Number)) ? Integer.valueOf(((Number) obj).intValue()) : num;
    }

    public Long g(Map<String, Object> map, String str, Class<Long> cls, Long l10) {
        Object obj = map.get(str);
        if (obj == null) {
            return l10;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (cls == Long.class && (obj instanceof String)) {
            Matcher matcher = Pattern.compile("(0x|#)(\\w{2})?(\\w{6})", 2).matcher((String) obj);
            if (matcher.find()) {
                String strGroup = matcher.group(2);
                StringBuilder sb2 = new StringBuilder();
                if (strGroup == null) {
                    strGroup = "FF";
                }
                sb2.append(strGroup);
                sb2.append(matcher.group(3));
                String string = sb2.toString();
                return cls.cast(Long.valueOf(o.c().e(string).booleanValue() ? 0L : 0 + Long.parseLong(string, 16)));
            }
        }
        return l10;
    }

    public String h(Map<String, Object> map, String str, Class<String> cls, String str2) {
        Object obj = map.get(str);
        return (obj != null && (obj instanceof String)) ? (String) obj : str2;
    }

    public Calendar i(Map<String, Object> map, String str, Class<Calendar> cls, Calendar calendar) {
        Object obj = map.get(str);
        return (obj != null && (obj instanceof String)) ? this.f8327a.a((String) obj) : calendar;
    }

    public TimeZone j(Map<String, Object> map, String str, Class<TimeZone> cls, TimeZone timeZone) {
        Object obj = map.get(str);
        return obj == null ? timeZone : this.f8327a.b((String) obj);
    }

    public zd.a l(Map<String, Object> map, String str, Class<zd.a> cls, zd.a aVar) {
        Object obj = map.get(str);
        return (obj != null && (obj instanceof String)) ? zd.a.i((String) obj) : aVar;
    }

    public zd.b m(Map<String, Object> map, String str, Class<zd.b> cls, zd.b bVar) {
        Object obj = map.get(str);
        return (obj != null && (obj instanceof String)) ? zd.b.i((String) obj) : bVar;
    }

    public zd.c n(Map<String, Object> map, String str, Class<zd.c> cls, zd.c cVar) {
        Object obj = map.get(str);
        return (obj != null && (obj instanceof String)) ? zd.c.i((String) obj) : cVar;
    }

    public zd.d o(Map<String, Object> map, String str, Class<zd.d> cls, zd.d dVar) {
        Object obj = map.get(str);
        return (obj != null && (obj instanceof String)) ? zd.d.i((String) obj) : dVar;
    }

    public zd.e p(Map<String, Object> map, String str, Class<zd.e> cls, zd.e eVar) {
        Object obj = map.get(str);
        return (obj != null && (obj instanceof String)) ? zd.e.i((String) obj) : eVar;
    }

    public zd.f q(Map<String, Object> map, String str, Class<zd.f> cls, zd.f fVar) {
        Object obj = map.get(str);
        return (obj != null && (obj instanceof String)) ? zd.f.i((String) obj) : fVar;
    }

    public zd.h r(Map<String, Object> map, String str, Class<zd.h> cls, zd.h hVar) {
        Object obj = map.get(str);
        return (obj != null && (obj instanceof String)) ? zd.h.i((String) obj) : hVar;
    }

    public zd.i s(Map<String, Object> map, String str, Class<zd.i> cls, zd.i iVar) {
        Object obj = map.get(str);
        return (obj != null && (obj instanceof String)) ? zd.i.k((String) obj) : iVar;
    }

    public zd.j t(Map<String, Object> map, String str, Class<zd.j> cls, zd.j jVar) {
        Object obj = map.get(str);
        if (obj == null) {
            return jVar;
        }
        if (obj instanceof String) {
            return zd.j.i((String) obj);
        }
        return obj instanceof zd.j ? (zd.j) obj : jVar;
    }

    public zd.k u(Map<String, Object> map, String str, Class<zd.k> cls, zd.k kVar) {
        Object obj = map.get(str);
        if (obj == null) {
            return kVar;
        }
        if (obj instanceof String) {
            return zd.k.i((String) obj);
        }
        return obj instanceof zd.k ? (zd.k) obj : kVar;
    }

    public zd.n v(Map<String, Object> map, String str, Class<zd.n> cls, zd.n nVar) {
        Object obj = map.get(str);
        if (obj == null) {
            return nVar;
        }
        if (obj instanceof String) {
            return zd.n.i((String) obj);
        }
        return obj instanceof zd.n ? (zd.n) obj : nVar;
    }

    public zd.o w(Map<String, Object> map, String str, Class<zd.o> cls, zd.o oVar) {
        Object obj = map.get(str);
        if (obj == null) {
            return oVar;
        }
        if (obj instanceof String) {
            return zd.o.i((String) obj);
        }
        return obj instanceof zd.o ? (zd.o) obj : oVar;
    }

    public long[] x(Map<String, Object> map, String str, Class<long[]> cls, long[] jArr) {
        Object obj = map.get(str);
        if (obj == null) {
            return jArr;
        }
        if (obj instanceof List) {
            return n6.h.f((List) obj);
        }
        return obj instanceof long[] ? (long[]) obj : jArr;
    }

    public List<Calendar> y(Map<String, Object> map, String str, List<Calendar> list) {
        Object obj = map.get(str);
        if (obj == null || !List.class.isAssignableFrom(obj.getClass())) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            arrayList.add(this.f8327a.a((String) it.next()));
        }
        return arrayList;
    }

    public <T> List<T> z(Map<String, Object> map, String str, List<T> list) {
        Object obj = map.get(str);
        if (obj == null) {
            return list;
        }
        Type typeB = new C0145a().b();
        try {
            e9.e eVar = this.f8329c;
            List<T> list2 = (List) eVar.h(eVar.r(obj), typeB);
            return list2 != null ? list2 : list;
        } catch (Exception unused) {
            return list;
        }
    }
}
