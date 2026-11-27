package je;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f11405a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static TimeZone f11406b = TimeZone.getTimeZone("GMT");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static TimeZone f11407c = TimeZone.getDefault();

    public static d g() {
        return f11405a;
    }

    public Calendar a(String str) {
        if (o.c().e(str).booleanValue()) {
            return null;
        }
        Matcher matcher = Pattern.compile("^((\\d+)-(\\d+)-(\\d+) (\\d+):(\\d+):(\\d+))( (\\S+))?$", 2).matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(1);
        Objects.requireNonNull(strGroup);
        return b(strGroup, matcher.group(9));
    }

    public Calendar b(String str, String str2) {
        if (o.c().e(str).booleanValue()) {
            return null;
        }
        TimeZone timeZoneK = o.c().e(str2).booleanValue() ? g().k() : p.a().b(str2);
        if (timeZoneK == null) {
            timeZoneK = p.a().b(str2);
        }
        return c(str, timeZoneK);
    }

    public Calendar c(String str, TimeZone timeZone) {
        if (o.c().e(str).booleanValue()) {
            return null;
        }
        Matcher matcher = Pattern.compile("^(\\d+)-(\\d+)-(\\d+) (\\d+):(\\d+):(\\d+)$", 2).matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        Calendar calendarI = i();
        l(calendarI, timeZone);
        calendarI.set(1, Integer.parseInt(matcher.group(1)));
        calendarI.set(2, Integer.parseInt(matcher.group(2)) - 1);
        calendarI.set(5, Integer.parseInt(matcher.group(3)));
        calendarI.set(11, Integer.parseInt(matcher.group(4)));
        calendarI.set(12, Integer.parseInt(matcher.group(5)));
        calendarI.set(13, Integer.parseInt(matcher.group(6)));
        return calendarI;
    }

    public String d(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        return String.format(Locale.US, "%04d-%02d-%02d %02d:%02d:%02d %s", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)), calendar.getTimeZone().getID());
    }

    public Calendar e() {
        return i();
    }

    public Calendar f(TimeZone timeZone) {
        return l(i(), timeZone);
    }

    public TimeZone h() {
        return f11407c;
    }

    public Calendar i() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.setTime(new Date());
        calendar.set(14, 0);
        return calendar;
    }

    public String j() {
        return d(i());
    }

    public TimeZone k() {
        return f11406b;
    }

    public Calendar l(Calendar calendar, TimeZone timeZone) {
        Date time = calendar.getTime();
        int offset = calendar.getTimeZone().getOffset(time.getTime());
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTime(time);
        calendar2.add(14, offset);
        return calendar2;
    }
}
