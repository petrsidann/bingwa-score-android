package p8;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public class k implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f14386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource<m> f14387b;

    public k(p pVar, TaskCompletionSource<m> taskCompletionSource) {
        this.f14386a = pVar;
        this.f14387b = taskCompletionSource;
    }

    @Override // p8.o
    public boolean a(r8.d dVar) {
        if (!dVar.k() || this.f14386a.f(dVar)) {
            return false;
        }
        this.f14387b.setResult(m.a().b(dVar.b()).d(dVar.c()).c(dVar.h()).a());
        return true;
    }

    @Override // p8.o
    public boolean b(Exception exc) {
        this.f14387b.trySetException(exc);
        return true;
    }
}
