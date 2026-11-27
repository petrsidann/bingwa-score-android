package x4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        ArrayList<String> arrayListS = null;
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                arrayListS = d4.b.s(parcel, iD);
            } else if (iW != 2) {
                d4.b.L(parcel, iD);
            } else {
                strQ = d4.b.q(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new h(arrayListS, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new h[i10];
    }
}
