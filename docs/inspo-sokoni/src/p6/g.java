package p6;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14150a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f14151b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f14152c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f14153d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ThreadFactory f14154e = null;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ThreadFactory f14155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f14156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicLong f14157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Boolean f14158d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Integer f14159e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f14160f;

        public a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f14155a = threadFactory;
            this.f14156b = str;
            this.f14157c = atomicLong;
            this.f14158d = bool;
            this.f14159e = num;
            this.f14160f = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.f14155a.newThread(runnable);
            Objects.requireNonNull(threadNewThread);
            String str = this.f14156b;
            if (str != null) {
                AtomicLong atomicLong = this.f14157c;
                Objects.requireNonNull(atomicLong);
                threadNewThread.setName(g.d(str, Long.valueOf(atomicLong.getAndIncrement())));
            }
            Boolean bool = this.f14158d;
            if (bool != null) {
                threadNewThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f14159e;
            if (num != null) {
                threadNewThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f14160f;
            if (uncaughtExceptionHandler != null) {
                threadNewThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return threadNewThread;
        }
    }

    public static ThreadFactory c(g gVar) {
        String str = gVar.f14150a;
        Boolean bool = gVar.f14151b;
        Integer num = gVar.f14152c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = gVar.f14153d;
        ThreadFactory threadFactoryDefaultThreadFactory = gVar.f14154e;
        if (threadFactoryDefaultThreadFactory == null) {
            threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        }
        return new a(threadFactoryDefaultThreadFactory, str, str != null ? new AtomicLong(0L) : null, bool, num, uncaughtExceptionHandler);
    }

    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public ThreadFactory b() {
        return c(this);
    }

    public g e(boolean z10) {
        this.f14151b = Boolean.valueOf(z10);
        return this;
    }

    public g f(String str) {
        d(str, 0);
        this.f14150a = str;
        return this;
    }
}
