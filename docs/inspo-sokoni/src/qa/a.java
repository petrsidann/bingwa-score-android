package qa;

import io.flutter.embedding.engine.FlutterJNI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import va.f;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f14918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f14919e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f14920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FlutterJNI.c f14921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ExecutorService f14922c;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f14923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public FlutterJNI.c f14924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ExecutorService f14925c;

        /* JADX INFO: renamed from: qa.a$b$a, reason: collision with other inner class name */
        public class ThreadFactoryC0259a implements ThreadFactory {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f14926a;

            public ThreadFactoryC0259a() {
                this.f14926a = 0;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("flutter-worker-");
                int i10 = this.f14926a;
                this.f14926a = i10 + 1;
                sb2.append(i10);
                thread.setName(sb2.toString());
                return thread;
            }
        }

        public a a() {
            b();
            return new a(this.f14923a, null, this.f14924b, this.f14925c);
        }

        public final void b() {
            if (this.f14924b == null) {
                this.f14924b = new FlutterJNI.c();
            }
            if (this.f14925c == null) {
                this.f14925c = Executors.newCachedThreadPool(new ThreadFactoryC0259a());
            }
            if (this.f14923a == null) {
                this.f14923a = new f(this.f14924b.a(), this.f14925c);
            }
        }
    }

    public a(f fVar, ua.a aVar, FlutterJNI.c cVar, ExecutorService executorService) {
        this.f14920a = fVar;
        this.f14921b = cVar;
        this.f14922c = executorService;
    }

    public static a e() {
        f14919e = true;
        if (f14918d == null) {
            f14918d = new b().a();
        }
        return f14918d;
    }

    public ua.a a() {
        return null;
    }

    public ExecutorService b() {
        return this.f14922c;
    }

    public f c() {
        return this.f14920a;
    }

    public FlutterJNI.c d() {
        return this.f14921b;
    }
}
