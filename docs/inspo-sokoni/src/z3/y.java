package z3;

import android.os.Bundle;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;

/* JADX INFO: loaded from: classes.dex */
public final class y implements o1.a.InterfaceC0233a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SignInHubActivity f19796a;

    public /* synthetic */ y(SignInHubActivity signInHubActivity, x xVar) {
        this.f19796a = signInHubActivity;
    }

    @Override // o1.a.InterfaceC0233a
    public final void a(p1.b bVar) {
    }

    @Override // o1.a.InterfaceC0233a
    public final p1.b b(int i10, Bundle bundle) {
        return new g(this.f19796a, com.google.android.gms.common.api.f.c());
    }

    @Override // o1.a.InterfaceC0233a
    public final /* bridge */ /* synthetic */ void c(p1.b bVar, Object obj) {
        SignInHubActivity signInHubActivity = this.f19796a;
        signInHubActivity.setResult(signInHubActivity.H, signInHubActivity.I);
        this.f19796a.finish();
    }
}
