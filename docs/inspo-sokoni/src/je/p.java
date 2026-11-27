package je;

import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f11418a = new p();

    public static p a() {
        return f11418a;
    }

    public TimeZone b(String str) {
        TimeZone timeZone;
        String strGroup;
        if (str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("^((\\-|\\+)?(\\d{2}(:\\d{2})?))|(\\S+)$", 8).matcher(str);
        if (matcher.matches()) {
            if (matcher.group(1) != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("GMT");
                sb2.append(matcher.group(2) == null ? "+" : matcher.group(2));
                sb2.append(matcher.group(3));
                sb2.append(matcher.group(4) == null ? ":00" : matcher.group(4));
                strGroup = sb2.toString();
            } else {
                strGroup = matcher.group(5);
            }
            timeZone = TimeZone.getTimeZone(strGroup);
        } else {
            timeZone = TimeZone.getDefault();
        }
        if (timeZone.getID().contains(str)) {
            return timeZone;
        }
        return null;
    }

    public String c(TimeZone timeZone) {
        if (timeZone == null) {
            return null;
        }
        return timeZone.getID();
    }
}
