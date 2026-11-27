package i2;

import java.lang.reflect.Method;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f10494a;

    /* JADX INFO: renamed from: i2.a$a, reason: collision with other inner class name */
    public static final class C0172a extends l implements xc.a<Class<?>> {
        public C0172a() {
            super(0);
        }

        @Override // xc.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Class<?> invoke() throws ClassNotFoundException {
            Class<?> clsLoadClass = a.this.f10494a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
            k.d(clsLoadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
            return clsLoadClass;
        }
    }

    public static final class b extends l implements xc.a<Boolean> {
        public b() {
            super(0);
        }

        @Override // xc.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
            boolean z10 = false;
            Method getWindowExtensionsMethod = a.this.d().getDeclaredMethod("getWindowExtensions", new Class[0]);
            Class<?> clsC = a.this.c();
            r2.a aVar = r2.a.f14994a;
            k.d(getWindowExtensionsMethod, "getWindowExtensionsMethod");
            if (aVar.c(getWindowExtensionsMethod, clsC) && aVar.d(getWindowExtensionsMethod)) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    public a(ClassLoader loader) {
        k.e(loader, "loader");
        this.f10494a = loader;
    }

    public final Class<?> c() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f10494a.loadClass("androidx.window.extensions.WindowExtensions");
        k.d(clsLoadClass, "loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)");
        return clsLoadClass;
    }

    public final Class<?> d() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f10494a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
        k.d(clsLoadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
        return clsLoadClass;
    }

    public final boolean e() {
        return r2.a.f14994a.a(new C0172a());
    }

    public final boolean f() {
        return e() && r2.a.e("WindowExtensionsProvider#getWindowExtensions is not valid", new b());
    }
}
