package ee;

import android.content.Context;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o<ge.a> f7951a = new o<>(je.o.c(), "DismissedManager", ge.a.class, "ActionReceived");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static h f7952b;

    public static h e() {
        if (f7952b == null) {
            f7952b = new h();
        }
        return f7952b;
    }

    public boolean d(Context context) {
        return f7951a.a(context);
    }

    public List<ge.a> f(Context context) {
        return f7951a.d(context, "dismissed");
    }

    public boolean g(Context context) {
        return f7951a.g(context, "dismissed").booleanValue();
    }

    public boolean h(Context context, Integer num, Calendar calendar) {
        return f7951a.f(context, "dismissed", j.c(num, calendar)).booleanValue();
    }

    public boolean i(Context context, ge.a aVar) {
        return f7951a.h(context, "dismissed", j.c(aVar.f8380l, aVar.f9284j0), aVar).booleanValue();
    }
}
