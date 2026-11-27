package c6;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import t.g;

/* JADX INFO: loaded from: classes.dex */
public class a extends x0.a {
    public static final Parcelable.Creator<a> CREATOR = new C0065a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g<String, Bundle> f3408c;

    /* JADX INFO: renamed from: c6.a$a, reason: collision with other inner class name */
    public class C0065a implements Parcelable.ClassLoaderCreator<a> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null, 0 == true ? 1 : 0);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    public a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i10 = parcel.readInt();
        String[] strArr = new String[i10];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i10];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f3408c = new g<>(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            this.f3408c.put(strArr[i11], bundleArr[i11]);
        }
    }

    public /* synthetic */ a(Parcel parcel, ClassLoader classLoader, C0065a c0065a) {
        this(parcel, classLoader);
    }

    public a(Parcelable parcelable) {
        super(parcelable);
        this.f3408c = new g<>();
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f3408c + "}";
    }

    @Override // x0.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        int size = this.f3408c.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = this.f3408c.i(i11);
            bundleArr[i11] = this.f3408c.m(i11);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
