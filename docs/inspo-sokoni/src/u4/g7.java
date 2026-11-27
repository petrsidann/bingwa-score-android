package u4;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public final class g7 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f16210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BlockingQueue<i7<?>> f16211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16212c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d7 f16213d;

    public g7(d7 d7Var, String str, BlockingQueue<i7<?>> blockingQueue) {
        this.f16213d = d7Var;
        com.google.android.gms.common.internal.r.l(str);
        com.google.android.gms.common.internal.r.l(blockingQueue);
        this.f16210a = new Object();
        this.f16211b = blockingQueue;
        setName(str);
    }

    public final void a() {
        synchronized (this.f16210a) {
            this.f16210a.notifyAll();
        }
    }

    public final void b(InterruptedException interruptedException) {
        this.f16213d.zzj().H().b(getName() + " was interrupted", interruptedException);
    }

    public final void c() {
        synchronized (this.f16213d.f16106i) {
            if (!this.f16212c) {
                this.f16213d.f16107j.release();
                this.f16213d.f16106i.notifyAll();
                if (this == this.f16213d.f16100c) {
                    this.f16213d.f16100c = null;
                } else if (this == this.f16213d.f16101d) {
                    this.f16213d.f16101d = null;
                } else {
                    this.f16213d.zzj().C().a("Current scheduler thread is neither worker nor network");
                }
                this.f16212c = true;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z10 = false;
        while (!z10) {
            try {
                this.f16213d.f16107j.acquire();
                z10 = true;
            } catch (InterruptedException e10) {
                b(e10);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                i7<?> i7VarPoll = this.f16211b.poll();
                if (i7VarPoll != null) {
                    Process.setThreadPriority(i7VarPoll.f16352b ? threadPriority : 10);
                    i7VarPoll.run();
                } else {
                    synchronized (this.f16210a) {
                        if (this.f16211b.peek() == null && !this.f16213d.f16108k) {
                            try {
                                this.f16210a.wait(30000L);
                            } catch (InterruptedException e11) {
                                b(e11);
                            }
                        }
                    }
                    synchronized (this.f16213d.f16106i) {
                        if (this.f16211b.peek() == null) {
                            c();
                            c();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            c();
            throw th;
        }
    }
}
