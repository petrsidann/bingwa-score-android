package g0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f8455a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<d, SparseArray<c>> f8456b = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f8457c = new Object();

    public static class a {
        public static Drawable a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getDrawable(i10, theme);
        }

        public static Drawable b(Resources resources, int i10, int i11, Resources.Theme theme) {
            return resources.getDrawableForDensity(i10, i11, theme);
        }
    }

    public static class b {
        public static int a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColor(i10, theme);
        }

        public static ColorStateList b(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColorStateList(i10, theme);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ColorStateList f8458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Configuration f8459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8460c;

        public c(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f8458a = colorStateList;
            this.f8459b = configuration;
            this.f8460c = theme == null ? 0 : theme.hashCode();
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f8461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Resources.Theme f8462b;

        public d(Resources resources, Resources.Theme theme) {
            this.f8461a = resources;
            this.f8462b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f8461a.equals(dVar.f8461a) && o0.c.a(this.f8462b, dVar.f8462b);
        }

        public int hashCode() {
            return o0.c.b(this.f8461a, this.f8462b);
        }
    }

    public static abstract class e {
        public static Handler e(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(final int i10, Handler handler) {
            e(handler).post(new Runnable() { // from class: g0.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f8468a.f(i10);
                }
            });
        }

        public final void d(final Typeface typeface, Handler handler) {
            e(handler).post(new Runnable() { // from class: g0.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f8466a.g(typeface);
                }
            });
        }

        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public abstract void f(int i10);

        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public abstract void g(Typeface typeface);
    }

    public static final class f {

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Object f8463a = new Object();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static Method f8464b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static boolean f8465c;

            /* JADX WARN: Code duplicated, block: B:30:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            public static void a(Resources.Theme theme) {
                Method method;
                synchronized (f8463a) {
                    if (f8465c) {
                        method = f8464b;
                        if (method != null) {
                            method.invoke(theme, new Object[0]);
                        }
                    } else {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f8464b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e10) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e10);
                        }
                        f8465c = true;
                        method = f8464b;
                        if (method != null) {
                            try {
                                method.invoke(theme, new Object[0]);
                            } catch (IllegalAccessException | InvocationTargetException e11) {
                                Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e11);
                                f8464b = null;
                            }
                        }
                    }
                    throw th;
                }
            }
        }

        public static class b {
            public static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                b.a(theme);
            } else {
                a.a(theme);
            }
        }
    }

    public static void a(d dVar, int i10, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f8457c) {
            WeakHashMap<d, SparseArray<c>> weakHashMap = f8456b;
            SparseArray<c> sparseArray = weakHashMap.get(dVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(dVar, sparseArray);
            }
            sparseArray.append(i10, new c(colorStateList, dVar.f8461a.getConfiguration(), theme));
        }
    }

    public static ColorStateList b(d dVar, int i10) {
        c cVar;
        Resources.Theme theme;
        synchronized (f8457c) {
            SparseArray<c> sparseArray = f8456b.get(dVar);
            if (sparseArray != null && sparseArray.size() > 0 && (cVar = sparseArray.get(i10)) != null) {
                if (cVar.f8459b.equals(dVar.f8461a.getConfiguration()) && (((theme = dVar.f8462b) == null && cVar.f8460c == 0) || (theme != null && cVar.f8460c == theme.hashCode()))) {
                    return cVar.f8458a;
                }
                sparseArray.remove(i10);
            }
            return null;
        }
    }

    public static Typeface c(Context context, int i10) {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i10, new TypedValue(), 0, null, null, false, true);
    }

    public static ColorStateList d(Resources resources, int i10, Resources.Theme theme) {
        d dVar = new d(resources, theme);
        ColorStateList colorStateListB = b(dVar, i10);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListK = k(resources, i10, theme);
        if (colorStateListK == null) {
            return b.b(resources, i10, theme);
        }
        a(dVar, i10, colorStateListK, theme);
        return colorStateListK;
    }

    public static Drawable e(Resources resources, int i10, Resources.Theme theme) {
        return a.a(resources, i10, theme);
    }

    public static Drawable f(Resources resources, int i10, int i11, Resources.Theme theme) {
        return a.b(resources, i10, i11, theme);
    }

    public static Typeface g(Context context, int i10) {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i10, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface h(Context context, int i10, TypedValue typedValue, int i11, e eVar) {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i10, typedValue, i11, eVar, null, true, false);
    }

    public static void i(Context context, int i10, e eVar, Handler handler) {
        o0.h.g(eVar);
        if (context.isRestricted()) {
            eVar.c(-4, handler);
        } else {
            m(context, i10, new TypedValue(), 0, eVar, handler, false, false);
        }
    }

    public static TypedValue j() {
        ThreadLocal<TypedValue> threadLocal = f8455a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList k(Resources resources, int i10, Resources.Theme theme) {
        if (l(resources, i10)) {
            return null;
        }
        try {
            return g0.c.a(resources, resources.getXml(i10), theme);
        } catch (Exception e10) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e10);
            return null;
        }
    }

    public static boolean l(Resources resources, int i10) {
        TypedValue typedValueJ = j();
        resources.getValue(i10, typedValueJ, true);
        int i11 = typedValueJ.type;
        return i11 >= 28 && i11 <= 31;
    }

    public static Typeface m(Context context, int i10, TypedValue typedValue, int i11, e eVar, Handler handler, boolean z10, boolean z11) {
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        Typeface typefaceN = n(context, resources, typedValue, i10, i11, eVar, handler, z10, z11);
        if (typefaceN != null || eVar != null || z11) {
            return typefaceN;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i10) + " could not be retrieved.");
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00aa  */
    public static Typeface n(Context context, Resources resources, TypedValue typedValue, int i10, int i11, e eVar, Handler handler, boolean z10, boolean z11) {
        StringBuilder sb2;
        String str;
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i10) + "\" (" + Integer.toHexString(i10) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        if (!string.startsWith("res/")) {
            if (eVar != null) {
                eVar.c(-3, handler);
            }
            return null;
        }
        Typeface typefaceF = h0.j.f(resources, i10, string, typedValue.assetCookie, i11);
        if (typefaceF != null) {
            if (eVar != null) {
                eVar.d(typefaceF, handler);
            }
            return typefaceF;
        }
        if (z11) {
            return null;
        }
        try {
            if (!string.toLowerCase().endsWith(".xml")) {
                Typeface typefaceD = h0.j.d(context, resources, i10, string, typedValue.assetCookie, i11);
                if (eVar != null) {
                    if (typefaceD != null) {
                        eVar.d(typefaceD, handler);
                    } else {
                        eVar.c(-3, handler);
                    }
                }
                return typefaceD;
            }
            g0.e.b bVarB = g0.e.b(resources.getXml(i10), resources);
            if (bVarB != null) {
                return h0.j.c(context, bVarB, resources, i10, string, typedValue.assetCookie, i11, eVar, handler, z10);
            }
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            if (eVar != null) {
                eVar.c(-3, handler);
            }
            return null;
        } catch (IOException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "Failed to read xml resource ";
            sb2.append(str);
            sb2.append(string);
            Log.e("ResourcesCompat", sb2.toString(), e);
            if (eVar != null) {
                eVar.c(-3, handler);
            }
            return null;
        } catch (XmlPullParserException e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "Failed to parse xml resource ";
            sb2.append(str);
            sb2.append(string);
            Log.e("ResourcesCompat", sb2.toString(), e);
            if (eVar != null) {
                eVar.c(-3, handler);
            }
            return null;
        }
    }
}
