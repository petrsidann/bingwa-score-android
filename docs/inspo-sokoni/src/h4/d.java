package h4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        g4.b bVar = null;
        int iF = 0;
        int iF2 = 0;
        boolean zX = false;
        int iF3 = 0;
        boolean zX2 = false;
        int iF4 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 1:
                    iF = d4.b.F(parcel, iD);
                    break;
                case 2:
                    iF2 = d4.b.F(parcel, iD);
                    break;
                case 3:
                    zX = d4.b.x(parcel, iD);
                    break;
                case 4:
                    iF3 = d4.b.F(parcel, iD);
                    break;
                case 5:
                    zX2 = d4.b.x(parcel, iD);
                    break;
                case 6:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case 7:
                    iF4 = d4.b.F(parcel, iD);
                    break;
                case 8:
                    strQ2 = d4.b.q(parcel, iD);
                    break;
                case 9:
                    bVar = (g4.b) d4.b.p(parcel, iD, g4.b.CREATOR);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new a.C0159a(iF, iF2, zX, iF3, zX2, strQ, iF4, strQ2, bVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new a.C0159a[i10];
    }
}
