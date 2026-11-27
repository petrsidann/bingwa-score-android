package je;

import android.text.Html;
import android.text.Spanned;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static String a(String str) {
        if (o.c().e(str).booleanValue()) {
            return str;
        }
        Matcher matcher = Pattern.compile("(<(\\S+\\s+)*)(color=)('|\")(0x|#)?(\\d+)('|\")((\\s+[^\\s>]+)*\\/?>)", 8).matcher(str);
        Boolean bool = Boolean.FALSE;
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            try {
                String strGroup = matcher.group(1);
                String strGroup2 = matcher.group(3);
                String strGroup3 = matcher.group(4);
                Long lValueOf = Long.valueOf(Long.parseLong(matcher.group(6)));
                matcher.appendReplacement(stringBuffer, strGroup + strGroup2 + strGroup3 + Integer.valueOf(lValueOf.intValue()).toString() + matcher.group(7) + matcher.group(8));
                bool = Boolean.TRUE;
            } catch (Exception unused) {
            }
        }
        if (!bool.booleanValue()) {
            return str;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static Spanned b(String str) {
        if (o.c().e(str).booleanValue()) {
            return null;
        }
        return Html.fromHtml(a(str), 0);
    }
}
