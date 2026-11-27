package lb;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class i implements xa.a, o.b, o.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, String> f12631c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f12632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12633b = false;

    public static /* synthetic */ void F(String str, TaskCompletionSource taskCompletionSource) {
        try {
            try {
                h7.f.p(str).j();
            } catch (IllegalStateException unused) {
            }
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(h7.f fVar, TaskCompletionSource taskCompletionSource) {
        try {
            o.f.a aVar = new o.f.a();
            aVar.c(fVar.q());
            aVar.d(E(fVar.r()));
            aVar.b(Boolean.valueOf(fVar.x()));
            aVar.e((Map) Tasks.await(FlutterFirebasePluginRegistry.getPluginConstantsForFirebaseApp(fVar)));
            taskCompletionSource.setResult(aVar.a());
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(o.e eVar, String str, TaskCompletionSource taskCompletionSource) {
        try {
            h7.n nVarA = new h7.n.b().b(eVar.b()).c(eVar.c()).d(eVar.e()).f(eVar.f()).g(eVar.g()).h(eVar.h()).e(eVar.i()).a();
            try {
                Looper.prepare();
            } catch (Exception unused) {
            }
            if (eVar.d() != null) {
                f12631c.put(str, eVar.d());
            }
            taskCompletionSource.setResult((o.f) Tasks.await(D(h7.f.w(this.f12632a, nVarA, str))));
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(TaskCompletionSource taskCompletionSource) {
        try {
            if (this.f12633b) {
                Tasks.await(FlutterFirebasePluginRegistry.didReinitializeFirebaseCore());
            } else {
                this.f12633b = true;
            }
            List<h7.f> listN = h7.f.n(this.f12632a);
            ArrayList arrayList = new ArrayList(listN.size());
            Iterator<h7.f> it = listN.iterator();
            while (it.hasNext()) {
                arrayList.add((o.f) Tasks.await(D(it.next())));
            }
            taskCompletionSource.setResult(arrayList);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static /* synthetic */ void J(o.g gVar, Task task) {
        if (task.isSuccessful()) {
            gVar.a(task.getResult());
        } else {
            gVar.b(task.getException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(TaskCompletionSource taskCompletionSource) {
        try {
            h7.n nVarA = h7.n.a(this.f12632a);
            if (nVarA == null) {
                taskCompletionSource.setException(new Exception("Failed to load FirebaseOptions from resource. Check that you have defined values.xml correctly."));
            } else {
                taskCompletionSource.setResult(E(nVarA));
            }
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static /* synthetic */ void L(String str, Boolean bool, TaskCompletionSource taskCompletionSource) {
        try {
            h7.f.p(str).F(bool);
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static /* synthetic */ void M(String str, Boolean bool, TaskCompletionSource taskCompletionSource) {
        try {
            h7.f.p(str).E(bool.booleanValue());
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public final Task<o.f> D(final h7.f fVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: lb.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f12628a.G(fVar, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final o.e E(h7.n nVar) {
        o.e.a aVar = new o.e.a();
        aVar.b(nVar.b());
        aVar.c(nVar.c());
        if (nVar.f() != null) {
            aVar.e(nVar.f());
        }
        if (nVar.g() != null) {
            aVar.f(nVar.g());
        }
        aVar.d(nVar.d());
        aVar.g(nVar.h());
        aVar.h(nVar.e());
        return aVar.a();
    }

    public final <T> void N(TaskCompletionSource<T> taskCompletionSource, final o.g<T> gVar) {
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: lb.g
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                i.J(gVar, task);
            }
        });
    }

    @Override // lb.o.b
    public void b(o.g<List<o.f>> gVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: lb.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f12615a.I(taskCompletionSource);
            }
        });
        N(taskCompletionSource, gVar);
    }

    @Override // lb.o.b
    public void e(final String str, final o.e eVar, o.g<o.f> gVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: lb.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f12617a.H(eVar, str, taskCompletionSource);
            }
        });
        N(taskCompletionSource, gVar);
    }

    @Override // lb.o.b
    public void g(o.g<o.e> gVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: lb.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f12613a.K(taskCompletionSource);
            }
        });
        N(taskCompletionSource, gVar);
    }

    @Override // lb.o.a
    public void h(final String str, final Boolean bool, o.g<Void> gVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: lb.f
            @Override // java.lang.Runnable
            public final void run() {
                i.M(str, bool, taskCompletionSource);
            }
        });
        N(taskCompletionSource, gVar);
    }

    @Override // lb.o.a
    public void i(final String str, o.g<Void> gVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: lb.a
            @Override // java.lang.Runnable
            public final void run() {
                i.F(str, taskCompletionSource);
            }
        });
        N(taskCompletionSource, gVar);
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        o.b.c(bVar.b(), this);
        o.a.l(bVar.b(), this);
        this.f12632a = bVar.a();
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        this.f12632a = null;
        o.b.c(bVar.b(), null);
        o.a.l(bVar.b(), null);
    }

    @Override // lb.o.a
    public void q(final String str, final Boolean bool, o.g<Void> gVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: lb.e
            @Override // java.lang.Runnable
            public final void run() {
                i.L(str, bool, taskCompletionSource);
            }
        });
        N(taskCompletionSource, gVar);
    }
}
