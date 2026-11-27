package q7;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f14845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c<T> f14846b;

    public static class b implements c<Context> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<? extends Service> f14847a;

        public b(Class<? extends Service> cls) {
            this.f14847a = cls;
        }

        public final Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.f14847a), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("ComponentDiscovery", this.f14847a + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        @Override // q7.f.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public List<String> a(Context context) {
            Bundle bundleB = b(context);
            if (bundleB == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : bundleB.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundleB.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }
    }

    public interface c<T> {
        List<String> a(T t10);
    }

    public f(T t10, c<T> cVar) {
        this.f14845a = t10;
        this.f14846b = cVar;
    }

    public static f<Context> c(Context context, Class<? extends Service> cls) {
        return new f<>(context, new b(cls));
    }

    public static ComponentRegistrar d(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            throw new v(String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar"));
        } catch (ClassNotFoundException unused) {
            Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str));
            return null;
        } catch (IllegalAccessException e10) {
            throw new v(String.format("Could not instantiate %s.", str), e10);
        } catch (InstantiationException e11) {
            throw new v(String.format("Could not instantiate %s.", str), e11);
        } catch (NoSuchMethodException e12) {
            throw new v(String.format("Could not instantiate %s", str), e12);
        } catch (InvocationTargetException e13) {
            throw new v(String.format("Could not instantiate %s", str), e13);
        }
    }

    public List<o8.b<ComponentRegistrar>> b() {
        ArrayList arrayList = new ArrayList();
        for (final String str : this.f14846b.a(this.f14845a)) {
            arrayList.add(new o8.b() { // from class: q7.e
                @Override // o8.b
                public final Object get() {
                    return f.d(str);
                }
            });
        }
        return arrayList;
    }
}
