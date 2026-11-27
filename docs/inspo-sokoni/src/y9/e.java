package y9;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f19450p = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f19454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f19455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f19456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f19457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f19458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f19459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f19460j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f19461k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f19462l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f19463m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f19464n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<c> f19465o;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(Context context) {
            k.e(context, "context");
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.NOTIFICATION_OPTIONS", 0).edit();
            editorEdit.clear();
            editorEdit.commit();
        }

        public final e b(Context context) throws JSONException {
            String str;
            d dVar;
            k.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.NOTIFICATION_OPTIONS", 0);
            int i10 = sharedPreferences.getInt("notificationId", 1000);
            String string = sharedPreferences.getString("notificationChannelId", null);
            if (string == null) {
                string = "foreground_service";
            }
            String str2 = string;
            String string2 = sharedPreferences.getString("notificationChannelName", null);
            if (string2 == null) {
                string2 = "Foreground Service";
            }
            String str3 = string2;
            String string3 = sharedPreferences.getString("notificationChannelDescription", null);
            int i11 = sharedPreferences.getInt("notificationChannelImportance", 3);
            int i12 = sharedPreferences.getInt("notificationPriority", 0);
            String string4 = sharedPreferences.getString("notificationContentTitle", null);
            String str4 = string4 == null ? "" : string4;
            String string5 = sharedPreferences.getString("notificationContentText", null);
            String str5 = string5 == null ? "" : string5;
            boolean z10 = sharedPreferences.getBoolean("enableVibration", false);
            boolean z11 = sharedPreferences.getBoolean("playSound", false);
            boolean z12 = sharedPreferences.getBoolean("showWhen", false);
            boolean z13 = sharedPreferences.getBoolean("isSticky", true);
            int i13 = sharedPreferences.getInt("visibility", 1);
            String string6 = sharedPreferences.getString("iconData", null);
            if (string6 != null) {
                JSONObject jSONObject = new JSONObject(string6);
                str = "";
                String string7 = jSONObject.getString("resType");
                if (string7 == null) {
                    string7 = str;
                }
                String string8 = jSONObject.getString("resPrefix");
                if (string8 == null) {
                    string8 = str;
                }
                String string9 = jSONObject.getString("name");
                if (string9 == null) {
                    string9 = str;
                }
                dVar = new d(string7, string8, string9, jSONObject.getString("backgroundColorRgb"));
            } else {
                str = "";
                dVar = null;
            }
            String string10 = sharedPreferences.getString("buttons", null);
            ArrayList arrayList = new ArrayList();
            if (string10 != null) {
                JSONArray jSONArray = new JSONArray(string10);
                int length = jSONArray.length();
                int i14 = 0;
                while (i14 < length) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i14);
                    int i15 = length;
                    String string11 = jSONObject2.getString("id");
                    JSONArray jSONArray2 = jSONArray;
                    if (string11 == null) {
                        string11 = str;
                    }
                    String string12 = jSONObject2.getString("text");
                    d dVar2 = dVar;
                    if (string12 == null) {
                        string12 = str;
                    }
                    arrayList.add(new c(string11, string12, jSONObject2.getString("textColorRgb")));
                    i14++;
                    length = i15;
                    jSONArray = jSONArray2;
                    dVar = dVar2;
                }
            }
            return new e(i10, str2, str3, string3, i11, i12, str4, str5, z10, z11, z12, z13, i13, dVar, arrayList);
        }

        public final void c(Context context, Map<?, ?> map) {
            String str;
            k.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.NOTIFICATION_OPTIONS", 0);
            Object obj = map != null ? map.get("notificationId") : null;
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 1000;
            Object obj2 = map != null ? map.get("notificationChannelId") : null;
            String str2 = obj2 instanceof String ? (String) obj2 : null;
            Object obj3 = map != null ? map.get("notificationChannelName") : null;
            String str3 = obj3 instanceof String ? (String) obj3 : null;
            Object obj4 = map != null ? map.get("notificationChannelDescription") : null;
            String str4 = obj4 instanceof String ? (String) obj4 : null;
            Object obj5 = map != null ? map.get("notificationChannelImportance") : null;
            Integer num2 = obj5 instanceof Integer ? (Integer) obj5 : null;
            int iIntValue2 = num2 != null ? num2.intValue() : 3;
            Object obj6 = map != null ? map.get("notificationPriority") : null;
            Integer num3 = obj6 instanceof Integer ? (Integer) obj6 : null;
            int iIntValue3 = num3 != null ? num3.intValue() : 0;
            Object obj7 = map != null ? map.get("notificationContentTitle") : null;
            String str5 = obj7 instanceof String ? (String) obj7 : null;
            if (str5 == null) {
                str5 = "";
                str = str5;
            } else {
                str = "";
            }
            Object obj8 = map != null ? map.get("notificationContentText") : null;
            String str6 = obj8 instanceof String ? (String) obj8 : null;
            if (str6 == null) {
                str6 = str;
            }
            Object obj9 = map != null ? map.get("enableVibration") : null;
            Boolean bool = obj9 instanceof Boolean ? (Boolean) obj9 : null;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            Object obj10 = map != null ? map.get("playSound") : null;
            Boolean bool2 = obj10 instanceof Boolean ? (Boolean) obj10 : null;
            boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : false;
            Object obj11 = map != null ? map.get("showWhen") : null;
            Boolean bool3 = obj11 instanceof Boolean ? (Boolean) obj11 : null;
            boolean zBooleanValue3 = bool3 != null ? bool3.booleanValue() : false;
            Object obj12 = map != null ? map.get("isSticky") : null;
            Boolean bool4 = obj12 instanceof Boolean ? (Boolean) obj12 : null;
            boolean zBooleanValue4 = bool4 != null ? bool4.booleanValue() : true;
            Object obj13 = map != null ? map.get("visibility") : null;
            Integer num4 = obj13 instanceof Integer ? (Integer) obj13 : null;
            int iIntValue4 = num4 != null ? num4.intValue() : 1;
            Object obj14 = map != null ? map.get("iconData") : null;
            Map map2 = obj14 instanceof Map ? (Map) obj14 : null;
            String string = map2 != null ? new JSONObject(map2).toString() : null;
            Object obj15 = map != null ? map.get("buttons") : null;
            List list = obj15 instanceof List ? (List) obj15 : null;
            String string2 = list != null ? new JSONArray((Collection) list).toString() : null;
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt("notificationId", iIntValue);
            editorEdit.putString("notificationChannelId", str2);
            editorEdit.putString("notificationChannelName", str3);
            editorEdit.putString("notificationChannelDescription", str4);
            editorEdit.putInt("notificationChannelImportance", iIntValue2);
            editorEdit.putInt("notificationPriority", iIntValue3);
            editorEdit.putString("notificationContentTitle", str5);
            editorEdit.putString("notificationContentText", str6);
            editorEdit.putBoolean("enableVibration", zBooleanValue);
            editorEdit.putBoolean("playSound", zBooleanValue2);
            editorEdit.putBoolean("showWhen", zBooleanValue3);
            editorEdit.putBoolean("isSticky", zBooleanValue4);
            editorEdit.putInt("visibility", iIntValue4);
            editorEdit.putString("iconData", string);
            editorEdit.putString("buttons", string2);
            editorEdit.commit();
        }

        public final void d(Context context, Map<?, ?> map) {
            k.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.NOTIFICATION_OPTIONS", 0);
            Object obj = map != null ? map.get("notificationContentTitle") : null;
            String string = obj instanceof String ? (String) obj : null;
            if (string == null && (string = sharedPreferences.getString("notificationContentTitle", null)) == null) {
                string = "";
            }
            Object obj2 = map != null ? map.get("notificationContentText") : null;
            String string2 = obj2 instanceof String ? (String) obj2 : null;
            String str = (string2 == null && (string2 = sharedPreferences.getString("notificationContentText", null)) == null) ? "" : string2;
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("notificationContentTitle", string);
            editorEdit.putString("notificationContentText", str);
            editorEdit.commit();
        }
    }

    public e(int i10, String channelId, String channelName, String str, int i11, int i12, String contentTitle, String contentText, boolean z10, boolean z11, boolean z12, boolean z13, int i13, d dVar, List<c> buttons) {
        k.e(channelId, "channelId");
        k.e(channelName, "channelName");
        k.e(contentTitle, "contentTitle");
        k.e(contentText, "contentText");
        k.e(buttons, "buttons");
        this.f19451a = i10;
        this.f19452b = channelId;
        this.f19453c = channelName;
        this.f19454d = str;
        this.f19455e = i11;
        this.f19456f = i12;
        this.f19457g = contentTitle;
        this.f19458h = contentText;
        this.f19459i = z10;
        this.f19460j = z11;
        this.f19461k = z12;
        this.f19462l = z13;
        this.f19463m = i13;
        this.f19464n = dVar;
        this.f19465o = buttons;
    }

    public final List<c> a() {
        return this.f19465o;
    }

    public final String b() {
        return this.f19454d;
    }

    public final String c() {
        return this.f19452b;
    }

    public final int d() {
        return this.f19455e;
    }

    public final String e() {
        return this.f19453c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f19451a == eVar.f19451a && k.a(this.f19452b, eVar.f19452b) && k.a(this.f19453c, eVar.f19453c) && k.a(this.f19454d, eVar.f19454d) && this.f19455e == eVar.f19455e && this.f19456f == eVar.f19456f && k.a(this.f19457g, eVar.f19457g) && k.a(this.f19458h, eVar.f19458h) && this.f19459i == eVar.f19459i && this.f19460j == eVar.f19460j && this.f19461k == eVar.f19461k && this.f19462l == eVar.f19462l && this.f19463m == eVar.f19463m && k.a(this.f19464n, eVar.f19464n) && k.a(this.f19465o, eVar.f19465o);
    }

    public final String f() {
        return this.f19458h;
    }

    public final String g() {
        return this.f19457g;
    }

    public final boolean h() {
        return this.f19459i;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.f19451a) * 31) + this.f19452b.hashCode()) * 31) + this.f19453c.hashCode()) * 31;
        String str = this.f19454d;
        int iHashCode2 = (((((((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.f19455e)) * 31) + Integer.hashCode(this.f19456f)) * 31) + this.f19457g.hashCode()) * 31) + this.f19458h.hashCode()) * 31) + Boolean.hashCode(this.f19459i)) * 31) + Boolean.hashCode(this.f19460j)) * 31) + Boolean.hashCode(this.f19461k)) * 31) + Boolean.hashCode(this.f19462l)) * 31) + Integer.hashCode(this.f19463m)) * 31;
        d dVar = this.f19464n;
        return ((iHashCode2 + (dVar != null ? dVar.hashCode() : 0)) * 31) + this.f19465o.hashCode();
    }

    public final d i() {
        return this.f19464n;
    }

    public final int j() {
        return this.f19451a;
    }

    public final boolean k() {
        return this.f19460j;
    }

    public final boolean l() {
        return this.f19461k;
    }

    public final int m() {
        return this.f19463m;
    }

    public final boolean n() {
        return this.f19462l;
    }

    public String toString() {
        return "NotificationOptions(id=" + this.f19451a + ", channelId=" + this.f19452b + ", channelName=" + this.f19453c + ", channelDescription=" + this.f19454d + ", channelImportance=" + this.f19455e + ", priority=" + this.f19456f + ", contentTitle=" + this.f19457g + ", contentText=" + this.f19458h + ", enableVibration=" + this.f19459i + ", playSound=" + this.f19460j + ", showWhen=" + this.f19461k + ", isSticky=" + this.f19462l + ", visibility=" + this.f19463m + ", iconData=" + this.f19464n + ", buttons=" + this.f19465o + ')';
    }
}
