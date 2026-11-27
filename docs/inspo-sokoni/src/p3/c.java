package p3;

import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
public final class c extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<a> f14131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CountDownLatch f14133c = new CountDownLatch(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14134d = false;

    public c(a aVar, long j10) {
        this.f14131a = new WeakReference<>(aVar);
        this.f14132b = j10;
        start();
    }

    public final void a() {
        a aVar = this.f14131a.get();
        if (aVar != null) {
            aVar.c();
            this.f14134d = true;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            if (this.f14133c.await(this.f14132b, TimeUnit.MILLISECONDS)) {
                return;
            }
            a();
        } catch (InterruptedException unused) {
            a();
        }
    }
}
