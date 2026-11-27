package g4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d extends d4.a {
    public static final Parcelable.Creator<d> CREATOR = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8657c;

    public d(int i10, String str, int i11) {
        this.f8655a = i10;
        this.f8656b = str;
        this.f8657c = i11;
    }

    public d(String str, int i10) {
        this.f8655a = 1;
        this.f8656b = str;
        this.f8657c = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f8655a;
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, i11);
        d4.c.E(parcel, 2, this.f8656b, false);
        d4.c.t(parcel, 3, this.f8657c);
        d4.c.b(parcel, iA);
    }
}
