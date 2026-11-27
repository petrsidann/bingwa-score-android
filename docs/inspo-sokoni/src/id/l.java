package id;

import gd.n1;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l {
    public static final void a(t<?> tVar, Throwable th) {
        CancellationException cancellationExceptionA = null;
        if (th != null) {
            cancellationExceptionA = th instanceof CancellationException ? (CancellationException) th : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = n1.a("Channel was consumed, consumer had failed", th);
            }
        }
        tVar.cancel(cancellationExceptionA);
    }
}
