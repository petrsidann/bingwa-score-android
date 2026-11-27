package gd;

/* JADX INFO: loaded from: classes2.dex */
public enum o0 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9241a;

        static {
            int[] iArr = new int[o0.values().length];
            try {
                iArr[o0.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[o0.ATOMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[o0.UNDISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[o0.LAZY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f9241a = iArr;
        }
    }

    public final <R, T> void h(xc.p<? super R, ? super oc.e<? super T>, ? extends Object> pVar, R r10, oc.e<? super T> eVar) throws Throwable {
        int i10 = a.f9241a[ordinal()];
        if (i10 == 1) {
            md.a.d(pVar, r10, eVar, null, 4, null);
            return;
        }
        if (i10 == 2) {
            oc.g.a(pVar, r10, eVar);
        } else if (i10 == 3) {
            md.b.a(pVar, r10, eVar);
        } else if (i10 != 4) {
            throw new lc.h();
        }
    }

    public final boolean i() {
        return this == LAZY;
    }
}
