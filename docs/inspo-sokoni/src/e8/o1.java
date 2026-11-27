package e8;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public class o1<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l8.g f7268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k8.s0 f7269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l8.t<k1, Task<TResult>> f7270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l8.r f7272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TaskCompletionSource<TResult> f7273f = new TaskCompletionSource<>();

    public o1(l8.g gVar, k8.s0 s0Var, b8.x1 x1Var, l8.t<k1, Task<TResult>> tVar) {
        this.f7268a = gVar;
        this.f7269b = s0Var;
        this.f7270c = tVar;
        this.f7271d = x1Var.a();
        this.f7272e = new l8.r(gVar, l8.g.d.RETRY_TRANSACTION);
    }

    public static boolean e(Exception exc) {
        if (!(exc instanceof com.google.firebase.firestore.f)) {
            return false;
        }
        com.google.firebase.firestore.f fVar = (com.google.firebase.firestore.f) exc;
        com.google.firebase.firestore.f.a aVarA = fVar.a();
        return aVarA == com.google.firebase.firestore.f.a.ABORTED || aVarA == com.google.firebase.firestore.f.a.ALREADY_EXISTS || aVarA == com.google.firebase.firestore.f.a.FAILED_PRECONDITION || !k8.q.h(fVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Task task, Task task2) {
        if (task2.isSuccessful()) {
            this.f7273f.setResult((TResult) task.getResult());
        } else {
            d(task2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(k1 k1Var, final Task task) {
        if (task.isSuccessful()) {
            k1Var.c().addOnCompleteListener(this.f7268a.o(), new OnCompleteListener() { // from class: e8.n1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    this.f7239a.f(task, task2);
                }
            });
        } else {
            d(task);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        final k1 k1VarP = this.f7269b.p();
        this.f7270c.apply(k1VarP).addOnCompleteListener(this.f7268a.o(), new OnCompleteListener() { // from class: e8.m1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f7233a.g(k1VarP, task);
            }
        });
    }

    public final void d(Task task) {
        if (this.f7271d <= 0 || !e(task.getException())) {
            this.f7273f.setException(task.getException());
        } else {
            j();
        }
    }

    public Task<TResult> i() {
        j();
        return this.f7273f.getTask();
    }

    public final void j() {
        this.f7271d--;
        this.f7272e.b(new Runnable() { // from class: e8.l1
            @Override // java.lang.Runnable
            public final void run() {
                this.f7224a.h();
            }
        });
    }
}
