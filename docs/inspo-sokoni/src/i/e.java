package i;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static m.a f9964a = new m.a(new m.b());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f9965b = -100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static l0.j f9966c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static l0.j f9967d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f9968e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f9969f = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final t.b<WeakReference<e>> f9970l = new t.b<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f9971m = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Object f9972n = new Object();

    public static class a {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    public static class b {
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    public static void E(e eVar) {
        synchronized (f9971m) {
            F(eVar);
        }
    }

    public static void F(e eVar) {
        synchronized (f9971m) {
            Iterator<WeakReference<e>> it = f9970l.iterator();
            while (it.hasNext()) {
                e eVar2 = it.next().get();
                if (eVar2 == eVar || eVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public static void N(final Context context) {
        if (u(context)) {
            if (l0.a.b()) {
                if (f9969f) {
                    return;
                }
                f9964a.execute(new Runnable() { // from class: i.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.v(context);
                    }
                });
                return;
            }
            synchronized (f9972n) {
                l0.j jVar = f9966c;
                if (jVar == null) {
                    if (f9967d == null) {
                        f9967d = l0.j.b(m.b(context));
                    }
                    if (f9967d.e()) {
                    } else {
                        f9966c = f9967d;
                    }
                } else if (!jVar.equals(f9967d)) {
                    l0.j jVar2 = f9966c;
                    f9967d = jVar2;
                    m.a(context, jVar2.g());
                }
            }
        }
    }

    public static void d(e eVar) {
        synchronized (f9971m) {
            F(eVar);
            f9970l.add(new WeakReference<>(eVar));
        }
    }

    public static e h(Activity activity, c cVar) {
        return new f(activity, cVar);
    }

    public static e i(Dialog dialog, c cVar) {
        return new f(dialog, cVar);
    }

    public static l0.j k() {
        if (l0.a.b()) {
            Object objO = o();
            if (objO != null) {
                return l0.j.i(b.a(objO));
            }
        } else {
            l0.j jVar = f9966c;
            if (jVar != null) {
                return jVar;
            }
        }
        return l0.j.d();
    }

    public static int m() {
        return f9965b;
    }

    public static Object o() {
        Context contextL;
        Iterator<WeakReference<e>> it = f9970l.iterator();
        while (it.hasNext()) {
            e eVar = it.next().get();
            if (eVar != null && (contextL = eVar.l()) != null) {
                return contextL.getSystemService("locale");
            }
        }
        return null;
    }

    public static l0.j q() {
        return f9966c;
    }

    public static boolean u(Context context) {
        if (f9968e == null) {
            try {
                Bundle bundle = k.a(context).metaData;
                if (bundle != null) {
                    f9968e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f9968e = Boolean.FALSE;
            }
        }
        return f9968e.booleanValue();
    }

    public static /* synthetic */ void v(Context context) {
        m.c(context);
        f9969f = true;
    }

    public abstract void A();

    public abstract void B(Bundle bundle);

    public abstract void C();

    public abstract void D();

    public abstract boolean G(int i10);

    public abstract void H(int i10);

    public abstract void I(View view);

    public abstract void J(View view, ViewGroup.LayoutParams layoutParams);

    public void K(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public void L(int i10) {
    }

    public abstract void M(CharSequence charSequence);

    public abstract void e(View view, ViewGroup.LayoutParams layoutParams);

    @Deprecated
    public void f(Context context) {
    }

    public Context g(Context context) {
        f(context);
        return context;
    }

    public abstract <T extends View> T j(int i10);

    public Context l() {
        return null;
    }

    public int n() {
        return -100;
    }

    public abstract MenuInflater p();

    public abstract i.a r();

    public abstract void s();

    public abstract void t();

    public abstract void w(Configuration configuration);

    public abstract void x(Bundle bundle);

    public abstract void y();

    public abstract void z(Bundle bundle);
}
