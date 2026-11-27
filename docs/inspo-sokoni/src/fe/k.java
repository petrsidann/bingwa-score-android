package fe;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class k extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8406e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8407f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f8408l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Long f8409m;

    public k() {
    }

    public k(String str, String str2, String str3) {
        this.f8406e = str;
        this.f8407f = str2;
        this.f8408l = str3;
        this.f8409m = Long.valueOf(System.currentTimeMillis());
    }

    @Override // fe.a
    public String N() {
        return M();
    }

    @Override // fe.a
    public Map<String, Object> O() {
        HashMap map = new HashMap();
        D("title", map, this.f8406e);
        D("messages", map, this.f8407f);
        D("largeIcon", map, this.f8408l);
        D("timestamp", map, this.f8409m);
        return map;
    }

    @Override // fe.a
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public c a(String str) {
        return (c) super.L(str);
    }

    @Override // fe.a
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public k b(Map<String, Object> map) {
        this.f8406e = h(map, "title", String.class, null);
        this.f8407f = h(map, "messages", String.class, null);
        this.f8408l = h(map, "largeIcon", String.class, null);
        this.f8409m = g(map, "timestamp", Long.class, null);
        return this;
    }
}
