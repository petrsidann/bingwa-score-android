package u4;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class p implements Parcelable.Creator<q> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ q createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        Bundle bundleF = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            if (d4.b.w(iD) != 1) {
                d4.b.L(parcel, iD);
            } else {
                bundleF = d4.b.f(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new q(bundleF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ q[] newArray(int i10) {
        return new q[i10];
    }
}
