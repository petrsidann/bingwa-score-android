package t3;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class a extends d4.a {
    public static final Parcelable.Creator<a> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f15815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f15816d;

    public a(int i10, boolean z10, long j10, boolean z11) {
        this.f15813a = i10;
        this.f15814b = z10;
        this.f15815c = j10;
        this.f15816d = z11;
    }

    public long S() {
        return this.f15815c;
    }

    public boolean T() {
        return this.f15816d;
    }

    public boolean U() {
        return this.f15814b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, this.f15813a);
        d4.c.g(parcel, 2, U());
        d4.c.x(parcel, 3, S());
        d4.c.g(parcel, 4, T());
        d4.c.b(parcel, iA);
    }
}
