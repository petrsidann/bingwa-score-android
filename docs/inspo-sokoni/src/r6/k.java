package r6;

import e7.a0;
import e7.i0;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f15038a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f15040b;

        static {
            int[] iArr = new int[b.values().length];
            f15040b = iArr;
            try {
                iArr[b.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15040b[b.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15040b[b.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15040b[b.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[i0.values().length];
            f15039a = iArr2;
            try {
                iArr2[i0.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15039a[i0.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15039a[i0.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f15039a[i0.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public enum b {
        TINK,
        LEGACY,
        RAW,
        CRUNCHY
    }

    public k(a0 a0Var) {
        this.f15038a = a0Var;
    }

    public static k a(String str, byte[] bArr, b bVar) {
        return new k(a0.U().y(str).z(com.google.crypto.tink.shaded.protobuf.i.k(bArr)).x(c(bVar)).build());
    }

    public static i0 c(b bVar) {
        int i10 = a.f15040b[bVar.ordinal()];
        if (i10 == 1) {
            return i0.TINK;
        }
        if (i10 == 2) {
            return i0.LEGACY;
        }
        if (i10 == 3) {
            return i0.RAW;
        }
        if (i10 == 4) {
            return i0.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }

    public a0 b() {
        return this.f15038a;
    }
}
