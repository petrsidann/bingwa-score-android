package q4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.fido.zzao;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class e0 extends d4.a {
    public static final Parcelable.Creator<e0> CREATOR = new d1();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e0 f14699c = new e0(a.SUPPORTED.toString(), null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e0 f14700d = new e0(a.NOT_SUPPORTED.toString(), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f14701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14702b;

    public enum a implements Parcelable {
        PRESENT("present"),
        SUPPORTED("supported"),
        NOT_SUPPORTED("not-supported");

        public static final Parcelable.Creator<a> CREATOR = new c1();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f14707a;

        a(String str) {
            this.f14707a = str;
        }

        public static a d(String str) throws b {
            for (a aVar : values()) {
                if (str.equals(aVar.f14707a)) {
                    return aVar;
                }
            }
            throw new b(str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f14707a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f14707a);
        }
    }

    public static class b extends Exception {
        public b(String str) {
            super(String.format("TokenBindingStatus %s not supported", str));
        }
    }

    public e0(String str, String str2) {
        com.google.android.gms.common.internal.r.l(str);
        try {
            this.f14701a = a.d(str);
            this.f14702b = str2;
        } catch (b e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public String S() {
        return this.f14702b;
    }

    public String T() {
        return this.f14701a.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return zzao.zza(this.f14701a, e0Var.f14701a) && zzao.zza(this.f14702b, e0Var.f14702b);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f14701a, this.f14702b});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.E(parcel, 2, T(), false);
        d4.c.E(parcel, 3, S(), false);
        d4.c.b(parcel, iA);
    }
}
