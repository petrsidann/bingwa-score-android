package p7;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h2 implements o7.i {
    public static final Parcelable.Creator<h2> CREATOR = new g2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f14239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f2 f14240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o7.x1 f14241c;

    public h2(i iVar) {
        i iVar2 = (i) com.google.android.gms.common.internal.r.l(iVar);
        this.f14239a = iVar2;
        List<e> listB0 = iVar2.B0();
        this.f14240b = null;
        for (int i10 = 0; i10 < listB0.size(); i10++) {
            if (!TextUtils.isEmpty(listB0.get(i10).zza())) {
                this.f14240b = new f2(listB0.get(i10).i(), listB0.get(i10).zza(), iVar.C0());
            }
        }
        if (this.f14240b == null) {
            this.f14240b = new f2(iVar.C0());
        }
        this.f14241c = iVar.z0();
    }

    public h2(i iVar, f2 f2Var, o7.x1 x1Var) {
        this.f14239a = iVar;
        this.f14240b = f2Var;
        this.f14241c = x1Var;
    }

    @Override // o7.i
    public final o7.g A() {
        return this.f14240b;
    }

    @Override // o7.i
    public final o7.h C() {
        return this.f14241c;
    }

    @Override // o7.i
    public final o7.a0 N() {
        return this.f14239a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.C(parcel, 1, N(), i10, false);
        d4.c.C(parcel, 2, A(), i10, false);
        d4.c.C(parcel, 3, this.f14241c, i10, false);
        d4.c.b(parcel, iA);
    }
}
