package j4;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f11232a = Pattern.compile("\\\\.");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f11233b = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = f11233b.matcher(str);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            char cCharAt = matcher.group().charAt(0);
            if (cCharAt == '\f') {
                str2 = "\\\\f";
            } else if (cCharAt == '\r') {
                str2 = "\\\\r";
            } else if (cCharAt == '\"') {
                str2 = "\\\\\\\"";
            } else if (cCharAt == '/') {
                str2 = "\\\\/";
            } else if (cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                        str2 = "\\\\b";
                        break;
                    case '\t':
                        str2 = "\\\\t";
                        break;
                    case '\n':
                        str2 = "\\\\n";
                        break;
                    default:
                        continue;
                }
            } else {
                str2 = "\\\\\\\\";
            }
            matcher.appendReplacement(stringBuffer, str2);
        }
        if (stringBuffer == null) {
            return str;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
