package u4;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class pc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f16708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f16711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ me f16712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ qb f16713f;

    public pc(qb qbVar, AtomicReference atomicReference, String str, String str2, String str3, me meVar) {
        this.f16708a = atomicReference;
        this.f16709b = str;
        this.f16710c = str2;
        this.f16711d = str3;
        this.f16712e = meVar;
        this.f16713f = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        List<h> listH0;
        synchronized (this.f16708a) {
            try {
                try {
                    f5 f5Var = this.f16713f.f16738d;
                    if (f5Var == null) {
                        this.f16713f.zzj().C().d("(legacy) Failed to get conditional properties; not connected to service", v5.r(this.f16709b), this.f16710c, this.f16711d);
                        this.f16708a.set(Collections.emptyList());
                        this.f16708a.notify();
                        return;
                    }
                    if (TextUtils.isEmpty(this.f16709b)) {
                        com.google.android.gms.common.internal.r.l(this.f16712e);
                        atomicReference2 = this.f16708a;
                        listH0 = f5Var.R0(this.f16710c, this.f16711d, this.f16712e);
                    } else {
                        atomicReference2 = this.f16708a;
                        listH0 = f5Var.h0(this.f16709b, this.f16710c, this.f16711d);
                    }
                    atomicReference2.set(listH0);
                    this.f16713f.m0();
                    atomicReference = this.f16708a;
                    atomicReference.notify();
                } catch (RemoteException e10) {
                    this.f16713f.zzj().C().d("(legacy) Failed to get conditional properties; remote exception", v5.r(this.f16709b), this.f16710c, e10);
                    this.f16708a.set(Collections.emptyList());
                    atomicReference = this.f16708a;
                }
            } catch (Throwable th) {
                this.f16708a.notify();
                throw th;
            }
        }
    }
}
