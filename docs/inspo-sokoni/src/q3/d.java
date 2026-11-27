package q3;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        int iF = 0;
        int iF2 = 0;
        int iF3 = 0;
        long jH = 0;
        String strQ = null;
        String strQ2 = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 1:
                    iF = d4.b.F(parcel, iD);
                    break;
                case 2:
                    jH = d4.b.H(parcel, iD);
                    break;
                case 3:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case 4:
                    iF2 = d4.b.F(parcel, iD);
                    break;
                case 5:
                    iF3 = d4.b.F(parcel, iD);
                    break;
                case 6:
                    strQ2 = d4.b.q(parcel, iD);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new a(iF, jH, strQ, iF2, iF3, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new a[i10];
    }
}
