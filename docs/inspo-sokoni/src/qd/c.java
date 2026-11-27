package qd;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Looper;
import ee.k;
import fb.i;
import fb.j;
import io.flutter.view.FlutterCallbackInformation;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class c extends sd.a implements j.c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final BlockingQueue<Intent> f14958n = new LinkedBlockingDeque();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Context f14959o;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j f14961f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public io.flutter.embedding.engine.a f14962l;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AtomicBoolean f14960e = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j.d f14963m = new C0262c();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler f14964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Long f14965b;

        /* JADX INFO: renamed from: qd.c$a$a, reason: collision with other inner class name */
        public class RunnableC0261a implements Runnable {
            public RunnableC0261a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                String strJ = qa.a.e().c().j();
                AssetManager assets = c.f14959o.getApplicationContext().getAssets();
                de.a.d("DartBackgroundExec", "Creating background FlutterEngine instance.");
                c.this.f14962l = new io.flutter.embedding.engine.a(c.f14959o.getApplicationContext());
                FlutterCallbackInformation flutterCallbackInformationLookupCallbackInformation = FlutterCallbackInformation.lookupCallbackInformation(a.this.f14965b.longValue());
                if (flutterCallbackInformationLookupCallbackInformation == null) {
                    ae.b.e().h("DartBackgroundExec", "MISSING_ARGUMENTS", "The flutter background reference for dart background action is invalid", "arguments.required.FlutterCallbackInformation");
                    return;
                }
                ta.a aVarK = c.this.f14962l.k();
                c.this.n(aVarK);
                de.a.d("DartBackgroundExec", "Executing background FlutterEngine instance.");
                aVarK.i(new ta.a.b(assets, strJ, flutterCallbackInformationLookupCallbackInformation));
            }
        }

        public a(Handler handler, Long l10) {
            this.f14964a = handler;
            this.f14965b = l10;
        }

        @Override // java.lang.Runnable
        public void run() {
            de.a.d("DartBackgroundExec", "Initializing Flutter global instance.");
            qa.a.e().c().r(c.f14959o.getApplicationContext());
            qa.a.e().c().i(c.f14959o.getApplicationContext(), null, this.f14964a, new RunnableC0261a());
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            de.a.d("DartBackgroundExec", "Shutting down background FlutterEngine instance.");
            if (c.this.f14962l != null) {
                c.this.f14962l.g();
                c.this.f14962l = null;
            }
            de.a.d("DartBackgroundExec", "FlutterEngine instance terminated.");
        }
    }

    /* JADX INFO: renamed from: qd.c$c, reason: collision with other inner class name */
    public class C0262c implements j.d {
        public C0262c() {
        }

        @Override // fb.j.d
        public void a(Object obj) {
            c.this.m();
        }

        @Override // fb.j.d
        public void b(String str, String str2, Object obj) {
            c.this.m();
        }

        @Override // fb.j.d
        public void c() {
            c.this.m();
        }
    }

    public static void i(Intent intent) {
        f14958n.add(intent);
    }

    @Override // sd.a
    public boolean a() {
        AtomicBoolean atomicBoolean = this.f14960e;
        return (atomicBoolean == null || atomicBoolean.get()) ? false : true;
    }

    @Override // sd.a
    public boolean b(Context context, Intent intent) {
        if (this.f15717a.longValue() == 0) {
            return false;
        }
        f14959o = context;
        i(intent);
        if (this.f14960e == null) {
            this.f14960e = new AtomicBoolean(true);
            o(this.f15717a);
        }
        return true;
    }

    public void j() {
        if (a()) {
            return;
        }
        this.f14960e.set(false);
        new Handler(Looper.getMainLooper()).post(new b());
    }

    public void k() {
        BlockingQueue<Intent> blockingQueue = f14958n;
        if (blockingQueue.isEmpty()) {
            j();
            return;
        }
        try {
            l(blockingQueue.take());
        } catch (Exception e10) {
            ae.b.e().g("DartBackgroundExec", "BACKGROUND_EXECUTION_EXCEPTION", "unexpectedError.background.silentExecution", e10);
        }
    }

    public void l(Intent intent) {
        if (this.f14962l == null) {
            de.a.d("DartBackgroundExec", "A background message could not be handled since dart callback handler has not been registered.");
            return;
        }
        ge.a aVarA = vd.b.m().a(f14959o, intent, k.h());
        if (aVarA == null) {
            de.a.b("DartBackgroundExec", "Silent data model not found inside Intent content.");
            m();
        } else {
            Map<String, Object> mapO = aVarA.O();
            mapO.put("actionHandle", this.f15718b);
            this.f14961f.d("silentCallbackReference", mapO, this.f14963m);
        }
    }

    public final void m() {
        BlockingQueue<Intent> blockingQueue = f14958n;
        if (blockingQueue.isEmpty()) {
            if (rd.a.f15359i.booleanValue()) {
                de.a.d("DartBackgroundExec", "All silent data fetched.");
            }
            j();
            return;
        }
        if (rd.a.f15359i.booleanValue()) {
            de.a.d("DartBackgroundExec", "Remaining " + blockingQueue.size() + " silents to finish");
        }
        k();
    }

    public final void n(fb.b bVar) {
        j jVar = new j(bVar, "awesome_notifications_reverse");
        this.f14961f = jVar;
        jVar.e(this);
    }

    public void o(Long l10) {
        if (this.f14962l != null) {
            de.a.b("DartBackgroundExec", "Background isolate already started.");
        } else {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new a(handler, l10));
        }
    }

    @Override // fb.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        try {
            if (iVar.f8284a.equals("pushNext")) {
                k();
                dVar.a(Boolean.TRUE);
            } else {
                dVar.c();
            }
        } catch (Exception unused) {
            ae.a aVarC = ae.b.e().c("DartBackgroundExec", "UNKNOWN_EXCEPTION", "An unexpected exception was found in a silent background execution", "unexpectedError");
            dVar.b(aVarC.a(), aVarC.getMessage(), aVarC.b());
        }
    }
}
