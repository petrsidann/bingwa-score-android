package u4;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzdq;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class sc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ me f16808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzdq f16809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ qb f16810e;

    public sc(qb qbVar, String str, String str2, me meVar, zzdq zzdqVar) {
        this.f16806a = str;
        this.f16807b = str2;
        this.f16808c = meVar;
        this.f16809d = zzdqVar;
        this.f16810e = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            try {
                f5 f5Var = this.f16810e.f16738d;
                if (f5Var == null) {
                    this.f16810e.zzj().C().c("Failed to get conditional properties; not connected to service", this.f16806a, this.f16807b);
                } else {
                    com.google.android.gms.common.internal.r.l(this.f16808c);
                    arrayList = af.p0(f5Var.R0(this.f16806a, this.f16807b, this.f16808c));
                    this.f16810e.m0();
                }
            } catch (RemoteException e10) {
                this.f16810e.zzj().C().d("Failed to get conditional properties; remote exception", this.f16806a, this.f16807b, e10);
            }
        } finally {
            this.f16810e.g().P(this.f16809d, arrayList);
        }
    }
}
