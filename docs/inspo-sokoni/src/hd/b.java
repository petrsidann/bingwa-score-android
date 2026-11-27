package hd;

import android.os.Build;
import gd.k0;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import oc.i;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends oc.a implements k0 {
    private volatile Object _preHandler;

    public b() {
        super(k0.f9230h);
        this._preHandler = this;
    }

    public final Method c0() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            boolean z10 = false;
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            if (Modifier.isPublic(declaredMethod.getModifiers()) && Modifier.isStatic(declaredMethod.getModifiers())) {
                z10 = true;
            }
            if (z10) {
                method = declaredMethod;
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    @Override // gd.k0
    public void v(i iVar, Throwable th) {
        if (Build.VERSION.SDK_INT < 28) {
            Method methodC0 = c0();
            Object objInvoke = methodC0 != null ? methodC0.invoke(null, new Object[0]) : null;
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = objInvoke instanceof Thread.UncaughtExceptionHandler ? (Thread.UncaughtExceptionHandler) objInvoke : null;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
        }
    }
}
