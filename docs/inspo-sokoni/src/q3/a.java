package q3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.r;

/* JADX INFO: loaded from: classes.dex */
public class a extends d4.a {
    public static final Parcelable.Creator<a> CREATOR = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f14635f;

    public a(int i10, long j10, String str, int i11, int i12, String str2) {
        this.f14630a = i10;
        this.f14631b = j10;
        this.f14632c = (String) r.l(str);
        this.f14633d = i11;
        this.f14634e = i12;
        this.f14635f = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        a aVar = (a) obj;
        return this.f14630a == aVar.f14630a && this.f14631b == aVar.f14631b && p.b(this.f14632c, aVar.f14632c) && this.f14633d == aVar.f14633d && this.f14634e == aVar.f14634e && p.b(this.f14635f, aVar.f14635f);
    }

    public int hashCode() {
        return p.c(Integer.valueOf(this.f14630a), Long.valueOf(this.f14631b), this.f14632c, Integer.valueOf(this.f14633d), Integer.valueOf(this.f14634e), this.f14635f);
    }

    public String toString() {
        String str;
        int i10 = this.f14633d;
        if (i10 == 1) {
            str = "ADDED";
        } else if (i10 == 2) {
            str = "REMOVED";
        } else if (i10 != 3) {
            str = i10 != 4 ? "UNKNOWN" : "RENAMED_TO";
        } else {
            str = "RENAMED_FROM";
        }
        return "AccountChangeEvent {accountName = " + this.f14632c + ", changeType = " + str + ", changeData = " + this.f14635f + ", eventIndex = " + this.f14634e + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, this.f14630a);
        d4.c.x(parcel, 2, this.f14631b);
        d4.c.E(parcel, 3, this.f14632c, false);
        d4.c.t(parcel, 4, this.f14633d);
        d4.c.t(parcel, 5, this.f14634e);
        d4.c.E(parcel, 6, this.f14635f, false);
        d4.c.b(parcel, iA);
    }
}
