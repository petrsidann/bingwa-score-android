package b8;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.firebase.firestore.i f2884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.google.firebase.firestore.a> f2885b;

    public c(com.google.firebase.firestore.i iVar, List<com.google.firebase.firestore.a> list) {
        this.f2884a = iVar;
        this.f2885b = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task e(e8.q0 q0Var) {
        return q0Var.l0(this.f2884a.f5537a, this.f2885b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object f(TaskCompletionSource taskCompletionSource, Task task) {
        if (task.isSuccessful()) {
            taskCompletionSource.setResult(new com.google.firebase.firestore.b(this, (Map) task.getResult()));
            return null;
        }
        taskCompletionSource.setException(task.getException());
        return null;
    }

    public Task<com.google.firebase.firestore.b> c(d dVar) {
        l8.x.c(dVar, "AggregateSource must not be null");
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ((Task) this.f2884a.f5538b.s(new l8.t() { // from class: b8.a
            @Override // l8.t
            public final Object apply(Object obj) {
                return this.f2872a.e((e8.q0) obj);
            }
        })).continueWith(l8.p.f12580b, new Continuation() { // from class: b8.b
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f2876a.f(taskCompletionSource, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    public com.google.firebase.firestore.i d() {
        return this.f2884a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f2884a.equals(cVar.f2884a) && this.f2885b.equals(cVar.f2885b);
    }

    public int hashCode() {
        return Objects.hash(this.f2884a, this.f2885b);
    }
}
