package v3;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class r implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        b.e eVar = null;
        b.C0301b c0301b = null;
        String strQ = null;
        b.d dVar = null;
        b.c cVar = null;
        boolean zX = false;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 1:
                    eVar = (b.e) d4.b.p(parcel, iD, b.e.CREATOR);
                    break;
                case 2:
                    c0301b = (b.C0301b) d4.b.p(parcel, iD, b.C0301b.CREATOR);
                    break;
                case 3:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case 4:
                    zX = d4.b.x(parcel, iD);
                    break;
                case 5:
                    iF = d4.b.F(parcel, iD);
                    break;
                case 6:
                    dVar = (b.d) d4.b.p(parcel, iD, b.d.CREATOR);
                    break;
                case 7:
                    cVar = (b.c) d4.b.p(parcel, iD, b.c.CREATOR);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new b(eVar, c0301b, strQ, zX, iF, dVar, cVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new b[i10];
    }
}
