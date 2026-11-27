package q4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class x0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        byte[] bArrG = null;
        Double dA = null;
        String strQ = null;
        ArrayList arrayListU = null;
        Integer numG = null;
        e0 e0Var = null;
        String strQ2 = null;
        d dVar = null;
        Long lI = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 2:
                    bArrG = d4.b.g(parcel, iD);
                    break;
                case 3:
                    dA = d4.b.A(parcel, iD);
                    break;
                case 4:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case 5:
                    arrayListU = d4.b.u(parcel, iD, v.CREATOR);
                    break;
                case 6:
                    numG = d4.b.G(parcel, iD);
                    break;
                case 7:
                    e0Var = (e0) d4.b.p(parcel, iD, e0.CREATOR);
                    break;
                case 8:
                    strQ2 = d4.b.q(parcel, iD);
                    break;
                case 9:
                    dVar = (d) d4.b.p(parcel, iD, d.CREATOR);
                    break;
                case 10:
                    lI = d4.b.I(parcel, iD);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new x(bArrG, dA, strQ, arrayListU, numG, e0Var, strQ2, dVar, lI);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new x[i10];
    }
}
