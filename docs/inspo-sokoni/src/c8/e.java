package c8;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import l8.p;
import l8.u;

/* JADX INFO: loaded from: classes.dex */
public final class e extends a<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u<String> f3423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n7.b f3424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n7.a f3426d = new n7.a() { // from class: c8.b
    };

    public e(o8.a<n7.b> aVar) {
        aVar.a(new o8.a.InterfaceC0236a() { // from class: c8.c
            @Override // o8.a.InterfaceC0236a
            public final void a(o8.b bVar) {
                this.f3422a.h(bVar);
            }
        });
    }

    public static /* synthetic */ Task g(Task task) {
        return task.isSuccessful() ? Tasks.forResult(((m7.a) task.getResult()).b()) : Tasks.forException(task.getException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(o8.b bVar) {
        synchronized (this) {
            n7.b bVar2 = (n7.b) bVar.get();
            this.f3424b = bVar2;
            if (bVar2 != null) {
                bVar2.c(this.f3426d);
            }
        }
    }

    @Override // c8.a
    public synchronized Task<String> a() {
        n7.b bVar = this.f3424b;
        if (bVar == null) {
            return Tasks.forException(new h7.c("AppCheck is not available"));
        }
        Task<m7.a> taskA = bVar.a(this.f3425c);
        this.f3425c = false;
        return taskA.continueWithTask(p.f12580b, new Continuation() { // from class: c8.d
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return e.g(task);
            }
        });
    }

    @Override // c8.a
    public synchronized void b() {
        this.f3425c = true;
    }

    @Override // c8.a
    public synchronized void c() {
        this.f3423a = null;
        n7.b bVar = this.f3424b;
        if (bVar != null) {
            bVar.b(this.f3426d);
        }
    }

    @Override // c8.a
    public synchronized void d(u<String> uVar) {
        this.f3423a = uVar;
    }
}
