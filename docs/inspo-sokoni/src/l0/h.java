package l0;

import android.os.OutcomeReceiver;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class h<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oc.e<R> f12397a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(oc.e<? super R> eVar) {
        super(false);
        this.f12397a = eVar;
    }

    @Override // android.os.OutcomeReceiver
    public void onError(E e10) {
        if (compareAndSet(false, true)) {
            oc.e<R> eVar = this.f12397a;
            lc.j.a aVar = lc.j.f12703b;
            eVar.resumeWith(lc.j.b(lc.k.a(e10)));
        }
    }

    @Override // android.os.OutcomeReceiver
    public void onResult(R r10) {
        if (compareAndSet(false, true)) {
            this.f12397a.resumeWith(lc.j.b(r10));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
