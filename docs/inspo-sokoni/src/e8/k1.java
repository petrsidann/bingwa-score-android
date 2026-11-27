package e8;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class k1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Executor f7211g = d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k8.q f7212a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.google.firebase.firestore.f f7216e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<h8.k, h8.v> f7213b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<i8.f> f7214c = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Set<h8.k> f7217f = new HashSet();

    public k1(k8.q qVar) {
        this.f7212a = qVar;
    }

    public static Executor d() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor g() {
        return f7211g;
    }

    public static /* synthetic */ Task h(Task task) {
        return task.isSuccessful() ? Tasks.forResult(null) : Tasks.forException(task.getException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task i(Task task) throws com.google.firebase.firestore.f {
        if (task.isSuccessful()) {
            Iterator it = ((List) task.getResult()).iterator();
            while (it.hasNext()) {
                m((h8.r) it.next());
            }
        }
        return task;
    }

    public Task<Void> c() {
        f();
        com.google.firebase.firestore.f fVar = this.f7216e;
        if (fVar != null) {
            return Tasks.forException(fVar);
        }
        HashSet<h8.k> hashSet = new HashSet(this.f7213b.keySet());
        Iterator<i8.f> it = this.f7214c.iterator();
        while (it.hasNext()) {
            hashSet.remove(it.next().g());
        }
        for (h8.k kVar : hashSet) {
            this.f7214c.add(new i8.q(kVar, k(kVar)));
        }
        this.f7215d = true;
        return this.f7212a.d(this.f7214c).continueWithTask(l8.p.f12580b, new Continuation() { // from class: e8.j1
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return k1.h(task);
            }
        });
    }

    public void e(h8.k kVar) {
        p(Collections.singletonList(new i8.c(kVar, k(kVar))));
        this.f7217f.add(kVar);
    }

    public final void f() {
        l8.b.d(!this.f7215d, "A transaction object cannot be used after its update callback has been invoked.", new Object[0]);
    }

    public Task<List<h8.r>> j(List<h8.k> list) {
        f();
        return this.f7214c.size() != 0 ? Tasks.forException(new com.google.firebase.firestore.f("Firestore transactions require all reads to be executed before all writes.", com.google.firebase.firestore.f.a.INVALID_ARGUMENT)) : this.f7212a.m(list).continueWithTask(l8.p.f12580b, new Continuation() { // from class: e8.i1
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f7183a.i(task);
            }
        });
    }

    public final i8.m k(h8.k kVar) {
        h8.v vVar = this.f7213b.get(kVar);
        if (this.f7217f.contains(kVar) || vVar == null) {
            return i8.m.f10544c;
        }
        return vVar.equals(h8.v.f9777b) ? i8.m.a(false) : i8.m.f(vVar);
    }

    public final i8.m l(h8.k kVar) throws com.google.firebase.firestore.f {
        h8.v vVar = this.f7213b.get(kVar);
        if (this.f7217f.contains(kVar) || vVar == null) {
            return i8.m.a(true);
        }
        if (vVar.equals(h8.v.f9777b)) {
            throw new com.google.firebase.firestore.f("Can't update a document that doesn't exist.", com.google.firebase.firestore.f.a.INVALID_ARGUMENT);
        }
        return i8.m.f(vVar);
    }

    public final void m(h8.r rVar) throws com.google.firebase.firestore.f {
        h8.v vVarM;
        if (rVar.c()) {
            vVarM = rVar.m();
        } else {
            if (!rVar.j()) {
                throw l8.b.a("Unexpected document type in transaction: " + rVar, new Object[0]);
            }
            vVarM = h8.v.f9777b;
        }
        if (!this.f7213b.containsKey(rVar.getKey())) {
            this.f7213b.put(rVar.getKey(), vVarM);
        } else if (!this.f7213b.get(rVar.getKey()).equals(rVar.m())) {
            throw new com.google.firebase.firestore.f("Document version changed between two reads.", com.google.firebase.firestore.f.a.ABORTED);
        }
    }

    public void n(h8.k kVar, s1 s1Var) {
        p(Collections.singletonList(s1Var.a(kVar, k(kVar))));
        this.f7217f.add(kVar);
    }

    public void o(h8.k kVar, t1 t1Var) {
        try {
            p(Collections.singletonList(t1Var.a(kVar, l(kVar))));
        } catch (com.google.firebase.firestore.f e10) {
            this.f7216e = e10;
        }
        this.f7217f.add(kVar);
    }

    public final void p(List<i8.f> list) {
        f();
        this.f7214c.addAll(list);
    }
}
