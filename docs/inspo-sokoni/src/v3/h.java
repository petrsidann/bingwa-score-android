package v3;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class h extends d4.a {
    public static final Parcelable.Creator<h> CREATOR = new b0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f17164a;

    public h(PendingIntent pendingIntent) {
        this.f17164a = pendingIntent;
    }

    public PendingIntent S() {
        return this.f17164a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            return com.google.android.gms.common.internal.p.b(this.f17164a, ((h) obj).f17164a);
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f17164a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.C(parcel, 1, S(), i10, false);
        d4.c.b(parcel, iA);
    }
}
