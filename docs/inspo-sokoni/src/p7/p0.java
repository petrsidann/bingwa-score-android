package p7;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzadr;
import com.google.android.gms.internal.p002firebaseauthapi.zzaic;
import com.google.android.gms.internal.p002firebaseauthapi.zzaj;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class p0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f14302d = 3600000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zzaj<String> f14303e = zzaj.zza("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", "timestamp");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p0 f14304f = new p0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Task<o7.i> f14305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Task<String> f14306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f14307c = 0;

    public static void b(Context context, Status status) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putInt("statusCode", status.T());
        editorEdit.putString("statusMessage", status.U());
        editorEdit.putLong("timestamp", j4.g.d().a());
        editorEdit.commit();
    }

    public static void c(Context context, zzaic zzaicVar, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("verifyAssertionRequest", d4.e.f(zzaicVar));
        editorEdit.putString("operation", str);
        editorEdit.putString("tenantId", str2);
        editorEdit.putLong("timestamp", j4.g.d().a());
        editorEdit.commit();
    }

    public static void d(Context context, FirebaseAuth firebaseAuth) {
        com.google.android.gms.common.internal.r.l(context);
        com.google.android.gms.common.internal.r.l(firebaseAuth);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("firebaseAppName", firebaseAuth.l().q());
        editorEdit.commit();
    }

    public static void e(Context context, FirebaseAuth firebaseAuth, o7.a0 a0Var) {
        com.google.android.gms.common.internal.r.l(context);
        com.google.android.gms.common.internal.r.l(firebaseAuth);
        com.google.android.gms.common.internal.r.l(a0Var);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("firebaseAppName", firebaseAuth.l().q());
        editorEdit.putString("firebaseUserUid", a0Var.h());
        editorEdit.commit();
    }

    public static void f(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("recaptchaToken", str);
        editorEdit.putString("operation", str2);
        editorEdit.putLong("timestamp", j4.g.d().a());
        editorEdit.commit();
    }

    public static void g(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        zzaj<String> zzajVar = f14303e;
        int size = zzajVar.size();
        int i10 = 0;
        while (i10 < size) {
            String str = zzajVar.get(i10);
            i10++;
            editorEdit.remove(str);
        }
        editorEdit.commit();
    }

    public static p0 j() {
        return f14304f;
    }

    public final void a(Context context) {
        com.google.android.gms.common.internal.r.l(context);
        g(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.f14305a = null;
        this.f14307c = 0L;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:25:0x0091  */
    public final void h(FirebaseAuth firebaseAuth) {
        Task<o7.i> taskW0;
        com.google.android.gms.common.internal.r.l(firebaseAuth);
        byte b10 = 0;
        SharedPreferences sharedPreferences = firebaseAuth.l().m().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0);
        if (firebaseAuth.l().q().equals(sharedPreferences.getString("firebaseAppName", ""))) {
            if (!sharedPreferences.contains("verifyAssertionRequest")) {
                if (!sharedPreferences.contains("recaptchaToken")) {
                    if (sharedPreferences.contains("statusCode")) {
                        Status status = new Status(sharedPreferences.getInt("statusCode", 17062), sharedPreferences.getString("statusMessage", ""));
                        this.f14307c = sharedPreferences.getLong("timestamp", 0L);
                        g(sharedPreferences);
                        this.f14305a = Tasks.forException(zzadr.zza(status));
                        return;
                    }
                    return;
                }
                String string = sharedPreferences.getString("recaptchaToken", "");
                String string2 = sharedPreferences.getString("operation", "");
                this.f14307c = sharedPreferences.getLong("timestamp", 0L);
                string2.hashCode();
                if (string2.equals("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA")) {
                    this.f14306b = Tasks.forResult(string);
                } else {
                    this.f14306b = null;
                }
                g(sharedPreferences);
                return;
            }
            zzaic zzaicVar = (zzaic) d4.e.c(sharedPreferences.getString("verifyAssertionRequest", ""), zzaic.CREATOR);
            String string3 = sharedPreferences.getString("operation", "");
            String string4 = sharedPreferences.getString("tenantId", null);
            String string5 = sharedPreferences.getString("firebaseUserUid", "");
            this.f14307c = sharedPreferences.getLong("timestamp", 0L);
            if (string4 != null) {
                firebaseAuth.z(string4);
                zzaicVar.zzb(string4);
            }
            string3.hashCode();
            switch (string3.hashCode()) {
                case -98509410:
                    if (!string3.equals("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE")) {
                        b10 = -1;
                    }
                    break;
                case 175006864:
                    b10 = !string3.equals("com.google.firebase.auth.internal.NONGMSCORE_LINK") ? (byte) -1 : (byte) 1;
                    break;
                case 1450464913:
                    b10 = !string3.equals("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN") ? (byte) -1 : (byte) 2;
                    break;
                default:
                    b10 = -1;
                    break;
            }
            switch (b10) {
                case 0:
                    if (!firebaseAuth.m().h().equals(string5)) {
                        this.f14305a = null;
                    } else {
                        taskW0 = firebaseAuth.w0(firebaseAuth.m(), o7.x1.Z(zzaicVar));
                        this.f14305a = taskW0;
                    }
                    break;
                case 1:
                    if (!firebaseAuth.m().h().equals(string5)) {
                        this.f14305a = null;
                    } else {
                        taskW0 = firebaseAuth.T(firebaseAuth.m(), o7.x1.Z(zzaicVar));
                        this.f14305a = taskW0;
                    }
                    break;
                case 2:
                    taskW0 = firebaseAuth.B(o7.x1.Z(zzaicVar));
                    this.f14305a = taskW0;
                    break;
                default:
                    this.f14305a = null;
                    break;
            }
            g(sharedPreferences);
        }
    }

    public final Task<String> i() {
        if (j4.g.d().a() - this.f14307c < f14302d) {
            return this.f14306b;
        }
        return null;
    }
}
