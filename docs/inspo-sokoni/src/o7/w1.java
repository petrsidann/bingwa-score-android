package o7;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class w1 implements Parcelable.Creator<e> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        String strQ8 = null;
        boolean zX = false;
        boolean zX2 = false;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 1:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case 2:
                    strQ2 = d4.b.q(parcel, iD);
                    break;
                case 3:
                    strQ3 = d4.b.q(parcel, iD);
                    break;
                case 4:
                    strQ4 = d4.b.q(parcel, iD);
                    break;
                case 5:
                    zX = d4.b.x(parcel, iD);
                    break;
                case 6:
                    strQ5 = d4.b.q(parcel, iD);
                    break;
                case 7:
                    zX2 = d4.b.x(parcel, iD);
                    break;
                case 8:
                    strQ6 = d4.b.q(parcel, iD);
                    break;
                case 9:
                    iF = d4.b.F(parcel, iD);
                    break;
                case 10:
                    strQ7 = d4.b.q(parcel, iD);
                    break;
                case 11:
                    strQ8 = d4.b.q(parcel, iD);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new e(strQ, strQ2, strQ3, strQ4, zX, strQ5, zX2, strQ6, iF, strQ7, strQ8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e[] newArray(int i10) {
        return new e[i10];
    }
}
