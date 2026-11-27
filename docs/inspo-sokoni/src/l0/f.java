package l0;

import android.os.CancellationSignal;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f12395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12396c;

    public static class a {
        public static void a(Object obj) {
            ((CancellationSignal) obj).cancel();
        }

        public static CancellationSignal b() {
            return new CancellationSignal();
        }
    }

    public void a() {
        synchronized (this) {
            if (this.f12394a) {
                return;
            }
            this.f12394a = true;
            this.f12396c = true;
            Object obj = this.f12395b;
            if (obj != null) {
                try {
                    a.a(obj);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f12396c = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            synchronized (this) {
                this.f12396c = false;
                notifyAll();
            }
        }
    }
}
