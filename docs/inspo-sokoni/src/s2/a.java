package s2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: s2.a$a, reason: collision with other inner class name */
    @FunctionalInterface
    public interface InterfaceC0270a {
        void a(boolean z10);
    }

    public void a(Context context, InterfaceC0270a interfaceC0270a, b bVar) {
        if (context == null) {
            Log.d("permissions_handler", "Context cannot be null.");
            bVar.a("PermissionHandler.AppSettingsManager", "Android context cannot be null.");
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            intent.addFlags(268435456);
            intent.addFlags(1073741824);
            intent.addFlags(8388608);
            context.startActivity(intent);
            interfaceC0270a.a(true);
        } catch (Exception unused) {
            interfaceC0270a.a(false);
        }
    }
}
