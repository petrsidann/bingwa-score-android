package je;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class a extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f11401b;

    public static a f() {
        if (f11401b == null) {
            f11401b = new a();
        }
        return f11401b;
    }

    public int e(Context context, String str) {
        String[] strArrSplit = a(str).split("\\/");
        try {
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[1];
            int identifier = context.getResources().getIdentifier(String.format("res_%1s", str3), str2, rd.a.K(context));
            return identifier == 0 ? context.getResources().getIdentifier(str3, str2, rd.a.K(context)) : identifier;
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public Boolean g(Context context, String str) {
        if (str != null) {
            if (c("^resource?:\\/\\/", str).booleanValue()) {
                return h(context, str);
            }
            Boolean bool = Boolean.FALSE;
            if (d("^((http|https):\\/\\/)(www\\.)?[a-zA-Z0-9@:%.\\-_\\\\+~#?&\\/\\/=]{2,2048}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%.\\-_\\\\+~#?&\\/=]*)$", str, bool).booleanValue() || c("^file?:\\/\\/", str).booleanValue() || c("^asset?:\\/\\/", str).booleanValue()) {
                return bool;
            }
        }
        return Boolean.FALSE;
    }

    public final Boolean h(Context context, String str) {
        if (str != null) {
            return Boolean.valueOf(e(context, str) > 0);
        }
        return Boolean.FALSE;
    }
}
