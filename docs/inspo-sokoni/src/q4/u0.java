package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class u0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        byte[] bArrG = null;
        h hVar = null;
        g gVar = null;
        i iVar = null;
        e eVar = null;
        String strQ3 = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 1:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case 2:
                    strQ2 = d4.b.q(parcel, iD);
                    break;
                case 3:
                    bArrG = d4.b.g(parcel, iD);
                    break;
                case 4:
                    hVar = (h) d4.b.p(parcel, iD, h.CREATOR);
                    break;
                case 5:
                    gVar = (g) d4.b.p(parcel, iD, g.CREATOR);
                    break;
                case 6:
                    iVar = (i) d4.b.p(parcel, iD, i.CREATOR);
                    break;
                case 7:
                    eVar = (e) d4.b.p(parcel, iD, e.CREATOR);
                    break;
                case 8:
                    strQ3 = d4.b.q(parcel, iD);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new t(strQ, strQ2, bArrG, hVar, gVar, iVar, eVar, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new t[i10];
    }
}
