package q4;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class w1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        u uVar = null;
        Uri uri = null;
        byte[] bArrG = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 2) {
                uVar = (u) d4.b.p(parcel, iD, u.CREATOR);
            } else if (iW == 3) {
                uri = (Uri) d4.b.p(parcel, iD, Uri.CREATOR);
            } else if (iW != 4) {
                d4.b.L(parcel, iD);
            } else {
                bArrG = d4.b.g(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new l(uVar, uri, bArrG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new l[i10];
    }
}
