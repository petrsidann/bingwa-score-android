package gd;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final class n1 {
    public static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
