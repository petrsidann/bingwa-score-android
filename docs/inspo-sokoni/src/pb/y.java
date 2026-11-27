package pb;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static y f14524c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14525a = ",";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences f14526b;

    public static y b() {
        if (f14524c == null) {
            f14524c = new y();
        }
        return f14524c;
    }

    public Map<String, Object> a(String str) {
        String strD = d(str, null);
        if (strD != null) {
            try {
                HashMap map = new HashMap(1);
                Map<String, Object> mapF = f(new JSONObject(strD));
                mapF.put("to", str);
                map.put("message", mapF);
                return map;
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    public final SharedPreferences c() {
        if (this.f14526b == null) {
            this.f14526b = a.a().getSharedPreferences("io.flutter.plugins.firebase.messaging", 0);
        }
        return this.f14526b;
    }

    public String d(String str, String str2) {
        return c().getString(str, str2);
    }

    public List<Object> e(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            Object objF = jSONArray.get(i10);
            if (objF instanceof JSONArray) {
                objF = e((JSONArray) objF);
            } else if (objF instanceof JSONObject) {
                objF = f((JSONObject) objF);
            }
            arrayList.add(objF);
        }
        return arrayList;
    }

    public final Map<String, Object> f(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objF = jSONObject.get(next);
            if (objF instanceof JSONArray) {
                objF = e((JSONArray) objF);
            } else if (objF instanceof JSONObject) {
                objF = f((JSONObject) objF);
            }
            map.put(next, objF);
        }
        return map;
    }

    public void g(String str) {
        c().edit().remove(str).apply();
        String strD = d("notification_ids", "");
        if (strD.isEmpty()) {
            return;
        }
        h("notification_ids", strD.replace(str + ",", ""));
    }

    public void h(String str, String str2) {
        c().edit().putString(str, str2).apply();
    }

    public void i(com.google.firebase.messaging.d dVar) {
        h(dVar.V(), new JSONObject(z.f(dVar)).toString());
        String strReplace = d("notification_ids", "") + dVar.V() + ",";
        ArrayList arrayList = new ArrayList(Arrays.asList(strReplace.split(",")));
        if (arrayList.size() > 100) {
            String str = (String) arrayList.get(0);
            c().edit().remove(str).apply();
            strReplace = strReplace.replace(str + ",", "");
        }
        h("notification_ids", strReplace);
    }
}
