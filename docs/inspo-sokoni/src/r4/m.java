package r4;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.u2f.api.common.SignRequestParams;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        Integer numG = null;
        Double dA = null;
        Uri uri = null;
        byte[] bArrG = null;
        ArrayList arrayListU = null;
        a aVar = null;
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 2:
                    numG = d4.b.G(parcel, iD);
                    break;
                case 3:
                    dA = d4.b.A(parcel, iD);
                    break;
                case 4:
                    uri = (Uri) d4.b.p(parcel, iD, Uri.CREATOR);
                    break;
                case 5:
                    bArrG = d4.b.g(parcel, iD);
                    break;
                case 6:
                    arrayListU = d4.b.u(parcel, iD, e.CREATOR);
                    break;
                case 7:
                    aVar = (a) d4.b.p(parcel, iD, a.CREATOR);
                    break;
                case 8:
                    strQ = d4.b.q(parcel, iD);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new SignRequestParams(numG, dA, uri, bArrG, arrayListU, aVar, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new SignRequestParams[i10];
    }
}
