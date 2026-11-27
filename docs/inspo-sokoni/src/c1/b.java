package c1;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final File a(Context context, String name) {
        k.e(context, "<this>");
        k.e(name, "name");
        return z0.a.a(context, k.j(name, ".preferences_pb"));
    }
}
