package gd;

/* JADX INFO: loaded from: classes2.dex */
public interface t0<T> extends y1 {
    Object await(oc.e<? super T> eVar);

    T getCompleted();

    Throwable getCompletionExceptionOrNull();

    od.c<T> getOnAwait();
}
