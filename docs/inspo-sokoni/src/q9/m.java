package q9;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f14912e = d.RSA_ECB_PKCS1Padding;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l f14913f = l.AES_CBC_PKCS7Padding;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f14914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f14915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f14916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f14917d;

    public m(SharedPreferences sharedPreferences, Map<String, Object> map) {
        d dVar = f14912e;
        this.f14914a = d.valueOf(sharedPreferences.getString("FlutterSecureSAlgorithmKey", dVar.name()));
        l lVar = f14913f;
        this.f14915b = l.valueOf(sharedPreferences.getString("FlutterSecureSAlgorithmStorage", lVar.name()));
        d dVarValueOf = d.valueOf(b(map, "keyCipherAlgorithm", dVar.name()));
        int i10 = dVarValueOf.f14901b;
        int i11 = Build.VERSION.SDK_INT;
        this.f14916c = i10 <= i11 ? dVarValueOf : dVar;
        l lVarValueOf = l.valueOf(b(map, "storageCipherAlgorithm", lVar.name()));
        this.f14917d = lVarValueOf.f14911b <= i11 ? lVarValueOf : lVar;
    }

    public i a(Context context) {
        return this.f14917d.f14910a.a(context, this.f14916c.f14900a.a(context));
    }

    public final String b(Map<String, Object> map, String str, String str2) {
        Object obj = map.get(str);
        return obj != null ? obj.toString() : str2;
    }

    public i c(Context context) {
        return this.f14915b.f14910a.a(context, this.f14914a.f14900a.a(context));
    }

    public void d(SharedPreferences.Editor editor) {
        editor.remove("FlutterSecureSAlgorithmKey");
        editor.remove("FlutterSecureSAlgorithmStorage");
    }

    public boolean e() {
        return (this.f14914a == this.f14916c && this.f14915b == this.f14917d) ? false : true;
    }

    public void f(SharedPreferences.Editor editor) {
        editor.putString("FlutterSecureSAlgorithmKey", this.f14916c.name());
        editor.putString("FlutterSecureSAlgorithmStorage", this.f14917d.name());
    }
}
