package q3;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        int iF = 0;
        String strQ = null;
        Account account = null;
        int iF2 = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                iF = d4.b.F(parcel, iD);
            } else if (iW == 2) {
                iF2 = d4.b.F(parcel, iD);
            } else if (iW == 3) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW != 4) {
                d4.b.L(parcel, iD);
            } else {
                account = (Account) d4.b.p(parcel, iD, Account.CREATOR);
            }
        }
        d4.b.v(parcel, iM);
        return new b(iF, iF2, strQ, account);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new b[i10];
    }
}
