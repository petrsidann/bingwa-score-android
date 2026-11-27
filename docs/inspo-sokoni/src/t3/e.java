package t3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.auth.zzbz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e extends zzbz {
    public static final Parcelable.Creator<e> CREATOR = new f();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final t.a f15823l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f15825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f15826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f15827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f15828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f15829f;

    static {
        t.a aVar = new t.a();
        f15823l = aVar;
        aVar.put("registered", h4.a.C0159a.X("registered", 2));
        aVar.put("in_progress", h4.a.C0159a.X("in_progress", 3));
        aVar.put("success", h4.a.C0159a.X("success", 4));
        aVar.put("failed", h4.a.C0159a.X("failed", 5));
        aVar.put("escrowed", h4.a.C0159a.X("escrowed", 6));
    }

    public e() {
        this.f15824a = 1;
    }

    public e(int i10, List list, List list2, List list3, List list4, List list5) {
        this.f15824a = i10;
        this.f15825b = list;
        this.f15826c = list2;
        this.f15827d = list3;
        this.f15828e = list4;
        this.f15829f = list5;
    }

    @Override // h4.a
    public final Map getFieldMappings() {
        return f15823l;
    }

    @Override // h4.a
    public final Object getFieldValue(h4.a.C0159a c0159a) {
        switch (c0159a.Y()) {
            case 1:
                return Integer.valueOf(this.f15824a);
            case 2:
                return this.f15825b;
            case 3:
                return this.f15826c;
            case 4:
                return this.f15827d;
            case 5:
                return this.f15828e;
            case 6:
                return this.f15829f;
            default:
                throw new IllegalStateException("Unknown SafeParcelable id=" + c0159a.Y());
        }
    }

    @Override // h4.a
    public final boolean isFieldSet(h4.a.C0159a c0159a) {
        return true;
    }

    @Override // h4.a
    public final void setStringsInternal(h4.a.C0159a c0159a, String str, ArrayList arrayList) {
        int iY = c0159a.Y();
        if (iY == 2) {
            this.f15825b = arrayList;
            return;
        }
        if (iY == 3) {
            this.f15826c = arrayList;
            return;
        }
        if (iY == 4) {
            this.f15827d = arrayList;
        } else if (iY == 5) {
            this.f15828e = arrayList;
        } else {
            if (iY != 6) {
                throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string list.", Integer.valueOf(iY)));
            }
            this.f15829f = arrayList;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.t(parcel, 1, this.f15824a);
        d4.c.G(parcel, 2, this.f15825b, false);
        d4.c.G(parcel, 3, this.f15826c, false);
        d4.c.G(parcel, 4, this.f15827d, false);
        d4.c.G(parcel, 5, this.f15828e, false);
        d4.c.G(parcel, 6, this.f15829f, false);
        d4.c.b(parcel, iA);
    }
}
