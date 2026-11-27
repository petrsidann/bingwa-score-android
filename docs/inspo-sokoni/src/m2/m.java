package m2;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.inputmethodservice.InputMethodService;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.WindowManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import mc.o;
import p0.k2;

/* JADX INFO: loaded from: classes.dex */
public final class m implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f12951b = new m();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ArrayList<Integer> f12953d;

    static {
        String simpleName = m.class.getSimpleName();
        kotlin.jvm.internal.k.d(simpleName, "WindowMetricsCalculatorC…at::class.java.simpleName");
        f12952c = simpleName;
        f12953d = o.e(Integer.valueOf(k2.m.g()), Integer.valueOf(k2.m.f()), Integer.valueOf(k2.m.a()), Integer.valueOf(k2.m.c()), Integer.valueOf(k2.m.i()), Integer.valueOf(k2.m.e()), Integer.valueOf(k2.m.j()), Integer.valueOf(k2.m.b()));
    }

    @Override // m2.l
    public k a(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        return e(activity);
    }

    public k c(Activity activity) throws Exception {
        Rect rectG;
        k2 k2VarA;
        kotlin.jvm.internal.k.e(activity, "activity");
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            rectG = q2.g.f14627a.a(activity);
        } else if (i10 >= 29) {
            rectG = h(activity);
        } else {
            rectG = i10 >= 28 ? g(activity) : f(activity);
        }
        if (i10 >= 30) {
            k2VarA = i(activity);
        } else {
            k2VarA = new k2.b().a();
            kotlin.jvm.internal.k.d(k2VarA, "{\n            WindowInse…ilder().build()\n        }");
        }
        return new k(new j2.b(rectG), k2VarA);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k d(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        if (Build.VERSION.SDK_INT >= 30) {
            return q2.g.f14627a.c(context);
        }
        Context contextA = q2.b.f14626a.a(context);
        if (contextA instanceof Activity) {
            return c((Activity) context);
        }
        if (!(contextA instanceof InputMethodService)) {
            throw new IllegalArgumentException(context + " is not a UiContext");
        }
        Object systemService = context.getSystemService("window");
        kotlin.jvm.internal.k.c(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        kotlin.jvm.internal.k.d(defaultDisplay, "wm.defaultDisplay");
        Point pointL = l(defaultDisplay);
        return new k(new Rect(0, 0, pointL.x, pointL.y), null, 2, 0 == true ? 1 : 0);
    }

    public k e(Context context) throws Exception {
        Rect rect;
        k2 k2VarA;
        kotlin.jvm.internal.k.e(context, "context");
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            rect = q2.g.f14627a.d(context);
        } else {
            Object systemService = context.getSystemService("window");
            kotlin.jvm.internal.k.c(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            Display display = ((WindowManager) systemService).getDefaultDisplay();
            kotlin.jvm.internal.k.d(display, "display");
            Point pointL = l(display);
            rect = new Rect(0, 0, pointL.x, pointL.y);
        }
        if (i10 >= 30) {
            k2VarA = i(context);
        } else {
            k2VarA = new k2.b().a();
            kotlin.jvm.internal.k.d(k2VarA, "{\n            WindowInse…ilder().build()\n        }");
        }
        return new k(new j2.b(rect), k2VarA);
    }

    public final Rect f(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        Rect rect = new Rect();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!q2.a.f14625a.a(activity)) {
            kotlin.jvm.internal.k.d(defaultDisplay, "defaultDisplay");
            Point pointL = l(defaultDisplay);
            int iK = k(activity);
            int i10 = rect.bottom;
            if (i10 + iK == pointL.y) {
                rect.bottom = i10 + iK;
            } else {
                int i11 = rect.right;
                if (i11 + iK == pointL.x) {
                    rect.right = i11 + iK;
                }
            }
        }
        return rect;
    }

    public final Rect g(Activity activity) {
        DisplayCutout displayCutoutJ;
        Rect rect;
        kotlin.jvm.internal.k.e(activity, "activity");
        Rect rect2 = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (q2.a.f14625a.a(activity)) {
                Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
                kotlin.jvm.internal.k.c(objInvoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect = (Rect) objInvoke;
            } else {
                Object objInvoke2 = obj.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(obj, new Object[0]);
                kotlin.jvm.internal.k.c(objInvoke2, "null cannot be cast to non-null type android.graphics.Rect");
                rect = (Rect) objInvoke2;
            }
            rect2.set(rect);
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e10) {
            Log.w(f12952c, e10);
            m(activity, rect2);
        }
        Display currentDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        q2.h hVar = q2.h.f14628a;
        kotlin.jvm.internal.k.d(currentDisplay, "currentDisplay");
        hVar.a(currentDisplay, point);
        q2.a aVar = q2.a.f14625a;
        if (!aVar.a(activity)) {
            int iK = k(activity);
            int i10 = rect2.bottom;
            if (i10 + iK == point.y) {
                rect2.bottom = i10 + iK;
            } else {
                int i11 = rect2.right;
                if (i11 + iK == point.x) {
                    rect2.right = i11 + iK;
                } else if (rect2.left == iK) {
                    rect2.left = 0;
                }
            }
        }
        if ((rect2.width() < point.x || rect2.height() < point.y) && !aVar.a(activity) && (displayCutoutJ = j(currentDisplay)) != null) {
            int i12 = rect2.left;
            q2.i iVar = q2.i.f14629a;
            if (i12 == iVar.b(displayCutoutJ)) {
                rect2.left = 0;
            }
            if (point.x - rect2.right == iVar.c(displayCutoutJ)) {
                rect2.right += iVar.c(displayCutoutJ);
            }
            if (rect2.top == iVar.d(displayCutoutJ)) {
                rect2.top = 0;
            }
            if (point.y - rect2.bottom == iVar.a(displayCutoutJ)) {
                rect2.bottom += iVar.a(displayCutoutJ);
            }
        }
        return rect2;
    }

    public final Rect h(Activity activity) {
        kotlin.jvm.internal.k.e(activity, "activity");
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
            kotlin.jvm.internal.k.c(objInvoke, "null cannot be cast to non-null type android.graphics.Rect");
            return new Rect((Rect) objInvoke);
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e10) {
            Log.w(f12952c, e10);
            return g(activity);
        }
    }

    public final k2 i(Context context) throws Exception {
        kotlin.jvm.internal.k.e(context, "context");
        if (Build.VERSION.SDK_INT >= 30) {
            return q2.g.f14627a.b(context);
        }
        throw new Exception("Incompatible SDK version");
    }

    public final DisplayCutout j(Display display) {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(new Class[0]);
            constructor.setAccessible(true);
            Object objNewInstance = constructor.newInstance(new Object[0]);
            Method declaredMethod = display.getClass().getDeclaredMethod("getDisplayInfo", objNewInstance.getClass());
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(display, objNewInstance);
            Field declaredField = objNewInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objNewInstance);
            if (obj instanceof DisplayCutout) {
                return (DisplayCutout) obj;
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e10) {
            Log.w(f12952c, e10);
        }
        return null;
    }

    public final int k(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final Point l(Display display) {
        kotlin.jvm.internal.k.e(display, "display");
        Point point = new Point();
        q2.h.f14628a.a(display, point);
        return point;
    }

    public final void m(Activity activity, Rect rect) {
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
    }
}
