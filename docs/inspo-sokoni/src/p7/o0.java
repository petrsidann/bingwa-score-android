package p7;

import android.text.TextUtils;
import com.google.android.gms.internal.p002firebaseauthapi.zzagz;
import com.google.android.gms.internal.p002firebaseauthapi.zzaia;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class o0 {
    public static List<o7.j0> a(List<zzagz> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<zzagz> it = list.iterator();
        while (it.hasNext()) {
            o7.j0 j0VarB = b(it.next());
            if (j0VarB != null) {
                arrayList.add(j0VarB);
            }
        }
        return arrayList;
    }

    public static o7.j0 b(zzagz zzagzVar) {
        if (zzagzVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(zzagzVar.zze())) {
            return new o7.r0(zzagzVar.zzd(), zzagzVar.zzc(), zzagzVar.zza(), com.google.android.gms.common.internal.r.f(zzagzVar.zze()));
        }
        if (zzagzVar.zzb() != null) {
            return new o7.x0(zzagzVar.zzd(), zzagzVar.zzc(), zzagzVar.zza(), (zzaia) com.google.android.gms.common.internal.r.m(zzagzVar.zzb(), "totpInfo cannot be null."));
        }
        return null;
    }
}
