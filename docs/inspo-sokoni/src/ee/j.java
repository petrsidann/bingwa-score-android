package ee;

import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {
    public static String a(Calendar calendar) {
        return String.format(Locale.US, "%010d", Long.valueOf(calendar.getTimeInMillis()));
    }

    public static String b(Integer num) {
        return String.format(Locale.US, "%010d", num);
    }

    public static String c(Integer num, Calendar calendar) {
        return b(num) + "-" + a(calendar);
    }
}
