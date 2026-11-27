package z3;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class a extends d4.a {
    public static final Parcelable.Creator<a> CREATOR = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f19776c;

    public a(int i10, int i11, Bundle bundle) {
        this.f19774a = i10;
        this.f19775b = i11;
        this.f19776c = bundle;
    }

    public int S() {
        return this.f19775b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, this.f19774a);
        d4.c.t(parcel, 2, S());
        d4.c.j(parcel, 3, this.f19776c, false);
        d4.c.b(parcel, iA);
    }
}
