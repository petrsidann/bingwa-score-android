package t0;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import p0.p0;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f15767w = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f15770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f15771d;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f15774l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f15775m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f15779q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f15780r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f15781s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f15782t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f15783u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f15784v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0285a f15768a = new C0285a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Interpolator f15769b = new AccelerateInterpolator();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f15772e = {0.0f, 0.0f};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f15773f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float[] f15776n = {0.0f, 0.0f};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float[] f15777o = {0.0f, 0.0f};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float[] f15778p = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: t0.a$a, reason: collision with other inner class name */
    public static class C0285a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15786b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f15787c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f15788d;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f15794j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f15795k;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f15789e = Long.MIN_VALUE;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f15793i = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f15790f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f15791g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f15792h = 0;

        public void a() {
            if (this.f15790f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fG = g(e(jCurrentAnimationTimeMillis));
            long j10 = jCurrentAnimationTimeMillis - this.f15790f;
            this.f15790f = jCurrentAnimationTimeMillis;
            float f10 = j10 * fG;
            this.f15791g = (int) (this.f15787c * f10);
            this.f15792h = (int) (f10 * this.f15788d);
        }

        public int b() {
            return this.f15791g;
        }

        public int c() {
            return this.f15792h;
        }

        public int d() {
            float f10 = this.f15787c;
            return (int) (f10 / Math.abs(f10));
        }

        public final float e(long j10) {
            long j11 = this.f15789e;
            if (j10 < j11) {
                return 0.0f;
            }
            long j12 = this.f15793i;
            if (j12 < 0 || j10 < j12) {
                return a.e((j10 - j11) / this.f15785a, 0.0f, 1.0f) * 0.5f;
            }
            float f10 = this.f15794j;
            return (1.0f - f10) + (f10 * a.e((j10 - j12) / this.f15795k, 0.0f, 1.0f));
        }

        public int f() {
            float f10 = this.f15788d;
            return (int) (f10 / Math.abs(f10));
        }

        public final float g(float f10) {
            return ((-4.0f) * f10 * f10) + (f10 * 4.0f);
        }

        public boolean h() {
            return this.f15793i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f15793i + ((long) this.f15795k);
        }

        public void i() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f15795k = a.f((int) (jCurrentAnimationTimeMillis - this.f15789e), 0, this.f15786b);
            this.f15794j = e(jCurrentAnimationTimeMillis);
            this.f15793i = jCurrentAnimationTimeMillis;
        }

        public void j(int i10) {
            this.f15786b = i10;
        }

        public void k(int i10) {
            this.f15785a = i10;
        }

        public void l(float f10, float f11) {
            this.f15787c = f10;
            this.f15788d = f11;
        }

        public void m() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f15789e = jCurrentAnimationTimeMillis;
            this.f15793i = -1L;
            this.f15790f = jCurrentAnimationTimeMillis;
            this.f15794j = 0.5f;
            this.f15791g = 0;
            this.f15792h = 0;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f15782t) {
                if (aVar.f15780r) {
                    aVar.f15780r = false;
                    aVar.f15768a.m();
                }
                C0285a c0285a = a.this.f15768a;
                if (c0285a.h() || !a.this.u()) {
                    a.this.f15782t = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f15781s) {
                    aVar2.f15781s = false;
                    aVar2.c();
                }
                c0285a.a();
                a.this.j(c0285a.b(), c0285a.c());
                p0.h0(a.this.f15770c, this);
            }
        }
    }

    public a(View view) {
        this.f15770c = view;
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        float f11 = (int) ((1575.0f * f10) + 0.5f);
        o(f11, f11);
        float f12 = (int) ((f10 * 315.0f) + 0.5f);
        p(f12, f12);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f15767w);
        r(500);
        q(500);
    }

    public static float e(float f10, float f11, float f12) {
        if (f10 > f12) {
            return f12;
        }
        return f10 < f11 ? f11 : f10;
    }

    public static int f(int i10, int i11, int i12) {
        if (i10 > i12) {
            return i12;
        }
        return i10 < i11 ? i11 : i10;
    }

    public abstract boolean a(int i10);

    public abstract boolean b(int i10);

    public void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f15770c.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public final float d(int i10, float f10, float f11, float f12) {
        float fH = h(this.f15772e[i10], f11, this.f15773f[i10], f10);
        if (fH == 0.0f) {
            return 0.0f;
        }
        float f13 = this.f15776n[i10];
        float f14 = this.f15777o[i10];
        float f15 = this.f15778p[i10];
        float f16 = f13 * f12;
        return fH > 0.0f ? e(fH * f16, f14, f15) : -e((-fH) * f16, f14, f15);
    }

    public final float g(float f10, float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        int i10 = this.f15774l;
        if (i10 == 0 || i10 == 1) {
            if (f10 < f11) {
                if (f10 >= 0.0f) {
                    return 1.0f - (f10 / f11);
                }
                if (this.f15782t && i10 == 1) {
                    return 1.0f;
                }
            }
        } else if (i10 == 2 && f10 < 0.0f) {
            return f10 / (-f11);
        }
        return 0.0f;
    }

    public final float h(float f10, float f11, float f12, float f13) {
        float interpolation;
        float fE = e(f10 * f11, 0.0f, f12);
        float fG = g(f11 - f13, fE) - g(f13, fE);
        if (fG < 0.0f) {
            interpolation = -this.f15769b.getInterpolation(-fG);
        } else {
            if (fG <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f15769b.getInterpolation(fG);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    public final void i() {
        if (this.f15780r) {
            this.f15782t = false;
        } else {
            this.f15768a.i();
        }
    }

    public abstract void j(int i10, int i11);

    public a k(int i10) {
        this.f15775m = i10;
        return this;
    }

    public a l(int i10) {
        this.f15774l = i10;
        return this;
    }

    public a m(boolean z10) {
        if (this.f15783u && !z10) {
            i();
        }
        this.f15783u = z10;
        return this;
    }

    public a n(float f10, float f11) {
        float[] fArr = this.f15773f;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a o(float f10, float f11) {
        float[] fArr = this.f15778p;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f15783u) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                i();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    i();
                }
            }
            return this.f15784v && this.f15782t;
        }
        this.f15781s = true;
        this.f15779q = false;
        this.f15768a.l(d(0, motionEvent.getX(), view.getWidth(), this.f15770c.getWidth()), d(1, motionEvent.getY(), view.getHeight(), this.f15770c.getHeight()));
        if (!this.f15782t && u()) {
            v();
        }
        if (this.f15784v) {
            return false;
        }
    }

    public a p(float f10, float f11) {
        float[] fArr = this.f15777o;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    public a q(int i10) {
        this.f15768a.j(i10);
        return this;
    }

    public a r(int i10) {
        this.f15768a.k(i10);
        return this;
    }

    public a s(float f10, float f11) {
        float[] fArr = this.f15772e;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a t(float f10, float f11) {
        float[] fArr = this.f15776n;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    public boolean u() {
        C0285a c0285a = this.f15768a;
        int iF = c0285a.f();
        int iD = c0285a.d();
        return (iF != 0 && b(iF)) || (iD != 0 && a(iD));
    }

    public final void v() {
        int i10;
        if (this.f15771d == null) {
            this.f15771d = new b();
        }
        this.f15782t = true;
        this.f15780r = true;
        if (this.f15779q || (i10 = this.f15775m) <= 0) {
            this.f15771d.run();
        } else {
            p0.i0(this.f15770c, this.f15771d, i10);
        }
        this.f15779q = true;
    }
}
