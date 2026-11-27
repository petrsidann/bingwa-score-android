package q3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.r;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends d4.a {
    public static final Parcelable.Creator<c> CREATOR = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f14641b;

    public c(int i10, List list) {
        this.f14640a = i10;
        this.f14641b = (List) r.l(list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, this.f14640a);
        d4.c.I(parcel, 2, this.f14641b, false);
        d4.c.b(parcel, iA);
    }
}
