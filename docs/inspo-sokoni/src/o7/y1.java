package o7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaic;

/* JADX INFO: loaded from: classes.dex */
public final class y1 implements Parcelable.Creator<x1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ x1 createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        zzaic zzaicVar = null;
        String strQ4 = null;
        String strQ5 = null;
        String strQ6 = null;
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
                    zzaicVar = (zzaic) d4.b.p(parcel, iD, zzaic.CREATOR);
                    break;
                case 5:
                    strQ4 = d4.b.q(parcel, iD);
                    break;
                case 6:
                    strQ5 = d4.b.q(parcel, iD);
                    break;
                case 7:
                    strQ6 = d4.b.q(parcel, iD);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new x1(strQ, strQ2, strQ3, zzaicVar, strQ4, strQ5, strQ6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ x1[] newArray(int i10) {
        return new x1[i10];
    }
}
