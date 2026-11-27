package p7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class n0 extends d4.a {
    public static final Parcelable.Creator<n0> CREATOR = new q0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<o7.r0> f14287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<o7.x0> f14288b;

    public n0(List<o7.r0> list, List<o7.x0> list2) {
        this.f14287a = list == null ? new ArrayList<>() : list;
        this.f14288b = list2 == null ? new ArrayList<>() : list2;
    }

    public static n0 S(List<o7.j0> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (o7.j0 j0Var : list) {
            if (j0Var instanceof o7.r0) {
                arrayList.add((o7.r0) j0Var);
            } else if (j0Var instanceof o7.x0) {
                arrayList2.add((o7.x0) j0Var);
            }
        }
        return new n0(arrayList, arrayList2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.I(parcel, 1, this.f14287a, false);
        d4.c.I(parcel, 2, this.f14288b, false);
        d4.c.b(parcel, iA);
    }

    public final List<o7.j0> zza() {
        ArrayList arrayList = new ArrayList();
        Iterator<o7.r0> it = this.f14287a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        Iterator<o7.x0> it2 = this.f14288b.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        return arrayList;
    }
}
