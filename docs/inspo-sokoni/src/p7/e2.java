package p7;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class e2 implements Parcelable.Creator<f2> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f2 createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        boolean zX = false;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW == 2) {
                strQ2 = d4.b.q(parcel, iD);
            } else if (iW != 3) {
                d4.b.L(parcel, iD);
            } else {
                zX = d4.b.x(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new f2(strQ, strQ2, zX);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f2[] newArray(int i10) {
        return new f2[i10];
    }
}
