package k8;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;
import vb.l1;

/* JADX INFO: loaded from: classes.dex */
public final class u extends vb.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final vb.a1.g<String> f11818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final vb.a1.g<String> f11819d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c8.a<c8.j> f11820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c8.a<String> f11821b;

    static {
        vb.a1.d<String> dVar = vb.a1.f17241e;
        f11818c = vb.a1.g.e("Authorization", dVar);
        f11819d = vb.a1.g.e("x-firebase-appcheck", dVar);
    }

    public u(c8.a<c8.j> aVar, c8.a<String> aVar2) {
        this.f11820a = aVar;
        this.f11821b = aVar2;
    }

    public static /* synthetic */ void c(Task task, vb.b.a aVar, Task task2, Task task3) {
        Exception exception;
        vb.a1 a1Var = new vb.a1();
        if (task.isSuccessful()) {
            String str = (String) task.getResult();
            l8.v.a("FirestoreCallCredentials", "Successfully fetched auth token.", new Object[0]);
            if (str != null) {
                a1Var.p(f11818c, "Bearer " + str);
            }
        } else {
            exception = task.getException();
            if (!(exception instanceof h7.c)) {
                if (exception instanceof v8.a) {
                    l8.v.a("FirestoreCallCredentials", "No user signed in, not using authentication.", new Object[0]);
                } else {
                    l8.v.e("FirestoreCallCredentials", "Failed to get auth token: %s.", exception);
                }
                aVar.b(l1.f17413m.p(exception));
                return;
            }
            l8.v.a("FirestoreCallCredentials", "Firebase Auth API not available, not using authentication.", new Object[0]);
        }
        if (task2.isSuccessful()) {
            String str2 = (String) task2.getResult();
            if (str2 != null && !str2.isEmpty()) {
                l8.v.a("FirestoreCallCredentials", "Successfully fetched AppCheck token.", new Object[0]);
                a1Var.p(f11819d, str2);
            }
        } else {
            exception = task2.getException();
            if (!(exception instanceof h7.c)) {
                l8.v.e("FirestoreCallCredentials", "Failed to get AppCheck token: %s.", exception);
                aVar.b(l1.f17413m.p(exception));
                return;
            }
            l8.v.a("FirestoreCallCredentials", "Firebase AppCheck API not available.", new Object[0]);
        }
        aVar.a(a1Var);
    }

    @Override // vb.b
    public void a(vb.b.AbstractC0303b abstractC0303b, Executor executor, final vb.b.a aVar) {
        final Task<String> taskA = this.f11820a.a();
        final Task<String> taskA2 = this.f11821b.a();
        Tasks.whenAll((Task<?>[]) new Task[]{taskA, taskA2}).addOnCompleteListener(l8.p.f12580b, new OnCompleteListener() { // from class: k8.t
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                u.c(taskA, aVar, taskA2, task);
            }
        });
    }
}
