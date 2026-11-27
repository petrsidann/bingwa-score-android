package ee;

import android.content.Context;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o<ge.b> f7946a = new o<>(je.o.c(), "CreatedManager", ge.b.class, "NotificationReceived");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f f7947b;

    public static f e() {
        if (f7947b == null) {
            f7947b = new f();
        }
        return f7947b;
    }

    public boolean d(Context context) {
        return f7946a.a(context);
    }

    public List<ge.b> f(Context context) {
        return f7946a.d(context, "created");
    }

    public boolean g(Context context) {
        return f7946a.g(context, "created").booleanValue();
    }

    public boolean h(Context context, Integer num, Calendar calendar) {
        return f7946a.f(context, "created", j.c(num, calendar)).booleanValue();
    }

    public boolean i(Context context, ge.b bVar) {
        return f7946a.h(context, "created", j.c(bVar.f8380l, bVar.Y), bVar).booleanValue();
    }
}
