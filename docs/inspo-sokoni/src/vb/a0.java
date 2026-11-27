package vb;

import java.util.concurrent.TimeUnit;
import vb.a0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a0<T extends a0<T>> extends z<T> {
    @Override // vb.z
    @Deprecated
    public abstract x0<?> e();

    @Override // vb.x0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public T c(long j10, TimeUnit timeUnit) {
        e().c(j10, timeUnit);
        return (T) g();
    }

    public final T g() {
        return this;
    }

    @Override // vb.x0
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public T d() {
        e().d();
        return (T) g();
    }
}
