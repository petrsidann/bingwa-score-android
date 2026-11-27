package r4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        int iF = 0;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 2) {
                iF = d4.b.F(parcel, iD);
            } else if (iW == 3) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW != 4) {
                d4.b.L(parcel, iD);
            } else {
                strQ2 = d4.b.q(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new a(iF, strQ, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new a[i10];
    }
}
