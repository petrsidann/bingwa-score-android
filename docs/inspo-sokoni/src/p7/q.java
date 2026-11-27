package p7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class q implements Parcelable.Creator<o> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ o createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        ArrayList arrayListU = null;
        p pVar = null;
        String strQ = null;
        o7.x1 x1Var = null;
        i iVar = null;
        ArrayList arrayListU2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 1:
                    arrayListU = d4.b.u(parcel, iD, o7.r0.CREATOR);
                    break;
                case 2:
                    pVar = (p) d4.b.p(parcel, iD, p.CREATOR);
                    break;
                case 3:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case 4:
                    x1Var = (o7.x1) d4.b.p(parcel, iD, o7.x1.CREATOR);
                    break;
                case 5:
                    iVar = (i) d4.b.p(parcel, iD, i.CREATOR);
                    break;
                case 6:
                    arrayListU2 = d4.b.u(parcel, iD, o7.x0.CREATOR);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new o(arrayListU, pVar, strQ, x1Var, iVar, arrayListU2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ o[] newArray(int i10) {
        return new o[i10];
    }
}
