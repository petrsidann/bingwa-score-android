package p7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class q0 implements Parcelable.Creator<n0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ n0 createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        ArrayList arrayListU = null;
        ArrayList arrayListU2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                arrayListU = d4.b.u(parcel, iD, o7.r0.CREATOR);
            } else if (iW != 2) {
                d4.b.L(parcel, iD);
            } else {
                arrayListU2 = d4.b.u(parcel, iD, o7.x0.CREATOR);
            }
        }
        d4.b.v(parcel, iM);
        return new n0(arrayListU, arrayListU2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ n0[] newArray(int i10) {
        return new n0[i10];
    }
}
