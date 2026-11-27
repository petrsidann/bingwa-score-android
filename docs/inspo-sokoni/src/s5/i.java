package s5;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class i {
    public static String a() {
        String str = Build.MANUFACTURER;
        return str != null ? str.toLowerCase(Locale.ENGLISH) : "";
    }

    public static boolean b() {
        return a().equals("meizu");
    }
}
