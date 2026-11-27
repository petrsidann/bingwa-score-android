package h8;

import h8.e;
import java.util.ArrayList;
import java.util.List;
import l8.g0;

/* JADX INFO: loaded from: classes.dex */
public abstract class e<B extends e<B>> implements Comparable<B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f9737a;

    public e(List<String> list) {
        this.f9737a = list;
    }

    public static int k(String str, String str2) {
        boolean zS = s(str);
        boolean zS2 = s(str2);
        if (zS && !zS2) {
            return -1;
        }
        if (zS || !zS2) {
            return (zS && zS2) ? Long.compare(o(str), o(str2)) : g0.o(str, str2);
        }
        return 1;
    }

    public static long o(String str) {
        return Long.parseLong(str.substring(4, str.length() - 2));
    }

    public static boolean s(String str) {
        return str.startsWith("__id") && str.endsWith("__");
    }

    public B d(B b10) {
        ArrayList arrayList = new ArrayList(this.f9737a);
        arrayList.addAll(b10.f9737a);
        return (B) n(arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && compareTo((e) obj) == 0;
    }

    public B h(String str) {
        ArrayList arrayList = new ArrayList(this.f9737a);
        arrayList.add(str);
        return (B) n(arrayList);
    }

    public int hashCode() {
        return ((getClass().hashCode() + 37) * 37) + this.f9737a.hashCode();
    }

    public abstract String i();

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public int compareTo(B b10) {
        int iU = u();
        int iU2 = b10.u();
        for (int i10 = 0; i10 < iU && i10 < iU2; i10++) {
            int iK = k(q(i10), b10.q(i10));
            if (iK != 0) {
                return iK;
            }
        }
        return g0.l(iU, iU2);
    }

    public abstract B n(List<String> list);

    public String p() {
        return this.f9737a.get(u() - 1);
    }

    public String q(int i10) {
        return this.f9737a.get(i10);
    }

    public boolean r() {
        return u() == 0;
    }

    public boolean t(B b10) {
        if (u() > b10.u()) {
            return false;
        }
        for (int i10 = 0; i10 < u(); i10++) {
            if (!q(i10).equals(b10.q(i10))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return i();
    }

    public int u() {
        return this.f9737a.size();
    }

    public B v(int i10) {
        int iU = u();
        l8.b.d(iU >= i10, "Can't call popFirst with count > length() (%d > %d)", Integer.valueOf(i10), Integer.valueOf(iU));
        return (B) n(this.f9737a.subList(i10, iU));
    }

    public B w() {
        return (B) n(this.f9737a.subList(0, u() - 1));
    }
}
