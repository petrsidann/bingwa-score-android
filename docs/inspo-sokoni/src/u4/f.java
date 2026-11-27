package u4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class f extends d4.a {
    public static final Parcelable.Creator<f> CREATOR = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f16173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f16175c;

    public f(long j10, int i10, long j11) {
        this.f16173a = j10;
        this.f16174b = i10;
        this.f16175c = j11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.x(parcel, 1, this.f16173a);
        d4.c.t(parcel, 2, this.f16174b);
        d4.c.x(parcel, 3, this.f16175c);
        d4.c.b(parcel, iA);
    }
}
