package zd;

/* JADX INFO: loaded from: classes2.dex */
public enum o implements p {
    Local("Local"),
    Schedule("Schedule"),
    ForegroundService("ForegroundService"),
    Firebase("Firebase"),
    OneSignal("OneSignal"),
    CallKit("CallKit");


    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static o[] f20667m = (o[]) o.class.getEnumConstants();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20669a;

    o(String str) {
        this.f20669a = str;
    }

    public static o i(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return null;
        }
        if (p.d(str, length, 0, 'l')) {
            return Local;
        }
        if (p.d(str, length, 0, 'f')) {
            return p.d(str, length, 1, 'o') ? ForegroundService : Firebase;
        }
        if (p.d(str, length, 0, 's')) {
            return Schedule;
        }
        if (p.d(str, length, 0, 'c')) {
            return CallKit;
        }
        if (p.d(str, length, 0, 'o')) {
            return OneSignal;
        }
        return null;
    }

    @Override // zd.p
    public String h() {
        return this.f20669a;
    }
}
