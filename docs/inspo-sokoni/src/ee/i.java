package ee;

import android.content.Context;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class i extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o<ge.b> f7953a = new o<>(je.o.c(), "DisplayedManager", ge.b.class, "NotificationReceived");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static i f7954b;

    public static i e() {
        if (f7954b == null) {
            f7954b = new i();
        }
        return f7954b;
    }

    public boolean d(Context context) {
        return f7953a.a(context);
    }

    public List<ge.b> f(Context context) {
        return f7953a.d(context, "displayed");
    }

    public boolean g(Context context) {
        return f7953a.g(context, "displayed").booleanValue();
    }

    public Boolean h(Context context, Integer num, Calendar calendar) {
        return f7953a.f(context, "displayed", j.c(num, calendar));
    }

    public boolean i(Context context, ge.b bVar) {
        return f7953a.h(context, "displayed", j.c(bVar.f8380l, bVar.f8376a0), bVar).booleanValue();
    }
}
