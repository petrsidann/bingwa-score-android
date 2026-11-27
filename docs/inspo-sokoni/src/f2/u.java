package f2;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: loaded from: classes.dex */
public class u implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroupOverlay f8160a;

    public u(ViewGroup viewGroup) {
        this.f8160a = viewGroup.getOverlay();
    }

    @Override // f2.z
    public void a(Drawable drawable) {
        this.f8160a.add(drawable);
    }

    @Override // f2.z
    public void b(Drawable drawable) {
        this.f8160a.remove(drawable);
    }

    @Override // f2.v
    public void c(View view) {
        this.f8160a.add(view);
    }

    @Override // f2.v
    public void d(View view) {
        this.f8160a.remove(view);
    }
}
