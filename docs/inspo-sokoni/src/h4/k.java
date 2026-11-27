package h4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        Parcel parcelN = null;
        int iF = 0;
        h hVar = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                iF = d4.b.F(parcel, iD);
            } else if (iW == 2) {
                parcelN = d4.b.n(parcel, iD);
            } else if (iW != 3) {
                d4.b.L(parcel, iD);
            } else {
                hVar = (h) d4.b.p(parcel, iD, h.CREATOR);
            }
        }
        d4.b.v(parcel, iM);
        return new c(iF, parcelN, hVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new c[i10];
    }
}
