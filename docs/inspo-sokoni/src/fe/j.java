package fe;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class j extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8401f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f8402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f8403m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f8404n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Map<String, String> f8405o;

    @Override // fe.a
    public String N() {
        return M();
    }

    @Override // fe.a
    public Map<String, Object> O() {
        HashMap map = new HashMap();
        D("title", map, this.f8400e);
        D("body", map, this.f8401f);
        D("summary", map, this.f8402l);
        D("largeIcon", map, this.f8403m);
        D("bigPicture", map, this.f8404n);
        H("buttonLabels", map, this.f8405o);
        return map;
    }

    @Override // fe.a
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public j a(String str) {
        return (j) super.L(str);
    }

    @Override // fe.a
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public j b(Map<String, Object> map) {
        this.f8400e = h(map, "title", String.class, null);
        this.f8401f = h(map, "body", String.class, null);
        this.f8402l = h(map, "summary", String.class, null);
        this.f8403m = h(map, "largeIcon", String.class, null);
        this.f8404n = h(map, "bigPicture", String.class, null);
        this.f8405o = A(map, "buttonLabels", null);
        return this;
    }
}
