package e0;

import android.app.LocaleManager;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    public static class a {
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static LocaleList b(Object obj) {
            return ((LocaleManager) obj).getSystemLocales();
        }
    }

    public static l0.j a(Context context) {
        if (Build.VERSION.SDK_INT < 33) {
            return l0.j.b(g.a(context));
        }
        Object objB = b(context);
        return objB != null ? l0.j.i(a.a(objB)) : l0.j.d();
    }

    public static Object b(Context context) {
        return context.getSystemService("locale");
    }
}
