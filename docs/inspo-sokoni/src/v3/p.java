package v3;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class p implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        ArrayList arrayListU = null;
        String strQ = null;
        Account account = null;
        String strQ2 = null;
        String strQ3 = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 1:
                    arrayListU = d4.b.u(parcel, iD, Scope.CREATOR);
                    break;
                case 2:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case 3:
                    zX = d4.b.x(parcel, iD);
                    break;
                case 4:
                    zX2 = d4.b.x(parcel, iD);
                    break;
                case 5:
                    account = (Account) d4.b.p(parcel, iD, Account.CREATOR);
                    break;
                case 6:
                    strQ2 = d4.b.q(parcel, iD);
                    break;
                case 7:
                    strQ3 = d4.b.q(parcel, iD);
                    break;
                case 8:
                    zX3 = d4.b.x(parcel, iD);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new AuthorizationRequest(arrayListU, strQ, zX, zX2, account, strQ2, strQ3, zX3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new AuthorizationRequest[i10];
    }
}
