package i1;

import android.view.ViewGroup;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f10376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClassLoader f10377b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10381f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10383h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10384i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f10386k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10387l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f10388m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10389n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f10390o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList<String> f10391p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList<String> f10392q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ArrayList<Runnable> f10394s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<a> f10378c = new ArrayList<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10385j = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f10393r = false;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p f10396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f10398d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f10399e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f10400f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f10401g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public androidx.lifecycle.g.b f10402h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public androidx.lifecycle.g.b f10403i;

        public a() {
        }

        public a(int i10, p pVar) {
            this.f10395a = i10;
            this.f10396b = pVar;
            this.f10397c = false;
            androidx.lifecycle.g.b bVar = androidx.lifecycle.g.b.RESUMED;
            this.f10402h = bVar;
            this.f10403i = bVar;
        }

        public a(int i10, p pVar, boolean z10) {
            this.f10395a = i10;
            this.f10396b = pVar;
            this.f10397c = z10;
            androidx.lifecycle.g.b bVar = androidx.lifecycle.g.b.RESUMED;
            this.f10402h = bVar;
            this.f10403i = bVar;
        }
    }

    public p0(y yVar, ClassLoader classLoader) {
        this.f10376a = yVar;
        this.f10377b = classLoader;
    }

    public p0 b(int i10, p pVar, String str) {
        k(i10, pVar, str, 1);
        return this;
    }

    public p0 c(ViewGroup viewGroup, p pVar, String str) {
        pVar.N = viewGroup;
        return b(viewGroup.getId(), pVar, str);
    }

    public p0 d(p pVar, String str) {
        k(0, pVar, str, 1);
        return this;
    }

    public void e(a aVar) {
        this.f10378c.add(aVar);
        aVar.f10398d = this.f10379d;
        aVar.f10399e = this.f10380e;
        aVar.f10400f = this.f10381f;
        aVar.f10401g = this.f10382g;
    }

    public abstract int f();

    public abstract int g();

    public abstract void h();

    public abstract void i();

    public p0 j() {
        if (this.f10384i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f10385j = false;
        return this;
    }

    public void k(int i10, p pVar, String str, int i11) {
        String str2 = pVar.X;
        if (str2 != null) {
            j1.c.f(pVar, str2);
        }
        Class<?> cls = pVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = pVar.F;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + pVar + ": was " + pVar.F + " now " + str);
            }
            pVar.F = str;
        }
        if (i10 != 0) {
            if (i10 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + pVar + " with tag " + str + " to container view with no id");
            }
            int i12 = pVar.D;
            if (i12 != 0 && i12 != i10) {
                throw new IllegalStateException("Can't change container ID of fragment " + pVar + ": was " + pVar.D + " now " + i10);
            }
            pVar.D = i10;
            pVar.E = i10;
        }
        e(new a(i11, pVar));
    }

    public p0 l(p pVar) {
        e(new a(3, pVar));
        return this;
    }

    public p0 m(int i10, p pVar) {
        return n(i10, pVar, null);
    }

    public p0 n(int i10, p pVar, String str) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        k(i10, pVar, str, 2);
        return this;
    }

    public p0 o(boolean z10) {
        this.f10393r = z10;
        return this;
    }
}
