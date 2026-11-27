package j2;

/* JADX INFO: loaded from: classes.dex */
public final class i<T> extends h<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f11182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f11184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f11185e;

    public i(T value, String tag, j verificationMode, g logger) {
        kotlin.jvm.internal.k.e(value, "value");
        kotlin.jvm.internal.k.e(tag, "tag");
        kotlin.jvm.internal.k.e(verificationMode, "verificationMode");
        kotlin.jvm.internal.k.e(logger, "logger");
        this.f11182b = value;
        this.f11183c = tag;
        this.f11184d = verificationMode;
        this.f11185e = logger;
    }

    @Override // j2.h
    public T a() {
        return this.f11182b;
    }

    @Override // j2.h
    public h<T> c(String message, xc.l<? super T, Boolean> condition) {
        kotlin.jvm.internal.k.e(message, "message");
        kotlin.jvm.internal.k.e(condition, "condition");
        return condition.invoke(this.f11182b).booleanValue() ? this : new f(this.f11182b, this.f11183c, message, this.f11185e, this.f11184d);
    }
}
