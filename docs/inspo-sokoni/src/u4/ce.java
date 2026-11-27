package u4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ce implements Parcelable.Creator<de> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ de createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        ArrayList arrayListU = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            if (d4.b.w(iD) != 1) {
                d4.b.L(parcel, iD);
            } else {
                arrayListU = d4.b.u(parcel, iD, zd.CREATOR);
            }
        }
        d4.b.v(parcel, iM);
        return new de(arrayListU);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ de[] newArray(int i10) {
        return new de[i10];
    }
}
