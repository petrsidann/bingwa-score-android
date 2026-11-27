package gd;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 {
    public static final void a(oc.i iVar, Throwable th) {
        try {
            k0 k0Var = (k0) iVar.get(k0.f9230h);
            if (k0Var != null) {
                k0Var.v(iVar, th);
            } else {
                ld.h.a(iVar, th);
            }
        } catch (Throwable th2) {
            ld.h.a(iVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        lc.a.a(runtimeException, th);
        return runtimeException;
    }
}
