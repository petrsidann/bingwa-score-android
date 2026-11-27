package l0;

import android.content.res.Configuration;
import android.os.LocaleList;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    public static class a {
        public static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }

        public static void b(Configuration configuration, j jVar) {
            configuration.setLocales((LocaleList) jVar.h());
        }
    }

    public static j a(Configuration configuration) {
        return j.i(a.a(configuration));
    }

    public static void b(Configuration configuration, j jVar) {
        a.b(configuration, jVar);
    }
}
