package u3;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.IdToken;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        Uri uri = null;
        ArrayList arrayListU = null;
        String strQ3 = null;
        String strQ4 = null;
        String strQ5 = null;
        String strQ6 = null;
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
                    uri = (Uri) d4.b.p(parcel, iD, Uri.CREATOR);
                    break;
                case 4:
                    arrayListU = d4.b.u(parcel, iD, IdToken.CREATOR);
                    break;
                case 5:
                    strQ3 = d4.b.q(parcel, iD);
                    break;
                case 6:
                    strQ4 = d4.b.q(parcel, iD);
                    break;
                case 7:
                case 8:
                default:
                    d4.b.L(parcel, iD);
                    break;
                case 9:
                    strQ5 = d4.b.q(parcel, iD);
                    break;
                case 10:
                    strQ6 = d4.b.q(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new Credential(strQ, strQ2, uri, arrayListU, strQ3, strQ4, strQ5, strQ6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new Credential[i10];
    }
}
