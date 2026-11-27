package ga;

import fb.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends ga.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f9113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f9114b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9115c;

    public class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f9116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f9117b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f9118c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f9119d;

        public a() {
        }

        @Override // ga.f
        public void a(Object obj) {
            this.f9116a = obj;
        }

        @Override // ga.f
        public void b(String str, String str2, Object obj) {
            this.f9117b = str;
            this.f9118c = str2;
            this.f9119d = obj;
        }
    }

    public c(Map<String, Object> map, boolean z10) {
        this.f9113a = map;
        this.f9115c = z10;
    }

    @Override // ga.e
    public <T> T c(String str) {
        return (T) this.f9113a.get(str);
    }

    @Override // ga.b, ga.e
    public boolean e() {
        return this.f9115c;
    }

    @Override // ga.e
    public String getMethod() {
        return (String) this.f9113a.get("method");
    }

    @Override // ga.e
    public boolean h(String str) {
        return this.f9113a.containsKey(str);
    }

    @Override // ga.a
    public f n() {
        return this.f9114b;
    }

    public Map<String, Object> o() {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put("code", this.f9114b.f9117b);
        map2.put("message", this.f9114b.f9118c);
        map2.put("data", this.f9114b.f9119d);
        map.put("error", map2);
        return map;
    }

    public Map<String, Object> p() {
        HashMap map = new HashMap();
        map.put("result", this.f9114b.f9116a);
        return map;
    }

    public void q(j.d dVar) {
        a aVar = this.f9114b;
        dVar.b(aVar.f9117b, aVar.f9118c, aVar.f9119d);
    }

    public void r(List<Map<String, Object>> list) {
        if (e()) {
            return;
        }
        list.add(o());
    }

    public void s(List<Map<String, Object>> list) {
        if (e()) {
            return;
        }
        list.add(p());
    }
}
