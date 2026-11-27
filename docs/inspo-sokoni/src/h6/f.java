package h6;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Map f9652o = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g0 f9654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9655c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Intent f9660h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n0 f9661i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ServiceConnection f9665m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IInterface f9666n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f9656d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f9657e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f9658f = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final IBinder.DeathRecipient f9663k = new IBinder.DeathRecipient() { // from class: h6.i0
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            f.k(this.f9669a);
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f9664l = new AtomicInteger(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final WeakReference f9662j = new WeakReference(null);

    public f(Context context, g0 g0Var, String str, Intent intent, n0 n0Var, m0 m0Var) {
        this.f9653a = context;
        this.f9654b = g0Var;
        this.f9655c = str;
        this.f9660h = intent;
        this.f9661i = n0Var;
    }

    public static /* synthetic */ void k(f fVar) {
        fVar.f9654b.d("reportBinderDeath", new Object[0]);
        m0 m0Var = (m0) fVar.f9662j.get();
        if (m0Var != null) {
            fVar.f9654b.d("calling onBinderDied", new Object[0]);
            m0Var.a();
        } else {
            fVar.f9654b.d("%s : Binder has died.", fVar.f9655c);
            Iterator it = fVar.f9656d.iterator();
            while (it.hasNext()) {
                ((h0) it.next()).a(fVar.w());
            }
            fVar.f9656d.clear();
        }
        synchronized (fVar.f9658f) {
            fVar.x();
        }
    }

    public static /* bridge */ /* synthetic */ void o(final f fVar, final TaskCompletionSource taskCompletionSource) {
        fVar.f9657e.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: h6.j0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f9671a.u(taskCompletionSource, task);
            }
        });
    }

    public static /* bridge */ /* synthetic */ void q(f fVar, h0 h0Var) {
        if (fVar.f9666n != null || fVar.f9659g) {
            if (!fVar.f9659g) {
                h0Var.run();
                return;
            } else {
                fVar.f9654b.d("Waiting to bind to the service.", new Object[0]);
                fVar.f9656d.add(h0Var);
                return;
            }
        }
        fVar.f9654b.d("Initiate binding to the service.", new Object[0]);
        fVar.f9656d.add(h0Var);
        e eVar = new e(fVar, null);
        fVar.f9665m = eVar;
        fVar.f9659g = true;
        if (fVar.f9653a.bindService(fVar.f9660h, eVar, 1)) {
            return;
        }
        fVar.f9654b.d("Failed to bind to the service.", new Object[0]);
        fVar.f9659g = false;
        Iterator it = fVar.f9656d.iterator();
        while (it.hasNext()) {
            ((h0) it.next()).a(new g());
        }
        fVar.f9656d.clear();
    }

    public static /* bridge */ /* synthetic */ void r(f fVar) {
        fVar.f9654b.d("linkToDeath", new Object[0]);
        try {
            fVar.f9666n.asBinder().linkToDeath(fVar.f9663k, 0);
        } catch (RemoteException e10) {
            fVar.f9654b.c(e10, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void s(f fVar) {
        fVar.f9654b.d("unlinkToDeath", new Object[0]);
        fVar.f9666n.asBinder().unlinkToDeath(fVar.f9663k, 0);
    }

    public final Handler c() {
        Handler handler;
        Map map = f9652o;
        synchronized (map) {
            if (!map.containsKey(this.f9655c)) {
                HandlerThread handlerThread = new HandlerThread(this.f9655c, 10);
                handlerThread.start();
                map.put(this.f9655c, new Handler(handlerThread.getLooper()));
            }
            handler = (Handler) map.get(this.f9655c);
        }
        return handler;
    }

    public final IInterface e() {
        return this.f9666n;
    }

    public final void t(h0 h0Var, TaskCompletionSource taskCompletionSource) {
        c().post(new k0(this, h0Var.c(), taskCompletionSource, h0Var));
    }

    public final /* synthetic */ void u(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.f9658f) {
            this.f9657e.remove(taskCompletionSource);
        }
    }

    public final void v(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f9658f) {
            this.f9657e.remove(taskCompletionSource);
        }
        c().post(new l0(this));
    }

    public final RemoteException w() {
        return new RemoteException(String.valueOf(this.f9655c).concat(" : Binder has died."));
    }

    public final void x() {
        Iterator it = this.f9657e.iterator();
        while (it.hasNext()) {
            ((TaskCompletionSource) it.next()).trySetException(w());
        }
        this.f9657e.clear();
    }
}
