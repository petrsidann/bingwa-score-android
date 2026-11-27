package h4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        ArrayList arrayListU = null;
        int iF = 0;
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                iF = d4.b.F(parcel, iD);
            } else if (iW == 2) {
                arrayListU = d4.b.u(parcel, iD, f.CREATOR);
            } else if (iW != 3) {
                d4.b.L(parcel, iD);
            } else {
                strQ = d4.b.q(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new h(iF, arrayListU, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new h[i10];
    }
}
