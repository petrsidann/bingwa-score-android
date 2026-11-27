package p6;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public interface e<V> extends Future<V> {
    void d(Runnable runnable, Executor executor);
}
