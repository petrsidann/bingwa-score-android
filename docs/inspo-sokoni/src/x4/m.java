package x4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.r0;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        c4.b bVar = null;
        int iF = 0;
        r0 r0Var = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                iF = d4.b.F(parcel, iD);
            } else if (iW == 2) {
                bVar = (c4.b) d4.b.p(parcel, iD, c4.b.CREATOR);
            } else if (iW != 3) {
                d4.b.L(parcel, iD);
            } else {
                r0Var = (r0) d4.b.p(parcel, iD, r0.CREATOR);
            }
        }
        d4.b.v(parcel, iM);
        return new l(iF, bVar, r0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new l[i10];
    }
}
