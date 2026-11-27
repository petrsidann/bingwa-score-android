package h0;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class l extends k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class<?> f9569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Constructor<?> f9570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Method f9571i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Method f9572j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Method f9573k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Method f9574l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Method f9575m;

    public l() {
        Class<?> clsT;
        Constructor<?> constructorU;
        Method methodQ;
        Method methodR;
        Method methodV;
        Method methodP;
        Method methodS;
        try {
            clsT = t();
            constructorU = u(clsT);
            methodQ = q(clsT);
            methodR = r(clsT);
            methodV = v(clsT);
            methodP = p(clsT);
            methodS = s(clsT);
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e10.getClass().getName(), e10);
            clsT = null;
            constructorU = null;
            methodQ = null;
            methodR = null;
            methodV = null;
            methodP = null;
            methodS = null;
        }
        this.f9569g = clsT;
        this.f9570h = constructorU;
        this.f9571i = methodQ;
        this.f9572j = methodR;
        this.f9573k = methodV;
        this.f9574l = methodP;
        this.f9575m = methodS;
    }

    private Object j() {
        try {
            return this.f9570h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // h0.k, h0.c0
    public Typeface a(Context context, g0.e.c cVar, Resources resources, int i10) {
        if (!o()) {
            return super.a(context, cVar, resources, i10);
        }
        Object objJ = j();
        if (objJ == null) {
            return null;
        }
        for (g0.e.d dVar : cVar.a()) {
            if (!l(context, objJ, dVar.a(), dVar.c(), dVar.e(), dVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(dVar.d()))) {
                k(objJ);
                return null;
            }
        }
        if (n(objJ)) {
            return h(objJ);
        }
        return null;
    }

    @Override // h0.c0
    public Typeface b(Context context, CancellationSignal cancellationSignal, m0.g.b[] bVarArr, int i10) {
        Typeface typefaceH;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!o()) {
            m0.g.b bVarF = f(bVarArr, i10);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(bVarF.d(), "r", cancellationSignal);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(bVarF.e()).setItalic(bVarF.f()).build();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceBuild;
                } catch (Throwable th) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> mapF = d0.f(context, bVarArr, cancellationSignal);
        Object objJ = j();
        if (objJ == null) {
            return null;
        }
        boolean z10 = false;
        for (m0.g.b bVar : bVarArr) {
            ByteBuffer byteBuffer = mapF.get(bVar.d());
            if (byteBuffer != null) {
                if (!m(objJ, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                    k(objJ);
                    return null;
                }
                z10 = true;
            }
        }
        if (!z10) {
            k(objJ);
            return null;
        }
        if (n(objJ) && (typefaceH = h(objJ)) != null) {
            return Typeface.create(typefaceH, i10);
        }
        return null;
    }

    @Override // h0.c0
    public Typeface c(Context context, Resources resources, int i10, String str, int i11) {
        if (!o()) {
            return super.c(context, resources, i10, str, i11);
        }
        Object objJ = j();
        if (objJ == null) {
            return null;
        }
        if (!l(context, objJ, str, 0, -1, -1, null)) {
            k(objJ);
            return null;
        }
        if (n(objJ)) {
            return h(objJ);
        }
        return null;
    }

    public Typeface h(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(this.f9569g, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f9575m.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final void k(Object obj) {
        try {
            this.f9574l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean l(Context context, Object obj, String str, int i10, int i11, int i12, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f9571i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean m(Object obj, ByteBuffer byteBuffer, int i10, int i11, int i12) {
        try {
            return ((Boolean) this.f9572j.invoke(obj, byteBuffer, Integer.valueOf(i10), null, Integer.valueOf(i11), Integer.valueOf(i12))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean n(Object obj) {
        try {
            return ((Boolean) this.f9573k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean o() {
        if (this.f9571i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f9571i != null;
    }

    public Method p(Class<?> cls) {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    public Method q(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public Method r(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public Method s(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public Class<?> t() {
        return Class.forName("android.graphics.FontFamily");
    }

    public Constructor<?> u(Class<?> cls) {
        return cls.getConstructor(new Class[0]);
    }

    public Method v(Class<?> cls) {
        return cls.getMethod("freeze", new Class[0]);
    }
}
