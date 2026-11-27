package k8;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class j implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f11710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f11711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<l8.n<n.a>> f11712d = new ArrayList();

    public class a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f11713a;

        public a(AtomicBoolean atomicBoolean) {
            this.f11713a = atomicBoolean;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (this.f11713a.compareAndSet(true, false)) {
                j.this.l();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (this.f11713a.compareAndSet(true, false)) {
                j.this.l();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f11713a.compareAndSet(true, false)) {
                j.this.l();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    public class b implements ComponentCallbacks2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f11715a;

        public b(AtomicBoolean atomicBoolean) {
            this.f11715a = atomicBoolean;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i10) {
            if (i10 == 20) {
                this.f11715a.set(true);
            }
        }
    }

    public class c extends ConnectivityManager.NetworkCallback {
        public c() {
        }

        public /* synthetic */ c(j jVar, a aVar) {
            this();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            j.this.k(true);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            j.this.k(false);
        }
    }

    public class d extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f11718a;

        public d() {
            this.f11718a = false;
        }

        public /* synthetic */ d(j jVar, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            j jVar;
            boolean z10;
            boolean zH = j.this.h();
            if (!j.this.h() || this.f11718a) {
                if (!zH && this.f11718a) {
                    jVar = j.this;
                    z10 = false;
                }
                this.f11718a = zH;
            }
            jVar = j.this;
            z10 = true;
            jVar.k(z10);
            this.f11718a = zH;
        }
    }

    public j(Context context) {
        l8.b.d(context != null, "Context must be non-null", new Object[0]);
        this.f11709a = context;
        this.f11710b = (ConnectivityManager) context.getSystemService("connectivity");
        f();
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(c cVar) {
        this.f11710b.unregisterNetworkCallback(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(d dVar) {
        this.f11709a.unregisterReceiver(dVar);
    }

    @Override // k8.n
    public void a(l8.n<n.a> nVar) {
        synchronized (this.f11712d) {
            this.f11712d.add(nVar);
        }
    }

    public final void f() {
        Application application = (Application) this.f11709a.getApplicationContext();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        application.registerActivityLifecycleCallbacks(new a(atomicBoolean));
        application.registerComponentCallbacks(new b(atomicBoolean));
    }

    public final void g() {
        Runnable runnable;
        a aVar = null;
        if (this.f11710b != null) {
            final c cVar = new c(this, aVar);
            this.f11710b.registerDefaultNetworkCallback(cVar);
            runnable = new Runnable() { // from class: k8.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11697a.i(cVar);
                }
            };
        } else {
            final d dVar = new d(this, aVar);
            this.f11709a.registerReceiver(dVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            runnable = new Runnable() { // from class: k8.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f11707a.j(dVar);
                }
            };
        }
        this.f11711c = runnable;
    }

    public final boolean h() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f11709a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final void k(boolean z10) {
        synchronized (this.f11712d) {
            Iterator<l8.n<n.a>> it = this.f11712d.iterator();
            while (it.hasNext()) {
                it.next().accept(z10 ? n.a.REACHABLE : n.a.UNREACHABLE);
            }
        }
    }

    public void l() {
        l8.v.a("AndroidConnectivityMonitor", "App has entered the foreground.", new Object[0]);
        if (h()) {
            k(true);
        }
    }

    @Override // k8.n
    public void shutdown() {
        Runnable runnable = this.f11711c;
        if (runnable != null) {
            runnable.run();
            this.f11711c = null;
        }
    }
}
