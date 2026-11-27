package x3;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        int iF = 0;
        int iF2 = 0;
        int iF3 = 0;
        PendingIntent pendingIntent = null;
        Bundle bundleF = null;
        byte[] bArrG = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                iF2 = d4.b.F(parcel, iD);
            } else if (iW == 2) {
                pendingIntent = (PendingIntent) d4.b.p(parcel, iD, PendingIntent.CREATOR);
            } else if (iW == 3) {
                iF3 = d4.b.F(parcel, iD);
            } else if (iW == 4) {
                bundleF = d4.b.f(parcel, iD);
            } else if (iW == 5) {
                bArrG = d4.b.g(parcel, iD);
            } else if (iW != 1000) {
                d4.b.L(parcel, iD);
            } else {
                iF = d4.b.F(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new c(iF, iF2, pendingIntent, iF3, bundleF, bArrG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new c[i10];
    }
}
