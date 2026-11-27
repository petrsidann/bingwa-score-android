package kb;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class q0 implements a1.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f12255a;

    public static /* synthetic */ void A0(a1.f0 f0Var, o7.a0 a0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.j(a0Var));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void B0(final o7.a0 a0Var, final a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            a0Var.b0().addOnCompleteListener(new OnCompleteListener() { // from class: kb.e0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    q0.A0(f0Var, a0Var, task2);
                }
            });
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void C0(a1.f0 f0Var, o7.a0 a0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.j(a0Var));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void D0(final o7.a0 a0Var, final a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            a0Var.b0().addOnCompleteListener(new OnCompleteListener() { // from class: kb.f0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    q0.C0(f0Var, a0Var, task2);
                }
            });
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void E0(a1.f0 f0Var, o7.a0 a0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.j(a0Var));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void F0(final o7.a0 a0Var, final a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            a0Var.b0().addOnCompleteListener(new OnCompleteListener() { // from class: kb.g0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    q0.E0(f0Var, a0Var, task2);
                }
            });
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void G0(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void H0(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    public static o7.a0 n0(a1.b bVar) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(h7.f.p(bVar.b()));
        if (bVar.d() != null) {
            firebaseAuth.z(bVar.d());
        }
        return firebaseAuth.m();
    }

    public static /* synthetic */ void o0(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void p0(a1.b bVar, a1.f0 f0Var, Boolean bool) {
        o7.a0 a0VarN0 = n0(bVar);
        if (a0VarN0 == null) {
            f0Var.b(v.d());
            return;
        }
        try {
            f0Var.a(z2.l((o7.c0) Tasks.await(a0VarN0.T(bool.booleanValue()))));
        } catch (Exception e10) {
            f0Var.b(v.e(e10));
        }
    }

    public static /* synthetic */ void q0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.i((o7.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void r0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.i((o7.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void s0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.i((o7.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void t0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.i((o7.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void u0(a1.f0 f0Var, o7.a0 a0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.j(a0Var));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void v0(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void w0(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void x0(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.i((o7.i) task.getResult()));
        } else {
            Exception exception = task.getException();
            f0Var.b(exception.getMessage().contains("User was not linked to an account with the given provider.") ? v.c() : v.e(exception));
        }
    }

    public static /* synthetic */ void y0(a1.f0 f0Var, o7.a0 a0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.j(a0Var));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void z0(final o7.a0 a0Var, final a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            a0Var.b0().addOnCompleteListener(new OnCompleteListener() { // from class: kb.d0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    q0.y0(f0Var, a0Var, task2);
                }
            });
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    @Override // kb.a1.e
    public void A(a1.b bVar, String str, final a1.f0<a1.b0> f0Var) {
        final o7.a0 a0VarN0 = n0(bVar);
        if (a0VarN0 == null) {
            f0Var.b(v.d());
        } else {
            a0VarN0.i0(str).addOnCompleteListener(new OnCompleteListener() { // from class: kb.n0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.B0(a0VarN0, f0Var, task);
                }
            });
        }
    }

    @Override // kb.a1.e
    public void C(final a1.b bVar, final Boolean bool, final a1.f0<a1.u> f0Var) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: kb.o0
            @Override // java.lang.Runnable
            public final void run() {
                q0.p0(bVar, f0Var, bool);
            }
        });
    }

    @Override // kb.a1.e
    public void G(a1.b bVar, Map<String, Object> map, final a1.f0<a1.a0> f0Var) {
        o7.a0 a0VarN0 = n0(bVar);
        o7.h hVarB = z2.b(map);
        if (a0VarN0 == null) {
            f0Var.b(v.d());
        } else if (hVarB == null) {
            f0Var.b(v.b());
        } else {
            a0VarN0.a0(hVarB).addOnCompleteListener(new OnCompleteListener() { // from class: kb.j0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.s0(f0Var, task);
                }
            });
        }
    }

    @Override // kb.a1.e
    public void H(a1.b bVar, Map<String, Object> map, final a1.f0<a1.a0> f0Var) {
        o7.a0 a0VarN0 = n0(bVar);
        o7.h hVarB = z2.b(map);
        if (a0VarN0 == null) {
            f0Var.b(v.d());
        } else if (hVarB == null) {
            f0Var.b(v.b());
        } else {
            a0VarN0.Z(hVarB).addOnCompleteListener(new OnCompleteListener() { // from class: kb.x
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.q0(f0Var, task);
                }
            });
        }
    }

    @Override // kb.a1.e
    public void I(a1.b bVar, final a1.g0 g0Var) {
        o7.a0 a0VarN0 = n0(bVar);
        if (a0VarN0 == null) {
            g0Var.b(v.d());
        } else {
            a0VarN0.S().addOnCompleteListener(new OnCompleteListener() { // from class: kb.y
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.o0(g0Var, task);
                }
            });
        }
    }

    public void I0(Activity activity) {
        this.f12255a = activity;
    }

    @Override // kb.a1.e
    public void K(a1.b bVar, a1.d0 d0Var, final a1.f0<a1.b0> f0Var) {
        final o7.a0 a0VarN0 = n0(bVar);
        if (a0VarN0 == null) {
            f0Var.b(v.d());
            return;
        }
        o7.c1.a aVar = new o7.c1.a();
        if (d0Var.c().booleanValue()) {
            aVar.b(d0Var.b());
        }
        if (d0Var.e().booleanValue()) {
            aVar.c(d0Var.d() != null ? Uri.parse(d0Var.d()) : null);
        }
        a0VarN0.k0(aVar.a()).addOnCompleteListener(new OnCompleteListener() { // from class: kb.l0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                q0.F0(a0VarN0, f0Var, task);
            }
        });
    }

    @Override // kb.a1.e
    public void N(a1.b bVar, Map<String, Object> map, final a1.f0<a1.b0> f0Var) {
        final o7.a0 a0VarN0 = n0(bVar);
        if (a0VarN0 == null) {
            f0Var.b(v.d());
            return;
        }
        o7.o0 o0Var = (o7.o0) z2.b(map);
        if (o0Var == null) {
            f0Var.b(v.b());
        } else {
            a0VarN0.j0(o0Var).addOnCompleteListener(new OnCompleteListener() { // from class: kb.z
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.D0(a0VarN0, f0Var, task);
                }
            });
        }
    }

    @Override // kb.a1.e
    public void Q(a1.b bVar, a1.y yVar, final a1.f0<a1.a0> f0Var) {
        o7.a0 a0VarN0 = n0(bVar);
        o7.n0.a aVarD = o7.n0.d(yVar.c());
        if (yVar.d() != null) {
            aVarD.c(yVar.d());
        }
        if (yVar.b() != null) {
            aVarD.a(yVar.b());
        }
        a0VarN0.e0(this.f12255a, aVarD.b()).addOnCompleteListener(new OnCompleteListener() { // from class: kb.m0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                q0.r0(f0Var, task);
            }
        });
    }

    @Override // kb.a1.e
    public void S(a1.b bVar, a1.y yVar, final a1.f0<a1.a0> f0Var) {
        o7.a0 a0VarN0 = n0(bVar);
        o7.n0.a aVarD = o7.n0.d(yVar.c());
        if (yVar.d() != null) {
            aVarD.c(yVar.d());
        }
        if (yVar.b() != null) {
            aVarD.a(yVar.b());
        }
        a0VarN0.f0(this.f12255a, aVarD.b()).addOnCompleteListener(new OnCompleteListener() { // from class: kb.k0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                q0.t0(f0Var, task);
            }
        });
    }

    @Override // kb.a1.e
    public void e(a1.b bVar, String str, a1.q qVar, final a1.g0 g0Var) {
        o7.a0 a0VarN0 = n0(bVar);
        if (a0VarN0 == null) {
            g0Var.b(v.d());
        } else if (qVar == null) {
            a0VarN0.l0(str).addOnCompleteListener(new OnCompleteListener() { // from class: kb.b0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.G0(g0Var, task);
                }
            });
        } else {
            a0VarN0.m0(str, z2.a(qVar)).addOnCompleteListener(new OnCompleteListener() { // from class: kb.c0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.H0(g0Var, task);
                }
            });
        }
    }

    @Override // kb.a1.e
    public void f(a1.b bVar, final a1.f0<a1.b0> f0Var) {
        final o7.a0 a0VarN0 = n0(bVar);
        if (a0VarN0 == null) {
            f0Var.b(v.d());
        } else {
            a0VarN0.b0().addOnCompleteListener(new OnCompleteListener() { // from class: kb.w
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.u0(f0Var, a0VarN0, task);
                }
            });
        }
    }

    @Override // kb.a1.e
    public void k(a1.b bVar, String str, final a1.f0<a1.b0> f0Var) {
        final o7.a0 a0VarN0 = n0(bVar);
        if (a0VarN0 == null) {
            f0Var.b(v.d());
        } else {
            a0VarN0.h0(str).addOnCompleteListener(new OnCompleteListener() { // from class: kb.p0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.z0(a0VarN0, f0Var, task);
                }
            });
        }
    }

    @Override // kb.a1.e
    public void r(a1.b bVar, a1.q qVar, final a1.g0 g0Var) {
        o7.a0 a0VarN0 = n0(bVar);
        if (a0VarN0 == null) {
            g0Var.b(v.d());
        } else if (qVar == null) {
            a0VarN0.c0().addOnCompleteListener(new OnCompleteListener() { // from class: kb.h0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.v0(g0Var, task);
                }
            });
        } else {
            a0VarN0.d0(z2.a(qVar)).addOnCompleteListener(new OnCompleteListener() { // from class: kb.i0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.w0(g0Var, task);
                }
            });
        }
    }

    @Override // kb.a1.e
    public void t(a1.b bVar, String str, final a1.f0<a1.a0> f0Var) {
        o7.a0 a0VarN0 = n0(bVar);
        if (a0VarN0 == null) {
            f0Var.b(v.d());
        } else {
            a0VarN0.g0(str).addOnCompleteListener(new OnCompleteListener() { // from class: kb.a0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q0.x0(f0Var, task);
                }
            });
        }
    }
}
