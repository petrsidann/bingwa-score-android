package b8;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FirebaseFirestore f2881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<i8.f> f2882b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2883c = false;

    public b2(FirebaseFirestore firebaseFirestore) {
        this.f2881a = (FirebaseFirestore) l8.x.b(firebaseFirestore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task d(e8.q0 q0Var) {
        return q0Var.s0(this.f2882b);
    }

    public Task<Void> b() {
        i();
        this.f2883c = true;
        return !this.f2882b.isEmpty() ? (Task) this.f2881a.s(new l8.t() { // from class: b8.a2
            @Override // l8.t
            public final Object apply(Object obj) {
                return this.f2875a.d((e8.q0) obj);
            }
        }) : Tasks.forResult(null);
    }

    public b2 c(com.google.firebase.firestore.c cVar) {
        this.f2881a.d0(cVar);
        i();
        this.f2882b.add(new i8.c(cVar.q(), i8.m.f10544c));
        return this;
    }

    public b2 e(com.google.firebase.firestore.c cVar, Object obj) {
        return f(cVar, obj, r1.f2952c);
    }

    public b2 f(com.google.firebase.firestore.c cVar, Object obj, r1 r1Var) {
        this.f2881a.d0(cVar);
        l8.x.c(obj, "Provided data must not be null.");
        l8.x.c(r1Var, "Provided options must not be null.");
        i();
        this.f2882b.add((r1Var.b() ? this.f2881a.F().g(obj, r1Var.a()) : this.f2881a.F().l(obj)).a(cVar.q(), i8.m.f10544c));
        return this;
    }

    public final b2 g(com.google.firebase.firestore.c cVar, e8.t1 t1Var) {
        this.f2881a.d0(cVar);
        i();
        this.f2882b.add(t1Var.a(cVar.q(), i8.m.a(true)));
        return this;
    }

    public b2 h(com.google.firebase.firestore.c cVar, Map<String, Object> map) {
        return g(cVar, this.f2881a.F().o(map));
    }

    public final void i() {
        if (this.f2883c) {
            throw new IllegalStateException("A write batch can no longer be used after commit() has been called.");
        }
    }
}
