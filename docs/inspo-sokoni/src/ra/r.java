package ra;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.Window;
import android.view.WindowInsets;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class r {
    public List<Rect> a(Context context) {
        WindowInsets windowInsetsB = b(context);
        return windowInsetsB == null ? Collections.emptyList() : windowInsetsB.getBoundingRects(WindowInsets.Type.captionBar());
    }

    public WindowInsets b(Context context) {
        Window window;
        Activity activityE = ub.h.e(context);
        if (activityE == null || (window = activityE.getWindow()) == null) {
            return null;
        }
        return window.getDecorView().getRootWindowInsets();
    }

    public void c(Context context, FlutterRenderer.h hVar) {
        List<Rect> listA = a(context);
        int iMax = hVar.f10774d;
        Iterator<Rect> it = listA.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().bottom);
        }
        hVar.f10774d = iMax;
    }
}
