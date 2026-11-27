package p7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Parcelable.Creator<p> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ p createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        ArrayList arrayListU = null;
        ArrayList arrayListU2 = null;
        i iVar = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW == 2) {
                strQ2 = d4.b.q(parcel, iD);
            } else if (iW == 3) {
                arrayListU = d4.b.u(parcel, iD, o7.r0.CREATOR);
            } else if (iW == 4) {
                arrayListU2 = d4.b.u(parcel, iD, o7.x0.CREATOR);
            } else if (iW != 5) {
                d4.b.L(parcel, iD);
            } else {
                iVar = (i) d4.b.p(parcel, iD, i.CREATOR);
            }
        }
        d4.b.v(parcel, iM);
        return new p(strQ, strQ2, arrayListU, arrayListU2, iVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ p[] newArray(int i10) {
        return new p[i10];
    }
}
