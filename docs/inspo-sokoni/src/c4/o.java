package c4;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zau;

/* JADX INFO: loaded from: classes.dex */
public final class o extends zau {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f3393b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(e eVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f3393b = eVar;
        this.f3392a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i10);
            return;
        }
        e eVar = this.f3393b;
        int iG = eVar.g(this.f3392a);
        if (eVar.j(iG)) {
            this.f3393b.p(this.f3392a, iG);
        }
    }
}
