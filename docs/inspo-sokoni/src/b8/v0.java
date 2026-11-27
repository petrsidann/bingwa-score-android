package b8;

import android.app.Activity;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class v0 extends Task<w0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2983a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w0 f2984b = w0.f2991g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TaskCompletionSource<w0> f2985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Task<w0> f2986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Queue<a> f2987e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Executor f2988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d1<w0> f2989b;

        public a(Executor executor, d1<w0> d1Var) {
            this.f2988a = executor == null ? TaskExecutors.MAIN_THREAD : executor;
            this.f2989b = d1Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(w0 w0Var) {
            this.f2989b.a(w0Var);
        }

        public void b(final w0 w0Var) {
            this.f2988a.execute(new Runnable() { // from class: b8.u0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2977a.c(w0Var);
                }
            });
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f2989b.equals(((a) obj).f2989b);
        }

        public int hashCode() {
            return this.f2989b.hashCode();
        }
    }

    public v0() {
        TaskCompletionSource<w0> taskCompletionSource = new TaskCompletionSource<>();
        this.f2985c = taskCompletionSource;
        this.f2986d = taskCompletionSource.getTask();
        this.f2987e = new ArrayDeque();
    }

    public v0 a(d1<w0> d1Var) {
        a aVar = new a(null, d1Var);
        synchronized (this.f2983a) {
            this.f2987e.add(aVar);
        }
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<w0> addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        return this.f2986d.addOnCanceledListener(activity, onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<w0> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        return this.f2986d.addOnCanceledListener(onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<w0> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        return this.f2986d.addOnCanceledListener(executor, onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<w0> addOnCompleteListener(Activity activity, OnCompleteListener<w0> onCompleteListener) {
        return this.f2986d.addOnCompleteListener(activity, onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<w0> addOnCompleteListener(OnCompleteListener<w0> onCompleteListener) {
        return this.f2986d.addOnCompleteListener(onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<w0> addOnCompleteListener(Executor executor, OnCompleteListener<w0> onCompleteListener) {
        return this.f2986d.addOnCompleteListener(executor, onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<w0> addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        return this.f2986d.addOnFailureListener(activity, onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<w0> addOnFailureListener(OnFailureListener onFailureListener) {
        return this.f2986d.addOnFailureListener(onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<w0> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        return this.f2986d.addOnFailureListener(executor, onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<w0> addOnSuccessListener(Activity activity, OnSuccessListener<? super w0> onSuccessListener) {
        return this.f2986d.addOnSuccessListener(activity, onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<w0> addOnSuccessListener(OnSuccessListener<? super w0> onSuccessListener) {
        return this.f2986d.addOnSuccessListener(onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<w0> addOnSuccessListener(Executor executor, OnSuccessListener<? super w0> onSuccessListener) {
        return this.f2986d.addOnSuccessListener(executor, onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public w0 getResult() {
        return this.f2986d.getResult();
    }

    @Override // com.google.android.gms.tasks.Task
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public <X extends Throwable> w0 getResult(Class<X> cls) {
        return this.f2986d.getResult(cls);
    }

    @Override // com.google.android.gms.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<w0, TContinuationResult> continuation) {
        return this.f2986d.continueWith(continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<w0, TContinuationResult> continuation) {
        return this.f2986d.continueWith(executor, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<w0, Task<TContinuationResult>> continuation) {
        return this.f2986d.continueWithTask(continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, Continuation<w0, Task<TContinuationResult>> continuation) {
        return this.f2986d.continueWithTask(executor, continuation);
    }

    public void d(Exception exc) {
        synchronized (this.f2983a) {
            w0 w0Var = new w0(this.f2984b.d(), this.f2984b.g(), this.f2984b.c(), this.f2984b.f(), exc, w0.a.ERROR);
            this.f2984b = w0Var;
            Iterator<a> it = this.f2987e.iterator();
            while (it.hasNext()) {
                it.next().b(w0Var);
            }
            this.f2987e.clear();
        }
        this.f2985c.setException(exc);
    }

    public void e(w0 w0Var) {
        l8.b.d(w0Var.e().equals(w0.a.SUCCESS), "Expected success, but was " + w0Var.e(), new Object[0]);
        synchronized (this.f2983a) {
            this.f2984b = w0Var;
            Iterator<a> it = this.f2987e.iterator();
            while (it.hasNext()) {
                it.next().b(this.f2984b);
            }
            this.f2987e.clear();
        }
        this.f2985c.setResult(w0Var);
    }

    public void f(w0 w0Var) {
        synchronized (this.f2983a) {
            this.f2984b = w0Var;
            Iterator<a> it = this.f2987e.iterator();
            while (it.hasNext()) {
                it.next().b(w0Var);
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public Exception getException() {
        return this.f2986d.getException();
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isCanceled() {
        return this.f2986d.isCanceled();
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isComplete() {
        return this.f2986d.isComplete();
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isSuccessful() {
        return this.f2986d.isSuccessful();
    }

    @Override // com.google.android.gms.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<w0, TContinuationResult> successContinuation) {
        return this.f2986d.onSuccessTask(successContinuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<w0, TContinuationResult> successContinuation) {
        return this.f2986d.onSuccessTask(executor, successContinuation);
    }
}
