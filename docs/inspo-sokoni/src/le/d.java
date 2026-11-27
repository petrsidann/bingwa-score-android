package le;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d implements ke.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12785a = -1;

    @Override // ke.a
    public List<String> a() {
        return Collections.singletonList("com.oppo.launcher");
    }

    @Override // ke.a
    public void b(Context context, ComponentName componentName, int i10) throws ke.b {
        if (this.f12785a == i10) {
            return;
        }
        this.f12785a = i10;
        c(context, i10);
    }

    public final void c(Context context, int i10) throws ke.b {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("app_badge_count", i10);
            context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
        } catch (Throwable unused) {
            throw new ke.b("Unable to execute Badge By Content Provider");
        }
    }
}
