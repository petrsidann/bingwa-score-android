package x4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p0;

/* JADX INFO: loaded from: classes.dex */
public final class j extends d4.a {
    public static final Parcelable.Creator<j> CREATOR = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p0 f17987b;

    public j(int i10, p0 p0Var) {
        this.f17986a = i10;
        this.f17987b = p0Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, this.f17986a);
        d4.c.C(parcel, 2, this.f17987b, i10, false);
        d4.c.b(parcel, iA);
    }
}
