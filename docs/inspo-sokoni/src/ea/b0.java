package ea;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b0 implements xa.a, fb.j.c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f7473m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static n f7477q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fb.j f7479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Integer> f7468c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Integer, i> f7469d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f7470e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f7471f = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f7472l = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f7474n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f7475o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f7476p = 0;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f7480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ fb.j.d f7481b;

        public a(i iVar, fb.j.d dVar) {
            this.f7480a = iVar;
            this.f7481b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b0.f7471f) {
                b0.this.l(this.f7480a);
            }
            this.f7481b.a(null);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f7483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ fb.j.d f7485c;

        public b(i iVar, String str, fb.j.d dVar) {
            this.f7483a = iVar;
            this.f7484b = str;
            this.f7485c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b0.f7471f) {
                i iVar = this.f7483a;
                if (iVar != null) {
                    b0.this.l(iVar);
                }
                try {
                    if (q.c(b0.f7472l)) {
                        Log.d("Sqflite", "delete database " + this.f7484b);
                    }
                    i.n(this.f7484b);
                } catch (Exception e10) {
                    Log.e("Sqflite", "error " + e10 + " while closing database " + b0.f7476p);
                }
            }
            this.f7485c.a(null);
        }
    }

    public static boolean o(String str) {
        return str == null || str.equals(":memory:");
    }

    public static /* synthetic */ void q(fb.i iVar, fb.j.d dVar, i iVar2) {
        iVar2.u(new ga.d(iVar, dVar));
    }

    public static /* synthetic */ void r(fb.i iVar, fb.j.d dVar, i iVar2) {
        iVar2.C(new ga.d(iVar, dVar));
    }

    public static /* synthetic */ void s(boolean z10, String str, fb.j.d dVar, Boolean bool, i iVar, fb.i iVar2, boolean z11, int i10) {
        synchronized (f7471f) {
            if (!z10) {
                try {
                    File file = new File(new File(str).getParent());
                    if (!file.exists() && !file.mkdirs() && !file.exists()) {
                        dVar.b("sqlite_error", "open_failed " + str, null);
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            try {
                if (Boolean.TRUE.equals(bool)) {
                    iVar.L();
                } else {
                    iVar.K();
                }
                synchronized (f7470e) {
                    if (z11) {
                        f7468c.put(str, Integer.valueOf(i10));
                        f7469d.put(Integer.valueOf(i10), iVar);
                    } else {
                        f7469d.put(Integer.valueOf(i10), iVar);
                    }
                    throw th;
                }
                if (q.b(iVar.f7503d)) {
                    Log.d("Sqflite", iVar.y() + "opened " + i10 + " " + str);
                }
                dVar.a(x(i10, false, false));
            } catch (Exception e10) {
                iVar.B(e10, new ga.d(iVar2, dVar));
            }
        }
    }

    public static /* synthetic */ void t(fb.i iVar, fb.j.d dVar, i iVar2) {
        iVar2.M(new ga.d(iVar, dVar));
    }

    public static /* synthetic */ void u(fb.i iVar, fb.j.d dVar, i iVar2) {
        iVar2.N(new ga.d(iVar, dVar));
    }

    public static /* synthetic */ void v(fb.i iVar, i iVar2, fb.j.d dVar) {
        try {
            iVar2.f7508i.setLocale(d0.d((String) iVar.a("locale")));
            dVar.a(null);
        } catch (Exception e10) {
            dVar.b("sqlite_error", "Error calling setLocale: " + e10.getMessage(), null);
        }
    }

    public static /* synthetic */ void w(fb.i iVar, fb.j.d dVar, i iVar2) {
        iVar2.P(new ga.d(iVar, dVar));
    }

    public static Map x(int i10, boolean z10, boolean z11) {
        HashMap map = new HashMap();
        map.put("id", Integer.valueOf(i10));
        if (z10) {
            map.put("recovered", Boolean.TRUE);
        }
        if (z11) {
            map.put("recoveredInTransaction", Boolean.TRUE);
        }
        return map;
    }

    public final void A(fb.i iVar, fb.j.d dVar) {
        int iIntValue = ((Integer) iVar.a("id")).intValue();
        i iVarN = n(iVar, dVar);
        if (iVarN == null) {
            return;
        }
        if (q.b(iVarN.f7503d)) {
            Log.d("Sqflite", iVarN.y() + "closing " + iIntValue + " " + iVarN.f7501b);
        }
        String str = iVarN.f7501b;
        synchronized (f7470e) {
            f7469d.remove(Integer.valueOf(iIntValue));
            if (iVarN.f7500a) {
                f7468c.remove(str);
            }
        }
        f7477q.a(iVarN, new a(iVarN, dVar));
    }

    public final void B(fb.i iVar, fb.j.d dVar) {
        dVar.a(Boolean.valueOf(i.w((String) iVar.a("path"))));
    }

    public final void C(fb.i iVar, fb.j.d dVar) {
        String str = (String) iVar.a("cmd");
        HashMap map = new HashMap();
        if ("get".equals(str)) {
            int i10 = f7472l;
            if (i10 > 0) {
                map.put("logLevel", Integer.valueOf(i10));
            }
            Map<Integer, i> map2 = f7469d;
            if (!map2.isEmpty()) {
                HashMap map3 = new HashMap();
                for (Map.Entry<Integer, i> entry : map2.entrySet()) {
                    i value = entry.getValue();
                    HashMap map4 = new HashMap();
                    map4.put("path", value.f7501b);
                    map4.put("singleInstance", Boolean.valueOf(value.f7500a));
                    int i11 = value.f7503d;
                    if (i11 > 0) {
                        map4.put("logLevel", Integer.valueOf(i11));
                    }
                    map3.put(entry.getKey().toString(), map4);
                }
                map.put("databases", map3);
            }
        }
        dVar.a(map);
    }

    public final void D(fb.i iVar, fb.j.d dVar) {
        fa.a.f8257a = Boolean.TRUE.equals(iVar.b());
        fa.a.f8259c = fa.a.f8258b && fa.a.f8257a;
        if (!fa.a.f8257a) {
            f7472l = 0;
        } else if (fa.a.f8259c) {
            f7472l = 2;
        } else if (fa.a.f8257a) {
            f7472l = 1;
        }
        dVar.a(null);
    }

    public final void E(fb.i iVar, fb.j.d dVar) {
        i iVar2;
        Map<Integer, i> map;
        String str = (String) iVar.a("path");
        synchronized (f7470e) {
            if (q.c(f7472l)) {
                Log.d("Sqflite", "Look for " + str + " in " + f7468c.keySet());
            }
            Map<String, Integer> map2 = f7468c;
            Integer num = map2.get(str);
            if (num == null || (iVar2 = (map = f7469d).get(num)) == null || !iVar2.f7508i.isOpen()) {
                iVar2 = null;
            } else {
                if (q.c(f7472l)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iVar2.y());
                    sb2.append("found single instance ");
                    sb2.append(iVar2.D() ? "(in transaction) " : "");
                    sb2.append(num);
                    sb2.append(" ");
                    sb2.append(str);
                    Log.d("Sqflite", sb2.toString());
                }
                map.remove(num);
                map2.remove(str);
            }
        }
        b bVar = new b(iVar2, str, dVar);
        n nVar = f7477q;
        if (nVar != null) {
            nVar.a(iVar2, bVar);
        } else {
            bVar.run();
        }
    }

    public final void F(final fb.i iVar, final fb.j.d dVar) {
        final i iVarN = n(iVar, dVar);
        if (iVarN == null) {
            return;
        }
        f7477q.a(iVarN, new Runnable() { // from class: ea.w
            @Override // java.lang.Runnable
            public final void run() {
                b0.q(iVar, dVar, iVarN);
            }
        });
    }

    public void G(fb.i iVar, fb.j.d dVar) {
        if (f7473m == null) {
            f7473m = this.f7478a.getDatabasePath("tekartik_sqflite.db").getParent();
        }
        dVar.a(f7473m);
    }

    public final void H(final fb.i iVar, final fb.j.d dVar) {
        final i iVarN = n(iVar, dVar);
        if (iVarN == null) {
            return;
        }
        f7477q.a(iVarN, new Runnable() { // from class: ea.t
            @Override // java.lang.Runnable
            public final void run() {
                b0.r(iVar, dVar, iVarN);
            }
        });
    }

    public final void I(final fb.i iVar, final fb.j.d dVar) {
        final int i10;
        i iVar2;
        final String str = (String) iVar.a("path");
        final Boolean bool = (Boolean) iVar.a("readOnly");
        final boolean zO = o(str);
        boolean z10 = (Boolean.FALSE.equals(iVar.a("singleInstance")) || zO) ? false : true;
        if (z10) {
            synchronized (f7470e) {
                if (q.c(f7472l)) {
                    Log.d("Sqflite", "Look for " + str + " in " + f7468c.keySet());
                }
                Integer num = f7468c.get(str);
                if (num != null && (iVar2 = f7469d.get(num)) != null) {
                    if (iVar2.f7508i.isOpen()) {
                        if (q.c(f7472l)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(iVar2.y());
                            sb2.append("re-opened single instance ");
                            sb2.append(iVar2.D() ? "(in transaction) " : "");
                            sb2.append(num);
                            sb2.append(" ");
                            sb2.append(str);
                            Log.d("Sqflite", sb2.toString());
                        }
                        dVar.a(x(num.intValue(), true, iVar2.D()));
                        return;
                    }
                    if (q.c(f7472l)) {
                        Log.d("Sqflite", iVar2.y() + "single instance database of " + str + " not opened");
                    }
                }
            }
        }
        Object obj = f7470e;
        synchronized (obj) {
            i10 = f7476p + 1;
            f7476p = i10;
        }
        final i iVar3 = new i(this.f7478a, str, i10, z10, f7472l);
        synchronized (obj) {
            if (f7477q == null) {
                n nVarC = n.c("Sqflite", f7475o, f7474n);
                f7477q = nVarC;
                nVarC.start();
                if (q.b(iVar3.f7503d)) {
                    Log.d("Sqflite", iVar3.y() + "starting worker pool with priority " + f7474n);
                }
            }
            iVar3.f7507h = f7477q;
            if (q.b(iVar3.f7503d)) {
                Log.d("Sqflite", iVar3.y() + "opened " + i10 + " " + str);
            }
            final boolean z11 = z10;
            f7477q.a(iVar3, new Runnable() { // from class: ea.y
                @Override // java.lang.Runnable
                public final void run() {
                    b0.s(zO, str, dVar, bool, iVar3, iVar, z11, i10);
                }
            });
        }
    }

    public void J(fb.i iVar, fb.j.d dVar) {
        Object objA = iVar.a("androidThreadPriority");
        if (objA != null) {
            f7474n = ((Integer) objA).intValue();
        }
        Object objA2 = iVar.a("androidThreadCount");
        if (objA2 != null && !objA2.equals(Integer.valueOf(f7475o))) {
            f7475o = ((Integer) objA2).intValue();
            n nVar = f7477q;
            if (nVar != null) {
                nVar.d();
                f7477q = null;
            }
        }
        Integer numA = q.a(iVar);
        if (numA != null) {
            f7472l = numA.intValue();
        }
        dVar.a(null);
    }

    public final void K(final fb.i iVar, final fb.j.d dVar) {
        final i iVarN = n(iVar, dVar);
        if (iVarN == null) {
            return;
        }
        f7477q.a(iVarN, new Runnable() { // from class: ea.x
            @Override // java.lang.Runnable
            public final void run() {
                b0.t(iVar, dVar, iVarN);
            }
        });
    }

    public final void L(final fb.i iVar, final fb.j.d dVar) {
        final i iVarN = n(iVar, dVar);
        if (iVarN == null) {
            return;
        }
        f7477q.a(iVarN, new Runnable() { // from class: ea.u
            @Override // java.lang.Runnable
            public final void run() {
                b0.u(iVar, dVar, iVarN);
            }
        });
    }

    public final void M(final fb.i iVar, final fb.j.d dVar) {
        final i iVarN = n(iVar, dVar);
        if (iVarN == null) {
            return;
        }
        f7477q.a(iVarN, new Runnable() { // from class: ea.z
            @Override // java.lang.Runnable
            public final void run() {
                b0.v(iVar, iVarN, dVar);
            }
        });
    }

    public final void N(final fb.i iVar, final fb.j.d dVar) {
        final i iVarN = n(iVar, dVar);
        if (iVarN == null) {
            return;
        }
        f7477q.a(iVarN, new Runnable() { // from class: ea.v
            @Override // java.lang.Runnable
            public final void run() {
                b0.w(iVar, dVar, iVarN);
            }
        });
    }

    public final void l(i iVar) {
        try {
            if (q.b(iVar.f7503d)) {
                Log.d("Sqflite", iVar.y() + "closing database ");
            }
            iVar.j();
        } catch (Exception e10) {
            Log.e("Sqflite", "error " + e10 + " while closing database " + f7476p);
        }
        synchronized (f7470e) {
            if (f7469d.isEmpty() && f7477q != null) {
                if (q.b(iVar.f7503d)) {
                    Log.d("Sqflite", iVar.y() + "stopping thread");
                }
                f7477q.d();
                f7477q = null;
            }
        }
    }

    public final i m(int i10) {
        return f7469d.get(Integer.valueOf(i10));
    }

    public final i n(fb.i iVar, fb.j.d dVar) {
        int iIntValue = ((Integer) iVar.a("id")).intValue();
        i iVarM = m(iIntValue);
        if (iVarM != null) {
            return iVarM;
        }
        dVar.b("sqlite_error", "database_closed " + iIntValue, null);
        return null;
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        y(bVar.a(), bVar.b());
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        this.f7478a = null;
        this.f7479b.e(null);
        this.f7479b = null;
    }

    @Override // fb.j.c
    public void onMethodCall(fb.i iVar, fb.j.d dVar) {
        String str = iVar.f8284a;
        str.hashCode();
        switch (str) {
            case "execute":
                F(iVar, dVar);
                break;
            case "closeDatabase":
                A(iVar, dVar);
                break;
            case "options":
                J(iVar, dVar);
                break;
            case "insert":
                H(iVar, dVar);
                break;
            case "update":
                N(iVar, dVar);
                break;
            case "androidSetLocale":
                M(iVar, dVar);
                break;
            case "deleteDatabase":
                E(iVar, dVar);
                break;
            case "debugMode":
                D(iVar, dVar);
                break;
            case "openDatabase":
                I(iVar, dVar);
                break;
            case "batch":
                z(iVar, dVar);
                break;
            case "debug":
                C(iVar, dVar);
                break;
            case "query":
                K(iVar, dVar);
                break;
            case "databaseExists":
                B(iVar, dVar);
                break;
            case "queryCursorNext":
                L(iVar, dVar);
                break;
            case "getPlatformVersion":
                dVar.a("Android " + Build.VERSION.RELEASE);
                break;
            case "getDatabasesPath":
                G(iVar, dVar);
                break;
            default:
                dVar.c();
                break;
        }
    }

    public final void y(Context context, fb.b bVar) {
        this.f7478a = context;
        fb.j jVar = new fb.j(bVar, "com.tekartik.sqflite", fb.q.f8299b, bVar.b());
        this.f7479b = jVar;
        jVar.e(this);
    }

    public final void z(final fb.i iVar, final fb.j.d dVar) {
        final i iVarN = n(iVar, dVar);
        if (iVarN == null) {
            return;
        }
        f7477q.a(iVarN, new Runnable() { // from class: ea.a0
            @Override // java.lang.Runnable
            public final void run() {
                iVarN.h(iVar, dVar);
            }
        });
    }
}
