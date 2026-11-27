package e0;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?> f6744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Field f6745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Field f6746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f6747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f6748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Method f6749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Handler f6750g = new Handler(Looper.getMainLooper());

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f6751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f6752b;

        public a(d dVar, Object obj) {
            this.f6751a = dVar;
            this.f6752b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6751a.f6757a = this.f6752b;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f6753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f6754b;

        public b(Application application, d dVar) {
            this.f6753a = application;
            this.f6754b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6753a.unregisterActivityLifecycleCallbacks(this.f6754b);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f6755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f6756b;

        public c(Object obj, Object obj2) {
            this.f6755a = obj;
            this.f6756b = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = e.f6747d;
                if (method != null) {
                    method.invoke(this.f6755a, this.f6756b, Boolean.FALSE, "AppCompat recreation");
                } else {
                    e.f6748e.invoke(this.f6755a, this.f6756b, Boolean.FALSE);
                }
            } catch (RuntimeException e10) {
                if (e10.getClass() == RuntimeException.class && e10.getMessage() != null && e10.getMessage().startsWith("Unable to stop")) {
                    throw e10;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    public static final class d implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f6757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Activity f6758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f6759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f6760d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f6761e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f6762f = false;

        public d(Activity activity) {
            this.f6758b = activity;
            this.f6759c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f6758b == activity) {
                this.f6758b = null;
                this.f6761e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f6761e || this.f6762f || this.f6760d || !e.h(this.f6757a, this.f6759c, activity)) {
                return;
            }
            this.f6762f = true;
            this.f6757a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f6758b == activity) {
                this.f6760d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> clsA = a();
        f6744a = clsA;
        f6745b = b();
        f6746c = f();
        f6747d = d(clsA);
        f6748e = c(clsA);
        f6749f = e(clsA);
    }

    public static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean g() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 == 26 || i10 == 27;
    }

    public static boolean h(Object obj, int i10, Activity activity) {
        try {
            Object obj2 = f6746c.get(activity);
            if (obj2 == obj && activity.hashCode() == i10) {
                f6750g.postAtFrontOfQueue(new c(f6745b.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    public static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f6749f == null) {
            return false;
        }
        if (f6748e == null && f6747d == null) {
            return false;
        }
        try {
            Object obj2 = f6746c.get(activity);
            if (obj2 == null || (obj = f6745b.get(activity)) == null) {
                return false;
            }
            Application application = activity.getApplication();
            d dVar = new d(activity);
            application.registerActivityLifecycleCallbacks(dVar);
            f6750g.post(new a(dVar, obj2));
            try {
                if (g()) {
                    Method method = f6749f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                return true;
            } finally {
                f6750g.post(new b(application, dVar));
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
