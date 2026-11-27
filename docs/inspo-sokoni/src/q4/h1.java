package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public enum h1 implements Parcelable {
    USER_VERIFICATION_REQUIRED("required"),
    USER_VERIFICATION_PREFERRED("preferred"),
    USER_VERIFICATION_DISCOURAGED("discouraged");

    public static final Parcelable.Creator<h1> CREATOR = new Parcelable.Creator() { // from class: q4.f1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return h1.d(parcel.readString());
            } catch (g1 e10) {
                throw new RuntimeException(e10);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i10) {
            return new h1[i10];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14727a;

    h1(String str) {
        this.f14727a = str;
    }

    public static h1 d(String str) throws g1 {
        for (h1 h1Var : values()) {
            if (str.equals(h1Var.f14727a)) {
                return h1Var;
            }
        }
        throw new g1(str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f14727a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f14727a);
    }
}
