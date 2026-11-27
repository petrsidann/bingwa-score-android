package zd;

/* JADX INFO: loaded from: classes2.dex */
public enum l implements p {
    Alert("Alert"),
    Sound("Sound"),
    Badge("Badge"),
    Vibration("Vibration"),
    Light("Light"),
    CriticalAlert("CriticalAlert"),
    OverrideDnD("OverrideDnD"),
    Provisional("Provisional"),
    PreciseAlarms("PreciseAlarms"),
    FullScreenIntent("FullScreenIntent"),
    Car("Car");


    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static l[] f20635r = (l[]) l.class.getEnumConstants();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20637a;

    l(String str) {
        this.f20637a = str;
    }

    @Override // zd.p
    public String h() {
        return this.f20637a;
    }
}
