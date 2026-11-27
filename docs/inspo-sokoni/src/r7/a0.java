package r7;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public enum a0 implements Executor {
    INSTANCE;


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f15079b = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        f15079b.post(runnable);
    }
}
