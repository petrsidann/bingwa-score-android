package k4;

import com.google.android.gms.common.internal.r;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class c implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f11520b = new AtomicInteger();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadFactory f11521c = Executors.defaultThreadFactory();

    public c(String str) {
        r.m(str, "Name must not be null");
        this.f11519a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f11521c.newThread(new d(runnable, 0));
        threadNewThread.setName(this.f11519a + "[" + this.f11520b.getAndIncrement() + "]");
        return threadNewThread;
    }
}
