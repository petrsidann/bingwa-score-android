package u4;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v8 f16085a;

    public d2(v8 v8Var) {
        this.f16085a = v8Var;
    }

    public static d2 a(String str) {
        return new d2((TextUtils.isEmpty(str) || str.length() > 1) ? v8.UNINITIALIZED : s8.i(str.charAt(0)));
    }

    public final v8 b() {
        return this.f16085a;
    }

    public final String c() {
        return String.valueOf(s8.a(this.f16085a));
    }
}
