package o7;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class k1 implements Parcelable.Creator<d0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d0 createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            if (d4.b.w(iD) != 1) {
                d4.b.L(parcel, iD);
            } else {
                strQ = d4.b.q(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new d0(strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ d0[] newArray(int i10) {
        return new d0[i10];
    }
}
