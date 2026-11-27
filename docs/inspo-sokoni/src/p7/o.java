package p7;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzzs;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class o extends o7.k0 {
    public static final Parcelable.Creator<o> CREATOR = new q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<o7.r0> f14290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f14291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o7.x1 f14293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f14294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<o7.x0> f14295f;

    public o(List<o7.r0> list, p pVar, String str, o7.x1 x1Var, i iVar, List<o7.x0> list2) {
        this.f14290a = (List) com.google.android.gms.common.internal.r.l(list);
        this.f14291b = (p) com.google.android.gms.common.internal.r.l(pVar);
        this.f14292c = com.google.android.gms.common.internal.r.f(str);
        this.f14293d = x1Var;
        this.f14294e = iVar;
        this.f14295f = (List) com.google.android.gms.common.internal.r.l(list2);
    }

    public static o X(zzzs zzzsVar, FirebaseAuth firebaseAuth, o7.a0 a0Var) {
        List<o7.j0> listZzc = zzzsVar.zzc();
        ArrayList arrayList = new ArrayList();
        for (o7.j0 j0Var : listZzc) {
            if (j0Var instanceof o7.r0) {
                arrayList.add((o7.r0) j0Var);
            }
        }
        List<o7.j0> listZzc2 = zzzsVar.zzc();
        ArrayList arrayList2 = new ArrayList();
        for (o7.j0 j0Var2 : listZzc2) {
            if (j0Var2 instanceof o7.x0) {
                arrayList2.add((o7.x0) j0Var2);
            }
        }
        return new o(arrayList, p.U(zzzsVar.zzc(), zzzsVar.zzb()), firebaseAuth.l().q(), zzzsVar.zza(), (i) a0Var, arrayList2);
    }

    @Override // o7.k0
    public final FirebaseAuth S() {
        return FirebaseAuth.getInstance(h7.f.p(this.f14292c));
    }

    @Override // o7.k0
    public final List<o7.j0> T() {
        ArrayList arrayList = new ArrayList();
        Iterator<o7.r0> it = this.f14290a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        Iterator<o7.x0> it2 = this.f14295f.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        return arrayList;
    }

    @Override // o7.k0
    public final o7.l0 U() {
        return this.f14291b;
    }

    @Override // o7.k0
    public final Task<o7.i> V(o7.i0 i0Var) {
        return S().Z(i0Var, this.f14291b, this.f14294e).continueWithTask(new n(this));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = d4.c.a(parcel);
        d4.c.I(parcel, 1, this.f14290a, false);
        d4.c.C(parcel, 2, U(), i10, false);
        d4.c.E(parcel, 3, this.f14292c, false);
        d4.c.C(parcel, 4, this.f14293d, i10, false);
        d4.c.C(parcel, 5, this.f14294e, i10, false);
        d4.c.I(parcel, 6, this.f14295f, false);
        d4.c.b(parcel, iA);
    }
}
