package mb;

import android.app.Activity;
import android.util.Log;
import b8.b2;
import b8.h1;
import b8.i1;
import b8.r1;
import b8.u1;
import b8.x0;
import b8.y0;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.FirebaseFirestore;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class x implements FlutterFirebasePlugin, xa.a, ya.a, z.g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final HashMap<FirebaseFirestore, b> f13116m = new HashMap<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Map<Integer, com.google.firebase.firestore.d.a> f13117n = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fb.b f13119b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.q f13118a = new fb.q(c.f13035d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<Activity> f13120c = new AtomicReference<>(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, com.google.firebase.firestore.l> f13121d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, fb.c> f13122e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, fb.c.d> f13123f = new HashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, nb.f> f13124l = new HashMap();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f13126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f13127c;

        static {
            int[] iArr = new int[z.l.values().length];
            f13127c = iArr;
            try {
                iArr[z.l.ENABLE_INDEX_AUTO_CREATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13127c[z.l.DISABLE_INDEX_AUTO_CREATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13127c[z.l.DELETE_ALL_INDEXES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[z.w.values().length];
            f13126b = iArr2;
            try {
                iArr2[z.w.DELETE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13126b[z.w.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13126b[z.w.SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[z.d.values().length];
            f13125a = iArr3;
            try {
                iArr3[z.d.COUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13125a[z.d.SUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13125a[z.d.AVERAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static void O0(FirebaseFirestore firebaseFirestore) {
        HashMap<FirebaseFirestore, b> map = f13116m;
        synchronized (map) {
            if (map.get(firebaseFirestore) != null) {
                map.remove(firebaseFirestore);
            }
        }
    }

    public static b Q0(FirebaseFirestore firebaseFirestore) {
        b bVar;
        HashMap<FirebaseFirestore, b> map = f13116m;
        synchronized (map) {
            bVar = map.get(firebaseFirestore);
        }
        return bVar;
    }

    public static FirebaseFirestore R0(z.i iVar) {
        synchronized (f13116m) {
            FirebaseFirestore firebaseFirestoreS0 = S0(iVar.b(), iVar.c());
            if (firebaseFirestoreS0 != null) {
                return firebaseFirestoreS0;
            }
            FirebaseFirestore firebaseFirestoreC = FirebaseFirestore.C(h7.f.p(iVar.b()), iVar.c());
            firebaseFirestoreC.Z(T0(iVar));
            s1(firebaseFirestoreC, iVar.c());
            return firebaseFirestoreC;
        }
    }

    public static FirebaseFirestore S0(String str, String str2) {
        HashMap<FirebaseFirestore, b> map = f13116m;
        synchronized (map) {
            for (Map.Entry<FirebaseFirestore, b> entry : map.entrySet()) {
                if (entry.getValue().b().A().q().equals(str) && entry.getValue().a().equals(str2)) {
                    return entry.getKey();
                }
            }
            return null;
        }
    }

    public static com.google.firebase.firestore.g T0(z.i iVar) {
        x0 x0VarA;
        com.google.firebase.firestore.g.b bVar = new com.google.firebase.firestore.g.b();
        if (iVar.d().c() != null) {
            bVar.g(iVar.d().c());
        }
        if (iVar.d().e() != null) {
            bVar.i(iVar.d().e().booleanValue());
        }
        if (iVar.d().d() != null) {
            if (iVar.d().d().booleanValue()) {
                Long lB = iVar.d().b();
                x0VarA = i1.b().b((lB == null || lB.longValue() == -1) ? 104857600L : lB.longValue()).a();
            } else {
                x0VarA = y0.b().a();
            }
            bVar.h(x0VarA);
        }
        return bVar.f();
    }

    public static /* synthetic */ void V0(b8.c cVar, z.c cVar2, List list, z.x xVar) {
        z.b bVarA;
        try {
            com.google.firebase.firestore.b bVar = (com.google.firebase.firestore.b) Tasks.await(cVar.c(ob.b.b(cVar2)));
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                z.a aVar = (z.a) it.next();
                int i10 = a.f13125a[aVar.c().ordinal()];
                if (i10 == 1) {
                    z.b.a aVar2 = new z.b.a();
                    aVar2.c(z.d.COUNT);
                    aVar2.d(Double.valueOf(bVar.e()));
                    bVarA = aVar2.a();
                } else if (i10 == 2) {
                    z.b.a aVar3 = new z.b.a();
                    aVar3.c(z.d.SUM);
                    Object objD = bVar.d(com.google.firebase.firestore.a.f(aVar.b()));
                    Objects.requireNonNull(objD);
                    aVar3.d(Double.valueOf(((Number) objD).doubleValue()));
                    aVar3.b(aVar.b());
                    bVarA = aVar3.a();
                } else if (i10 == 3) {
                    z.b.a aVar4 = new z.b.a();
                    aVar4.c(z.d.AVERAGE);
                    aVar4.d(bVar.c(com.google.firebase.firestore.a.a(aVar.b())));
                    aVar4.b(aVar.b());
                    bVarA = aVar4.a();
                }
                arrayList.add(bVarA);
            }
            xVar.a(arrayList);
        } catch (Exception e10) {
            ob.a.b(xVar, e10);
        }
    }

    public static /* synthetic */ void W0(z.i iVar, z.x xVar) {
        try {
            Tasks.await(R0(iVar).t());
            xVar.a(null);
        } catch (Exception e10) {
            ob.a.b(xVar, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X0(TaskCompletionSource taskCompletionSource) {
        try {
            HashMap<FirebaseFirestore, b> map = f13116m;
            synchronized (map) {
                Iterator<Map.Entry<FirebaseFirestore, b>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    FirebaseFirestore key = it.next().getKey();
                    Tasks.await(key.c0());
                    O0(key);
                }
            }
            r1();
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static /* synthetic */ void Y0(z.i iVar, z.x xVar) {
        try {
            Tasks.await(R0(iVar).x());
            xVar.a(null);
        } catch (Exception e10) {
            ob.a.b(xVar, e10);
        }
    }

    public static /* synthetic */ void Z0(z.i iVar, z.f fVar, z.x xVar) {
        try {
            xVar.a((Void) Tasks.await(R0(iVar).y(fVar.d()).m()));
        } catch (Exception e10) {
            ob.a.b(xVar, e10);
        }
    }

    public static /* synthetic */ void a1(z.f fVar, z.i iVar, z.x xVar) {
        try {
            xVar.a(ob.b.k((com.google.firebase.firestore.d) Tasks.await(R0(iVar).y(fVar.d()).o(ob.b.f(fVar.f()))), ob.b.e(fVar.e())));
        } catch (Exception e10) {
            ob.a.b(xVar, e10);
        }
    }

    public static /* synthetic */ void b1(z.i iVar, z.f fVar, z.x xVar) {
        Task<Void> taskD;
        r1 r1VarD;
        try {
            com.google.firebase.firestore.c cVarY = R0(iVar).y(fVar.d());
            Map<Object, Object> mapB = fVar.b();
            Objects.requireNonNull(mapB);
            Map<Object, Object> map = mapB;
            if (fVar.c().b() == null || !fVar.c().b().booleanValue()) {
                if (fVar.c().c() != null) {
                    List<List<String>> listC = fVar.c().c();
                    Objects.requireNonNull(listC);
                    r1VarD = r1.d(ob.b.c(listC));
                } else {
                    taskD = cVarY.D(map);
                }
                xVar.a((Void) Tasks.await(taskD));
            }
            r1VarD = r1.c();
            taskD = cVarY.E(map, r1VarD);
            xVar.a((Void) Tasks.await(taskD));
        } catch (Exception e10) {
            ob.a.b(xVar, e10);
        }
    }

    public static /* synthetic */ void c1(z.i iVar, z.f fVar, z.x xVar) {
        b8.t tVarD;
        Object obj;
        try {
            com.google.firebase.firestore.c cVarY = R0(iVar).y(fVar.d());
            Map<Object, Object> mapB = fVar.b();
            Objects.requireNonNull(mapB);
            Map<Object, Object> map = mapB;
            HashMap map2 = new HashMap();
            for (Object obj2 : map.keySet()) {
                if (obj2 instanceof String) {
                    tVarD = b8.t.d((String) obj2);
                    obj = map.get(obj2);
                } else {
                    if (!(obj2 instanceof b8.t)) {
                        throw new IllegalArgumentException("Invalid key type in update data. Supported types are String and FieldPath.");
                    }
                    tVarD = (b8.t) obj2;
                    obj = map.get(obj2);
                }
                map2.put(tVarD, obj);
            }
            b8.t tVar = (b8.t) map2.keySet().iterator().next();
            Object obj3 = map2.get(tVar);
            ArrayList arrayList = new ArrayList();
            for (b8.t tVar2 : map2.keySet()) {
                if (!tVar2.equals(tVar)) {
                    arrayList.add(tVar2);
                    arrayList.add(map2.get(tVar2));
                }
            }
            xVar.a((Void) Tasks.await(cVarY.F(tVar, obj3, arrayList.toArray())));
        } catch (Exception e10) {
            ob.a.b(xVar, e10);
        }
    }

    public static /* synthetic */ void d1(z.i iVar, z.x xVar) {
        try {
            Tasks.await(R0(iVar).z());
            xVar.a(null);
        } catch (Exception e10) {
            ob.a.b(xVar, e10);
        }
    }

    public static /* synthetic */ void e1(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static /* synthetic */ void f1(z.i iVar, String str, z.x xVar, z.q qVar) {
        try {
            com.google.firebase.firestore.i iVar2 = (com.google.firebase.firestore.i) Tasks.await(R0(iVar).D(str));
            if (iVar2 == null) {
                xVar.b(new NullPointerException("Named query has not been found. Please check it has been loaded properly via loadBundle()."));
            } else {
                xVar.a(ob.b.m((com.google.firebase.firestore.k) Tasks.await(iVar2.o(ob.b.f(qVar.c()))), ob.b.e(qVar.b())));
            }
        } catch (Exception e10) {
            ob.a.b(xVar, e10);
        }
    }

    public static /* synthetic */ void g1(z.i iVar, z.l lVar, z.x xVar) {
        h1 h1VarE = R0(iVar).E();
        if (h1VarE != null) {
            int i10 = a.f13127c[lVar.ordinal()];
            if (i10 == 1) {
                h1VarE.e();
            } else if (i10 == 2) {
                h1VarE.d();
            } else if (i10 == 3) {
                h1VarE.c();
            }
        } else {
            Log.d("FlutterFirestorePlugin", "`PersistentCacheIndexManager` is not available.");
        }
        xVar.a(null);
    }

    public static /* synthetic */ void h1(z.q qVar, z.i iVar, String str, Boolean bool, z.r rVar, z.x xVar) {
        try {
            u1 u1VarF = ob.b.f(qVar.c());
            com.google.firebase.firestore.i iVarG = ob.b.g(R0(iVar), str, bool.booleanValue(), rVar);
            if (iVarG == null) {
                xVar.b(new z.j("invalid_query", "An error occurred while parsing query arguments, see native logs for more information. Please report this issue.", null));
            } else {
                xVar.a(ob.b.m((com.google.firebase.firestore.k) Tasks.await(iVarG.o(u1VarF)), ob.b.e(qVar.b())));
            }
        } catch (Exception e10) {
            ob.a.b(xVar, e10);
        }
    }

    public static /* synthetic */ void i1(z.i iVar, String str, z.x xVar) {
        try {
            Tasks.await(R0(iVar).a0(str));
            xVar.a(null);
        } catch (Exception e10) {
            ob.a.b(xVar, e10);
        }
    }

    public static /* synthetic */ void j1(Boolean bool, z.x xVar) {
        try {
            FirebaseFirestore.b0(bool.booleanValue());
            xVar.a(null);
        } catch (Exception e10) {
            ob.a.b(xVar, e10);
        }
    }

    public static /* synthetic */ void k1(z.i iVar, z.x xVar) {
        try {
            FirebaseFirestore firebaseFirestoreR0 = R0(iVar);
            Tasks.await(firebaseFirestoreR0.c0());
            O0(firebaseFirestoreR0);
            xVar.a(null);
        } catch (Exception e10) {
            ob.a.b(xVar, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l1(String str, com.google.firebase.firestore.l lVar) {
        this.f13121d.put(str, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m1(z.i iVar, String str, String str2, z.x xVar) {
        try {
            com.google.firebase.firestore.c cVarY = R0(iVar).y(str);
            com.google.firebase.firestore.l lVar = this.f13121d.get(str2);
            if (lVar != null) {
                xVar.a(ob.b.k(lVar.c(cVarY), com.google.firebase.firestore.d.a.NONE));
                return;
            }
            xVar.b(new Exception("Transaction.getDocument(): No transaction handler exists for ID: " + str2));
        } catch (Exception e10) {
            ob.a.b(xVar, e10);
        }
    }

    public static /* synthetic */ void n1(z.i iVar, z.x xVar) {
        try {
            Tasks.await(R0(iVar).e0());
            xVar.a(null);
        } catch (Exception e10) {
            ob.a.b(xVar, e10);
        }
    }

    public static /* synthetic */ void o1(z.i iVar, List list, z.x xVar) {
        r1 r1VarD;
        try {
            FirebaseFirestore firebaseFirestoreR0 = R0(iVar);
            b2 b2VarR = firebaseFirestoreR0.r();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                z.u uVar = (z.u) it.next();
                z.w wVarE = uVar.e();
                Objects.requireNonNull(wVarE);
                String strD = uVar.d();
                Objects.requireNonNull(strD);
                Map<String, Object> mapB = uVar.b();
                com.google.firebase.firestore.c cVarY = firebaseFirestoreR0.y(strD);
                int i10 = a.f13126b[wVarE.ordinal()];
                if (i10 == 1) {
                    b2VarR = b2VarR.c(cVarY);
                } else if (i10 == 2) {
                    Objects.requireNonNull(mapB);
                    b2VarR = b2VarR.h(cVarY, mapB);
                } else if (i10 == 3) {
                    z.n nVarC = uVar.c();
                    Objects.requireNonNull(nVarC);
                    if (nVarC.b() != null && nVarC.b().booleanValue()) {
                        Objects.requireNonNull(mapB);
                        r1VarD = r1.c();
                    } else if (nVarC.c() != null) {
                        List<List<String>> listC = nVarC.c();
                        Objects.requireNonNull(listC);
                        List<b8.t> listC2 = ob.b.c(listC);
                        Objects.requireNonNull(mapB);
                        r1VarD = r1.d(listC2);
                    } else {
                        Objects.requireNonNull(mapB);
                        b2VarR = b2VarR.e(cVarY, mapB);
                    }
                    b2VarR = b2VarR.f(cVarY, mapB, r1VarD);
                }
            }
            Tasks.await(b2VarR.b());
            xVar.a(null);
        } catch (Exception e10) {
            ob.a.b(xVar, e10);
        }
    }

    public static void s1(FirebaseFirestore firebaseFirestore, String str) {
        HashMap<FirebaseFirestore, b> map = f13116m;
        synchronized (map) {
            if (map.get(firebaseFirestore) == null) {
                map.put(firebaseFirestore, new b(firebaseFirestore, str));
            }
        }
    }

    @Override // mb.z.g
    public void A(final Boolean bool, final z.x<Void> xVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.k
            @Override // java.lang.Runnable
            public final void run() {
                x.j1(bool, xVar);
            }
        });
    }

    @Override // mb.z.g
    public void J(z.i iVar, z.f fVar, Boolean bool, z.k kVar, z.x<String> xVar) {
        xVar.a(p1("plugins.flutter.io/firebase_firestore/document", new nb.b(R0(iVar), R0(iVar).y(fVar.d()), bool, ob.b.e(fVar.e()), ob.b.d(kVar))));
    }

    @Override // mb.z.g
    public void L(String str, z.v vVar, List<z.u> list, z.x<Void> xVar) {
        nb.f fVar = this.f13124l.get(str);
        Objects.requireNonNull(fVar);
        fVar.a(vVar, list);
        xVar.a(null);
    }

    public final void N0(ya.c cVar) {
        this.f13120c.set(cVar.g());
    }

    @Override // mb.z.g
    public void P(z.i iVar, z.x<String> xVar) {
        xVar.a(p1("plugins.flutter.io/firebase_firestore/snapshotsInSync", new nb.j(R0(iVar))));
    }

    public final void P0() {
        this.f13120c.set(null);
    }

    @Override // mb.z.g
    public void Q(final z.i iVar, final z.x<Void> xVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.s
            @Override // java.lang.Runnable
            public final void run() {
                x.Y0(iVar, xVar);
            }
        });
    }

    @Override // mb.z.g
    public void S(final z.i iVar, final String str, final z.q qVar, final z.x<z.s> xVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.q
            @Override // java.lang.Runnable
            public final void run() {
                x.f1(iVar, str, xVar, qVar);
            }
        });
    }

    @Override // mb.z.g
    public void U(final z.i iVar, final String str, final String str2, final z.x<z.o> xVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f13079a.m1(iVar, str2, str, xVar);
            }
        });
    }

    public final void U0(fb.b bVar) {
        this.f13119b = bVar;
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_firestore", this);
        z.g.l(this.f13119b, this);
    }

    @Override // mb.z.g
    public void Z(z.i iVar, byte[] bArr, z.x<String> xVar) {
        xVar.a(p1("plugins.flutter.io/firebase_firestore/loadBundle", new nb.e(R0(iVar), bArr)));
    }

    @Override // mb.z.g
    public void b(final z.i iVar, final z.f fVar, final z.x<Void> xVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.n
            @Override // java.lang.Runnable
            public final void run() {
                x.Z0(iVar, fVar, xVar);
            }
        });
    }

    @Override // mb.z.g
    public void c0(final z.i iVar, final z.x<Void> xVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.j
            @Override // java.lang.Runnable
            public final void run() {
                x.d1(iVar, xVar);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f13039a.X0(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // mb.z.g
    public void e(final z.i iVar, final String str, final Boolean bool, final z.r rVar, final z.q qVar, final z.x<z.s> xVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.r
            @Override // java.lang.Runnable
            public final void run() {
                x.h1(qVar, iVar, str, bool, rVar, xVar);
            }
        });
    }

    @Override // mb.z.g
    public void g(final z.i iVar, final z.x<Void> xVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.e
            @Override // java.lang.Runnable
            public final void run() {
                x.W0(iVar, xVar);
            }
        });
    }

    @Override // mb.z.g
    public void g0(final z.i iVar, final String str, final z.x<Void> xVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.l
            @Override // java.lang.Runnable
            public final void run() {
                x.i1(iVar, str, xVar);
            }
        });
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(h7.f fVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.o
            @Override // java.lang.Runnable
            public final void run() {
                x.e1(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // mb.z.g
    public void h0(z.i iVar, Long l10, Long l11, z.x<String> xVar) {
        FirebaseFirestore firebaseFirestoreR0 = R0(iVar);
        final String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        nb.o oVar = new nb.o(new nb.o.b() { // from class: mb.w
            @Override // nb.o.b
            public final void a(com.google.firebase.firestore.l lVar) {
                this.f13113a.l1(lowerCase, lVar);
            }
        }, firebaseFirestoreR0, lowerCase, l10, l11);
        q1("plugins.flutter.io/firebase_firestore/transaction", lowerCase, oVar);
        this.f13124l.put(lowerCase, oVar);
        xVar.a(lowerCase);
    }

    @Override // mb.z.g
    public void j0(final z.i iVar, final z.x<Void> xVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.g
            @Override // java.lang.Runnable
            public final void run() {
                x.n1(iVar, xVar);
            }
        });
    }

    @Override // mb.z.g
    public void k0(final z.i iVar, final z.l lVar, final z.x<Void> xVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.m
            @Override // java.lang.Runnable
            public final void run() {
                x.g1(iVar, lVar, xVar);
            }
        });
    }

    @Override // mb.z.g
    public void o(final z.i iVar, final List<z.u> list, final z.x<Void> xVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.t
            @Override // java.lang.Runnable
            public final void run() {
                x.o1(iVar, list, xVar);
            }
        });
    }

    @Override // ya.a
    public void onAttachedToActivity(ya.c cVar) {
        N0(cVar);
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        U0(bVar.b());
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
        P0();
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        P0();
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        r1();
        this.f13119b = null;
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(ya.c cVar) {
        N0(cVar);
    }

    public final String p1(String str, fb.c.d dVar) {
        return q1(str, UUID.randomUUID().toString().toLowerCase(Locale.US), dVar);
    }

    @Override // mb.z.g
    public void q(final z.i iVar, final z.f fVar, final z.x<Void> xVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.f
            @Override // java.lang.Runnable
            public final void run() {
                x.c1(iVar, fVar, xVar);
            }
        });
    }

    public final String q1(String str, String str2, fb.c.d dVar) {
        fb.c cVar = new fb.c(this.f13119b, str + "/" + str2, this.f13118a);
        cVar.d(dVar);
        this.f13122e.put(str2, cVar);
        this.f13123f.put(str2, dVar);
        return str2;
    }

    @Override // mb.z.g
    public void r0(z.i iVar, String str, z.r rVar, final z.c cVar, final List<z.a> list, Boolean bool, final z.x<List<z.b>> xVar) {
        com.google.firebase.firestore.a aVarB;
        com.google.firebase.firestore.i iVarG = ob.b.g(R0(iVar), str, bool.booleanValue(), rVar);
        ArrayList arrayList = new ArrayList();
        for (z.a aVar : list) {
            int i10 = a.f13125a[aVar.c().ordinal()];
            if (i10 == 1) {
                aVarB = com.google.firebase.firestore.a.b();
            } else if (i10 == 2) {
                aVarB = com.google.firebase.firestore.a.f(aVar.b());
            } else if (i10 == 3) {
                aVarB = com.google.firebase.firestore.a.a(aVar.b());
            }
            arrayList.add(aVarB);
        }
        final b8.c cVarI = iVarG.i((com.google.firebase.firestore.a) arrayList.get(0), (com.google.firebase.firestore.a[]) arrayList.subList(1, arrayList.size()).toArray(new com.google.firebase.firestore.a[0]));
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.v
            @Override // java.lang.Runnable
            public final void run() {
                x.V0(cVarI, cVar, list, xVar);
            }
        });
    }

    public final void r1() {
        synchronized (this.f13122e) {
            Iterator<String> it = this.f13122e.keySet().iterator();
            while (it.hasNext()) {
                fb.c cVar = this.f13122e.get(it.next());
                Objects.requireNonNull(cVar);
                cVar.d(null);
            }
            this.f13122e.clear();
        }
        synchronized (this.f13123f) {
            Iterator<String> it2 = this.f13123f.keySet().iterator();
            while (it2.hasNext()) {
                fb.c.d dVar = this.f13123f.get(it2.next());
                Objects.requireNonNull(dVar);
                dVar.onCancel(null);
            }
            this.f13123f.clear();
        }
        this.f13124l.clear();
    }

    @Override // mb.z.g
    public void s(final z.i iVar, final z.f fVar, final z.x<Void> xVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.h
            @Override // java.lang.Runnable
            public final void run() {
                x.b1(iVar, fVar, xVar);
            }
        });
    }

    @Override // mb.z.g
    public void s0(final z.i iVar, final z.x<Void> xVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.i
            @Override // java.lang.Runnable
            public final void run() {
                x.k1(iVar, xVar);
            }
        });
    }

    @Override // mb.z.g
    public void u(z.i iVar, String str, Boolean bool, z.r rVar, z.q qVar, Boolean bool2, z.k kVar, z.x<String> xVar) {
        com.google.firebase.firestore.i iVarG = ob.b.g(R0(iVar), str, bool.booleanValue(), rVar);
        if (iVarG == null) {
            xVar.b(new z.j("invalid_query", "An error occurred while parsing query arguments, see native logs for more information. Please report this issue.", null));
        } else {
            xVar.a(p1("plugins.flutter.io/firebase_firestore/query", new nb.h(iVarG, bool2, ob.b.e(qVar.b()), ob.b.d(kVar))));
        }
    }

    @Override // mb.z.g
    public void w(final z.i iVar, final z.f fVar, final z.x<z.o> xVar) {
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: mb.u
            @Override // java.lang.Runnable
            public final void run() {
                x.a1(fVar, iVar, xVar);
            }
        });
    }
}
