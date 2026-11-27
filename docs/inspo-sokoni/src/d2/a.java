package d2;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.startup.InitializationProvider;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f6275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f6276e = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f6279c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Class<? extends b<?>>> f6278b = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, Object> f6277a = new HashMap();

    public a(Context context) {
        this.f6279c = context.getApplicationContext();
    }

    public static a e(Context context) {
        if (f6275d == null) {
            synchronized (f6276e) {
                if (f6275d == null) {
                    f6275d = new a(context);
                }
            }
        }
        return f6275d;
    }

    public void a() {
        try {
            try {
                e2.a.c("Startup");
                b(this.f6279c.getPackageManager().getProviderInfo(new ComponentName(this.f6279c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
                e2.a.f();
            } catch (PackageManager.NameNotFoundException e10) {
                throw new d(e10);
            }
        } catch (Throwable th) {
            e2.a.f();
            throw th;
        }
    }

    public void b(Bundle bundle) {
        String string = this.f6279c.getString(c.f6280a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (b.class.isAssignableFrom(cls)) {
                            this.f6278b.add((Class<? extends b<?>>) cls);
                        }
                    }
                }
                Iterator<Class<? extends b<?>>> it = this.f6278b.iterator();
                while (it.hasNext()) {
                    d(it.next(), hashSet);
                }
            } catch (ClassNotFoundException e10) {
                throw new d(e10);
            }
        }
    }

    public <T> T c(Class<? extends b<?>> cls) {
        T t10;
        synchronized (f6276e) {
            t10 = (T) this.f6277a.get(cls);
            if (t10 == null) {
                t10 = (T) d(cls, new HashSet());
            }
        }
        return t10;
    }

    public final <T> T d(Class<? extends b<?>> cls, Set<Class<?>> set) {
        T t10;
        if (e2.a.h()) {
            try {
                e2.a.c(cls.getSimpleName());
            } catch (Throwable th) {
                e2.a.f();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f6277a.containsKey(cls)) {
            t10 = (T) this.f6277a.get(cls);
        } else {
            set.add(cls);
            try {
                b<?> bVarNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends b<?>>> listA = bVarNewInstance.a();
                if (!listA.isEmpty()) {
                    for (Class<? extends b<?>> cls2 : listA) {
                        if (!this.f6277a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                t10 = (T) bVarNewInstance.b(this.f6279c);
                set.remove(cls);
                this.f6277a.put(cls, t10);
            } catch (Throwable th2) {
                throw new d(th2);
            }
        }
        e2.a.f();
        return t10;
    }

    public <T> T f(Class<? extends b<T>> cls) {
        return (T) c(cls);
    }

    public boolean g(Class<? extends b<?>> cls) {
        return this.f6278b.contains(cls);
    }
}
