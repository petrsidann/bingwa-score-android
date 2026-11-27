package f2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends l {
    public static final String[] R = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final Property<Drawable, PointF> S = new b(PointF.class, "boundsOrigin");
    public static final Property<k, PointF> T = new C0135c(PointF.class, "topLeft");
    public static final Property<k, PointF> U = new d(PointF.class, "bottomRight");
    public static final Property<View, PointF> V = new e(PointF.class, "bottomRight");
    public static final Property<View, PointF> W = new f(PointF.class, "topLeft");
    public static final Property<View, PointF> X = new g(PointF.class, "position");
    public static f2.j Y = new f2.j();
    public int[] O = new int[2];
    public boolean P = false;
    public boolean Q = false;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f8038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f8039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f8040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f8041d;

        public a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f10) {
            this.f8038a = viewGroup;
            this.f8039b = bitmapDrawable;
            this.f8040c = view;
            this.f8041d = f10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a0.b(this.f8038a).b(this.f8039b);
            a0.g(this.f8040c, this.f8041d);
        }
    }

    public static class b extends Property<Drawable, PointF> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f8043a;

        public b(Class cls, String str) {
            super(cls, str);
            this.f8043a = new Rect();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f8043a);
            Rect rect = this.f8043a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f8043a);
            this.f8043a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f8043a);
        }
    }

    /* JADX INFO: renamed from: f2.c$c, reason: collision with other inner class name */
    public static class C0135c extends Property<k, PointF> {
        public C0135c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    public static class d extends Property<k, PointF> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    public static class e extends Property<View, PointF> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            a0.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    public static class f extends Property<View, PointF> {
        public f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            a0.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    public static class g extends Property<View, PointF> {
        public g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            a0.f(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f8044a;
        private k mViewBounds;

        public h(k kVar) {
            this.f8044a = kVar;
            this.mViewBounds = kVar;
        }
    }

    public class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f8047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Rect f8048c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f8049d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f8050e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f8051f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f8052g;

        public i(View view, Rect rect, int i10, int i11, int i12, int i13) {
            this.f8047b = view;
            this.f8048c = rect;
            this.f8049d = i10;
            this.f8050e = i11;
            this.f8051f = i12;
            this.f8052g = i13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f8046a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f8046a) {
                return;
            }
            p0.p0.w0(this.f8047b, this.f8048c);
            a0.f(this.f8047b, this.f8049d, this.f8050e, this.f8051f, this.f8052g);
        }
    }

    public class j extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8054a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f8055b;

        public j(ViewGroup viewGroup) {
            this.f8055b = viewGroup;
        }

        @Override // f2.m, f2.l.f
        public void b(l lVar) {
            x.c(this.f8055b, false);
        }

        @Override // f2.l.f
        public void c(l lVar) {
            if (!this.f8054a) {
                x.c(this.f8055b, false);
            }
            lVar.U(this);
        }

        @Override // f2.m, f2.l.f
        public void d(l lVar) {
            x.c(this.f8055b, false);
            this.f8054a = true;
        }

        @Override // f2.m, f2.l.f
        public void e(l lVar) {
            x.c(this.f8055b, true);
        }
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8058b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8059c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8060d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f8061e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8062f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8063g;

        public k(View view) {
            this.f8061e = view;
        }

        public void a(PointF pointF) {
            this.f8059c = Math.round(pointF.x);
            this.f8060d = Math.round(pointF.y);
            int i10 = this.f8063g + 1;
            this.f8063g = i10;
            if (this.f8062f == i10) {
                b();
            }
        }

        public final void b() {
            a0.f(this.f8061e, this.f8057a, this.f8058b, this.f8059c, this.f8060d);
            this.f8062f = 0;
            this.f8063g = 0;
        }

        public void c(PointF pointF) {
            this.f8057a = Math.round(pointF.x);
            this.f8058b = Math.round(pointF.y);
            int i10 = this.f8062f + 1;
            this.f8062f = i10;
            if (i10 == this.f8063g) {
                b();
            }
        }
    }

    @Override // f2.l
    public String[] H() {
        return R;
    }

    @Override // f2.l
    public void h(s sVar) {
        h0(sVar);
    }

    public final void h0(s sVar) {
        View view = sVar.f8154b;
        if (!p0.p0.T(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        sVar.f8153a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        sVar.f8153a.put("android:changeBounds:parent", sVar.f8154b.getParent());
        if (this.Q) {
            sVar.f8154b.getLocationInWindow(this.O);
            sVar.f8153a.put("android:changeBounds:windowX", Integer.valueOf(this.O[0]));
            sVar.f8153a.put("android:changeBounds:windowY", Integer.valueOf(this.O[1]));
        }
        if (this.P) {
            sVar.f8153a.put("android:changeBounds:clip", p0.p0.u(view));
        }
    }

    public final boolean i0(View view, View view2) {
        if (!this.Q) {
            return true;
        }
        s sVarV = v(view, true);
        if (sVarV == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == sVarV.f8154b) {
            return true;
        }
        return false;
    }

    @Override // f2.l
    public void l(s sVar) {
        h0(sVar);
    }

    @Override // f2.l
    public Animator p(ViewGroup viewGroup, s sVar, s sVar2) {
        int i10;
        View view;
        int i11;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator animatorC;
        Path pathA;
        Property<View, PointF> property;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map<String, Object> map = sVar.f8153a;
        Map<String, Object> map2 = sVar2.f8153a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar2.f8154b;
        if (!i0(viewGroup2, viewGroup3)) {
            int iIntValue = ((Integer) sVar.f8153a.get("android:changeBounds:windowX")).intValue();
            int iIntValue2 = ((Integer) sVar.f8153a.get("android:changeBounds:windowY")).intValue();
            int iIntValue3 = ((Integer) sVar2.f8153a.get("android:changeBounds:windowX")).intValue();
            int iIntValue4 = ((Integer) sVar2.f8153a.get("android:changeBounds:windowY")).intValue();
            if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.O);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(bitmapCreateBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            float fC = a0.c(view2);
            a0.g(view2, 0.0f);
            a0.b(viewGroup).a(bitmapDrawable);
            f2.g gVarX = x();
            int[] iArr = this.O;
            int i12 = iArr[0];
            int i13 = iArr[1];
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, f2.h.a(S, gVarX.a(iIntValue - i12, iIntValue2 - i13, iIntValue3 - i12, iIntValue4 - i13)));
            objectAnimatorOfPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, fC));
            return objectAnimatorOfPropertyValuesHolder;
        }
        Rect rect2 = (Rect) sVar.f8153a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) sVar2.f8153a.get("android:changeBounds:bounds");
        int i14 = rect2.left;
        int i15 = rect3.left;
        int i16 = rect2.top;
        int i17 = rect3.top;
        int i18 = rect2.right;
        int i19 = rect3.right;
        int i20 = rect2.bottom;
        int i21 = rect3.bottom;
        int i22 = i18 - i14;
        int i23 = i20 - i16;
        int i24 = i19 - i15;
        int i25 = i21 - i17;
        Rect rect4 = (Rect) sVar.f8153a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) sVar2.f8153a.get("android:changeBounds:clip");
        if ((i22 == 0 || i23 == 0) && (i24 == 0 || i25 == 0)) {
            i10 = 0;
        } else {
            i10 = (i14 == i15 && i16 == i17) ? 0 : 1;
            if (i18 != i19 || i20 != i21) {
                i10++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i10++;
        }
        if (i10 <= 0) {
            return null;
        }
        if (this.P) {
            view = view2;
            a0.f(view, i14, i16, Math.max(i22, i24) + i14, Math.max(i23, i25) + i16);
            ObjectAnimator objectAnimatorA = (i14 == i15 && i16 == i17) ? null : f2.f.a(view, X, x().a(i14, i16, i15, i17));
            if (rect4 == null) {
                i11 = 0;
                rect = new Rect(0, 0, i22, i23);
            } else {
                i11 = 0;
                rect = rect4;
            }
            Rect rect6 = rect5 == null ? new Rect(i11, i11, i24, i25) : rect5;
            if (rect.equals(rect6)) {
                objectAnimator = null;
            } else {
                p0.p0.w0(view, rect);
                f2.j jVar = Y;
                Object[] objArr = new Object[2];
                objArr[i11] = rect;
                objArr[1] = rect6;
                ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", jVar, objArr);
                objectAnimatorOfObject.addListener(new i(view, rect5, i15, i17, i19, i21));
                objectAnimator = objectAnimatorOfObject;
            }
            animatorC = r.c(objectAnimatorA, objectAnimator);
        } else {
            view = view2;
            a0.f(view, i14, i16, i18, i20);
            if (i10 == 2) {
                if (i22 == i24 && i23 == i25) {
                    pathA = x().a(i14, i16, i15, i17);
                    property = X;
                } else {
                    k kVar = new k(view);
                    ObjectAnimator objectAnimatorA2 = f2.f.a(kVar, T, x().a(i14, i16, i15, i17));
                    ObjectAnimator objectAnimatorA3 = f2.f.a(kVar, U, x().a(i18, i20, i19, i21));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                    animatorSet.addListener(new h(kVar));
                    animatorC = animatorSet;
                }
            } else if (i14 == i15 && i16 == i17) {
                pathA = x().a(i18, i20, i19, i21);
                property = V;
            } else {
                pathA = x().a(i14, i16, i15, i17);
                property = W;
            }
            animatorC = f2.f.a(view, property, pathA);
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            x.c(viewGroup4, true);
            a(new j(viewGroup4));
        }
        return animatorC;
    }
}
