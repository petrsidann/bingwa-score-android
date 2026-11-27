package ld;

import gd.k2;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f12776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f12777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k2 f12778c;

    static {
        w wVar = new w();
        f12776a = wVar;
        f12777b = i0.f("kotlinx.coroutines.fast.service.loader", true);
        f12778c = wVar.a();
    }

    public final k2 a() {
        Object next;
        k2 k2VarE;
        try {
            List<v> listC = f12777b ? l.f12737a.c() : dd.i.f(dd.g.c(ServiceLoader.load(v.class, v.class.getClassLoader()).iterator()));
            Iterator<T> it = listC.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iC = ((v) next).c();
                    do {
                        Object next2 = it.next();
                        int iC2 = ((v) next2).c();
                        if (iC < iC2) {
                            next = next2;
                            iC = iC2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            v vVar = (v) next;
            return (vVar == null || (k2VarE = x.e(vVar, listC)) == null) ? x.b(null, null, 3, null) : k2VarE;
        } catch (Throwable th) {
            return x.b(th, null, 2, null);
        }
    }
}
