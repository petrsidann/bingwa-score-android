package u4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class ye implements Parcelable.Creator<ze> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ze createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        int iF = 0;
        String strQ = null;
        Long lI = null;
        Float fC = null;
        String strQ2 = null;
        String strQ3 = null;
        Double dA = null;
        long jH = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 1:
                    iF = d4.b.F(parcel, iD);
                    break;
                case 2:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case 3:
                    jH = d4.b.H(parcel, iD);
                    break;
                case 4:
                    lI = d4.b.I(parcel, iD);
                    break;
                case 5:
                    fC = d4.b.C(parcel, iD);
                    break;
                case 6:
                    strQ2 = d4.b.q(parcel, iD);
                    break;
                case 7:
                    strQ3 = d4.b.q(parcel, iD);
                    break;
                case 8:
                    dA = d4.b.A(parcel, iD);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new ze(iF, strQ, jH, lI, fC, strQ2, strQ3, dA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ze[] newArray(int i10) {
        return new ze[i10];
    }
}
