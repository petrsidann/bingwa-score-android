package p7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f2 implements o7.g {
    public static final Parcelable.Creator<f2> CREATOR = new e2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Object> f14227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14228d;

    public f2(String str, String str2, boolean z10) {
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.f(str2);
        this.f14225a = str;
        this.f14226b = str2;
        this.f14227c = l0.d(str2);
        this.f14228d = z10;
    }

    public f2(boolean z10) {
        this.f14228d = z10;
        this.f14226b = null;
        this.f14225a = null;
        this.f14227c = null;
    }

    @Override // o7.g
    public final Map<String, Object> D() {
        return this.f14227c;
    }

    @Override // o7.g
    public final boolean Q() {
        return this.f14228d;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // o7.g
    public final String i() {
        return this.f14225a;
    }

    @Override // o7.g
    public final String v() {
        Map<String, Object> map;
        String str;
        if ("github.com".equals(this.f14225a)) {
            map = this.f14227c;
            str = "login";
        } else {
            if (!"twitter.com".equals(this.f14225a)) {
                return null;
            }
            map = this.f14227c;
            str = "screen_name";
        }
        return (String) map.get(str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, i(), false);
        d4.c.E(parcel, 2, this.f14226b, false);
        d4.c.g(parcel, 3, Q());
        d4.c.b(parcel, iA);
    }
}
