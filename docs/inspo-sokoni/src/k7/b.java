package k7;

import android.os.Bundle;
import k6.q;
import k6.t;
import u4.a9;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t<String> f11638a = t.y("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q<String> f11639b = q.B("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q<String> f11640c = q.A("auto", "app", "am");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q<String> f11641d = q.z("_r", "_dbg");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final q<String> f11642e = new q.a().i(a9.f15988a).i(a9.f15989b).k();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final q<String> f11643f = q.z("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    public static void a(String str, String str2, Bundle bundle) {
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1L);
        }
    }

    public static boolean b(String str, Bundle bundle) {
        if (f11639b.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        q<String> qVar = f11641d;
        int size = qVar.size();
        int i10 = 0;
        while (i10 < size) {
            String str2 = qVar.get(i10);
            i10++;
            if (bundle.containsKey(str2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals("fcm") || str.equals("frc");
        }
        if ("_ln".equals(str2)) {
            return str.equals("fcm") || str.equals("fiam");
        }
        if (f11642e.contains(str2)) {
            return false;
        }
        q<String> qVar = f11643f;
        int size = qVar.size();
        int i10 = 0;
        while (i10 < size) {
            String str3 = qVar.get(i10);
            i10++;
            if (str2.matches(str3)) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(String str, String str2, Bundle bundle) {
        String str3;
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!e(str) || bundle == null) {
            return false;
        }
        q<String> qVar = f11641d;
        int size = qVar.size();
        int i10 = 0;
        while (i10 < size) {
            String str4 = qVar.get(i10);
            i10++;
            if (bundle.containsKey(str4)) {
                return false;
            }
        }
        str.hashCode();
        switch (str) {
            case "fcm":
                str3 = "fcm_integration";
                break;
            case "fdl":
                str3 = "fdl_integration";
                break;
            case "fiam":
                str3 = "fiam_integration";
                break;
            default:
                return false;
        }
        bundle.putString("_cis", str3);
        return true;
    }

    public static boolean e(String str) {
        return !f11640c.contains(str);
    }
}
