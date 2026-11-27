package o7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaia;

/* JADX INFO: loaded from: classes.dex */
public final class t1 implements Parcelable.Creator<x0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ x0 createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        zzaia zzaiaVar = null;
        long jH = 0;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW == 2) {
                strQ2 = d4.b.q(parcel, iD);
            } else if (iW == 3) {
                jH = d4.b.H(parcel, iD);
            } else if (iW != 4) {
                d4.b.L(parcel, iD);
            } else {
                zzaiaVar = (zzaia) d4.b.p(parcel, iD, zzaia.CREATOR);
            }
        }
        d4.b.v(parcel, iM);
        return new x0(strQ, strQ2, jH, zzaiaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ x0[] newArray(int i10) {
        return new x0[i10];
    }
}
