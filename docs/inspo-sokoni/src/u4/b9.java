package u4;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzdz;

/* JADX INFO: loaded from: classes.dex */
public final class b9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f16026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f16027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f16028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zzdz f16029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16030h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f16031i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f16032j;

    public b9(Context context, zzdz zzdzVar, Long l10) {
        this.f16030h = true;
        com.google.android.gms.common.internal.r.l(context);
        Context applicationContext = context.getApplicationContext();
        com.google.android.gms.common.internal.r.l(applicationContext);
        this.f16023a = applicationContext;
        this.f16031i = l10;
        if (zzdzVar != null) {
            this.f16029g = zzdzVar;
            this.f16024b = zzdzVar.zzf;
            this.f16025c = zzdzVar.zze;
            this.f16026d = zzdzVar.zzd;
            this.f16030h = zzdzVar.zzc;
            this.f16028f = zzdzVar.zzb;
            this.f16032j = zzdzVar.zzh;
            Bundle bundle = zzdzVar.zzg;
            if (bundle != null) {
                this.f16027e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
