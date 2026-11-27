package u4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ae implements Parcelable.Creator<be> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ be createFromParcel(Parcel parcel) {
        int iM = d4.b.M(parcel);
        ArrayList<Integer> arrayListL = null;
        while (parcel.dataPosition() < iM) {
            int iD = d4.b.D(parcel);
            if (d4.b.w(iD) != 1) {
                d4.b.L(parcel, iD);
            } else {
                arrayListL = d4.b.l(parcel, iD);
            }
        }
        d4.b.v(parcel, iM);
        return new be(arrayListL);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ be[] newArray(int i10) {
        return new be[i10];
    }
}
