package fe;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TimeZone f8416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Calendar f8417f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Boolean f8418l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Boolean f8419m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Boolean f8420n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f8421o;

    public static m S(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        if (map.containsKey("crontabExpression") || map.containsKey("preciseSchedules") || map.containsKey("expirationDateTime")) {
            return new h().b(map);
        }
        if (map.containsKey("second") || map.containsKey("minute") || map.containsKey("hour") || map.containsKey("day") || map.containsKey("month") || map.containsKey("year") || map.containsKey("era") || map.containsKey("millisecond") || map.containsKey("weekday") || map.containsKey("weekOfMonth") || map.containsKey("weekOfYear")) {
            return new d().b(map);
        }
        if (map.containsKey("interval")) {
            return new i().b(map);
        }
        return null;
    }

    @Override // fe.a
    public Map<String, Object> O() {
        HashMap map = new HashMap();
        I("timeZone", map, this.f8416e);
        E("createdDate", map, this.f8417f);
        D("repeats", map, this.f8418l);
        D("allowWhileIdle", map, this.f8419m);
        D("preciseAlarm", map, this.f8420n);
        D("delayTolerance", map, this.f8421o);
        return map;
    }

    public m Q(Map<String, Object> map) {
        this.f8416e = j(map, "timeZone", TimeZone.class, TimeZone.getDefault());
        this.f8417f = i(map, "createdDate", Calendar.class, null);
        Boolean bool = Boolean.FALSE;
        this.f8418l = c(map, "repeats", Boolean.class, bool);
        this.f8419m = c(map, "allowWhileIdle", Boolean.class, bool);
        this.f8420n = c(map, "preciseAlarm", Boolean.class, bool);
        this.f8421o = f(map, "delayTolerance", Integer.class, 0);
        return this;
    }

    public abstract Calendar R(Calendar calendar);

    public Boolean T() {
        je.d dVarG = je.d.g();
        Boolean boolValueOf = Boolean.valueOf(je.c.a().b(this.f8418l));
        this.f8418l = boolValueOf;
        return (this.f8417f != null || boolValueOf.booleanValue()) ? U(dVarG.e()) : Boolean.FALSE;
    }

    public Boolean U(Calendar calendar) {
        Calendar calendarR = R(calendar);
        return Boolean.valueOf(calendarR != null && (calendarR.after(calendar) || calendarR.equals(calendar)));
    }
}
