package u3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.HintRequest;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        CredentialPickerConfig credentialPickerConfig = null;
        String[] strArrR = null;
        String strQ = null;
        String strQ2 = null;
        int iF = 0;
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW != 1000) {
                switch (iW) {
                    case 1:
                        credentialPickerConfig = (CredentialPickerConfig) d4.b.p(parcel, iD, CredentialPickerConfig.CREATOR);
                        break;
                    case 2:
                        zX = d4.b.x(parcel, iD);
                        break;
                    case 3:
                        zX2 = d4.b.x(parcel, iD);
                        break;
                    case 4:
                        strArrR = d4.b.r(parcel, iD);
                        break;
                    case 5:
                        zX3 = d4.b.x(parcel, iD);
                        break;
                    case 6:
                        strQ = d4.b.q(parcel, iD);
                        break;
                    case 7:
                        strQ2 = d4.b.q(parcel, iD);
                        break;
                    default:
                        d4.b.L(parcel, iD);
                        break;
                }
            } else {
                iF = d4.b.F(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new HintRequest(iF, credentialPickerConfig, zX, zX2, strArrR, zX3, strQ, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new HintRequest[i10];
    }
}
