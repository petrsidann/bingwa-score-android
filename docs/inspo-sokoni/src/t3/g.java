package t3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.auth.zzbz;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class g extends zzbz {
    public static final Parcelable.Creator<g> CREATOR = new h();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final HashMap f15830l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f15831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f15833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f15834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f15835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f15836f;

    static {
        HashMap map = new HashMap();
        f15830l = map;
        map.put("authenticatorInfo", h4.a.C0159a.T("authenticatorInfo", 2, i.class));
        map.put("signature", h4.a.C0159a.W("signature", 3));
        map.put("package", h4.a.C0159a.W("package", 4));
    }

    public g() {
        this.f15831a = new HashSet(3);
        this.f15832b = 1;
    }

    public g(Set set, int i10, i iVar, String str, String str2, String str3) {
        this.f15831a = set;
        this.f15832b = i10;
        this.f15833c = iVar;
        this.f15834d = str;
        this.f15835e = str2;
        this.f15836f = str3;
    }

    @Override // h4.a
    public final void addConcreteTypeInternal(h4.a.C0159a c0159a, String str, h4.a aVar) {
        int iY = c0159a.Y();
        if (iY != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", Integer.valueOf(iY), aVar.getClass().getCanonicalName()));
        }
        this.f15833c = (i) aVar;
        this.f15831a.add(Integer.valueOf(iY));
    }

    @Override // h4.a
    public final /* synthetic */ Map getFieldMappings() {
        return f15830l;
    }

    @Override // h4.a
    public final Object getFieldValue(h4.a.C0159a c0159a) {
        int iY = c0159a.Y();
        if (iY == 1) {
            return Integer.valueOf(this.f15832b);
        }
        if (iY == 2) {
            return this.f15833c;
        }
        if (iY == 3) {
            return this.f15834d;
        }
        if (iY == 4) {
            return this.f15835e;
        }
        throw new IllegalStateException("Unknown SafeParcelable id=" + c0159a.Y());
    }

    @Override // h4.a
    public final boolean isFieldSet(h4.a.C0159a c0159a) {
        return this.f15831a.contains(Integer.valueOf(c0159a.Y()));
    }

    @Override // h4.a
    public final void setStringInternal(h4.a.C0159a c0159a, String str, String str2) {
        int iY = c0159a.Y();
        if (iY == 3) {
            this.f15834d = str2;
        } else {
            if (iY != 4) {
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(iY)));
            }
            this.f15835e = str2;
        }
        this.f15831a.add(Integer.valueOf(iY));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        Set set = this.f15831a;
        if (set.contains(1)) {
            d4.c.t(parcel, 1, this.f15832b);
        }
        if (set.contains(2)) {
            d4.c.C(parcel, 2, this.f15833c, i10, true);
        }
        if (set.contains(3)) {
            d4.c.E(parcel, 3, this.f15834d, true);
        }
        if (set.contains(4)) {
            d4.c.E(parcel, 4, this.f15835e, true);
        }
        if (set.contains(5)) {
            d4.c.E(parcel, 5, this.f15836f, true);
        }
        d4.c.b(parcel, iA);
    }
}
