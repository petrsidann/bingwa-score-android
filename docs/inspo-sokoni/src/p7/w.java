package p7;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f14334b;

    public w(t tVar, String str) {
        this.f14334b = tVar;
        this.f14333a = com.google.android.gms.common.internal.r.f(str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(h7.f.p(this.f14333a));
        if (firebaseAuth.m() != null) {
            Task<o7.c0> taskC = firebaseAuth.c(true);
            t.f14311h.g("Token refreshing started", new Object[0]);
            taskC.addOnFailureListener(new v(this));
        }
    }
}
