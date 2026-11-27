package p0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f13935a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h0.g f13936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h0.g f13937b;

        public a(WindowInsetsAnimation.Bounds bounds) {
            this.f13936a = d.g(bounds);
            this.f13937b = d.f(bounds);
        }

        public a(h0.g gVar, h0.g gVar2) {
            this.f13936a = gVar;
            this.f13937b = gVar2;
        }

        public static a d(WindowInsetsAnimation.Bounds bounds) {
            return new a(bounds);
        }

        public h0.g a() {
            return this.f13936a;
        }

        public h0.g b() {
            return this.f13937b;
        }

        public WindowInsetsAnimation.Bounds c() {
            return d.e(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.f13936a + " upper=" + this.f13937b + "}";
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WindowInsets f13938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13939b;

        public b(int i10) {
            this.f13939b = i10;
        }

        public final int a() {
            return this.f13939b;
        }

        public abstract void b(b2 b2Var);

        public abstract void c(b2 b2Var);

        public abstract k2 d(k2 k2Var, List<b2> list);

        public abstract a e(b2 b2Var, a aVar);
    }

    public static class c extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Interpolator f13940e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Interpolator f13941f = new k1.a();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Interpolator f13942g = new DecelerateInterpolator();

        public static class a implements View.OnApplyWindowInsetsListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f13943a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public k2 f13944b;

            /* JADX INFO: renamed from: p0.b2$c$a$a, reason: collision with other inner class name */
            public class C0242a implements ValueAnimator.AnimatorUpdateListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ b2 f13945a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ k2 f13946b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ k2 f13947c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ int f13948d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public final /* synthetic */ View f13949e;

                public C0242a(b2 b2Var, k2 k2Var, k2 k2Var2, int i10, View view) {
                    this.f13945a = b2Var;
                    this.f13946b = k2Var;
                    this.f13947c = k2Var2;
                    this.f13948d = i10;
                    this.f13949e = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f13945a.e(valueAnimator.getAnimatedFraction());
                    c.k(this.f13949e, c.o(this.f13946b, this.f13947c, this.f13945a.b(), this.f13948d), Collections.singletonList(this.f13945a));
                }
            }

            public class b extends AnimatorListenerAdapter {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ b2 f13951a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ View f13952b;

                public b(b2 b2Var, View view) {
                    this.f13951a = b2Var;
                    this.f13952b = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    this.f13951a.e(1.0f);
                    c.i(this.f13952b, this.f13951a);
                }
            }

            /* JADX INFO: renamed from: p0.b2$c$a$c, reason: collision with other inner class name */
            public class RunnableC0243c implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ View f13954a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b2 f13955b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ a f13956c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ ValueAnimator f13957d;

                public RunnableC0243c(View view, b2 b2Var, a aVar, ValueAnimator valueAnimator) {
                    this.f13954a = view;
                    this.f13955b = b2Var;
                    this.f13956c = aVar;
                    this.f13957d = valueAnimator;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.l(this.f13954a, this.f13955b, this.f13956c);
                    this.f13957d.start();
                }
            }

            public a(View view, b bVar) {
                this.f13943a = bVar;
                k2 k2VarH = p0.H(view);
                this.f13944b = k2VarH != null ? new k2.b(k2VarH).a() : null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                int iE;
                if (view.isLaidOut()) {
                    k2 k2VarV = k2.v(windowInsets, view);
                    if (this.f13944b == null) {
                        this.f13944b = p0.H(view);
                    }
                    if (this.f13944b != null) {
                        b bVarN = c.n(view);
                        if ((bVarN == null || !Objects.equals(bVarN.f13938a, windowInsets)) && (iE = c.e(k2VarV, this.f13944b)) != 0) {
                            k2 k2Var = this.f13944b;
                            b2 b2Var = new b2(iE, c.g(iE, k2VarV, k2Var), 160L);
                            b2Var.e(0.0f);
                            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(b2Var.a());
                            a aVarF = c.f(k2VarV, k2Var, iE);
                            c.j(view, b2Var, windowInsets, false);
                            duration.addUpdateListener(new C0242a(b2Var, k2VarV, k2Var, iE, view));
                            duration.addListener(new b(b2Var, view));
                            i0.a(view, new RunnableC0243c(view, b2Var, aVarF, duration));
                        }
                        return c.m(view, windowInsets);
                    }
                    this.f13944b = k2VarV;
                } else {
                    this.f13944b = k2.v(windowInsets, view);
                }
                return c.m(view, windowInsets);
            }
        }

        public c(int i10, Interpolator interpolator, long j10) {
            super(i10, interpolator, j10);
        }

        public static int e(k2 k2Var, k2 k2Var2) {
            int i10 = 0;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if (!k2Var.f(i11).equals(k2Var2.f(i11))) {
                    i10 |= i11;
                }
            }
            return i10;
        }

        public static a f(k2 k2Var, k2 k2Var2, int i10) {
            h0.g gVarF = k2Var.f(i10);
            h0.g gVarF2 = k2Var2.f(i10);
            return new a(h0.g.b(Math.min(gVarF.f9552a, gVarF2.f9552a), Math.min(gVarF.f9553b, gVarF2.f9553b), Math.min(gVarF.f9554c, gVarF2.f9554c), Math.min(gVarF.f9555d, gVarF2.f9555d)), h0.g.b(Math.max(gVarF.f9552a, gVarF2.f9552a), Math.max(gVarF.f9553b, gVarF2.f9553b), Math.max(gVarF.f9554c, gVarF2.f9554c), Math.max(gVarF.f9555d, gVarF2.f9555d)));
        }

        public static Interpolator g(int i10, k2 k2Var, k2 k2Var2) {
            if ((i10 & 8) != 0) {
                return k2Var.f(k2.m.c()).f9555d > k2Var2.f(k2.m.c()).f9555d ? f13940e : f13941f;
            }
            return f13942g;
        }

        public static View.OnApplyWindowInsetsListener h(View view, b bVar) {
            return new a(view, bVar);
        }

        public static void i(View view, b2 b2Var) {
            b bVarN = n(view);
            if (bVarN != null) {
                bVarN.b(b2Var);
                if (bVarN.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    i(viewGroup.getChildAt(i10), b2Var);
                }
            }
        }

        public static void j(View view, b2 b2Var, WindowInsets windowInsets, boolean z10) {
            b bVarN = n(view);
            if (bVarN != null) {
                bVarN.f13938a = windowInsets;
                if (!z10) {
                    bVarN.c(b2Var);
                    z10 = bVarN.a() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    j(viewGroup.getChildAt(i10), b2Var, windowInsets, z10);
                }
            }
        }

        public static void k(View view, k2 k2Var, List<b2> list) {
            b bVarN = n(view);
            if (bVarN != null) {
                k2Var = bVarN.d(k2Var, list);
                if (bVarN.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    k(viewGroup.getChildAt(i10), k2Var, list);
                }
            }
        }

        public static void l(View view, b2 b2Var, a aVar) {
            b bVarN = n(view);
            if (bVarN != null) {
                bVarN.e(b2Var, aVar);
                if (bVarN.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    l(viewGroup.getChildAt(i10), b2Var, aVar);
                }
            }
        }

        public static WindowInsets m(View view, WindowInsets windowInsets) {
            return view.getTag(d0.e.L) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        public static b n(View view) {
            Object tag = view.getTag(d0.e.S);
            if (tag instanceof a) {
                return ((a) tag).f13943a;
            }
            return null;
        }

        public static k2 o(k2 k2Var, k2 k2Var2, float f10, int i10) {
            h0.g gVarM;
            k2.b bVar = new k2.b(k2Var);
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) == 0) {
                    gVarM = k2Var.f(i11);
                } else {
                    h0.g gVarF = k2Var.f(i11);
                    h0.g gVarF2 = k2Var2.f(i11);
                    float f11 = 1.0f - f10;
                    gVarM = k2.m(gVarF, (int) (((double) ((gVarF.f9552a - gVarF2.f9552a) * f11)) + 0.5d), (int) (((double) ((gVarF.f9553b - gVarF2.f9553b) * f11)) + 0.5d), (int) (((double) ((gVarF.f9554c - gVarF2.f9554c) * f11)) + 0.5d), (int) (((double) ((gVarF.f9555d - gVarF2.f9555d) * f11)) + 0.5d));
                }
                bVar.b(i11, gVarM);
            }
            return bVar.a();
        }

        public static void p(View view, b bVar) {
            Object tag = view.getTag(d0.e.L);
            if (bVar == null) {
                view.setTag(d0.e.S, null);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener(null);
                    return;
                }
                return;
            }
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListenerH = h(view, bVar);
            view.setTag(d0.e.S, onApplyWindowInsetsListenerH);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListenerH);
            }
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final WindowInsetsAnimation f13959e;

        public static class a extends WindowInsetsAnimation.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f13960a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public List<b2> f13961b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public ArrayList<b2> f13962c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final HashMap<WindowInsetsAnimation, b2> f13963d;

            public a(b bVar) {
                super(bVar.a());
                this.f13963d = new HashMap<>();
                this.f13960a = bVar;
            }

            public final b2 a(WindowInsetsAnimation windowInsetsAnimation) {
                b2 b2Var = this.f13963d.get(windowInsetsAnimation);
                if (b2Var != null) {
                    return b2Var;
                }
                b2 b2VarF = b2.f(windowInsetsAnimation);
                this.f13963d.put(windowInsetsAnimation, b2VarF);
                return b2VarF;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.f13960a.b(a(windowInsetsAnimation));
                this.f13963d.remove(windowInsetsAnimation);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.f13960a.c(a(windowInsetsAnimation));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
                ArrayList<b2> arrayList = this.f13962c;
                if (arrayList == null) {
                    ArrayList<b2> arrayList2 = new ArrayList<>(list.size());
                    this.f13962c = arrayList2;
                    this.f13961b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimation = list.get(size);
                    b2 b2VarA = a(windowInsetsAnimation);
                    b2VarA.e(windowInsetsAnimation.getFraction());
                    this.f13962c.add(b2VarA);
                }
                return this.f13960a.d(k2.u(windowInsets), this.f13961b).t();
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.f13960a.e(a(windowInsetsAnimation), a.d(bounds)).c();
            }
        }

        public d(int i10, Interpolator interpolator, long j10) {
            this(new WindowInsetsAnimation(i10, interpolator, j10));
        }

        public d(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.f13959e = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds e(a aVar) {
            return new WindowInsetsAnimation.Bounds(aVar.a().e(), aVar.b().e());
        }

        public static h0.g f(WindowInsetsAnimation.Bounds bounds) {
            return h0.g.d(bounds.getUpperBound());
        }

        public static h0.g g(WindowInsetsAnimation.Bounds bounds) {
            return h0.g.d(bounds.getLowerBound());
        }

        public static void h(View view, b bVar) {
            view.setWindowInsetsAnimationCallback(bVar != null ? new a(bVar) : null);
        }

        @Override // p0.b2.e
        public long a() {
            return this.f13959e.getDurationMillis();
        }

        @Override // p0.b2.e
        public float b() {
            return this.f13959e.getInterpolatedFraction();
        }

        @Override // p0.b2.e
        public int c() {
            return this.f13959e.getTypeMask();
        }

        @Override // p0.b2.e
        public void d(float f10) {
            this.f13959e.setFraction(f10);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f13965b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Interpolator f13966c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f13967d;

        public e(int i10, Interpolator interpolator, long j10) {
            this.f13964a = i10;
            this.f13966c = interpolator;
            this.f13967d = j10;
        }

        public long a() {
            return this.f13967d;
        }

        public float b() {
            Interpolator interpolator = this.f13966c;
            return interpolator != null ? interpolator.getInterpolation(this.f13965b) : this.f13965b;
        }

        public int c() {
            return this.f13964a;
        }

        public void d(float f10) {
            this.f13965b = f10;
        }
    }

    public b2(int i10, Interpolator interpolator, long j10) {
        this.f13935a = Build.VERSION.SDK_INT >= 30 ? new d(i10, interpolator, j10) : new c(i10, interpolator, j10);
    }

    public b2(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f13935a = new d(windowInsetsAnimation);
        }
    }

    public static void d(View view, b bVar) {
        if (Build.VERSION.SDK_INT >= 30) {
            d.h(view, bVar);
        } else {
            c.p(view, bVar);
        }
    }

    public static b2 f(WindowInsetsAnimation windowInsetsAnimation) {
        return new b2(windowInsetsAnimation);
    }

    public long a() {
        return this.f13935a.a();
    }

    public float b() {
        return this.f13935a.b();
    }

    public int c() {
        return this.f13935a.c();
    }

    public void e(float f10) {
        this.f13935a.d(f10);
    }
}
