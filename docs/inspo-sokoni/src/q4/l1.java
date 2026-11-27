package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class l1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        g0 g0Var = null;
        o1 o1Var = null;
        f fVar = null;
        q1 q1Var = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                g0Var = (g0) d4.b.p(parcel, iD, g0.CREATOR);
            } else if (iW == 2) {
                o1Var = (o1) d4.b.p(parcel, iD, o1.CREATOR);
            } else if (iW == 3) {
                fVar = (f) d4.b.p(parcel, iD, f.CREATOR);
            } else if (iW != 4) {
                d4.b.L(parcel, iD);
            } else {
                q1Var = (q1) d4.b.p(parcel, iD, q1.CREATOR);
            }
        }
        d4.b.v(parcel, iM);
        return new e(g0Var, o1Var, fVar, q1Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new e[i10];
    }
}
