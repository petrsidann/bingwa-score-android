package c4;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends d4.a {
    public static final Parcelable.Creator<c0> CREATOR = new d0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f3352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f3354f;

    public c0(String str, boolean z10, boolean z11, IBinder iBinder, boolean z12, boolean z13) {
        this.f3349a = str;
        this.f3350b = z10;
        this.f3351c = z11;
        this.f3352d = (Context) m4.b.f(m4.a.AbstractBinderC0217a.b(iBinder));
        this.f3353e = z12;
        this.f3354f = z13;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [android.os.IBinder, m4.a] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        String str = this.f3349a;
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, str, false);
        d4.c.g(parcel, 2, this.f3350b);
        d4.c.g(parcel, 3, this.f3351c);
        d4.c.s(parcel, 4, m4.b.i(this.f3352d), false);
        d4.c.g(parcel, 5, this.f3353e);
        d4.c.g(parcel, 6, this.f3354f);
        d4.c.b(parcel, iA);
    }
}
