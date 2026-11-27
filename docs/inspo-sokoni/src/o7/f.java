package o7;

import android.net.Uri;
import com.google.android.gms.internal.p002firebaseauthapi.zzan;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzan<String, Integer> f13720g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f13725e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f13726f;

    static {
        HashMap map = new HashMap();
        map.put("recoverEmail", 2);
        map.put("resetPassword", 0);
        map.put("signIn", 4);
        map.put("verifyEmail", 1);
        map.put("verifyBeforeChangeEmail", 5);
        map.put("revertSecondFactorAddition", 6);
        f13720g = zzan.zza(map);
    }

    public f(String str) {
        String strE = e(str, "apiKey");
        String strE2 = e(str, "oobCode");
        String strE3 = e(str, "mode");
        if (strE == null || strE2 == null || strE3 == null) {
            throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", "apiKey", "oobCode", "mode"));
        }
        this.f13721a = com.google.android.gms.common.internal.r.f(strE);
        this.f13722b = com.google.android.gms.common.internal.r.f(strE2);
        this.f13723c = com.google.android.gms.common.internal.r.f(strE3);
        this.f13724d = e(str, "continueUrl");
        this.f13725e = e(str, "languageCode");
        this.f13726f = e(str, "tenantId");
    }

    public static f c(String str) {
        com.google.android.gms.common.internal.r.f(str);
        try {
            return new f(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String e(String str, String str2) {
        Uri uri = Uri.parse(str);
        try {
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return uri.getQueryParameter(str2);
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(com.google.android.gms.common.internal.r.f(uri.getQueryParameter("link"))).getQueryParameter(str2);
            }
            return null;
        } catch (NullPointerException | UnsupportedOperationException unused) {
            return null;
        }
    }

    public String a() {
        return this.f13722b;
    }

    public int b() {
        zzan<String, Integer> zzanVar = f13720g;
        if (zzanVar.containsKey(this.f13723c)) {
            return zzanVar.get(this.f13723c).intValue();
        }
        return 3;
    }

    public final String d() {
        return this.f13726f;
    }
}
