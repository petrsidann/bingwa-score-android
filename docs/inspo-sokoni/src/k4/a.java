package k4;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.common.zzh;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class a implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f11516a;

    public a(Looper looper) {
        this.f11516a = new zzh(looper);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f11516a.post(runnable);
    }
}
