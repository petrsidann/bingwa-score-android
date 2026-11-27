package sa;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import fb.l;
import fb.m;
import fb.n;
import fb.o;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class b implements xa.b, ya.b, cb.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.flutter.embedding.engine.a f15670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xa.a.b f15671c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ra.b<Activity> f15673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f15674f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Service f15677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f15678j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BroadcastReceiver f15680l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ContentProvider f15682n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends xa.a>, xa.a> f15669a = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class<? extends xa.a>, ya.a> f15672d = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f15675g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Class<? extends xa.a>, cb.a> f15676h = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<Class<? extends xa.a>, za.a> f15679k = new HashMap();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<Class<? extends xa.a>, ab.a> f15681m = new HashMap();

    /* JADX INFO: renamed from: sa.b$b, reason: collision with other inner class name */
    public static class C0281b implements xa.a.InterfaceC0323a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final va.f f15683a;

        public C0281b(va.f fVar) {
            this.f15683a = fVar;
        }
    }

    public static class c implements ya.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f15684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HiddenLifecycleReference f15685b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<n> f15686c = new HashSet();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set<l> f15687d = new HashSet();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Set<m> f15688e = new HashSet();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Set<o> f15689f = new HashSet();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Set<Object> f15690g = new HashSet();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Set<ya.c.a> f15691h = new HashSet();

        public c(Activity activity, androidx.lifecycle.g gVar) {
            this.f15684a = activity;
            this.f15685b = new HiddenLifecycleReference(gVar);
        }

        @Override // ya.c
        public Object a() {
            return this.f15685b;
        }

        @Override // ya.c
        public void b(l lVar) {
            this.f15687d.add(lVar);
        }

        @Override // ya.c
        public void c(m mVar) {
            this.f15688e.remove(mVar);
        }

        @Override // ya.c
        public void d(l lVar) {
            this.f15687d.remove(lVar);
        }

        @Override // ya.c
        public void e(m mVar) {
            this.f15688e.add(mVar);
        }

        @Override // ya.c
        public void f(n nVar) {
            this.f15686c.remove(nVar);
        }

        @Override // ya.c
        public Activity g() {
            return this.f15684a;
        }

        @Override // ya.c
        public void h(n nVar) {
            this.f15686c.add(nVar);
        }

        public boolean i(int i10, int i11, Intent intent) {
            Iterator it = new HashSet(this.f15687d).iterator();
            while (true) {
                boolean z10 = false;
                while (it.hasNext()) {
                    if (((l) it.next()).onActivityResult(i10, i11, intent) || z10) {
                        z10 = true;
                    }
                }
                return z10;
            }
        }

        public void j(Intent intent) {
            Iterator<m> it = this.f15688e.iterator();
            while (it.hasNext()) {
                it.next().onNewIntent(intent);
            }
        }

        public boolean k(int i10, String[] strArr, int[] iArr) {
            Iterator<n> it = this.f15686c.iterator();
            while (true) {
                boolean z10 = false;
                while (it.hasNext()) {
                    if (it.next().onRequestPermissionsResult(i10, strArr, iArr) || z10) {
                        z10 = true;
                    }
                }
                return z10;
            }
        }

        public void l(Bundle bundle) {
            Iterator<ya.c.a> it = this.f15691h.iterator();
            while (it.hasNext()) {
                it.next().b(bundle);
            }
        }

        public void m(Bundle bundle) {
            Iterator<ya.c.a> it = this.f15691h.iterator();
            while (it.hasNext()) {
                it.next().c(bundle);
            }
        }

        public void n() {
            Iterator<o> it = this.f15689f.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
        }
    }

    public static class d implements cb.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Service f15692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HiddenLifecycleReference f15693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<cb.a.InterfaceC0070a> f15694c = new HashSet();

        public d(Service service, androidx.lifecycle.g gVar) {
            this.f15692a = service;
            this.f15693b = gVar != null ? new HiddenLifecycleReference(gVar) : null;
        }

        public void a() {
            Iterator<cb.a.InterfaceC0070a> it = this.f15694c.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        public void b() {
            Iterator<cb.a.InterfaceC0070a> it = this.f15694c.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        }
    }

    public b(Context context, io.flutter.embedding.engine.a aVar, va.f fVar, io.flutter.embedding.engine.b bVar) {
        this.f15670b = aVar;
        this.f15671c = new xa.a.b(context, aVar, aVar.k(), aVar.t(), aVar.q().W(), new C0281b(fVar), bVar);
    }

    @Override // cb.b
    public void a() {
        if (w()) {
            ub.e eVarZ = ub.e.z("FlutterEngineConnectionRegistry#onMoveToBackground");
            try {
                this.f15678j.a();
                if (eVarZ != null) {
                    eVarZ.close();
                }
            } catch (Throwable th) {
                if (eVarZ != null) {
                    try {
                        eVarZ.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    @Override // ya.b
    public void b(Bundle bundle) {
        if (!t()) {
            qa.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
            return;
        }
        ub.e eVarZ = ub.e.z("FlutterEngineConnectionRegistry#onRestoreInstanceState");
        try {
            this.f15674f.l(bundle);
            if (eVarZ != null) {
                eVarZ.close();
            }
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // ya.b
    public void c(Bundle bundle) {
        if (!t()) {
            qa.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
            return;
        }
        ub.e eVarZ = ub.e.z("FlutterEngineConnectionRegistry#onSaveInstanceState");
        try {
            this.f15674f.m(bundle);
            if (eVarZ != null) {
                eVarZ.close();
            }
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // ya.b
    public void d() {
        if (!t()) {
            qa.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
            return;
        }
        ub.e eVarZ = ub.e.z("FlutterEngineConnectionRegistry#onUserLeaveHint");
        try {
            this.f15674f.n();
            if (eVarZ != null) {
                eVarZ.close();
            }
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // cb.b
    public void e() {
        if (w()) {
            ub.e eVarZ = ub.e.z("FlutterEngineConnectionRegistry#onMoveToForeground");
            try {
                this.f15678j.b();
                if (eVarZ != null) {
                    eVarZ.close();
                }
            } catch (Throwable th) {
                if (eVarZ != null) {
                    try {
                        eVarZ.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    @Override // xa.b
    public void f(Class<? extends xa.a> cls) {
        xa.a aVar = this.f15669a.get(cls);
        if (aVar == null) {
            return;
        }
        ub.e eVarZ = ub.e.z("FlutterEngineConnectionRegistry#remove " + cls.getSimpleName());
        try {
            if (aVar instanceof ya.a) {
                if (t()) {
                    ((ya.a) aVar).onDetachedFromActivity();
                }
                this.f15672d.remove(cls);
            }
            if (aVar instanceof cb.a) {
                if (w()) {
                    ((cb.a) aVar).b();
                }
                this.f15676h.remove(cls);
            }
            if (aVar instanceof za.a) {
                if (u()) {
                    ((za.a) aVar).b();
                }
                this.f15679k.remove(cls);
            }
            if (aVar instanceof ab.a) {
                if (v()) {
                    ((ab.a) aVar).a();
                }
                this.f15681m.remove(cls);
            }
            aVar.onDetachedFromEngine(this.f15671c);
            this.f15669a.remove(cls);
            if (eVarZ != null) {
                eVarZ.close();
            }
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // cb.b
    public void g(Service service, androidx.lifecycle.g gVar, boolean z10) {
        ub.e eVarZ = ub.e.z("FlutterEngineConnectionRegistry#attachToService");
        try {
            p();
            this.f15677i = service;
            this.f15678j = new d(service, gVar);
            Iterator<cb.a> it = this.f15676h.values().iterator();
            while (it.hasNext()) {
                it.next().a(this.f15678j);
            }
            if (eVarZ != null) {
                eVarZ.close();
            }
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // ya.b
    public void h() {
        if (!t()) {
            qa.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        ub.e eVarZ = ub.e.z("FlutterEngineConnectionRegistry#detachFromActivity");
        try {
            Iterator<ya.a> it = this.f15672d.values().iterator();
            while (it.hasNext()) {
                it.next().onDetachedFromActivity();
            }
            o();
            if (eVarZ != null) {
                eVarZ.close();
            }
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // cb.b
    public void i() {
        if (!w()) {
            qa.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a Service when no Service was attached.");
            return;
        }
        ub.e eVarZ = ub.e.z("FlutterEngineConnectionRegistry#detachFromService");
        try {
            Iterator<cb.a> it = this.f15676h.values().iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f15677i = null;
            this.f15678j = null;
            if (eVarZ != null) {
                eVarZ.close();
            }
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // ya.b
    public void j() {
        if (!t()) {
            qa.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        ub.e eVarZ = ub.e.z("FlutterEngineConnectionRegistry#detachFromActivityForConfigChanges");
        try {
            this.f15675g = true;
            Iterator<ya.a> it = this.f15672d.values().iterator();
            while (it.hasNext()) {
                it.next().onDetachedFromActivityForConfigChanges();
            }
            o();
            if (eVarZ != null) {
                eVarZ.close();
            }
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xa.b
    public void k(xa.a aVar) {
        ub.e eVarZ = ub.e.z("FlutterEngineConnectionRegistry#add " + aVar.getClass().getSimpleName());
        try {
            if (s(aVar.getClass())) {
                qa.b.g("FlutterEngineCxnRegstry", "Attempted to register plugin (" + aVar + ") but it was already registered with this FlutterEngine (" + this.f15670b + ").");
                if (eVarZ != null) {
                    eVarZ.close();
                    return;
                }
                return;
            }
            qa.b.f("FlutterEngineCxnRegstry", "Adding plugin: " + aVar);
            this.f15669a.put((Class<? extends xa.a>) aVar.getClass(), aVar);
            aVar.onAttachedToEngine(this.f15671c);
            if (aVar instanceof ya.a) {
                ya.a aVar2 = (ya.a) aVar;
                this.f15672d.put((Class<? extends xa.a>) aVar.getClass(), aVar2);
                if (t()) {
                    aVar2.onAttachedToActivity(this.f15674f);
                }
            }
            if (aVar instanceof cb.a) {
                cb.a aVar3 = (cb.a) aVar;
                this.f15676h.put((Class<? extends xa.a>) aVar.getClass(), aVar3);
                if (w()) {
                    aVar3.a(this.f15678j);
                }
            }
            if (aVar instanceof za.a) {
                za.a aVar4 = (za.a) aVar;
                this.f15679k.put((Class<? extends xa.a>) aVar.getClass(), aVar4);
                if (u()) {
                    aVar4.a(null);
                }
            }
            if (aVar instanceof ab.a) {
                ab.a aVar5 = (ab.a) aVar;
                this.f15681m.put((Class<? extends xa.a>) aVar.getClass(), aVar5);
                if (v()) {
                    aVar5.b(null);
                }
            }
            if (eVarZ != null) {
                eVarZ.close();
            }
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // ya.b
    public void l(ra.b<Activity> bVar, androidx.lifecycle.g gVar) {
        ub.e eVarZ = ub.e.z("FlutterEngineConnectionRegistry#attachToActivity");
        try {
            ra.b<Activity> bVar2 = this.f15673e;
            if (bVar2 != null) {
                bVar2.d();
            }
            p();
            this.f15673e = bVar;
            m(bVar.e(), gVar);
            if (eVarZ != null) {
                eVarZ.close();
            }
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final void m(Activity activity, androidx.lifecycle.g gVar) {
        this.f15674f = new c(activity, gVar);
        this.f15670b.q().u0(activity.getIntent() != null ? activity.getIntent().getBooleanExtra("enable-software-rendering", false) : false);
        this.f15670b.q().C(activity, this.f15670b.t(), this.f15670b.k());
        for (ya.a aVar : this.f15672d.values()) {
            if (this.f15675g) {
                aVar.onReattachedToActivityForConfigChanges(this.f15674f);
            } else {
                aVar.onAttachedToActivity(this.f15674f);
            }
        }
        this.f15675g = false;
    }

    public void n() {
        qa.b.f("FlutterEngineCxnRegstry", "Destroying.");
        p();
        y();
    }

    public final void o() {
        this.f15670b.q().O();
        this.f15673e = null;
        this.f15674f = null;
    }

    @Override // ya.b
    public boolean onActivityResult(int i10, int i11, Intent intent) {
        if (!t()) {
            qa.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
            return false;
        }
        ub.e eVarZ = ub.e.z("FlutterEngineConnectionRegistry#onActivityResult");
        try {
            boolean zI = this.f15674f.i(i10, i11, intent);
            if (eVarZ != null) {
                eVarZ.close();
            }
            return zI;
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // ya.b
    public void onNewIntent(Intent intent) {
        if (!t()) {
            qa.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
            return;
        }
        ub.e eVarZ = ub.e.z("FlutterEngineConnectionRegistry#onNewIntent");
        try {
            this.f15674f.j(intent);
            if (eVarZ != null) {
                eVarZ.close();
            }
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // ya.b
    public boolean onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (!t()) {
            qa.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
            return false;
        }
        ub.e eVarZ = ub.e.z("FlutterEngineConnectionRegistry#onRequestPermissionsResult");
        try {
            boolean zK = this.f15674f.k(i10, strArr, iArr);
            if (eVarZ != null) {
                eVarZ.close();
            }
            return zK;
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final void p() {
        if (t()) {
            h();
            return;
        }
        if (w()) {
            i();
        } else if (u()) {
            q();
        } else if (v()) {
            r();
        }
    }

    public void q() {
        if (!u()) {
            qa.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
            return;
        }
        ub.e eVarZ = ub.e.z("FlutterEngineConnectionRegistry#detachFromBroadcastReceiver");
        try {
            Iterator<za.a> it = this.f15679k.values().iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            if (eVarZ != null) {
                eVarZ.close();
            }
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void r() {
        if (!v()) {
            qa.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
            return;
        }
        ub.e eVarZ = ub.e.z("FlutterEngineConnectionRegistry#detachFromContentProvider");
        try {
            Iterator<ab.a> it = this.f15681m.values().iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            if (eVarZ != null) {
                eVarZ.close();
            }
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public boolean s(Class<? extends xa.a> cls) {
        return this.f15669a.containsKey(cls);
    }

    public final boolean t() {
        return this.f15673e != null;
    }

    public final boolean u() {
        return this.f15680l != null;
    }

    public final boolean v() {
        return this.f15682n != null;
    }

    public final boolean w() {
        return this.f15677i != null;
    }

    public void x(Set<Class<? extends xa.a>> set) {
        Iterator<Class<? extends xa.a>> it = set.iterator();
        while (it.hasNext()) {
            f(it.next());
        }
    }

    public void y() {
        x(new HashSet(this.f15669a.keySet()));
        this.f15669a.clear();
    }
}
