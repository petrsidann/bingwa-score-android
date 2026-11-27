package h0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class k extends c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f9564b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Constructor<?> f9565c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f9566d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f9567e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f9568f = false;

    public static boolean g(Object obj, String str, int i10, boolean z10) {
        i();
        try {
            return ((Boolean) f9566d.invoke(obj, str, Integer.valueOf(i10), Boolean.valueOf(z10))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static Typeface h(Object obj) {
        i();
        try {
            Object objNewInstance = Array.newInstance(f9564b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f9567e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static void i() {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        if (f9568f) {
            return;
        }
        f9568f = true;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            Log.e("TypefaceCompatApi21Impl", e10.getClass().getName(), e10);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        f9565c = constructor;
        f9564b = cls;
        f9566d = method2;
        f9567e = method;
    }

    public static Object j() {
        i();
        try {
            return f9565c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // h0.c0
    public Typeface a(Context context, g0.e.c cVar, Resources resources, int i10) {
        Object objJ = j();
        for (g0.e.d dVar : cVar.a()) {
            File fileD = d0.d(context);
            if (fileD == null) {
                return null;
            }
            try {
                if (!d0.b(fileD, resources, dVar.b())) {
                    fileD.delete();
                    return null;
                }
                boolean zG = g(objJ, fileD.getPath(), dVar.e(), dVar.f());
                fileD.delete();
                if (!zG) {
                    return null;
                }
            } catch (RuntimeException unused) {
                fileD.delete();
                return null;
            } catch (Throwable th) {
                fileD.delete();
                throw th;
            }
        }
        return h(objJ);
    }
}
