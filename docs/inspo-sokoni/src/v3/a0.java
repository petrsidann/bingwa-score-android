package v3;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        int iF = 0;
        PendingIntent pendingIntent = null;
        String strQ = null;
        String strQ2 = null;
        ArrayList<String> arrayListS = null;
        String strQ3 = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 1:
                    pendingIntent = (PendingIntent) d4.b.p(parcel, iD, PendingIntent.CREATOR);
                    break;
                case 2:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case 3:
                    strQ2 = d4.b.q(parcel, iD);
                    break;
                case 4:
                    arrayListS = d4.b.s(parcel, iD);
                    break;
                case 5:
                    strQ3 = d4.b.q(parcel, iD);
                    break;
                case 6:
                    iF = d4.b.F(parcel, iD);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new SaveAccountLinkingTokenRequest(pendingIntent, strQ, strQ2, arrayListS, strQ3, iF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new SaveAccountLinkingTokenRequest[i10];
    }
}
