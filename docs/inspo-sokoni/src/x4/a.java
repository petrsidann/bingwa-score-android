package x4;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.p0;
import com.google.android.gms.common.internal.r;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.google.android.gms.common.internal.g<g> implements w4.f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f17976e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f17977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.common.internal.d f17978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f17979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f17980d;

    public a(Context context, Looper looper, boolean z10, com.google.android.gms.common.internal.d dVar, Bundle bundle, com.google.android.gms.common.api.f.a aVar, com.google.android.gms.common.api.f.b bVar) {
        super(context, looper, 44, dVar, aVar, bVar);
        this.f17977a = true;
        this.f17978b = dVar;
        this.f17979c = bundle;
        this.f17980d = dVar.i();
    }

    public static Bundle c(com.google.android.gms.common.internal.d dVar) {
        dVar.h();
        Integer numI = dVar.i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", dVar.a());
        if (numI != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", numI.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w4.f
    public final void a(f fVar) {
        r.m(fVar, "Expecting a valid ISignInCallbacks");
        try {
            Account accountC = this.f17978b.c();
            ((g) getService()).b(new j(1, new p0(accountC, ((Integer) r.l(this.f17980d)).intValue(), com.google.android.gms.common.internal.c.DEFAULT_ACCOUNT.equals(accountC.name) ? z3.c.b(getContext()).c() : null)), fVar);
        } catch (RemoteException e10) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                fVar.i1(new l(1, new c4.b(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e10);
            }
        }
    }

    @Override // w4.f
    public final void b() {
        connect(new com.google.android.gms.common.internal.c.d());
    }

    @Override // com.google.android.gms.common.internal.c
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof g ? (g) iInterfaceQueryLocalInterface : new g(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c
    public final Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.f17978b.f())) {
            this.f17979c.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f17978b.f());
        }
        return this.f17979c;
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.c
    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.c
    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final boolean requiresSignIn() {
        return this.f17977a;
    }
}
