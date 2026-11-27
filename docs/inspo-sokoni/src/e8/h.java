package e8;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class h<T> implements b8.r<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f7174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b8.r<T> f7175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f7176c = false;

    public h(Executor executor, b8.r<T> rVar) {
        this.f7174a = executor;
        this.f7175b = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Object obj, com.google.firebase.firestore.f fVar) {
        if (this.f7176c) {
            return;
        }
        this.f7175b.a(obj, fVar);
    }

    @Override // b8.r
    public void a(final T t10, final com.google.firebase.firestore.f fVar) {
        this.f7174a.execute(new Runnable() { // from class: e8.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f7160a.c(t10, fVar);
            }
        });
    }

    public void d() {
        this.f7176c = true;
    }
}
