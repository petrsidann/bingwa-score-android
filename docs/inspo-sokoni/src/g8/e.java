package g8;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Comparator<e> f8707c = new Comparator() { // from class: g8.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return e.e((e) obj, (e) obj2);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Comparator<e> f8708d = new Comparator() { // from class: g8.d
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return e.f((e) obj, (e) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h8.k f8709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8710b;

    public e(h8.k kVar, int i10) {
        this.f8709a = kVar;
        this.f8710b = i10;
    }

    public static /* synthetic */ int e(e eVar, e eVar2) {
        int iCompareTo = eVar.f8709a.compareTo(eVar2.f8709a);
        return iCompareTo != 0 ? iCompareTo : l8.g0.l(eVar.f8710b, eVar2.f8710b);
    }

    public static /* synthetic */ int f(e eVar, e eVar2) {
        int iL = l8.g0.l(eVar.f8710b, eVar2.f8710b);
        return iL != 0 ? iL : eVar.f8709a.compareTo(eVar2.f8709a);
    }

    public int c() {
        return this.f8710b;
    }

    public h8.k d() {
        return this.f8709a;
    }
}
