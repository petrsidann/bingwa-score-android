package q4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class t0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        y yVar = null;
        a0 a0Var = null;
        byte[] bArrG = null;
        ArrayList arrayListU = null;
        Double dA = null;
        ArrayList arrayListU2 = null;
        k kVar = null;
        Integer numG = null;
        e0 e0Var = null;
        String strQ = null;
        d dVar = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 2:
                    yVar = (y) d4.b.p(parcel, iD, y.CREATOR);
                    break;
                case 3:
                    a0Var = (a0) d4.b.p(parcel, iD, a0.CREATOR);
                    break;
                case 4:
                    bArrG = d4.b.g(parcel, iD);
                    break;
                case 5:
                    arrayListU = d4.b.u(parcel, iD, w.CREATOR);
                    break;
                case 6:
                    dA = d4.b.A(parcel, iD);
                    break;
                case 7:
                    arrayListU2 = d4.b.u(parcel, iD, v.CREATOR);
                    break;
                case 8:
                    kVar = (k) d4.b.p(parcel, iD, k.CREATOR);
                    break;
                case 9:
                    numG = d4.b.G(parcel, iD);
                    break;
                case 10:
                    e0Var = (e0) d4.b.p(parcel, iD, e0.CREATOR);
                    break;
                case 11:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case d9.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                    dVar = (d) d4.b.p(parcel, iD, d.CREATOR);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new u(yVar, a0Var, bArrG, arrayListU, dA, arrayListU2, kVar, numG, e0Var, strQ, dVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new u[i10];
    }
}
