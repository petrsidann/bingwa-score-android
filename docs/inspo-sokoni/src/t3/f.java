package t3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        int iF = 0;
        ArrayList<String> arrayListS = null;
        ArrayList<String> arrayListS2 = null;
        ArrayList<String> arrayListS3 = null;
        ArrayList<String> arrayListS4 = null;
        ArrayList<String> arrayListS5 = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            switch (d4.b.w(iD)) {
                case 1:
                    iF = d4.b.F(parcel, iD);
                    break;
                case 2:
                    arrayListS = d4.b.s(parcel, iD);
                    break;
                case 3:
                    arrayListS2 = d4.b.s(parcel, iD);
                    break;
                case 4:
                    arrayListS3 = d4.b.s(parcel, iD);
                    break;
                case 5:
                    arrayListS4 = d4.b.s(parcel, iD);
                    break;
                case 6:
                    arrayListS5 = d4.b.s(parcel, iD);
                    break;
                default:
                    d4.b.L(parcel, iD);
                    break;
            }
        }
        d4.b.v(parcel, iM);
        return new e(iF, arrayListS, arrayListS2, arrayListS3, arrayListS4, arrayListS5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        return new e[i10];
    }
}
