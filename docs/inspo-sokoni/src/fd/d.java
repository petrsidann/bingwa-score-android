package fd;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public enum d {
    NANOSECONDS(TimeUnit.NANOSECONDS),
    MICROSECONDS(TimeUnit.MICROSECONDS),
    MILLISECONDS(TimeUnit.MILLISECONDS),
    SECONDS(TimeUnit.SECONDS),
    MINUTES(TimeUnit.MINUTES),
    HOURS(TimeUnit.HOURS),
    DAYS(TimeUnit.DAYS);


    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ rc.a f8324o = rc.b.a(d());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeUnit f8325a;

    d(TimeUnit timeUnit) {
        this.f8325a = timeUnit;
    }

    public final TimeUnit h() {
        return this.f8325a;
    }
}
