package zd;

/* JADX INFO: loaded from: classes2.dex */
public enum k implements p {
    Foreground("Foreground"),
    Background("Background"),
    Terminated("Terminated");


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final k f20620e = Terminated;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static k[] f20621f = (k[]) k.class.getEnumConstants();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20623a;

    k(String str) {
        this.f20623a = str;
    }

    public static k i(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return null;
        }
        if (!p.d(str, length, 0, 't') && !p.d(str, length, 0, 'a')) {
            if (p.d(str, length, 0, 'f')) {
                return Foreground;
            }
            if (p.d(str, length, 0, 'b')) {
                return Background;
            }
            return null;
        }
        return Terminated;
    }

    @Override // zd.p
    public String h() {
        return this.f20623a;
    }
}
