package u4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class sd extends d4.a {
    public static final Parcelable.Creator<sd> CREATOR = new vd();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f16812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16813c;

    public sd(String str, long j10, int i10) {
        this.f16811a = str;
        this.f16812b = j10;
        this.f16813c = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, this.f16811a, false);
        d4.c.x(parcel, 2, this.f16812b);
        d4.c.t(parcel, 3, this.f16813c);
        d4.c.b(parcel, iA);
    }
}
