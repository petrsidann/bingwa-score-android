package je;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static Calendar a(Calendar calendar) {
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.set(14, 0);
        return calendar2;
    }

    public static Calendar b(Calendar calendar, String str, TimeZone timeZone) {
        if (calendar != null && timeZone != null && !o.c().e(str).booleanValue() && be.a.s(str)) {
            try {
                be.a aVar = new be.a(str);
                aVar.u(timeZone);
                Date dateL = aVar.l(calendar.getTime());
                Calendar calendarA = a(calendar);
                if (dateL == null || dateL.compareTo(calendarA.getTime()) < 0) {
                    return null;
                }
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTimeZone(timeZone);
                calendar2.setTime(dateL);
                return calendar2;
            } catch (ParseException e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }
}
