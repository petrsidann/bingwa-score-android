package o7;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class c1 extends d4.a {
    public static final Parcelable.Creator<c1> CREATOR = new v1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Uri f13689e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Uri f13691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f13692c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f13693d;

        public c1 a() {
            String str = this.f13690a;
            Uri uri = this.f13691b;
            return new c1(str, uri == null ? null : uri.toString(), this.f13692c, this.f13693d);
        }

        public a b(String str) {
            if (str == null) {
                this.f13692c = true;
            } else {
                this.f13690a = str;
            }
            return this;
        }

        public a c(Uri uri) {
            if (uri == null) {
                this.f13693d = true;
            } else {
                this.f13691b = uri;
            }
            return this;
        }
    }

    public c1(String str, String str2, boolean z10, boolean z11) {
        this.f13685a = str;
        this.f13686b = str2;
        this.f13687c = z10;
        this.f13688d = z11;
        this.f13689e = TextUtils.isEmpty(str2) ? null : Uri.parse(str2);
    }

    public Uri S() {
        return this.f13689e;
    }

    public final boolean T() {
        return this.f13687c;
    }

    public String w() {
        return this.f13685a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 2, w(), false);
        d4.c.E(parcel, 3, this.f13686b, false);
        d4.c.g(parcel, 4, this.f13687c);
        d4.c.g(parcel, 5, this.f13688d);
        d4.c.b(parcel, iA);
    }

    public final String zza() {
        return this.f13686b;
    }

    public final boolean zzc() {
        return this.f13688d;
    }
}
