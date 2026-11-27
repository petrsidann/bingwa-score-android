package o7;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class p1 implements Parcelable.Creator<o0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ o0 createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW == 2) {
                strQ2 = d4.b.q(parcel, iD);
            } else if (iW == 4) {
                strQ3 = d4.b.q(parcel, iD);
            } else if (iW == 5) {
                zX = d4.b.x(parcel, iD);
            } else if (iW != 6) {
                d4.b.L(parcel, iD);
            } else {
                strQ4 = d4.b.q(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new o0(strQ, strQ2, strQ3, zX, strQ4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ o0[] newArray(int i10) {
        return new o0[i10];
    }
}
