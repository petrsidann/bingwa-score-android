package xb;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class i2 implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f18652c = Logger.getLogger(i2.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayDeque<Runnable> f18654b;

    public final void a() {
        while (true) {
            Runnable runnablePoll = this.f18654b.poll();
            if (runnablePoll == null) {
                return;
            }
            try {
                runnablePoll.run();
            } catch (Throwable th) {
                f18652c.log(Level.SEVERE, "Exception while executing runnable " + runnablePoll, th);
            }
        }
    }

    public final void b(Runnable runnable) {
        if (this.f18654b == null) {
            this.f18654b = new ArrayDeque<>(4);
        }
        this.f18654b.add(runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        j6.m.p(runnable, "'task' must not be null.");
        if (this.f18653a) {
            b(runnable);
            return;
        }
        this.f18653a = true;
        try {
            runnable.run();
            if (this.f18654b != null) {
            }
        } catch (Throwable th) {
            try {
                f18652c.log(Level.SEVERE, "Exception while executing runnable " + runnable, th);
            } finally {
                if (this.f18654b != null) {
                    a();
                }
                this.f18653a = false;
            }
        }
    }
}
