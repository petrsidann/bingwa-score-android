package f2;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: loaded from: classes.dex */
public class y implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewOverlay f8162a;

    public y(View view) {
        this.f8162a = view.getOverlay();
    }

    @Override // f2.z
    public void a(Drawable drawable) {
        this.f8162a.add(drawable);
    }

    @Override // f2.z
    public void b(Drawable drawable) {
        this.f8162a.remove(drawable);
    }
}
