package y3;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        ArrayList arrayListU = null;
        Account account = null;
        String strQ = null;
        String strQ2 = null;
        ArrayList arrayListU2 = null;
        String strQ3 = null;
        int iF = 0;
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 1:
                    iF = d4.b.F(parcel, iD);
                    break;
                case 2:
                    arrayListU = d4.b.u(parcel, iD, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) d4.b.p(parcel, iD, Account.CREATOR);
                    break;
                case 4:
                    zX = d4.b.x(parcel, iD);
                    break;
                case 5:
                    zX2 = d4.b.x(parcel, iD);
                    break;
                case 6:
                    zX3 = d4.b.x(parcel, iD);
                    break;
                case 7:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case 8:
                    strQ2 = d4.b.q(parcel, iD);
                    break;
                case 9:
                    arrayListU2 = d4.b.u(parcel, iD, z3.a.CREATOR);
                    break;
                case 10:
                    strQ3 = d4.b.q(parcel, iD);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new GoogleSignInOptions(iF, arrayListU, account, zX, zX2, zX3, strQ, strQ2, arrayListU2, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new GoogleSignInOptions[i10];
    }
}
