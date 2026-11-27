package h4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f extends d4.a {
    public static final Parcelable.Creator<f> CREATOR = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f9623c;

    public f(int i10, String str, ArrayList arrayList) {
        this.f9621a = i10;
        this.f9622b = str;
        this.f9623c = arrayList;
    }

    public f(String str, Map map) {
        ArrayList arrayList;
        this.f9621a = 1;
        this.f9622b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(new g(str2, (a.C0159a) map.get(str2)));
            }
        }
        this.f9623c = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f9621a;
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, i11);
        d4.c.E(parcel, 2, this.f9622b, false);
        d4.c.I(parcel, 3, this.f9623c, false);
        d4.c.b(parcel, iA);
    }
}
