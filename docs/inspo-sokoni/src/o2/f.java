package o2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import androidx.window.extensions.layout.FoldingFeature;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.ArrayList;
import java.util.List;
import m2.j;
import m2.k;
import m2.m;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f13642a = new f();

    public final m2.c a(k windowMetrics, FoldingFeature oemFeature) {
        m2.d.b bVarA;
        m2.c.b bVar;
        kotlin.jvm.internal.k.e(windowMetrics, "windowMetrics");
        kotlin.jvm.internal.k.e(oemFeature, "oemFeature");
        int type = oemFeature.getType();
        if (type == 1) {
            bVarA = m2.d.b.f12917b.a();
        } else {
            if (type != 2) {
                return null;
            }
            bVarA = m2.d.b.f12917b.b();
        }
        int state = oemFeature.getState();
        if (state == 1) {
            bVar = m2.c.b.f12910c;
        } else {
            if (state != 2) {
                return null;
            }
            bVar = m2.c.b.f12911d;
        }
        Rect bounds = oemFeature.getBounds();
        kotlin.jvm.internal.k.d(bounds, "oemFeature.bounds");
        if (!d(windowMetrics, new j2.b(bounds))) {
            return null;
        }
        Rect bounds2 = oemFeature.getBounds();
        kotlin.jvm.internal.k.d(bounds2, "oemFeature.bounds");
        return new m2.d(new j2.b(bounds2), bVarA, bVar);
    }

    public final j b(Context context, WindowLayoutInfo info) throws Exception {
        k kVarC;
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(info, "info");
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            kVarC = m.f12951b.d(context);
        } else {
            if (i10 < 29 || !(context instanceof Activity)) {
                throw new UnsupportedOperationException("Display Features are only supported after Q. Display features for non-Activity contexts are not expected to be reported on devices running Q.");
            }
            kVarC = m.f12951b.c((Activity) context);
        }
        return c(kVarC, info);
    }

    public final j c(k windowMetrics, WindowLayoutInfo info) {
        m2.c cVarA;
        kotlin.jvm.internal.k.e(windowMetrics, "windowMetrics");
        kotlin.jvm.internal.k.e(info, "info");
        List<FoldingFeature> displayFeatures = info.getDisplayFeatures();
        kotlin.jvm.internal.k.d(displayFeatures, "info.displayFeatures");
        ArrayList arrayList = new ArrayList();
        for (FoldingFeature feature : displayFeatures) {
            if (feature instanceof FoldingFeature) {
                f fVar = f13642a;
                kotlin.jvm.internal.k.d(feature, "feature");
                cVarA = fVar.a(windowMetrics, feature);
            } else {
                cVarA = null;
            }
            if (cVarA != null) {
                arrayList.add(cVarA);
            }
        }
        return new j(arrayList);
    }

    public final boolean d(k kVar, j2.b bVar) {
        Rect rectA = kVar.a();
        if (bVar.e()) {
            return false;
        }
        if (bVar.d() != rectA.width() && bVar.a() != rectA.height()) {
            return false;
        }
        if (bVar.d() >= rectA.width() || bVar.a() >= rectA.height()) {
            return (bVar.d() == rectA.width() && bVar.a() == rectA.height()) ? false : true;
        }
        return false;
    }
}
