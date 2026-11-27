package z3;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000authapi.zbb;
import com.google.android.gms.internal.p000authapi.zbc;

/* JADX INFO: loaded from: classes.dex */
public abstract class s extends zbb implements t {
    public s() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    public final boolean zba(int i10, Parcel parcel, Parcel parcel2, int i11) {
        switch (i10) {
            case 101:
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) zbc.zba(parcel, GoogleSignInAccount.CREATOR);
                Status status = (Status) zbc.zba(parcel, Status.CREATOR);
                zbc.zbb(parcel);
                o0(googleSignInAccount, status);
                break;
            case 102:
                Status status2 = (Status) zbc.zba(parcel, Status.CREATOR);
                zbc.zbb(parcel);
                zbc(status2);
                break;
            case 103:
                Status status3 = (Status) zbc.zba(parcel, Status.CREATOR);
                zbc.zbb(parcel);
                k0(status3);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
