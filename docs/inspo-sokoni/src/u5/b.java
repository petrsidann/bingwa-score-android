package u5;

import android.content.res.Resources;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class b extends a<View> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f17026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f17027g;

    public b(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f17026f = resources.getDimension(z4.d.f19846h);
        this.f17027g = resources.getDimension(z4.d.f19847i);
    }
}
