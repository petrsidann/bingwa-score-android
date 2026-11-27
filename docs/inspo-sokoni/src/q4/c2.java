package q4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class c2 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        ArrayList arrayListU = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            if (d4.b.w(iD) != 1) {
                d4.b.L(parcel, iD);
            } else {
                arrayListU = d4.b.u(parcel, iD, z1.CREATOR);
            }
        }
        d4.b.v(parcel, iM);
        return new b2(arrayListU);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new b2[i10];
    }
}
