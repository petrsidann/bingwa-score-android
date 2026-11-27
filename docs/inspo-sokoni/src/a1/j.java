package a1;

/* JADX INFO: loaded from: classes.dex */
public final class j<T> extends n<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f222a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Throwable readException) {
        super(null);
        kotlin.jvm.internal.k.e(readException, "readException");
        this.f222a = readException;
    }

    public final Throwable a() {
        return this.f222a;
    }
}
