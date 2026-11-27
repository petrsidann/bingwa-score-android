package id;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public interface t<E> {
    Object a();

    Object b(oc.e<? super E> eVar);

    void cancel(CancellationException cancellationException);

    f<E> iterator();
}
