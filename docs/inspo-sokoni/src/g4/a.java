package g4;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d4.a implements h4.a.b<String, Integer> {
    public static final Parcelable.Creator<a> CREATOR = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f8651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray f8652c;

    public a() {
        this.f8650a = 1;
        this.f8651b = new HashMap();
        this.f8652c = new SparseArray();
    }

    public a(int i10, ArrayList arrayList) {
        this.f8650a = i10;
        this.f8651b = new HashMap();
        this.f8652c = new SparseArray();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            d dVar = (d) arrayList.get(i11);
            S(dVar.f8656b, dVar.f8657c);
        }
    }

    public a S(String str, int i10) {
        this.f8651b.put(str, Integer.valueOf(i10));
        this.f8652c.put(i10, str);
        return this;
    }

    @Override // h4.a.b
    public final /* bridge */ /* synthetic */ Object q(Object obj) {
        String str = (String) this.f8652c.get(((Integer) obj).intValue());
        return (str == null && this.f8651b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    @Override // h4.a.b
    public final /* bridge */ /* synthetic */ Object t(Object obj) {
        Integer num = (Integer) this.f8651b.get((String) obj);
        return num == null ? (Integer) this.f8651b.get("gms_unknown") : num;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.f8650a;
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, i11);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f8651b.keySet()) {
            arrayList.add(new d(str, ((Integer) this.f8651b.get(str)).intValue()));
        }
        d4.c.I(parcel, 2, arrayList, false);
        d4.c.b(parcel, iA);
    }
}
