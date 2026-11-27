package wb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.util.Log;
import j6.m;
import java.util.concurrent.TimeUnit;
import vb.a0;
import vb.b1;
import vb.g;
import vb.m0;
import vb.q;
import vb.w0;
import vb.x0;
import vb.y0;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends a0<a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y0 f17843c = j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x0<?> f17844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f17845b;

    public static final class b extends w0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w0 f17846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f17847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ConnectivityManager f17848c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f17849d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Runnable f17850e;

        /* JADX INFO: renamed from: wb.a$b$a, reason: collision with other inner class name */
        public class RunnableC0316a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f17851a;

            public RunnableC0316a(c cVar) {
                this.f17851a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f17848c.unregisterNetworkCallback(this.f17851a);
            }
        }

        /* JADX INFO: renamed from: wb.a$b$b, reason: collision with other inner class name */
        public class RunnableC0317b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f17853a;

            public RunnableC0317b(d dVar) {
                this.f17853a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f17847b.unregisterReceiver(this.f17853a);
            }
        }

        public class c extends ConnectivityManager.NetworkCallback {
            public c() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                b.this.f17846a.j();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onBlockedStatusChanged(Network network, boolean z10) {
                if (z10) {
                    return;
                }
                b.this.f17846a.j();
            }
        }

        public class d extends BroadcastReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f17856a;

            public d() {
                this.f17856a = false;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                boolean z10 = this.f17856a;
                boolean z11 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
                this.f17856a = z11;
                if (!z11 || z10) {
                    return;
                }
                b.this.f17846a.j();
            }
        }

        public b(w0 w0Var, Context context) {
            this.f17846a = w0Var;
            this.f17847b = context;
            if (context == null) {
                this.f17848c = null;
                return;
            }
            this.f17848c = (ConnectivityManager) context.getSystemService("connectivity");
            try {
                r();
            } catch (SecurityException e10) {
                Log.w("AndroidChannelBuilder", "Failed to configure network monitoring. Does app have ACCESS_NETWORK_STATE permission?", e10);
            }
        }

        @Override // vb.d
        public String b() {
            return this.f17846a.b();
        }

        @Override // vb.d
        public <RequestT, ResponseT> g<RequestT, ResponseT> f(b1<RequestT, ResponseT> b1Var, vb.c cVar) {
            return this.f17846a.f(b1Var, cVar);
        }

        @Override // vb.w0
        public boolean i(long j10, TimeUnit timeUnit) {
            return this.f17846a.i(j10, timeUnit);
        }

        @Override // vb.w0
        public void j() {
            this.f17846a.j();
        }

        @Override // vb.w0
        public q k(boolean z10) {
            return this.f17846a.k(z10);
        }

        @Override // vb.w0
        public void l(q qVar, Runnable runnable) {
            this.f17846a.l(qVar, runnable);
        }

        @Override // vb.w0
        public w0 m() {
            s();
            return this.f17846a.m();
        }

        @Override // vb.w0
        public w0 n() {
            s();
            return this.f17846a.n();
        }

        public final void r() {
            Runnable runnableC0317b;
            if (this.f17848c != null) {
                c cVar = new c();
                this.f17848c.registerDefaultNetworkCallback(cVar);
                runnableC0317b = new RunnableC0316a(cVar);
            } else {
                d dVar = new d();
                this.f17847b.registerReceiver(dVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                runnableC0317b = new RunnableC0317b(dVar);
            }
            this.f17850e = runnableC0317b;
        }

        public final void s() {
            synchronized (this.f17849d) {
                Runnable runnable = this.f17850e;
                if (runnable != null) {
                    runnable.run();
                    this.f17850e = null;
                }
            }
        }
    }

    public a(x0<?> x0Var) {
        this.f17844a = (x0) m.p(x0Var, "delegateBuilder");
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 4 */
    public static y0 j() {
        try {
            try {
                y0 y0Var = (y0) yb.g.class.asSubclass(y0.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                if (m0.a(y0Var)) {
                    return y0Var;
                }
                Log.w("AndroidChannelBuilder", "OkHttpChannelProvider.isAvailable() returned false");
                return null;
            } catch (Exception e10) {
                Log.w("AndroidChannelBuilder", "Failed to construct OkHttpChannelProvider", e10);
                return null;
            }
        } catch (ClassCastException e11) {
            Log.w("AndroidChannelBuilder", "Couldn't cast OkHttpChannelProvider to ManagedChannelProvider", e11);
            return null;
        }
    }

    public static a k(x0<?> x0Var) {
        return new a(x0Var);
    }

    @Override // vb.z, vb.x0
    public w0 a() {
        return new b(this.f17844a.a(), this.f17845b);
    }

    @Override // vb.a0, vb.z
    public x0<?> e() {
        return this.f17844a;
    }

    public a i(Context context) {
        this.f17845b = context;
        return this;
    }
}
