package a1;

/* JADX INFO: loaded from: classes.dex */
public final class h<T> extends n<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f221a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Throwable finalException) {
        super(null);
        kotlin.jvm.internal.k.e(finalException, "finalException");
        this.f221a = finalException;
    }

    public final Throwable a() {
        return this.f221a;
    }
}
