package f2;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f8121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f8122b;

    public void a(View view) {
        throw null;
    }

    public float b(View view) {
        throw null;
    }

    public void c(View view) {
        throw null;
    }

    public void d(View view, int i10, int i11, int i12, int i13) {
        throw null;
    }

    public void e(View view, float f10) {
        throw null;
    }

    public void f(View view, int i10) {
        if (!f8122b) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f8121a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f8122b = true;
        }
        Field field = f8121a;
        if (field != null) {
            try {
                f8121a.setInt(view, i10 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void g(View view, Matrix matrix) {
        throw null;
    }

    public void h(View view, Matrix matrix) {
        throw null;
    }
}
