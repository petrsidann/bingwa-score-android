package c4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class f0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        boolean zX = false;
        int iF = 0;
        String strQ = null;
        int iF2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                zX = d4.b.x(parcel, iD);
            } else if (iW == 2) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW == 3) {
                iF2 = d4.b.F(parcel, iD);
            } else if (iW != 4) {
                d4.b.L(parcel, iD);
            } else {
                iF = d4.b.F(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new e0(zX, strQ, iF2, iF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new e0[i10];
    }
}
