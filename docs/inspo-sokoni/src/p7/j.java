package p7;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Parcelable.Creator<k> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        long jH = 0;
        long jH2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                jH = d4.b.H(parcel, iD);
            } else if (iW != 2) {
                d4.b.L(parcel, iD);
            } else {
                jH2 = d4.b.H(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new k(jH, jH2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k[] newArray(int i10) {
        return new k[i10];
    }
}
