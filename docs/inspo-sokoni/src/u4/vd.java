package u4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class vd implements Parcelable.Creator<sd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ sd createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        long jH = 0;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW == 2) {
                jH = d4.b.H(parcel, iD);
            } else if (iW != 3) {
                d4.b.L(parcel, iD);
            } else {
                iF = d4.b.F(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new sd(strQ, jH, iF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ sd[] newArray(int i10) {
        return new sd[i10];
    }
}
