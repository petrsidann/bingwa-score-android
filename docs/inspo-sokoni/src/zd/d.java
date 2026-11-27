package zd;

/* JADX INFO: loaded from: classes2.dex */
public enum d implements p {
    stick("stick"),
    stickCompatibility("stickCompatibility"),
    notStick("notStick"),
    deliverIntent("deliverIntent");


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static d[] f20552f = (d[]) d.class.getEnumConstants();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20554a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20555a;

        static {
            int[] iArr = new int[d.values().length];
            f20555a = iArr;
            try {
                iArr[d.notStick.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20555a[d.stickCompatibility.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20555a[d.deliverIntent.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20555a[d.stick.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    d(String str) {
        this.f20554a = str;
    }

    public static d i(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return null;
        }
        if (p.d(str, length, 0, 's')) {
            return p.d(str, length, 5, 'c') ? stickCompatibility : stick;
        }
        if (p.d(str, length, 0, 'n')) {
            return notStick;
        }
        if (p.d(str, length, 0, 'd')) {
            return deliverIntent;
        }
        return null;
    }

    @Override // zd.p
    public String h() {
        return this.f20554a;
    }

    public int k() {
        int i10 = a.f20555a[ordinal()];
        if (i10 == 1) {
            return 2;
        }
        if (i10 != 2) {
            return i10 != 3 ? 1 : 3;
        }
        return 0;
    }
}
