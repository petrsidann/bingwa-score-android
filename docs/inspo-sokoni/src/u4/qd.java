package u4;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class qd {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f16750b = {"GoogleConsent", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "CmpSdkID"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f16751a;

    public qd(Map<String, String> map) {
        HashMap map2 = new HashMap();
        this.f16751a = map2;
        map2.putAll(map);
    }

    public static int a(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    public static String c(String str, boolean z10) {
        if (!z10 || str.length() <= 4) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i10 = 1;
        while (i10 < 64) {
            if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i10)) {
                charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(1 | i10);
                return String.valueOf(charArray);
            }
            i10++;
        }
        i10 = 0;
        charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(1 | i10);
        return String.valueOf(charArray);
    }

    public static qd d(SharedPreferences sharedPreferences) {
        HashMap map = new HashMap();
        String strF = f(sharedPreferences, "IABTCF_VendorConsents");
        if (!"\u0000".equals(strF) && strF.length() > 754) {
            map.put("GoogleConsent", String.valueOf(strF.charAt(754)));
        }
        int iA = a(sharedPreferences, "IABTCF_gdprApplies");
        if (iA != -1) {
            map.put("gdprApplies", String.valueOf(iA));
        }
        int iA2 = a(sharedPreferences, "IABTCF_EnableAdvertiserConsentMode");
        if (iA2 != -1) {
            map.put("EnableAdvertiserConsentMode", String.valueOf(iA2));
        }
        int iA3 = a(sharedPreferences, "IABTCF_PolicyVersion");
        if (iA3 != -1) {
            map.put("PolicyVersion", String.valueOf(iA3));
        }
        String strF2 = f(sharedPreferences, "IABTCF_PurposeConsents");
        if (!"\u0000".equals(strF2)) {
            map.put("PurposeConsents", strF2);
        }
        int iA4 = a(sharedPreferences, "IABTCF_CmpSdkID");
        if (iA4 != -1) {
            map.put("CmpSdkID", String.valueOf(iA4));
        }
        return new qd(map);
    }

    public static String f(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "\u0000");
        } catch (ClassCastException unused) {
            return "\u0000";
        }
    }

    public final Bundle b() {
        int i10;
        if (("1".equals(this.f16751a.get("GoogleConsent")) && "1".equals(this.f16751a.get("gdprApplies")) && "1".equals(this.f16751a.get("EnableAdvertiserConsentMode"))) && (i10 = i()) >= 0) {
            String str = this.f16751a.get("PurposeConsents");
            if (TextUtils.isEmpty(str)) {
                return Bundle.EMPTY;
            }
            Bundle bundle = new Bundle();
            if (str.length() > 0) {
                bundle.putString(s8.a.AD_STORAGE.f16801a, str.charAt(0) == '1' ? "granted" : "denied");
            }
            if (str.length() > 3) {
                bundle.putString(s8.a.AD_PERSONALIZATION.f16801a, (str.charAt(2) == '1' && str.charAt(3) == '1') ? "granted" : "denied");
            }
            if (str.length() > 6 && i10 >= 4) {
                bundle.putString(s8.a.AD_USER_DATA.f16801a, (str.charAt(0) == '1' && str.charAt(6) == '1') ? "granted" : "denied");
            }
            return bundle;
        }
        return Bundle.EMPTY;
    }

    public final String e() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("1");
        int iH = h();
        if (iH < 0 || iH > 4095) {
            sb2.append("00");
        } else {
            sb2.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt((iH >> 6) & 63));
            sb2.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(iH & 63));
        }
        int i10 = i();
        if (i10 < 0 || i10 > 63) {
            sb2.append("0");
        } else {
            sb2.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i10));
        }
        com.google.android.gms.common.internal.r.a(true);
        int i11 = ("1".equals(this.f16751a.get("gdprApplies")) ? 2 : 0) | 4;
        if ("1".equals(this.f16751a.get("EnableAdvertiserConsentMode"))) {
            i11 |= 8;
        }
        sb2.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i11));
        return sb2.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof qd) {
            return g().equalsIgnoreCase(((qd) obj).g());
        }
        return false;
    }

    public final String g() {
        StringBuilder sb2 = new StringBuilder();
        for (String str : f16750b) {
            if (this.f16751a.containsKey(str)) {
                if (sb2.length() > 0) {
                    sb2.append(";");
                }
                sb2.append(str);
                sb2.append("=");
                sb2.append(this.f16751a.get(str));
            }
        }
        return sb2.toString();
    }

    public final int h() {
        try {
            String str = this.f16751a.get("CmpSdkID");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final int hashCode() {
        return g().hashCode();
    }

    public final int i() {
        try {
            String str = this.f16751a.get("PolicyVersion");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final String toString() {
        return g();
    }
}
