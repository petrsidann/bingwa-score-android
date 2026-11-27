package u4;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class e7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f16135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16136b;

    public e7(Context context, String str) {
        com.google.android.gms.common.internal.r.l(context);
        this.f16135a = context.getResources();
        if (TextUtils.isEmpty(str)) {
            this.f16136b = a(context);
        } else {
            this.f16136b = str;
        }
    }

    public static String a(Context context) {
        try {
            return context.getResources().getResourcePackageName(c4.l.f3389a);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    public final String b(String str) {
        int identifier = this.f16135a.getIdentifier(str, "string", this.f16136b);
        if (identifier == 0) {
            return null;
        }
        try {
            return this.f16135a.getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }
}
