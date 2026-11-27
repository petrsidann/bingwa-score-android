package fe;

import android.content.Context;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import zd.n;
import zd.o;

/* JADX INFO: loaded from: classes2.dex */
public class g extends a {
    public Boolean A;
    public Boolean B;
    public Boolean C;
    public Boolean D;
    public Boolean E;
    public Boolean F;
    public Integer G;
    public Integer H;
    public Integer I;
    public Integer J;
    public Integer K;
    public Integer L;
    public String M;
    public Integer N;
    public Float O;
    public zd.m P;
    public Boolean Q;
    public Boolean R;
    public zd.a S;
    public n T;
    public String U;
    public zd.j V;
    public o W;
    public zd.k X;
    public Calendar Y;
    public zd.k Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public Calendar f8376a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public zd.h f8377b0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8378e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8379f = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f8380l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f8381m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f8382n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f8383o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f8384p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Boolean f8385q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<k> f8386r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Map<String, String> f8387s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f8388t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f8389u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Boolean f8390v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f8391w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f8392x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Boolean f8393y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f8394z;

    public static List<k> S(List<Map> list) {
        ArrayList arrayList = new ArrayList();
        if (!je.k.a(list)) {
            Iterator<Map> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new k().b(it.next()));
            }
        }
        return arrayList;
    }

    @Override // fe.a
    public String N() {
        return M();
    }

    @Override // fe.a
    public Map<String, Object> O() {
        HashMap map = new HashMap();
        D("id", map, this.f8380l);
        D("randomId", map, Boolean.valueOf(this.f8379f));
        D("title", map, this.f8382n);
        D("body", map, this.f8383o);
        D("summary", map, this.f8384p);
        D("showWhen", map, this.f8385q);
        D("wakeUpScreen", map, this.A);
        D("fullScreenIntent", map, this.B);
        D("actionType", map, this.S);
        D("locked", map, this.f8393y);
        D("playSound", map, this.f8390v);
        D("customSound", map, this.f8389u);
        D("ticker", map, this.M);
        H("payload", map, this.f8387s);
        D("autoDismissible", map, this.D);
        D("notificationLayout", map, this.V);
        D("createdSource", map, this.W);
        D("createdLifeCycle", map, this.X);
        D("displayedLifeCycle", map, this.Z);
        E("displayedDate", map, this.f8376a0);
        E("createdDate", map, this.Y);
        D("channelKey", map, this.f8381m);
        D("category", map, this.f8377b0);
        D("autoDismissible", map, this.D);
        D("displayOnForeground", map, this.E);
        D("displayOnBackground", map, this.F);
        D("color", map, this.H);
        D("backgroundColor", map, this.I);
        D("icon", map, this.f8391w);
        D("largeIcon", map, this.f8392x);
        D("bigPicture", map, this.f8394z);
        D("progress", map, this.J);
        D("badge", map, this.K);
        D("timeoutAfter", map, this.L);
        D("groupKey", map, this.f8388t);
        D("privacy", map, this.T);
        D("chronometer", map, this.G);
        D("privateMessage", map, this.U);
        D("roundedLargeIcon", map, this.Q);
        D("roundedBigPicture", map, this.R);
        D("duration", map, this.N);
        D("playState", map, this.P);
        D("playbackSpeed", map, this.O);
        F("messages", map, this.f8386r);
        return map;
    }

    @Override // fe.a
    public void P(Context context) throws ae.a {
        if (this.f8380l == null) {
            throw ae.b.e().c("NotificationContentModel", "MISSING_ARGUMENTS", "Notification id is required", "arguments.required.notificationContent.id");
        }
        Integer num = this.L;
        if (num != null && num.intValue() < 1) {
            this.L = null;
        }
        if (ee.e.h().g(context, this.f8381m) != null) {
            X(context);
            zd.j jVar = this.V;
            if (jVar == null) {
                this.V = zd.j.Default;
            } else if (jVar == zd.j.BigPicture) {
                Z(context);
            }
            W(context);
            Y(context);
            return;
        }
        throw ae.b.e().c("NotificationContentModel", "INVALID_ARGUMENTS", "Notification channel '" + this.f8381m + "' does not exist.", "arguments.invalid.notificationContent." + this.f8381m);
    }

    @Override // fe.a
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public g a(String str) {
        return (g) super.L(str);
    }

    @Override // fe.a
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public g b(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        T(map);
        this.f8380l = f(map, "id", Integer.class, 0);
        this.S = l(map, "actionType", zd.a.class, zd.a.Default);
        this.Y = i(map, "createdDate", Calendar.class, null);
        this.f8376a0 = i(map, "displayedDate", Calendar.class, null);
        this.X = u(map, "createdLifeCycle", zd.k.class, null);
        this.Z = u(map, "displayedLifeCycle", zd.k.class, null);
        this.W = w(map, "createdSource", o.class, o.Local);
        this.f8381m = h(map, "channelKey", String.class, "miscellaneous");
        this.H = f(map, "color", Integer.class, null);
        this.I = f(map, "backgroundColor", Integer.class, null);
        this.f8382n = h(map, "title", String.class, null);
        this.f8383o = h(map, "body", String.class, null);
        this.f8384p = h(map, "summary", String.class, null);
        Boolean bool = Boolean.TRUE;
        this.f8390v = c(map, "playSound", Boolean.class, bool);
        this.f8389u = h(map, "customSound", String.class, null);
        Boolean bool2 = Boolean.FALSE;
        this.A = c(map, "wakeUpScreen", Boolean.class, bool2);
        this.B = c(map, "fullScreenIntent", Boolean.class, bool2);
        this.f8385q = c(map, "showWhen", Boolean.class, bool);
        this.f8393y = c(map, "locked", Boolean.class, bool2);
        this.E = c(map, "displayOnForeground", Boolean.class, bool);
        this.F = c(map, "displayOnBackground", Boolean.class, bool);
        this.C = c(map, "hideLargeIconOnExpand", Boolean.class, bool2);
        this.V = t(map, "notificationLayout", zd.j.class, zd.j.Default);
        this.T = v(map, "privacy", n.class, n.Private);
        this.f8377b0 = r(map, "category", zd.h.class, null);
        this.U = h(map, "privateMessage", String.class, null);
        this.f8391w = h(map, "icon", String.class, null);
        this.f8392x = h(map, "largeIcon", String.class, null);
        this.f8394z = h(map, "bigPicture", String.class, null);
        this.f8387s = A(map, "payload", null);
        this.D = c(map, "autoDismissible", Boolean.class, bool);
        this.J = f(map, "progress", Integer.class, null);
        this.K = f(map, "badge", Integer.class, null);
        this.L = f(map, "timeoutAfter", Integer.class, null);
        this.f8388t = h(map, "groupKey", String.class, null);
        this.G = f(map, "chronometer", Integer.class, null);
        this.M = h(map, "ticker", String.class, null);
        this.Q = c(map, "roundedLargeIcon", Boolean.class, bool2);
        this.R = c(map, "roundedBigPicture", Boolean.class, bool2);
        this.N = f(map, "duration", Integer.class, null);
        this.O = d(map, "playbackSpeed", Float.class, null);
        this.P = zd.m.i(map.get("playState"));
        this.f8386r = S(z(map, "messages", null));
        return this;
    }

    public void T(Map<String, Object> map) {
        if (map.containsKey("autoCancel")) {
            de.a.d("AwesomeNotifications", "autoCancel is now deprecated. Please use autoDismissible instead.");
            this.D = c(map, "autoCancel", Boolean.class, Boolean.TRUE);
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value != null && value.equals("AppKilled")) {
                de.a.d("AwesomeNotifications", "AppKilled is now deprecated. Please use Terminated instead.");
                map.put(entry.getKey(), zd.k.Terminated);
            }
        }
    }

    public boolean U(zd.k kVar, o oVar) {
        if (this.Y != null) {
            return false;
        }
        this.Y = je.d.g().e();
        this.X = kVar;
        this.W = oVar;
        return true;
    }

    public boolean V(zd.k kVar) {
        this.f8376a0 = je.d.g().e();
        this.Z = kVar;
        return true;
    }

    public final void W(Context context) throws ae.a {
        if (!this.f8328b.e(this.f8394z).booleanValue() && !je.b.k().l(context, this.f8394z).booleanValue()) {
            throw ae.b.e().c("NotificationContentModel", "INVALID_ARGUMENTS", "bigPicture is invalid", "arguments.invalid.invalid.bigPicture");
        }
    }

    public final void X(Context context) throws ae.a {
        if (this.f8328b.e(this.f8391w).booleanValue()) {
            return;
        }
        if (je.b.k().b(this.f8391w) == zd.g.Resource && je.b.k().l(context, this.f8391w).booleanValue()) {
            return;
        }
        throw ae.b.e().c("NotificationContentModel", "INVALID_ARGUMENTS", "Small icon ('" + this.f8391w + "') must be a valid media native resource type.", "arguments.invalid.smallIcon");
    }

    public final void Y(Context context) throws ae.a {
        if (!this.f8328b.e(this.f8392x).booleanValue() && !je.b.k().l(context, this.f8392x).booleanValue()) {
            throw ae.b.e().c("NotificationContentModel", "INVALID_ARGUMENTS", "largeIcon is invalid", "arguments.invalid.invalid.largeIcon");
        }
    }

    public final void Z(Context context) throws ae.a {
        if (this.f8328b.e(this.f8392x).booleanValue() && this.f8328b.e(this.f8394z).booleanValue()) {
            throw ae.b.e().c("NotificationContentModel", "MISSING_ARGUMENTS", "bigPicture or largeIcon is required", "arguments.required.image.required");
        }
    }
}
