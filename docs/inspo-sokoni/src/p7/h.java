package p7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzagw;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable.Creator<i> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ i createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        zzagw zzagwVar = null;
        e eVar = null;
        String strQ = null;
        String strQ2 = null;
        ArrayList arrayListU = null;
        ArrayList<String> arrayListS = null;
        String strQ3 = null;
        Boolean boolY = null;
        k kVar = null;
        o7.x1 x1Var = null;
        n0 n0Var = null;
        ArrayList arrayListU2 = null;
        boolean zX = false;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 1:
                    zzagwVar = (zzagw) d4.b.p(parcel, iD, zzagw.CREATOR);
                    break;
                case 2:
                    eVar = (e) d4.b.p(parcel, iD, e.CREATOR);
                    break;
                case 3:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case 4:
                    strQ2 = d4.b.q(parcel, iD);
                    break;
                case 5:
                    arrayListU = d4.b.u(parcel, iD, e.CREATOR);
                    break;
                case 6:
                    arrayListS = d4.b.s(parcel, iD);
                    break;
                case 7:
                    strQ3 = d4.b.q(parcel, iD);
                    break;
                case 8:
                    boolY = d4.b.y(parcel, iD);
                    break;
                case 9:
                    kVar = (k) d4.b.p(parcel, iD, k.CREATOR);
                    break;
                case 10:
                    zX = d4.b.x(parcel, iD);
                    break;
                case 11:
                    x1Var = (o7.x1) d4.b.p(parcel, iD, o7.x1.CREATOR);
                    break;
                case d9.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                    n0Var = (n0) d4.b.p(parcel, iD, n0.CREATOR);
                    break;
                case 13:
                    arrayListU2 = d4.b.u(parcel, iD, o7.m1.CREATOR);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new i(zzagwVar, eVar, strQ, strQ2, arrayListU, arrayListS, strQ3, boolY, kVar, zX, x1Var, n0Var, arrayListU2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ i[] newArray(int i10) {
        return new i[i10];
    }
}
