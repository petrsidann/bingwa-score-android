package le;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h implements ke.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f12788a = Uri.parse("content://com.android.badge/badge");

    @Override // ke.a
    public List<String> a() {
        return Collections.singletonList("com.zui.launcher");
    }

    @Override // ke.a
    public void b(Context context, ComponentName componentName, int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("app_badge_count", i10);
        context.getContentResolver().call(this.f12788a, "setAppBadgeCount", (String) null, bundle);
    }
}
