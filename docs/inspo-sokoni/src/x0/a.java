package x0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Parcelable f17949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f17948b = new C0318a();
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* JADX INFO: renamed from: x0.a$a, reason: collision with other inner class name */
    public class C0318a extends a {
        public C0318a() {
            super((C0318a) null);
        }
    }

    public class b implements Parcelable.ClassLoaderCreator<a> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.f17948b;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    public a() {
        this.f17949a = null;
    }

    public a(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f17949a = parcelable == null ? f17948b : parcelable;
    }

    public a(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.f17949a = parcelable == f17948b ? null : parcelable;
    }

    public /* synthetic */ a(C0318a c0318a) {
        this();
    }

    public final Parcelable a() {
        return this.f17949a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f17949a, i10);
    }
}
