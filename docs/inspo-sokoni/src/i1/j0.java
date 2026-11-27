package i1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class j0 implements Parcelable {
    public static final Parcelable.Creator<j0> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<String> f10246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<String> f10247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b[] f10248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f10250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<String> f10251f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList<c> f10252l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList<h0.l> f10253m;

    public class a implements Parcelable.Creator<j0> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j0 createFromParcel(Parcel parcel) {
            return new j0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public j0[] newArray(int i10) {
            return new j0[i10];
        }
    }

    public j0() {
        this.f10250e = null;
        this.f10251f = new ArrayList<>();
        this.f10252l = new ArrayList<>();
    }

    public j0(Parcel parcel) {
        this.f10250e = null;
        this.f10251f = new ArrayList<>();
        this.f10252l = new ArrayList<>();
        this.f10246a = parcel.createStringArrayList();
        this.f10247b = parcel.createStringArrayList();
        this.f10248c = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f10249d = parcel.readInt();
        this.f10250e = parcel.readString();
        this.f10251f = parcel.createStringArrayList();
        this.f10252l = parcel.createTypedArrayList(c.CREATOR);
        this.f10253m = parcel.createTypedArrayList(h0.l.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.f10246a);
        parcel.writeStringList(this.f10247b);
        parcel.writeTypedArray(this.f10248c, i10);
        parcel.writeInt(this.f10249d);
        parcel.writeString(this.f10250e);
        parcel.writeStringList(this.f10251f);
        parcel.writeTypedList(this.f10252l);
        parcel.writeTypedList(this.f10253m);
    }
}
