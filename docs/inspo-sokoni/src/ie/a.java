package ie;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import fe.l;
import java.lang.ref.WeakReference;
import me.carda.awesome_notifications.core.services.ForegroundService;
import zd.k;
import zd.o;

/* JADX INFO: loaded from: classes2.dex */
public class a extends d<l> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f10640k = "NotificationSender";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f10641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vd.b f10642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ForegroundService.b f10643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o f10644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f10645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final wd.c f10646g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f10647h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f10648i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final je.o f10649j;

    public a(Context context, je.o oVar, ForegroundService.b bVar, vd.b bVar2, k kVar, wd.c cVar) throws ae.a {
        this.f10647h = 0L;
        if (bVar == null) {
            throw ae.b.e().c(f10640k, "INVALID_ARGUMENTS", "Foreground service intent is invalid", "arguments.invalid.foreground.intent");
        }
        this.f10641b = new WeakReference<>(context);
        this.f10643d = bVar;
        this.f10646g = cVar;
        this.f10642c = bVar2;
        this.f10645f = kVar;
        this.f10644e = o.ForegroundService;
        this.f10647h = System.nanoTime();
        this.f10649j = oVar;
    }

    public static void l(Context context, vd.b bVar, ForegroundService.b bVar2, k kVar, wd.c cVar) {
        l lVar = bVar2.f13330a;
        if (lVar == null) {
            throw ae.b.e().c(f10640k, "INVALID_ARGUMENTS", "Notification model is required", "arguments.invalid.foreground.notificationModel");
        }
        lVar.P(context);
        new a(context, je.o.c(), bVar2, bVar, kVar, cVar).c(bVar2.f13330a);
    }

    @Override // ie.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public l a() throws ae.a {
        l lVar = this.f10643d.f13330a;
        lVar.f8412l.U(this.f10645f, this.f10644e);
        lVar.f8412l.V(this.f10645f);
        if (this.f10649j.e(lVar.f8412l.f8382n).booleanValue() && this.f10649j.e(lVar.f8412l.f8383o).booleanValue()) {
            throw ae.b.e().c(f10640k, "INVALID_ARGUMENTS", "A foreground service requires at least the title or body", "arguments.invalid.foreground.intent");
        }
        return k(this.f10641b.get(), lVar);
    }

    @Override // ie.d
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public l e(l lVar) {
        if (lVar != null) {
            ge.b bVar = new ge.b(lVar.f8412l, null);
            k kVar = bVar.Z;
            if (kVar == null) {
                kVar = this.f10645f;
            }
            bVar.Z = kVar;
            ud.a.c().g(this.f10641b.get(), bVar);
            ud.a.c().i(this.f10641b.get(), bVar);
        }
        if (this.f10648i == 0) {
            this.f10648i = System.nanoTime();
        }
        if (rd.a.f15359i.booleanValue()) {
            long j10 = (this.f10648i - this.f10647h) / 1000000;
            de.a.a(f10640k, "Notification displayed in " + j10 + "ms");
        }
        return lVar;
    }

    public l k(Context context, l lVar) {
        try {
            k kVarD = rd.a.D();
            if (kVarD == k.Terminated || ((kVarD == k.Foreground && lVar.f8412l.E.booleanValue()) || (kVarD == k.Background && lVar.f8412l.F.booleanValue()))) {
                Notification notificationE = this.f10642c.e(context, null, lVar);
                if (notificationE == null || Build.VERSION.SDK_INT < 29 || this.f10643d.f13332c == zd.c.none) {
                    ((Service) context).startForeground(lVar.f8412l.f8380l.intValue(), notificationE);
                } else {
                    ((Service) context).startForeground(lVar.f8412l.f8380l.intValue(), notificationE, this.f10643d.f13332c.k());
                }
            }
            return lVar;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // ie.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void h(l lVar, ae.a aVar) {
        wd.c cVar = this.f10646g;
        if (cVar != null) {
            cVar.a(lVar != null, aVar);
        }
    }
}
