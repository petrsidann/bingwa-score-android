package v2;

import android.content.Context;
import android.content.SharedPreferences;
import io.flutter.view.FlutterCallbackInformation;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17101a = "com.dexterous.flutterlocalnotifications.CALLBACK_DISPATCHER_HANDLE_KEY";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17102b = "com.dexterous.flutterlocalnotifications.CALLBACK_HANDLE_KEY";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f17103c;

    public a(Context context) {
        this.f17103c = context;
    }

    public final SharedPreferences a() {
        return this.f17103c.getSharedPreferences("flutter_local_notifications_plugin", 0);
    }

    public Long b() {
        return Long.valueOf(a().getLong("com.dexterous.flutterlocalnotifications.CALLBACK_DISPATCHER_HANDLE_KEY", -1L));
    }

    public Long c() {
        return Long.valueOf(a().getLong("com.dexterous.flutterlocalnotifications.CALLBACK_HANDLE_KEY", -1L));
    }

    public FlutterCallbackInformation d() {
        return FlutterCallbackInformation.lookupCallbackInformation(b().longValue());
    }

    public void e(Long l10, Long l11) {
        a().edit().putLong("com.dexterous.flutterlocalnotifications.CALLBACK_DISPATCHER_HANDLE_KEY", l10.longValue()).apply();
        a().edit().putLong("com.dexterous.flutterlocalnotifications.CALLBACK_HANDLE_KEY", l11.longValue()).apply();
    }
}
