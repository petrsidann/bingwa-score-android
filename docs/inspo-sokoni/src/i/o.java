package i;

import java.util.LinkedHashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static l0.j a(l0.j jVar, l0.j jVar2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i10 = 0;
        while (i10 < jVar.f() + jVar2.f()) {
            Locale localeC = i10 < jVar.f() ? jVar.c(i10) : jVar2.c(i10 - jVar.f());
            if (localeC != null) {
                linkedHashSet.add(localeC);
            }
            i10++;
        }
        return l0.j.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    public static l0.j b(l0.j jVar, l0.j jVar2) {
        return (jVar == null || jVar.e()) ? l0.j.d() : a(jVar, jVar2);
    }
}
