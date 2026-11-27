package w8;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f17805d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17808c;

    public x0(String str, String str2) {
        this.f17806a = d(str2, str);
        this.f17807b = str;
        this.f17808c = str + "!" + str2;
    }

    public static x0 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("!", -1);
        if (strArrSplit.length != 2) {
            return null;
        }
        return new x0(strArrSplit[0], strArrSplit[1]);
    }

    public static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str2));
            str = str.substring(8);
        }
        if (str == null || !f17805d.matcher(str).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", str, "[a-zA-Z0-9-_.~%]{1,900}"));
        }
        return str;
    }

    public static x0 f(String str) {
        return new x0("S", str);
    }

    public static x0 g(String str) {
        return new x0("U", str);
    }

    public String b() {
        return this.f17807b;
    }

    public String c() {
        return this.f17806a;
    }

    public String e() {
        return this.f17808c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return this.f17806a.equals(x0Var.f17806a) && this.f17807b.equals(x0Var.f17807b);
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f17807b, this.f17806a);
    }
}
