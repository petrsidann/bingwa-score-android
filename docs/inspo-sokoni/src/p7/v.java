package p7;

import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: loaded from: classes.dex */
public final class v implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f14325a;

    public v(w wVar) {
        this.f14325a = wVar;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        if (exc instanceof h7.m) {
            t.f14311h.g("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.f14325a.f14334b.d();
        }
    }
}
