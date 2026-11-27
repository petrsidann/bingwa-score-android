package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public enum d0 implements Parcelable {
    RESIDENT_KEY_DISCOURAGED("discouraged"),
    RESIDENT_KEY_PREFERRED("preferred"),
    RESIDENT_KEY_REQUIRED("required");

    public static final Parcelable.Creator<d0> CREATOR = new Parcelable.Creator() { // from class: q4.b1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            String string = parcel.readString();
            if (string == null) {
                string = "";
            }
            try {
                return d0.d(string);
            } catch (d0.a e10) {
                throw new RuntimeException(e10);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i10) {
            return new d0[i10];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14693a;

    public static class a extends Exception {
        public a(String str) {
            super(String.format("Resident key requirement %s not supported", str));
        }
    }

    d0(String str) {
        this.f14693a = str;
    }

    public static d0 d(String str) throws a {
        for (d0 d0Var : values()) {
            if (str.equals(d0Var.f14693a)) {
                return d0Var;
            }
        }
        throw new a(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f14693a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f14693a);
    }
}
