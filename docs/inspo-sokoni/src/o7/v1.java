package o7;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class v1 implements Parcelable.Creator<c1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c1 createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        boolean zX = false;
        boolean zX2 = false;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 2) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW == 3) {
                strQ2 = d4.b.q(parcel, iD);
            } else if (iW == 4) {
                zX = d4.b.x(parcel, iD);
            } else if (iW != 5) {
                d4.b.L(parcel, iD);
            } else {
                zX2 = d4.b.x(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new c1(strQ, strQ2, zX, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c1[] newArray(int i10) {
        return new c1[i10];
    }
}
