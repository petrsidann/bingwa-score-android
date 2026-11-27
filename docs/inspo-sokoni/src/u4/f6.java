package u4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public class f6 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ge f16183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16185c;

    public f6(ge geVar) {
        com.google.android.gms.common.internal.r.l(geVar);
        this.f16183a = geVar;
    }

    public final void b() {
        this.f16183a.J0();
        this.f16183a.zzl().j();
        if (this.f16184b) {
            return;
        }
        this.f16183a.zza().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f16185c = this.f16183a.y0().x();
        this.f16183a.zzj().G().b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f16185c));
        this.f16184b = true;
    }

    public final void c() {
        this.f16183a.J0();
        this.f16183a.zzl().j();
        this.f16183a.zzl().j();
        if (this.f16184b) {
            this.f16183a.zzj().G().a("Unregistering connectivity change receiver");
            this.f16184b = false;
            this.f16185c = false;
            try {
                this.f16183a.zza().unregisterReceiver(this);
            } catch (IllegalArgumentException e10) {
                this.f16183a.zzj().C().b("Failed to unregister the network broadcast receiver", e10);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f16183a.J0();
        String action = intent.getAction();
        this.f16183a.zzj().G().b("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.f16183a.zzj().H().b("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zX = this.f16183a.y0().x();
        if (this.f16185c != zX) {
            this.f16185c = zX;
            this.f16183a.zzl().y(new j6(this, zX));
        }
    }
}
