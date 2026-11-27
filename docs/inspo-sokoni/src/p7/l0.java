package p7;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzv;
import com.google.android.gms.internal.p002firebaseauthapi.zzzp;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f4.a f14275a = new f4.a("JSONParser", new String[0]);

    public static List<Object> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Object objC = jSONArray.get(i10);
            if (objC instanceof JSONArray) {
                objC = a((JSONArray) objC);
            } else if (objC instanceof JSONObject) {
                objC = c((JSONObject) objC);
            }
            arrayList.add(objC);
        }
        return arrayList;
    }

    public static Map<String, Object> b(String str) {
        com.google.android.gms.common.internal.r.f(str);
        List<String> listZza = zzv.zza('.').zza((CharSequence) str);
        if (listZza.size() < 2) {
            f14275a.c("Invalid idToken " + str, new Object[0]);
            return new HashMap();
        }
        try {
            Map<String, Object> mapD = d(new String(j4.c.b(listZza.get(1)), "UTF-8"));
            return mapD == null ? new HashMap() : mapD;
        } catch (UnsupportedEncodingException e10) {
            f14275a.b("Unable to decode token", e10, new Object[0]);
            return new HashMap();
        }
    }

    public static Map<String, Object> c(JSONObject jSONObject) throws JSONException {
        t.a aVar = new t.a();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objC = jSONObject.get(next);
            if (objC instanceof JSONArray) {
                objC = a((JSONArray) objC);
            } else if (objC instanceof JSONObject) {
                objC = c((JSONObject) objC);
            }
            aVar.put(next, objC);
        }
        return aVar;
    }

    public static Map<String, Object> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return c(jSONObject);
            }
            return null;
        } catch (Exception e10) {
            Log.d("JSONParser", "Failed to parse JSONObject into Map.");
            throw new zzzp(e10);
        }
    }
}
