package o7;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class a2 implements Parcelable.Creator<l> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l createFromParcel(Parcel parcel) {
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
        return new l(strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ l[] newArray(int i10) {
        return new l[i10];
    }
}
