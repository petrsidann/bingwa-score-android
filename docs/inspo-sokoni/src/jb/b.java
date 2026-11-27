package jb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class b extends BroadcastReceiver implements fb.c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f11331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public jb.a f11332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public fb.c.b f11333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f11334d = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f11335e;

    public class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            b.this.d();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            b.this.d();
        }
    }

    /* JADX INFO: renamed from: jb.b$b, reason: collision with other inner class name */
    public class RunnableC0190b implements Runnable {
        public RunnableC0190b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f11333c.a(b.this.f11332b.b());
        }
    }

    public b(Context context, jb.a aVar) {
        this.f11331a = context;
        this.f11332b = aVar;
    }

    public final void d() {
        this.f11334d.post(new RunnableC0190b());
    }

    @Override // fb.c.d
    public void onCancel(Object obj) {
        if (this.f11335e != null) {
            this.f11332b.a().unregisterNetworkCallback(this.f11335e);
            this.f11335e = null;
        }
    }

    @Override // fb.c.d
    public void onListen(Object obj, fb.c.b bVar) {
        this.f11333c = bVar;
        this.f11335e = new a();
        this.f11332b.a().registerDefaultNetworkCallback(this.f11335e);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        fb.c.b bVar = this.f11333c;
        if (bVar != null) {
            bVar.a(this.f11332b.b());
        }
    }
}
