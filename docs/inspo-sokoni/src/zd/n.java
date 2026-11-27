package zd;

/* JADX INFO: loaded from: classes2.dex */
public enum n implements p {
    Secret("Secret"),
    Private("Private"),
    Public("Public");


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static n[] f20657e = (n[]) n.class.getEnumConstants();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20659a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20660a;

        static {
            int[] iArr = new int[n.values().length];
            f20660a = iArr;
            try {
                iArr[n.Secret.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20660a[n.Public.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20660a[n.Private.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    n(String str) {
        this.f20659a = str;
    }

    public static n i(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return null;
        }
        if (p.d(str, length, 0, 's')) {
            return Secret;
        }
        if (p.d(str, length, 1, 'u')) {
            return Public;
        }
        if (p.d(str, length, 1, 'r')) {
            return Private;
        }
        return null;
    }

    public static int k(n nVar) {
        int[] iArr = a.f20660a;
        if (nVar == null) {
            nVar = Private;
        }
        int i10 = iArr[nVar.ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? 0 : 1;
        }
        return -1;
    }

    @Override // zd.p
    public String h() {
        return this.f20659a;
    }
}
