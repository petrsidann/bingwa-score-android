package p4;

import android.app.Activity;
import android.app.PendingIntent;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.internal.r;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.v;
import com.google.android.gms.internal.fido.zzo;
import com.google.android.gms.internal.fido.zzp;
import com.google.android.gms.internal.fido.zzs;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import q4.u;

/* JADX INFO: loaded from: classes.dex */
public class a extends e<com.google.android.gms.common.api.a.d.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a.g f14135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f14136b;

    static {
        com.google.android.gms.common.api.a.g gVar = new com.google.android.gms.common.api.a.g();
        f14135a = gVar;
        f14136b = new com.google.android.gms.common.api.a("Fido.FIDO2_API", new zzo(), gVar);
    }

    @Deprecated
    public a(Activity activity) {
        super(activity, (com.google.android.gms.common.api.a<com.google.android.gms.common.api.a.d.c>) f14136b, com.google.android.gms.common.api.a.d.f3669g, (t) new com.google.android.gms.common.api.internal.a());
    }

    public Task<PendingIntent> b(final u uVar) {
        return doRead(v.a().b(new r() { // from class: p4.b
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.r
            public final void accept(Object obj, Object obj2) {
                a aVar = this.f14137a;
                u uVar2 = uVar;
                ((zzs) ((zzp) obj).getService()).zzc(new c(aVar, (TaskCompletionSource) obj2), uVar2);
            }
        }).e(5407).a());
    }
}
