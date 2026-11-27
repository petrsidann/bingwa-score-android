package z3;

import android.content.Context;
import android.util.Log;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class g extends p1.a implements com.google.android.gms.common.api.internal.s {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Semaphore f19785o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Set f19786p;

    public g(Context context, Set set) {
        super(context);
        this.f19785o = new Semaphore(0);
        this.f19786p = set;
    }

    @Override // p1.a
    public final /* bridge */ /* synthetic */ Object A() {
        Iterator it = this.f19786p.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (((com.google.android.gms.common.api.f) it.next()).g(this)) {
                i10++;
            }
        }
        try {
            this.f19785o.tryAcquire(i10, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e10) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e10);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // p1.b
    public final void o() {
        this.f19785o.drainPermits();
        h();
    }
}
