package c8;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import l8.p;
import l8.u;
import l8.v;
import o7.c0;

/* JADX INFO: loaded from: classes.dex */
public final class i extends a<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p7.a f3431a = new p7.a() { // from class: c8.f
        @Override // p7.a
        public final void a(u8.b bVar) {
            this.f3427a.j(bVar);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p7.b f3432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u<j> f3433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3435e;

    public i(o8.a<p7.b> aVar) {
        aVar.a(new o8.a.InterfaceC0236a() { // from class: c8.g
            @Override // o8.a.InterfaceC0236a
            public final void a(o8.b bVar) {
                this.f3428a.k(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task i(int i10, Task task) {
        synchronized (this) {
            if (i10 != this.f3434d) {
                v.a("FirebaseAuthCredentialsProvider", "getToken aborted due to token change", new Object[0]);
                return a();
            }
            if (task.isSuccessful()) {
                return Tasks.forResult(((c0) task.getResult()).g());
            }
            return Tasks.forException(task.getException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(u8.b bVar) {
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(o8.b bVar) {
        synchronized (this) {
            this.f3432b = (p7.b) bVar.get();
            l();
            this.f3432b.b(this.f3431a);
        }
    }

    @Override // c8.a
    public synchronized Task<String> a() {
        p7.b bVar = this.f3432b;
        if (bVar == null) {
            return Tasks.forException(new h7.c("auth is not available"));
        }
        Task<c0> taskC = bVar.c(this.f3435e);
        this.f3435e = false;
        final int i10 = this.f3434d;
        return taskC.continueWithTask(p.f12580b, new Continuation() { // from class: c8.h
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f3429a.i(i10, task);
            }
        });
    }

    @Override // c8.a
    public synchronized void b() {
        this.f3435e = true;
    }

    @Override // c8.a
    public synchronized void c() {
        this.f3433c = null;
        p7.b bVar = this.f3432b;
        if (bVar != null) {
            bVar.a(this.f3431a);
        }
    }

    @Override // c8.a
    public synchronized void d(u<j> uVar) {
        this.f3433c = uVar;
        uVar.a(h());
    }

    public final synchronized j h() {
        String strH;
        p7.b bVar = this.f3432b;
        strH = bVar == null ? null : bVar.h();
        return strH != null ? new j(strH) : j.f3436b;
    }

    public final synchronized void l() {
        this.f3434d++;
        u<j> uVar = this.f3433c;
        if (uVar != null) {
            uVar.a(h());
        }
    }
}
