package w3;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.e;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends e<com.google.android.gms.common.api.a.d.c> {
    private static final com.google.android.gms.common.api.a.g zza;
    private static final com.google.android.gms.common.api.a.AbstractC0072a zzb;
    private static final com.google.android.gms.common.api.a zzc;

    static {
        com.google.android.gms.common.api.a.g gVar = new com.google.android.gms.common.api.a.g();
        zza = gVar;
        c cVar = new c();
        zzb = cVar;
        zzc = new com.google.android.gms.common.api.a("SmsRetriever.API", cVar, gVar);
    }

    public b(Activity activity) {
        super(activity, (com.google.android.gms.common.api.a<com.google.android.gms.common.api.a.d.c>) zzc, com.google.android.gms.common.api.a.d.f3669g, e.a.f3671c);
    }

    public b(Context context) {
        super(context, (com.google.android.gms.common.api.a<com.google.android.gms.common.api.a.d.c>) zzc, com.google.android.gms.common.api.a.d.f3669g, e.a.f3671c);
    }

    public abstract Task<Void> startSmsRetriever();

    public abstract Task<Void> startSmsUserConsent(String str);
}
