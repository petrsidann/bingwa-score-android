package o7;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class r1 implements Parcelable.Creator<r0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ r0 createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        long jH = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW == 2) {
                strQ2 = d4.b.q(parcel, iD);
            } else if (iW == 3) {
                jH = d4.b.H(parcel, iD);
            } else if (iW != 4) {
                d4.b.L(parcel, iD);
            } else {
                strQ3 = d4.b.q(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new r0(strQ, strQ2, jH, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ r0[] newArray(int i10) {
        return new r0[i10];
    }
}
