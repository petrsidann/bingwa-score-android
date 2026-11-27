package u4;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class oe extends d0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ge f16634e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oe(ge geVar, q8 q8Var) {
        super(q8Var);
        this.f16634e = geVar;
    }

    @Override // u4.d0
    public final void d() {
        this.f16634e.H0();
        String str = (String) this.f16634e.f16244q.pollFirst();
        if (str != null) {
            ge geVar = this.f16634e;
            geVar.I = geVar.zzb().b();
            this.f16634e.zzj().G().b("Sending trigger URI notification to app", str);
            Intent intent = new Intent();
            intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            intent.setPackage(str);
            this.f16634e.zza().sendBroadcast(intent);
        }
        this.f16634e.V();
    }
}
