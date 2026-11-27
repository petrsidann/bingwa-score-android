package gd;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(oc.e<?> eVar) {
        Object objB;
        if (eVar instanceof ld.j) {
            return eVar.toString();
        }
        try {
            lc.j.a aVar = lc.j.f12703b;
            objB = lc.j.b(eVar + '@' + b(eVar));
        } catch (Throwable th) {
            lc.j.a aVar2 = lc.j.f12703b;
            objB = lc.j.b(lc.k.a(th));
        }
        if (lc.j.d(objB) != null) {
            objB = eVar.getClass().getName() + '@' + b(eVar);
        }
        return (String) objB;
    }
}
