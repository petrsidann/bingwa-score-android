package sd;

import ae.b;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f15715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<? extends a> f15716d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f15717a = 0L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f15718b = 0L;

    public static void c(Context context, Intent intent, Long l10, Long l11) throws ae.a {
        try {
            if (f15716d == null) {
                throw b.e().c("BackgroundExecutor", "INITIALIZATION_EXCEPTION", "There is no valid background executor available to run.", "insufficientRequirements.backgroundExecutorClass");
            }
            a aVar = f15715c;
            if (aVar == null || aVar.a()) {
                a aVarNewInstance = f15716d.newInstance();
                f15715c = aVarNewInstance;
                aVarNewInstance.f15717a = l10;
                aVarNewInstance.f15718b = l11;
            }
            if (f15715c.b(context, intent)) {
                return;
            }
            f15715c = null;
            throw b.e().c("BackgroundExecutor", "BACKGROUND_EXECUTION_EXCEPTION", "The background executor could not be started.", "insufficientRequirements.backgroundExecutor.run");
        } catch (IllegalAccessException | InstantiationException e10) {
            throw b.e().b("BackgroundExecutor", "BACKGROUND_EXECUTION_EXCEPTION", String.format("%s", e10.getLocalizedMessage()), e10);
        }
    }

    public static void d(Class<? extends a> cls) {
        f15716d = cls;
    }

    public abstract boolean a();

    public abstract boolean b(Context context, Intent intent);
}
