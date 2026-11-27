package v3;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class e extends d4.a {
    public static final Parcelable.Creator<e> CREATOR = new u();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17151a;

    public e(int i10) {
        this.f17151a = i10;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return com.google.android.gms.common.internal.p.b(Integer.valueOf(this.f17151a), Integer.valueOf(((e) obj).f17151a));
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(Integer.valueOf(this.f17151a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, this.f17151a);
        d4.c.b(parcel, iA);
    }
}
