package h4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class g extends d4.a {
    public static final Parcelable.Creator<g> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.C0159a f9626c;

    public g(int i10, String str, a.C0159a c0159a) {
        this.f9624a = i10;
        this.f9625b = str;
        this.f9626c = c0159a;
    }

    public g(String str, a.C0159a c0159a) {
        this.f9624a = 1;
        this.f9625b = str;
        this.f9626c = c0159a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f9624a;
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, i11);
        d4.c.E(parcel, 2, this.f9625b, false);
        d4.c.C(parcel, 3, this.f9626c, i10, false);
        d4.c.b(parcel, iA);
    }
}
