package x3;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class c extends d4.a {
    public static final Parcelable.Creator<c> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PendingIntent f17971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f17973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17974e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f17975f;

    public c(int i10, int i11, PendingIntent pendingIntent, int i12, Bundle bundle, byte[] bArr) {
        this.f17974e = i10;
        this.f17970a = i11;
        this.f17972c = i12;
        this.f17975f = bundle;
        this.f17973d = bArr;
        this.f17971b = pendingIntent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, this.f17970a);
        d4.c.C(parcel, 2, this.f17971b, i10, false);
        d4.c.t(parcel, 3, this.f17972c);
        d4.c.j(parcel, 4, this.f17975f, false);
        d4.c.k(parcel, 5, this.f17973d, false);
        d4.c.t(parcel, 1000, this.f17974e);
        d4.c.b(parcel, iA);
    }
}
