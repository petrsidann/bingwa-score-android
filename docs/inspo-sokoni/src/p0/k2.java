package p0;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class k2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k2 f14000b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f14001a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Field f14002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Field f14003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Field f14004c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static boolean f14005d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f14002a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f14003b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f14004c = declaredField3;
                declaredField3.setAccessible(true);
                f14005d = true;
            } catch (ReflectiveOperationException e10) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e10.getMessage(), e10);
            }
        }

        public static k2 a(View view) {
            if (f14005d && view.isAttachedToWindow()) {
                try {
                    Object obj = f14002a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f14003b.get(obj);
                        Rect rect2 = (Rect) f14004c.get(obj);
                        if (rect != null && rect2 != null) {
                            k2 k2VarA = new b().c(h0.g.c(rect)).d(h0.g.c(rect2)).a();
                            k2VarA.r(k2VarA);
                            k2VarA.d(view.getRootView());
                            return k2VarA;
                        }
                    }
                } catch (IllegalAccessException e10) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e10.getMessage(), e10);
                }
            }
            return null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f14006a;

        public b() {
            int i10 = Build.VERSION.SDK_INT;
            this.f14006a = i10 >= 30 ? new e() : i10 >= 29 ? new d() : new c();
        }

        public b(k2 k2Var) {
            int i10 = Build.VERSION.SDK_INT;
            this.f14006a = i10 >= 30 ? new e(k2Var) : i10 >= 29 ? new d(k2Var) : new c(k2Var);
        }

        public k2 a() {
            return this.f14006a.b();
        }

        public b b(int i10, h0.g gVar) {
            this.f14006a.c(i10, gVar);
            return this;
        }

        @Deprecated
        public b c(h0.g gVar) {
            this.f14006a.e(gVar);
            return this;
        }

        @Deprecated
        public b d(h0.g gVar) {
            this.f14006a.g(gVar);
            return this;
        }
    }

    public static class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static Field f14007e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static boolean f14008f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static Constructor<WindowInsets> f14009g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static boolean f14010h = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WindowInsets f14011c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public h0.g f14012d;

        public c() {
            this.f14011c = i();
        }

        public c(k2 k2Var) {
            super(k2Var);
            this.f14011c = k2Var.t();
        }

        private static WindowInsets i() {
            if (!f14008f) {
                try {
                    f14007e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e10) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e10);
                }
                f14008f = true;
            }
            Field field = f14007e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e11) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e11);
                }
            }
            if (!f14010h) {
                try {
                    f14009g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e12) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e12);
                }
                f14010h = true;
            }
            Constructor<WindowInsets> constructor = f14009g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e13) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e13);
                }
            }
            return null;
        }

        @Override // p0.k2.f
        public k2 b() {
            a();
            k2 k2VarU = k2.u(this.f14011c);
            k2VarU.p(this.f14015b);
            k2VarU.s(this.f14012d);
            return k2VarU;
        }

        @Override // p0.k2.f
        public void e(h0.g gVar) {
            this.f14012d = gVar;
        }

        @Override // p0.k2.f
        public void g(h0.g gVar) {
            WindowInsets windowInsets = this.f14011c;
            if (windowInsets != null) {
                this.f14011c = windowInsets.replaceSystemWindowInsets(gVar.f9552a, gVar.f9553b, gVar.f9554c, gVar.f9555d);
            }
        }
    }

    public static class d extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets.Builder f14013c;

        public d() {
            this.f14013c = new WindowInsets.Builder();
        }

        public d(k2 k2Var) {
            super(k2Var);
            WindowInsets windowInsetsT = k2Var.t();
            this.f14013c = windowInsetsT != null ? new WindowInsets.Builder(windowInsetsT) : new WindowInsets.Builder();
        }

        @Override // p0.k2.f
        public k2 b() {
            a();
            k2 k2VarU = k2.u(this.f14013c.build());
            k2VarU.p(this.f14015b);
            return k2VarU;
        }

        @Override // p0.k2.f
        public void d(h0.g gVar) {
            this.f14013c.setMandatorySystemGestureInsets(gVar.e());
        }

        @Override // p0.k2.f
        public void e(h0.g gVar) {
            this.f14013c.setStableInsets(gVar.e());
        }

        @Override // p0.k2.f
        public void f(h0.g gVar) {
            this.f14013c.setSystemGestureInsets(gVar.e());
        }

        @Override // p0.k2.f
        public void g(h0.g gVar) {
            this.f14013c.setSystemWindowInsets(gVar.e());
        }

        @Override // p0.k2.f
        public void h(h0.g gVar) {
            this.f14013c.setTappableElementInsets(gVar.e());
        }
    }

    public static class e extends d {
        public e() {
        }

        public e(k2 k2Var) {
            super(k2Var);
        }

        @Override // p0.k2.f
        public void c(int i10, h0.g gVar) {
            this.f14013c.setInsets(n.a(i10), gVar.e());
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k2 f14014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h0.g[] f14015b;

        public f() {
            this(new k2((k2) null));
        }

        public f(k2 k2Var) {
            this.f14014a = k2Var;
        }

        public final void a() {
            h0.g[] gVarArr = this.f14015b;
            if (gVarArr != null) {
                h0.g gVarF = gVarArr[m.d(1)];
                h0.g gVarF2 = this.f14015b[m.d(2)];
                if (gVarF2 == null) {
                    gVarF2 = this.f14014a.f(2);
                }
                if (gVarF == null) {
                    gVarF = this.f14014a.f(1);
                }
                g(h0.g.a(gVarF, gVarF2));
                h0.g gVar = this.f14015b[m.d(16)];
                if (gVar != null) {
                    f(gVar);
                }
                h0.g gVar2 = this.f14015b[m.d(32)];
                if (gVar2 != null) {
                    d(gVar2);
                }
                h0.g gVar3 = this.f14015b[m.d(64)];
                if (gVar3 != null) {
                    h(gVar3);
                }
            }
        }

        public k2 b() {
            throw null;
        }

        public void c(int i10, h0.g gVar) {
            if (this.f14015b == null) {
                this.f14015b = new h0.g[9];
            }
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    this.f14015b[m.d(i11)] = gVar;
                }
            }
        }

        public void d(h0.g gVar) {
        }

        public void e(h0.g gVar) {
            throw null;
        }

        public void f(h0.g gVar) {
        }

        public void g(h0.g gVar) {
            throw null;
        }

        public void h(h0.g gVar) {
        }
    }

    public static class g extends l {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static boolean f14016h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static Method f14017i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static Class<?> f14018j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static Field f14019k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static Field f14020l;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets f14021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public h0.g[] f14022d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public h0.g f14023e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public k2 f14024f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public h0.g f14025g;

        public g(k2 k2Var, WindowInsets windowInsets) {
            super(k2Var);
            this.f14023e = null;
            this.f14021c = windowInsets;
        }

        public g(k2 k2Var, g gVar) {
            this(k2Var, new WindowInsets(gVar.f14021c));
        }

        private h0.g t(int i10, boolean z10) {
            h0.g gVarA = h0.g.f9551e;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    gVarA = h0.g.a(gVarA, u(i11, z10));
                }
            }
            return gVarA;
        }

        private h0.g v() {
            k2 k2Var = this.f14024f;
            return k2Var != null ? k2Var.g() : h0.g.f9551e;
        }

        private h0.g w(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f14016h) {
                x();
            }
            Method method = f14017i;
            if (method != null && f14018j != null && f14019k != null) {
                try {
                    Object objInvoke = method.invoke(view, new Object[0]);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f14019k.get(f14020l.get(objInvoke));
                    if (rect != null) {
                        return h0.g.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e10) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
                }
            }
            return null;
        }

        private static void x() {
            try {
                f14017i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f14018j = cls;
                f14019k = cls.getDeclaredField("mVisibleInsets");
                f14020l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f14019k.setAccessible(true);
                f14020l.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
            }
            f14016h = true;
        }

        @Override // p0.k2.l
        public void d(View view) {
            h0.g gVarW = w(view);
            if (gVarW == null) {
                gVarW = h0.g.f9551e;
            }
            q(gVarW);
        }

        @Override // p0.k2.l
        public void e(k2 k2Var) {
            k2Var.r(this.f14024f);
            k2Var.q(this.f14025g);
        }

        @Override // p0.k2.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f14025g, ((g) obj).f14025g);
            }
            return false;
        }

        @Override // p0.k2.l
        public h0.g g(int i10) {
            return t(i10, false);
        }

        @Override // p0.k2.l
        public final h0.g k() {
            if (this.f14023e == null) {
                this.f14023e = h0.g.b(this.f14021c.getSystemWindowInsetLeft(), this.f14021c.getSystemWindowInsetTop(), this.f14021c.getSystemWindowInsetRight(), this.f14021c.getSystemWindowInsetBottom());
            }
            return this.f14023e;
        }

        @Override // p0.k2.l
        public k2 m(int i10, int i11, int i12, int i13) {
            b bVar = new b(k2.u(this.f14021c));
            bVar.d(k2.m(k(), i10, i11, i12, i13));
            bVar.c(k2.m(i(), i10, i11, i12, i13));
            return bVar.a();
        }

        @Override // p0.k2.l
        public boolean o() {
            return this.f14021c.isRound();
        }

        @Override // p0.k2.l
        public void p(h0.g[] gVarArr) {
            this.f14022d = gVarArr;
        }

        @Override // p0.k2.l
        public void q(h0.g gVar) {
            this.f14025g = gVar;
        }

        @Override // p0.k2.l
        public void r(k2 k2Var) {
            this.f14024f = k2Var;
        }

        public h0.g u(int i10, boolean z10) {
            h0.g gVarG;
            int i11;
            if (i10 == 1) {
                return z10 ? h0.g.b(0, Math.max(v().f9553b, k().f9553b), 0, 0) : h0.g.b(0, k().f9553b, 0, 0);
            }
            if (i10 == 2) {
                if (z10) {
                    h0.g gVarV = v();
                    h0.g gVarI = i();
                    return h0.g.b(Math.max(gVarV.f9552a, gVarI.f9552a), 0, Math.max(gVarV.f9554c, gVarI.f9554c), Math.max(gVarV.f9555d, gVarI.f9555d));
                }
                h0.g gVarK = k();
                k2 k2Var = this.f14024f;
                gVarG = k2Var != null ? k2Var.g() : null;
                int iMin = gVarK.f9555d;
                if (gVarG != null) {
                    iMin = Math.min(iMin, gVarG.f9555d);
                }
                return h0.g.b(gVarK.f9552a, 0, gVarK.f9554c, iMin);
            }
            if (i10 != 8) {
                if (i10 == 16) {
                    return j();
                }
                if (i10 == 32) {
                    return h();
                }
                if (i10 == 64) {
                    return l();
                }
                if (i10 != 128) {
                    return h0.g.f9551e;
                }
                k2 k2Var2 = this.f14024f;
                q qVarE = k2Var2 != null ? k2Var2.e() : f();
                return qVarE != null ? h0.g.b(qVarE.b(), qVarE.d(), qVarE.c(), qVarE.a()) : h0.g.f9551e;
            }
            h0.g[] gVarArr = this.f14022d;
            gVarG = gVarArr != null ? gVarArr[m.d(8)] : null;
            if (gVarG != null) {
                return gVarG;
            }
            h0.g gVarK2 = k();
            h0.g gVarV2 = v();
            int i12 = gVarK2.f9555d;
            if (i12 > gVarV2.f9555d) {
                return h0.g.b(0, 0, 0, i12);
            }
            h0.g gVar = this.f14025g;
            return (gVar == null || gVar.equals(h0.g.f9551e) || (i11 = this.f14025g.f9555d) <= gVarV2.f9555d) ? h0.g.f9551e : h0.g.b(0, 0, 0, i11);
        }
    }

    public static class h extends g {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public h0.g f14026m;

        public h(k2 k2Var, WindowInsets windowInsets) {
            super(k2Var, windowInsets);
            this.f14026m = null;
        }

        public h(k2 k2Var, h hVar) {
            super(k2Var, hVar);
            this.f14026m = null;
            this.f14026m = hVar.f14026m;
        }

        @Override // p0.k2.l
        public k2 b() {
            return k2.u(this.f14021c.consumeStableInsets());
        }

        @Override // p0.k2.l
        public k2 c() {
            return k2.u(this.f14021c.consumeSystemWindowInsets());
        }

        @Override // p0.k2.l
        public final h0.g i() {
            if (this.f14026m == null) {
                this.f14026m = h0.g.b(this.f14021c.getStableInsetLeft(), this.f14021c.getStableInsetTop(), this.f14021c.getStableInsetRight(), this.f14021c.getStableInsetBottom());
            }
            return this.f14026m;
        }

        @Override // p0.k2.l
        public boolean n() {
            return this.f14021c.isConsumed();
        }

        @Override // p0.k2.l
        public void s(h0.g gVar) {
            this.f14026m = gVar;
        }
    }

    public static class i extends h {
        public i(k2 k2Var, WindowInsets windowInsets) {
            super(k2Var, windowInsets);
        }

        public i(k2 k2Var, i iVar) {
            super(k2Var, iVar);
        }

        @Override // p0.k2.l
        public k2 a() {
            return k2.u(this.f14021c.consumeDisplayCutout());
        }

        @Override // p0.k2.g, p0.k2.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f14021c, iVar.f14021c) && Objects.equals(this.f14025g, iVar.f14025g);
        }

        @Override // p0.k2.l
        public q f() {
            return q.e(this.f14021c.getDisplayCutout());
        }

        @Override // p0.k2.l
        public int hashCode() {
            return this.f14021c.hashCode();
        }
    }

    public static class j extends i {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public h0.g f14027n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public h0.g f14028o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public h0.g f14029p;

        public j(k2 k2Var, WindowInsets windowInsets) {
            super(k2Var, windowInsets);
            this.f14027n = null;
            this.f14028o = null;
            this.f14029p = null;
        }

        public j(k2 k2Var, j jVar) {
            super(k2Var, jVar);
            this.f14027n = null;
            this.f14028o = null;
            this.f14029p = null;
        }

        @Override // p0.k2.l
        public h0.g h() {
            if (this.f14028o == null) {
                this.f14028o = h0.g.d(this.f14021c.getMandatorySystemGestureInsets());
            }
            return this.f14028o;
        }

        @Override // p0.k2.l
        public h0.g j() {
            if (this.f14027n == null) {
                this.f14027n = h0.g.d(this.f14021c.getSystemGestureInsets());
            }
            return this.f14027n;
        }

        @Override // p0.k2.l
        public h0.g l() {
            if (this.f14029p == null) {
                this.f14029p = h0.g.d(this.f14021c.getTappableElementInsets());
            }
            return this.f14029p;
        }

        @Override // p0.k2.g, p0.k2.l
        public k2 m(int i10, int i11, int i12, int i13) {
            return k2.u(this.f14021c.inset(i10, i11, i12, i13));
        }

        @Override // p0.k2.h, p0.k2.l
        public void s(h0.g gVar) {
        }
    }

    public static class k extends j {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final k2 f14030q = k2.u(WindowInsets.CONSUMED);

        public k(k2 k2Var, WindowInsets windowInsets) {
            super(k2Var, windowInsets);
        }

        public k(k2 k2Var, k kVar) {
            super(k2Var, kVar);
        }

        @Override // p0.k2.g, p0.k2.l
        public final void d(View view) {
        }

        @Override // p0.k2.g, p0.k2.l
        public h0.g g(int i10) {
            return h0.g.d(this.f14021c.getInsets(n.a(i10)));
        }
    }

    public static class l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final k2 f14031b = new b().a().a().b().c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k2 f14032a;

        public l(k2 k2Var) {
            this.f14032a = k2Var;
        }

        public k2 a() {
            return this.f14032a;
        }

        public k2 b() {
            return this.f14032a;
        }

        public k2 c() {
            return this.f14032a;
        }

        public void d(View view) {
        }

        public void e(k2 k2Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return o() == lVar.o() && n() == lVar.n() && o0.c.a(k(), lVar.k()) && o0.c.a(i(), lVar.i()) && o0.c.a(f(), lVar.f());
        }

        public q f() {
            return null;
        }

        public h0.g g(int i10) {
            return h0.g.f9551e;
        }

        public h0.g h() {
            return k();
        }

        public int hashCode() {
            return o0.c.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        public h0.g i() {
            return h0.g.f9551e;
        }

        public h0.g j() {
            return k();
        }

        public h0.g k() {
            return h0.g.f9551e;
        }

        public h0.g l() {
            return k();
        }

        public k2 m(int i10, int i11, int i12, int i13) {
            return f14031b;
        }

        public boolean n() {
            return false;
        }

        public boolean o() {
            return false;
        }

        public void p(h0.g[] gVarArr) {
        }

        public void q(h0.g gVar) {
        }

        public void r(k2 k2Var) {
        }

        public void s(h0.g gVar) {
        }
    }

    public static final class m {
        public static int a() {
            return 4;
        }

        public static int b() {
            return 128;
        }

        public static int c() {
            return 8;
        }

        public static int d(int i10) {
            if (i10 == 1) {
                return 0;
            }
            if (i10 == 2) {
                return 1;
            }
            if (i10 == 4) {
                return 2;
            }
            if (i10 == 8) {
                return 3;
            }
            if (i10 == 16) {
                return 4;
            }
            if (i10 == 32) {
                return 5;
            }
            if (i10 == 64) {
                return 6;
            }
            if (i10 == 128) {
                return 7;
            }
            if (i10 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i10);
        }

        public static int e() {
            return 32;
        }

        public static int f() {
            return 2;
        }

        public static int g() {
            return 1;
        }

        public static int h() {
            return 7;
        }

        public static int i() {
            return 16;
        }

        public static int j() {
            return 64;
        }
    }

    public static final class n {
        public static int a(int i10) {
            int iStatusBars;
            int i11 = 0;
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i10 & i12) != 0) {
                    if (i12 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i12 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i12 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i12 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i12 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i12 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i12 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i12 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i11 |= iStatusBars;
                }
            }
            return i11;
        }
    }

    static {
        f14000b = Build.VERSION.SDK_INT >= 30 ? k.f14030q : l.f14031b;
    }

    public k2(WindowInsets windowInsets) {
        int i10 = Build.VERSION.SDK_INT;
        this.f14001a = i10 >= 30 ? new k(this, windowInsets) : i10 >= 29 ? new j(this, windowInsets) : i10 >= 28 ? new i(this, windowInsets) : new h(this, windowInsets);
    }

    public k2(k2 k2Var) {
        if (k2Var == null) {
            this.f14001a = new l(this);
            return;
        }
        l lVar = k2Var.f14001a;
        int i10 = Build.VERSION.SDK_INT;
        this.f14001a = (i10 < 30 || !(lVar instanceof k)) ? (i10 < 29 || !(lVar instanceof j)) ? (i10 < 28 || !(lVar instanceof i)) ? lVar instanceof h ? new h(this, (h) lVar) : lVar instanceof g ? new g(this, (g) lVar) : new l(this) : new i(this, (i) lVar) : new j(this, (j) lVar) : new k(this, (k) lVar);
        lVar.e(this);
    }

    public static h0.g m(h0.g gVar, int i10, int i11, int i12, int i13) {
        int iMax = Math.max(0, gVar.f9552a - i10);
        int iMax2 = Math.max(0, gVar.f9553b - i11);
        int iMax3 = Math.max(0, gVar.f9554c - i12);
        int iMax4 = Math.max(0, gVar.f9555d - i13);
        return (iMax == i10 && iMax2 == i11 && iMax3 == i12 && iMax4 == i13) ? gVar : h0.g.b(iMax, iMax2, iMax3, iMax4);
    }

    public static k2 u(WindowInsets windowInsets) {
        return v(windowInsets, null);
    }

    public static k2 v(WindowInsets windowInsets, View view) {
        k2 k2Var = new k2((WindowInsets) o0.h.g(windowInsets));
        if (view != null && p0.S(view)) {
            k2Var.r(p0.H(view));
            k2Var.d(view.getRootView());
        }
        return k2Var;
    }

    @Deprecated
    public k2 a() {
        return this.f14001a.a();
    }

    @Deprecated
    public k2 b() {
        return this.f14001a.b();
    }

    @Deprecated
    public k2 c() {
        return this.f14001a.c();
    }

    public void d(View view) {
        this.f14001a.d(view);
    }

    public q e() {
        return this.f14001a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k2) {
            return o0.c.a(this.f14001a, ((k2) obj).f14001a);
        }
        return false;
    }

    public h0.g f(int i10) {
        return this.f14001a.g(i10);
    }

    @Deprecated
    public h0.g g() {
        return this.f14001a.i();
    }

    @Deprecated
    public int h() {
        return this.f14001a.k().f9555d;
    }

    public int hashCode() {
        l lVar = this.f14001a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f14001a.k().f9552a;
    }

    @Deprecated
    public int j() {
        return this.f14001a.k().f9554c;
    }

    @Deprecated
    public int k() {
        return this.f14001a.k().f9553b;
    }

    public k2 l(int i10, int i11, int i12, int i13) {
        return this.f14001a.m(i10, i11, i12, i13);
    }

    public boolean n() {
        return this.f14001a.n();
    }

    @Deprecated
    public k2 o(int i10, int i11, int i12, int i13) {
        return new b(this).d(h0.g.b(i10, i11, i12, i13)).a();
    }

    public void p(h0.g[] gVarArr) {
        this.f14001a.p(gVarArr);
    }

    public void q(h0.g gVar) {
        this.f14001a.q(gVar);
    }

    public void r(k2 k2Var) {
        this.f14001a.r(k2Var);
    }

    public void s(h0.g gVar) {
        this.f14001a.s(gVar);
    }

    public WindowInsets t() {
        l lVar = this.f14001a;
        if (lVar instanceof g) {
            return ((g) lVar).f14021c;
        }
        return null;
    }
}
