package qd;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import fb.j;
import fb.l;
import fb.m;
import fb.n;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import je.k;
import je.o;

/* JADX INFO: loaded from: classes2.dex */
public class b implements xa.a, j.c, m, ya.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ya.c f14936a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f14939d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public rd.a f14941f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f14937b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f14938c = new C0260b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ce.b f14940e = new c();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final o f14942l = o.c();

    public class a implements n {
        public a() {
        }

        @Override // fb.n
        public boolean onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
            ee.n.e().l(i10, strArr, iArr);
            return true;
        }
    }

    /* JADX INFO: renamed from: qd.b$b, reason: collision with other inner class name */
    public class C0260b implements l {
        public C0260b() {
        }

        @Override // fb.l
        public boolean onActivityResult(int i10, int i11, Intent intent) throws InterruptedException {
            ee.n.e().k(i10, i11, intent);
            return true;
        }
    }

    public class c implements ce.b {
        public c() {
        }

        @Override // ce.b
        public void a(String str, Map<String, Object> map) {
            if (b.this.f14939d != null) {
                if ("silentAction".equals(str)) {
                    try {
                        map.put("actionHandle", b.this.f14941f != null ? b.this.f14941f.B() : null);
                    } catch (ae.a unused) {
                    }
                }
                b.this.f14939d.c(str, map);
            }
        }
    }

    public class d implements wd.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j.d f14946a;

        public d(j.d dVar) {
            this.f14946a = dVar;
        }

        @Override // wd.b
        public void a(byte[] bArr, ae.a aVar) {
            if (aVar != null) {
                this.f14946a.b(aVar.a(), aVar.getMessage(), aVar.b());
            } else {
                this.f14946a.a(bArr);
            }
        }
    }

    public class e implements wd.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j.d f14948a;

        public e(j.d dVar) {
            this.f14948a = dVar;
        }

        @Override // wd.d
        public void a(List<String> list) {
            this.f14948a.a(list);
        }
    }

    public class f implements wd.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j.d f14950a;

        public f(j.d dVar) {
            this.f14950a = dVar;
        }

        @Override // wd.d
        public void a(List<String> list) {
            this.f14950a.a(list);
        }
    }

    public class g implements wd.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j.d f14952a;

        public g(j.d dVar) {
            this.f14952a = dVar;
        }

        @Override // wd.d
        public void a(List<String> list) {
            this.f14952a.a(list);
        }
    }

    public class h implements wd.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j.d f14954a;

        public h(j.d dVar) {
            this.f14954a = dVar;
        }

        @Override // wd.d
        public void a(List<String> list) {
            this.f14954a.a(list);
        }
    }

    public class i implements wd.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j.d f14956a;

        public i(j.d dVar) {
            this.f14956a = dVar;
        }

        @Override // wd.c
        public void a(boolean z10, ae.a aVar) {
            if (aVar != null) {
                this.f14956a.b(aVar.a(), aVar.getLocalizedMessage(), aVar.b());
            } else {
                this.f14956a.a(Boolean.valueOf(z10));
            }
        }
    }

    public final void A(fb.i iVar, j.d dVar) {
        dVar.a(this.f14941f.I());
    }

    public final void B(fb.i iVar, j.d dVar) throws ae.a {
        Map map = (Map) je.l.a(iVar.b(), Map.class).g();
        if (map == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Schedule data is invalid", "arguments.invalid.schedule.data");
        }
        Map map2 = (Map) je.l.b(map, "schedule", Map.class).g();
        if (map2 == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Schedule data is invalid", "arguments.invalid.schedule.data");
        }
        fe.m mVarS = fe.m.S(map2);
        if (mVarS == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Schedule data is invalid", "arguments.invalid.schedule.data");
        }
        Calendar calendarJ = this.f14941f.J(mVarS, (Calendar) je.l.b(map, "fixedDate", Calendar.class).f(je.d.g().e()));
        dVar.a(calendarJ == null ? null : je.d.g().d(calendarJ));
    }

    public final void C(fb.i iVar, j.d dVar) {
        dVar.a(this.f14941f.L());
    }

    public final void D(fb.i iVar, j.d dVar) {
        dVar.a(Integer.valueOf(this.f14941f.M()));
    }

    public final void E(fb.i iVar, j.d dVar) throws ae.a {
        Map map = (Map) iVar.b();
        if (map == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "MISSING_ARGUMENTS", "Arguments are missing", "arguments.required");
        }
        String str = (String) map.get("defaultIcon");
        List<Object> list = (List) map.get("initializeChannels");
        List<Object> list2 = (List) map.get("initializeChannelGroups");
        Boolean bool = (Boolean) map.get("debug");
        Boolean boolValueOf = Boolean.valueOf(bool != null && bool.booleanValue());
        Object obj = map.get("awesomeDartBGHandle");
        this.f14941f.O(str, list, list2, Long.valueOf(obj == null ? 0L : ((Number) obj).longValue()), boolValueOf.booleanValue());
        if (rd.a.f15359i.booleanValue()) {
            de.a.a("AwesomeNotificationsPlugin", "Awesome Notifications Flutter plugin initialized");
        }
        dVar.a(Boolean.TRUE);
    }

    public final void F(fb.i iVar, j.d dVar) throws ae.a {
        Integer num = (Integer) iVar.b();
        if (num == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "MISSING_ARGUMENTS", "Id is required", "arguments.required");
        }
        dVar.a(Boolean.valueOf(this.f14941f.Q(num.intValue())));
    }

    public final void G(fb.i iVar, j.d dVar) {
        List<fe.l> listR = this.f14941f.R();
        ArrayList arrayList = new ArrayList();
        if (listR != null) {
            Iterator<fe.l> it = listR.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().O());
            }
        }
        dVar.a(arrayList);
    }

    public final void H(fb.i iVar, j.d dVar) throws ae.a {
        String str;
        String str2 = (String) iVar.b();
        if (this.f14942l.e(str2).booleanValue()) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Empty channel key", "arguments.invalid.channel.key");
        }
        boolean zW = this.f14941f.W(str2);
        if (rd.a.f15359i.booleanValue()) {
            if (zW) {
                str = "Channel removed";
            } else {
                str = "Channel '" + str2 + "' not found";
            }
            de.a.a("AwesomeNotificationsPlugin", str);
        }
        dVar.a(Boolean.valueOf(zW));
    }

    public final void I(fb.i iVar, j.d dVar) {
        this.f14941f.Y();
        dVar.a(null);
    }

    public final void J(fb.i iVar, j.d dVar) throws ae.a {
        int iIntValue = ((Integer) je.l.a(iVar.b(), Integer.class).f(-1)).intValue();
        if (iIntValue < 0) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Invalid Badge value", "arguments.invalid.badge.value");
        }
        this.f14941f.d0(Integer.valueOf(iIntValue));
        dVar.a(Boolean.TRUE);
    }

    public final void K(fb.i iVar, j.d dVar) throws ae.a {
        Map<String, Object> map = (Map) je.l.a(iVar.b(), Map.class).g();
        if (map == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Channel data is missing", "arguments.invalid.channel.data");
        }
        fe.f fVarB = new fe.f().b(map);
        if (fVarB == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Channel data is invalid", "arguments.invalid.channel.data");
        }
        Object obj = map.get("forceUpdate");
        dVar.a(Boolean.valueOf(this.f14941f.Z(fVarB, obj != null && Boolean.parseBoolean(obj.toString()))));
    }

    public final void L(fb.i iVar, j.d dVar) throws ae.a {
        Map map = (Map) iVar.b();
        if (map == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "MISSING_ARGUMENTS", "Arguments are missing", "arguments.required");
        }
        Object obj = map.get("createdHandle");
        Object obj2 = map.get("displayedHandle");
        Object obj3 = map.get("actionHandle");
        Object obj4 = map.get("dismissedHandle");
        long jLongValue = obj == null ? 0L : ((Number) obj).longValue();
        long jLongValue2 = obj2 == null ? 0L : ((Number) obj2).longValue();
        long jLongValue3 = obj3 == null ? 0L : ((Number) obj3).longValue();
        long jLongValue4 = obj4 == null ? 0L : ((Number) obj4).longValue();
        this.f14941f.g(this.f14940e);
        this.f14941f.c0(Long.valueOf(jLongValue), Long.valueOf(jLongValue2), Long.valueOf(jLongValue3), Long.valueOf(jLongValue4));
        boolean z10 = jLongValue3 != 0;
        if (!z10) {
            de.a.e("AwesomeNotificationsPlugin", "Attention: there is no valid static method to receive notification actions in background");
        }
        dVar.a(Boolean.valueOf(z10));
    }

    public final void M(fb.i iVar, j.d dVar) {
        dVar.a(Boolean.valueOf(this.f14941f.e0((String) iVar.b())));
    }

    public final void N(fb.i iVar, j.d dVar) throws ae.a {
        Map map = (Map) je.l.a(iVar.b(), Map.class).g();
        if (map == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "MISSING_ARGUMENTS", "Arguments are missing", "arguments.required");
        }
        String str = (String) map.get("channelKey");
        List<String> list = (List) map.get("permissions");
        if (list == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Permission list is required", "arguments.required.permissionList");
        }
        if (list.isEmpty()) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Permission list cannot be empty", "arguments.required.permissionList");
        }
        dVar.a(this.f14941f.f0(str, list));
    }

    public final void O(fb.i iVar, j.d dVar) throws ae.a {
        Map<String, Object> map = (Map) je.l.a(iVar.b(), Map.class).g();
        if (map == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "MISSING_ARGUMENTS", "Arguments are missing", "arguments.required");
        }
        fe.l lVarB = new fe.l().b((Map) map.get("notificationModel"));
        if (lVarB == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Foreground notification is invalid", "arguments.invalid.notificationModel");
        }
        zd.d dVarO = lVarB.o(map, "startMode", zd.d.class, zd.d.stick);
        zd.c cVarN = lVarB.n(map, "foregroundServiceType", zd.c.class, zd.c.none);
        if (dVarO == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Foreground start type is required", "arguments.invalid.foreground.startType");
        }
        if (cVarN == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "foregroundServiceType is required", "arguments.invalid.foreground.serviceType");
        }
        this.f14941f.j0(lVarB, dVarO, cVarN);
    }

    public final void P(fb.i iVar, j.d dVar) {
        this.f14941f.k0((Integer) iVar.a("id"));
        dVar.a(null);
    }

    public final void Q(fb.i iVar, j.d dVar) throws ae.a {
        Map map = (Map) je.l.a(iVar.b(), Map.class).g();
        if (map == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "MISSING_ARGUMENTS", "Arguments are missing", "arguments.required");
        }
        if (!map.containsKey("permissions")) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Permission list is required", "arguments.required.permissionList");
        }
        String str = (String) map.get("channelKey");
        List<String> list = (List) map.get("permissions");
        if (k.a(list)) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Permission list is required", "arguments.required.permissionList");
        }
        this.f14941f.X(this.f14936a.g(), str, list, new h(dVar));
    }

    public final void R(fb.i iVar, j.d dVar) {
        this.f14941f.i0(new f(dVar));
    }

    public final void S(fb.i iVar, j.d dVar) {
        this.f14941f.g0(new g(dVar));
    }

    public final void T(fb.i iVar, j.d dVar) {
        this.f14941f.h0((String) iVar.b(), new e(dVar));
    }

    public final void U(Context context) {
        this.f14939d.e(null);
        this.f14939d = null;
        rd.a aVar = this.f14941f;
        if (aVar != null) {
            aVar.v(this.f14940e);
            this.f14941f.A();
            this.f14941f = null;
        }
        if (rd.a.f15359i.booleanValue()) {
            de.a.a("AwesomeNotificationsPlugin", "Awesome Notifications plugin detached from Android " + Build.VERSION.SDK_INT);
        }
    }

    public final void a(Context context, j jVar) {
        this.f14939d = jVar;
        jVar.e(this);
        try {
            qd.a.b();
            this.f14941f = new rd.a(context);
            if (rd.a.f15359i.booleanValue()) {
                de.a.a("AwesomeNotificationsPlugin", "Awesome Notifications plugin attached to Android " + Build.VERSION.SDK_INT);
            }
        } catch (ae.a unused) {
        } catch (Exception e10) {
            ae.b.e().g("AwesomeNotificationsPlugin", "UNKNOWN_EXCEPTION", "An exception was found while attaching awesome notifications plugin", e10);
        }
    }

    public final void d(fb.i iVar, j.d dVar) {
        dVar.a(this.f14941f.e());
    }

    public final void e(fb.i iVar, j.d dVar) {
        this.f14941f.h();
        if (rd.a.f15359i.booleanValue()) {
            de.a.a("AwesomeNotificationsPlugin", "All notifications was cancelled");
        }
        dVar.a(Boolean.TRUE);
    }

    public final void f(fb.i iVar, j.d dVar) {
        this.f14941f.i();
        if (rd.a.f15359i.booleanValue()) {
            de.a.a("AwesomeNotificationsPlugin", "All notifications scheduled was cancelled");
        }
        dVar.a(Boolean.TRUE);
    }

    public final void g(fb.i iVar, j.d dVar) throws ae.a {
        StringBuilder sb2;
        String str;
        Integer num = (Integer) iVar.b();
        if (num == null || num.intValue() < 0) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Invalid id value", "arguments.invalid.dismiss.id");
        }
        boolean zJ = this.f14941f.j(num);
        if (rd.a.f15359i.booleanValue()) {
            if (zJ) {
                sb2 = new StringBuilder();
                sb2.append("Notification ");
                sb2.append(num);
                str = " cancelled";
            } else {
                sb2 = new StringBuilder();
                sb2.append("Notification ");
                sb2.append(num);
                str = " was not found";
            }
            sb2.append(str);
            de.a.a("AwesomeNotificationsPlugin", sb2.toString());
        }
        dVar.a(Boolean.valueOf(zJ));
    }

    public final void h(fb.i iVar, j.d dVar) throws ae.a {
        StringBuilder sb2;
        String str;
        String str2 = (String) iVar.b();
        if (this.f14942l.e(str2).booleanValue()) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Invalid channel Key value", "arguments.invalid.dismiss.channelKey");
        }
        boolean zK = this.f14941f.k(str2);
        if (rd.a.f15359i.booleanValue()) {
            if (zK) {
                sb2 = new StringBuilder();
                sb2.append("Notifications and schedules from channel ");
                sb2.append(str2);
                str = " canceled";
            } else {
                sb2 = new StringBuilder();
                sb2.append("Notifications and schedules from channel ");
                sb2.append(str2);
                str = " not found";
            }
            sb2.append(str);
            de.a.a("AwesomeNotificationsPlugin", sb2.toString());
        }
        dVar.a(Boolean.valueOf(zK));
    }

    public final void i(fb.i iVar, j.d dVar) throws ae.a {
        StringBuilder sb2;
        String str;
        String str2 = (String) iVar.b();
        if (this.f14942l.e(str2).booleanValue()) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Invalid groupKey value", "arguments.invalid.dismiss.groupKey");
        }
        boolean zL = this.f14941f.l(str2);
        if (rd.a.f15359i.booleanValue()) {
            if (zL) {
                sb2 = new StringBuilder();
                sb2.append("Notifications and schedules from group ");
                sb2.append(str2);
                str = " canceled";
            } else {
                sb2 = new StringBuilder();
                sb2.append("Notifications and schedules from group ");
                sb2.append(str2);
                str = " not found to be";
            }
            sb2.append(str);
            de.a.a("AwesomeNotificationsPlugin", sb2.toString());
        }
        dVar.a(Boolean.valueOf(zL));
    }

    public final void j(fb.i iVar, j.d dVar) throws ae.a {
        StringBuilder sb2;
        String str;
        Integer num = (Integer) iVar.b();
        if (num == null || num.intValue() < 0) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Invalid id value", "arguments.invalid.dismiss.id");
        }
        boolean zM = this.f14941f.m(num);
        if (rd.a.f15359i.booleanValue()) {
            if (zM) {
                sb2 = new StringBuilder();
                sb2.append("Schedule ");
                sb2.append(num);
                str = " cancelled";
            } else {
                sb2 = new StringBuilder();
                sb2.append("Schedule ");
                sb2.append(num);
                str = " was not found";
            }
            sb2.append(str);
            de.a.a("AwesomeNotificationsPlugin", sb2.toString());
        }
        dVar.a(Boolean.valueOf(zM));
    }

    public final void k(fb.i iVar, j.d dVar) throws ae.a {
        StringBuilder sb2;
        String str;
        String str2 = (String) iVar.b();
        if (this.f14942l.e(str2).booleanValue()) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Invalid channel Key value", "arguments.invalid.dismiss.channelKey");
        }
        boolean zN = this.f14941f.n(str2);
        if (rd.a.f15359i.booleanValue()) {
            if (zN) {
                sb2 = new StringBuilder();
                sb2.append("Scheduled Notifications from channel ");
                sb2.append(str2);
                str = " canceled";
            } else {
                sb2 = new StringBuilder();
                sb2.append("Scheduled Notifications from channel ");
                sb2.append(str2);
                str = " not found";
            }
            sb2.append(str);
            de.a.a("AwesomeNotificationsPlugin", sb2.toString());
        }
        dVar.a(Boolean.valueOf(zN));
    }

    public final void l(fb.i iVar, j.d dVar) throws ae.a {
        StringBuilder sb2;
        String str;
        String str2 = (String) iVar.b();
        if (this.f14942l.e(str2).booleanValue()) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Invalid groupKey value", "arguments.invalid.dismiss.groupKey");
        }
        boolean zO = this.f14941f.o(str2);
        if (rd.a.f15359i.booleanValue()) {
            if (zO) {
                sb2 = new StringBuilder();
                sb2.append("Scheduled Notifications from group ");
                sb2.append(str2);
                str = " canceled";
            } else {
                sb2 = new StringBuilder();
                sb2.append("Scheduled Notifications from group ");
                sb2.append(str2);
                str = " not found";
            }
            sb2.append(str);
            de.a.a("AwesomeNotificationsPlugin", sb2.toString());
        }
        dVar.a(Boolean.valueOf(zO));
    }

    public final void m(fb.i iVar, j.d dVar) throws ae.a {
        Map map = (Map) je.l.a(iVar.b(), Map.class).g();
        if (map == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "MISSING_ARGUMENTS", "Arguments are missing", "arguments.required");
        }
        String str = (String) map.get("channelKey");
        List<String> list = (List) map.get("permissions");
        if (k.a(list)) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Permission list is required", "arguments.required.permissionList");
        }
        dVar.a(this.f14941f.f(str, list));
    }

    public final void n(fb.i iVar, j.d dVar) {
        this.f14941f.s();
        dVar.a(null);
    }

    public final void o(fb.i iVar, j.d dVar) throws ae.a {
        Map<String, Object> map = (Map) iVar.b();
        if (map == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "MISSING_ARGUMENTS", "Arguments are missing", "arguments.required");
        }
        fe.l lVarB = new fe.l().b(map);
        if (lVarB == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Notification content is invalid", "arguments.required.notificationModel.data");
        }
        this.f14941f.t(lVarB, new i(dVar));
    }

    @Override // ya.a
    public void onAttachedToActivity(ya.c cVar) {
        try {
            this.f14936a = cVar;
            cVar.h(this.f14937b);
            this.f14936a.b(this.f14938c);
            rd.a aVar = this.f14941f;
            if (aVar != null) {
                aVar.p(cVar.g());
            }
            this.f14936a.e(this);
        } catch (Exception e10) {
            ae.b.e().g("AwesomeNotificationsPlugin", "UNKNOWN_EXCEPTION", "unexpectedError.fcm." + e10.getClass().getSimpleName(), e10);
        }
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        a(bVar.a(), new j(bVar.b(), "awesome_notifications"));
        if (rd.a.f15359i.booleanValue()) {
            de.a.a("AwesomeNotificationsPlugin", "Awesome Notifications attached to engine for Android " + Build.VERSION.SDK_INT);
        }
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
        this.f14936a.f(this.f14937b);
        this.f14936a.d(this.f14938c);
        this.f14936a.c(this);
        this.f14936a = null;
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        this.f14936a.f(this.f14937b);
        this.f14936a.d(this.f14938c);
        this.f14936a.c(this);
        this.f14936a = null;
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        U(bVar.a());
    }

    /* JADX WARN: Code duplicated, block: B:138:0x0221  */
    @Override // fb.j.c
    public void onMethodCall(fb.i iVar, j.d dVar) {
        ae.a e10;
        if (this.f14941f == null) {
            ae.a aVarC = ae.b.e().c("AwesomeNotificationsPlugin", "INITIALIZATION_EXCEPTION", "Awesome notifications is currently not available", "initialization.awesomeNotifications.core");
            dVar.b(aVarC.a(), aVarC.getMessage(), aVarC.b());
        }
        try {
            switch (iVar.f8284a) {
                case "initialize":
                    E(iVar, dVar);
                    break;
                case "setEventHandles":
                    L(iVar, dVar);
                    break;
                case "getDrawableData":
                    w(iVar, dVar);
                    break;
                case "isNotificationAllowed":
                    d(iVar, dVar);
                    break;
                case "showNotificationPage":
                    T(iVar, dVar);
                    break;
                case "showAlarmPage":
                    R(iVar, dVar);
                    break;
                case "showGlobalDndPage":
                    S(iVar, dVar);
                    break;
                case "checkPermissions":
                    m(iVar, dVar);
                    break;
                case "shouldShowRationale":
                    N(iVar, dVar);
                    break;
                case "requestNotifications":
                    Q(iVar, dVar);
                    break;
                case "isNotificationActive":
                    F(iVar, dVar);
                    break;
                case "getAllActiveNotificationIds":
                    u(iVar, dVar);
                    break;
                case "createNewNotification":
                    o(iVar, dVar);
                    break;
                case "listAllSchedules":
                    G(iVar, dVar);
                    break;
                case "getInitialAction":
                    x(iVar, dVar);
                    break;
                case "clearStoredActions":
                    n(iVar, dVar);
                    break;
                case "getNextDate":
                    B(iVar, dVar);
                    break;
                case "getLocalTimeZoneIdentifier":
                    z(iVar, dVar);
                    break;
                case "getUtcTimeZoneIdentifier":
                    C(iVar, dVar);
                    break;
                case "getAppLifeCycle":
                    y(iVar, dVar);
                    break;
                case "setNotificationChannel":
                    K(iVar, dVar);
                    break;
                case "removeNotificationChannel":
                    H(iVar, dVar);
                    break;
                case "getBadgeCount":
                    v(iVar, dVar);
                    break;
                case "setBadgeCount":
                    J(iVar, dVar);
                    break;
                case "incBadgeCount":
                    D(iVar, dVar);
                    break;
                case "decBadgeCount":
                    p(iVar, dVar);
                    break;
                case "resetBadge":
                    I(iVar, dVar);
                    break;
                case "setLocalization":
                    M(iVar, dVar);
                    break;
                case "getLocalization":
                    A(iVar, dVar);
                    break;
                case "dismissNotification":
                    r(iVar, dVar);
                    break;
                case "cancelNotification":
                    g(iVar, dVar);
                    break;
                case "cancelSchedule":
                    j(iVar, dVar);
                    break;
                case "dismissNotificationsByChannelKey":
                    s(iVar, dVar);
                    break;
                case "cancelSchedulesByChannelKey":
                    k(iVar, dVar);
                    break;
                case "cancelNotificationsByChannelKey":
                    h(iVar, dVar);
                    break;
                case "dismissNotificationsByGroupKey":
                    t(iVar, dVar);
                    break;
                case "cancelSchedulesByGroupKey":
                    l(iVar, dVar);
                    break;
                case "cancelNotificationsByGroupKey":
                    i(iVar, dVar);
                    break;
                case "dismissAllNotifications":
                    q(iVar, dVar);
                    break;
                case "cancelAllSchedules":
                    f(iVar, dVar);
                    break;
                case "cancelAllNotifications":
                    e(iVar, dVar);
                    break;
                case "startForeground":
                    O(iVar, dVar);
                    break;
                case "stopForeground":
                    P(iVar, dVar);
                    break;
                default:
                    dVar.c();
                    break;
            }
        } catch (ae.a e11) {
            e10 = e11;
            dVar.b(e10.a(), e10.getMessage(), e10.b());
        } catch (Exception e12) {
            e10 = ae.b.e().b("AwesomeNotificationsPlugin", "UNKNOWN_EXCEPTION", "unexpectedError." + e12.getClass().getSimpleName(), e12);
            dVar.b(e10.a(), e10.getMessage(), e10.b());
        }
    }

    @Override // fb.m
    public boolean onNewIntent(Intent intent) {
        try {
            return this.f14941f.q(intent);
        } catch (Exception e10) {
            ae.b.e().g("AwesomeNotificationsPlugin", "UNKNOWN_EXCEPTION", "unexpectedError.fcm." + e10.getClass().getSimpleName(), e10);
            return false;
        }
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(ya.c cVar) {
        this.f14936a = cVar;
        cVar.h(this.f14937b);
        this.f14936a.b(this.f14938c);
        this.f14936a.e(this);
    }

    public final void p(fb.i iVar, j.d dVar) {
        dVar.a(Integer.valueOf(this.f14941f.u()));
    }

    public final void q(fb.i iVar, j.d dVar) {
        this.f14941f.w();
        if (rd.a.f15359i.booleanValue()) {
            de.a.a("AwesomeNotificationsPlugin", "All notifications was dismissed");
        }
        dVar.a(Boolean.TRUE);
    }

    public final void r(fb.i iVar, j.d dVar) throws ae.a {
        StringBuilder sb2;
        String str;
        Integer num = (Integer) iVar.b();
        if (num == null || num.intValue() < 0) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Invalid id value", "arguments.invalid.dismiss.id");
        }
        boolean zX = this.f14941f.x(num);
        if (rd.a.f15359i.booleanValue()) {
            if (zX) {
                sb2 = new StringBuilder();
                sb2.append("Notification ");
                sb2.append(num);
                str = " dismissed";
            } else {
                sb2 = new StringBuilder();
                sb2.append("Notification ");
                sb2.append(num);
                str = " was not found";
            }
            sb2.append(str);
            de.a.a("AwesomeNotificationsPlugin", sb2.toString());
        }
        dVar.a(Boolean.valueOf(zX));
    }

    public final void s(fb.i iVar, j.d dVar) throws ae.a {
        StringBuilder sb2;
        String str;
        String str2 = (String) iVar.b();
        if (this.f14942l.e(str2).booleanValue()) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Invalid channel Key value", "arguments.invalid.dismiss.channelKey");
        }
        boolean zY = this.f14941f.y(str2);
        if (rd.a.f15359i.booleanValue()) {
            if (zY) {
                sb2 = new StringBuilder();
                sb2.append("Notifications from channel ");
                sb2.append(str2);
                str = " dismissed";
            } else {
                sb2 = new StringBuilder();
                sb2.append("Notifications from channel ");
                sb2.append(str2);
                str = " not found";
            }
            sb2.append(str);
            de.a.a("AwesomeNotificationsPlugin", sb2.toString());
        }
        dVar.a(Boolean.valueOf(zY));
    }

    public final void t(fb.i iVar, j.d dVar) throws ae.a {
        StringBuilder sb2;
        String str;
        String str2 = (String) iVar.b();
        if (this.f14942l.e(str2).booleanValue()) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Invalid groupKey value", "arguments.invalid.dismiss.groupKey");
        }
        boolean z10 = this.f14941f.z(str2);
        if (rd.a.f15359i.booleanValue()) {
            if (z10) {
                sb2 = new StringBuilder();
                sb2.append("Notifications from group ");
                sb2.append(str2);
                str = " dismissed";
            } else {
                sb2 = new StringBuilder();
                sb2.append("Notifications from group ");
                sb2.append(str2);
                str = " not found";
            }
            sb2.append(str);
            de.a.a("AwesomeNotificationsPlugin", sb2.toString());
        }
        dVar.a(Boolean.valueOf(z10));
    }

    public final void u(fb.i iVar, j.d dVar) {
        dVar.a(this.f14941f.C());
    }

    public final void v(fb.i iVar, j.d dVar) {
        dVar.a(Integer.valueOf(this.f14941f.F()));
    }

    public final void w(fb.i iVar, j.d dVar) throws ae.a {
        String str = (String) iVar.b();
        if (str == null) {
            throw ae.b.e().c("AwesomeNotificationsPlugin", "INVALID_ARGUMENTS", "Bitmap reference is required", "arguments.invalid.bitmapReference");
        }
        this.f14941f.E(str, new d(dVar));
    }

    public final void x(fb.i iVar, j.d dVar) {
        ge.a aVarG = this.f14941f.G(!Boolean.FALSE.equals(iVar.b()));
        dVar.a(aVarG == null ? null : aVarG.O());
    }

    public final void y(fb.i iVar, j.d dVar) {
        dVar.a(rd.a.D().h());
    }

    public final void z(fb.i iVar, j.d dVar) {
        dVar.a(this.f14941f.H());
    }
}
