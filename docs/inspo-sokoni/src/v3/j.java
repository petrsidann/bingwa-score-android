package v3;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class j extends d4.a {
    public static final Parcelable.Creator<j> CREATOR = new d0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f17171a;

    public j(PendingIntent pendingIntent) {
        this.f17171a = (PendingIntent) com.google.android.gms.common.internal.r.l(pendingIntent);
    }

    public PendingIntent S() {
        return this.f17171a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return com.google.android.gms.common.internal.p.b(this.f17171a, ((j) obj).f17171a);
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f17171a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.C(parcel, 1, S(), i10, false);
        d4.c.b(parcel, iA);
    }
}
