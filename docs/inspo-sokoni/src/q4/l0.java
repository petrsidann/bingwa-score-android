package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class l0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        long jH = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            if (d4.b.w(iD) != 1) {
                d4.b.L(parcel, iD);
            } else {
                jH = d4.b.H(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new k0(jH);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new k0[i10];
    }
}
