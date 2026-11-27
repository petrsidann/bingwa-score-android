package u9;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.g;
import androidx.lifecycle.k;
import fb.i;
import fb.j;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class c implements j.c, xa.a, ya.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f17063n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static boolean f17064o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f17065p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f17066q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ya.c f17067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u9.b f17068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Application f17069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public xa.a.b f17070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f17071e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f17072f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Activity f17073l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public j f17074m;

    public class a implements fb.c.d {
        public a() {
        }

        @Override // fb.c.d
        public void onCancel(Object obj) {
            c.this.f17068b.p(null);
        }

        @Override // fb.c.d
        public void onListen(Object obj, fb.c.b bVar) {
            c.this.f17068b.p(bVar);
        }
    }

    public class b implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f17076a;

        public b(Activity activity) {
            this.f17076a = activity;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void a(k kVar) {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void b(k kVar) {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void d(k kVar) {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void e(k kVar) {
            onActivityStopped(this.f17076a);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void f(k kVar) {
            onActivityDestroyed(this.f17076a);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void g(k kVar) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f17076a != activity || activity.getApplicationContext() == null) {
                return;
            }
            ((Application) activity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX INFO: renamed from: u9.c$c, reason: collision with other inner class name */
    public static class C0297c implements j.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j.d f17078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f17079b = new Handler(Looper.getMainLooper());

        /* JADX INFO: renamed from: u9.c$c$a */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f17080a;

            public a(Object obj) {
                this.f17080a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0297c.this.f17078a.a(this.f17080a);
            }
        }

        /* JADX INFO: renamed from: u9.c$c$b */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f17082a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f17083b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Object f17084c;

            public b(String str, String str2, Object obj) {
                this.f17082a = str;
                this.f17083b = str2;
                this.f17084c = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0297c.this.f17078a.b(this.f17082a, this.f17083b, this.f17084c);
            }
        }

        /* JADX INFO: renamed from: u9.c$c$c, reason: collision with other inner class name */
        public class RunnableC0298c implements Runnable {
            public RunnableC0298c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0297c.this.f17078a.c();
            }
        }

        public C0297c(j.d dVar) {
            this.f17078a = dVar;
        }

        @Override // fb.j.d
        public void a(Object obj) {
            this.f17079b.post(new a(obj));
        }

        @Override // fb.j.d
        public void b(String str, String str2, Object obj) {
            this.f17079b.post(new b(str, str2, obj));
        }

        @Override // fb.j.d
        public void c() {
            this.f17079b.post(new RunnableC0298c());
        }
    }

    public static String b(String str) {
        str.hashCode();
        switch (str) {
            case "custom":
            case "any":
                return "*/*";
            case "dir":
                return "dir";
            case "audio":
                return "audio/*";
            case "image":
                return "image/*";
            case "media":
                return "image/*,video/*";
            case "video":
                return "video/*";
            default:
                return null;
        }
    }

    public final void c(fb.b bVar, Application application, Activity activity, ya.c cVar) {
        this.f17073l = activity;
        this.f17069c = application;
        this.f17068b = new u9.b(activity);
        j jVar = new j(bVar, "miguelruivo.flutter.plugins.filepicker");
        this.f17074m = jVar;
        jVar.e(this);
        new fb.c(bVar, "miguelruivo.flutter.plugins.filepickerevent").d(new a());
        this.f17072f = new b(activity);
        cVar.b(this.f17068b);
        g gVarA = bb.a.a(cVar);
        this.f17071e = gVarA;
        gVarA.a(this.f17072f);
    }

    public final void d() {
        this.f17067a.d(this.f17068b);
        this.f17067a = null;
        b bVar = this.f17072f;
        if (bVar != null) {
            this.f17071e.c(bVar);
            this.f17069c.unregisterActivityLifecycleCallbacks(this.f17072f);
        }
        this.f17071e = null;
        this.f17068b.p(null);
        this.f17068b = null;
        this.f17074m.e(null);
        this.f17074m = null;
        this.f17069c = null;
    }

    @Override // ya.a
    public void onAttachedToActivity(ya.c cVar) {
        this.f17067a = cVar;
        c(this.f17070d.b(), (Application) this.f17070d.a(), this.f17067a.g(), this.f17067a);
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        this.f17070d = bVar;
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
        d();
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        this.f17070d = null;
    }

    @Override // fb.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        String[] strArrH;
        String str;
        if (this.f17073l == null) {
            dVar.b("no_activity", "file picker plugin requires a foreground activity", null);
            return;
        }
        C0297c c0297c = new C0297c(dVar);
        HashMap map = (HashMap) iVar.f8285b;
        String str2 = iVar.f8284a;
        if (str2 != null && str2.equals("clear")) {
            c0297c.a(Boolean.valueOf(d.a(this.f17073l.getApplicationContext())));
            return;
        }
        String str3 = iVar.f8284a;
        if (str3 != null && str3.equals("save")) {
            this.f17068b.o((String) map.get("fileName"), b((String) map.get("fileType")), (String) map.get("initialDirectory"), d.h((ArrayList) map.get("allowedExtensions")), (byte[]) map.get("bytes"), c0297c);
            return;
        }
        String strB = b(iVar.f8284a);
        f17063n = strB;
        if (strB != null) {
            if (strB != "dir") {
                f17064o = ((Boolean) map.get("allowMultipleSelection")).booleanValue();
                f17065p = ((Boolean) map.get("withData")).booleanValue();
                f17066q = ((Integer) map.get("compressionQuality")).intValue();
                strArrH = d.h((ArrayList) map.get("allowedExtensions"));
            }
            str = iVar.f8284a;
            if (str == null && str.equals("custom") && (strArrH == null || strArrH.length == 0)) {
                c0297c.b("FilePicker", "Unsupported filter. Make sure that you are only using the extension without the dot, (ie., jpg instead of .jpg). This could also have happened because you are using an unsupported file extension.  If the problem persists, you may want to consider using FileType.any instead.", null);
                return;
            } else {
                this.f17068b.s(f17063n, f17064o, f17065p, strArrH, f17066q, c0297c);
            }
        }
        c0297c.c();
        strArrH = null;
        str = iVar.f8284a;
        if (str == null) {
        }
        this.f17068b.s(f17063n, f17064o, f17065p, strArrH, f17066q, c0297c);
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(ya.c cVar) {
        onAttachedToActivity(cVar);
    }
}
