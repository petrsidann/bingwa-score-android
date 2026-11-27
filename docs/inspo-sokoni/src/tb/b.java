package tb;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import io.flutter.plugins.urllauncher.WebViewActivity;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f15912b;

    public enum a {
        OK,
        NO_ACTIVITY,
        ACTIVITY_NOT_FOUND
    }

    public b(Context context, Activity activity) {
        this.f15911a = context;
        this.f15912b = activity;
    }

    public boolean a(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        ComponentName componentNameResolveActivity = intent.resolveActivity(this.f15911a.getPackageManager());
        if (componentNameResolveActivity == null) {
            Log.i("UrlLauncher", "component name for " + str + " is null");
            return false;
        }
        Log.i("UrlLauncher", "component name for " + str + " is " + componentNameResolveActivity.toShortString());
        return !"{com.android.fallback/com.android.fallback.Fallback}".equals(componentNameResolveActivity.toShortString());
    }

    public void b() {
        this.f15911a.sendBroadcast(new Intent("close action"));
    }

    public a c(String str, Bundle bundle, boolean z10, boolean z11, boolean z12) {
        Activity activity = this.f15912b;
        if (activity == null) {
            return a.NO_ACTIVITY;
        }
        try {
            this.f15912b.startActivity(z10 ? WebViewActivity.a(activity, str, z11, z12, bundle) : new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).putExtra("com.android.browser.headers", bundle));
            return a.OK;
        } catch (ActivityNotFoundException unused) {
            return a.ACTIVITY_NOT_FOUND;
        }
    }

    public void d(Activity activity) {
        this.f15912b = activity;
    }
}
