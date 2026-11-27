package z0;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final File a(Context context, String fileName) {
        k.e(context, "<this>");
        k.e(fileName, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), k.j("datastore/", fileName));
    }
}
