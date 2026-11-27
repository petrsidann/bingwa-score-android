package kb;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class w0 implements a1.m, a1.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Map<String, o7.h0>> f12287a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, o7.l0> f12288b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, o7.k0> f12289c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, o7.i0> f12290d = new HashMap();

    public static /* synthetic */ void D(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void E(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void F(a1.f0 f0Var, Task task) {
        if (!task.isSuccessful()) {
            f0Var.b(v.e(task.getException()));
            return;
        }
        o7.l0 l0Var = (o7.l0) task.getResult();
        String string = UUID.randomUUID().toString();
        f12288b.put(string, l0Var);
        f0Var.a(new a1.w.a().b(string).a());
    }

    public static /* synthetic */ void G(a1.f0 f0Var, Task task) {
        if (task.isSuccessful()) {
            f0Var.a(z2.i((o7.i) task.getResult()));
        } else {
            f0Var.b(v.e(task.getException()));
        }
    }

    public static /* synthetic */ void H(a1.g0 g0Var, Task task) {
        if (task.isSuccessful()) {
            g0Var.a();
        } else {
            g0Var.b(v.e(task.getException()));
        }
    }

    public o7.h0 C(a1.b bVar) throws v8.a {
        o7.a0 a0VarN0 = q0.n0(bVar);
        if (a0VarN0 == null) {
            throw new v8.a("No user is signed in");
        }
        Map<String, Map<String, o7.h0>> map = f12287a;
        if (map.get(bVar.b()) == null) {
            map.put(bVar.b(), new HashMap());
        }
        Map<String, o7.h0> map2 = map.get(bVar.b());
        if (map2.get(a0VarN0.h()) == null) {
            map2.put(a0VarN0.h(), a0VarN0.V());
        }
        return map2.get(a0VarN0.h());
    }

    @Override // kb.a1.m
    public void f(a1.b bVar, final a1.f0<a1.w> f0Var) {
        try {
            C(bVar).c().addOnCompleteListener(new OnCompleteListener() { // from class: kb.u0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    w0.F(f0Var, task);
                }
            });
        } catch (v8.a e10) {
            f0Var.b(e10);
        }
    }

    @Override // kb.a1.m
    public void g(a1.b bVar, String str, String str2, final a1.g0 g0Var) {
        try {
            C(bVar).a(f12290d.get(str), str2).addOnCompleteListener(new OnCompleteListener() { // from class: kb.t0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    w0.E(g0Var, task);
                }
            });
        } catch (v8.a e10) {
            g0Var.b(e10);
        }
    }

    @Override // kb.a1.m
    public void l(a1.b bVar, a1.x xVar, String str, final a1.g0 g0Var) {
        try {
            C(bVar).a(o7.q0.a(com.google.firebase.auth.b.a(xVar.c(), xVar.b())), str).addOnCompleteListener(new OnCompleteListener() { // from class: kb.r0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    w0.D(g0Var, task);
                }
            });
        } catch (v8.a e10) {
            g0Var.b(e10);
        }
    }

    @Override // kb.a1.m
    public void m(a1.b bVar, a1.f0<List<a1.v>> f0Var) {
        try {
            f0Var.a(z2.e(C(bVar).b()));
        } catch (v8.a e10) {
            f0Var.b(e10);
        }
    }

    @Override // kb.a1.h
    public void n(String str, a1.x xVar, String str2, final a1.f0<a1.a0> f0Var) {
        o7.k0 k0Var = f12289c.get(str);
        if (k0Var == null) {
            f0Var.b(v.e(new Exception("Resolver not found")));
        } else {
            k0Var.V(xVar != null ? o7.q0.a(com.google.firebase.auth.b.a(xVar.c(), xVar.b())) : f12290d.get(str2)).addOnCompleteListener(new OnCompleteListener() { // from class: kb.v0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    w0.G(f0Var, task);
                }
            });
        }
    }

    @Override // kb.a1.m
    public void q(a1.b bVar, String str, final a1.g0 g0Var) {
        try {
            C(bVar).d(str).addOnCompleteListener(new OnCompleteListener() { // from class: kb.s0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    w0.H(g0Var, task);
                }
            });
        } catch (v8.a e10) {
            g0Var.b(v.e(e10));
        }
    }
}
