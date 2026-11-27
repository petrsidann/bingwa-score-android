package h7;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.internal.v1;
import com.google.android.gms.common.internal.r;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import q7.w;
import r7.a0;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f9692k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map<String, f> f9693l = new t.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f9696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q7.n f9697d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w<u8.a> f9700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o8.b<m8.f> f9701h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f9698e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f9699f = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<a> f9702i = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<g> f9703j = new CopyOnWriteArrayList();

    public interface a {
        void a(boolean z10);
    }

    public static class b implements com.google.android.gms.common.api.internal.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static AtomicReference<b> f9704a = new AtomicReference<>();

        public static void c(Context context) {
            if (j4.m.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f9704a.get() == null) {
                    b bVar = new b();
                    if (v1.a(f9704a, null, bVar)) {
                        com.google.android.gms.common.api.internal.c.c(application);
                        com.google.android.gms.common.api.internal.c.b().a(bVar);
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.c.a
        public void a(boolean z10) {
            synchronized (f.f9692k) {
                for (f fVar : new ArrayList(f.f9693l.values())) {
                    if (fVar.f9698e.get()) {
                        fVar.C(z10);
                    }
                }
            }
        }
    }

    public static class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static AtomicReference<c> f9705b = new AtomicReference<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f9706a;

        public c(Context context) {
            this.f9706a = context;
        }

        public static void b(Context context) {
            if (f9705b.get() == null) {
                c cVar = new c(context);
                if (v1.a(f9705b, null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f9706a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (f.f9692k) {
                Iterator<f> it = f.f9693l.values().iterator();
                while (it.hasNext()) {
                    it.next().t();
                }
            }
            c();
        }
    }

    public f(final Context context, String str, n nVar) {
        this.f9694a = (Context) r.l(context);
        this.f9695b = r.f(str);
        this.f9696c = (n) r.l(nVar);
        p pVarB = FirebaseInitProvider.b();
        a9.c.b("Firebase");
        a9.c.b("ComponentDiscovery");
        List<o8.b<ComponentRegistrar>> listB = q7.f.c(context, ComponentDiscoveryService.class).b();
        a9.c.a();
        a9.c.b("Runtime");
        q7.n.b bVarG = q7.n.m(a0.INSTANCE).d(listB).c(new FirebaseCommonRegistrar()).c(new ExecutorsRegistrar()).b(q7.c.s(context, Context.class, new Class[0])).b(q7.c.s(this, f.class, new Class[0])).b(q7.c.s(nVar, n.class, new Class[0])).g(new a9.b());
        if (l0.o.a(context) && FirebaseInitProvider.c()) {
            bVarG.b(q7.c.s(pVarB, p.class, new Class[0]));
        }
        q7.n nVarE = bVarG.e();
        this.f9697d = nVarE;
        a9.c.a();
        this.f9700g = new w<>(new o8.b() { // from class: h7.d
            @Override // o8.b
            public final Object get() {
                return this.f9689a.z(context);
            }
        });
        this.f9701h = nVarE.c(m8.f.class);
        g(new a() { // from class: h7.e
            @Override // h7.f.a
            public final void a(boolean z10) {
                this.f9691a.A(z10);
            }
        });
        a9.c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(boolean z10) {
        if (z10) {
            return;
        }
        this.f9701h.get().l();
    }

    public static String B(String str) {
        return str.trim();
    }

    public static List<String> l() {
        ArrayList arrayList = new ArrayList();
        synchronized (f9692k) {
            Iterator<f> it = f9693l.values().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().q());
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static List<f> n(Context context) {
        ArrayList arrayList;
        synchronized (f9692k) {
            arrayList = new ArrayList(f9693l.values());
        }
        return arrayList;
    }

    public static f o() {
        f fVar;
        synchronized (f9692k) {
            fVar = f9693l.get("[DEFAULT]");
            if (fVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + j4.p.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
            fVar.f9701h.get().l();
        }
        return fVar;
    }

    public static f p(String str) {
        f fVar;
        String str2;
        synchronized (f9692k) {
            fVar = f9693l.get(B(str));
            if (fVar == null) {
                List<String> listL = l();
                if (listL.isEmpty()) {
                    str2 = "";
                } else {
                    str2 = "Available app names: " + TextUtils.join(", ", listL);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", str, str2));
            }
            fVar.f9701h.get().l();
        }
        return fVar;
    }

    public static f u(Context context) {
        synchronized (f9692k) {
            if (f9693l.containsKey("[DEFAULT]")) {
                return o();
            }
            n nVarA = n.a(context);
            if (nVarA == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return v(context, nVarA);
        }
    }

    public static f v(Context context, n nVar) {
        return w(context, nVar, "[DEFAULT]");
    }

    public static f w(Context context, n nVar, String str) {
        f fVar;
        b.c(context);
        String strB = B(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f9692k) {
            Map<String, f> map = f9693l;
            r.p(!map.containsKey(strB), "FirebaseApp name " + strB + " already exists!");
            r.m(context, "Application context cannot be null.");
            fVar = new f(context, strB, nVar);
            map.put(strB, fVar);
        }
        fVar.t();
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ u8.a z(Context context) {
        return new u8.a(context, s(), (a8.c) this.f9697d.a(a8.c.class));
    }

    public final void C(boolean z10) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator<a> it = this.f9702i.iterator();
        while (it.hasNext()) {
            it.next().a(z10);
        }
    }

    public final void D() {
        Iterator<g> it = this.f9703j.iterator();
        while (it.hasNext()) {
            it.next().a(this.f9695b, this.f9696c);
        }
    }

    public void E(boolean z10) {
        boolean z11;
        i();
        if (this.f9698e.compareAndSet(!z10, z10)) {
            boolean zD = com.google.android.gms.common.api.internal.c.b().d();
            if (z10 && zD) {
                z11 = true;
            } else if (z10 || !zD) {
                return;
            } else {
                z11 = false;
            }
            C(z11);
        }
    }

    public void F(Boolean bool) {
        i();
        this.f9700g.get().e(bool);
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f9695b.equals(((f) obj).q());
        }
        return false;
    }

    public void g(a aVar) {
        i();
        if (this.f9698e.get() && com.google.android.gms.common.api.internal.c.b().d()) {
            aVar.a(true);
        }
        this.f9702i.add(aVar);
    }

    public void h(g gVar) {
        i();
        r.l(gVar);
        this.f9703j.add(gVar);
    }

    public int hashCode() {
        return this.f9695b.hashCode();
    }

    public final void i() {
        r.p(!this.f9699f.get(), "FirebaseApp was deleted");
    }

    public void j() {
        if (this.f9699f.compareAndSet(false, true)) {
            synchronized (f9692k) {
                f9693l.remove(this.f9695b);
            }
            D();
        }
    }

    public <T> T k(Class<T> cls) {
        i();
        return (T) this.f9697d.a(cls);
    }

    public Context m() {
        i();
        return this.f9694a;
    }

    public String q() {
        i();
        return this.f9695b;
    }

    public n r() {
        i();
        return this.f9696c;
    }

    public String s() {
        return j4.c.e(q().getBytes(Charset.defaultCharset())) + "+" + j4.c.e(r().c().getBytes(Charset.defaultCharset()));
    }

    public final void t() {
        if (!l0.o.a(this.f9694a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + q());
            c.b(this.f9694a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + q());
        this.f9697d.p(y());
        this.f9701h.get().l();
    }

    public String toString() {
        return com.google.android.gms.common.internal.p.d(this).a("name", this.f9695b).a("options", this.f9696c).toString();
    }

    public boolean x() {
        i();
        return this.f9700g.get().b();
    }

    public boolean y() {
        return "[DEFAULT]".equals(q());
    }
}
