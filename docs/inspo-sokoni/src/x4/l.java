package x4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.r0;

/* JADX INFO: loaded from: classes.dex */
public final class l extends d4.a {
    public static final Parcelable.Creator<l> CREATOR = new m();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c4.b f17989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r0 f17990c;

    public l(int i10, c4.b bVar, r0 r0Var) {
        this.f17988a = i10;
        this.f17989b = bVar;
        this.f17990c = r0Var;
    }

    public final c4.b S() {
        return this.f17989b;
    }

    public final r0 T() {
        return this.f17990c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, this.f17988a);
        d4.c.C(parcel, 2, this.f17989b, i10, false);
        d4.c.C(parcel, 3, this.f17990c, i10, false);
        d4.c.b(parcel, iA);
    }
}
