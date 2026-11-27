package v3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class w implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        ArrayList<String> arrayListS = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 1:
                    zX = d4.b.x(parcel, iD);
                    break;
                case 2:
                    strQ = d4.b.q(parcel, iD);
                    break;
                case 3:
                    strQ2 = d4.b.q(parcel, iD);
                    break;
                case 4:
                    zX2 = d4.b.x(parcel, iD);
                    break;
                case 5:
                    strQ3 = d4.b.q(parcel, iD);
                    break;
                case 6:
                    arrayListS = d4.b.s(parcel, iD);
                    break;
                case 7:
                    zX3 = d4.b.x(parcel, iD);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new b.C0301b(zX, strQ, strQ2, zX2, strQ3, arrayListS, zX3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new b.C0301b[i10];
    }
}
