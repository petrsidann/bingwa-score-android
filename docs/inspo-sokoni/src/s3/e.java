package s3;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.Collections;
import java.util.List;
import z3.i;

/* JADX INFO: loaded from: classes.dex */
public final class e extends com.google.android.gms.common.api.a.AbstractC0072a {
    @Override // com.google.android.gms.common.api.a.AbstractC0072a
    public final /* synthetic */ com.google.android.gms.common.api.a.f buildClient(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, Object obj, com.google.android.gms.common.api.f.a aVar, com.google.android.gms.common.api.f.b bVar) {
        return new i(context, looper, dVar, (GoogleSignInOptions) obj, aVar, bVar);
    }

    @Override // com.google.android.gms.common.api.a.e
    public final /* bridge */ /* synthetic */ List getImpliedScopes(Object obj) {
        GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
        return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.U();
    }
}
