package r7;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class b implements ThreadFactory {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ThreadFactory f15081e = Executors.defaultThreadFactory();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f15082a = new AtomicLong();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StrictMode.ThreadPolicy f15085d;

    public b(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        this.f15083b = str;
        this.f15084c = i10;
        this.f15085d = threadPolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable) {
        Process.setThreadPriority(this.f15084c);
        StrictMode.ThreadPolicy threadPolicy = this.f15085d;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread threadNewThread = f15081e.newThread(new Runnable() { // from class: r7.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f15076a.b(runnable);
            }
        });
        threadNewThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.f15083b, Long.valueOf(this.f15082a.getAndIncrement())));
        return threadNewThread;
    }
}
