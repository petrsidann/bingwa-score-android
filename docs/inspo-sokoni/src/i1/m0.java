package i1;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class m0 implements Parcelable {
    public static final Parcelable.Creator<m0> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f10273f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f10274l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f10275m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f10276n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f10277o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f10278p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f10279q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f10280r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f10281s;

    public class a implements Parcelable.Creator<m0> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public m0 createFromParcel(Parcel parcel) {
            return new m0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public m0[] newArray(int i10) {
            return new m0[i10];
        }
    }

    public m0(Parcel parcel) {
        this.f10268a = parcel.readString();
        this.f10269b = parcel.readString();
        this.f10270c = parcel.readInt() != 0;
        this.f10271d = parcel.readInt();
        this.f10272e = parcel.readInt();
        this.f10273f = parcel.readString();
        this.f10274l = parcel.readInt() != 0;
        this.f10275m = parcel.readInt() != 0;
        this.f10276n = parcel.readInt() != 0;
        this.f10277o = parcel.readInt() != 0;
        this.f10278p = parcel.readInt();
        this.f10279q = parcel.readString();
        this.f10280r = parcel.readInt();
        this.f10281s = parcel.readInt() != 0;
    }

    public m0(p pVar) {
        this.f10268a = pVar.getClass().getName();
        this.f10269b = pVar.f10328f;
        this.f10270c = pVar.f10341u;
        this.f10271d = pVar.D;
        this.f10272e = pVar.E;
        this.f10273f = pVar.F;
        this.f10274l = pVar.I;
        this.f10275m = pVar.f10338r;
        this.f10276n = pVar.H;
        this.f10277o = pVar.G;
        this.f10278p = pVar.Y.ordinal();
        this.f10279q = pVar.f10334n;
        this.f10280r = pVar.f10335o;
        this.f10281s = pVar.Q;
    }

    public p a(y yVar, ClassLoader classLoader) {
        p pVarA = yVar.a(classLoader, this.f10268a);
        pVarA.f10328f = this.f10269b;
        pVarA.f10341u = this.f10270c;
        pVarA.f10343w = true;
        pVarA.D = this.f10271d;
        pVarA.E = this.f10272e;
        pVarA.F = this.f10273f;
        pVarA.I = this.f10274l;
        pVarA.f10338r = this.f10275m;
        pVarA.H = this.f10276n;
        pVarA.G = this.f10277o;
        pVarA.Y = androidx.lifecycle.g.b.values()[this.f10278p];
        pVarA.f10334n = this.f10279q;
        pVarA.f10335o = this.f10280r;
        pVarA.Q = this.f10281s;
        return pVarA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f10268a);
        sb2.append(" (");
        sb2.append(this.f10269b);
        sb2.append(")}:");
        if (this.f10270c) {
            sb2.append(" fromLayout");
        }
        if (this.f10272e != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.f10272e));
        }
        String str = this.f10273f;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(this.f10273f);
        }
        if (this.f10274l) {
            sb2.append(" retainInstance");
        }
        if (this.f10275m) {
            sb2.append(" removing");
        }
        if (this.f10276n) {
            sb2.append(" detached");
        }
        if (this.f10277o) {
            sb2.append(" hidden");
        }
        if (this.f10279q != null) {
            sb2.append(" targetWho=");
            sb2.append(this.f10279q);
            sb2.append(" targetRequestCode=");
            sb2.append(this.f10280r);
        }
        if (this.f10281s) {
            sb2.append(" userVisibleHint");
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f10268a);
        parcel.writeString(this.f10269b);
        parcel.writeInt(this.f10270c ? 1 : 0);
        parcel.writeInt(this.f10271d);
        parcel.writeInt(this.f10272e);
        parcel.writeString(this.f10273f);
        parcel.writeInt(this.f10274l ? 1 : 0);
        parcel.writeInt(this.f10275m ? 1 : 0);
        parcel.writeInt(this.f10276n ? 1 : 0);
        parcel.writeInt(this.f10277o ? 1 : 0);
        parcel.writeInt(this.f10278p);
        parcel.writeString(this.f10279q);
        parcel.writeInt(this.f10280r);
        parcel.writeInt(this.f10281s ? 1 : 0);
    }
}
