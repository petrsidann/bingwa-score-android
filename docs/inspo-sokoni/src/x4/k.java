package x4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p0;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        p0 p0Var = null;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                iF = d4.b.F(parcel, iD);
            } else if (iW != 2) {
                d4.b.L(parcel, iD);
            } else {
                p0Var = (p0) d4.b.p(parcel, iD, p0.CREATOR);
            }
        }
        d4.b.v(parcel, iM);
        return new j(iF, p0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new j[i10];
    }
}
