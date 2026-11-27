package pb;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f14423a;

    public static Context a() {
        return f14423a;
    }

    public static void b(Context context) {
        Log.d("FLTFireContextHolder", "received application context.");
        f14423a = context;
    }
}
