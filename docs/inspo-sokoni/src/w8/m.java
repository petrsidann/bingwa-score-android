package w8;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class m {
    public static Executor a(String str) {
        return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new k4.b(str));
    }

    public static Executor b() {
        return a("Firebase-Messaging-File-Io");
    }

    public static ScheduledExecutorService c() {
        return new ScheduledThreadPoolExecutor(1, new k4.b("Firebase-Messaging-Init"));
    }

    public static ExecutorService d() {
        return y8.b.a().a(new k4.b("Firebase-Messaging-Intent-Handle"), y8.c.HIGH_SPEED);
    }

    public static ExecutorService e() {
        return Executors.newSingleThreadExecutor(new k4.b("Firebase-Messaging-Network-Io"));
    }

    public static ExecutorService f() {
        return Executors.newSingleThreadExecutor(new k4.b("Firebase-Messaging-Task"));
    }

    public static ScheduledExecutorService g() {
        return new ScheduledThreadPoolExecutor(1, new k4.b("Firebase-Messaging-Topics-Io"));
    }
}
