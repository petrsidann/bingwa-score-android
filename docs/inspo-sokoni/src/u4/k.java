package u4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable.Creator<h> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        ze zeVar = null;
        String strQ3 = null;
        n0 n0Var = null;
        n0 n0Var2 = null;
        n0 n0Var3 = null;
        long jH = 0;
        long jH2 = 0;
        long jH3 = 0;
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 2:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case 3:
                    strQ2 = d4.b.q(parcel, iD);
                    break;
                case 4:
                    zeVar = (ze) d4.b.p(parcel, iD, ze.CREATOR);
                    break;
                case 5:
                    jH = d4.b.H(parcel, iD);
                    break;
                case 6:
                    zX = d4.b.x(parcel, iD);
                    break;
                case 7:
                    strQ3 = d4.b.q(parcel, iD);
                    break;
                case 8:
                    n0Var = (n0) d4.b.p(parcel, iD, n0.CREATOR);
                    break;
                case 9:
                    jH2 = d4.b.H(parcel, iD);
                    break;
                case 10:
                    n0Var2 = (n0) d4.b.p(parcel, iD, n0.CREATOR);
                    break;
                case 11:
                    jH3 = d4.b.H(parcel, iD);
                    break;
                case d9.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                    n0Var3 = (n0) d4.b.p(parcel, iD, n0.CREATOR);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new h(strQ, strQ2, zeVar, jH, zX, strQ3, n0Var, jH2, n0Var2, jH3, n0Var3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h[] newArray(int i10) {
        return new h[i10];
    }
}
