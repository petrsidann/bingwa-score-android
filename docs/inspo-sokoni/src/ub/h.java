package ub;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import m2.k;
import m2.l;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    public interface a {
        void a(float f10, float f11, float f12);
    }

    public interface b {
        boolean a(View view);
    }

    public static void c(Context context, a aVar) {
        Activity activityE = e(context);
        if (activityE != null) {
            k kVarA = l.b().a(activityE);
            aVar.a(kVarA.a().width(), kVarA.a().height(), context.getResources().getDisplayMetrics().density);
        }
    }

    public static boolean d(View view) {
        return i(view, new b() { // from class: ub.f
            @Override // ub.h.b
            public final boolean a(View view2) {
                return view2.hasFocus();
            }
        });
    }

    public static Activity e(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return e(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean f(View view, final Class<? extends View>[] clsArr) {
        return i(view, new b() { // from class: ub.g
            @Override // ub.h.b
            public final boolean a(View view2) {
                return h.h(clsArr, view2);
            }
        });
    }

    public static /* synthetic */ boolean h(Class[] clsArr, View view) {
        for (Class cls : clsArr) {
            if (cls.isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(View view, b bVar) {
        if (view == null) {
            return false;
        }
        if (bVar.a(view)) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                if (i(viewGroup.getChildAt(i10), bVar)) {
                    return true;
                }
            }
        }
        return false;
    }
}
