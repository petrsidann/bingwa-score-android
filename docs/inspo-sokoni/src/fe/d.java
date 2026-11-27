package fe;

import android.content.Context;
import java.util.Calendar;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d extends m {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f8346p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f8347q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f8348r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Integer f8349s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Integer f8350t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Integer f8351u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Integer f8352v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Integer f8353w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Integer f8354x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Integer f8355y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Integer f8356z;

    public static Integer X(Integer num) {
        if (num == null) {
            return null;
        }
        if (num.intValue() <= 0 || num.intValue() > 7) {
            return num;
        }
        if (num.intValue() == 7) {
            return 1;
        }
        return Integer.valueOf(num.intValue() + 1);
    }

    public static Integer Y(Integer num) {
        if (num == null) {
            return null;
        }
        if (num.intValue() <= 0 || num.intValue() > 7) {
            return num;
        }
        if (num.intValue() == 1) {
            return 7;
        }
        return Integer.valueOf(num.intValue() - 1);
    }

    @Override // fe.a
    public String N() {
        return M();
    }

    @Override // fe.m, fe.a
    public Map<String, Object> O() {
        Map<String, Object> mapO = super.O();
        D("era", mapO, this.f8346p);
        D("year", mapO, this.f8347q);
        D("month", mapO, this.f8348r);
        D("day", mapO, this.f8349s);
        D("hour", mapO, this.f8350t);
        D("minute", mapO, this.f8351u);
        D("second", mapO, this.f8352v);
        D("millisecond", mapO, this.f8353w);
        D("weekOfMonth", mapO, this.f8355y);
        D("weekOfYear", mapO, this.f8356z);
        D("weekday", mapO, Y(this.f8354x));
        return mapO;
    }

    @Override // fe.a
    public void P(Context context) throws ae.a {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        Integer num8;
        Integer num9;
        Integer num10;
        Integer num11 = this.f8346p;
        if (num11 == null && this.f8347q == null && this.f8348r == null && this.f8349s == null && this.f8350t == null && this.f8351u == null && this.f8352v == null && this.f8353w == null && this.f8354x == null && this.f8355y == null && this.f8356z == null) {
            throw ae.b.e().c("NotificationCalendarModel", "INVALID_ARGUMENTS", "At least one time condition is required", "arguments.invalid.notificationCalendar");
        }
        if ((num11 != null && !je.i.d(num11, 0, Integer.valueOf(com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER)).booleanValue()) || (((num = this.f8347q) != null && !je.i.d(num, 0, Integer.valueOf(com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER)).booleanValue()) || (((num2 = this.f8348r) != null && !je.i.d(num2, 1, 12).booleanValue()) || (((num3 = this.f8349s) != null && !je.i.d(num3, 1, 31).booleanValue()) || (((num4 = this.f8350t) != null && !je.i.d(num4, 0, 23).booleanValue()) || (((num5 = this.f8351u) != null && !je.i.d(num5, 0, 59).booleanValue()) || (((num6 = this.f8352v) != null && !je.i.d(num6, 0, 59).booleanValue()) || (((num7 = this.f8353w) != null && !je.i.d(num7, 0, 999).booleanValue()) || (((num8 = this.f8354x) != null && !je.i.d(num8, 1, 7).booleanValue()) || (((num9 = this.f8355y) != null && !je.i.d(num9, 1, 6).booleanValue()) || ((num10 = this.f8356z) != null && !je.i.d(num10, 1, 53).booleanValue()))))))))))) {
            throw ae.b.e().c("NotificationCalendarModel", "INVALID_ARGUMENTS", "The time conditions are invalid", "arguments.invalid.notificationCalendar");
        }
    }

    @Override // fe.m
    public Calendar R(Calendar calendar) throws ae.a {
        String string;
        if (this.f8416e == null) {
            throw ae.b.e().c("NotificationCalendarModel", "INVALID_ARGUMENTS", "Invalid time zone", "arguments.invalid.notificationCalendar.timeZone");
        }
        StringBuilder sb2 = new StringBuilder();
        Integer num = this.f8352v;
        sb2.append(num == null ? "*" : num.toString());
        sb2.append(" ");
        Integer num2 = this.f8351u;
        sb2.append(num2 == null ? "*" : num2.toString());
        sb2.append(" ");
        Integer num3 = this.f8350t;
        sb2.append(num3 == null ? "*" : num3.toString());
        sb2.append(" ");
        if (this.f8354x != null) {
            string = "?";
        } else {
            Integer num4 = this.f8349s;
            string = num4 == null ? "*" : num4.toString();
        }
        sb2.append(string);
        sb2.append(" ");
        Integer num5 = this.f8348r;
        sb2.append(num5 == null ? "*" : num5.toString());
        sb2.append(" ");
        Integer num6 = this.f8354x;
        sb2.append(num6 != null ? num6.toString() : "?");
        sb2.append(" ");
        Integer num7 = this.f8347q;
        sb2.append(num7 != null ? num7.toString() : "*");
        return je.f.b(calendar, sb2.toString(), this.f8416e);
    }

    @Override // fe.a
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public d a(String str) {
        return (d) super.L(str);
    }

    @Override // fe.a
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public d b(Map<String, Object> map) {
        super.Q(map);
        this.f8346p = f(map, "era", Integer.class, null);
        this.f8347q = f(map, "year", Integer.class, null);
        this.f8348r = f(map, "month", Integer.class, null);
        this.f8349s = f(map, "day", Integer.class, null);
        this.f8350t = f(map, "hour", Integer.class, null);
        this.f8351u = f(map, "minute", Integer.class, null);
        this.f8352v = f(map, "second", Integer.class, null);
        this.f8353w = f(map, "millisecond", Integer.class, null);
        this.f8354x = f(map, "weekday", Integer.class, null);
        this.f8355y = f(map, "weekOfMonth", Integer.class, null);
        this.f8356z = f(map, "weekOfYear", Integer.class, null);
        this.f8354x = X(this.f8354x);
        return this;
    }
}
