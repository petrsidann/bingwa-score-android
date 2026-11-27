package ie;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import ee.e;
import ee.p;
import fe.l;
import fe.m;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import je.i;
import zd.h;
import zd.k;
import zd.o;

/* JADX INFO: loaded from: classes2.dex */
public class b extends d<Calendar> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f10650m = "NotificationScheduler";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f10651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f10652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f10653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f10654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Intent f10655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f10656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f10657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f10658i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f10659j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Calendar f10660k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final wd.c f10661l;

    public b(Context context, k kVar, o oVar, l lVar, Intent intent, boolean z10, wd.c cVar) {
        Boolean bool = Boolean.FALSE;
        this.f10656g = bool;
        this.f10657h = bool;
        this.f10658i = 0L;
        this.f10659j = 0L;
        this.f10651b = new WeakReference<>(context);
        this.f10657h = Boolean.valueOf(z10);
        this.f10652c = oVar;
        this.f10653d = kVar;
        this.f10654e = lVar;
        this.f10658i = System.nanoTime();
        this.f10655f = intent;
        this.f10661l = cVar;
        this.f10660k = je.d.g().f(lVar.f8413m.f8416e);
        Integer num = lVar.f8412l.f8380l;
        if (num == null || num.intValue() < 0) {
            lVar.f8412l.f8380l = Integer.valueOf(i.c());
        }
    }

    public static void i(Context context, List<Integer> list) {
        AlarmManager alarmManagerG = p.g(context);
        Intent intent = new Intent(context, (Class<?>) rd.a.f15362l);
        int i10 = Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            alarmManagerG.cancel(PendingIntent.getBroadcast(context, it.next().intValue(), intent, i10));
        }
    }

    public static void j(Context context, Integer num) {
        p.g(context).cancel(PendingIntent.getBroadcast(context, num.intValue(), new Intent(context, (Class<?>) rd.a.f15362l), Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728));
    }

    public static void k(Context context) {
        i(context, p.k(context));
        p.b(context);
        p.f(context);
    }

    public static void l(Context context, l lVar) {
        j(context, lVar.f8412l.f8380l);
        p.p(context, lVar);
        p.f(context);
    }

    public static void m(Context context, Integer num) {
        j(context, num);
        p.c(context, num);
        p.f(context);
    }

    public static void n(Context context, String str) {
        i(context, p.l(context, str));
        p.d(context, str);
        p.f(context);
    }

    public static void o(Context context, String str) {
        i(context, p.m(context, str));
        p.e(context, str);
        p.f(context);
    }

    public static boolean q(Context context, Integer num) throws ae.a {
        if (num.intValue() < 0) {
            throw ae.b.e().c(f10650m, "INVALID_ARGUMENTS", "Scheduled notification Id is invalid", "arguments.invalid.notificationId");
        }
        return PendingIntent.getBroadcast(context, num.intValue(), new Intent(context, (Class<?>) rd.a.f15362l), Build.VERSION.SDK_INT >= 31 ? 570425344 : 536870912) != null;
    }

    public static void s(Context context) {
        List<Integer> listK = p.k(context);
        if (listK.isEmpty()) {
            return;
        }
        for (Integer num : listK) {
            if (!q(context, num)) {
                l lVarH = p.h(context, num);
                if (lVarH == null) {
                    p.c(context, num);
                } else if (lVarH.f8413m.T().booleanValue()) {
                    t(context, lVarH, null, null);
                } else {
                    p.p(context, lVarH);
                }
            }
        }
    }

    public static void t(Context context, l lVar, Intent intent, wd.c cVar) throws ae.a {
        if (lVar == null) {
            throw ae.b.e().c(f10650m, "INVALID_ARGUMENTS", "Invalid notification content", "arguments.invalid.notificationModel");
        }
        lVar.P(context);
        new b(context, rd.a.D(), lVar.f8412l.W, lVar, intent, true, cVar).c(lVar);
    }

    public static void u(Context context, o oVar, l lVar, wd.c cVar) {
        if (lVar == null) {
            throw ae.b.e().c(f10650m, "INVALID_ARGUMENTS", "Invalid notification content", "arguments.invalid.notificationModel");
        }
        lVar.P(context);
        new b(context, rd.a.D(), oVar, lVar, null, false, cVar).c(lVar);
    }

    @Override // ie.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Calendar a() throws ae.a {
        if (this.f10654e != null) {
            if (!e.h().i(this.f10651b.get(), this.f10654e.f8412l.f8381m)) {
                throw ae.b.e().c(f10650m, "INVALID_ARGUMENTS", "Channel '" + this.f10654e.f8412l.f8381m + "' do not exist or is disabled", "insufficientPermissions.channel." + this.f10654e.f8412l.f8381m);
            }
            l lVar = this.f10654e;
            if (lVar.f8413m == null) {
                return null;
            }
            this.f10656g = Boolean.valueOf(lVar.f8412l.U(this.f10653d, this.f10652c));
            Calendar calendarR = this.f10654e.f8413m.R(this.f10660k);
            if (calendarR != null) {
                l lVarV = v(this.f10651b.get(), this.f10654e, calendarR);
                this.f10654e = lVarV;
                if (lVarV != null) {
                    this.f10656g = Boolean.TRUE;
                }
                return calendarR;
            }
            l(this.f10651b.get(), this.f10654e);
            de.a.a(f10650m, "Date is not more valid. (" + je.d.g().j() + ")");
        }
        return null;
    }

    @Override // ie.d
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Calendar e(Calendar calendar) {
        if (this.f10654e != null) {
            if (calendar != null && this.f10656g.booleanValue()) {
                p.q(this.f10651b.get(), this.f10654e);
                if (!this.f10657h.booleanValue()) {
                    ud.a.c().g(this.f10651b.get(), new ge.b(this.f10654e.f8412l, this.f10655f));
                    de.a.a(f10650m, "Scheduled created");
                }
                p.f(this.f10651b.get());
                if (this.f10659j == 0) {
                    this.f10659j = System.nanoTime();
                }
                if (rd.a.f15359i.booleanValue()) {
                    long j10 = (this.f10659j - this.f10658i) / 1000000;
                    String str = f10650m;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Notification ");
                    sb2.append(this.f10657h.booleanValue() ? "rescheduled" : "scheduled");
                    sb2.append(" in ");
                    sb2.append(j10);
                    sb2.append("ms");
                    de.a.a(str, sb2.toString());
                }
                return calendar;
            }
            p.p(this.f10651b.get(), this.f10654e);
            j(this.f10651b.get(), this.f10654e.f8412l.f8380l);
            de.a.a(f10650m, "Scheduled removed");
            p.f(this.f10651b.get());
        }
        if (this.f10659j == 0) {
            this.f10659j = System.nanoTime();
        }
        if (!rd.a.f15359i.booleanValue()) {
            return null;
        }
        long j11 = (this.f10659j - this.f10658i) / 1000000;
        de.a.a(f10650m, "Notification schedule removed in " + j11 + "ms");
        return null;
    }

    public final l v(Context context, l lVar, Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        String strN = lVar.N();
        Intent intent = new Intent(context, (Class<?>) rd.a.f15362l);
        intent.setFlags(32);
        intent.putExtra("id", lVar.f8412l.f8380l);
        intent.putExtra("notificationJson", strN);
        w(context, lVar, calendar, PendingIntent.getBroadcast(context, lVar.f8412l.f8380l.intValue(), intent, Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728));
        return lVar;
    }

    public final void w(Context context, l lVar, Calendar calendar, PendingIntent pendingIntent) {
        if (lVar.f8413m == null) {
            return;
        }
        AlarmManager alarmManagerG = p.g(context);
        long timeInMillis = calendar.getTimeInMillis();
        if (je.c.a().b(lVar.f8413m.f8420n) && p.i(alarmManagerG)) {
            if (lVar.f8412l.f8377b0 == h.Alarm) {
                alarmManagerG.setAlarmClock(new AlarmManager.AlarmClockInfo(timeInMillis, pendingIntent), pendingIntent);
                return;
            } else if (je.c.a().b(lVar.f8413m.f8419m)) {
                alarmManagerG.setExactAndAllowWhileIdle(0, timeInMillis, pendingIntent);
                return;
            } else {
                alarmManagerG.setExact(0, timeInMillis, pendingIntent);
                return;
            }
        }
        m mVar = lVar.f8413m;
        if (mVar.f8421o == null) {
            mVar.f8421o = 0;
        }
        if (je.c.a().b(lVar.f8413m.f8419m)) {
            alarmManagerG.setAndAllowWhileIdle(0, timeInMillis, pendingIntent);
        } else {
            alarmManagerG.setWindow(1, timeInMillis, lVar.f8413m.f8421o.intValue(), pendingIntent);
        }
    }

    @Override // ie.d
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(Calendar calendar, ae.a aVar) {
        wd.c cVar = this.f10661l;
        if (cVar != null) {
            cVar.a(aVar != null, aVar);
        }
    }
}
