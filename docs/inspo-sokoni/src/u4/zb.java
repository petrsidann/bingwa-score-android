package u4;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f17000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ me f17001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f17002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ qb f17003d;

    public zb(qb qbVar, AtomicReference atomicReference, me meVar, Bundle bundle) {
        this.f17000a = atomicReference;
        this.f17001b = meVar;
        this.f17002c = bundle;
        this.f17003d = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.f17000a) {
            try {
                try {
                    f5 f5Var = this.f17003d.f16738d;
                    if (f5Var == null) {
                        this.f17003d.zzj().C().a("Failed to get trigger URIs; not connected to service");
                        this.f17000a.notify();
                        return;
                    }
                    com.google.android.gms.common.internal.r.l(this.f17001b);
                    this.f17000a.set(f5Var.T(this.f17001b, this.f17002c));
                    this.f17003d.m0();
                    atomicReference = this.f17000a;
                    atomicReference.notify();
                } catch (RemoteException e10) {
                    this.f17003d.zzj().C().b("Failed to get trigger URIs; remote exception", e10);
                    atomicReference = this.f17000a;
                }
            } catch (Throwable th) {
                this.f17000a.notify();
                throw th;
            }
        }
    }
}
