package u5;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<V extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeInterpolator f17021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V f17022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17025e;

    public a(V v10) {
        this.f17022b = v10;
        Context context = v10.getContext();
        this.f17021a = e.g(context, z4.b.I, r0.a.a(0.0f, 0.0f, 0.0f, 1.0f));
        this.f17023c = e.f(context, z4.b.f19826z, 300);
        this.f17024d = e.f(context, z4.b.C, 150);
        this.f17025e = e.f(context, z4.b.B, 100);
    }
}
