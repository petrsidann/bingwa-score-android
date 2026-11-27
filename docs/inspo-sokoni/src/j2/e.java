package j2;

import android.util.Log;
import androidx.window.extensions.WindowExtensionsProvider;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f11172a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f11173b = u.b(e.class).b();

    public final int a() {
        String str;
        String str2;
        try {
            return WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel();
        } catch (NoClassDefFoundError unused) {
            if (c.f11164a.a() != j.LOG) {
                return 0;
            }
            str = f11173b;
            str2 = "Embedding extension version not found";
            Log.d(str, str2);
            return 0;
        } catch (UnsupportedOperationException unused2) {
            if (c.f11164a.a() != j.LOG) {
                return 0;
            }
            str = f11173b;
            str2 = "Stub Extension";
            Log.d(str, str2);
            return 0;
        }
    }
}
