package ie;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import ee.p;
import fe.g;
import fe.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import je.i;
import me.carda.awesome_notifications.core.managers.StatusBarManager;
import zd.j;
import zd.k;
import zd.o;

/* JADX INFO: loaded from: classes2.dex */
public class c extends d<ge.b> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f10662n = "NotificationSender";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f10663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vd.b f10664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f10665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f10666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Intent f10667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l f10668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final wd.c f10669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f10670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f10671j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f10672k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f10673l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final je.o f10674m;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10675a;

        static {
            int[] iArr = new int[k.values().length];
            f10675a = iArr;
            try {
                iArr[k.Background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10675a[k.Foreground.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(Context context, je.o oVar, vd.b bVar, k kVar, o oVar2, l lVar, Intent intent, wd.c cVar) {
        Boolean bool = Boolean.FALSE;
        this.f10670i = bool;
        this.f10671j = bool;
        this.f10672k = 0L;
        this.f10673l = 0L;
        this.f10663b = new WeakReference<>(context);
        this.f10664c = bVar;
        this.f10665d = oVar2;
        this.f10666e = kVar;
        this.f10668g = lVar;
        this.f10667f = intent;
        this.f10669h = cVar;
        this.f10672k = System.nanoTime();
        this.f10674m = oVar;
    }

    public static void l(Context context, vd.b bVar, k kVar, l lVar, wd.c cVar) {
        m(context, bVar, lVar.f8412l.W, kVar, lVar, null, cVar);
    }

    public static void m(Context context, vd.b bVar, o oVar, k kVar, l lVar, Intent intent, wd.c cVar) {
        if (lVar == null) {
            throw ae.b.e().c(f10662n, "INVALID_ARGUMENTS", "Notification cannot be empty or null", "arguments.invalid.sender.notificationModel");
        }
        new c(context, je.o.c(), bVar, kVar, oVar, lVar, intent, cVar).c(lVar);
    }

    public final l i(l lVar) {
        l lVarQ = this.f10668g.Q();
        lVarQ.f8412l.f8380l = Integer.valueOf(i.c());
        g gVar = lVarQ.f8412l;
        gVar.V = j.Default;
        gVar.f8392x = null;
        gVar.f8394z = null;
        lVarQ.f8410e = true;
        return lVarQ;
    }

    @Override // ie.d
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public ge.b a() {
        l lVar = this.f10668g;
        if (lVar == null) {
            return null;
        }
        this.f10670i = Boolean.valueOf(lVar.f8412l.U(this.f10666e, this.f10665d));
        if (!this.f10674m.e(this.f10668g.f8412l.f8382n).booleanValue() || !this.f10674m.e(this.f10668g.f8412l.f8383o).booleanValue()) {
            this.f10671j = Boolean.valueOf(this.f10668g.f8412l.V(this.f10666e));
            this.f10668g = n(this.f10663b.get(), this.f10668g, this.f10667f);
        }
        if (this.f10668g != null) {
            return new ge.b(this.f10668g.f8412l, this.f10667f);
        }
        return null;
    }

    @Override // ie.d
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public ge.b e(ge.b bVar) {
        if (bVar != null) {
            if (this.f10670i.booleanValue()) {
                p.c(this.f10663b.get(), bVar.f8380l);
                ud.a.c().g(this.f10663b.get(), bVar);
            }
            if (this.f10671j.booleanValue()) {
                ud.a.c().i(this.f10663b.get(), bVar);
            }
        }
        if (this.f10673l == 0) {
            this.f10673l = System.nanoTime();
        }
        if (rd.a.f15359i.booleanValue()) {
            long j10 = (this.f10673l - this.f10672k) / 1000000;
            ArrayList arrayList = new ArrayList();
            if (this.f10670i.booleanValue()) {
                arrayList.add("created");
            }
            if (this.f10671j.booleanValue()) {
                arrayList.add("displayed");
            }
            de.a.a(f10662n, "Notification " + this.f10674m.f(arrayList.iterator(), " and ") + " in " + j10 + "ms");
        }
        return bVar;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0022  */
    public l n(Context context, l lVar, Intent intent) throws ae.a {
        Boolean bool;
        int i10 = a.f10675a[rd.a.D().ordinal()];
        boolean zBooleanValue = true;
        if (i10 != 1) {
            if (i10 == 2) {
                bool = lVar.f8412l.E;
            }
            if (zBooleanValue) {
                Notification notificationE = this.f10664c.e(context, intent, lVar);
                if (lVar.f8412l.V == j.Default && StatusBarManager.k(context).n(lVar.f8412l.f8388t)) {
                    l lVarI = i(lVar);
                    StatusBarManager.k(context).B(context, lVarI, this.f10664c.e(context, intent, lVarI));
                }
                StatusBarManager.k(context).B(context, lVar, notificationE);
            }
            return lVar;
        }
        bool = lVar.f8412l.F;
        zBooleanValue = bool.booleanValue();
        if (zBooleanValue) {
            Notification notificationE2 = this.f10664c.e(context, intent, lVar);
            if (lVar.f8412l.V == j.Default) {
                l lVarI2 = i(lVar);
                StatusBarManager.k(context).B(context, lVarI2, this.f10664c.e(context, intent, lVarI2));
            }
            StatusBarManager.k(context).B(context, lVar, notificationE2);
        }
        return lVar;
    }

    @Override // ie.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void h(ge.b bVar, ae.a aVar) {
        wd.c cVar = this.f10669h;
        if (cVar != null) {
            cVar.a(bVar != null, aVar);
        }
    }
}
