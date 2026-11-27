package y9;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0338a f19434b = new C0338a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19435a;

    /* JADX INFO: renamed from: y9.a$a, reason: collision with other inner class name */
    public static final class C0338a {
        public C0338a() {
        }

        public /* synthetic */ C0338a(g gVar) {
            this();
        }

        public final a a(Context context) {
            k.e(context, "context");
            String string = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_SERVICE_STATUS", 0).getString("foregroundServiceAction", null);
            if (string == null) {
                string = "com.pravera.flutter_foreground_task.action.stop";
            }
            return new a(string);
        }

        public final void b(Context context, String action) {
            k.e(context, "context");
            k.e(action, "action");
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_SERVICE_STATUS", 0).edit();
            editorEdit.putString("foregroundServiceAction", action);
            editorEdit.commit();
        }
    }

    public a(String action) {
        k.e(action, "action");
        this.f19435a = action;
    }

    public final String a() {
        return this.f19435a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && k.a(this.f19435a, ((a) obj).f19435a);
    }

    public int hashCode() {
        return this.f19435a.hashCode();
    }

    public String toString() {
        return "ForegroundServiceStatus(action=" + this.f19435a + ')';
    }
}
