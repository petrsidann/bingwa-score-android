package p1;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import o0.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<D> extends b<D> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Executor f14072i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile a<D>.RunnableC0245a f14073j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile a<D>.RunnableC0245a f14074k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f14075l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f14076m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Handler f14077n;

    /* JADX INFO: renamed from: p1.a$a, reason: collision with other inner class name */
    public final class RunnableC0245a extends c<Void, Void, D> implements Runnable {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final CountDownLatch f14078p = new CountDownLatch(1);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f14079q;

        public RunnableC0245a() {
        }

        @Override // p1.c
        public void h(D d10) {
            try {
                a.this.x(this, d10);
            } finally {
                this.f14078p.countDown();
            }
        }

        @Override // p1.c
        public void i(D d10) {
            try {
                a.this.y(this, d10);
            } finally {
                this.f14078p.countDown();
            }
        }

        @Override // p1.c
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public D b(Void... voidArr) {
            return (D) a.this.C();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14079q = false;
            a.this.z();
        }
    }

    public a(Context context) {
        this(context, c.f14091m);
    }

    public a(Context context, Executor executor) {
        super(context);
        this.f14076m = -10000L;
        this.f14072i = executor;
    }

    public abstract D A();

    public void B(D d10) {
    }

    public D C() {
        return A();
    }

    @Override // p1.b
    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        if (this.f14073j != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f14073j);
            printWriter.print(" waiting=");
            printWriter.println(this.f14073j.f14079q);
        }
        if (this.f14074k != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f14074k);
            printWriter.print(" waiting=");
            printWriter.println(this.f14074k.f14079q);
        }
        if (this.f14075l != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            i.c(this.f14075l, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            i.b(this.f14076m, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    @Override // p1.b
    public boolean k() {
        if (this.f14073j == null) {
            return false;
        }
        if (!this.f14084d) {
            this.f14087g = true;
        }
        if (this.f14074k != null) {
            if (this.f14073j.f14079q) {
                this.f14073j.f14079q = false;
                this.f14077n.removeCallbacks(this.f14073j);
            }
            this.f14073j = null;
            return false;
        }
        if (this.f14073j.f14079q) {
            this.f14073j.f14079q = false;
            this.f14077n.removeCallbacks(this.f14073j);
            this.f14073j = null;
            return false;
        }
        boolean zA = this.f14073j.a(false);
        if (zA) {
            this.f14074k = this.f14073j;
            w();
        }
        this.f14073j = null;
        return zA;
    }

    @Override // p1.b
    public void m() {
        super.m();
        b();
        this.f14073j = new RunnableC0245a();
        z();
    }

    public void w() {
    }

    public void x(a<D>.RunnableC0245a runnableC0245a, D d10) {
        B(d10);
        if (this.f14074k == runnableC0245a) {
            s();
            this.f14076m = SystemClock.uptimeMillis();
            this.f14074k = null;
            e();
            z();
        }
    }

    public void y(a<D>.RunnableC0245a runnableC0245a, D d10) {
        if (this.f14073j != runnableC0245a) {
            x(runnableC0245a, d10);
            return;
        }
        if (i()) {
            B(d10);
            return;
        }
        c();
        this.f14076m = SystemClock.uptimeMillis();
        this.f14073j = null;
        f(d10);
    }

    public void z() {
        if (this.f14074k != null || this.f14073j == null) {
            return;
        }
        if (this.f14073j.f14079q) {
            this.f14073j.f14079q = false;
            this.f14077n.removeCallbacks(this.f14073j);
        }
        if (this.f14075l <= 0 || SystemClock.uptimeMillis() >= this.f14076m + this.f14075l) {
            this.f14073j.c(this.f14072i, null);
        } else {
            this.f14073j.f14079q = true;
            this.f14077n.postAtTime(this.f14073j, this.f14076m + this.f14075l);
        }
    }
}
