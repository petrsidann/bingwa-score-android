package c4;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class h0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        boolean zX = false;
        String strQ = null;
        IBinder iBinderE = null;
        boolean zX2 = false;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW == 2) {
                iBinderE = d4.b.E(parcel, iD);
            } else if (iW == 3) {
                zX = d4.b.x(parcel, iD);
            } else if (iW != 4) {
                d4.b.L(parcel, iD);
            } else {
                zX2 = d4.b.x(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new g0(strQ, iBinderE, zX, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new g0[i10];
    }
}
