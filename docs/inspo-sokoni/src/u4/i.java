package u4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Parcelable.Creator<f> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        long jH = 0;
        long jH2 = 0;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                jH = d4.b.H(parcel, iD);
            } else if (iW == 2) {
                iF = d4.b.F(parcel, iD);
            } else if (iW != 3) {
                d4.b.L(parcel, iD);
            } else {
                jH2 = d4.b.H(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new f(jH, iF, jH2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f[] newArray(int i10) {
        return new f[i10];
    }
}
