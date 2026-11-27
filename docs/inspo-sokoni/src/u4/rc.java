package u4;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class rc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f16762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f16765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ me f16766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f16767f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ qb f16768l;

    public rc(qb qbVar, AtomicReference atomicReference, String str, String str2, String str3, me meVar, boolean z10) {
        this.f16762a = atomicReference;
        this.f16763b = str;
        this.f16764c = str2;
        this.f16765d = str3;
        this.f16766e = meVar;
        this.f16767f = z10;
        this.f16768l = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        List<ze> listB;
        synchronized (this.f16762a) {
            try {
                try {
                    f5 f5Var = this.f16768l.f16738d;
                    if (f5Var == null) {
                        this.f16768l.zzj().C().d("(legacy) Failed to get user properties; not connected to service", v5.r(this.f16763b), this.f16764c, this.f16765d);
                        this.f16762a.set(Collections.emptyList());
                        this.f16762a.notify();
                        return;
                    }
                    if (TextUtils.isEmpty(this.f16763b)) {
                        com.google.android.gms.common.internal.r.l(this.f16766e);
                        atomicReference2 = this.f16762a;
                        listB = f5Var.U0(this.f16764c, this.f16765d, this.f16767f, this.f16766e);
                    } else {
                        atomicReference2 = this.f16762a;
                        listB = f5Var.B(this.f16763b, this.f16764c, this.f16765d, this.f16767f);
                    }
                    atomicReference2.set(listB);
                    this.f16768l.m0();
                    atomicReference = this.f16762a;
                    atomicReference.notify();
                } catch (RemoteException e10) {
                    this.f16768l.zzj().C().d("(legacy) Failed to get user properties; remote exception", v5.r(this.f16763b), this.f16764c, e10);
                    this.f16762a.set(Collections.emptyList());
                    atomicReference = this.f16762a;
                }
            } catch (Throwable th) {
                this.f16762a.notify();
                throw th;
            }
        }
    }
}
