package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class a1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        byte[] bArrG = null;
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 2) {
                bArrG = d4.b.g(parcel, iD);
            } else if (iW == 3) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW == 4) {
                strQ2 = d4.b.q(parcel, iD);
            } else if (iW != 5) {
                d4.b.L(parcel, iD);
            } else {
                strQ3 = d4.b.q(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new a0(bArrG, strQ, strQ2, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new a0[i10];
    }
}
