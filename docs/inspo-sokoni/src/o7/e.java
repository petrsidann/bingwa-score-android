package o7;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class e extends d4.a {
    public static final Parcelable.Creator<e> CREATOR = new w1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f13705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f13706f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f13707l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f13708m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13709n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f13710o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f13711p;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f13714c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f13715d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f13716e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f13717f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f13718g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f13719h;

        public a() {
            this.f13717f = false;
        }

        public e a() {
            if (this.f13712a != null) {
                return new e(this);
            }
            throw new IllegalArgumentException("Cannot build ActionCodeSettings with null URL. Call #setUrl(String) before calling build()");
        }

        public a b(String str, boolean z10, String str2) {
            this.f13714c = str;
            this.f13715d = z10;
            this.f13716e = str2;
            return this;
        }

        @Deprecated
        public a c(String str) {
            this.f13718g = str;
            return this;
        }

        public a d(boolean z10) {
            this.f13717f = z10;
            return this;
        }

        public a e(String str) {
            this.f13713b = str;
            return this;
        }

        public a f(String str) {
            this.f13719h = str;
            return this;
        }

        public a g(String str) {
            this.f13712a = str;
            return this;
        }
    }

    public e(String str, String str2, String str3, String str4, boolean z10, String str5, boolean z11, String str6, int i10, String str7, String str8) {
        this.f13701a = str;
        this.f13702b = str2;
        this.f13703c = str3;
        this.f13704d = str4;
        this.f13705e = z10;
        this.f13706f = str5;
        this.f13707l = z11;
        this.f13708m = str6;
        this.f13709n = i10;
        this.f13710o = str7;
        this.f13711p = str8;
    }

    public e(a aVar) {
        this.f13701a = aVar.f13712a;
        this.f13702b = aVar.f13713b;
        this.f13703c = null;
        this.f13704d = aVar.f13714c;
        this.f13705e = aVar.f13715d;
        this.f13706f = aVar.f13716e;
        this.f13707l = aVar.f13717f;
        this.f13710o = aVar.f13718g;
        this.f13711p = aVar.f13719h;
    }

    public static a Z() {
        return new a();
    }

    public static e d0() {
        return new e(new a());
    }

    public boolean S() {
        return this.f13707l;
    }

    public boolean T() {
        return this.f13705e;
    }

    public String U() {
        return this.f13706f;
    }

    public String V() {
        return this.f13704d;
    }

    public String W() {
        return this.f13702b;
    }

    public String X() {
        return this.f13711p;
    }

    public String Y() {
        return this.f13701a;
    }

    public final int a0() {
        return this.f13709n;
    }

    public final void b0(int i10) {
        this.f13709n = i10;
    }

    public final void c0(String str) {
        this.f13708m = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 1, Y(), false);
        d4.c.E(parcel, 2, W(), false);
        d4.c.E(parcel, 3, this.f13703c, false);
        d4.c.E(parcel, 4, V(), false);
        d4.c.g(parcel, 5, T());
        d4.c.E(parcel, 6, U(), false);
        d4.c.g(parcel, 7, S());
        d4.c.E(parcel, 8, this.f13708m, false);
        d4.c.t(parcel, 9, this.f13709n);
        d4.c.E(parcel, 10, this.f13710o, false);
        d4.c.E(parcel, 11, X(), false);
        d4.c.b(parcel, iA);
    }

    @Deprecated
    public final String zzc() {
        return this.f13710o;
    }

    public final String zzd() {
        return this.f13703c;
    }

    public final String zze() {
        return this.f13708m;
    }
}
