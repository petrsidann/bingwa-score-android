package u1;

import android.os.Build;
import android.os.ext.SdkExtensions;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15976a = new a();

    /* JADX INFO: renamed from: u1.a$a, reason: collision with other inner class name */
    public static final class C0293a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0293a f15977a = new C0293a();

        public final int a() {
            return SdkExtensions.getExtensionVersion(1000000);
        }
    }

    public final int a() {
        if (Build.VERSION.SDK_INT >= 30) {
            return C0293a.f15977a.a();
        }
        return 0;
    }
}
