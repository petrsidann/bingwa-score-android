package g4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class b extends d4.a {
    public static final Parcelable.Creator<b> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f8654b;

    public b(int i10, a aVar) {
        this.f8653a = i10;
        this.f8654b = aVar;
    }

    public b(a aVar) {
        this.f8653a = 1;
        this.f8654b = aVar;
    }

    public static b S(h4.a.b bVar) {
        if (bVar instanceof a) {
            return new b((a) bVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final h4.a.b T() {
        a aVar = this.f8654b;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f8653a;
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, i11);
        d4.c.C(parcel, 2, this.f8654b, i10, false);
        d4.c.b(parcel, iA);
    }
}
