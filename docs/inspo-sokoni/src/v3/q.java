package v3;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class q implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        ArrayList<String> arrayListS = null;
        GoogleSignInAccount googleSignInAccount = null;
        PendingIntent pendingIntent = null;
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
                    arrayListS = d4.b.s(parcel, iD);
                    break;
                case 5:
                    googleSignInAccount = (GoogleSignInAccount) d4.b.p(parcel, iD, GoogleSignInAccount.CREATOR);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) d4.b.p(parcel, iD, PendingIntent.CREATOR);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new a(strQ, strQ2, strQ3, arrayListS, googleSignInAccount, pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new a[i10];
    }
}
