package zd;

/* JADX INFO: loaded from: classes2.dex */
public enum h implements p {
    Alarm("Alarm", "alarm"),
    Call("Call", "call"),
    Email("Email", "email"),
    Error("Error", "err"),
    Event("Event", "event"),
    LocalSharing("LocalSharing", "location_sharing"),
    Message("Message", "msg"),
    MissedCall("MissedCall", "missed_call"),
    Navigation("Navigation", "navigation"),
    Progress("Progress", "progress"),
    Promo("Promo", "promo"),
    Recommendation("Recommendation", "recommendation"),
    Reminder("Reminder", "reminder"),
    Service("Service", "service"),
    Social("Social", "social"),
    Status("Status", "status"),
    StopWatch("StopWatch", "stopwatch"),
    Transport("Transport", "transport"),
    Workout("Workout", "workout");

    public static h[] A = (h[]) h.class.getEnumConstants();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20595b;

    h(String str, String str2) {
        this.f20594a = str;
        this.f20595b = str2;
    }

    public static h i(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return null;
        }
        if (p.d(str, length, 0, 'a')) {
            return Alarm;
        }
        if (p.d(str, length, 0, 'c')) {
            return Call;
        }
        if (p.d(str, length, 0, 'm')) {
            return p.d(str, length, 1, 'e') ? Message : MissedCall;
        }
        if (p.d(str, length, 0, 'r')) {
            return p.d(str, length, 2, 'c') ? Recommendation : Reminder;
        }
        if (p.d(str, length, 0, 'l')) {
            return LocalSharing;
        }
        if (p.d(str, length, 0, 'n')) {
            return Navigation;
        }
        if (p.d(str, length, 0, 'p')) {
            return p.d(str, length, 3, 'g') ? Progress : Promo;
        }
        if (p.d(str, length, 0, 'e')) {
            if (p.d(str, length, 1, 'm')) {
                return Email;
            }
            return p.d(str, length, 1, 'r') ? Error : Event;
        }
        if (p.d(str, length, 0, 's')) {
            if (p.d(str, length, 1, 'e')) {
                return Service;
            }
            if (p.d(str, length, 1, 'o')) {
                return Social;
            }
            return p.d(str, length, 2, 'a') ? Status : StopWatch;
        }
        if (p.d(str, length, 0, 'w')) {
            return Workout;
        }
        if (p.d(str, length, 0, 't')) {
            return Transport;
        }
        return null;
    }

    @Override // zd.p
    public String h() {
        return this.f20594a;
    }
}
