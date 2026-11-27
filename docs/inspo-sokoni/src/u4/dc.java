package u4;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class dc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f16116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ me f16117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ qb f16118c;

    public dc(qb qbVar, AtomicReference atomicReference, me meVar) {
        this.f16116a = atomicReference;
        this.f16117b = meVar;
        this.f16118c = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.f16116a) {
            try {
                try {
                    if (!this.f16118c.e().I().x()) {
                        this.f16118c.zzj().I().a("Analytics storage consent denied; will not get app instance id");
                        this.f16118c.n().Q0(null);
                        this.f16118c.e().f16333i.b(null);
                        this.f16116a.set(null);
                        this.f16116a.notify();
                        return;
                    }
                    f5 f5Var = this.f16118c.f16738d;
                    if (f5Var == null) {
                        this.f16118c.zzj().C().a("Failed to get app instance id");
                        this.f16116a.notify();
                        return;
                    }
                    com.google.android.gms.common.internal.r.l(this.f16117b);
                    this.f16116a.set(f5Var.l0(this.f16117b));
                    String str = (String) this.f16116a.get();
                    if (str != null) {
                        this.f16118c.n().Q0(str);
                        this.f16118c.e().f16333i.b(str);
                    }
                    this.f16118c.m0();
                    atomicReference = this.f16116a;
                    atomicReference.notify();
                } catch (RemoteException e10) {
                    this.f16118c.zzj().C().b("Failed to get app instance id", e10);
                    atomicReference = this.f16116a;
                }
            } catch (Throwable th) {
                this.f16116a.notify();
                throw th;
            }
        }
    }
}
