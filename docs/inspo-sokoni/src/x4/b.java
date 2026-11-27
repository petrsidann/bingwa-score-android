package x4;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class b extends d4.a implements com.google.android.gms.common.api.k {
    public static final Parcelable.Creator<b> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Intent f17983c;

    public b() {
        this(2, 0, null);
    }

    public b(int i10, int i11, Intent intent) {
        this.f17981a = i10;
        this.f17982b = i11;
        this.f17983c = intent;
    }

    @Override // com.google.android.gms.common.api.k
    public final Status getStatus() {
        return this.f17982b == 0 ? Status.f3655f : Status.f3659o;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f17981a;
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, i11);
        d4.c.t(parcel, 2, this.f17982b);
        d4.c.C(parcel, 3, this.f17983c, i10, false);
        d4.c.b(parcel, iA);
    }
}
