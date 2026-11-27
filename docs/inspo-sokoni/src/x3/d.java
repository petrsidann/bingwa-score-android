package x3;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        int iF = 0;
        int iF2 = 0;
        String strQ = null;
        byte[] bArrG = null;
        Bundle bundleF = null;
        long jH = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW == 2) {
                iF2 = d4.b.F(parcel, iD);
            } else if (iW == 3) {
                jH = d4.b.H(parcel, iD);
            } else if (iW == 4) {
                bArrG = d4.b.g(parcel, iD);
            } else if (iW == 5) {
                bundleF = d4.b.f(parcel, iD);
            } else if (iW != 1000) {
                d4.b.L(parcel, iD);
            } else {
                iF = d4.b.F(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new b(iF, strQ, iF2, jH, bArrG, bundleF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new b[i10];
    }
}
