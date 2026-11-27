package a3;

import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: classes.dex */
@AutoValue
public abstract class d<T> {
    public static <T> d<T> e(T t10, f fVar) {
        return new a(null, t10, e.DEFAULT, fVar);
    }

    public abstract Integer a();

    public abstract T b();

    public abstract e c();

    public abstract f d();
}
