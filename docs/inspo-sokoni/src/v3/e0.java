package v3;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class e0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        Uri uri = null;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        q4.t tVar = null;
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
                    strQ3 = d4.b.q(parcel, iD);
                    break;
                case 4:
                    strQ4 = d4.b.q(parcel, iD);
                    break;
                case 5:
                    uri = (Uri) d4.b.p(parcel, iD, Uri.CREATOR);
                    break;
                case 6:
                    strQ5 = d4.b.q(parcel, iD);
                    break;
                case 7:
                    strQ6 = d4.b.q(parcel, iD);
                    break;
                case 8:
                    strQ7 = d4.b.q(parcel, iD);
                    break;
                case 9:
                    tVar = (q4.t) d4.b.p(parcel, iD, q4.t.CREATOR);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new l(strQ, strQ2, strQ3, strQ4, uri, strQ5, strQ6, strQ7, tVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new l[i10];
    }
}
