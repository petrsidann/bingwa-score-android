package pb;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FirebaseMessaging;
import e0.o0;
import io.flutter.plugins.firebase.core.FlutterFirebasePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingBackgroundService;
import io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingReceiver;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class x implements FlutterFirebasePlugin, fb.j.c, fb.m, xa.a, ya.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fb.j f14511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f14512c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.lifecycle.r<com.google.firebase.messaging.d> f14514e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public androidx.lifecycle.r<String> f14516l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.google.firebase.messaging.d f14517m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map<String, Object> f14518n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a0 f14519o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Boolean> f14510a = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.lifecycle.o<com.google.firebase.messaging.d> f14513d = b0.o();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.lifecycle.o<String> f14515f = c0.o();

    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14520a;

        public a(String str) {
            this.f14520a = str;
            put("token", str);
        }
    }

    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FirebaseMessaging f14522a;

        public b(FirebaseMessaging firebaseMessaging) {
            this.f14522a = firebaseMessaging;
            put("isAutoInitEnabled", Boolean.valueOf(firebaseMessaging.B()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:33:0x0078 A[PHI: r0
  0x0078: PHI (r0v11 com.google.firebase.messaging.d) = (r0v8 com.google.firebase.messaging.d), (r0v13 com.google.firebase.messaging.d) binds: [B:29:0x0063, B:31:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    public /* synthetic */ void A(TaskCompletionSource taskCompletionSource) {
        Map<String, Object> mapU;
        try {
            com.google.firebase.messaging.d dVar = this.f14517m;
            if (dVar != null) {
                Map<String, Object> mapF = z.f(dVar);
                Map<String, Object> map = this.f14518n;
                if (map != null) {
                    mapF.put("notification", map);
                }
                taskCompletionSource.setResult(mapF);
                this.f14517m = null;
                this.f14518n = null;
                return;
            }
            Activity activity = this.f14512c;
            if (activity == null) {
                taskCompletionSource.setResult(null);
                return;
            }
            Intent intent = activity.getIntent();
            if (intent != null && intent.getExtras() != null) {
                String string = intent.getExtras().getString("google.message_id");
                if (string == null) {
                    string = intent.getExtras().getString("message_id");
                }
                if (string != null && this.f14510a.get(string) == null) {
                    com.google.firebase.messaging.d dVarB = FlutterFirebaseMessagingReceiver.f10979a.get(string);
                    if (dVarB == null) {
                        Map<String, Object> mapA = y.b().a(string);
                        if (mapA != null) {
                            dVarB = z.b(mapA);
                            if (mapA.get("notification") != null) {
                                mapU = U(mapA.get("notification"));
                            } else {
                                mapU = null;
                            }
                        } else {
                            mapU = null;
                        }
                        y.b().g(string);
                    } else {
                        mapU = null;
                    }
                    if (dVarB == null) {
                        taskCompletionSource.setResult(null);
                        return;
                    }
                    this.f14510a.put(string, Boolean.TRUE);
                    Map<String, Object> mapF2 = z.f(dVarB);
                    if (dVarB.Y() == null && mapU != null) {
                        mapF2.put("notification", mapU);
                    }
                    taskCompletionSource.setResult(mapF2);
                    return;
                }
                taskCompletionSource.setResult(null);
                return;
            }
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(TaskCompletionSource taskCompletionSource) {
        try {
            HashMap map = new HashMap();
            map.put("authorizationStatus", Integer.valueOf(Build.VERSION.SDK_INT >= 33 ? r().booleanValue() : o0.e(this.f14512c).a() ? 1 : 0));
            taskCompletionSource.setResult(map);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static /* synthetic */ void C(h7.f fVar, TaskCompletionSource taskCompletionSource) {
        try {
            HashMap map = new HashMap();
            if (fVar.q().equals("[DEFAULT]")) {
                map.put("AUTO_INIT_ENABLED", Boolean.valueOf(FirebaseMessaging.s().B()));
            }
            taskCompletionSource.setResult(map);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(new a((String) Tasks.await(FirebaseMessaging.s().v())));
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(com.google.firebase.messaging.d dVar) {
        this.f14511b.c("Messaging#onMessage", z.f(dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(String str) {
        this.f14511b.c("Messaging#onTokenRefresh", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(fb.j.d dVar, Task task) {
        if (task.isSuccessful()) {
            dVar.a(task.getResult());
        } else {
            Exception exception = task.getException();
            dVar.b("firebase_messaging", exception != null ? exception.getMessage() : null, t(exception));
        }
    }

    public static /* synthetic */ void H(Map map, TaskCompletionSource taskCompletionSource, int i10) {
        map.put("authorizationStatus", Integer.valueOf(i10));
        taskCompletionSource.setResult(map);
    }

    public static /* synthetic */ void I(TaskCompletionSource taskCompletionSource, String str) {
        taskCompletionSource.setException(new Exception(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(final TaskCompletionSource taskCompletionSource) {
        final HashMap map = new HashMap();
        try {
            if (r().booleanValue()) {
                map.put("authorizationStatus", 1);
                taskCompletionSource.setResult(map);
            } else {
                this.f14519o.a(this.f14512c, new a0.a() { // from class: pb.m
                    @Override // pb.a0.a
                    public final void a(int i10) {
                        x.H(map, taskCompletionSource, i10);
                    }
                }, new pb.b() { // from class: pb.n
                    @Override // pb.b
                    public final void a(String str) {
                        x.I(taskCompletionSource, str);
                    }
                });
            }
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static /* synthetic */ void K(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            z.a(map).P(z.b(map));
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessagingA = z.a(map);
            Object obj = map.get("enabled");
            Objects.requireNonNull(obj);
            firebaseMessagingA.Q(((Boolean) obj).booleanValue());
            taskCompletionSource.setResult(new b(firebaseMessagingA));
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static /* synthetic */ void M(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessagingA = z.a(map);
            Object obj = map.get("enabled");
            Objects.requireNonNull(obj);
            firebaseMessagingA.R(((Boolean) obj).booleanValue());
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static /* synthetic */ void N(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessagingA = z.a(map);
            Object obj = map.get("topic");
            Objects.requireNonNull(obj);
            Tasks.await(firebaseMessagingA.W((String) obj));
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static /* synthetic */ void O(Map map, TaskCompletionSource taskCompletionSource) {
        try {
            FirebaseMessaging firebaseMessagingA = z.a(map);
            Object obj = map.get("topic");
            Objects.requireNonNull(obj);
            Tasks.await(firebaseMessagingA.Z((String) obj));
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static /* synthetic */ void y(TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(FirebaseMessaging.s().p());
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public final Task<Map<String, Integer>> P() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: pb.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f14500a.J(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final Task<Void> Q(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: pb.w
            @Override // java.lang.Runnable
            public final void run() {
                x.K(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final Task<Map<String, Object>> R(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: pb.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f14487a.L(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final Task<Void> S(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: pb.i
            @Override // java.lang.Runnable
            public final void run() {
                x.M(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final Task<Void> T(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: pb.u
            @Override // java.lang.Runnable
            public final void run() {
                x.N(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final Map<String, Object> U(Object obj) {
        return (Map) obj;
    }

    public final Task<Void> V(final Map<String, Object> map) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: pb.l
            @Override // java.lang.Runnable
            public final void run() {
                x.O(map, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Void> didReinitializeFirebaseCore() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: pb.o
            @Override // java.lang.Runnable
            public final void run() {
                taskCompletionSource.setResult(null);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // io.flutter.plugins.firebase.core.FlutterFirebasePlugin
    public Task<Map<String, Object>> getPluginConstantsForFirebaseApp(final h7.f fVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: pb.g
            @Override // java.lang.Runnable
            public final void run() {
                x.C(fVar, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Override // ya.a
    public void onAttachedToActivity(ya.c cVar) {
        cVar.e(this);
        cVar.h(this.f14519o);
        Activity activityG = cVar.g();
        this.f14512c = activityG;
        if (activityG.getIntent() == null || this.f14512c.getIntent().getExtras() == null || (this.f14512c.getIntent().getFlags() & 1048576) == 1048576) {
            return;
        }
        onNewIntent(this.f14512c.getIntent());
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        pb.a.b(bVar.a());
        x(bVar.b());
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
        this.f14512c = null;
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        this.f14512c = null;
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        this.f14515f.m(this.f14516l);
        this.f14513d.m(this.f14514e);
    }

    @Override // fb.j.c
    public void onMethodCall(fb.i iVar, final fb.j.d dVar) {
        Task taskU;
        Long lValueOf;
        Long lValueOf2;
        String str = iVar.f8284a;
        str.hashCode();
        switch (str) {
            case "Messaging#getInitialMessage":
                taskU = u();
                taskU.addOnCompleteListener(new OnCompleteListener() { // from class: pb.r
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        this.f14498a.G(dVar, task);
                    }
                });
                return;
            case "Messaging#setAutoInitEnabled":
                taskU = R((Map) iVar.b());
                taskU.addOnCompleteListener(new OnCompleteListener() { // from class: pb.r
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        this.f14498a.G(dVar, task);
                    }
                });
                return;
            case "Messaging#deleteToken":
                taskU = s();
                taskU.addOnCompleteListener(new OnCompleteListener() { // from class: pb.r
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        this.f14498a.G(dVar, task);
                    }
                });
                return;
            case "Messaging#unsubscribeFromTopic":
                taskU = V((Map) iVar.b());
                taskU.addOnCompleteListener(new OnCompleteListener() { // from class: pb.r
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        this.f14498a.G(dVar, task);
                    }
                });
                return;
            case "Messaging#subscribeToTopic":
                taskU = T((Map) iVar.b());
                taskU.addOnCompleteListener(new OnCompleteListener() { // from class: pb.r
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        this.f14498a.G(dVar, task);
                    }
                });
                return;
            case "Messaging#setDeliveryMetricsExportToBigQuery":
                taskU = S((Map) iVar.b());
                taskU.addOnCompleteListener(new OnCompleteListener() { // from class: pb.r
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        this.f14498a.G(dVar, task);
                    }
                });
                return;
            case "Messaging#startBackgroundIsolate":
                Map map = (Map) iVar.f8285b;
                Object obj = map.get("pluginCallbackHandle");
                Object obj2 = map.get("userCallbackHandle");
                if (obj instanceof Long) {
                    lValueOf = (Long) obj;
                } else {
                    if (!(obj instanceof Integer)) {
                        throw new IllegalArgumentException("Expected 'Long' or 'Integer' type for 'pluginCallbackHandle'.");
                    }
                    lValueOf = Long.valueOf(((Integer) obj).intValue());
                }
                long jLongValue = lValueOf.longValue();
                if (obj2 instanceof Long) {
                    lValueOf2 = (Long) obj2;
                } else {
                    if (!(obj2 instanceof Integer)) {
                        throw new IllegalArgumentException("Expected 'Long' or 'Integer' type for 'userCallbackHandle'.");
                    }
                    lValueOf2 = Long.valueOf(((Integer) obj2).intValue());
                }
                long jLongValue2 = lValueOf2.longValue();
                Activity activity = this.f14512c;
                sa.j jVarA = activity != null ? sa.j.a(activity.getIntent()) : null;
                FlutterFirebaseMessagingBackgroundService.n(jLongValue);
                FlutterFirebaseMessagingBackgroundService.o(jLongValue2);
                FlutterFirebaseMessagingBackgroundService.p(jLongValue, jVarA);
                taskU = Tasks.forResult(null);
                taskU.addOnCompleteListener(new OnCompleteListener() { // from class: pb.r
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        this.f14498a.G(dVar, task);
                    }
                });
                return;
            case "Messaging#sendMessage":
                taskU = Q((Map) iVar.b());
                taskU.addOnCompleteListener(new OnCompleteListener() { // from class: pb.r
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        this.f14498a.G(dVar, task);
                    }
                });
                return;
            case "Messaging#requestPermission":
                if (Build.VERSION.SDK_INT >= 33) {
                    taskU = P();
                }
                taskU.addOnCompleteListener(new OnCompleteListener() { // from class: pb.r
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        this.f14498a.G(dVar, task);
                    }
                });
                return;
            case "Messaging#getNotificationSettings":
                taskU = v();
                taskU.addOnCompleteListener(new OnCompleteListener() { // from class: pb.r
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        this.f14498a.G(dVar, task);
                    }
                });
                return;
            case "Messaging#getToken":
                taskU = w();
                taskU.addOnCompleteListener(new OnCompleteListener() { // from class: pb.r
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        this.f14498a.G(dVar, task);
                    }
                });
                return;
            default:
                dVar.c();
                return;
        }
    }

    @Override // fb.m
    public boolean onNewIntent(Intent intent) {
        Map<String, Object> mapC;
        Map<String, Object> map;
        Map<String, Object> mapA;
        if (intent.getExtras() == null) {
            return false;
        }
        String string = intent.getExtras().getString("google.message_id");
        if (string == null) {
            string = intent.getExtras().getString("message_id");
        }
        if (string == null) {
            return false;
        }
        com.google.firebase.messaging.d dVarB = FlutterFirebaseMessagingReceiver.f10979a.get(string);
        if (dVarB != null || (mapA = y.b().a(string)) == null) {
            mapC = null;
        } else {
            dVarB = z.b(mapA);
            mapC = z.c(mapA);
        }
        if (dVarB == null) {
            return false;
        }
        this.f14517m = dVarB;
        this.f14518n = mapC;
        FlutterFirebaseMessagingReceiver.f10979a.remove(string);
        Map<String, Object> mapF = z.f(dVarB);
        if (dVarB.Y() == null && (map = this.f14518n) != null) {
            mapF.put("notification", map);
        }
        this.f14511b.c("Messaging#onMessageOpenedApp", mapF);
        this.f14512c.setIntent(intent);
        return true;
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(ya.c cVar) {
        cVar.e(this);
        this.f14512c = cVar.g();
    }

    public final Boolean r() {
        return Boolean.valueOf(pb.a.a().checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0);
    }

    public final Task<Void> s() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: pb.j
            @Override // java.lang.Runnable
            public final void run() {
                x.y(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final Map<String, Object> t(Exception exc) {
        HashMap map = new HashMap();
        map.put("code", "unknown");
        map.put("message", exc != null ? exc.getMessage() : "An unknown error has occurred.");
        return map;
    }

    public final Task<Map<String, Object>> u() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: pb.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f14506a.A(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final Task<Map<String, Integer>> v() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: pb.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f14502a.B(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final Task<Map<String, Object>> w() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        FlutterFirebasePlugin.cachedThreadPool.execute(new Runnable() { // from class: pb.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f14482a.D(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final void x(fb.b bVar) {
        fb.j jVar = new fb.j(bVar, "plugins.flutter.io/firebase_messaging");
        this.f14511b = jVar;
        jVar.e(this);
        this.f14519o = new a0();
        this.f14514e = new androidx.lifecycle.r() { // from class: pb.p
            @Override // androidx.lifecycle.r
            public final void a(Object obj) {
                this.f14496a.E((com.google.firebase.messaging.d) obj);
            }
        };
        this.f14516l = new androidx.lifecycle.r() { // from class: pb.q
            @Override // androidx.lifecycle.r
            public final void a(Object obj) {
                this.f14497a.F((String) obj);
            }
        };
        this.f14513d.i(this.f14514e);
        this.f14515f.i(this.f14516l);
        FlutterFirebasePluginRegistry.registerPlugin("plugins.flutter.io/firebase_messaging", this);
    }
}
