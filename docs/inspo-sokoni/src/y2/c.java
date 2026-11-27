package y2;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class c {

    public interface a {
        void a(Context context, String[] strArr, String str, File file, d dVar);
    }

    public interface b {
        String a(String str);

        void b(String str);

        String c(String str);

        String[] d();

        void e(String str);
    }

    /* JADX INFO: renamed from: y2.c$c, reason: collision with other inner class name */
    public interface InterfaceC0335c {
    }

    public static void a(Context context, String str) {
        b(context, str, null, null);
    }

    public static void b(Context context, String str, String str2, InterfaceC0335c interfaceC0335c) {
        new d().f(context, str, str2, interfaceC0335c);
    }
}
