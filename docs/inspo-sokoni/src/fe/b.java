package fe;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8333f = "0";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f8334l = "0";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f8335m;

    @Override // fe.a
    public String N() {
        return M();
    }

    @Override // fe.a
    public Map<String, Object> O() {
        HashMap map = new HashMap();
        D("defaultIcon", map, this.f8332e);
        D("silentHandle", map, this.f8333f);
        D("awesomeDartBGHandle", map, this.f8334l);
        D("bgHandleClass", map, this.f8335m);
        return map;
    }

    @Override // fe.a
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public b a(String str) {
        return (b) super.L(str);
    }

    @Override // fe.a
    public a b(Map<String, Object> map) {
        this.f8332e = h(map, "defaultIcon", String.class, null);
        this.f8333f = h(map, "silentHandle", String.class, null);
        this.f8334l = h(map, "awesomeDartBGHandle", String.class, null);
        this.f8335m = h(map, "bgHandleClass", String.class, null);
        return this;
    }
}
