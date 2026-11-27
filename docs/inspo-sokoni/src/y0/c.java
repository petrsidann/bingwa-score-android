package y0;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import p0.p0;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Interpolator f19271x = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19273b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f19275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f19276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f19277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f19278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f19279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f19280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f19281j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f19282k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f19283l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f19284m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f19285n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f19286o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f19287p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f19288q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public OverScroller f19289r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AbstractC0333c f19290s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f19291t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f19292u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ViewGroup f19293v;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19274c = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Runnable f19294w = new b();

    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.E(0);
        }
    }

    /* JADX INFO: renamed from: y0.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0333c {
        public abstract int a(View view, int i10, int i11);

        public abstract int b(View view, int i10, int i11);

        public int c(int i10) {
            return i10;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i10, int i11) {
        }

        public boolean g(int i10) {
            return false;
        }

        public void h(int i10, int i11) {
        }

        public void i(View view, int i10) {
        }

        public abstract void j(int i10);

        public abstract void k(View view, int i10, int i11, int i12, int i13);

        public abstract void l(View view, float f10, float f11);

        public abstract boolean m(View view, int i10);
    }

    public c(Context context, ViewGroup viewGroup, AbstractC0333c abstractC0333c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0333c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f19293v = viewGroup;
        this.f19290s = abstractC0333c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i10 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f19287p = i10;
        this.f19286o = i10;
        this.f19273b = viewConfiguration.getScaledTouchSlop();
        this.f19284m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f19285n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f19289r = new OverScroller(context, f19271x);
    }

    public static c l(ViewGroup viewGroup, float f10, AbstractC0333c abstractC0333c) {
        c cVarM = m(viewGroup, abstractC0333c);
        cVarM.f19273b = (int) (cVarM.f19273b * (1.0f / f10));
        return cVarM;
    }

    public static c m(ViewGroup viewGroup, AbstractC0333c abstractC0333c) {
        return new c(viewGroup.getContext(), viewGroup, abstractC0333c);
    }

    public final void A() {
        this.f19283l.computeCurrentVelocity(1000, this.f19284m);
        n(e(this.f19283l.getXVelocity(this.f19274c), this.f19285n, this.f19284m), e(this.f19283l.getYVelocity(this.f19274c), this.f19285n, this.f19284m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [y0.c$c] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void B(float f10, float f11, int i10) {
        boolean zC = c(f10, f11, i10, 1);
        ?? r10 = zC;
        if (c(f11, f10, i10, 4)) {
            r10 = (zC ? 1 : 0) | 4;
        }
        ?? r11 = r10;
        if (c(f10, f11, i10, 2)) {
            r11 = (r10 == true ? 1 : 0) | 2;
        }
        ?? r12 = r11;
        if (c(f11, f10, i10, 8)) {
            r12 = (r11 == true ? 1 : 0) | 8;
        }
        if (r12 != 0) {
            int[] iArr = this.f19280i;
            iArr[i10] = (iArr[i10] | r12) == true ? 1 : 0;
            this.f19290s.f(r12, i10);
        }
    }

    public final void C(float f10, float f11, int i10) {
        q(i10);
        float[] fArr = this.f19275d;
        this.f19277f[i10] = f10;
        fArr[i10] = f10;
        float[] fArr2 = this.f19276e;
        this.f19278g[i10] = f11;
        fArr2[i10] = f11;
        this.f19279h[i10] = t((int) f10, (int) f11);
        this.f19282k |= 1 << i10;
    }

    public final void D(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (x(pointerId)) {
                float x10 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                this.f19277f[pointerId] = x10;
                this.f19278g[pointerId] = y10;
            }
        }
    }

    public void E(int i10) {
        this.f19293v.removeCallbacks(this.f19294w);
        if (this.f19272a != i10) {
            this.f19272a = i10;
            this.f19290s.j(i10);
            if (this.f19272a == 0) {
                this.f19291t = null;
            }
        }
    }

    public boolean F(int i10, int i11) {
        if (this.f19292u) {
            return s(i10, i11, (int) this.f19283l.getXVelocity(this.f19274c), (int) this.f19283l.getYVelocity(this.f19274c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ff  */
    public boolean G(MotionEvent motionEvent) {
        boolean z10;
        View viewR;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f19283l == null) {
            this.f19283l = VelocityTracker.obtain();
        }
        this.f19283l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                a();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    a();
                } else if (actionMasked == 5) {
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    float x10 = motionEvent.getX(actionIndex);
                    float y10 = motionEvent.getY(actionIndex);
                    C(x10, y10, pointerId);
                    int i10 = this.f19272a;
                    if (i10 == 0) {
                        int i11 = this.f19279h[pointerId];
                        int i12 = this.f19288q;
                        if ((i11 & i12) != 0) {
                            this.f19290s.h(i11 & i12, pointerId);
                        }
                    } else if (i10 == 2 && (viewR = r((int) x10, (int) y10)) == this.f19291t) {
                        I(viewR, pointerId);
                    }
                } else if (actionMasked == 6) {
                    h(motionEvent.getPointerId(actionIndex));
                }
            } else if (this.f19275d != null && this.f19276e != null) {
                int pointerCount = motionEvent.getPointerCount();
                for (int i13 = 0; i13 < pointerCount; i13++) {
                    int pointerId2 = motionEvent.getPointerId(i13);
                    if (x(pointerId2)) {
                        float x11 = motionEvent.getX(i13);
                        float y11 = motionEvent.getY(i13);
                        float f10 = x11 - this.f19275d[pointerId2];
                        float f11 = y11 - this.f19276e[pointerId2];
                        View viewR2 = r((int) x11, (int) y11);
                        boolean z11 = viewR2 != null && d(viewR2, f10, f11);
                        if (!z11) {
                            B(f10, f11, pointerId2);
                            if (this.f19272a != 1) {
                                break;
                            }
                        } else {
                            int left = viewR2.getLeft();
                            int i14 = (int) f10;
                            int iA = this.f19290s.a(viewR2, left + i14, i14);
                            int top = viewR2.getTop();
                            int i15 = (int) f11;
                            int iB = this.f19290s.b(viewR2, top + i15, i15);
                            int iD = this.f19290s.d(viewR2);
                            int iE = this.f19290s.e(viewR2);
                            if ((iD == 0 || (iD > 0 && iA == left)) && (iE == 0 || (iE > 0 && iB == top))) {
                                break;
                            }
                            B(f10, f11, pointerId2);
                            if (this.f19272a != 1 || (z11 && I(viewR2, pointerId2))) {
                                break;
                            }
                        }
                    }
                }
                D(motionEvent);
            }
            z10 = false;
        } else {
            float x12 = motionEvent.getX();
            float y12 = motionEvent.getY();
            z10 = false;
            int pointerId3 = motionEvent.getPointerId(0);
            C(x12, y12, pointerId3);
            View viewR3 = r((int) x12, (int) y12);
            if (viewR3 == this.f19291t && this.f19272a == 2) {
                I(viewR3, pointerId3);
            }
            int i16 = this.f19279h[pointerId3];
            int i17 = this.f19288q;
            if ((i16 & i17) != 0) {
                this.f19290s.h(i16 & i17, pointerId3);
            }
        }
        if (this.f19272a == 1) {
            return true;
        }
        return z10;
    }

    public boolean H(View view, int i10, int i11) {
        this.f19291t = view;
        this.f19274c = -1;
        boolean zS = s(i10, i11, 0, 0);
        if (!zS && this.f19272a == 0 && this.f19291t != null) {
            this.f19291t = null;
        }
        return zS;
    }

    public boolean I(View view, int i10) {
        if (view == this.f19291t && this.f19274c == i10) {
            return true;
        }
        if (view == null || !this.f19290s.m(view, i10)) {
            return false;
        }
        this.f19274c = i10;
        b(view, i10);
        return true;
    }

    public void a() {
        this.f19274c = -1;
        g();
        VelocityTracker velocityTracker = this.f19283l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f19283l = null;
        }
    }

    public void b(View view, int i10) {
        if (view.getParent() == this.f19293v) {
            this.f19291t = view;
            this.f19274c = i10;
            this.f19290s.i(view, i10);
            E(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f19293v + ")");
    }

    public final boolean c(float f10, float f11, int i10, int i11) {
        float fAbs = Math.abs(f10);
        float fAbs2 = Math.abs(f11);
        if ((this.f19279h[i10] & i11) != i11 || (this.f19288q & i11) == 0 || (this.f19281j[i10] & i11) == i11 || (this.f19280i[i10] & i11) == i11) {
            return false;
        }
        int i12 = this.f19273b;
        if (fAbs <= i12 && fAbs2 <= i12) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.f19290s.g(i11)) {
            return (this.f19280i[i10] & i11) == 0 && fAbs > ((float) this.f19273b);
        }
        int[] iArr = this.f19281j;
        iArr[i10] = iArr[i10] | i11;
        return false;
    }

    public final boolean d(View view, float f10, float f11) {
        if (view == null) {
            return false;
        }
        boolean z10 = this.f19290s.d(view) > 0;
        boolean z11 = this.f19290s.e(view) > 0;
        if (z10 && z11) {
            float f12 = (f10 * f10) + (f11 * f11);
            int i10 = this.f19273b;
            return f12 > ((float) (i10 * i10));
        }
        if (z10) {
            return Math.abs(f10) > ((float) this.f19273b);
        }
        return z11 && Math.abs(f11) > ((float) this.f19273b);
    }

    public final float e(float f10, float f11, float f12) {
        float fAbs = Math.abs(f10);
        if (fAbs < f11) {
            return 0.0f;
        }
        if (fAbs > f12) {
            return f10 > 0.0f ? f12 : -f12;
        }
        return f10;
    }

    public final int f(int i10, int i11, int i12) {
        int iAbs = Math.abs(i10);
        if (iAbs < i11) {
            return 0;
        }
        if (iAbs > i12) {
            return i10 > 0 ? i12 : -i12;
        }
        return i10;
    }

    public final void g() {
        float[] fArr = this.f19275d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f19276e, 0.0f);
        Arrays.fill(this.f19277f, 0.0f);
        Arrays.fill(this.f19278g, 0.0f);
        Arrays.fill(this.f19279h, 0);
        Arrays.fill(this.f19280i, 0);
        Arrays.fill(this.f19281j, 0);
        this.f19282k = 0;
    }

    public final void h(int i10) {
        if (this.f19275d == null || !w(i10)) {
            return;
        }
        this.f19275d[i10] = 0.0f;
        this.f19276e[i10] = 0.0f;
        this.f19277f[i10] = 0.0f;
        this.f19278g[i10] = 0.0f;
        this.f19279h[i10] = 0;
        this.f19280i[i10] = 0;
        this.f19281j[i10] = 0;
        this.f19282k = (~(1 << i10)) & this.f19282k;
    }

    public final int i(int i10, int i11, int i12) {
        if (i10 == 0) {
            return 0;
        }
        int width = this.f19293v.getWidth();
        float f10 = width / 2;
        float fO = f10 + (o(Math.min(1.0f, Math.abs(i10) / width)) * f10);
        int iAbs = Math.abs(i11);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fO / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i10) / i12) + 1.0f) * 256.0f), 600);
    }

    public final int j(View view, int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int iF = f(i12, (int) this.f19285n, (int) this.f19284m);
        int iF2 = f(i13, (int) this.f19285n, (int) this.f19284m);
        int iAbs = Math.abs(i10);
        int iAbs2 = Math.abs(i11);
        int iAbs3 = Math.abs(iF);
        int iAbs4 = Math.abs(iF2);
        int i14 = iAbs3 + iAbs4;
        int i15 = iAbs + iAbs2;
        if (iF != 0) {
            f10 = iAbs3;
            f11 = i14;
        } else {
            f10 = iAbs;
            f11 = i15;
        }
        float f14 = f10 / f11;
        if (iF2 != 0) {
            f12 = iAbs4;
            f13 = i14;
        } else {
            f12 = iAbs2;
            f13 = i15;
        }
        return (int) ((i(i10, iF, this.f19290s.d(view)) * f14) + (i(i11, iF2, this.f19290s.e(view)) * (f12 / f13)));
    }

    public boolean k(boolean z10) {
        if (this.f19272a == 2) {
            boolean zComputeScrollOffset = this.f19289r.computeScrollOffset();
            int currX = this.f19289r.getCurrX();
            int currY = this.f19289r.getCurrY();
            int left = currX - this.f19291t.getLeft();
            int top = currY - this.f19291t.getTop();
            if (left != 0) {
                p0.Z(this.f19291t, left);
            }
            if (top != 0) {
                p0.a0(this.f19291t, top);
            }
            if (left != 0 || top != 0) {
                this.f19290s.k(this.f19291t, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f19289r.getFinalX() && currY == this.f19289r.getFinalY()) {
                this.f19289r.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z10) {
                    this.f19293v.post(this.f19294w);
                } else {
                    E(0);
                }
            }
        }
        return this.f19272a == 2;
    }

    public final void n(float f10, float f11) {
        this.f19292u = true;
        this.f19290s.l(this.f19291t, f10, f11);
        this.f19292u = false;
        if (this.f19272a == 1) {
            E(0);
        }
    }

    public final float o(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    public final void p(int i10, int i11, int i12, int i13) {
        int left = this.f19291t.getLeft();
        int top = this.f19291t.getTop();
        if (i12 != 0) {
            i10 = this.f19290s.a(this.f19291t, i10, i12);
            p0.Z(this.f19291t, i10 - left);
        }
        int i14 = i10;
        if (i13 != 0) {
            i11 = this.f19290s.b(this.f19291t, i11, i13);
            p0.a0(this.f19291t, i11 - top);
        }
        int i15 = i11;
        if (i12 == 0 && i13 == 0) {
            return;
        }
        this.f19290s.k(this.f19291t, i14, i15, i14 - left, i15 - top);
    }

    public final void q(int i10) {
        float[] fArr = this.f19275d;
        if (fArr == null || fArr.length <= i10) {
            int i11 = i10 + 1;
            float[] fArr2 = new float[i11];
            float[] fArr3 = new float[i11];
            float[] fArr4 = new float[i11];
            float[] fArr5 = new float[i11];
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f19276e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f19277f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f19278g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f19279h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f19280i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f19281j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f19275d = fArr2;
            this.f19276e = fArr3;
            this.f19277f = fArr4;
            this.f19278g = fArr5;
            this.f19279h = iArr;
            this.f19280i = iArr2;
            this.f19281j = iArr3;
        }
    }

    public View r(int i10, int i11) {
        for (int childCount = this.f19293v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f19293v.getChildAt(this.f19290s.c(childCount));
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean s(int i10, int i11, int i12, int i13) {
        int left = this.f19291t.getLeft();
        int top = this.f19291t.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        if (i14 == 0 && i15 == 0) {
            this.f19289r.abortAnimation();
            E(0);
            return false;
        }
        this.f19289r.startScroll(left, top, i14, i15, j(this.f19291t, i14, i15, i12, i13));
        E(2);
        return true;
    }

    public final int t(int i10, int i11) {
        int i12 = i10 < this.f19293v.getLeft() + this.f19286o ? 1 : 0;
        if (i11 < this.f19293v.getTop() + this.f19286o) {
            i12 |= 4;
        }
        if (i10 > this.f19293v.getRight() - this.f19286o) {
            i12 |= 2;
        }
        return i11 > this.f19293v.getBottom() - this.f19286o ? i12 | 8 : i12;
    }

    public int u() {
        return this.f19273b;
    }

    public boolean v(int i10, int i11) {
        return y(this.f19291t, i10, i11);
    }

    public boolean w(int i10) {
        return ((1 << i10) & this.f19282k) != 0;
    }

    public final boolean x(int i10) {
        if (w(i10)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i10 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public boolean y(View view, int i10, int i11) {
        return view != null && i10 >= view.getLeft() && i10 < view.getRight() && i11 >= view.getTop() && i11 < view.getBottom();
    }

    public void z(MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f19283l == null) {
            this.f19283l = VelocityTracker.obtain();
        }
        this.f19283l.addMovement(motionEvent);
        int i11 = 0;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewR = r((int) x10, (int) y10);
            C(x10, y10, pointerId);
            I(viewR, pointerId);
            int i12 = this.f19279h[pointerId];
            int i13 = this.f19288q;
            if ((i12 & i13) != 0) {
                this.f19290s.h(i12 & i13, pointerId);
                return;
            }
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (this.f19272a != 1) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (i11 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i11);
                        if (x(pointerId2)) {
                            float x11 = motionEvent.getX(i11);
                            float y11 = motionEvent.getY(i11);
                            float f10 = x11 - this.f19275d[pointerId2];
                            float f11 = y11 - this.f19276e[pointerId2];
                            B(f10, f11, pointerId2);
                            if (this.f19272a != 1) {
                                View viewR2 = r((int) x11, (int) y11);
                                if (d(viewR2, f10, f11) && I(viewR2, pointerId2)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        i11++;
                    }
                } else {
                    if (!x(this.f19274c)) {
                        return;
                    }
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f19274c);
                    float x12 = motionEvent.getX(iFindPointerIndex);
                    float y12 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f19277f;
                    int i14 = this.f19274c;
                    int i15 = (int) (x12 - fArr[i14]);
                    int i16 = (int) (y12 - this.f19278g[i14]);
                    p(this.f19291t.getLeft() + i15, this.f19291t.getTop() + i16, i15, i16);
                }
                D(motionEvent);
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked == 5) {
                    int pointerId3 = motionEvent.getPointerId(actionIndex);
                    float x13 = motionEvent.getX(actionIndex);
                    float y13 = motionEvent.getY(actionIndex);
                    C(x13, y13, pointerId3);
                    if (this.f19272a != 0) {
                        if (v((int) x13, (int) y13)) {
                            I(this.f19291t, pointerId3);
                            return;
                        }
                        return;
                    } else {
                        I(r((int) x13, (int) y13), pointerId3);
                        int i17 = this.f19279h[pointerId3];
                        int i18 = this.f19288q;
                        if ((i17 & i18) != 0) {
                            this.f19290s.h(i17 & i18, pointerId3);
                            return;
                        }
                        return;
                    }
                }
                if (actionMasked != 6) {
                    return;
                }
                int pointerId4 = motionEvent.getPointerId(actionIndex);
                if (this.f19272a == 1 && pointerId4 == this.f19274c) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (true) {
                        if (i11 >= pointerCount2) {
                            i10 = -1;
                            break;
                        }
                        int pointerId5 = motionEvent.getPointerId(i11);
                        if (pointerId5 != this.f19274c) {
                            View viewR3 = r((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                            View view = this.f19291t;
                            if (viewR3 == view && I(view, pointerId5)) {
                                i10 = this.f19274c;
                                break;
                            }
                        }
                        i11++;
                    }
                    if (i10 == -1) {
                        A();
                    }
                }
                h(pointerId4);
                return;
            }
            if (this.f19272a == 1) {
                n(0.0f, 0.0f);
            }
        } else if (this.f19272a == 1) {
            A();
        }
        a();
    }
}
