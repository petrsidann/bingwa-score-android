package u4;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class re {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f16770a;

    static {
        int[] iArr = new int[v8.values().length];
        f16770a = iArr;
        try {
            iArr[v8.POLICY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f16770a[v8.GRANTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f16770a[v8.DENIED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f16770a[v8.UNINITIALIZED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
