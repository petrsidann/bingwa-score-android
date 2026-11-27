package fe;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import zd.n;

/* JADX INFO: loaded from: classes2.dex */
public class f extends a {
    public zd.e A;
    public Integer B;
    public String C;
    public Long D;
    public Boolean E;
    public Boolean F;
    public Boolean G;
    public n H;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8360f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f8361l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Boolean f8362m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f8363n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public zd.i f8364o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Boolean f8365p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f8366q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public zd.b f8367r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Boolean f8368s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long[] f8369t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Boolean f8370u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Integer f8371v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Integer f8372w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Integer f8373x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f8374y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public zd.f f8375z;

    @Override // fe.a
    public String N() {
        return M();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.io.Serializable, long[]] */
    @Override // fe.a
    public Map<String, Object> O() {
        HashMap map = new HashMap();
        D("iconResourceId", map, this.B);
        D("icon", map, this.C);
        D("defaultColor", map, this.D);
        D("channelKey", map, this.f8359e);
        D("channelName", map, this.f8360f);
        D("channelDescription", map, this.f8361l);
        D("channelShowBadge", map, this.f8362m);
        D("channelGroupKey", map, this.f8363n);
        D("playSound", map, this.f8365p);
        D("soundSource", map, this.f8366q);
        D("enableVibration", map, this.f8368s);
        D("vibrationPattern", map, this.f8369t);
        D("enableLights", map, this.f8370u);
        D("ledColor", map, this.f8371v);
        D("ledOnMs", map, this.f8372w);
        D("ledOffMs", map, this.f8373x);
        D("groupKey", map, this.f8374y);
        D("groupSort", map, this.f8375z);
        D("importance", map, this.f8364o);
        D("groupAlertBehavior", map, this.A);
        D("defaultPrivacy", map, this.H);
        D("defaultRingtoneType", map, this.f8367r);
        D("locked", map, this.E);
        D("onlyAlertOnce", map, this.F);
        D("criticalAlerts", map, this.G);
        return map;
    }

    @Override // fe.a
    public void P(Context context) throws ae.a {
        if (this.C != null && je.b.k().b(this.C) != zd.g.Resource) {
            throw ae.b.e().c("NotificationChannelModel", "INVALID_ARGUMENTS", "Icon is not a Resource media type", "arguments.invalid.notificationContent");
        }
        if (this.f8328b.e(this.f8359e).booleanValue()) {
            throw ae.b.e().c("NotificationChannelModel", "INVALID_ARGUMENTS", "Channel key cannot be null or empty", "arguments.invalid.channel.key");
        }
        if (this.f8328b.e(this.f8360f).booleanValue()) {
            throw ae.b.e().c("NotificationChannelModel", "INVALID_ARGUMENTS", "Channel name cannot be null or empty", "arguments.invalid.channel.name");
        }
        if (this.f8328b.e(this.f8361l).booleanValue()) {
            throw ae.b.e().c("NotificationChannelModel", "INVALID_ARGUMENTS", "Channel description cannot be null or empty", "arguments.invalid.channel.description");
        }
        if (this.f8365p == null) {
            throw ae.b.e().c("NotificationChannelModel", "INVALID_ARGUMENTS", "Play sound selector cannot be null or empty", "arguments.invalid.channel.playSound");
        }
        if (this.f8371v != null && (this.f8372w == null || this.f8373x == null)) {
            throw ae.b.e().c("NotificationChannelModel", "INVALID_ARGUMENTS", "Standard led on and off times cannot be null or empty", "arguments.invalid.channel.led");
        }
        if (je.c.a().b(this.f8365p) && !this.f8328b.e(this.f8366q).booleanValue() && !je.a.f().g(context, this.f8366q).booleanValue()) {
            throw ae.b.e().c("NotificationChannelModel", "INVALID_ARGUMENTS", "Audio media is not valid", "arguments.invalid.channel.sound");
        }
    }

    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public f clone() {
        f fVar = new f();
        fVar.B = this.B;
        fVar.D = this.D;
        fVar.f8359e = this.f8359e;
        fVar.f8360f = this.f8360f;
        fVar.f8361l = this.f8361l;
        fVar.f8362m = this.f8362m;
        fVar.f8364o = this.f8364o;
        fVar.f8365p = this.f8365p;
        fVar.f8366q = this.f8366q;
        fVar.f8368s = this.f8368s;
        fVar.f8369t = this.f8369t;
        fVar.f8370u = this.f8370u;
        fVar.f8371v = this.f8371v;
        fVar.f8372w = this.f8372w;
        fVar.f8373x = this.f8373x;
        fVar.f8374y = this.f8374y;
        fVar.E = this.E;
        fVar.F = this.F;
        fVar.H = this.H;
        fVar.f8367r = this.f8367r;
        fVar.f8375z = this.f8375z;
        fVar.A = this.A;
        fVar.G = this.G;
        return fVar;
    }

    @Override // fe.a
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public f a(String str) {
        return (f) super.L(str);
    }

    @Override // fe.a
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public f b(Map<String, Object> map) {
        this.B = f(map, "iconResourceId", Integer.class, null);
        this.C = h(map, "icon", String.class, null);
        this.D = g(map, "defaultColor", Long.class, 4278190080L);
        this.f8359e = h(map, "channelKey", String.class, "miscellaneous");
        this.f8360f = h(map, "channelName", String.class, "Notifications");
        this.f8361l = h(map, "channelDescription", String.class, "Notifications");
        Boolean bool = Boolean.FALSE;
        this.f8362m = c(map, "channelShowBadge", Boolean.class, bool);
        this.f8363n = h(map, "channelGroupKey", String.class, null);
        Boolean bool2 = Boolean.TRUE;
        this.f8365p = c(map, "playSound", Boolean.class, bool2);
        this.f8366q = h(map, "soundSource", String.class, null);
        this.G = c(map, "criticalAlerts", Boolean.class, bool);
        this.f8368s = c(map, "enableVibration", Boolean.class, bool2);
        this.f8369t = x(map, "vibrationPattern", long[].class, null);
        this.f8371v = f(map, "ledColor", Integer.class, -1);
        this.f8370u = c(map, "enableLights", Boolean.class, bool2);
        this.f8372w = f(map, "ledOnMs", Integer.class, 300);
        this.f8373x = f(map, "ledOffMs", Integer.class, 700);
        this.f8364o = s(map, "importance", zd.i.class, zd.i.Default);
        this.f8375z = q(map, "groupSort", zd.f.class, zd.f.Desc);
        this.A = p(map, "groupAlertBehavior", zd.e.class, zd.e.All);
        this.H = v(map, "defaultPrivacy", n.class, n.Private);
        this.f8367r = m(map, "defaultRingtoneType", zd.b.class, zd.b.Notification);
        this.f8374y = h(map, "groupKey", String.class, null);
        this.E = c(map, "locked", Boolean.class, bool);
        this.F = c(map, "onlyAlertOnce", Boolean.class, bool);
        return this;
    }

    public String T(Context context, boolean z10) {
        U(context);
        if (z10) {
            return this.f8328b.a(N());
        }
        f fVarClone = clone();
        fVarClone.f8360f = "";
        fVarClone.f8361l = "";
        fVarClone.f8374y = null;
        return this.f8359e + "_" + this.f8328b.a(fVarClone.N());
    }

    public void U(Context context) {
        if (this.B == null && this.C != null && je.b.k().b(this.C) == zd.g.Resource) {
            int iJ = je.b.k().j(context, this.C);
            this.B = iJ > 0 ? Integer.valueOf(iJ) : null;
        }
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return je.e.d(fVar.B, this.B) && je.e.d(fVar.D, this.D) && je.e.d(fVar.f8359e, this.f8359e) && je.e.d(fVar.f8360f, this.f8360f) && je.e.d(fVar.f8361l, this.f8361l) && je.e.d(fVar.f8362m, this.f8362m) && je.e.d(fVar.f8364o, this.f8364o) && je.e.d(fVar.f8365p, this.f8365p) && je.e.d(fVar.f8366q, this.f8366q) && je.e.d(fVar.f8368s, this.f8368s) && je.e.d(fVar.f8369t, this.f8369t) && je.e.d(fVar.f8370u, this.f8370u) && je.e.d(fVar.f8371v, this.f8371v) && je.e.d(fVar.f8372w, this.f8372w) && je.e.d(fVar.f8373x, this.f8373x) && je.e.d(fVar.f8374y, this.f8374y) && je.e.d(fVar.E, this.E) && je.e.d(fVar.G, this.G) && je.e.d(fVar.F, this.F) && je.e.d(fVar.H, this.H) && je.e.d(fVar.f8367r, this.f8367r) && je.e.d(fVar.f8375z, this.f8375z) && je.e.d(fVar.A, this.A);
    }
}
