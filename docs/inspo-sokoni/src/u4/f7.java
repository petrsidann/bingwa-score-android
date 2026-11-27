package u4;

/* JADX INFO: loaded from: classes.dex */
public final class f7 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d7 f16187b;

    public f7(d7 d7Var, String str) {
        this.f16187b = d7Var;
        com.google.android.gms.common.internal.r.l(str);
        this.f16186a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f16187b.zzj().C().b(this.f16186a, th);
    }
}
