package k4;

import com.google.android.gms.common.internal.r;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadFactory f11518b = Executors.defaultThreadFactory();

    public b(String str) {
        r.m(str, "Name must not be null");
        this.f11517a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f11518b.newThread(new d(runnable, 0));
        threadNewThread.setName(this.f11517a);
        return threadNewThread;
    }
}
