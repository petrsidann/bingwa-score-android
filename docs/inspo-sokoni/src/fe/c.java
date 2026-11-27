package fe;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8337f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f8338l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f8339m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Boolean f8340n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Boolean f8341o = Boolean.FALSE;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Boolean f8342p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Boolean f8343q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Boolean f8344r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public zd.a f8345s;

    @Override // fe.a
    public String N() {
        return M();
    }

    @Override // fe.a
    public Map<String, Object> O() {
        HashMap map = new HashMap();
        D("key", map, this.f8336e);
        D("key", map, this.f8336e);
        D("icon", map, this.f8337f);
        D("label", map, this.f8338l);
        D("color", map, this.f8339m);
        D("actionType", map, this.f8345s);
        D("enabled", map, this.f8340n);
        D("requireInputText", map, this.f8341o);
        D("autoDismissible", map, this.f8342p);
        D("showInCompactView", map, this.f8343q);
        D("isDangerousOption", map, this.f8344r);
        return map;
    }

    @Override // fe.a
    public void P(Context context) throws ae.a {
        if (this.f8328b.e(this.f8336e).booleanValue()) {
            throw ae.b.e().c("NotificationButtonModel", "MISSING_ARGUMENTS", "Button key is required", "arguments.invalid.button.actionKey");
        }
        if (this.f8328b.e(this.f8338l).booleanValue()) {
            throw ae.b.e().c("NotificationButtonModel", "MISSING_ARGUMENTS", "Button label is required", "arguments.invalid.button.label");
        }
    }

    public final void Q() {
        if (this.f8345s == zd.a.InputField) {
            de.a.a("AwesomeNotifications", "InputField is deprecated. Please use requireInputText instead.");
            this.f8345s = zd.a.SilentAction;
            this.f8341o = Boolean.TRUE;
        }
    }

    @Override // fe.a
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public c a(String str) {
        return (c) super.L(str);
    }

    @Override // fe.a
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public c b(Map<String, Object> map) {
        T(map);
        this.f8336e = h(map, "key", String.class, null);
        this.f8337f = h(map, "icon", String.class, null);
        this.f8338l = h(map, "label", String.class, null);
        this.f8339m = f(map, "color", Integer.class, null);
        this.f8345s = l(map, "actionType", zd.a.class, zd.a.Default);
        Boolean bool = Boolean.TRUE;
        this.f8340n = c(map, "enabled", Boolean.class, bool);
        Boolean bool2 = Boolean.FALSE;
        this.f8341o = c(map, "requireInputText", Boolean.class, bool2);
        this.f8344r = c(map, "isDangerousOption", Boolean.class, bool2);
        this.f8342p = c(map, "autoDismissible", Boolean.class, bool);
        this.f8343q = c(map, "showInCompactView", Boolean.class, bool2);
        return this;
    }

    public final void T(Map<String, Object> map) {
        if (map.containsKey("autoCancel")) {
            de.a.e("AwesomeNotifications", "autoCancel is deprecated. Please use autoDismissible instead.");
            this.f8342p = c(map, "autoCancel", Boolean.class, Boolean.TRUE);
        }
        if (map.containsKey("buttonType")) {
            de.a.e("AwesomeNotifications", "buttonType is deprecated. Please use actionType instead.");
            this.f8345s = l(map, "buttonType", zd.a.class, zd.a.Default);
        }
        Q();
    }
}
