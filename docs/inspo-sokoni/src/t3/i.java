package t3;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.auth.zzbz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class i extends zzbz {
    public static final Parcelable.Creator<i> CREATOR = new j();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final HashMap f15837m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f15838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f15842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PendingIntent f15843f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f15844l;

    static {
        HashMap map = new HashMap();
        f15837m = map;
        map.put("accountType", h4.a.C0159a.W("accountType", 2));
        map.put("status", h4.a.C0159a.V("status", 3));
        map.put("transferBytes", h4.a.C0159a.S("transferBytes", 4));
    }

    public i() {
        this.f15838a = new t.b(3);
        this.f15839b = 1;
    }

    public i(Set set, int i10, String str, int i11, byte[] bArr, PendingIntent pendingIntent, a aVar) {
        this.f15838a = set;
        this.f15839b = i10;
        this.f15840c = str;
        this.f15841d = i11;
        this.f15842e = bArr;
        this.f15843f = pendingIntent;
        this.f15844l = aVar;
    }

    @Override // h4.a
    public final /* synthetic */ Map getFieldMappings() {
        return f15837m;
    }

    @Override // h4.a
    public final Object getFieldValue(h4.a.C0159a c0159a) {
        int i10;
        int iY = c0159a.Y();
        if (iY == 1) {
            i10 = this.f15839b;
        } else {
            if (iY == 2) {
                return this.f15840c;
            }
            if (iY != 3) {
                if (iY == 4) {
                    return this.f15842e;
                }
                throw new IllegalStateException("Unknown SafeParcelable id=" + c0159a.Y());
            }
            i10 = this.f15841d;
        }
        return Integer.valueOf(i10);
    }

    @Override // h4.a
    public final boolean isFieldSet(h4.a.C0159a c0159a) {
        return this.f15838a.contains(Integer.valueOf(c0159a.Y()));
    }

    @Override // h4.a
    public final void setDecodedBytesInternal(h4.a.C0159a c0159a, String str, byte[] bArr) {
        int iY = c0159a.Y();
        if (iY == 4) {
            this.f15842e = bArr;
            this.f15838a.add(Integer.valueOf(iY));
        } else {
            throw new IllegalArgumentException("Field with id=" + iY + " is not known to be an byte array.");
        }
    }

    @Override // h4.a
    public final void setIntegerInternal(h4.a.C0159a c0159a, String str, int i10) {
        int iY = c0159a.Y();
        if (iY == 3) {
            this.f15841d = i10;
            this.f15838a.add(Integer.valueOf(iY));
        } else {
            throw new IllegalArgumentException("Field with id=" + iY + " is not known to be an int.");
        }
    }

    @Override // h4.a
    public final void setStringInternal(h4.a.C0159a c0159a, String str, String str2) {
        int iY = c0159a.Y();
        if (iY != 2) {
            throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", Integer.valueOf(iY)));
        }
        this.f15840c = str2;
        this.f15838a.add(Integer.valueOf(iY));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        Set set = this.f15838a;
        if (set.contains(1)) {
            d4.c.t(parcel, 1, this.f15839b);
        }
        if (set.contains(2)) {
            d4.c.E(parcel, 2, this.f15840c, true);
        }
        if (set.contains(3)) {
            d4.c.t(parcel, 3, this.f15841d);
        }
        if (set.contains(4)) {
            d4.c.k(parcel, 4, this.f15842e, true);
        }
        if (set.contains(5)) {
            d4.c.C(parcel, 5, this.f15843f, i10, true);
        }
        if (set.contains(6)) {
            d4.c.C(parcel, 6, this.f15844l, i10, true);
        }
        d4.c.b(parcel, iA);
    }
}
