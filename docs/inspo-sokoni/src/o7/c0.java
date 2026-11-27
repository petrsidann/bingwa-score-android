package o7;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, Object> f13684b;

    public c0(String str, Map<String, Object> map) {
        this.f13683a = str;
        this.f13684b = map;
    }

    public long a() {
        return h("auth_time");
    }

    public Map<String, Object> b() {
        return this.f13684b;
    }

    public long c() {
        return h("exp");
    }

    public long d() {
        return h("iat");
    }

    public String e() {
        Map map = (Map) this.f13684b.get("firebase");
        if (map != null) {
            return (String) map.get("sign_in_provider");
        }
        return null;
    }

    public String f() {
        Map map = (Map) this.f13684b.get("firebase");
        if (map != null) {
            return (String) map.get("sign_in_second_factor");
        }
        return null;
    }

    public String g() {
        return this.f13683a;
    }

    public final long h(String str) {
        Integer num = (Integer) this.f13684b.get(str);
        if (num == null) {
            return 0L;
        }
        return num.longValue();
    }
}
