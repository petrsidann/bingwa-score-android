package u4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class be extends d4.a {
    public static final Parcelable.Creator<be> CREATOR = new ae();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f16053a;

    public be(List<Integer> list) {
        this.f16053a = list;
    }

    public static be S(fb... fbVarArr) {
        ArrayList arrayList = new ArrayList(fbVarArr.length);
        for (fb fbVar : fbVarArr) {
            arrayList.add(Integer.valueOf(fbVar.zza()));
        }
        return new be(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.v(parcel, 1, this.f16053a, false);
        d4.c.b(parcel, iA);
    }
}
