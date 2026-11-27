package t3;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i10;
        int iM = d4.b.M(parcel);
        HashSet hashSet = new HashSet();
        int iF = 0;
        String strQ = null;
        byte[] bArrG = null;
        PendingIntent pendingIntent = null;
        a aVar = null;
        int iF2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 1:
                    iF2 = d4.b.F(parcel, iD);
                    i10 = 1;
                    break;
                case 2:
                    strQ = d4.b.q(parcel, iD);
                    i10 = 2;
                    break;
                case 3:
                    iF = d4.b.F(parcel, iD);
                    i10 = 3;
                    break;
                case 4:
                    bArrG = d4.b.g(parcel, iD);
                    i10 = 4;
                    break;
                case 5:
                    pendingIntent = (PendingIntent) d4.b.p(parcel, iD, PendingIntent.CREATOR);
                    i10 = 5;
                    break;
                case 6:
                    aVar = (a) d4.b.p(parcel, iD, a.CREATOR);
                    i10 = 6;
                    break;
                default:
                    d4.b.L(parcel, iD);
                    continue;
            }
            hashSet.add(Integer.valueOf(i10));
        }
        if (parcel.dataPosition() == iM) {
            return new i(hashSet, iF2, strQ, iF, bArrG, pendingIntent, aVar);
        }
        throw new d4.b.a("Overread allowed size end=" + iM, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new i[i10];
    }
}
