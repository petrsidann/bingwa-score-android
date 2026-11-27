package b4;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.cloudmessaging.zzf;

/* JADX INFO: loaded from: classes.dex */
public final class i extends zzf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f2819a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c cVar, Looper looper) {
        super(looper);
        this.f2819a = cVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        c.g(this.f2819a, message);
    }
}
