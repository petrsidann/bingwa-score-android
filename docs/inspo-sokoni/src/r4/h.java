package r4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.common.Transport;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        byte[] bArrG = null;
        ArrayList arrayListU = null;
        int iF = 0;
        String strQ = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            int iW = d4.b.w(iD);
            if (iW == 1) {
                iF = d4.b.F(parcel, iD);
            } else if (iW == 2) {
                bArrG = d4.b.g(parcel, iD);
            } else if (iW == 3) {
                strQ = d4.b.q(parcel, iD);
            } else if (iW != 4) {
                d4.b.L(parcel, iD);
            } else {
                arrayListU = d4.b.u(parcel, iD, Transport.CREATOR);
            }
        }
        d4.b.v(parcel, iM);
        return new b(iF, bArrG, strQ, arrayListU);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new b[i10];
    }
}
