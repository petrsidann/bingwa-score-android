package na;

import android.content.res.Resources;
import android.database.Cursor;
import android.provider.ContactsContract;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f13496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f13497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f13498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13499g;

    public d(String str, String str2, String str3, String str4, String str5, String str6, int i10) {
        this.f13493a = str;
        this.f13494b = str2;
        this.f13495c = str3;
        this.f13496d = str4;
        this.f13497e = str5;
        this.f13498f = str6;
        this.f13499g = i10;
    }

    public static d a(HashMap<String, String> map) {
        String str = map.get("label");
        String str2 = map.get("street");
        String str3 = map.get("city");
        String str4 = map.get("postcode");
        String str5 = map.get("region");
        String str6 = map.get("country");
        String str7 = map.get("type");
        return new d(str, str2, str3, str4, str5, str6, str7 != null ? Integer.parseInt(str7) : -1);
    }

    public static String b(Resources resources, int i10, Cursor cursor, boolean z10) {
        if (z10) {
            return ContactsContract.CommonDataKinds.StructuredPostal.getTypeLabel(resources, i10, "").toString().toLowerCase();
        }
        int i11 = cursor.getInt(cursor.getColumnIndex("data2"));
        if (i11 == 0) {
            String string = cursor.getString(cursor.getColumnIndex("data3"));
            return string != null ? string : "";
        }
        if (i11 != 1) {
            return i11 != 2 ? "other" : "work";
        }
        return "home";
    }

    public HashMap<String, String> c() {
        HashMap<String, String> map = new HashMap<>();
        map.put("label", this.f13493a);
        map.put("street", this.f13494b);
        map.put("city", this.f13495c);
        map.put("postcode", this.f13496d);
        map.put("region", this.f13497e);
        map.put("country", this.f13498f);
        map.put("type", String.valueOf(this.f13499g));
        return map;
    }
}
