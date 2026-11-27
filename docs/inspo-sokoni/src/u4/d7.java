package u4;

import android.content.Context;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class d7 extends r8 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AtomicLong f16099l = new AtomicLong(Long.MIN_VALUE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g7 f16100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g7 f16101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PriorityBlockingQueue<i7<?>> f16102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BlockingQueue<i7<?>> f16103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f16104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f16105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f16106i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Semaphore f16107j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f16108k;

    public d7(k7 k7Var) {
        super(k7Var);
        this.f16106i = new Object();
        this.f16107j = new Semaphore(2);
        this.f16102e = new PriorityBlockingQueue<>();
        this.f16103f = new LinkedBlockingQueue();
        this.f16104g = new f7(this, "Thread death: Uncaught exception on worker thread");
        this.f16105h = new f7(this, "Thread death: Uncaught exception on network thread");
    }

    public final void C(Runnable runnable) {
        l();
        com.google.android.gms.common.internal.r.l(runnable);
        v(new i7<>(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean F() {
        return Thread.currentThread() == this.f16101d;
    }

    public final boolean G() {
        return Thread.currentThread() == this.f16100c;
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ j a() {
        return super.a();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ h0 c() {
        return super.c();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ s5 d() {
        return super.d();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ i6 e() {
        return super.e();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ ab f() {
        return super.f();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ af g() {
        return super.g();
    }

    @Override // u4.o8
    public final void h() {
        if (Thread.currentThread() != this.f16101d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    @Override // u4.o8
    public final void j() {
        if (Thread.currentThread() != this.f16100c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // u4.r8
    public final boolean p() {
        return false;
    }

    public final <T> T q(AtomicReference<T> atomicReference, long j10, String str, Runnable runnable) {
        synchronized (atomicReference) {
            zzl().y(runnable);
            try {
                atomicReference.wait(j10);
            } catch (InterruptedException unused) {
                zzj().H().a("Interrupted waiting for " + str);
                return null;
            }
        }
        T t10 = atomicReference.get();
        if (t10 == null) {
            zzj().H().a("Timed out waiting for " + str);
        }
        return t10;
    }

    public final <V> Future<V> r(Callable<V> callable) {
        l();
        com.google.android.gms.common.internal.r.l(callable);
        i7<?> i7Var = new i7<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f16100c) {
            if (!this.f16102e.isEmpty()) {
                zzj().H().a("Callable skipped the worker queue.");
            }
            i7Var.run();
        } else {
            v(i7Var);
        }
        return i7Var;
    }

    public final void t(Runnable runnable) {
        l();
        com.google.android.gms.common.internal.r.l(runnable);
        i7<?> i7Var = new i7<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.f16106i) {
            this.f16103f.add(i7Var);
            g7 g7Var = this.f16101d;
            if (g7Var == null) {
                g7 g7Var2 = new g7(this, "Measurement Network", this.f16103f);
                this.f16101d = g7Var2;
                g7Var2.setUncaughtExceptionHandler(this.f16105h);
                this.f16101d.start();
            } else {
                g7Var.a();
            }
        }
    }

    public final void v(i7<?> i7Var) {
        synchronized (this.f16106i) {
            this.f16102e.add(i7Var);
            g7 g7Var = this.f16100c;
            if (g7Var == null) {
                g7 g7Var2 = new g7(this, "Measurement Worker", this.f16102e);
                this.f16100c = g7Var2;
                g7Var2.setUncaughtExceptionHandler(this.f16104g);
                this.f16100c.start();
            } else {
                g7Var.a();
            }
        }
    }

    public final <V> Future<V> w(Callable<V> callable) {
        l();
        com.google.android.gms.common.internal.r.l(callable);
        i7<?> i7Var = new i7<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f16100c) {
            i7Var.run();
        } else {
            v(i7Var);
        }
        return i7Var;
    }

    public final void y(Runnable runnable) {
        l();
        com.google.android.gms.common.internal.r.l(runnable);
        v(new i7<>(this, runnable, false, "Task exception on worker thread"));
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ j4.d zzb() {
        return super.zzb();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ g zzd() {
        return super.zzd();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ v5 zzj() {
        return super.zzj();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ d7 zzl() {
        return super.zzl();
    }
}
