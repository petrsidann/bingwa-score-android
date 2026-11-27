package y3;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import d9.a0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable.Creator {
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
        ArrayList arrayListU = null;
        String strQ7 = null;
        String strQ8 = null;
        long jH = 0;
        int iF = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 1:
                    iF = d4.b.F(parcel, iD);
                    break;
                case 2:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case 3:
                    strQ2 = d4.b.q(parcel, iD);
                    break;
                case 4:
                    strQ3 = d4.b.q(parcel, iD);
                    break;
                case 5:
                    strQ4 = d4.b.q(parcel, iD);
                    break;
                case 6:
                    uri = (Uri) d4.b.p(parcel, iD, Uri.CREATOR);
                    break;
                case 7:
                    strQ5 = d4.b.q(parcel, iD);
                    break;
                case 8:
                    jH = d4.b.H(parcel, iD);
                    break;
                case 9:
                    strQ6 = d4.b.q(parcel, iD);
                    break;
                case 10:
                    arrayListU = d4.b.u(parcel, iD, Scope.CREATOR);
                    break;
                case 11:
                    strQ7 = d4.b.q(parcel, iD);
                    break;
                case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                    strQ8 = d4.b.q(parcel, iD);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new GoogleSignInAccount(iF, strQ, strQ2, strQ3, strQ4, uri, strQ5, jH, strQ6, arrayListU, strQ7, strQ8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new GoogleSignInAccount[i10];
    }
}
