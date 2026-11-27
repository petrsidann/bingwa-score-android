package r4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.r;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class a extends d4.a {
    public static final Parcelable.Creator<a> CREATOR = new g();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f14999d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f15000e = new a("unavailable");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f15001f = new a("unused");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC0265a f15002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15004c;

    /* JADX INFO: renamed from: r4.a$a, reason: collision with other inner class name */
    public enum EnumC0265a implements Parcelable {
        ABSENT(0),
        STRING(1),
        OBJECT(2);

        public static final Parcelable.Creator<EnumC0265a> CREATOR = new f();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15009a;

        EnumC0265a(int i10) {
            this.f15009a = i10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f15009a);
        }
    }

    public static class b extends Exception {
        public b(int i10) {
            super(String.format("ChannelIdValueType %s not supported", Integer.valueOf(i10)));
        }
    }

    public a() {
        this.f15002a = EnumC0265a.ABSENT;
        this.f15004c = null;
        this.f15003b = null;
    }

    public a(int i10, String str, String str2) {
        try {
            this.f15002a = V(i10);
            this.f15003b = str;
            this.f15004c = str2;
        } catch (b e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public a(String str) {
        this.f15003b = (String) r.l(str);
        this.f15002a = EnumC0265a.STRING;
        this.f15004c = null;
    }

    public static EnumC0265a V(int i10) throws b {
        for (EnumC0265a enumC0265a : EnumC0265a.values()) {
            if (i10 == enumC0265a.f15009a) {
                return enumC0265a;
            }
        }
        throw new b(i10);
    }

    public String S() {
        return this.f15004c;
    }

    public String T() {
        return this.f15003b;
    }

    public int U() {
        return this.f15002a.f15009a;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f15002a.equals(aVar.f15002a)) {
            return false;
        }
        int iOrdinal = this.f15002a.ordinal();
        if (iOrdinal == 0) {
            return true;
        }
        if (iOrdinal == 1) {
            str = this.f15003b;
            str2 = aVar.f15003b;
        } else {
            if (iOrdinal != 2) {
                return false;
            }
            str = this.f15004c;
            str2 = aVar.f15004c;
        }
        return str.equals(str2);
    }

    public int hashCode() {
        int i10;
        String str;
        int iHashCode = this.f15002a.hashCode() + 31;
        int iOrdinal = this.f15002a.ordinal();
        if (iOrdinal == 1) {
            i10 = iHashCode * 31;
            str = this.f15003b;
        } else {
            if (iOrdinal != 2) {
                return iHashCode;
            }
            i10 = iHashCode * 31;
            str = this.f15004c;
        }
        return i10 + str.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 2, U());
        d4.c.E(parcel, 3, T(), false);
        d4.c.E(parcel, 4, S(), false);
        d4.c.b(parcel, iA);
    }
}
