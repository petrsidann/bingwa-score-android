package ld;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static final void a(oc.i iVar, Throwable th) {
        Iterator<gd.k0> it = g.a().iterator();
        while (it.hasNext()) {
            try {
                it.next().v(iVar, th);
            } catch (Throwable th2) {
                g.b(gd.l0.b(th, th2));
            }
        }
        try {
            lc.a.a(th, new i(iVar));
        } catch (Throwable unused) {
        }
        g.b(th);
    }
}
