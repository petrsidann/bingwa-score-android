package t3;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        int iF = 0;
        boolean zX = false;
        boolean zX2 = false;
        long jH = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                iF = d4.b.F(parcel, iD);
            } else if (iW == 2) {
                zX = d4.b.x(parcel, iD);
            } else if (iW == 3) {
                jH = d4.b.H(parcel, iD);
            } else if (iW != 4) {
                d4.b.L(parcel, iD);
            } else {
                zX2 = d4.b.x(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new a(iF, zX, jH, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new a[i10];
    }
}
