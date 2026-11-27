package u4;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zzby;
import com.google.android.gms.internal.measurement.zzbz;

/* JADX INFO: loaded from: classes.dex */
public final class q6 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r6 f16726b;

    public q6(r6 r6Var, String str) {
        this.f16726b = r6Var;
        this.f16725a = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f16726b.f16753a.zzj().H().a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            zzbz zzbzVarZza = zzby.zza(iBinder);
            if (zzbzVarZza == null) {
                this.f16726b.f16753a.zzj().H().a("Install Referrer Service implementation was not found");
            } else {
                this.f16726b.f16753a.zzj().G().a("Install Referrer Service connected");
                this.f16726b.f16753a.zzl().y(new t6(this, zzbzVarZza, this));
            }
        } catch (RuntimeException e10) {
            this.f16726b.f16753a.zzj().H().b("Exception occurred while calling Install Referrer API", e10);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f16726b.f16753a.zzj().G().a("Install Referrer Service disconnected");
    }
}
