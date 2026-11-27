package ee;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import e0.o0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static n f7963f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final je.o f7965b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7964a = "PermissionManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BlockingQueue<wd.a> f7966c = new LinkedBlockingDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f7967d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f7968e = new b();

    public class a extends ArrayList<String> {
        public a() {
            add(zd.l.Sound.toString());
            add(zd.l.CriticalAlert.toString());
            add(zd.l.OverrideDnD.toString());
        }
    }

    public class b extends ArrayList<String> {
        public b() {
            add(zd.l.FullScreenIntent.toString());
            add(zd.l.Provisional.toString());
        }
    }

    public class c implements wd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f7973c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ wd.d f7974d;

        public c(Context context, String str, List list, wd.d dVar) {
            this.f7971a = context;
            this.f7972b = str;
            this.f7973c = list;
            this.f7974d = dVar;
        }

        @Override // wd.a
        public void a() {
            n.this.r(this.f7971a, this.f7972b, this.f7973c, this.f7974d);
        }
    }

    public class d implements wd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f7978c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ wd.d f7979d;

        public d(Context context, String str, List list, wd.d dVar) {
            this.f7976a = context;
            this.f7977b = str;
            this.f7978c = list;
            this.f7979d = dVar;
        }

        @Override // wd.a
        public void a() {
            n.this.r(this.f7976a, this.f7977b, this.f7978c, this.f7979d);
        }
    }

    public class e implements wd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wd.d f7981a;

        public e(wd.d dVar) {
            this.f7981a = dVar;
        }

        @Override // wd.a
        public void a() {
            this.f7981a.a(new ArrayList());
        }
    }

    public class f implements wd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wd.d f7983a;

        public f(wd.d dVar) {
            this.f7983a = dVar;
        }

        @Override // wd.a
        public void a() {
            this.f7983a.a(new ArrayList());
        }
    }

    public class g implements wd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wd.d f7985a;

        public g(wd.d dVar) {
            this.f7985a = dVar;
        }

        @Override // wd.a
        public void a() {
            this.f7985a.a(new ArrayList());
        }
    }

    public class h implements wd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wd.d f7987a;

        public h(wd.d dVar) {
            this.f7987a = dVar;
        }

        @Override // wd.a
        public void a() {
            this.f7987a.a(new ArrayList());
        }
    }

    public static /* synthetic */ class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7989a;

        static {
            int[] iArr = new int[zd.l.values().length];
            f7989a = iArr;
            try {
                iArr[zd.l.PreciseAlarms.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7989a[zd.l.CriticalAlert.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7989a[zd.l.Badge.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7989a[zd.l.OverrideDnD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7989a[zd.l.Sound.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7989a[zd.l.FullScreenIntent.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7989a[zd.l.Alert.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7989a[zd.l.Vibration.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7989a[zd.l.Light.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7989a[zd.l.Provisional.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f7989a[zd.l.Car.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public n(je.o oVar) {
        this.f7965b = oVar;
    }

    public static n e() {
        if (f7963f == null) {
            f7963f = new n(je.o.c());
        }
        return f7963f;
    }

    public final boolean A(Context context, Intent intent) {
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return true;
        }
        ae.b.e().h("PermissionManager", "PAGE_NOT_FOUND", "Activity permission action '" + intent.getAction() + "' not found!", "pageNotFound.permissionPage." + intent.getAction());
        return false;
    }

    public final void B(Context context, String str, List<String> list) {
    }

    public Boolean b(Context context) {
        return Boolean.valueOf(o0.e(context).a());
    }

    public List<String> c(Context context, String str, List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (!b(context).booleanValue()) {
            return arrayList;
        }
        for (String str2 : list) {
            zd.l lVar = (zd.l) this.f7965b.b(zd.l.class, str2);
            if (lVar != null && q(context, lVar) && (str == null || p(context, str, lVar))) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public final void d() throws InterruptedException {
        wd.a aVarTake;
        if (this.f7966c.isEmpty()) {
            return;
        }
        if (rd.a.f15359i.booleanValue()) {
            de.a.a("PermissionManager", "New permissions request found waiting for user response");
        }
        int i10 = 3;
        do {
            aVarTake = null;
            try {
                if (!this.f7966c.isEmpty()) {
                    aVarTake = this.f7966c.take();
                }
            } catch (InterruptedException unused) {
                i10--;
            }
            if (aVarTake != null) {
                aVarTake.a();
                i10 = 3;
            }
            if (i10 <= 0) {
                return;
            }
        } while (aVarTake != null);
    }

    public final String f(zd.l lVar) {
        if (lVar == null) {
            if (Build.VERSION.SDK_INT >= 33) {
                return "android.permission.POST_NOTIFICATIONS";
            }
            return null;
        }
        int i10 = i.f7989a[lVar.ordinal()];
        if (i10 == 1) {
            if (Build.VERSION.SDK_INT >= 31) {
                return "android.permission.SCHEDULE_EXACT_ALARM";
            }
            return null;
        }
        if (i10 == 6 && Build.VERSION.SDK_INT >= 29) {
            return "android.permission.USE_FULL_SCREEN_INTENT";
        }
        return null;
    }

    public final boolean g(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", rd.a.K(context));
        intent.setFlags(268435456);
        return A(context, intent);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x003d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x003f  */
    public final boolean h(Context context, String str) {
        NotificationChannel notificationChannelD = ee.e.h().d(context, str);
        Intent intentPutExtra = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS").putExtra("android.provider.extra.APP_PACKAGE", rd.a.K(context));
        if (notificationChannelD == null) {
            if (!this.f7965b.e(str).booleanValue()) {
            }
            intentPutExtra.setFlags(268435456);
            if (A(context, intentPutExtra)) {
                return true;
            }
            return g(context);
        }
        str = notificationChannelD.getId();
        intentPutExtra.putExtra("android.provider.extra.CHANNEL_ID", str);
        intentPutExtra.setFlags(268435456);
        if (A(context, intentPutExtra)) {
            return true;
        }
        return g(context);
    }

    public final boolean i(Context context) {
        Intent intent = new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
        intent.setFlags(268435456);
        if (A(context, intent)) {
            return true;
        }
        return g(context);
    }

    public final boolean j(Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            Intent intent = new Intent();
            intent.setAction("android.settings.REQUEST_SCHEDULE_EXACT_ALARM");
            intent.putExtra("android.provider.extra.APP_PACKAGE", rd.a.K(context));
            intent.setData(Uri.parse("package:" + rd.a.K(context)));
            intent.setFlags(268435456);
            if (A(context, intent)) {
                return true;
            }
        }
        return g(context);
    }

    public boolean k(int i10, int i11, Intent intent) throws InterruptedException {
        if (i10 != 101) {
            return false;
        }
        d();
        return false;
    }

    public boolean l(int i10, String[] strArr, int[] iArr) {
        if (i10 != 101) {
            return false;
        }
        d();
        return true;
    }

    public boolean m(Context context) {
        return ee.e.h().f(context).getCurrentInterruptionFilter() != 3;
    }

    public boolean n(Context context) {
        return ((NotificationManager) context.getSystemService("notification")).isNotificationPolicyAccessGranted();
    }

    public boolean o(Context context) {
        int importance = ((NotificationManager) context.getSystemService("notification")).getImportance();
        return importance < 0 || importance >= 3;
    }

    public boolean p(Context context, String str, zd.l lVar) throws ae.a {
        NotificationChannel notificationChannelD = ee.e.h().d(context, str);
        if (notificationChannelD == null) {
            throw ae.b.e().c("PermissionManager", "INVALID_ARGUMENTS", "Channel " + str + " does not exist.", "arguments.invalid.channel.key");
        }
        if (notificationChannelD.getImportance() == 0) {
            return false;
        }
        int i10 = i.f7989a[lVar.ordinal()];
        if (i10 == 2) {
            return notificationChannelD.canBypassDnd();
        }
        if (i10 == 3) {
            return notificationChannelD.canShowBadge();
        }
        if (i10 == 5) {
            return notificationChannelD.getImportance() >= 3 && notificationChannelD.getSound() != null;
        }
        if (i10 == 7) {
            return notificationChannelD.getImportance() >= 4;
        }
        if (i10 == 8) {
            return notificationChannelD.getImportance() >= 3 && notificationChannelD.shouldVibrate();
        }
        if (i10 != 9) {
            return true;
        }
        return notificationChannelD.shouldShowLights();
    }

    public boolean q(Context context, zd.l lVar) {
        int i10 = i.f7989a[lVar.ordinal()];
        if (i10 == 1) {
            return p.j(context);
        }
        if (i10 == 2) {
            return m(context);
        }
        if (i10 == 3) {
            ee.b.c();
            return ee.b.c().g(context);
        }
        if (i10 == 4) {
            return n(context);
        }
        if (i10 == 5) {
            return o(context);
        }
        String strF = f(lVar);
        return strF == null || f0.a.checkSelfPermission(context, strF) == 0;
    }

    public final void r(Context context, String str, List<String> list, wd.d dVar) {
        try {
            if (!list.isEmpty()) {
                if (!this.f7965b.e(str).booleanValue()) {
                    B(context, str, c(context, str, list));
                }
                list.removeAll(c(context, str, list));
            }
        } catch (ae.a e10) {
            e10.printStackTrace();
        }
        dVar.a(list);
    }

    public void s(Activity activity, Context context, String str, List<String> list, wd.d dVar) {
        if (!list.isEmpty()) {
            if (!b(context).booleanValue()) {
                if (Build.VERSION.SDK_INT >= 33) {
                    String strF = f(null);
                    if (!activity.shouldShowRequestPermissionRationale(strF)) {
                        t(activity, context, str, list, Collections.singletonList(strF), dVar);
                        return;
                    }
                }
                v(context, str, null, list, dVar);
                return;
            }
            ArrayList arrayList = new ArrayList(list);
            arrayList.removeAll(c(context, str, arrayList));
            List<String> listU = u(context, str, arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = listU.iterator();
            while (it.hasNext()) {
                zd.l lVar = (zd.l) this.f7965b.b(zd.l.class, it.next());
                String strF2 = f(lVar);
                if (strF2 == null || (activity != null && activity.shouldShowRequestPermissionRationale(strF2))) {
                    v(context, str, lVar, arrayList, dVar);
                    return;
                }
                arrayList2.add(strF2);
            }
            if (activity != null && !arrayList2.isEmpty()) {
                t(activity, context, str, arrayList, arrayList2, dVar);
                return;
            }
        }
        r(context, str, list, dVar);
    }

    public final void t(Activity activity, Context context, String str, List<String> list, List<String> list2, wd.d dVar) {
        activity.requestPermissions((String[]) list2.toArray(new String[0]), 101);
        this.f7966c.add(new c(context, str, list, dVar));
    }

    public List<String> u(Context context, String str, List<String> list) {
        if (!b(context).booleanValue()) {
            return list;
        }
        list.removeAll(this.f7968e);
        list.removeAll(c(context, str, list));
        return list;
    }

    /* JADX WARN: Code duplicated, block: B:3:0x0002  */
    public final void v(Context context, String str, zd.l lVar, List<String> list, wd.d dVar) {
        boolean zJ;
        if (lVar != null) {
            switch (i.f7989a[lVar.ordinal()]) {
                case 1:
                    zJ = j(context);
                    break;
                case 2:
                case 3:
                case 5:
                case 7:
                case 8:
                case 9:
                    zJ = h(context, str);
                    break;
                case 4:
                    zJ = i(context);
                    break;
                case 6:
                default:
                    zJ = g(context);
                    break;
            }
        } else {
            zJ = g(context);
        }
        if (zJ) {
            this.f7966c.add(new d(context, str, list, dVar));
        } else {
            r(context, str, list, dVar);
        }
    }

    public void w(Context context, String str, wd.d dVar) {
        if (h(context, str)) {
            this.f7966c.add(new f(dVar));
        } else {
            dVar.a(new ArrayList());
        }
    }

    public void x(Context context, wd.d dVar) {
        if (i(context)) {
            this.f7966c.add(new h(dVar));
        } else {
            dVar.a(new ArrayList());
        }
    }

    public void y(Context context, wd.d dVar) {
        if (g(context)) {
            this.f7966c.add(new e(dVar));
        } else {
            dVar.a(new ArrayList());
        }
    }

    public void z(Context context, wd.d dVar) {
        if (j(context)) {
            this.f7966c.add(new g(dVar));
        } else {
            dVar.a(new ArrayList());
        }
    }
}
