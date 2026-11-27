package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public enum z implements Parcelable {
    PUBLIC_KEY("public-key");

    public static final Parcelable.Creator<z> CREATOR = new Parcelable.Creator() { // from class: q4.z0
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return z.d(parcel.readString());
            } catch (z.a e10) {
                throw new RuntimeException(e10);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i10) {
            return new z[i10];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14815a = "public-key";

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    z(String str) {
    }

    public static z d(String str) throws a {
        for (z zVar : values()) {
            if (str.equals(zVar.f14815a)) {
                return zVar;
            }
        }
        throw new a(String.format("PublicKeyCredentialType %s not supported", str));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f14815a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f14815a);
    }
}
