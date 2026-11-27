package q4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class o implements Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new y1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q4.a f14744a;

    public static class a extends Exception {
        public a(int i10) {
            super("Algorithm with COSE value " + i10 + " not supported");
        }
    }

    public o(q4.a aVar) {
        this.f14744a = (q4.a) com.google.android.gms.common.internal.r.l(aVar);
    }

    public static o a(int i10) throws a {
        q4.a aVar;
        if (i10 != b0.LEGACY_RS1.d()) {
            for (b0 b0Var : b0.values()) {
                if (b0Var.d() == i10) {
                    aVar = b0Var;
                }
            }
            for (p pVar : p.values()) {
                if (pVar.d() == i10) {
                    aVar = pVar;
                }
            }
            throw new a(i10);
        }
        aVar = b0.RS1;
        return new o(aVar);
    }

    public int b() {
        return this.f14744a.d();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof o) && this.f14744a.d() == ((o) obj).f14744a.d();
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.c(this.f14744a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f14744a.d());
    }
}
