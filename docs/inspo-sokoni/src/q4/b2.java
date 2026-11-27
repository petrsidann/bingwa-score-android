package q4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b2 extends d4.a {
    public static final Parcelable.Creator<b2> CREATOR = new c2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f14673a;

    public b2(List list) {
        this.f14673a = (List) com.google.android.gms.common.internal.r.l(list);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b2)) {
            return false;
        }
        b2 b2Var = (b2) obj;
        return this.f14673a.containsAll(b2Var.f14673a) && b2Var.f14673a.containsAll(this.f14673a);
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.c(new HashSet(this.f14673a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.I(parcel, 1, this.f14673a, false);
        d4.c.b(parcel, iA);
    }
}
