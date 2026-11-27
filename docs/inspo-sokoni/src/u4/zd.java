package u4;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zd extends d4.a {
    public static final Parcelable.Creator<zd> CREATOR = new yd();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f17008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f17010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f17012f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f17013l;

    public zd(long j10, byte[] bArr, String str, Bundle bundle, int i10, long j11) {
        this(j10, bArr, str, bundle, i10, j11, "");
    }

    public zd(long j10, byte[] bArr, String str, Bundle bundle, int i10, long j11, String str2) {
        this.f17007a = j10;
        this.f17008b = bArr;
        this.f17009c = str;
        this.f17010d = bundle;
        this.f17011e = i10;
        this.f17012f = j11;
        this.f17013l = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.x(parcel, 1, this.f17007a);
        d4.c.k(parcel, 2, this.f17008b, false);
        d4.c.E(parcel, 3, this.f17009c, false);
        d4.c.j(parcel, 4, this.f17010d, false);
        d4.c.t(parcel, 5, this.f17011e);
        d4.c.x(parcel, 6, this.f17012f);
        d4.c.E(parcel, 7, this.f17013l, false);
        d4.c.b(parcel, iA);
    }
}
