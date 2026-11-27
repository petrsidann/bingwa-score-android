package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public enum b implements Parcelable {
    PLATFORM("platform"),
    CROSS_PLATFORM("cross-platform");

    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator() { // from class: q4.i0
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return b.d(parcel.readString());
            } catch (b.a e10) {
                throw new RuntimeException(e10);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i10) {
            return new b[i10];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14662a;

    public static class a extends Exception {
        public a(String str) {
            super(String.format("Attachment %s not supported", str));
        }
    }

    b(String str) {
        this.f14662a = str;
    }

    public static b d(String str) throws a {
        for (b bVar : values()) {
            if (str.equals(bVar.f14662a)) {
                return bVar;
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
        return this.f14662a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f14662a);
    }
}
