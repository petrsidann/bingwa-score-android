package s3;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.internal.p000authapi.zbo;

/* JADX INFO: loaded from: classes.dex */
public final class d extends com.google.android.gms.common.api.a.AbstractC0072a {
    @Override // com.google.android.gms.common.api.a.AbstractC0072a
    public final /* synthetic */ com.google.android.gms.common.api.a.f buildClient(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, Object obj, com.google.android.gms.common.api.f.a aVar, com.google.android.gms.common.api.f.b bVar) {
        return new zbo(context, looper, dVar, (a.C0271a) obj, aVar, bVar);
    }
}
