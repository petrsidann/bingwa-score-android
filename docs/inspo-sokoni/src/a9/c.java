package a9;

import android.os.Trace;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static void a() {
        Trace.endSection();
    }

    public static void b(String str) {
        Trace.beginSection(str);
    }
}
