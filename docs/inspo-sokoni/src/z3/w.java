package z3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;

/* JADX INFO: loaded from: classes.dex */
public final class w implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 2) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW != 5) {
                d4.b.L(parcel, iD);
            } else {
                googleSignInOptions = (GoogleSignInOptions) d4.b.p(parcel, iD, GoogleSignInOptions.CREATOR);
            }
        }
        d4.b.v(parcel, iM);
        return new SignInConfiguration(strQ, googleSignInOptions);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new SignInConfiguration[i10];
    }
}
