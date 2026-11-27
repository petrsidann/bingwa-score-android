package c4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class e0 extends d4.a {
    public static final Parcelable.Creator<e0> CREATOR = new f0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3365d;

    public e0(boolean z10, String str, int i10, int i11) {
        this.f3362a = z10;
        this.f3363b = str;
        this.f3364c = l0.a(i10) - 1;
        this.f3365d = r.a(i11) - 1;
    }

    public final boolean S() {
        return this.f3362a;
    }

    public final int T() {
        return r.a(this.f3365d);
    }

    public final int U() {
        return l0.a(this.f3364c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.g(parcel, 1, this.f3362a);
        d4.c.E(parcel, 2, this.f3363b, false);
        d4.c.t(parcel, 3, this.f3364c);
        d4.c.t(parcel, 4, this.f3365d);
        d4.c.b(parcel, iA);
    }

    public final String zza() {
        return this.f3363b;
    }
}
