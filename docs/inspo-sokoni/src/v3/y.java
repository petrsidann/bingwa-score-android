package v3;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class y implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        byte[] bArrG = null;
        boolean zX = false;
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                zX = d4.b.x(parcel, iD);
            } else if (iW == 2) {
                bArrG = d4.b.g(parcel, iD);
            } else if (iW != 3) {
                d4.b.L(parcel, iD);
            } else {
                strQ = d4.b.q(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new b.d(zX, bArrG, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new b.d[i10];
    }
}
