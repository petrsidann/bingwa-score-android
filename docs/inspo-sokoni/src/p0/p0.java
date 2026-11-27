package p0;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class p0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f14035c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f14033a = new AtomicInteger(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakHashMap<View, v1> f14034b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f14036d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f14037e = {d0.e.f6205b, d0.e.f6206c, d0.e.f6217n, d0.e.f6228y, d0.e.B, d0.e.C, d0.e.D, d0.e.E, d0.e.F, d0.e.G, d0.e.f6207d, d0.e.f6208e, d0.e.f6209f, d0.e.f6210g, d0.e.f6211h, d0.e.f6212i, d0.e.f6213j, d0.e.f6214k, d0.e.f6215l, d0.e.f6216m, d0.e.f6218o, d0.e.f6219p, d0.e.f6220q, d0.e.f6221r, d0.e.f6222s, d0.e.f6223t, d0.e.f6224u, d0.e.f6225v, d0.e.f6226w, d0.e.f6227x, d0.e.f6229z, d0.e.A};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h0 f14038f = new h0() { // from class: p0.o0
        @Override // p0.h0
        public final c a(c cVar) {
            return p0.X(cVar);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f14039g = new e();

    public class a extends f<Boolean> {
        public a(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        @Override // p0.p0.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(View view) {
            return Boolean.valueOf(p.d(view));
        }

        @Override // p0.p0.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, Boolean bool) {
            p.j(view, bool.booleanValue());
        }

        @Override // p0.p0.f
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    public class b extends f<CharSequence> {
        public b(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        @Override // p0.p0.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return p.b(view);
        }

        @Override // p0.p0.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence charSequence) {
            p.h(view, charSequence);
        }

        @Override // p0.p0.f
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    public class c extends f<CharSequence> {
        public c(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        @Override // p0.p0.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public CharSequence d(View view) {
            return r.b(view);
        }

        @Override // p0.p0.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, CharSequence charSequence) {
            r.f(view, charSequence);
        }

        @Override // p0.p0.f
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    public class d extends f<Boolean> {
        public d(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        @Override // p0.p0.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Boolean d(View view) {
            return Boolean.valueOf(p.c(view));
        }

        @Override // p0.p0.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void e(View view, Boolean bool) {
            p.g(view, bool.booleanValue());
        }

        @Override // p0.p0.f
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    public static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakHashMap<View, Boolean> f14040a = new WeakHashMap<>();

        public void a(View view) {
            this.f14040a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (k.b(view)) {
                c(view);
            }
        }

        public final void b(View view, boolean z10) {
            boolean z11 = view.isShown() && view.getWindowVisibility() == 0;
            if (z10 != z11) {
                p0.Y(view, z11 ? 16 : 32);
                this.f14040a.put(view, Boolean.valueOf(z11));
            }
        }

        public final void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void d(View view) {
            this.f14040a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        public final void e(View view) {
            h.o(view.getViewTreeObserver(), this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f14040a.entrySet()) {
                    b(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static abstract class f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<T> f14042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f14043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f14044d;

        public f(int i10, Class<T> cls, int i11) {
            this(i10, cls, 0, i11);
        }

        public f(int i10, Class<T> cls, int i11, int i12) {
            this.f14041a = i10;
            this.f14042b = cls;
            this.f14044d = i11;
            this.f14043c = i12;
        }

        public boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        public final boolean b() {
            return true;
        }

        public final boolean c() {
            return Build.VERSION.SDK_INT >= this.f14043c;
        }

        public abstract T d(View view);

        public abstract void e(View view, T t10);

        public T f(View view) {
            if (c()) {
                return d(view);
            }
            if (!b()) {
                return null;
            }
            T t10 = (T) view.getTag(this.f14041a);
            if (this.f14042b.isInstance(t10)) {
                return t10;
            }
            return null;
        }

        public void g(View view, T t10) {
            if (c()) {
                e(view, t10);
            } else if (b() && h(f(view), t10)) {
                p0.j(view);
                view.setTag(this.f14041a, t10);
                p0.Y(view, this.f14044d);
            }
        }

        public abstract boolean h(T t10, T t11);
    }

    public static class g {
        public static boolean a(View view) {
            return view.hasOnClickListeners();
        }
    }

    public static class h {
        public static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        public static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        public static int c(View view) {
            return view.getImportantForAccessibility();
        }

        public static int d(View view) {
            return view.getMinimumHeight();
        }

        public static int e(View view) {
            return view.getMinimumWidth();
        }

        public static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        public static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        public static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        public static boolean i(View view) {
            return view.hasTransientState();
        }

        public static boolean j(View view, int i10, Bundle bundle) {
            return view.performAccessibilityAction(i10, bundle);
        }

        public static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        public static void l(View view, int i10, int i11, int i12, int i13) {
            view.postInvalidateOnAnimation(i10, i11, i12, i13);
        }

        public static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public static void n(View view, Runnable runnable, long j10) {
            view.postOnAnimationDelayed(runnable, j10);
        }

        public static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        public static void p(View view) {
            view.requestFitSystemWindows();
        }

        public static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public static void r(View view, boolean z10) {
            view.setHasTransientState(z10);
        }

        public static void s(View view, int i10) {
            view.setImportantForAccessibility(i10);
        }
    }

    public static class i {
        public static int a() {
            return View.generateViewId();
        }

        public static Display b(View view) {
            return view.getDisplay();
        }

        public static int c(View view) {
            return view.getLabelFor();
        }

        public static int d(View view) {
            return view.getLayoutDirection();
        }

        public static int e(View view) {
            return view.getPaddingEnd();
        }

        public static int f(View view) {
            return view.getPaddingStart();
        }

        public static boolean g(View view) {
            return view.isPaddingRelative();
        }

        public static void h(View view, int i10) {
            view.setLabelFor(i10);
        }

        public static void i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        public static void j(View view, int i10) {
            view.setLayoutDirection(i10);
        }

        public static void k(View view, int i10, int i11, int i12, int i13) {
            view.setPaddingRelative(i10, i11, i12, i13);
        }
    }

    public static class j {
        public static Rect a(View view) {
            return view.getClipBounds();
        }

        public static boolean b(View view) {
            return view.isInLayout();
        }

        public static void c(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    public static class k {
        public static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        public static boolean b(View view) {
            return view.isAttachedToWindow();
        }

        public static boolean c(View view) {
            return view.isLaidOut();
        }

        public static boolean d(View view) {
            return view.isLayoutDirectionResolved();
        }

        public static void e(ViewParent viewParent, View view, View view2, int i10) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i10);
        }

        public static void f(View view, int i10) {
            view.setAccessibilityLiveRegion(i10);
        }

        public static void g(AccessibilityEvent accessibilityEvent, int i10) {
            accessibilityEvent.setContentChangeTypes(i10);
        }
    }

    public static class l {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static void c(View view) {
            view.requestApplyInsets();
        }
    }

    public static class m {

        public class a implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public k2 f14045a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f14046b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ f0 f14047c;

            public a(View view, f0 f0Var) {
                this.f14046b = view;
                this.f14047c = f0Var;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                k2 k2VarV = k2.v(windowInsets, view);
                int i10 = Build.VERSION.SDK_INT;
                if (i10 < 30) {
                    m.a(windowInsets, this.f14046b);
                    if (k2VarV.equals(this.f14045a)) {
                        return this.f14047c.a(view, k2VarV).t();
                    }
                }
                this.f14045a = k2VarV;
                k2 k2VarA = this.f14047c.a(view, k2VarV);
                if (i10 >= 30) {
                    return k2VarA.t();
                }
                p0.m0(view);
                return k2VarA.t();
            }
        }

        public static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(d0.e.S);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static k2 b(View view, k2 k2Var, Rect rect) {
            WindowInsets windowInsetsT = k2Var.t();
            if (windowInsetsT != null) {
                return k2.v(view.computeSystemWindowInsets(windowInsetsT, rect), view);
            }
            rect.setEmpty();
            return k2Var;
        }

        public static boolean c(View view, float f10, float f11, boolean z10) {
            return view.dispatchNestedFling(f10, f11, z10);
        }

        public static boolean d(View view, float f10, float f11) {
            return view.dispatchNestedPreFling(f10, f11);
        }

        public static boolean e(View view, int i10, int i11, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i10, i11, iArr, iArr2);
        }

        public static boolean f(View view, int i10, int i11, int i12, int i13, int[] iArr) {
            return view.dispatchNestedScroll(i10, i11, i12, i13, iArr);
        }

        public static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        public static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        public static float i(View view) {
            return view.getElevation();
        }

        public static k2 j(View view) {
            return k2.a.a(view);
        }

        public static String k(View view) {
            return view.getTransitionName();
        }

        public static float l(View view) {
            return view.getTranslationZ();
        }

        public static float m(View view) {
            return view.getZ();
        }

        public static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        public static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        public static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void s(View view, float f10) {
            view.setElevation(f10);
        }

        public static void t(View view, boolean z10) {
            view.setNestedScrollingEnabled(z10);
        }

        public static void u(View view, f0 f0Var) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(d0.e.L, f0Var);
            }
            if (f0Var == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(d0.e.S));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, f0Var));
            }
        }

        public static void v(View view, String str) {
            view.setTransitionName(str);
        }

        public static void w(View view, float f10) {
            view.setTranslationZ(f10);
        }

        public static void x(View view, float f10) {
            view.setZ(f10);
        }

        public static boolean y(View view, int i10) {
            return view.startNestedScroll(i10);
        }

        public static void z(View view) {
            view.stopNestedScroll();
        }
    }

    public static class n {
        public static k2 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            k2 k2VarU = k2.u(rootWindowInsets);
            k2VarU.r(k2VarU);
            k2VarU.d(view.getRootView());
            return k2VarU;
        }

        public static int b(View view) {
            return view.getScrollIndicators();
        }

        public static void c(View view, int i10) {
            view.setScrollIndicators(i10);
        }

        public static void d(View view, int i10, int i11) {
            view.setScrollIndicators(i10, i11);
        }
    }

    public static class o {
        public static void a(View view, Collection<View> collection, int i10) {
            view.addKeyboardNavigationClusters(collection, i10);
        }

        public static AutofillId b(View view) {
            return view.getAutofillId();
        }

        public static int c(View view) {
            return view.getImportantForAutofill();
        }

        public static int d(View view) {
            return view.getNextClusterForwardId();
        }

        public static boolean e(View view) {
            return view.hasExplicitFocusable();
        }

        public static boolean f(View view) {
            return view.isFocusedByDefault();
        }

        public static boolean g(View view) {
            return view.isImportantForAutofill();
        }

        public static boolean h(View view) {
            return view.isKeyboardNavigationCluster();
        }

        public static View i(View view, View view2, int i10) {
            return view.keyboardNavigationClusterSearch(view2, i10);
        }

        public static boolean j(View view) {
            return view.restoreDefaultFocus();
        }

        public static void k(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        public static void l(View view, boolean z10) {
            view.setFocusedByDefault(z10);
        }

        public static void m(View view, int i10) {
            view.setImportantForAutofill(i10);
        }

        public static void n(View view, boolean z10) {
            view.setKeyboardNavigationCluster(z10);
        }

        public static void o(View view, int i10) {
            view.setNextClusterForwardId(i10);
        }

        public static void p(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    public static class p {
        public static void a(View view, final u uVar) {
            int i10 = d0.e.R;
            t.g gVar = (t.g) view.getTag(i10);
            if (gVar == null) {
                gVar = new t.g();
                view.setTag(i10, gVar);
            }
            Objects.requireNonNull(uVar);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener() { // from class: p0.a1
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return uVar.onUnhandledKeyEvent(view2, keyEvent);
                }
            };
            gVar.put(uVar, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        public static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void e(View view, u uVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            t.g gVar = (t.g) view.getTag(d0.e.R);
            if (gVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) gVar.get(uVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        public static <T> T f(View view, int i10) {
            return (T) view.requireViewById(i10);
        }

        public static void g(View view, boolean z10) {
            view.setAccessibilityHeading(z10);
        }

        public static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void i(View view, AutofillId autofillId) {
            view.setAutofillId(autofillId);
        }

        public static void j(View view, boolean z10) {
            view.setScreenReaderFocusable(z10);
        }
    }

    public static class q {
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        public static ContentCaptureSession b(View view) {
            return view.getContentCaptureSession();
        }

        public static List<Rect> c(View view) {
            return view.getSystemGestureExclusionRects();
        }

        public static void d(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i10, i11);
        }

        public static void e(View view, ContentCaptureSession contentCaptureSession) {
            view.setContentCaptureSession(contentCaptureSession);
        }

        public static void f(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    public static class r {
        public static int a(View view) {
            return view.getImportantForContentCapture();
        }

        public static CharSequence b(View view) {
            return view.getStateDescription();
        }

        public static h3 c(View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return h3.d(windowInsetsController);
            }
            return null;
        }

        public static boolean d(View view) {
            return view.isImportantForContentCapture();
        }

        public static void e(View view, int i10) {
            view.setImportantForContentCapture(i10);
        }

        public static void f(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    public static final class s {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static p0.c b(View view, p0.c cVar) {
            ContentInfo contentInfoF = cVar.f();
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoF);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoF ? cVar : p0.c.g(contentInfoPerformReceiveContent);
        }

        public static void c(View view, String[] strArr, g0 g0Var) {
            if (g0Var == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new t(g0Var));
            }
        }
    }

    public static final class t implements OnReceiveContentListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g0 f14048a;

        public t(g0 g0Var) {
            this.f14048a = g0Var;
        }

        @Override // android.view.OnReceiveContentListener
        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            p0.c cVarG = p0.c.g(contentInfo);
            p0.c cVarA = this.f14048a.a(view, cVarG);
            if (cVarA == null) {
                return null;
            }
            return cVarA == cVarG ? contentInfo : cVarA.f();
        }
    }

    public interface u {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    public static class v {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final ArrayList<WeakReference<View>> f14049d = new ArrayList<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakHashMap<View, Boolean> f14050a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseArray<WeakReference<View>> f14051b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WeakReference<KeyEvent> f14052c = null;

        public static v a(View view) {
            int i10 = d0.e.Q;
            v vVar = (v) view.getTag(i10);
            if (vVar != null) {
                return vVar;
            }
            v vVar2 = new v();
            view.setTag(i10, vVar2);
            return vVar2;
        }

        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View viewC = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference<>(viewC));
                }
            }
            return viewC != null;
        }

        public final View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f14050a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewC != null) {
                            return viewC;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final SparseArray<WeakReference<View>> d() {
            if (this.f14051b == null) {
                this.f14051b = new SparseArray<>();
            }
            return this.f14051b;
        }

        public final boolean e(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(d0.e.R);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((u) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        public boolean f(KeyEvent keyEvent) {
            WeakReference<View> weakReferenceValueAt;
            int iIndexOfKey;
            WeakReference<KeyEvent> weakReference = this.f14052c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f14052c = new WeakReference<>(keyEvent);
            SparseArray<WeakReference<View>> sparseArrayD = d();
            if (keyEvent.getAction() != 1 || (iIndexOfKey = sparseArrayD.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReferenceValueAt = null;
            } else {
                weakReferenceValueAt = sparseArrayD.valueAt(iIndexOfKey);
                sparseArrayD.removeAt(iIndexOfKey);
            }
            if (weakReferenceValueAt == null) {
                weakReferenceValueAt = sparseArrayD.get(keyEvent.getKeyCode());
            }
            if (weakReferenceValueAt == null) {
                return false;
            }
            View view = weakReferenceValueAt.get();
            if (view != null && p0.S(view)) {
                e(view, keyEvent);
            }
            return true;
        }

        public final void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f14050a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f14049d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.f14050a == null) {
                    this.f14050a = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = f14049d;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.f14050a.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f14050a.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }
    }

    public static int A(View view) {
        return o.c(view);
    }

    public static void A0(View view) {
        if (z(view) == 0) {
            z0(view, 1);
        }
    }

    public static int B(View view) {
        return i.d(view);
    }

    public static void B0(View view, int i10) {
        o.m(view, i10);
    }

    public static int C(View view) {
        return h.d(view);
    }

    public static void C0(View view, int i10) {
        i.h(view, i10);
    }

    public static int D(View view) {
        return h.e(view);
    }

    public static void D0(View view, f0 f0Var) {
        m.u(view, f0Var);
    }

    public static String[] E(View view) {
        return Build.VERSION.SDK_INT >= 31 ? s.a(view) : (String[]) view.getTag(d0.e.N);
    }

    public static void E0(View view, int i10, int i11, int i12, int i13) {
        i.k(view, i10, i11, i12, i13);
    }

    public static int F(View view) {
        return i.e(view);
    }

    public static void F0(View view, boolean z10) {
        o0().g(view, Boolean.valueOf(z10));
    }

    public static int G(View view) {
        return i.f(view);
    }

    public static void G0(View view, int i10, int i11) {
        n.d(view, i10, i11);
    }

    public static k2 H(View view) {
        return n.a(view);
    }

    public static void H0(View view, String str) {
        m.v(view, str);
    }

    public static CharSequence I(View view) {
        return J0().f(view);
    }

    public static void I0(View view, b2.b bVar) {
        b2.d(view, bVar);
    }

    public static String J(View view) {
        return m.k(view);
    }

    public static f<CharSequence> J0() {
        return new c(d0.e.P, CharSequence.class, 64, 30);
    }

    @Deprecated
    public static h3 K(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return r.c(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return z1.a(window, view);
                }
                return null;
            }
        }
        return null;
    }

    public static void K0(View view) {
        m.z(view);
    }

    @Deprecated
    public static int L(View view) {
        return h.g(view);
    }

    public static float M(View view) {
        return m.m(view);
    }

    public static boolean N(View view) {
        return m(view) != null;
    }

    public static boolean O(View view) {
        return g.a(view);
    }

    public static boolean P(View view) {
        return h.h(view);
    }

    public static boolean Q(View view) {
        return h.i(view);
    }

    public static boolean R(View view) {
        Boolean boolF = b().f(view);
        return boolF != null && boolF.booleanValue();
    }

    public static boolean S(View view) {
        return k.b(view);
    }

    public static boolean T(View view) {
        return k.c(view);
    }

    public static boolean U(View view) {
        return m.p(view);
    }

    public static boolean V(View view) {
        return i.g(view);
    }

    public static boolean W(View view) {
        Boolean boolF = o0().f(view);
        return boolF != null && boolF.booleanValue();
    }

    public static /* synthetic */ p0.c X(p0.c cVar) {
        return cVar;
    }

    public static void Y(View view, int i10) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z10 = p(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (o(view) != 0 || z10) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z10 ? 32 : 2048);
                k.g(accessibilityEventObtain, i10);
                if (z10) {
                    accessibilityEventObtain.getText().add(p(view));
                    A0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i10 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                k.g(accessibilityEventObtain2, i10);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(p(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    k.e(view.getParent(), view, view, i10);
                } catch (AbstractMethodError e10) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e10);
                }
            }
        }
    }

    public static void Z(View view, int i10) {
        view.offsetLeftAndRight(i10);
    }

    public static void a0(View view, int i10) {
        view.offsetTopAndBottom(i10);
    }

    public static f<Boolean> b() {
        return new d(d0.e.J, Boolean.class, 28);
    }

    public static k2 b0(View view, k2 k2Var) {
        WindowInsets windowInsetsT = k2Var.t();
        if (windowInsetsT != null) {
            WindowInsets windowInsetsB = l.b(view, windowInsetsT);
            if (!windowInsetsB.equals(windowInsetsT)) {
                return k2.v(windowInsetsB, view);
            }
        }
        return k2Var;
    }

    public static int c(View view, CharSequence charSequence, q0.v vVar) {
        int iR = r(view, charSequence);
        if (iR != -1) {
            d(view, new q0.p.a(iR, charSequence, vVar));
        }
        return iR;
    }

    public static void c0(View view, q0.p pVar) {
        view.onInitializeAccessibilityNodeInfo(pVar.C0());
    }

    public static void d(View view, q0.p.a aVar) {
        j(view);
        k0(aVar.b(), view);
        q(view).add(aVar);
        Y(view, 0);
    }

    public static f<CharSequence> d0() {
        return new b(d0.e.K, CharSequence.class, 8, 28);
    }

    public static v1 e(View view) {
        if (f14034b == null) {
            f14034b = new WeakHashMap<>();
        }
        v1 v1Var = f14034b.get(view);
        if (v1Var != null) {
            return v1Var;
        }
        v1 v1Var2 = new v1(view);
        f14034b.put(view, v1Var2);
        return v1Var2;
    }

    public static boolean e0(View view, int i10, Bundle bundle) {
        return h.j(view, i10, bundle);
    }

    public static k2 f(View view, k2 k2Var, Rect rect) {
        return m.b(view, k2Var, rect);
    }

    public static p0.c f0(View view, p0.c cVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + cVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return s.b(view, cVar);
        }
        g0 g0Var = (g0) view.getTag(d0.e.M);
        if (g0Var == null) {
            return x(view).a(cVar);
        }
        p0.c cVarA = g0Var.a(view, cVar);
        if (cVarA == null) {
            return null;
        }
        return x(view).a(cVarA);
    }

    public static k2 g(View view, k2 k2Var) {
        WindowInsets windowInsetsT = k2Var.t();
        if (windowInsetsT != null) {
            WindowInsets windowInsetsA = l.a(view, windowInsetsT);
            if (!windowInsetsA.equals(windowInsetsT)) {
                return k2.v(windowInsetsA, view);
            }
        }
        return k2Var;
    }

    public static void g0(View view) {
        h.k(view);
    }

    public static boolean h(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return v.a(view).b(view, keyEvent);
    }

    public static void h0(View view, Runnable runnable) {
        h.m(view, runnable);
    }

    public static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return v.a(view).f(keyEvent);
    }

    public static void i0(View view, Runnable runnable, long j10) {
        h.n(view, runnable, j10);
    }

    public static void j(View view) {
        p0.a aVarL = l(view);
        if (aVarL == null) {
            aVarL = new p0.a();
        }
        p0(view, aVarL);
    }

    public static void j0(View view, int i10) {
        k0(i10, view);
        Y(view, 0);
    }

    public static int k() {
        return i.a();
    }

    public static void k0(int i10, View view) {
        List<q0.p.a> listQ = q(view);
        for (int i11 = 0; i11 < listQ.size(); i11++) {
            if (listQ.get(i11).b() == i10) {
                listQ.remove(i11);
                return;
            }
        }
    }

    public static p0.a l(View view) {
        View.AccessibilityDelegate accessibilityDelegateM = m(view);
        if (accessibilityDelegateM == null) {
            return null;
        }
        return accessibilityDelegateM instanceof p0.a.C0240a ? ((p0.a.C0240a) accessibilityDelegateM).f13925a : new p0.a(accessibilityDelegateM);
    }

    public static void l0(View view, q0.p.a aVar, CharSequence charSequence, q0.v vVar) {
        if (vVar == null && charSequence == null) {
            j0(view, aVar.b());
        } else {
            d(view, aVar.a(charSequence, vVar));
        }
    }

    public static View.AccessibilityDelegate m(View view) {
        return Build.VERSION.SDK_INT >= 29 ? q.a(view) : n(view);
    }

    public static void m0(View view) {
        l.c(view);
    }

    public static View.AccessibilityDelegate n(View view) {
        if (f14036d) {
            return null;
        }
        if (f14035c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f14035c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f14036d = true;
                return null;
            }
        }
        try {
            Object obj = f14035c.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f14036d = true;
            return null;
        }
    }

    public static void n0(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            q.d(view, context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    public static int o(View view) {
        return k.a(view);
    }

    public static f<Boolean> o0() {
        return new a(d0.e.O, Boolean.class, 28);
    }

    public static CharSequence p(View view) {
        return d0().f(view);
    }

    public static void p0(View view, p0.a aVar) {
        if (aVar == null && (m(view) instanceof p0.a.C0240a)) {
            aVar = new p0.a();
        }
        A0(view);
        view.setAccessibilityDelegate(aVar == null ? null : aVar.d());
    }

    public static List<q0.p.a> q(View view) {
        int i10 = d0.e.H;
        ArrayList arrayList = (ArrayList) view.getTag(i10);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i10, arrayList2);
        return arrayList2;
    }

    public static void q0(View view, boolean z10) {
        b().g(view, Boolean.valueOf(z10));
    }

    public static int r(View view, CharSequence charSequence) {
        List<q0.p.a> listQ = q(view);
        for (int i10 = 0; i10 < listQ.size(); i10++) {
            if (TextUtils.equals(charSequence, listQ.get(i10).c())) {
                return listQ.get(i10).b();
            }
        }
        int i11 = -1;
        int i12 = 0;
        while (true) {
            int[] iArr = f14037e;
            if (i12 >= iArr.length || i11 != -1) {
                break;
            }
            int i13 = iArr[i12];
            boolean z10 = true;
            for (int i14 = 0; i14 < listQ.size(); i14++) {
                z10 &= listQ.get(i14).b() != i13;
            }
            if (z10) {
                i11 = i13;
            }
            i12++;
        }
        return i11;
    }

    public static void r0(View view, int i10) {
        k.f(view, i10);
    }

    public static ColorStateList s(View view) {
        return m.g(view);
    }

    public static void s0(View view, CharSequence charSequence) {
        d0().g(view, charSequence);
        if (charSequence != null) {
            f14039g.a(view);
        } else {
            f14039g.d(view);
        }
    }

    public static PorterDuff.Mode t(View view) {
        return m.h(view);
    }

    public static void t0(View view, Drawable drawable) {
        h.q(view, drawable);
    }

    public static Rect u(View view) {
        return j.a(view);
    }

    public static void u0(View view, ColorStateList colorStateList) {
        m.q(view, colorStateList);
    }

    public static Display v(View view) {
        return i.b(view);
    }

    public static void v0(View view, PorterDuff.Mode mode) {
        m.r(view, mode);
    }

    public static float w(View view) {
        return m.i(view);
    }

    public static void w0(View view, Rect rect) {
        j.c(view, rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static h0 x(View view) {
        return view instanceof h0 ? (h0) view : f14038f;
    }

    public static void x0(View view, float f10) {
        m.s(view, f10);
    }

    public static boolean y(View view) {
        return h.b(view);
    }

    public static void y0(View view, boolean z10) {
        h.r(view, z10);
    }

    public static int z(View view) {
        return h.c(view);
    }

    public static void z0(View view, int i10) {
        h.s(view, i10);
    }
}
