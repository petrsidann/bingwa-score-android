package f2;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f8089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f8090b;

    public static k b(ViewGroup viewGroup) {
        return (k) viewGroup.getTag(i.f8086b);
    }

    public static void c(ViewGroup viewGroup, k kVar) {
        viewGroup.setTag(i.f8086b, kVar);
    }

    public void a() {
        Runnable runnable;
        if (b(this.f8089a) != this || (runnable = this.f8090b) == null) {
            return;
        }
        runnable.run();
    }
}
