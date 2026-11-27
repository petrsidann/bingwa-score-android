package o7;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class l1 implements Parcelable.Creator<f0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f0 createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW != 2) {
                d4.b.L(parcel, iD);
            } else {
                strQ2 = d4.b.q(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new f0(strQ, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f0[] newArray(int i10) {
        return new f0[i10];
    }
}
