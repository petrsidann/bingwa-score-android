package ka;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.PowerManager;
import fb.n;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import lc.q;
import xc.l;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f11937d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<fb.l, q> f11939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l<n, q> f11940c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public /* synthetic */ class b extends j implements l<Object, q> {
        public b(Object obj) {
            super(1, obj, fb.j.d.class, "success", "success(Ljava/lang/Object;)V", 0);
        }

        public final void d(Object obj) {
            ((fb.j.d) this.receiver).a(obj);
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ q invoke(Object obj) {
            d(obj);
            return q.f12711a;
        }
    }

    public /* synthetic */ class c extends j implements xc.q<String, String, Object, q> {
        public c(Object obj) {
            super(3, obj, fb.j.d.class, "error", "error(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", 0);
        }

        public final void d(String p10, String str, Object obj) {
            k.e(p10, "p0");
            ((fb.j.d) this.receiver).b(p10, str, obj);
        }

        @Override // xc.q
        public /* bridge */ /* synthetic */ q e(String str, String str2, Object obj) {
            d(str, str2, obj);
            return q.f12711a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Context context, l<? super fb.l, q> addActivityResultListener, l<? super n, q> addRequestPermissionsResultListener) {
        k.e(context, "context");
        k.e(addActivityResultListener, "addActivityResultListener");
        k.e(addRequestPermissionsResultListener, "addRequestPermissionsResultListener");
        this.f11938a = context;
        this.f11939b = addActivityResultListener;
        this.f11940c = addRequestPermissionsResultListener;
    }

    public final boolean a() {
        Object systemService = this.f11938a.getSystemService("power");
        k.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) systemService).isIgnoringBatteryOptimizations(this.f11938a.getPackageName());
    }

    public final boolean b() {
        return this.f11938a.checkSelfPermission("android.permission.WAKE_LOCK") == 0;
    }

    public final void c(fb.j.d result, Activity activity) {
        k.e(result, "result");
        k.e(activity, "activity");
        Object systemService = this.f11938a.getSystemService("power");
        k.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        if (((PowerManager) systemService).isIgnoringBatteryOptimizations(this.f11938a.getPackageName())) {
            result.a(Boolean.TRUE);
            return;
        }
        if (this.f11938a.checkSelfPermission("android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS") == -1) {
            result.b("flutter_background.PermissionHandler", "The app does not have the REQUEST_IGNORE_BATTERY_OPTIMIZATIONS permission required to ask the user for whitelisting. See the documentation on how to setup this plugin properly.", null);
            return;
        }
        this.f11939b.invoke(new ka.c(new b(result), new c(result)));
        Intent intent = new Intent();
        intent.setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent.setData(Uri.parse("package:" + this.f11938a.getPackageName()));
        activity.startActivityForResult(intent, 5672353);
    }
}
