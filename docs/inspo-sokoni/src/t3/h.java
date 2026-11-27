package t3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        HashSet hashSet = new HashSet();
        i iVar = null;
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        int iF = 0;
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
                            i10 = 5;
                            if (iW != 5) {
                                d4.b.L(parcel, iD);
                            } else {
                                strQ3 = d4.b.q(parcel, iD);
                            }
                        } else {
                            strQ2 = d4.b.q(parcel, iD);
                        }
                    } else {
                        strQ = d4.b.q(parcel, iD);
                    }
                } else {
                    iVar = (i) d4.b.p(parcel, iD, i.CREATOR);
                }
            } else {
                iF = d4.b.F(parcel, iD);
            }
            hashSet.add(Integer.valueOf(i10));
        }
        if (parcel.dataPosition() == iM) {
            return new g(hashSet, iF, iVar, strQ, strQ2, strQ3);
        }
        throw new d4.b.a("Overread allowed size end=" + iM, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new g[i10];
    }
}
