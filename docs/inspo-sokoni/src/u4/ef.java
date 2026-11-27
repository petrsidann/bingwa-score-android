package u4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ef implements Parcelable.Creator<me> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ me createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        Boolean boolY = null;
        ArrayList<String> arrayListS = null;
        String strQ8 = null;
        String strQ9 = null;
        String strQ10 = null;
        long jH = 0;
        long jH2 = 0;
        long jH3 = 0;
        long jH4 = 0;
        long jH5 = 0;
        long jH6 = 0;
        long jH7 = 0;
        boolean zX = true;
        boolean zX2 = true;
        boolean zX3 = false;
        int iF = 0;
        boolean zX4 = false;
        boolean zX5 = false;
        int iF2 = 0;
        int iF3 = 0;
        long jH8 = -2147483648L;
        String strQ11 = "";
        String strQ12 = strQ11;
        String strQ13 = strQ12;
        String strQ14 = strQ13;
        int iF4 = 100;
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
                    strQ3 = d4.b.q(parcel, iD);
                    break;
                case 5:
                    strQ4 = d4.b.q(parcel, iD);
                    break;
                case 6:
                    jH = d4.b.H(parcel, iD);
                    break;
                case 7:
                    jH2 = d4.b.H(parcel, iD);
                    break;
                case 8:
                    strQ5 = d4.b.q(parcel, iD);
                    break;
                case 9:
                    zX = d4.b.x(parcel, iD);
                    break;
                case 10:
                    zX3 = d4.b.x(parcel, iD);
                    break;
                case 11:
                    jH8 = d4.b.H(parcel, iD);
                    break;
                case d9.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                    strQ6 = d4.b.q(parcel, iD);
                    break;
                case 13:
                case d9.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                case 20:
                case 33:
                default:
                    d4.b.L(parcel, iD);
                    break;
                case 14:
                    jH3 = d4.b.H(parcel, iD);
                    break;
                case 15:
                    iF = d4.b.F(parcel, iD);
                    break;
                case 16:
                    zX2 = d4.b.x(parcel, iD);
                    break;
                case d9.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                    zX4 = d4.b.x(parcel, iD);
                    break;
                case 19:
                    strQ7 = d4.b.q(parcel, iD);
                    break;
                case 21:
                    boolY = d4.b.y(parcel, iD);
                    break;
                case 22:
                    jH4 = d4.b.H(parcel, iD);
                    break;
                case 23:
                    arrayListS = d4.b.s(parcel, iD);
                    break;
                case 24:
                    strQ8 = d4.b.q(parcel, iD);
                    break;
                case 25:
                    strQ11 = d4.b.q(parcel, iD);
                    break;
                case 26:
                    strQ12 = d4.b.q(parcel, iD);
                    break;
                case 27:
                    strQ9 = d4.b.q(parcel, iD);
                    break;
                case 28:
                    zX5 = d4.b.x(parcel, iD);
                    break;
                case 29:
                    jH5 = d4.b.H(parcel, iD);
                    break;
                case 30:
                    iF4 = d4.b.F(parcel, iD);
                    break;
                case 31:
                    strQ13 = d4.b.q(parcel, iD);
                    break;
                case 32:
                    iF2 = d4.b.F(parcel, iD);
                    break;
                case 34:
                    jH6 = d4.b.H(parcel, iD);
                    break;
                case 35:
                    strQ10 = d4.b.q(parcel, iD);
                    break;
                case 36:
                    strQ14 = d4.b.q(parcel, iD);
                    break;
                case 37:
                    jH7 = d4.b.H(parcel, iD);
                    break;
                case 38:
                    iF3 = d4.b.F(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new me(strQ, strQ2, strQ3, strQ4, jH, jH2, strQ5, zX, zX3, jH8, strQ6, jH3, iF, zX2, zX4, strQ7, boolY, jH4, arrayListS, strQ8, strQ11, strQ12, strQ9, zX5, jH5, iF4, strQ13, iF2, jH6, strQ10, strQ14, jH7, iF3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ me[] newArray(int i10) {
        return new me[i10];
    }
}
