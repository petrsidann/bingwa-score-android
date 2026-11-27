package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class k1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        int iF = 0;
        short sJ = 0;
        short sJ2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                iF = d4.b.F(parcel, iD);
            } else if (iW == 2) {
                sJ = d4.b.J(parcel, iD);
            } else if (iW != 3) {
                d4.b.L(parcel, iD);
            } else {
                sJ2 = d4.b.J(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new h0(iF, sJ, sJ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new h0[i10];
    }
}
