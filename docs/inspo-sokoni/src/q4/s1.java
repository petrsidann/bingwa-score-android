package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class s1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        byte[] bArrG = null;
        byte[] bArrG2 = null;
        byte[] bArrG3 = null;
        byte[] bArrG4 = null;
        byte[] bArrG5 = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 2) {
                bArrG = d4.b.g(parcel, iD);
            } else if (iW == 3) {
                bArrG2 = d4.b.g(parcel, iD);
            } else if (iW == 4) {
                bArrG3 = d4.b.g(parcel, iD);
            } else if (iW == 5) {
                bArrG4 = d4.b.g(parcel, iD);
            } else if (iW != 6) {
                d4.b.L(parcel, iD);
            } else {
                bArrG5 = d4.b.g(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new g(bArrG, bArrG2, bArrG3, bArrG4, bArrG5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new g[i10];
    }
}
