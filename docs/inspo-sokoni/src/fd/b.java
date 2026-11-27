package fd;

import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f8314a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<DecimalFormat>[] f8315b;

    static {
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i10 = 0; i10 < 4; i10++) {
            threadLocalArr[i10] = new ThreadLocal<>();
        }
        f8315b = threadLocalArr;
    }

    public static final boolean a() {
        return f8314a;
    }
}
