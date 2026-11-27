package k6;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class f0 extends i0<Comparable<?>> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f11547a = new f0();

    @Override // k6.i0, java.util.Comparator
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        j6.m.o(comparable);
        j6.m.o(comparable2);
        return comparable.compareTo(comparable2);
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
