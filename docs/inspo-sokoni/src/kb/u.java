package kb;

import android.app.Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class u implements FlutterFirebasePlugin, xa.a, ya.a, a1.c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final HashMap<Integer, o7.h> f12270n = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fb.b f12271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fb.j f12272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f12273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<fb.c, fb.c.d> f12274d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q0 f12275e = new q0();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w0 f12276f = new w0();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final y0 f12277l = new y0();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final z0 f12278m = new z0();

    public static FirebaseAuth K0(a1.b bVar) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(h7.f.p(bVar.b()));
        if (bVar.d() != null) {
            firebaseAuth.z(bVar.d());
        }
        String str = lb.i.f12631c.get(bVar.b());
        if (str != null) {
            firebaseAuth.x(str);
        }
        if (bVar.c() != null) {
            firebaseAuth.x(bVar.c());
        }
        return firebaseAuth;
    }

    public static /* synthetic */ void M0(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void N0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.f((o7.d) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void O0(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void P0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.i((o7.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(TaskCompletionSource taskCompletionSource) {
        try {
            e1();
            f12270n.clear();
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static /* synthetic */ void R0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(((o7.u0) task.getResult()).a());
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void S0(h7.f fVar, TaskCompletionSource taskCompletionSource) {
        try {
            HashMap map = new HashMap();
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(fVar);
            o7.a0 a0VarM = firebaseAuth.m();
            String strP = firebaseAuth.p();
            a1.b0 b0VarJ = a0VarM == null ? null : z2.j(a0VarM);
            if (strP != null) {
                map.put("APP_LANGUAGE_CODE", strP);
            }
            if (b0VarJ != null) {
                map.put("APP_CURRENT_USER", z2.c(b0VarJ));
            }
            taskCompletionSource.setResult(map);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static /* synthetic */ void T0(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void U0(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void V0(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void W0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.i((o7.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void X0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.i((o7.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void Y0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.i((o7.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void Z0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.i((o7.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void a1(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.i((o7.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void b1(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.i((o7.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void c1(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a((String) task.getResult());
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void d1(o7.o0 o0Var) {
        f12270n.put(Integer.valueOf(o0Var.hashCode()), o0Var);
    }

    @Override // kb.a1.c
    public void A(a1.b bVar, String str, String str2, final a1.g0 g0Var) {
        K0(bVar).i(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: kb.i
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.O0(g0Var, task);
            }
        });
    }

    @Override // kb.a1.c
    public void E(a1.b bVar, String str, final a1.f0<a1.o> f0Var) {
        K0(bVar).g(str).addOnCompleteListener(new OnCompleteListener() { // from class: kb.g
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.N0(f0Var, task);
            }
        });
    }

    @Override // kb.a1.c
    public void I(a1.b bVar, String str, final a1.f0<String> f0Var) {
        K0(bVar).J(str).addOnCompleteListener(new OnCompleteListener() { // from class: kb.e
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.c1(f0Var, task);
            }
        });
    }

    @Override // kb.a1.c
    public void J(a1.b bVar, a1.y yVar, final a1.f0<a1.a0> f0Var) {
        FirebaseAuth firebaseAuthK0 = K0(bVar);
        o7.n0.a aVarE = o7.n0.e(yVar.c(), firebaseAuthK0);
        if (yVar.d() != null) {
            aVarE.c(yVar.d());
        }
        if (yVar.b() != null) {
            aVarE.a(yVar.b());
        }
        firebaseAuthK0.G(J0(), aVarE.b()).addOnCompleteListener(new OnCompleteListener() { // from class: kb.p
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.b1(f0Var, task);
            }
        });
    }

    public final Activity J0() {
        return this.f12273c;
    }

    @Override // kb.a1.c
    public void L(a1.b bVar, a1.g0 g0Var) {
        Map<String, o7.h0> map;
        try {
            FirebaseAuth firebaseAuthK0 = K0(bVar);
            if (firebaseAuthK0.m() != null && (map = w0.f12287a.get(bVar.b())) != null) {
                map.remove(firebaseAuthK0.m().h());
            }
            firebaseAuthK0.F();
            g0Var.a();
        } catch (Exception e10) {
            g0Var.b(e10);
        }
    }

    public final void L0(fb.b bVar) {
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_auth", this);
        this.f12272b = new fb.j(bVar, "plugins.flutter.io/firebase_auth");
        a1.c.X(bVar, this);
        a1.e.z(bVar, this.f12275e);
        a1.m.p(bVar, this.f12276f);
        a1.h.t(bVar, this.f12276f);
        a1.j.b(bVar, this.f12277l);
        a1.l.h(bVar, this.f12278m);
        this.f12271a = bVar;
    }

    @Override // kb.a1.c
    public void P(a1.b bVar, String str, a1.q qVar, final a1.g0 g0Var) {
        K0(bVar).w(str, z2.a(qVar)).addOnCompleteListener(new OnCompleteListener() { // from class: kb.o
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.V0(g0Var, task);
            }
        });
    }

    @Override // kb.a1.c
    public void R(a1.b bVar, a1.f0<String> f0Var) {
        try {
            FirebaseAuth firebaseAuthK0 = K0(bVar);
            b bVar2 = new b(firebaseAuthK0);
            String str = "plugins.flutter.io/firebase_auth/auth-state/" + firebaseAuthK0.l().q();
            fb.c cVar = new fb.c(this.f12271a, str);
            cVar.d(bVar2);
            this.f12274d.put(cVar, bVar2);
            f0Var.a(str);
        } catch (Exception e10) {
            f0Var.b(e10);
        }
    }

    @Override // kb.a1.c
    public void W(a1.b bVar, String str, final a1.f0<a1.a0> f0Var) {
        K0(bVar).C(str).addOnCompleteListener(new OnCompleteListener() { // from class: kb.k
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.Y0(f0Var, task);
            }
        });
    }

    @Override // kb.a1.c
    public void a0(a1.b bVar, String str, String str2, final a1.f0<a1.a0> f0Var) {
        K0(bVar).j(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: kb.n
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.P0(f0Var, task);
            }
        });
    }

    @Override // kb.a1.c
    public void c0(a1.b bVar, String str, Long l10, a1.g0 g0Var) {
        try {
            K0(bVar).I(str, l10.intValue());
            g0Var.a();
        } catch (Exception e10) {
            g0Var.b(e10);
        }
    }

    @Override // kb.a1.c
    public void d(a1.b bVar, String str, a1.g0 g0Var) {
        g0Var.a();
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: kb.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f12229a.Q0(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // kb.a1.c
    public void e(a1.b bVar, String str, final a1.g0 g0Var) {
        K0(bVar).f(str).addOnCompleteListener(new OnCompleteListener() { // from class: kb.r
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.M0(g0Var, task);
            }
        });
    }

    public final void e1() {
        for (fb.c cVar : this.f12274d.keySet()) {
            fb.c.d dVar = this.f12274d.get(cVar);
            if (dVar != null) {
                dVar.onCancel(null);
            }
            cVar.d(null);
        }
        this.f12274d.clear();
    }

    @Override // kb.a1.c
    public void f(a1.b bVar, String str, final a1.f0<List<String>> f0Var) {
        K0(bVar).k(str).addOnCompleteListener(new OnCompleteListener() { // from class: kb.j
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.R0(f0Var, task);
            }
        });
    }

    @Override // kb.a1.c
    public void f0(a1.b bVar, String str, a1.f0<String> f0Var) {
        try {
            FirebaseAuth firebaseAuthK0 = K0(bVar);
            if (str == null) {
                firebaseAuthK0.H();
            } else {
                firebaseAuthK0.y(str);
            }
            f0Var.a(firebaseAuthK0.p());
        } catch (Exception e10) {
            f0Var.b(e10);
        }
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(final h7.f fVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: kb.c
            @Override // java.lang.Runnable
            public final void run() {
                u.S0(fVar, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // kb.a1.c
    public void h(a1.b bVar, a1.e0 e0Var, a1.f0<String> f0Var) {
        try {
            String str = "plugins.flutter.io/firebase_auth/phone/" + UUID.randomUUID().toString();
            fb.c cVar = new fb.c(this.f12271a, str);
            o7.r0 r0Var = null;
            o7.l0 l0Var = e0Var.e() != null ? w0.f12288b.get(e0Var.e()) : null;
            String strD = e0Var.d();
            if (strD != null) {
                Iterator<String> it = w0.f12289c.keySet().iterator();
                while (it.hasNext()) {
                    for (o7.j0 j0Var : w0.f12289c.get(it.next()).T()) {
                        if (j0Var.h().equals(strD) && (j0Var instanceof o7.r0)) {
                            r0Var = (o7.r0) j0Var;
                            break;
                        }
                    }
                }
            }
            y2 y2Var = new y2(J0(), bVar, e0Var, l0Var, r0Var, new y2.b() { // from class: kb.m
                @Override // kb.y2.b
                public final void a(o7.o0 o0Var) {
                    u.d1(o0Var);
                }
            });
            cVar.d(y2Var);
            this.f12274d.put(cVar, y2Var);
            f0Var.a(str);
        } catch (Exception e10) {
            f0Var.b(e10);
        }
    }

    @Override // kb.a1.c
    public void i(a1.b bVar, a1.f0<String> f0Var) {
        try {
            FirebaseAuth firebaseAuthK0 = K0(bVar);
            x2 x2Var = new x2(firebaseAuthK0);
            String str = "plugins.flutter.io/firebase_auth/id-token/" + firebaseAuthK0.l().q();
            fb.c cVar = new fb.c(this.f12271a, str);
            cVar.d(x2Var);
            this.f12274d.put(cVar, x2Var);
            f0Var.a(str);
        } catch (Exception e10) {
            f0Var.b(e10);
        }
    }

    @Override // kb.a1.c
    public void i0(a1.b bVar, a1.t tVar, a1.g0 g0Var) {
        try {
            FirebaseAuth firebaseAuthK0 = K0(bVar);
            firebaseAuthK0.o().b(tVar.b().booleanValue());
            if (tVar.c() != null) {
                firebaseAuthK0.o().a(tVar.c().booleanValue());
            }
            if (tVar.d() != null && tVar.e() != null) {
                firebaseAuthK0.o().c(tVar.d(), tVar.e());
            }
            g0Var.a();
        } catch (Exception e10) {
            g0Var.b(e10);
        }
    }

    @Override // kb.a1.c
    public void k(a1.b bVar, String str, String str2, final a1.f0<a1.a0> f0Var) {
        K0(bVar).D(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: kb.q
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.Z0(f0Var, task);
            }
        });
    }

    @Override // kb.a1.c
    public void n(a1.b bVar, final a1.f0<a1.a0> f0Var) {
        K0(bVar).A().addOnCompleteListener(new OnCompleteListener() { // from class: kb.h
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.W0(f0Var, task);
            }
        });
    }

    @Override // kb.a1.c
    public void o0(a1.b bVar, String str, String str2, final a1.f0<a1.a0> f0Var) {
        K0(bVar).E(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: kb.f
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.a1(f0Var, task);
            }
        });
    }

    @Override // ya.a
    public void onAttachedToActivity(ya.c cVar) {
        Activity activityG = cVar.g();
        this.f12273c = activityG;
        this.f12275e.I0(activityG);
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        L0(bVar.b());
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
        this.f12273c = null;
        this.f12275e.I0(null);
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        this.f12273c = null;
        this.f12275e.I0(null);
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        this.f12272b.e(null);
        a1.c.X(this.f12271a, null);
        a1.e.z(this.f12271a, null);
        a1.m.p(this.f12271a, null);
        a1.h.t(this.f12271a, null);
        a1.j.b(this.f12271a, null);
        a1.l.h(this.f12271a, null);
        this.f12272b = null;
        this.f12271a = null;
        e1();
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(ya.c cVar) {
        Activity activityG = cVar.g();
        this.f12273c = activityG;
        this.f12275e.I0(activityG);
    }

    @Override // kb.a1.c
    public void v(a1.b bVar, Map<String, Object> map, final a1.f0<a1.a0> f0Var) {
        FirebaseAuth firebaseAuthK0 = K0(bVar);
        o7.h hVarB = z2.b(map);
        if (hVarB == null) {
            throw v.b();
        }
        firebaseAuthK0.B(hVarB).addOnCompleteListener(new OnCompleteListener() { // from class: kb.d
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.X0(f0Var, task);
            }
        });
    }

    @Override // kb.a1.c
    public void x(a1.b bVar, String str, a1.q qVar, final a1.g0 g0Var) {
        Task<Void> taskV;
        OnCompleteListener<Void> onCompleteListener;
        FirebaseAuth firebaseAuthK0 = K0(bVar);
        if (qVar == null) {
            taskV = firebaseAuthK0.u(str);
            onCompleteListener = new OnCompleteListener() { // from class: kb.s
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    u.T0(g0Var, task);
                }
            };
        } else {
            taskV = firebaseAuthK0.v(str, z2.a(qVar));
            onCompleteListener = new OnCompleteListener() { // from class: kb.t
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    u.U0(g0Var, task);
                }
            };
        }
        taskV.addOnCompleteListener(onCompleteListener);
    }
}
