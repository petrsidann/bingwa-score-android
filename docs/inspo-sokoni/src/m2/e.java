package m2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.lang.reflect.Method;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f12921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j2.d f12922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i2.a f12923c;

    public static final class a extends kotlin.jvm.internal.l implements xc.a<Boolean> {
        public a() {
            super(0);
        }

        @Override // xc.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
            Class clsF = e.this.f();
            boolean z10 = false;
            Method getBoundsMethod = clsF.getMethod("getBounds", new Class[0]);
            Method getTypeMethod = clsF.getMethod("getType", new Class[0]);
            Method getStateMethod = clsF.getMethod("getState", new Class[0]);
            r2.a aVar = r2.a.f14994a;
            kotlin.jvm.internal.k.d(getBoundsMethod, "getBoundsMethod");
            if (aVar.b(getBoundsMethod, u.b(Rect.class)) && aVar.d(getBoundsMethod)) {
                kotlin.jvm.internal.k.d(getTypeMethod, "getTypeMethod");
                Class cls = Integer.TYPE;
                if (aVar.b(getTypeMethod, u.b(cls)) && aVar.d(getTypeMethod)) {
                    kotlin.jvm.internal.k.d(getStateMethod, "getStateMethod");
                    if (aVar.b(getStateMethod, u.b(cls)) && aVar.d(getStateMethod)) {
                        z10 = true;
                    }
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class b extends kotlin.jvm.internal.l implements xc.a<Boolean> {
        public b() {
            super(0);
        }

        @Override // xc.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
            Class<?> clsB = e.this.f12922b.b();
            if (clsB == null) {
                return Boolean.FALSE;
            }
            Class clsH = e.this.h();
            boolean z10 = false;
            Method addListenerMethod = clsH.getMethod("addWindowLayoutInfoListener", Activity.class, clsB);
            Method removeListenerMethod = clsH.getMethod("removeWindowLayoutInfoListener", clsB);
            r2.a aVar = r2.a.f14994a;
            kotlin.jvm.internal.k.d(addListenerMethod, "addListenerMethod");
            if (aVar.d(addListenerMethod)) {
                kotlin.jvm.internal.k.d(removeListenerMethod, "removeListenerMethod");
                if (aVar.d(removeListenerMethod)) {
                    z10 = true;
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class c extends kotlin.jvm.internal.l implements xc.a<Boolean> {
        public c() {
            super(0);
        }

        @Override // xc.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
            Class clsH = e.this.h();
            boolean z10 = false;
            Method addListenerMethod = clsH.getMethod("addWindowLayoutInfoListener", Context.class, Consumer.class);
            Method removeListenerMethod = clsH.getMethod("removeWindowLayoutInfoListener", Consumer.class);
            r2.a aVar = r2.a.f14994a;
            kotlin.jvm.internal.k.d(addListenerMethod, "addListenerMethod");
            if (aVar.d(addListenerMethod)) {
                kotlin.jvm.internal.k.d(removeListenerMethod, "removeListenerMethod");
                if (aVar.d(removeListenerMethod)) {
                    z10 = true;
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class d extends kotlin.jvm.internal.l implements xc.a<Boolean> {
        public d() {
            super(0);
        }

        @Override // xc.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
            boolean z10 = false;
            Method getWindowLayoutComponentMethod = e.this.f12923c.c().getMethod("getWindowLayoutComponent", new Class[0]);
            Class<?> clsH = e.this.h();
            r2.a aVar = r2.a.f14994a;
            kotlin.jvm.internal.k.d(getWindowLayoutComponentMethod, "getWindowLayoutComponentMethod");
            if (aVar.d(getWindowLayoutComponentMethod) && aVar.c(getWindowLayoutComponentMethod, clsH)) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    public e(ClassLoader loader, j2.d consumerAdapter) {
        kotlin.jvm.internal.k.e(loader, "loader");
        kotlin.jvm.internal.k.e(consumerAdapter, "consumerAdapter");
        this.f12921a = loader;
        this.f12922b = consumerAdapter;
        this.f12923c = new i2.a(loader);
    }

    public final boolean e() {
        if (!n()) {
            return false;
        }
        int iA = j2.e.f11172a.a();
        if (iA == 1) {
            return i();
        }
        if (2 <= iA && iA <= Integer.MAX_VALUE) {
            return j();
        }
        return false;
    }

    public final Class<?> f() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f12921a.loadClass("androidx.window.extensions.layout.FoldingFeature");
        kotlin.jvm.internal.k.d(clsLoadClass, "loader.loadClass(FOLDING_FEATURE_CLASS)");
        return clsLoadClass;
    }

    public final WindowLayoutComponent g() {
        if (!e()) {
            return null;
        }
        try {
            return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    public final Class<?> h() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f12921a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
        kotlin.jvm.internal.k.d(clsLoadClass, "loader.loadClass(WINDOW_LAYOUT_COMPONENT_CLASS)");
        return clsLoadClass;
    }

    public final boolean i() {
        return l();
    }

    public final boolean j() {
        return i() && m();
    }

    public final boolean k() {
        return r2.a.e("FoldingFeature class is not valid", new a());
    }

    public final boolean l() {
        return r2.a.e("WindowLayoutComponent#addWindowLayoutInfoListener(" + Activity.class.getName() + ", java.util.function.Consumer) is not valid", new b());
    }

    public final boolean m() {
        return r2.a.e("WindowLayoutComponent#addWindowLayoutInfoListener(" + Context.class.getName() + ", androidx.window.extensions.core.util.function.Consumer) is not valid", new c());
    }

    public final boolean n() {
        return this.f12923c.f() && o() && k();
    }

    public final boolean o() {
        return r2.a.e("WindowExtensions#getWindowLayoutComponent is not valid", new d());
    }
}
