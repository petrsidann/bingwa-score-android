package x4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h extends d4.a implements com.google.android.gms.common.api.k {
    public static final Parcelable.Creator<h> CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f17984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17985b;

    public h(List list, String str) {
        this.f17984a = list;
        this.f17985b = str;
    }

    @Override // com.google.android.gms.common.api.k
    public final Status getStatus() {
        return this.f17985b != null ? Status.f3655f : Status.f3659o;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        List list = this.f17984a;
        int iA = d4.c.a(parcel);
        d4.c.G(parcel, 1, list, false);
        d4.c.E(parcel, 2, this.f17985b, false);
        d4.c.b(parcel, iA);
    }
}
