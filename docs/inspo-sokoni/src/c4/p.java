package c4;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class p implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        PendingIntent pendingIntent = null;
        int iF = 0;
        int iF2 = 0;
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                iF = d4.b.F(parcel, iD);
            } else if (iW == 2) {
                iF2 = d4.b.F(parcel, iD);
            } else if (iW == 3) {
                pendingIntent = (PendingIntent) d4.b.p(parcel, iD, PendingIntent.CREATOR);
            } else if (iW != 4) {
                d4.b.L(parcel, iD);
            } else {
                strQ = d4.b.q(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new b(iF, iF2, pendingIntent, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new b[i10];
    }
}
