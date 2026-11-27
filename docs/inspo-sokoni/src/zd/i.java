package zd;

/* JADX INFO: loaded from: classes2.dex */
public enum i implements p {
    None("None"),
    Min("Min"),
    Low("Low"),
    Default("Default"),
    High("High"),
    Max("Max");


    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static i[] f20602m = (i[]) i.class.getEnumConstants();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20604a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20605a;

        static {
            int[] iArr = new int[i.values().length];
            f20605a = iArr;
            try {
                iArr[i.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20605a[i.Min.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20605a[i.Low.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20605a[i.High.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20605a[i.Max.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20605a[i.Default.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    i(String str) {
        this.f20604a = str;
    }

    public static i i(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        if (i10 > 5) {
            i10 = 5;
        }
        return values()[i10];
    }

    public static i k(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return null;
        }
        if (p.d(str, length, 0, 'h')) {
            return High;
        }
        if (p.d(str, length, 0, 'd')) {
            return Default;
        }
        if (p.d(str, length, 0, 'l')) {
            return Low;
        }
        if (p.d(str, length, 0, 'm')) {
            return p.d(str, length, 1, 'a') ? Max : Min;
        }
        if (p.d(str, length, 0, 'n')) {
            return None;
        }
        return null;
    }

    public static int l(i iVar) {
        int[] iArr = a.f20605a;
        if (iVar == null) {
            iVar = Default;
        }
        int i10 = iArr[iVar.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return -2;
        }
        if (i10 == 3) {
            return -1;
        }
        if (i10 != 4) {
            return i10 != 5 ? 0 : 2;
        }
        return 1;
    }

    @Override // zd.p
    public String h() {
        return this.f20604a;
    }
}
