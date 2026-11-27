package zd;

/* JADX INFO: loaded from: classes2.dex */
public enum b implements p {
    Ringtone("Ringtone"),
    Notification("Notification"),
    Alarm("Alarm");


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static b[] f20530e = (b[]) b.class.getEnumConstants();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20532a;

    b(String str) {
        this.f20532a = str;
    }

    public static b i(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return null;
        }
        if (p.d(str, length, 0, 'n')) {
            return Notification;
        }
        if (p.d(str, length, 0, 'r')) {
            return Ringtone;
        }
        if (p.d(str, length, 0, 'a')) {
            return Alarm;
        }
        return null;
    }

    @Override // zd.p
    public String h() {
        return this.f20532a;
    }
}
