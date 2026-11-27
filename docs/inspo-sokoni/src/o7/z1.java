package o7;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class z1 implements Parcelable.Creator<j> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ j createFromParcel(Parcel parcel) {
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
            } else if (iW == 3) {
                strQ3 = d4.b.q(parcel, iD);
            } else if (iW == 4) {
                strQ4 = d4.b.q(parcel, iD);
            } else if (iW != 5) {
                d4.b.L(parcel, iD);
            } else {
                zX = d4.b.x(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new j(strQ, strQ2, strQ3, strQ4, zX);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ j[] newArray(int i10) {
        return new j[i10];
    }
}
