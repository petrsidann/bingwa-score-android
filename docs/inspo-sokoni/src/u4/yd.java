package u4;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class yd implements Parcelable.Creator<zd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zd createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        long jH = 0;
        long jH2 = 0;
        byte[] bArrG = null;
        String strQ = null;
        Bundle bundleF = null;
        String strQ2 = null;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 1:
                    jH = d4.b.H(parcel, iD);
                    break;
                case 2:
                    bArrG = d4.b.g(parcel, iD);
                    break;
                case 3:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case 4:
                    bundleF = d4.b.f(parcel, iD);
                    break;
                case 5:
                    iF = d4.b.F(parcel, iD);
                    break;
                case 6:
                    jH2 = d4.b.H(parcel, iD);
                    break;
                case 7:
                    strQ2 = d4.b.q(parcel, iD);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new zd(jH, bArrG, strQ, bundleF, iF, jH2, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zd[] newArray(int i10) {
        return new zd[i10];
    }
}
