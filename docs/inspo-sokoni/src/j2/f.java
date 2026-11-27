package j2;

/* JADX INFO: loaded from: classes.dex */
public final class f<T> extends h<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f11174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f11177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f11178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f11179g;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11180a;

        static {
            int[] iArr = new int[j.values().length];
            try {
                iArr[j.STRICT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[j.LOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[j.QUIET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f11180a = iArr;
        }
    }

    public f(T value, String tag, String message, g logger, j verificationMode) {
        kotlin.jvm.internal.k.e(value, "value");
        kotlin.jvm.internal.k.e(tag, "tag");
        kotlin.jvm.internal.k.e(message, "message");
        kotlin.jvm.internal.k.e(logger, "logger");
        kotlin.jvm.internal.k.e(verificationMode, "verificationMode");
        this.f11174b = value;
        this.f11175c = tag;
        this.f11176d = message;
        this.f11177e = logger;
        this.f11178f = verificationMode;
        l lVar = new l(b(value, message));
        StackTraceElement[] stackTrace = lVar.getStackTrace();
        kotlin.jvm.internal.k.d(stackTrace, "stackTrace");
        lVar.setStackTrace((StackTraceElement[]) mc.k.k(stackTrace, 2).toArray(new StackTraceElement[0]));
        this.f11179g = lVar;
    }

    @Override // j2.h
    public T a() throws l {
        int i10 = a.f11180a[this.f11178f.ordinal()];
        if (i10 == 1) {
            throw this.f11179g;
        }
        if (i10 == 2) {
            this.f11177e.a(this.f11175c, b(this.f11174b, this.f11176d));
            return null;
        }
        if (i10 == 3) {
            return null;
        }
        throw new lc.h();
    }

    @Override // j2.h
    public h<T> c(String message, xc.l<? super T, Boolean> condition) {
        kotlin.jvm.internal.k.e(message, "message");
        kotlin.jvm.internal.k.e(condition, "condition");
        return this;
    }
}
