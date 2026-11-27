package b8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class r1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r1 f2952c = new r1(false, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r1 f2953d = new r1(true, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i8.d f2955b;

    public r1(boolean z10, i8.d dVar) {
        l8.x.a(dVar == null || z10, "Cannot specify a fieldMask for non-merge sets()", new Object[0]);
        this.f2954a = z10;
        this.f2955b = dVar;
    }

    public static r1 c() {
        return f2953d;
    }

    public static r1 d(List<t> list) {
        HashSet hashSet = new HashSet();
        Iterator<t> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().c());
        }
        return new r1(true, i8.d.b(hashSet));
    }

    public i8.d a() {
        return this.f2955b;
    }

    public boolean b() {
        return this.f2954a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r1.class != obj.getClass()) {
            return false;
        }
        r1 r1Var = (r1) obj;
        if (this.f2954a != r1Var.f2954a) {
            return false;
        }
        i8.d dVar = this.f2955b;
        i8.d dVar2 = r1Var.f2955b;
        if (dVar != null) {
            return dVar.equals(dVar2);
        }
        return dVar2 == null;
    }

    public int hashCode() {
        int i10 = (this.f2954a ? 1 : 0) * 31;
        i8.d dVar = this.f2955b;
        return i10 + (dVar != null ? dVar.hashCode() : 0);
    }
}
