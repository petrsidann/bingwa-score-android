package xb;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class d1 implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f18410b = Logger.getLogger(d1.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f18411a;

    public d1(Runnable runnable) {
        this.f18411a = (Runnable) j6.m.p(runnable, "task");
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f18411a.run();
        } catch (Throwable th) {
            f18410b.log(Level.SEVERE, "Exception while executing runnable " + this.f18411a, th);
            j6.u.f(th);
            throw new AssertionError(th);
        }
    }

    public String toString() {
        return "LogExceptionRunnable(" + this.f18411a + ")";
    }
}
