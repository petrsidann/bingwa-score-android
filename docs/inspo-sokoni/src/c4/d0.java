package c4;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        boolean zX4 = false;
        String strQ = null;
        IBinder iBinderE = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 1:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case 2:
                    zX = d4.b.x(parcel, iD);
                    break;
                case 3:
                    zX2 = d4.b.x(parcel, iD);
                    break;
                case 4:
                    iBinderE = d4.b.E(parcel, iD);
                    break;
                case 5:
                    zX3 = d4.b.x(parcel, iD);
                    break;
                case 6:
                    zX4 = d4.b.x(parcel, iD);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new c0(strQ, zX, zX2, iBinderE, zX3, zX4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new c0[i10];
    }
}
