package o3;

import a3.e;
import android.util.SparseArray;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SparseArray<e> f13647a = new SparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap<e, Integer> f13648b;

    static {
        HashMap<e, Integer> map = new HashMap<>();
        f13648b = map;
        map.put(e.DEFAULT, 0);
        f13648b.put(e.VERY_LOW, 1);
        f13648b.put(e.HIGHEST, 2);
        for (e eVar : f13648b.keySet()) {
            f13647a.append(f13648b.get(eVar).intValue(), eVar);
        }
    }

    public static int a(e eVar) {
        Integer num = f13648b.get(eVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + eVar);
    }

    public static e b(int i10) {
        e eVar = f13647a.get(i10);
        if (eVar != null) {
            return eVar;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i10);
    }
}
