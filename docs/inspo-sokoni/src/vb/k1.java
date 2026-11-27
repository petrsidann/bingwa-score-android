package vb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes2.dex */
public final class k1 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> implements Comparator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f17399a;

        public a(b bVar) {
            this.f17399a = bVar;
        }

        @Override // java.util.Comparator
        public int compare(T t10, T t11) {
            int iB = this.f17399a.b(t10) - this.f17399a.b(t11);
            return iB != 0 ? iB : t10.getClass().getName().compareTo(t11.getClass().getName());
        }
    }

    public interface b<T> {
        boolean a(T t10);

        int b(T t10);
    }

    public static <T> T a(Class<T> cls, Class<?> cls2) {
        try {
            return (T) cls2.asSubclass(cls).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassCastException unused) {
            return null;
        } catch (Throwable th) {
            throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", cls2.getName(), th), th);
        }
    }

    public static <T> Iterable<T> b(Class<T> cls, Iterable<Class<?>> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<Class<?>> it = iterable.iterator();
        while (it.hasNext()) {
            Object objA = a(cls, it.next());
            if (objA != null) {
                arrayList.add(objA);
            }
        }
        return arrayList;
    }

    public static <T> Iterable<T> c(Class<T> cls, ClassLoader classLoader) {
        ServiceLoader serviceLoaderLoad = ServiceLoader.load(cls, classLoader);
        return !serviceLoaderLoad.iterator().hasNext() ? ServiceLoader.load(cls) : serviceLoaderLoad;
    }

    public static boolean d(ClassLoader classLoader) {
        try {
            Class.forName("android.app.Application", false, classLoader);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static <T> List<T> e(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, b<T> bVar) {
        Iterable iterableB = d(classLoader) ? b(cls, iterable) : c(cls, classLoader);
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterableB) {
            if (bVar.a(t10)) {
                arrayList.add(t10);
            }
        }
        Collections.sort(arrayList, Collections.reverseOrder(new a(bVar)));
        return Collections.unmodifiableList(arrayList);
    }
}
