package ee;

import android.content.Context;
import me.carda.awesome_notifications.core.managers.StatusBarManager;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f7938b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final je.o f7939a;

    public c(je.o oVar) {
        this.f7939a = oVar;
    }

    public static c m() {
        if (f7938b == null) {
            f7938b = new c(je.o.c());
        }
        return f7938b;
    }

    public void a(Context context) {
        i(context);
        b(context);
    }

    public void b(Context context) {
        ie.b.k(context);
    }

    public boolean c(Context context, Integer num) throws ae.a {
        if (num == null || num.intValue() < 0) {
            throw ae.b.e().c("CancellationManager", "INVALID_ARGUMENTS", "Invalid notification id", "arguments.invalid.notificationId");
        }
        f(context, num);
        j(context, num);
        return true;
    }

    public boolean d(Context context, String str) throws ae.a {
        if (this.f7939a.e(str).booleanValue()) {
            throw ae.b.e().c("CancellationManager", "INVALID_ARGUMENTS", "Invalid channel key", "arguments.invalid.channelKey");
        }
        k(context, str);
        g(context, str);
        return true;
    }

    public boolean e(Context context, String str) throws ae.a {
        if (this.f7939a.e(str).booleanValue()) {
            throw ae.b.e().c("CancellationManager", "INVALID_ARGUMENTS", "Invalid group key", "arguments.invalid.groupKey");
        }
        l(context, str);
        h(context, str);
        return true;
    }

    public boolean f(Context context, Integer num) throws ae.a {
        if (num == null || num.intValue() < 0) {
            throw ae.b.e().c("CancellationManager", "INVALID_ARGUMENTS", "Invalid notification id", "arguments.invalid.notificationId");
        }
        ie.b.m(context, num);
        return true;
    }

    public boolean g(Context context, String str) throws ae.a {
        if (this.f7939a.e(str).booleanValue()) {
            throw ae.b.e().c("CancellationManager", "INVALID_ARGUMENTS", "Invalid channel key", "arguments.invalid.channelKey");
        }
        ie.b.n(context, str);
        return true;
    }

    public boolean h(Context context, String str) throws ae.a {
        if (this.f7939a.e(str).booleanValue()) {
            throw ae.b.e().c("CancellationManager", "INVALID_ARGUMENTS", "Invalid group key", "arguments.invalid.groupKey");
        }
        ie.b.o(context, str);
        return true;
    }

    public void i(Context context) {
        StatusBarManager.k(context).c(context);
    }

    public boolean j(Context context, Integer num) throws ae.a {
        if (num == null || num.intValue() < 0) {
            throw ae.b.e().c("CancellationManager", "INVALID_ARGUMENTS", "Invalid notification id", "arguments.invalid.notificationId");
        }
        StatusBarManager.k(context).d(context, num);
        return true;
    }

    public boolean k(Context context, String str) throws ae.a {
        if (this.f7939a.e(str).booleanValue()) {
            throw ae.b.e().c("CancellationManager", "INVALID_ARGUMENTS", "Invalid channel key", "arguments.invalid.channelKey");
        }
        StatusBarManager.k(context).e(context, str);
        return true;
    }

    public boolean l(Context context, String str) throws ae.a {
        if (this.f7939a.e(str).booleanValue()) {
            throw ae.b.e().c("CancellationManager", "INVALID_ARGUMENTS", "Invalid group key", "arguments.invalid.groupKey");
        }
        StatusBarManager.k(context).f(context, str);
        return true;
    }
}
