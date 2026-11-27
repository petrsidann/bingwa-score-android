package h6;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class k0 extends h0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f9676l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ h0 f9677m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ f f9678n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(f fVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, h0 h0Var) {
        super(taskCompletionSource);
        this.f9678n = fVar;
        this.f9676l = taskCompletionSource2;
        this.f9677m = h0Var;
    }

    @Override // h6.h0
    public final void b() {
        synchronized (this.f9678n.f9658f) {
            f.o(this.f9678n, this.f9676l);
            if (this.f9678n.f9664l.getAndIncrement() > 0) {
                this.f9678n.f9654b.d("Already connected to the service.", new Object[0]);
            }
            f.q(this.f9678n, this.f9677m);
        }
    }
}
