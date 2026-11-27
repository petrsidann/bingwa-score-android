package f;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0133a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Intent f7997b;

    /* JADX INFO: renamed from: f.a$a, reason: collision with other inner class name */
    public class C0133a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    public a(int i10, Intent intent) {
        this.f7996a = i10;
        this.f7997b = intent;
    }

    public a(Parcel parcel) {
        this.f7996a = parcel.readInt();
        this.f7997b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }

    public static String c(int i10) {
        if (i10 != -1) {
            return i10 != 0 ? String.valueOf(i10) : "RESULT_CANCELED";
        }
        return "RESULT_OK";
    }

    public Intent a() {
        return this.f7997b;
    }

    public int b() {
        return this.f7996a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + c(this.f7996a) + ", data=" + this.f7997b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f7996a);
        parcel.writeInt(this.f7997b == null ? 0 : 1);
        Intent intent = this.f7997b;
        if (intent != null) {
            intent.writeToParcel(parcel, i10);
        }
    }
}
