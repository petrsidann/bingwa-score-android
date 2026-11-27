package a9;

import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;
import q7.d;
import q7.g;
import q7.i;

/* JADX INFO: loaded from: classes.dex */
public class b implements i {
    public static /* synthetic */ Object c(String str, q7.c cVar, d dVar) {
        try {
            c.b(str);
            return cVar.h().a(dVar);
        } finally {
            c.a();
        }
    }

    @Override // q7.i
    public List<q7.c<?>> a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (final q7.c<?> cVarT : componentRegistrar.getComponents()) {
            final String strI = cVarT.i();
            if (strI != null) {
                cVarT = cVarT.t(new g() { // from class: a9.a
                    @Override // q7.g
                    public final Object a(d dVar) {
                        return b.c(strI, cVarT, dVar);
                    }
                });
            }
            arrayList.add(cVarT);
        }
        return arrayList;
    }
}
