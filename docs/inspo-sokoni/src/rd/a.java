package rd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.media.session.MediaSessionCompat;
import ce.d;
import ce.e;
import ee.l;
import ee.n;
import ee.p;
import fe.f;
import fe.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import je.j;
import je.o;
import me.carda.awesome_notifications.core.managers.StatusBarManager;
import me.carda.awesome_notifications.core.services.ForegroundService;
import td.g;
import zd.k;

/* JADX INFO: loaded from: classes2.dex */
public class a implements e, ce.a, d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Class f15363m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f15364n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static b f15365o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f15370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f15371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f15372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f15373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f15374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f15375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f15376g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k f15377h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Boolean f15359i = Boolean.FALSE;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Class f15360j = td.e.class;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Class f15361k = td.d.class;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Class f15362l = g.class;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f15366p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static List<e> f15367q = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static List<ce.a> f15368r = new ArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static List<ce.b> f15369s = new ArrayList();

    /* JADX INFO: renamed from: rd.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0269a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15378a;

        static {
            int[] iArr = new int[k.values().length];
            f15378a = iArr;
            try {
                iArr[k.Foreground.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15378a[k.Background.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15378a[k.Terminated.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public a(Context context) throws ae.a {
        K(context);
        f15359i = Boolean.valueOf(P(context));
        this.f15370a = new WeakReference<>(context);
        this.f15371b = o.c();
        ee.k.i().l(this).k();
        N(context);
        vd.b.m().g0(context).N(new MediaSessionCompat(context, "PUSH_MEDIA"));
    }

    public static k D() {
        return ee.k.h();
    }

    public static String K(Context context) {
        if (f15364n == null) {
            f15364n = context.getPackageName();
        }
        return f15364n;
    }

    public static void N(Context context) throws ae.a {
        if (f15366p) {
            return;
        }
        if (fe.a.f8326d.isEmpty()) {
            fe.a.f8326d.putAll(c.f15379a);
        }
        b bVar = f15365o;
        if (bVar == null) {
            throw ae.b.e().c("AwesomeNotifications", "CLASS_NOT_FOUND", "Awesome's plugin extension reference was not found.", "initialization.awesomeNotifications.extensions");
        }
        bVar.a(context);
        f15366p = true;
    }

    public void A() {
        ee.k.i().m(this);
    }

    public Long B() {
        return ee.g.f(this.f15370a.get()).b(this.f15370a.get());
    }

    public Collection<Integer> C() {
        return StatusBarManager.k(this.f15370a.get()).h();
    }

    public void E(String str, wd.b bVar) {
        new yd.a(this.f15370a.get(), str, bVar).b();
    }

    public int F() {
        return ee.b.c().b(this.f15370a.get());
    }

    public ge.a G(boolean z10) {
        ge.a aVarE = ee.a.f().e();
        if (!z10) {
            return aVarE;
        }
        if (aVarE == null) {
            return null;
        }
        Context context = this.f15370a.get();
        ee.a.f().h(context, aVarE.f8380l);
        ee.a.f().d(context);
        return aVarE;
    }

    public String H() {
        return je.d.g().h().getID();
    }

    public String I() {
        return l.a().b(this.f15370a.get());
    }

    public Calendar J(m mVar, Calendar calendar) {
        return mVar.R(calendar);
    }

    public Object L() {
        return je.d.g().k().getID();
    }

    public int M() {
        return ee.b.c().d(this.f15370a.get());
    }

    public void O(String str, List<Object> list, List<Object> list2, Long l10, boolean z10) throws ae.a {
        Context context = this.f15370a.get();
        ee.g.f(context).l(context, str);
        ee.g.f(context).k(context, l10);
        ee.g.f(context).a(context);
        if (!je.k.a(list2)) {
            a0(this.f15370a.get(), list2);
        }
        if (je.k.a(list)) {
            throw ae.b.e().c("AwesomeNotifications", "INITIALIZATION_EXCEPTION", "At least one channel is required", "arguments.required.channelList");
        }
        b0(context, list);
        f15359i = Boolean.valueOf(z10 && P(context));
        ie.b.s(context);
        if (f15359i.booleanValue()) {
            de.a.a("AwesomeNotifications", "Awesome Notifications initialized");
        }
    }

    public boolean P(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public boolean Q(int i10) {
        return StatusBarManager.k(this.f15370a.get()).p(i10);
    }

    public List<fe.l> R() {
        ie.b.s(this.f15370a.get());
        return p.n(this.f15370a.get());
    }

    public final void S(String str, ge.a aVar) {
        T(str, aVar);
        Iterator<ce.a> it = f15368r.iterator();
        while (it.hasNext()) {
            it.next().d(str, aVar);
        }
    }

    public final void T(String str, ge.a aVar) {
        Iterator<ce.b> it = f15369s.iterator();
        while (it.hasNext()) {
            it.next().a(str, aVar.O());
        }
    }

    public final void U(String str, ge.b bVar) {
        Iterator<ce.b> it = f15369s.iterator();
        while (it.hasNext()) {
            it.next().a(str, bVar.O());
        }
    }

    public final void V(String str, ge.b bVar) {
        U(str, bVar);
        Iterator<e> it = f15367q.iterator();
        while (it.hasNext()) {
            it.next().b(str, bVar);
        }
    }

    public boolean W(String str) {
        boolean zBooleanValue = ee.e.h().k(this.f15370a.get(), str).booleanValue();
        ee.e.h().c(this.f15370a.get());
        return zBooleanValue;
    }

    public void X(Activity activity, String str, List<String> list, wd.d dVar) {
        n.e().s(activity, this.f15370a.get(), str, list, dVar);
    }

    public void Y() {
        ee.b.c().h(this.f15370a.get());
    }

    public boolean Z(f fVar, boolean z10) {
        ee.e.h().o(this.f15370a.get(), fVar, Boolean.FALSE, Boolean.valueOf(z10)).c(this.f15370a.get());
        return true;
    }

    @Override // ce.a
    public boolean a(String str, ge.a aVar) {
        return false;
    }

    public final void a0(Context context, List<Object> list) throws ae.a {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof Map) {
                Map<String, Object> map = (Map) obj;
                fe.e eVarR = new fe.e().b(map);
                if (eVarR == null) {
                    throw ae.b.e().c("AwesomeNotifications", "INITIALIZATION_EXCEPTION", "Invalid channel group: " + j.g(map), "arguments.invalid.channelGroup.data");
                }
                arrayList.add(eVarR);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ee.d.b(context, (fe.e) it.next());
        }
        ee.e.h().c(context);
    }

    @Override // ce.e
    public void b(String str, ge.b bVar) {
        V(str, bVar);
    }

    public final void b0(Context context, List<Object> list) throws ae.a {
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (Object obj : list) {
            if (obj instanceof Map) {
                Map<String, Object> map = (Map) obj;
                f fVarS = new f().b(map);
                Object obj2 = map.get("forceUpdate");
                boolean z11 = obj2 != null && Boolean.parseBoolean(obj2.toString());
                if (fVarS == null) {
                    throw ae.b.e().c("AwesomeNotifications", "INVALID_ARGUMENTS", "Invalid channel: " + j.g(map), "arguments.invalid.channel.data");
                }
                arrayList.add(fVarS);
                z10 = z11;
            }
            if (obj instanceof f) {
                arrayList.add((f) obj);
            }
        }
        ee.e eVarH = ee.e.h();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            eVarH.o(context, (f) it.next(), Boolean.TRUE, Boolean.valueOf(z10));
        }
        eVarH.c(context);
    }

    @Override // ce.d
    public void c(k kVar) {
        if (this.f15376g) {
            if (C0269a.f15378a[kVar.ordinal()] == 1) {
                n.e().l(101, null, null);
                if (this.f15377h == k.Terminated) {
                    try {
                        ee.m.b().c(this.f15370a.get(), this.f15372c.longValue() > 0, this.f15373d.longValue() > 0, this.f15374e.longValue() > 0, this.f15375f.longValue() > 0);
                    } catch (ae.a unused) {
                        ae.b.e().h("AwesomeNotifications", "BACKGROUND_EXECUTION_EXCEPTION", "Was not possible to recover lost notification events", "unexpectedError.onNewLifeCycleEvent");
                    }
                }
            }
            this.f15377h = kVar;
        }
    }

    public void c0(Long l10, Long l11, Long l12, Long l13) {
        Context context = this.f15370a.get();
        ee.g gVarF = ee.g.f(this.f15370a.get());
        this.f15372c = l10;
        this.f15373d = l11;
        this.f15374e = l12;
        this.f15375f = l13;
        gVarF.j(context, l10);
        gVarF.n(context, l11);
        gVarF.i(context, l12);
        gVarF.m(context, l13);
        gVarF.a(context);
        if (l12.longValue() > 0) {
            ee.m.b().c(context, l10.longValue() > 0, l11.longValue() > 0, true, l13.longValue() > 0);
        }
    }

    @Override // ce.a
    public void d(String str, ge.a aVar) {
        S(str, aVar);
    }

    public void d0(Integer num) {
        ee.b.c().i(this.f15370a.get(), num.intValue());
    }

    public Object e() {
        return n.e().b(this.f15370a.get());
    }

    public boolean e0(String str) {
        return l.a().c(this.f15370a.get(), str);
    }

    public List<String> f(String str, List<String> list) {
        return n.e().c(this.f15370a.get(), str, list);
    }

    public List<String> f0(String str, List<String> list) {
        return n.e().u(this.f15370a.get(), str, list);
    }

    public void g(ce.b bVar) {
        if (this.f15376g) {
            return;
        }
        this.f15376g = true;
        l0(bVar);
        td.b.c().n(this).o(this);
        de.a.a("AwesomeNotifications", "Awesome notifications (" + hashCode() + ") attached to activity");
    }

    public void g0(wd.d dVar) {
        n.e().x(this.f15370a.get(), dVar);
    }

    public void h() {
        ee.c.m().a(this.f15370a.get());
    }

    public void h0(String str, wd.d dVar) {
        if (this.f15371b.e(str).booleanValue()) {
            n.e().y(this.f15370a.get(), dVar);
        } else {
            n.e().w(this.f15370a.get(), str, dVar);
        }
    }

    public void i() {
        ee.c.m().b(this.f15370a.get());
    }

    public void i0(wd.d dVar) {
        n.e().z(this.f15370a.get(), dVar);
    }

    public boolean j(Integer num) {
        return ee.c.m().c(this.f15370a.get(), num);
    }

    public void j0(fe.l lVar, zd.d dVar, zd.c cVar) {
        ForegroundService.b(this.f15370a.get(), lVar, dVar, cVar);
    }

    public boolean k(String str) {
        return ee.c.m().d(this.f15370a.get(), str);
    }

    public void k0(Integer num) {
        ForegroundService.c(num);
    }

    public boolean l(String str) {
        return ee.c.m().e(this.f15370a.get(), str);
    }

    public a l0(ce.b bVar) {
        f15369s.add(bVar);
        return this;
    }

    public boolean m(Integer num) {
        return ee.c.m().f(this.f15370a.get(), num);
    }

    public a m0(ce.b bVar) {
        f15369s.remove(bVar);
        return this;
    }

    public boolean n(String str) {
        return ee.c.m().g(this.f15370a.get(), str);
    }

    public boolean o(String str) {
        return ee.c.m().h(this.f15370a.get(), str);
    }

    public boolean p(Activity activity) {
        if (activity == null) {
            return false;
        }
        return r(activity.getIntent(), true);
    }

    public boolean q(Intent intent) {
        return r(intent, false);
    }

    public boolean r(Intent intent, boolean z10) {
        String action;
        if (intent == null || (action = intent.getAction()) == null) {
            return false;
        }
        boolean z11 = Boolean.valueOf("SELECT_NOTIFICATION".equals(action)).booleanValue() || Boolean.valueOf(action.startsWith("ACTION_NOTIFICATION")).booleanValue();
        if (z11) {
            td.e.d(this.f15370a.get(), intent, z10);
        }
        return z11;
    }

    public void s() {
        ee.a.f().i(this.f15370a.get());
    }

    public void t(fe.l lVar, wd.c cVar) throws ae.a {
        if (!n.e().b(this.f15370a.get()).booleanValue()) {
            throw ae.b.e().c("AwesomeNotifications", "INSUFFICIENT_PERMISSIONS", "Notifications are disabled", "insufficientPermissions.global");
        }
        if (lVar.f8413m == null) {
            ie.c.m(this.f15370a.get(), vd.b.m(), zd.o.Local, D(), lVar, null, cVar);
        } else {
            ie.b.u(this.f15370a.get(), zd.o.Schedule, lVar, cVar);
        }
    }

    public int u() {
        return ee.b.c().a(this.f15370a.get());
    }

    public void v(ce.b bVar) {
        if (this.f15376g) {
            this.f15376g = false;
            m0(bVar);
            td.b.c().q(this).p(this);
            de.a.a("AwesomeNotifications", "Awesome notifications (" + hashCode() + ") detached from activity");
        }
    }

    public void w() {
        ee.c.m().i(this.f15370a.get());
    }

    public boolean x(Integer num) {
        return ee.c.m().j(this.f15370a.get(), num);
    }

    public boolean y(String str) {
        return ee.c.m().k(this.f15370a.get(), str);
    }

    public boolean z(String str) {
        return ee.c.m().l(this.f15370a.get(), str);
    }
}
