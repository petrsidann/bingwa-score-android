package ta;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class g implements c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f15908a = ub.a.a(Looper.getMainLooper());

    @Override // ta.c.d
    public void a(Runnable runnable) {
        this.f15908a.post(runnable);
    }
}
