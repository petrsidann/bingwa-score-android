package na;

import android.content.res.Resources;
import android.database.Cursor;
import android.provider.ContactsContract;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13492c;

    public c(String str, String str2, int i10) {
        this.f13490a = str;
        this.f13491b = str2;
        this.f13492c = i10;
    }

    public static c a(HashMap<String, String> map) {
        String str = map.get("label");
        String str2 = map.get("value");
        String str3 = map.get("type");
        return new c(str, str2, str3 != null ? Integer.parseInt(str3) : -1);
    }

    public static String b(Resources resources, int i10, Cursor cursor, boolean z10) {
        String string;
        if (z10) {
            string = ContactsContract.CommonDataKinds.Email.getTypeLabel(resources, i10, "").toString();
        } else {
            if (i10 != 0) {
                if (i10 == 1) {
                    return "home";
                }
                if (i10 != 2) {
                    return i10 != 4 ? "other" : "mobile";
                }
                return "work";
            }
            if (cursor.getString(cursor.getColumnIndex("data3")) == null) {
                return "";
            }
            string = cursor.getString(cursor.getColumnIndex("data3"));
        }
        return string.toLowerCase();
    }

    public static String c(Resources resources, int i10, Cursor cursor, boolean z10) {
        String string;
        if (z10) {
            string = ContactsContract.CommonDataKinds.Phone.getTypeLabel(resources, i10, "").toString();
        } else {
            if (i10 == 10) {
                return "company";
            }
            if (i10 == 12) {
                return "main";
            }
            switch (i10) {
                case 0:
                    if (cursor.getString(cursor.getColumnIndex("data3")) == null) {
                        return "";
                    }
                    string = cursor.getString(cursor.getColumnIndex("data3"));
                    break;
                    break;
                case 1:
                    return "home";
                case 2:
                    return "mobile";
                case 3:
                    return "work";
                case 4:
                    return "fax work";
                case 5:
                    return "fax home";
                case 6:
                    return "pager";
                default:
                    return "other";
            }
        }
        return string.toLowerCase();
    }

    public HashMap<String, String> d() {
        HashMap<String, String> map = new HashMap<>();
        map.put("label", this.f13490a);
        map.put("value", this.f13491b);
        map.put("type", String.valueOf(this.f13492c));
        return map;
    }
}
