package y0;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;
import p0.p0;
import q0.p;
import q0.t;
import q0.u;
import t.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends p0.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Rect f19253n = new Rect(com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER, com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final y0.b.a<p> f19254o = new C0331a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final y0.b.InterfaceC0332b<h<p>, p> f19255p = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AccessibilityManager f19260h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f19261i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f19262j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f19256d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f19257e = new Rect();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f19258f = new Rect();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f19259g = new int[2];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f19263k = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f19264l = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f19265m = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: y0.a$a, reason: collision with other inner class name */
    public class C0331a implements y0.b.a<p> {
        @Override // y0.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(p pVar, Rect rect) {
            pVar.j(rect);
        }
    }

    public class b implements y0.b.InterfaceC0332b<h<p>, p> {
        @Override // y0.b.InterfaceC0332b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public p a(h<p> hVar, int i10) {
            return hVar.m(i10);
        }

        @Override // y0.b.InterfaceC0332b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int b(h<p> hVar) {
            return hVar.l();
        }
    }

    public class c extends t {
        public c() {
        }

        @Override // q0.t
        public p b(int i10) {
            return p.U(a.this.H(i10));
        }

        @Override // q0.t
        public p d(int i10) {
            int i11 = i10 == 2 ? a.this.f19263k : a.this.f19264l;
            if (i11 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i11);
        }

        @Override // q0.t
        public boolean f(int i10, int i11, Bundle bundle) {
            return a.this.P(i10, i11, bundle);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f19261i = view;
        this.f19260h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (p0.z(view) == 0) {
            p0.z0(view, 1);
        }
    }

    public static Rect D(View view, int i10, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i10 == 17) {
            rect.set(width, 0, width, height);
        } else if (i10 == 33) {
            rect.set(0, height, width, height);
        } else if (i10 == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i10 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    public static int F(int i10) {
        if (i10 == 19) {
            return 33;
        }
        if (i10 != 21) {
            return i10 != 22 ? 130 : 66;
        }
        return 17;
    }

    public final int A() {
        return this.f19264l;
    }

    public abstract int B(float f10, float f11);

    public abstract void C(List<Integer> list);

    public final boolean E(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f19261i.getWindowVisibility() != 0) {
            return false;
        }
        View view = this.f19261i;
        do {
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return parent != null;
            }
            view = (View) parent;
            if (view.getAlpha() <= 0.0f) {
                break;
            }
        } while (view.getVisibility() == 0);
        return false;
    }

    public final boolean G(int i10, Rect rect) {
        Object objD;
        h<p> hVarY = y();
        int i11 = this.f19264l;
        p pVarF = i11 == Integer.MIN_VALUE ? null : hVarY.f(i11);
        if (i10 == 1 || i10 == 2) {
            objD = y0.b.d(hVarY, f19255p, f19254o, pVarF, i10, p0.B(this.f19261i) == 1, false);
        } else {
            if (i10 != 17 && i10 != 33 && i10 != 66 && i10 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i12 = this.f19264l;
            if (i12 != Integer.MIN_VALUE) {
                z(i12, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                D(this.f19261i, i10, rect2);
            }
            objD = y0.b.c(hVarY, f19255p, f19254o, pVarF, rect2, i10);
        }
        p pVar = (p) objD;
        return T(pVar != null ? hVarY.i(hVarY.h(pVar)) : Integer.MIN_VALUE);
    }

    public p H(int i10) {
        return i10 == -1 ? u() : t(i10);
    }

    public final void I(boolean z10, int i10, Rect rect) {
        int i11 = this.f19264l;
        if (i11 != Integer.MIN_VALUE) {
            o(i11);
        }
        if (z10) {
            G(i10, rect);
        }
    }

    public abstract boolean J(int i10, int i11, Bundle bundle);

    public void K(AccessibilityEvent accessibilityEvent) {
    }

    public void L(int i10, AccessibilityEvent accessibilityEvent) {
    }

    public abstract void M(p pVar);

    public abstract void N(int i10, p pVar);

    public abstract void O(int i10, boolean z10);

    public boolean P(int i10, int i11, Bundle bundle) {
        return i10 != -1 ? Q(i10, i11, bundle) : R(i11, bundle);
    }

    public final boolean Q(int i10, int i11, Bundle bundle) {
        if (i11 == 1) {
            return T(i10);
        }
        if (i11 == 2) {
            return o(i10);
        }
        if (i11 != 64) {
            return i11 != 128 ? J(i10, i11, bundle) : n(i10);
        }
        return S(i10);
    }

    public final boolean R(int i10, Bundle bundle) {
        return p0.e0(this.f19261i, i10, bundle);
    }

    public final boolean S(int i10) {
        int i11;
        if (!this.f19260h.isEnabled() || !this.f19260h.isTouchExplorationEnabled() || (i11 = this.f19263k) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            n(i11);
        }
        this.f19263k = i10;
        this.f19261i.invalidate();
        U(i10, 32768);
        return true;
    }

    public final boolean T(int i10) {
        int i11;
        if ((!this.f19261i.isFocused() && !this.f19261i.requestFocus()) || (i11 = this.f19264l) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            o(i11);
        }
        if (i10 == Integer.MIN_VALUE) {
            return false;
        }
        this.f19264l = i10;
        O(i10, true);
        U(i10, 8);
        return true;
    }

    public final boolean U(int i10, int i11) {
        ViewParent parent;
        if (i10 == Integer.MIN_VALUE || !this.f19260h.isEnabled() || (parent = this.f19261i.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f19261i, q(i10, i11));
    }

    public final void V(int i10) {
        int i11 = this.f19265m;
        if (i11 == i10) {
            return;
        }
        this.f19265m = i10;
        U(i10, 128);
        U(i11, 256);
    }

    @Override // p0.a
    public t b(View view) {
        if (this.f19262j == null) {
            this.f19262j = new c();
        }
        return this.f19262j;
    }

    @Override // p0.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        K(accessibilityEvent);
    }

    @Override // p0.a
    public void g(View view, p pVar) {
        super.g(view, pVar);
        M(pVar);
    }

    public final boolean n(int i10) {
        if (this.f19263k != i10) {
            return false;
        }
        this.f19263k = Integer.MIN_VALUE;
        this.f19261i.invalidate();
        U(i10, 65536);
        return true;
    }

    public final boolean o(int i10) {
        if (this.f19264l != i10) {
            return false;
        }
        this.f19264l = Integer.MIN_VALUE;
        O(i10, false);
        U(i10, 8);
        return true;
    }

    public final boolean p() {
        int i10 = this.f19264l;
        return i10 != Integer.MIN_VALUE && J(i10, 16, null);
    }

    public final AccessibilityEvent q(int i10, int i11) {
        return i10 != -1 ? r(i10, i11) : s(i11);
    }

    public final AccessibilityEvent r(int i10, int i11) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i11);
        p pVarH = H(i10);
        accessibilityEventObtain.getText().add(pVarH.w());
        accessibilityEventObtain.setContentDescription(pVarH.q());
        accessibilityEventObtain.setScrollable(pVarH.N());
        accessibilityEventObtain.setPassword(pVarH.M());
        accessibilityEventObtain.setEnabled(pVarH.G());
        accessibilityEventObtain.setChecked(pVarH.D());
        L(i10, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(pVarH.n());
        u.c(accessibilityEventObtain, this.f19261i, i10);
        accessibilityEventObtain.setPackageName(this.f19261i.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    public final AccessibilityEvent s(int i10) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i10);
        this.f19261i.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    public final p t(int i10) {
        p pVarS = p.S();
        pVarS.i0(true);
        pVarS.k0(true);
        pVarS.d0("android.view.View");
        Rect rect = f19253n;
        pVarS.Z(rect);
        pVarS.a0(rect);
        pVarS.s0(this.f19261i);
        N(i10, pVarS);
        if (pVarS.w() == null && pVarS.q() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        pVarS.j(this.f19257e);
        if (this.f19257e.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int iH = pVarS.h();
        if ((iH & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((iH & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        pVarS.q0(this.f19261i.getContext().getPackageName());
        pVarS.x0(this.f19261i, i10);
        if (this.f19263k == i10) {
            pVarS.X(true);
            pVarS.a(128);
        } else {
            pVarS.X(false);
            pVarS.a(64);
        }
        boolean z10 = this.f19264l == i10;
        if (z10) {
            pVarS.a(2);
        } else if (pVarS.H()) {
            pVarS.a(1);
        }
        pVarS.l0(z10);
        this.f19261i.getLocationOnScreen(this.f19259g);
        pVarS.k(this.f19256d);
        if (this.f19256d.equals(rect)) {
            pVarS.j(this.f19256d);
            if (pVarS.f14578b != -1) {
                p pVarS2 = p.S();
                for (int i11 = pVarS.f14578b; i11 != -1; i11 = pVarS2.f14578b) {
                    pVarS2.t0(this.f19261i, -1);
                    pVarS2.Z(f19253n);
                    N(i11, pVarS2);
                    pVarS2.j(this.f19257e);
                    Rect rect2 = this.f19256d;
                    Rect rect3 = this.f19257e;
                    rect2.offset(rect3.left, rect3.top);
                }
                pVarS2.W();
            }
            this.f19256d.offset(this.f19259g[0] - this.f19261i.getScrollX(), this.f19259g[1] - this.f19261i.getScrollY());
        }
        if (this.f19261i.getLocalVisibleRect(this.f19258f)) {
            this.f19258f.offset(this.f19259g[0] - this.f19261i.getScrollX(), this.f19259g[1] - this.f19261i.getScrollY());
            if (this.f19256d.intersect(this.f19258f)) {
                pVarS.a0(this.f19256d);
                if (E(this.f19256d)) {
                    pVarS.B0(true);
                }
            }
        }
        return pVarS;
    }

    public final p u() {
        p pVarT = p.T(this.f19261i);
        p0.c0(this.f19261i, pVarT);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (pVarT.m() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            pVarT.c(this.f19261i, ((Integer) arrayList.get(i10)).intValue());
        }
        return pVarT;
    }

    public final boolean v(MotionEvent motionEvent) {
        if (!this.f19260h.isEnabled() || !this.f19260h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iB = B(motionEvent.getX(), motionEvent.getY());
            V(iB);
            return iB != Integer.MIN_VALUE;
        }
        if (action != 10 || this.f19265m == Integer.MIN_VALUE) {
            return false;
        }
        V(Integer.MIN_VALUE);
        return true;
    }

    public final boolean w(KeyEvent keyEvent) {
        int i10 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return G(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return G(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int iF = F(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z10 = false;
                    while (i10 < repeatCount && G(iF, null)) {
                        i10++;
                        z10 = true;
                    }
                    return z10;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        p();
        return true;
    }

    public final int x() {
        return this.f19263k;
    }

    public final h<p> y() {
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        h<p> hVar = new h<>();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            hVar.j(arrayList.get(i10).intValue(), t(arrayList.get(i10).intValue()));
        }
        return hVar;
    }

    public final void z(int i10, Rect rect) {
        H(i10).j(rect);
    }
}
