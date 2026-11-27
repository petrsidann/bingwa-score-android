package j2;

import android.app.Activity;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import lc.q;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f11166a;

    public static final class a<T> implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cd.c<T> f11167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xc.l<T, q> f11168b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(cd.c<T> clazz, xc.l<? super T, q> consumer) {
            kotlin.jvm.internal.k.e(clazz, "clazz");
            kotlin.jvm.internal.k.e(consumer, "consumer");
            this.f11167a = clazz;
            this.f11168b = consumer;
        }

        public final void a(T parameter) {
            kotlin.jvm.internal.k.e(parameter, "parameter");
            this.f11168b.invoke(parameter);
        }

        public final boolean b(Method method, Object[] objArr) {
            if (kotlin.jvm.internal.k.a(method.getName(), "accept")) {
                return objArr != null && objArr.length == 1;
            }
            return false;
        }

        public final boolean c(Method method, Object[] objArr) {
            if (kotlin.jvm.internal.k.a(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE)) {
                return objArr != null && objArr.length == 1;
            }
            return false;
        }

        public final boolean d(Method method, Object[] objArr) {
            return kotlin.jvm.internal.k.a(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null;
        }

        public final boolean e(Method method, Object[] objArr) {
            return kotlin.jvm.internal.k.a(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            kotlin.jvm.internal.k.e(obj, "obj");
            kotlin.jvm.internal.k.e(method, "method");
            if (b(method, objArr)) {
                a(cd.d.a(this.f11167a, objArr != null ? objArr[0] : null));
                return q.f12711a;
            }
            if (c(method, objArr)) {
                return Boolean.valueOf(obj == (objArr != null ? objArr[0] : null));
            }
            if (d(method, objArr)) {
                return Integer.valueOf(this.f11168b.hashCode());
            }
            if (e(method, objArr)) {
                return this.f11168b.toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }
    }

    public interface b {
        void d();
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f11169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f11170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f11171c;

        public c(Method method, Object obj, Object obj2) {
            this.f11169a = method;
            this.f11170b = obj;
            this.f11171c = obj2;
        }

        @Override // j2.d.b
        public void d() throws IllegalAccessException, InvocationTargetException {
            this.f11169a.invoke(this.f11170b, this.f11171c);
        }
    }

    public d(ClassLoader loader) {
        kotlin.jvm.internal.k.e(loader, "loader");
        this.f11166a = loader;
    }

    public final <T> Object a(cd.c<T> cVar, xc.l<? super T, q> lVar) {
        Object objNewProxyInstance = Proxy.newProxyInstance(this.f11166a, new Class[]{d()}, new a(cVar, lVar));
        kotlin.jvm.internal.k.d(objNewProxyInstance, "newProxyInstance(loader,…onsumerClass()), handler)");
        return objNewProxyInstance;
    }

    public final Class<?> b() {
        try {
            return d();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final <T> b c(Object obj, cd.c<T> clazz, String addMethodName, String removeMethodName, Activity activity, xc.l<? super T, q> consumer) throws IllegalAccessException, InvocationTargetException {
        kotlin.jvm.internal.k.e(obj, "obj");
        kotlin.jvm.internal.k.e(clazz, "clazz");
        kotlin.jvm.internal.k.e(addMethodName, "addMethodName");
        kotlin.jvm.internal.k.e(removeMethodName, "removeMethodName");
        kotlin.jvm.internal.k.e(activity, "activity");
        kotlin.jvm.internal.k.e(consumer, "consumer");
        Object objA = a(clazz, consumer);
        obj.getClass().getMethod(addMethodName, Activity.class, d()).invoke(obj, activity, objA);
        return new c(obj.getClass().getMethod(removeMethodName, d()), obj, objA);
    }

    public final Class<?> d() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f11166a.loadClass("java.util.function.Consumer");
        kotlin.jvm.internal.k.d(clsLoadClass, "loader.loadClass(\"java.util.function.Consumer\")");
        return clsLoadClass;
    }
}
