package h6;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public final class e implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f9651a;

    public /* synthetic */ e(f fVar, d dVar) {
        this.f9651a = fVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f9651a.f9654b.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f9651a.c().post(new b(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f9651a.f9654b.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f9651a.c().post(new c(this));
    }
}
