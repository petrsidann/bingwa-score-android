package u4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzoy;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class df extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k7 f16123a;

    public df(k7 k7Var) {
        this.f16123a = k7Var;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            this.f16123a.zzj().H().a("App receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            this.f16123a.zzj().H().a("App receiver called with null action");
            return;
        }
        if (action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
            final k7 k7Var = this.f16123a;
            if (zzoy.zza() && k7Var.w().F(null, p0.R0)) {
                k7Var.zzj().G().a("App receiver notified triggers are available");
                k7Var.zzl().y(new Runnable() { // from class: u4.ff
                    @Override // java.lang.Runnable
                    public final void run() {
                        k7 k7Var2 = k7Var;
                        if (!k7Var2.K().Q0()) {
                            k7Var2.zzj().H().a("registerTrigger called but app not eligible");
                            return;
                        }
                        k7Var2.E().D0();
                        final e9 e9VarE = k7Var2.E();
                        Objects.requireNonNull(e9VarE);
                        new Thread(new Runnable() { // from class: u4.gf
                            @Override // java.lang.Runnable
                            public final void run() {
                                e9VarE.F0();
                            }
                        }).start();
                    }
                });
                return;
            }
            return;
        }
        if (!action.equals("com.google.android.gms.measurement.BATCHES_AVAILABLE")) {
            this.f16123a.zzj().H().a("App receiver called with unknown action");
        } else if (this.f16123a.w().F(null, p0.M0)) {
            this.f16123a.zzj().G().a("[sgtm] App Receiver notified batches are available");
            this.f16123a.zzl().y(new Runnable() { // from class: u4.if
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16372a.f16123a.G().y(p0.f16691z.a(null).longValue());
                }
            });
        }
    }
}
