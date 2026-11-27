package u4;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class uc implements ServiceConnection, com.google.android.gms.common.internal.c.a, com.google.android.gms.common.internal.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f16873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile u5 f16874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ qb f16875c;

    public uc(qb qbVar) {
        this.f16875c = qbVar;
    }

    public final void a() {
        this.f16875c.j();
        Context contextZza = this.f16875c.zza();
        synchronized (this) {
            if (this.f16873a) {
                this.f16875c.zzj().G().a("Connection attempt already in progress");
                return;
            }
            if (this.f16874b != null && (this.f16874b.isConnecting() || this.f16874b.isConnected())) {
                this.f16875c.zzj().G().a("Already awaiting connection attempt");
                return;
            }
            this.f16874b = new u5(contextZza, Looper.getMainLooper(), this, this);
            this.f16875c.zzj().G().a("Connecting to remote service");
            this.f16873a = true;
            com.google.android.gms.common.internal.r.l(this.f16874b);
            this.f16874b.checkAvailabilityAndConnect();
        }
    }

    @Override // com.google.android.gms.common.internal.c.b
    public final void b(c4.b bVar) {
        com.google.android.gms.common.internal.r.e("MeasurementServiceConnection.onConnectionFailed");
        v5 v5VarB = this.f16875c.f16624a.B();
        if (v5VarB != null) {
            v5VarB.H().b("Service connection failed", bVar);
        }
        synchronized (this) {
            this.f16873a = false;
            this.f16874b = null;
        }
        this.f16875c.zzl().y(new xc(this));
    }

    public final void c(Intent intent) {
        this.f16875c.j();
        Context contextZza = this.f16875c.zza();
        i4.b bVarB = i4.b.b();
        synchronized (this) {
            if (this.f16873a) {
                this.f16875c.zzj().G().a("Connection attempt already in progress");
                return;
            }
            this.f16875c.zzj().G().a("Using local app measurement service");
            this.f16873a = true;
            bVarB.a(contextZza, intent, this.f16875c.f16737c, 129);
        }
    }

    public final void e() {
        if (this.f16874b != null && (this.f16874b.isConnected() || this.f16874b.isConnecting())) {
            this.f16874b.disconnect();
        }
        this.f16874b = null;
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void f(int i10) {
        com.google.android.gms.common.internal.r.e("MeasurementServiceConnection.onConnectionSuspended");
        this.f16875c.zzj().B().a("Service connection suspended");
        this.f16875c.zzl().y(new yc(this));
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void i(Bundle bundle) {
        com.google.android.gms.common.internal.r.e("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                com.google.android.gms.common.internal.r.l(this.f16874b);
                this.f16875c.zzl().y(new vc(this, this.f16874b.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f16874b = null;
                this.f16873a = false;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.common.internal.r.e("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f16873a = false;
                this.f16875c.zzj().C().a("Service connected with null binder");
                return;
            }
            f5 i5Var = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    i5Var = iInterfaceQueryLocalInterface instanceof f5 ? (f5) iInterfaceQueryLocalInterface : new i5(iBinder);
                    this.f16875c.zzj().G().a("Bound to IMeasurementService interface");
                } else {
                    this.f16875c.zzj().C().b("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f16875c.zzj().C().a("Service connect failed to get IMeasurementService");
            }
            if (i5Var == null) {
                this.f16873a = false;
                try {
                    i4.b.b().c(this.f16875c.zza(), this.f16875c.f16737c);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f16875c.zzl().y(new tc(this, i5Var));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.common.internal.r.e("MeasurementServiceConnection.onServiceDisconnected");
        this.f16875c.zzj().B().a("Service disconnected");
        this.f16875c.zzl().y(new wc(this, componentName));
    }
}
