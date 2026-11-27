package u4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class ze extends d4.a {
    public static final Parcelable.Creator<ze> CREATOR = new ye();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f17017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f17018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f17019f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Double f17020l;

    public ze(int i10, String str, long j10, Long l10, Float f10, String str2, String str3, Double d10) {
        this.f17014a = i10;
        this.f17015b = str;
        this.f17016c = j10;
        this.f17017d = l10;
        if (i10 == 1) {
            this.f17020l = f10 != null ? Double.valueOf(f10.doubleValue()) : null;
        } else {
            this.f17020l = d10;
        }
        this.f17018e = str2;
        this.f17019f = str3;
    }

    public ze(String str, long j10, Object obj, String str2) {
        com.google.android.gms.common.internal.r.f(str);
        this.f17014a = 2;
        this.f17015b = str;
        this.f17016c = j10;
        this.f17019f = str2;
        if (obj == null) {
            this.f17017d = null;
            this.f17020l = null;
            this.f17018e = null;
            return;
        }
        if (obj instanceof Long) {
            this.f17017d = (Long) obj;
            this.f17020l = null;
            this.f17018e = null;
        } else if (obj instanceof String) {
            this.f17017d = null;
            this.f17020l = null;
            this.f17018e = (String) obj;
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("User attribute given of un-supported type");
            }
            this.f17017d = null;
            this.f17020l = (Double) obj;
            this.f17018e = null;
        }
    }

    public ze(bf bfVar) {
        this(bfVar.f16056c, bfVar.f16057d, bfVar.f16058e, bfVar.f16055b);
    }

    public final Object S() {
        Long l10 = this.f17017d;
        if (l10 != null) {
            return l10;
        }
        Double d10 = this.f17020l;
        if (d10 != null) {
            return d10;
        }
        String str = this.f17018e;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, this.f17014a);
        d4.c.E(parcel, 2, this.f17015b, false);
        d4.c.x(parcel, 3, this.f17016c);
        d4.c.z(parcel, 4, this.f17017d, false);
        d4.c.r(parcel, 5, null, false);
        d4.c.E(parcel, 6, this.f17018e, false);
        d4.c.E(parcel, 7, this.f17019f, false);
        d4.c.o(parcel, 8, this.f17020l, false);
        d4.c.b(parcel, iA);
    }
}
