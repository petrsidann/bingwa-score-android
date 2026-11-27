package a8;

import q7.d0;

/* JADX INFO: loaded from: classes.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<T> f418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f419b;

    public a(Class<T> cls, T t10) {
        this.f418a = (Class) d0.b(cls);
        this.f419b = (T) d0.b(t10);
    }

    public T a() {
        return this.f419b;
    }

    public Class<T> b() {
        return this.f418a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.f418a, this.f419b);
    }
}
