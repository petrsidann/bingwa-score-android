package ud;

import android.content.Context;
import android.content.Intent;
import e0.l;
import ee.k;
import ee.m;
import vd.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f17090a;

    public static a c() {
        if (f17090a == null) {
            f17090a = new a();
        }
        return f17090a;
    }

    public void a(Context context, String str, ge.a aVar, Intent intent) {
        if (rd.a.f15363m == null) {
            return;
        }
        l.d(context, rd.a.f15363m, 42, b.m().b(context, intent, str, aVar, rd.a.f15363m));
    }

    public void b(Context context, String str, ge.a aVar, Intent intent) {
        l.d(context, rd.a.f15363m, 42, b.m().b(context, intent, str, aVar, rd.a.f15363m));
    }

    public final boolean d() {
        return k.h() == zd.k.Terminated || td.b.c().d() || !td.b.c().e();
    }

    public void e(Context context, ge.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            td.b.c().a(context, "broadcast.awesome_notifications.BACKGROUND_ACTION", aVar);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void f(Context context, ge.a aVar, boolean z10) {
        if (aVar == null) {
            return;
        }
        if (z10) {
            try {
                ee.a.f().k(context, aVar);
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        }
        if (d()) {
            ee.a.f().j(context, aVar);
        } else {
            td.b.c().a(context, "broadcast.awesome_notifications.DEFAULT_ACTION", aVar);
        }
    }

    public void g(Context context, ge.b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            if (d()) {
                m.b().h(context, bVar);
            } else {
                td.b.c().b(context, "broadcast.awesome_notifications.CREATED_NOTIFICATION", bVar);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void h(Context context, ge.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (d()) {
                m.b().i(context, aVar);
            } else {
                td.b.c().a(context, "broadcast.awesome_notifications.DISMISSED_NOTIFICATION", aVar);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void i(Context context, ge.b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            if (d()) {
                m.b().j(context, bVar);
            } else {
                td.b.c().b(context, "broadcast.awesome_notifications.DISPLAYED_NOTIFICATION", bVar);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void j(Context context, ge.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            td.b.c().a(context, "broadcast.awesome_notifications.SILENT_ACTION", aVar);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
