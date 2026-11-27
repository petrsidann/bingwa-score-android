package h4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        int iF = 0;
        a.C0159a c0159a = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                iF = d4.b.F(parcel, iD);
            } else if (iW == 2) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW != 3) {
                d4.b.L(parcel, iD);
            } else {
                c0159a = (a.C0159a) d4.b.p(parcel, iD, a.C0159a.CREATOR);
            }
        }
        d4.b.v(parcel, iM);
        return new g(iF, strQ, c0159a);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new g[i10];
    }
}
