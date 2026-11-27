package p7;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class g2 implements Parcelable.Creator<h2> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h2 createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        i iVar = null;
        f2 f2Var = null;
        o7.x1 x1Var = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                iVar = (i) d4.b.p(parcel, iD, i.CREATOR);
            } else if (iW == 2) {
                f2Var = (f2) d4.b.p(parcel, iD, f2.CREATOR);
            } else if (iW != 3) {
                d4.b.L(parcel, iD);
            } else {
                x1Var = (o7.x1) d4.b.p(parcel, iD, o7.x1.CREATOR);
            }
        }
        d4.b.v(parcel, iM);
        return new h2(iVar, f2Var, x1Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h2[] newArray(int i10) {
        return new h2[i10];
    }
}
