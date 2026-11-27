package l0;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f12399b = a(new Locale[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f12400a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Locale[] f12401a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        public static boolean b(Locale locale) {
            for (Locale locale2 : f12401a) {
                if (locale2.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean c(Locale locale, Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String strA = n0.c.a(locale);
            if (!strA.isEmpty()) {
                return strA.equals(n0.c.a(locale2));
            }
            String country = locale.getCountry();
            return country.isEmpty() || country.equals(locale2.getCountry());
        }
    }

    public static class b {
        public static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        public static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        public static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    public j(k kVar) {
        this.f12400a = kVar;
    }

    public static j a(Locale... localeArr) {
        return i(b.a(localeArr));
    }

    public static j b(String str) {
        if (str == null || str.isEmpty()) {
            return d();
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i10 = 0; i10 < length; i10++) {
            localeArr[i10] = a.a(strArrSplit[i10]);
        }
        return a(localeArr);
    }

    public static j d() {
        return f12399b;
    }

    public static j i(LocaleList localeList) {
        return new j(new l(localeList));
    }

    public Locale c(int i10) {
        return this.f12400a.get(i10);
    }

    public boolean e() {
        return this.f12400a.isEmpty();
    }

    public boolean equals(Object obj) {
        return (obj instanceof j) && this.f12400a.equals(((j) obj).f12400a);
    }

    public int f() {
        return this.f12400a.size();
    }

    public String g() {
        return this.f12400a.a();
    }

    public Object h() {
        return this.f12400a.b();
    }

    public int hashCode() {
        return this.f12400a.hashCode();
    }

    public String toString() {
        return this.f12400a.toString();
    }
}
