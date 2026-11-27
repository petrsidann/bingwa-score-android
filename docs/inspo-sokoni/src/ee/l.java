package ee;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static l f7961a;

    public static l a() {
        if (f7961a == null) {
            f7961a = new l();
        }
        return f7961a;
    }

    public String b(Context context) {
        String lowerCase = null;
        try {
            lowerCase = context.getResources().getConfiguration().locale.toLanguageTag().toLowerCase();
            return xd.f.C(context).I(context, "localization", "languageCode", lowerCase);
        } catch (Exception unused) {
            ae.b.e().h("LocalizationManager", "INSUFFICIENT_PERMISSIONS", "SQLitePrimitivesDB is not available", "insufficientPermissions.getLocalization");
            return lowerCase;
        }
    }

    public boolean c(Context context, String str) {
        if (str == null) {
            try {
                str = context.getResources().getConfiguration().locale.toLanguageTag().toLowerCase();
            } catch (Exception unused) {
                ae.b.e().h("LocalizationManager", "INSUFFICIENT_PERMISSIONS", "SQLitePrimitivesDB is not available", "insufficientPermissions.setLocalization");
                return false;
            }
        }
        xd.f.C(context).i0(context, "localization", "languageCode", str.toLowerCase());
        return true;
    }
}
