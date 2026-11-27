package e8;

import android.app.Activity;
import android.app.Fragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class d {

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Runnable> f7130a;

        public b() {
            this.f7130a = new ArrayList();
        }

        public synchronized void a(Runnable runnable) {
            this.f7130a.add(runnable);
        }

        public void b() {
            for (Runnable runnable : this.f7130a) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public static class c extends Fragment {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f7131a = new b();

        @Override // android.app.Fragment
        public void onStop() {
            b bVar;
            super.onStop();
            synchronized (this.f7131a) {
                bVar = this.f7131a;
                this.f7131a = new b();
            }
            bVar.b();
        }
    }

    /* JADX INFO: renamed from: e8.d$d, reason: collision with other inner class name */
    public static class C0124d extends i1.p {

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public b f7132j0 = new b();

        @Override // i1.p
        public void N0() {
            b bVar;
            super.N0();
            synchronized (this.f7132j0) {
                bVar = this.f7132j0;
                this.f7132j0 = new b();
            }
            bVar.b();
        }
    }

    public static b8.t0 c(Activity activity, final b8.t0 t0Var) {
        if (activity != null) {
            if (activity instanceof i1.u) {
                Objects.requireNonNull(t0Var);
                h((i1.u) activity, new Runnable() { // from class: e8.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        t0Var.remove();
                    }
                });
            } else {
                Objects.requireNonNull(t0Var);
                g(activity, new Runnable() { // from class: e8.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        t0Var.remove();
                    }
                });
            }
        }
        return t0Var;
    }

    public static <T> T d(Class<T> cls, Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Fragment with tag '" + str + "' is a " + obj.getClass().getName() + " but should be a " + cls.getName());
        }
    }

    public static /* synthetic */ void e(Activity activity, Runnable runnable) {
        c cVar = (c) d(c.class, activity.getFragmentManager().findFragmentByTag("FirestoreOnStopObserverFragment"), "FirestoreOnStopObserverFragment");
        if (cVar == null || cVar.isRemoving()) {
            cVar = new c();
            activity.getFragmentManager().beginTransaction().add(cVar, "FirestoreOnStopObserverFragment").commitAllowingStateLoss();
            activity.getFragmentManager().executePendingTransactions();
        }
        cVar.f7131a.a(runnable);
    }

    public static /* synthetic */ void f(i1.u uVar, Runnable runnable) {
        C0124d c0124d = (C0124d) d(C0124d.class, uVar.S().i0("FirestoreOnStopObserverSupportFragment"), "FirestoreOnStopObserverSupportFragment");
        if (c0124d == null || c0124d.f0()) {
            c0124d = new C0124d();
            uVar.S().n().d(c0124d, "FirestoreOnStopObserverSupportFragment").g();
            uVar.S().e0();
        }
        c0124d.f7132j0.a(runnable);
    }

    public static void g(final Activity activity, final Runnable runnable) {
        l8.b.d(!(activity instanceof i1.u), "onActivityStopCallOnce must be called with a *non*-FragmentActivity Activity.", new Object[0]);
        activity.runOnUiThread(new Runnable() { // from class: e8.b
            @Override // java.lang.Runnable
            public final void run() {
                d.e(activity, runnable);
            }
        });
    }

    public static void h(final i1.u uVar, final Runnable runnable) {
        uVar.runOnUiThread(new Runnable() { // from class: e8.c
            @Override // java.lang.Runnable
            public final void run() {
                d.f(uVar, runnable);
            }
        });
    }
}
