package f8;

import com.google.auto.value.AutoValue;
import h8.k;
import l8.g0;

/* JADX INFO: loaded from: classes.dex */
@AutoValue
public abstract class e implements Comparable<e> {
    public static e h(int i10, k kVar, byte[] bArr, byte[] bArr2) {
        return new a(i10, kVar, bArr, bArr2);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        int iCompare = Integer.compare(n(), eVar.n());
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompareTo = l().compareTo(eVar.l());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int i10 = g0.i(i(), eVar.i());
        return i10 != 0 ? i10 : g0.i(k(), eVar.k());
    }

    public abstract byte[] i();

    public abstract byte[] k();

    public abstract k l();

    public abstract int n();
}
