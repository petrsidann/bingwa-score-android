package u4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class m0 implements Parcelable.Creator<n0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ n0 createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        i0 i0Var = null;
        String strQ2 = null;
        long jH = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 2) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW == 3) {
                i0Var = (i0) d4.b.p(parcel, iD, i0.CREATOR);
            } else if (iW == 4) {
                strQ2 = d4.b.q(parcel, iD);
            } else if (iW != 5) {
                d4.b.L(parcel, iD);
            } else {
                jH = d4.b.H(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new n0(strQ, i0Var, strQ2, jH);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ n0[] newArray(int i10) {
        return new n0[i10];
    }
}
