package a8;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface d {
    <T> void a(Class<T> cls, Executor executor, b<? super T> bVar);

    <T> void c(Class<T> cls, b<? super T> bVar);

    <T> void d(Class<T> cls, b<? super T> bVar);
}
