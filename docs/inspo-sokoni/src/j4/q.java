package j4;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f11237a = Pattern.compile("\\$\\{(.*?)\\}");

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    public static boolean b(String str) {
        return str == null || str.trim().isEmpty();
    }
}
