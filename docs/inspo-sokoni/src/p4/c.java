package p4;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.w;
import com.google.android.gms.internal.fido.zzq;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class c extends zzq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f14139a;

    public c(a aVar, TaskCompletionSource taskCompletionSource) {
        this.f14139a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.fido.zzr
    public final void zzb(Status status, PendingIntent pendingIntent) {
        w.b(status, pendingIntent, this.f14139a);
    }
}
