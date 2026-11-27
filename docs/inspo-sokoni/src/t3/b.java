package t3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class b extends zzbz {
    public static final Parcelable.Creator<b> CREATOR = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap f15817f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f15818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f15820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f15822e;

    static {
        HashMap map = new HashMap();
        f15817f = map;
        map.put("authenticatorData", h4.a.C0159a.U("authenticatorData", 2, g.class));
        map.put("progress", h4.a.C0159a.T("progress", 4, e.class));
    }

    public b() {
        this.f15818a = new HashSet(1);
        this.f15819b = 1;
    }

    public b(Set set, int i10, ArrayList arrayList, int i11, e eVar) {
        this.f15818a = set;
        this.f15819b = i10;
        this.f15820c = arrayList;
        this.f15821d = i11;
        this.f15822e = eVar;
    }

    @Override // h4.a
    public final void addConcreteTypeArrayInternal(h4.a.C0159a c0159a, String str, ArrayList arrayList) {
        int iY = c0159a.Y();
        if (iY != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", Integer.valueOf(iY), arrayList.getClass().getCanonicalName()));
        }
        this.f15820c = arrayList;
        this.f15818a.add(Integer.valueOf(iY));
    }

    @Override // h4.a
    public final void addConcreteTypeInternal(h4.a.C0159a c0159a, String str, h4.a aVar) {
        int iY = c0159a.Y();
        if (iY != 4) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(iY), aVar.getClass().getCanonicalName()));
        }
        this.f15822e = (e) aVar;
        this.f15818a.add(Integer.valueOf(iY));
    }

    @Override // h4.a
    public final /* synthetic */ Map getFieldMappings() {
        return f15817f;
    }

    @Override // h4.a
    public final Object getFieldValue(h4.a.C0159a c0159a) {
        int iY = c0159a.Y();
        if (iY == 1) {
            return Integer.valueOf(this.f15819b);
        }
        if (iY == 2) {
            return this.f15820c;
        }
        if (iY == 4) {
            return this.f15822e;
        }
        throw new IllegalStateException("Unknown SafeParcelable id=" + c0159a.Y());
    }

    @Override // h4.a
    public final boolean isFieldSet(h4.a.C0159a c0159a) {
        return this.f15818a.contains(Integer.valueOf(c0159a.Y()));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        Set set = this.f15818a;
        if (set.contains(1)) {
            d4.c.t(parcel, 1, this.f15819b);
        }
        if (set.contains(2)) {
            d4.c.I(parcel, 2, this.f15820c, true);
        }
        if (set.contains(3)) {
            d4.c.t(parcel, 3, this.f15821d);
        }
        if (set.contains(4)) {
            d4.c.C(parcel, 4, this.f15822e, i10, true);
        }
        d4.c.b(parcel, iA);
    }
}
