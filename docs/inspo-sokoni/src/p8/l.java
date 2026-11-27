package p8;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public class l implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskCompletionSource<String> f14388a;

    public l(TaskCompletionSource<String> taskCompletionSource) {
        this.f14388a = taskCompletionSource;
    }

    @Override // p8.o
    public boolean a(r8.d dVar) {
        if (!dVar.l() && !dVar.k() && !dVar.i()) {
            return false;
        }
        this.f14388a.trySetResult(dVar.d());
        return true;
    }

    @Override // p8.o
    public boolean b(Exception exc) {
        return false;
    }
}
