package z9;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import fb.n;
import kotlin.jvm.internal.k;
import y9.f;

/* JADX INFO: loaded from: classes.dex */
public final class b implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f20388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f20389b;

    public final f a(Activity activity) {
        f fVar;
        k.e(activity, "activity");
        if (Build.VERSION.SDK_INT >= 33 && !d(activity, "android.permission.POST_NOTIFICATIONS")) {
            f fVarC = c(activity, "android.permission.POST_NOTIFICATIONS");
            return (fVarC == null || fVarC != (fVar = f.PERMANENTLY_DENIED) || activity.shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS")) ? f.DENIED : fVar;
        }
        return f.GRANTED;
    }

    public final void b() {
        this.f20388a = null;
        this.f20389b = null;
    }

    public final f c(Context context, String str) {
        String string;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.NOTIFICATION_PERMISSION_STATUS", 0);
        if (sharedPreferences == null || (string = sharedPreferences.getString(str, null)) == null) {
            return null;
        }
        return f.valueOf(string);
    }

    public final boolean d(Context context, String str) {
        return f0.a.checkSelfPermission(context, str) == 0;
    }

    public final void e(Activity activity, a callback) {
        k.e(activity, "activity");
        k.e(callback, "callback");
        if (Build.VERSION.SDK_INT < 33) {
            callback.b(f.GRANTED);
            return;
        }
        this.f20388a = activity;
        this.f20389b = callback;
        e0.b.e(activity, new String[]{"android.permission.POST_NOTIFICATIONS"}, 100);
    }

    public final void f(Context context, String str, f fVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.NOTIFICATION_PERMISSION_STATUS", 0);
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str, fVar.toString());
        editorEdit.commit();
    }

    @Override // fb.n
    public boolean onRequestPermissionsResult(int i10, String[] permissions, int[] grantResults) {
        k.e(permissions, "permissions");
        k.e(grantResults, "grantResults");
        boolean z10 = false;
        if (grantResults.length == 0) {
            a aVar = this.f20389b;
            if (aVar != null) {
                aVar.a(x9.a.NOTIFICATION_PERMISSION_REQUEST_CANCELLED);
            }
            b();
            return false;
        }
        f fVar = f.DENIED;
        if (i10 != 100) {
            return false;
        }
        int iQ = mc.k.q(permissions, "android.permission.POST_NOTIFICATIONS");
        if (iQ < 0 || grantResults[iQ] != 0) {
            Activity activity = this.f20388a;
            if (activity != null && !activity.shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS")) {
                z10 = true;
            }
            if (z10) {
                fVar = f.PERMANENTLY_DENIED;
            }
        } else {
            fVar = f.GRANTED;
        }
        Activity activity2 = this.f20388a;
        if (activity2 != null) {
            f(activity2, "android.permission.POST_NOTIFICATIONS", fVar);
        }
        a aVar2 = this.f20389b;
        if (aVar2 != null) {
            aVar2.b(fVar);
        }
        b();
        return true;
    }
}
