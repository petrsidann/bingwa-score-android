package k4;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f11522a;

    public d(Runnable runnable, int i10) {
        this.f11522a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.f11522a.run();
    }
}
