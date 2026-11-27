package p7;

import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f14273a;

    static {
        HashMap map = new HashMap();
        f14273a = map;
        map.put("auth/invalid-provider-id", "INVALID_PROVIDER_ID");
        map.put("auth/invalid-cert-hash", "INVALID_CERT_HASH");
        map.put("auth/network-request-failed", "WEB_NETWORK_REQUEST_FAILED");
        map.put("auth/web-storage-unsupported", "WEB_STORAGE_UNSUPPORTED");
        map.put("auth/operation-not-allowed", "OPERATION_NOT_ALLOWED");
    }

    public static Status a(Intent intent) {
        com.google.android.gms.common.internal.r.l(intent);
        com.google.android.gms.common.internal.r.a(d(intent));
        return (Status) d4.e.b(intent, "com.google.firebase.auth.internal.STATUS", Status.CREATOR);
    }

    public static Status b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("code");
            String string2 = jSONObject.getString("message");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                Map<String, String> map = f14273a;
                if (map.containsKey(string)) {
                    return r.a(map.get(string) + ":" + string2);
                }
            }
            return r.a("WEB_INTERNAL_ERROR:" + str);
        } catch (JSONException e10) {
            return r.a("WEB_INTERNAL_ERROR:" + str + "[ " + e10.getLocalizedMessage() + " ]");
        }
    }

    public static void c(Intent intent, Status status) {
        d4.e.e(status, intent, "com.google.firebase.auth.internal.STATUS");
    }

    public static boolean d(Intent intent) {
        com.google.android.gms.common.internal.r.l(intent);
        return intent.hasExtra("com.google.firebase.auth.internal.STATUS");
    }
}
