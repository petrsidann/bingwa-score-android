package t3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        HashSet hashSet = new HashSet();
        int iF = 0;
        ArrayList arrayListU = null;
        e eVar = null;
        int iF2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            int i10 = 1;
            if (iW != 1) {
                i10 = 2;
                if (iW != 2) {
                    i10 = 3;
                    if (iW != 3) {
                        i10 = 4;
                        if (iW != 4) {
                            d4.b.L(parcel, iD);
                        } else {
                            eVar = (e) d4.b.p(parcel, iD, e.CREATOR);
                        }
                    } else {
                        iF = d4.b.F(parcel, iD);
                    }
                } else {
                    arrayListU = d4.b.u(parcel, iD, g.CREATOR);
                }
            } else {
                iF2 = d4.b.F(parcel, iD);
            }
            hashSet.add(Integer.valueOf(i10));
        }
        if (parcel.dataPosition() == iM) {
            return new b(hashSet, iF2, arrayListU, iF, eVar);
        }
        throw new d4.b.a("Overread allowed size end=" + iM, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new b[i10];
    }
}
