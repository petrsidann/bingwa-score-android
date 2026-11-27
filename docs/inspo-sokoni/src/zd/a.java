package zd;

/* JADX INFO: loaded from: classes2.dex */
public enum a implements p {
    Default("Default"),
    DisabledAction("DisabledAction"),
    KeepOnTop("KeepOnTop"),
    SilentAction("SilentAction"),
    SilentBackgroundAction("SilentBackgroundAction"),
    DismissAction("DismissAction"),
    InputField("InputField");


    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static a[] f20524n = (a[]) a.class.getEnumConstants();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20526a;

    a(String str) {
        this.f20526a = str;
    }

    public static a i(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return null;
        }
        if (p.d(str, length, 0, 'd')) {
            if (p.d(str, length, 1, 'e')) {
                return Default;
            }
            return p.d(str, length, 3, 'a') ? DisabledAction : DismissAction;
        }
        if (p.d(str, length, 0, 's')) {
            return p.d(str, length, 6, 'a') ? SilentAction : SilentBackgroundAction;
        }
        if (p.d(str, length, 0, 'k')) {
            return KeepOnTop;
        }
        if (p.d(str, length, 0, 'i')) {
            return InputField;
        }
        return null;
    }

    @Override // zd.p
    public String h() {
        return this.f20526a;
    }
}
