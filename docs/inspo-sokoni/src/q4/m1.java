package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class m1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        r rVar = null;
        b2 b2Var = null;
        f0 f0Var = null;
        h2 h2Var = null;
        k0 k0Var = null;
        m0 m0Var = null;
        d2 d2Var = null;
        p0 p0Var = null;
        s sVar = null;
        r0 r0Var = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 2:
                    rVar = (r) d4.b.p(parcel, iD, r.CREATOR);
                    break;
                case 3:
                    b2Var = (b2) d4.b.p(parcel, iD, b2.CREATOR);
                    break;
                case 4:
                    f0Var = (f0) d4.b.p(parcel, iD, f0.CREATOR);
                    break;
                case 5:
                    h2Var = (h2) d4.b.p(parcel, iD, h2.CREATOR);
                    break;
                case 6:
                    k0Var = (k0) d4.b.p(parcel, iD, k0.CREATOR);
                    break;
                case 7:
                    m0Var = (m0) d4.b.p(parcel, iD, m0.CREATOR);
                    break;
                case 8:
                    d2Var = (d2) d4.b.p(parcel, iD, d2.CREATOR);
                    break;
                case 9:
                    p0Var = (p0) d4.b.p(parcel, iD, p0.CREATOR);
                    break;
                case 10:
                    sVar = (s) d4.b.p(parcel, iD, s.CREATOR);
                    break;
                case 11:
                    r0Var = (r0) d4.b.p(parcel, iD, r0.CREATOR);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new d(rVar, b2Var, f0Var, h2Var, k0Var, m0Var, d2Var, p0Var, sVar, r0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new d[i10];
    }
}
