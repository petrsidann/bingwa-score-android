package e3;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f6984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f6985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, m> f6986c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f6987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f6988b = null;

        public a(Context context) {
            this.f6987a = context;
        }

        public static Bundle d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        public final Map<String, String> a(Context context) {
            Bundle bundleD = d(context);
            if (bundleD == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap map = new HashMap();
            for (String str : bundleD.keySet()) {
                Object obj = bundleD.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(",", -1)) {
                        String strTrim = str2.trim();
                        if (!strTrim.isEmpty()) {
                            map.put(strTrim, str.substring(8));
                        }
                    }
                }
            }
            return map;
        }

        public d b(String str) {
            String str2;
            String str3;
            String str4 = c().get(str);
            if (str4 == null) {
                return null;
            }
            try {
                return (d) Class.forName(str4).asSubclass(d.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e10) {
                e = e10;
                str3 = String.format("Class %s is not found.", str4);
                Log.w("BackendRegistry", str3, e);
                return null;
            } catch (IllegalAccessException e11) {
                e = e11;
                str3 = String.format("Could not instantiate %s.", str4);
                Log.w("BackendRegistry", str3, e);
                return null;
            } catch (InstantiationException e12) {
                e = e12;
                str3 = String.format("Could not instantiate %s.", str4);
                Log.w("BackendRegistry", str3, e);
                return null;
            } catch (NoSuchMethodException e13) {
                e = e13;
                str2 = String.format("Could not instantiate %s", str4);
                Log.w("BackendRegistry", str2, e);
                return null;
            } catch (InvocationTargetException e14) {
                e = e14;
                str2 = String.format("Could not instantiate %s", str4);
                Log.w("BackendRegistry", str2, e);
                return null;
            }
        }

        public final Map<String, String> c() {
            if (this.f6988b == null) {
                this.f6988b = a(this.f6987a);
            }
            return this.f6988b;
        }
    }

    public k(Context context, i iVar) {
        this(new a(context), iVar);
    }

    public k(a aVar, i iVar) {
        this.f6986c = new HashMap();
        this.f6984a = aVar;
        this.f6985b = iVar;
    }

    @Override // e3.e
    public synchronized m a(String str) {
        if (this.f6986c.containsKey(str)) {
            return this.f6986c.get(str);
        }
        d dVarB = this.f6984a.b(str);
        if (dVarB == null) {
            return null;
        }
        m mVarCreate = dVarB.create(this.f6985b.a(str));
        this.f6986c.put(str, mVarCreate);
        return mVarCreate;
    }
}
