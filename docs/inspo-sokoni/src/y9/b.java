package y9;

import android.content.Context;
import android.content.SharedPreferences;
import ed.p;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f19436g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f19437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f19438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f19439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f19440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f19441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f19442f;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(Context context) {
            k.e(context, "context");
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_TASK_OPTIONS", 0).edit();
            editorEdit.clear();
            editorEdit.commit();
        }

        public final b b(Context context) {
            k.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_TASK_OPTIONS", 0);
            return new b(sharedPreferences.getLong("interval", 5000L), sharedPreferences.getBoolean("isOnceEvent", false), sharedPreferences.getBoolean("autoRunOnBoot", false), sharedPreferences.getBoolean("allowWakeLock", true), sharedPreferences.getBoolean("allowWifiLock", false), sharedPreferences.contains("callbackHandle") ? Long.valueOf(sharedPreferences.getLong("callbackHandle", 0L)) : null);
        }

        public final void c(Context context, Map<?, ?> map) {
            k.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_TASK_OPTIONS", 0);
            Long lJ = p.j(String.valueOf(map != null ? map.get("interval") : null));
            long jLongValue = lJ != null ? lJ.longValue() : 5000L;
            Object obj = map != null ? map.get("isOnceEvent") : null;
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            Object obj2 = map != null ? map.get("autoRunOnBoot") : null;
            Boolean bool2 = obj2 instanceof Boolean ? (Boolean) obj2 : null;
            boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : false;
            Object obj3 = map != null ? map.get("allowWakeLock") : null;
            Boolean bool3 = obj3 instanceof Boolean ? (Boolean) obj3 : null;
            boolean zBooleanValue3 = bool3 != null ? bool3.booleanValue() : true;
            Object obj4 = map != null ? map.get("allowWifiLock") : null;
            Boolean bool4 = obj4 instanceof Boolean ? (Boolean) obj4 : null;
            boolean zBooleanValue4 = bool4 != null ? bool4.booleanValue() : false;
            Long lJ2 = p.j(String.valueOf(map != null ? map.get("callbackHandle") : null));
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong("interval", jLongValue);
            editorEdit.putBoolean("isOnceEvent", zBooleanValue);
            editorEdit.putBoolean("autoRunOnBoot", zBooleanValue2);
            editorEdit.putBoolean("allowWakeLock", zBooleanValue3);
            editorEdit.putBoolean("allowWifiLock", zBooleanValue4);
            editorEdit.remove("callbackHandle");
            if (lJ2 != null) {
                editorEdit.putLong("callbackHandle", lJ2.longValue());
            }
            editorEdit.commit();
        }

        public final void d(Context context, Map<?, ?> map) {
            k.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.pravera.flutter_foreground_task.prefs.FOREGROUND_TASK_OPTIONS", 0);
            Long lJ = p.j(String.valueOf(map != null ? map.get("interval") : null));
            Object obj = map != null ? map.get("isOnceEvent") : null;
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            Object obj2 = map != null ? map.get("autoRunOnBoot") : null;
            Boolean bool2 = obj2 instanceof Boolean ? (Boolean) obj2 : null;
            Object obj3 = map != null ? map.get("allowWakeLock") : null;
            Boolean bool3 = obj3 instanceof Boolean ? (Boolean) obj3 : null;
            Object obj4 = map != null ? map.get("allowWifiLock") : null;
            Boolean bool4 = obj4 instanceof Boolean ? (Boolean) obj4 : null;
            Long lJ2 = p.j(String.valueOf(map != null ? map.get("callbackHandle") : null));
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (lJ != null) {
                editorEdit.putLong("interval", lJ.longValue());
            }
            if (bool != null) {
                editorEdit.putBoolean("isOnceEvent", bool.booleanValue());
            }
            if (bool2 != null) {
                editorEdit.putBoolean("autoRunOnBoot", bool2.booleanValue());
            }
            if (bool3 != null) {
                editorEdit.putBoolean("allowWakeLock", bool3.booleanValue());
            }
            if (bool4 != null) {
                editorEdit.putBoolean("allowWifiLock", bool4.booleanValue());
            }
            if (lJ2 != null) {
                editorEdit.putLong("callbackHandle", lJ2.longValue());
            }
            editorEdit.commit();
        }
    }

    public b(long j10, boolean z10, boolean z11, boolean z12, boolean z13, Long l10) {
        this.f19437a = j10;
        this.f19438b = z10;
        this.f19439c = z11;
        this.f19440d = z12;
        this.f19441e = z13;
        this.f19442f = l10;
    }

    public final boolean a() {
        return this.f19440d;
    }

    public final boolean b() {
        return this.f19441e;
    }

    public final boolean c() {
        return this.f19439c;
    }

    public final Long d() {
        return this.f19442f;
    }

    public final long e() {
        return this.f19437a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f19437a == bVar.f19437a && this.f19438b == bVar.f19438b && this.f19439c == bVar.f19439c && this.f19440d == bVar.f19440d && this.f19441e == bVar.f19441e && k.a(this.f19442f, bVar.f19442f);
    }

    public final boolean f() {
        return this.f19438b;
    }

    public int hashCode() {
        int iHashCode = ((((((((Long.hashCode(this.f19437a) * 31) + Boolean.hashCode(this.f19438b)) * 31) + Boolean.hashCode(this.f19439c)) * 31) + Boolean.hashCode(this.f19440d)) * 31) + Boolean.hashCode(this.f19441e)) * 31;
        Long l10 = this.f19442f;
        return iHashCode + (l10 == null ? 0 : l10.hashCode());
    }

    public String toString() {
        return "ForegroundTaskOptions(interval=" + this.f19437a + ", isOnceEvent=" + this.f19438b + ", autoRunOnBoot=" + this.f19439c + ", allowWakeLock=" + this.f19440d + ", allowWifiLock=" + this.f19441e + ", callbackHandle=" + this.f19442f + ')';
    }
}
