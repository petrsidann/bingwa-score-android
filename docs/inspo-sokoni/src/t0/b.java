package t0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    public static class a {
        public static Drawable a(CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkDrawable();
        }
    }

    /* JADX INFO: renamed from: t0.b$b, reason: collision with other inner class name */
    public static class C0286b {
        public static void a(CheckedTextView checkedTextView, ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        public static void b(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    public static Drawable a(CheckedTextView checkedTextView) {
        return a.a(checkedTextView);
    }

    public static void b(CheckedTextView checkedTextView, ColorStateList colorStateList) {
        C0286b.a(checkedTextView, colorStateList);
    }

    public static void c(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
        C0286b.b(checkedTextView, mode);
    }
}
