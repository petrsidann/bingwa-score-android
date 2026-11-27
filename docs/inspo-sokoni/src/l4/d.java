package l4;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f12494b = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f12495a = null;

    public static c a(Context context) {
        return f12494b.b(context);
    }

    public final synchronized c b(Context context) {
        if (this.f12495a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f12495a = new c(context);
        }
        return this.f12495a;
    }
}
