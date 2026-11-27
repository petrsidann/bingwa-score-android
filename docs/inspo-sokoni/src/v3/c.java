package v3;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class c extends d4.a {
    public static final Parcelable.Creator<c> CREATOR = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f17150a;

    public c(PendingIntent pendingIntent) {
        this.f17150a = (PendingIntent) com.google.android.gms.common.internal.r.l(pendingIntent);
    }

    public PendingIntent S() {
        return this.f17150a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.C(parcel, 1, S(), i10, false);
        d4.c.b(parcel, iA);
    }
}
