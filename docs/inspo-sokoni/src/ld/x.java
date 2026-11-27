package ld;

import gd.k2;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f12779a = true;

    public static final y a(Throwable th, String str) throws Throwable {
        if (f12779a) {
            return new y(th, str);
        }
        if (th != null) {
            throw th;
        }
        d();
        throw new lc.c();
    }

    public static /* synthetic */ y b(Throwable th, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            th = null;
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final boolean c(k2 k2Var) {
        return k2Var.f0() instanceof y;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final k2 e(v vVar, List<? extends v> list) {
        try {
            return vVar.b(list);
        } catch (Throwable th) {
            return a(th, vVar.a());
        }
    }
}
