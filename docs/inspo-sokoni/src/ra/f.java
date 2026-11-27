package ra;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f15229a = a.opaque.name();

    public enum a {
        opaque,
        transparent
    }

    public static boolean a(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("flutter_deeplinking_enabled")) {
            return true;
        }
        return bundle.getBoolean("flutter_deeplinking_enabled");
    }
}
