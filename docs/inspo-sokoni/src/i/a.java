package i;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: i.a$a, reason: collision with other inner class name */
    public static class C0165a extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9960a;

        public C0165a(int i10, int i11) {
            super(i10, i11);
            this.f9960a = 8388627;
        }

        public C0165a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f9960a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.j.f9513t);
            this.f9960a = typedArrayObtainStyledAttributes.getInt(h.j.f9518u, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0165a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f9960a = 0;
        }

        public C0165a(C0165a c0165a) {
            super((ViewGroup.MarginLayoutParams) c0165a);
            this.f9960a = 0;
            this.f9960a = c0165a.f9960a;
        }
    }

    public interface b {
        void onMenuVisibilityChanged(boolean z10);
    }

    @Deprecated
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public boolean f() {
        return false;
    }

    public abstract boolean g();

    public abstract void h(boolean z10);

    public abstract int i();

    public abstract Context j();

    public boolean k() {
        return false;
    }

    public abstract void l(Configuration configuration);

    public void m() {
    }

    public abstract boolean n(int i10, KeyEvent keyEvent);

    public boolean o(KeyEvent keyEvent) {
        return false;
    }

    public boolean p() {
        return false;
    }

    public abstract void q(boolean z10);

    public abstract void r(boolean z10);

    public abstract void s(CharSequence charSequence);

    public abstract m.b t(m.b.a aVar);
}
