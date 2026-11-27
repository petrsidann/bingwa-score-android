package n0;

import android.icu.util.ULocale;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    public static class a {
        public static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        public static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        public static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    public static String a(Locale locale) {
        return a.c(a.a(a.b(locale)));
    }
}
