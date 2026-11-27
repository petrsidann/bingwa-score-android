package kb;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class y0 implements a1.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, o7.y0> f12301a = new HashMap();

    public static /* synthetic */ void n(a1.f0 f0Var, Task task) {
        if (!task.isSuccessful()) {
            f0Var.b(v.e(task.getException()));
            return;
        }
        o7.y0 y0Var = (o7.y0) task.getResult();
        f12301a.put(y0Var.i(), y0Var);
        f0Var.a(new a1.z.a().b(Long.valueOf(y0Var.g())).c(Long.valueOf(y0Var.b())).f(y0Var.i()).e(y0Var.a()).d(Long.valueOf(y0Var.f())).a());
    }

    @Override // kb.a1.j
    public void c(String str, final a1.f0<a1.z> f0Var) {
        o7.w0.a(w0.f12288b.get(str)).addOnCompleteListener(new OnCompleteListener() { // from class: kb.x0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                y0.n(f0Var, task);
            }
        });
    }

    @Override // kb.a1.j
    public void d(String str, String str2, a1.f0<String> f0Var) {
        o7.v0 v0VarC = o7.w0.c(str, str2);
        String string = UUID.randomUUID().toString();
        w0.f12290d.put(string, v0VarC);
        f0Var.a(string);
    }

    @Override // kb.a1.j
    public void i(String str, String str2, a1.f0<String> f0Var) {
        o7.v0 v0VarB = o7.w0.b(f12301a.get(str), str2);
        String string = UUID.randomUUID().toString();
        w0.f12290d.put(string, v0VarB);
        f0Var.a(string);
    }
}
