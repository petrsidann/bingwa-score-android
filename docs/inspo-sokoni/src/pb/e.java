package pb;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.util.Log;
import io.flutter.plugins.firebase.messaging.FlutterFirebaseMessagingBackgroundService;
import io.flutter.view.FlutterCallbackInformation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class e implements fb.j.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f14471a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fb.j f14472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public io.flutter.embedding.engine.a f14473c;

    public class a implements fb.j.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f14474a;

        public a(CountDownLatch countDownLatch) {
            this.f14474a = countDownLatch;
        }

        @Override // fb.j.d
        public void a(Object obj) {
            this.f14474a.countDown();
        }

        @Override // fb.j.d
        public void b(String str, String str2, Object obj) {
            this.f14474a.countDown();
        }

        @Override // fb.j.d
        public void c() {
            this.f14474a.countDown();
        }
    }

    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f14476a;

        public b(Map map) {
            this.f14476a = map;
            put("userCallbackHandle", Long.valueOf(e.this.f()));
            put("message", map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(va.f fVar, sa.j jVar, long j10) {
        String strJ = fVar.j();
        AssetManager assets = pb.a.a().getAssets();
        if (i()) {
            if (jVar != null) {
                Log.i("FLTFireBGExecutor", "Creating background FlutterEngine instance, with args: " + Arrays.toString(jVar.b()));
                this.f14473c = new io.flutter.embedding.engine.a(pb.a.a(), jVar.b());
            } else {
                Log.i("FLTFireBGExecutor", "Creating background FlutterEngine instance.");
                this.f14473c = new io.flutter.embedding.engine.a(pb.a.a());
            }
            FlutterCallbackInformation flutterCallbackInformationLookupCallbackInformation = FlutterCallbackInformation.lookupCallbackInformation(j10);
            if (flutterCallbackInformationLookupCallbackInformation == null) {
                Log.e("FLTFireBGExecutor", "Failed to find registered callback");
                return;
            }
            ta.a aVarK = this.f14473c.k();
            g(aVarK);
            aVarK.i(new ta.a.b(assets, strJ, flutterCallbackInformationLookupCallbackInformation));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(final va.f fVar, Handler handler, final sa.j jVar, final long j10) {
        fVar.r(pb.a.a());
        fVar.i(pb.a.a(), null, handler, new Runnable() { // from class: pb.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f14434a.j(fVar, jVar, j10);
            }
        });
    }

    public static void m(long j10) {
        Context contextA = pb.a.a();
        if (contextA == null) {
            Log.e("FLTFireBGExecutor", "Context is null, cannot continue.");
        } else {
            contextA.getSharedPreferences("io.flutter.firebase.messaging.callback", 0).edit().putLong("callback_handle", j10).apply();
        }
    }

    public static void n(long j10) {
        pb.a.a().getSharedPreferences("io.flutter.firebase.messaging.callback", 0).edit().putLong("user_callback_handle", j10).apply();
    }

    public void d(Intent intent, CountDownLatch countDownLatch) {
        if (this.f14473c == null) {
            Log.i("FLTFireBGExecutor", "A background message could not be handled in Dart as no onBackgroundMessage handler has been registered.");
            return;
        }
        a aVar = countDownLatch != null ? new a(countDownLatch) : null;
        byte[] byteArrayExtra = intent.getByteArrayExtra("notification");
        if (byteArrayExtra == null) {
            Log.e("FLTFireBGExecutor", "RemoteMessage byte array not found in Intent.");
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
            parcelObtain.setDataPosition(0);
            this.f14472b.d("MessagingBackground#onMessage", new b(z.f(com.google.firebase.messaging.d.CREATOR.createFromParcel(parcelObtain))), aVar);
        } finally {
            parcelObtain.recycle();
        }
    }

    public final long e() {
        return pb.a.a().getSharedPreferences("io.flutter.firebase.messaging.callback", 0).getLong("callback_handle", 0L);
    }

    public final long f() {
        return pb.a.a().getSharedPreferences("io.flutter.firebase.messaging.callback", 0).getLong("user_callback_handle", 0L);
    }

    public final void g(fb.b bVar) {
        fb.j jVar = new fb.j(bVar, "plugins.flutter.io/firebase_messaging_background");
        this.f14472b = jVar;
        jVar.e(this);
    }

    public boolean h() {
        return e() != 0;
    }

    public boolean i() {
        return !this.f14471a.get();
    }

    public final void l() {
        this.f14471a.set(true);
        FlutterFirebaseMessagingBackgroundService.m();
    }

    public void o() {
        if (i()) {
            long jE = e();
            if (jE != 0) {
                p(jE, null);
            }
        }
    }

    @Override // fb.j.c
    public void onMethodCall(fb.i iVar, fb.j.d dVar) {
        if (!iVar.f8284a.equals("MessagingBackground#initialized")) {
            dVar.c();
        } else {
            l();
            dVar.a(Boolean.TRUE);
        }
    }

    public void p(final long j10, final sa.j jVar) {
        if (this.f14473c != null) {
            Log.e("FLTFireBGExecutor", "Background isolate already started.");
            return;
        }
        final va.f fVarC = qa.a.e().c();
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() { // from class: pb.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f14428a.k(fVarC, handler, jVar, j10);
            }
        });
    }
}
