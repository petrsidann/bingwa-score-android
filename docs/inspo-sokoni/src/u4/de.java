package u4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class de extends d4.a {
    public static final Parcelable.Creator<de> CREATOR = new ce();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<zd> f16122a;

    public de(List<zd> list) {
        this.f16122a = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.I(parcel, 1, this.f16122a, false);
        d4.c.b(parcel, iA);
    }
}
