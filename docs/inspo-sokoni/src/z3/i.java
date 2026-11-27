package z3;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.p000authapi.zbbj;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class i extends com.google.android.gms.common.internal.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GoogleSignInOptions f19787a;

    public i(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, GoogleSignInOptions googleSignInOptions, com.google.android.gms.common.api.f.a aVar, com.google.android.gms.common.api.f.b bVar) {
        super(context, looper, 91, dVar, aVar, bVar);
        GoogleSignInOptions.a aVar2 = googleSignInOptions != null ? new GoogleSignInOptions.a(googleSignInOptions) : new GoogleSignInOptions.a();
        aVar2.e(zbbj.zba());
        if (!dVar.d().isEmpty()) {
            Iterator<Scope> it = dVar.d().iterator();
            while (it.hasNext()) {
                aVar2.d(it.next(), new Scope[0]);
            }
        }
        this.f19787a = aVar2.a();
    }

    public final GoogleSignInOptions c() {
        return this.f19787a;
    }

    @Override // com.google.android.gms.common.internal.c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof u ? (u) iInterfaceQueryLocalInterface : new u(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.c
    public final Intent getSignInIntent() {
        return o.a(getContext(), this.f19787a);
    }

    @Override // com.google.android.gms.common.internal.c
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.c
    public final boolean providesSignIn() {
        return true;
    }
}
