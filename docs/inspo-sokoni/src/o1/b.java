package o1;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.i0;
import androidx.lifecycle.k;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import t.h;

/* JADX INFO: loaded from: classes.dex */
public class b extends o1.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f13615c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f13616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f13617b;

    public static class a<D> extends q<D> implements p1.b.a<D> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f13618l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Bundle f13619m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final p1.b<D> f13620n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public k f13621o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public C0234b<D> f13622p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public p1.b<D> f13623q;

        public a(int i10, Bundle bundle, p1.b<D> bVar, p1.b<D> bVar2) {
            this.f13618l = i10;
            this.f13619m = bundle;
            this.f13620n = bVar;
            this.f13623q = bVar2;
            bVar.q(i10, this);
        }

        @Override // p1.b.a
        public void a(p1.b<D> bVar, D d10) {
            if (b.f13615c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                n(d10);
                return;
            }
            if (b.f13615c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            l(d10);
        }

        @Override // androidx.lifecycle.o
        public void j() {
            if (b.f13615c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f13620n.t();
        }

        @Override // androidx.lifecycle.o
        public void k() {
            if (b.f13615c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f13620n.u();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.o
        public void m(r<? super D> rVar) {
            super.m(rVar);
            this.f13621o = null;
            this.f13622p = null;
        }

        @Override // androidx.lifecycle.q, androidx.lifecycle.o
        public void n(D d10) {
            super.n(d10);
            p1.b<D> bVar = this.f13623q;
            if (bVar != null) {
                bVar.r();
                this.f13623q = null;
            }
        }

        public p1.b<D> o(boolean z10) {
            if (b.f13615c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f13620n.b();
            this.f13620n.a();
            C0234b<D> c0234b = this.f13622p;
            if (c0234b != null) {
                m(c0234b);
                if (z10) {
                    c0234b.d();
                }
            }
            this.f13620n.v(this);
            if ((c0234b == null || c0234b.c()) && !z10) {
                return this.f13620n;
            }
            this.f13620n.r();
            return this.f13623q;
        }

        public void p(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f13618l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f13619m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f13620n);
            this.f13620n.g(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f13622p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f13622p);
                this.f13622p.b(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(q().d(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(g());
        }

        public p1.b<D> q() {
            return this.f13620n;
        }

        public void r() {
            k kVar = this.f13621o;
            C0234b<D> c0234b = this.f13622p;
            if (kVar == null || c0234b == null) {
                return;
            }
            super.m(c0234b);
            h(kVar, c0234b);
        }

        public p1.b<D> s(k kVar, o1.a.InterfaceC0233a<D> interfaceC0233a) {
            C0234b<D> c0234b = new C0234b<>(this.f13620n, interfaceC0233a);
            h(kVar, c0234b);
            C0234b<D> c0234b2 = this.f13622p;
            if (c0234b2 != null) {
                m(c0234b2);
            }
            this.f13621o = kVar;
            this.f13622p = c0234b;
            return this.f13620n;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("LoaderInfo{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" #");
            sb2.append(this.f13618l);
            sb2.append(" : ");
            o0.b.a(this.f13620n, sb2);
            sb2.append("}}");
            return sb2.toString();
        }
    }

    /* JADX INFO: renamed from: o1.b$b, reason: collision with other inner class name */
    public static class C0234b<D> implements r<D> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p1.b<D> f13624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o1.a.InterfaceC0233a<D> f13625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f13626c = false;

        public C0234b(p1.b<D> bVar, o1.a.InterfaceC0233a<D> interfaceC0233a) {
            this.f13624a = bVar;
            this.f13625b = interfaceC0233a;
        }

        @Override // androidx.lifecycle.r
        public void a(D d10) {
            if (b.f13615c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f13624a + ": " + this.f13624a.d(d10));
            }
            this.f13625b.c(this.f13624a, d10);
            this.f13626c = true;
        }

        public void b(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f13626c);
        }

        public boolean c() {
            return this.f13626c;
        }

        public void d() {
            if (this.f13626c) {
                if (b.f13615c) {
                    Log.v("LoaderManager", "  Resetting: " + this.f13624a);
                }
                this.f13625b.a(this.f13624a);
            }
        }

        public String toString() {
            return this.f13625b.toString();
        }
    }

    public static class c extends f0 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final g0.b f13627f = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public h<a> f13628d = new h<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f13629e = false;

        public static class a implements g0.b {
            @Override // androidx.lifecycle.g0.b
            public <T extends f0> T a(Class<T> cls) {
                return new c();
            }
        }

        public static c f(i0 i0Var) {
            return (c) new g0(i0Var, f13627f).a(c.class);
        }

        @Override // androidx.lifecycle.f0
        public void c() {
            super.c();
            int iL = this.f13628d.l();
            for (int i10 = 0; i10 < iL; i10++) {
                this.f13628d.m(i10).o(true);
            }
            this.f13628d.b();
        }

        public void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f13628d.l() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i10 = 0; i10 < this.f13628d.l(); i10++) {
                    a aVarM = this.f13628d.m(i10);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f13628d.i(i10));
                    printWriter.print(": ");
                    printWriter.println(aVarM.toString());
                    aVarM.p(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void e() {
            this.f13629e = false;
        }

        public <D> a<D> g(int i10) {
            return this.f13628d.f(i10);
        }

        public boolean h() {
            return this.f13629e;
        }

        public void i() {
            int iL = this.f13628d.l();
            for (int i10 = 0; i10 < iL; i10++) {
                this.f13628d.m(i10).r();
            }
        }

        public void j(int i10, a aVar) {
            this.f13628d.j(i10, aVar);
        }

        public void k() {
            this.f13629e = true;
        }
    }

    public b(k kVar, i0 i0Var) {
        this.f13616a = kVar;
        this.f13617b = c.f(i0Var);
    }

    @Override // o1.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f13617b.d(str, fileDescriptor, printWriter, strArr);
    }

    @Override // o1.a
    public <D> p1.b<D> c(int i10, Bundle bundle, o1.a.InterfaceC0233a<D> interfaceC0233a) {
        if (this.f13617b.h()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        a<D> aVarG = this.f13617b.g(i10);
        if (f13615c) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (aVarG == null) {
            return e(i10, bundle, interfaceC0233a, null);
        }
        if (f13615c) {
            Log.v("LoaderManager", "  Re-using existing loader " + aVarG);
        }
        return aVarG.s(this.f13616a, interfaceC0233a);
    }

    @Override // o1.a
    public void d() {
        this.f13617b.i();
    }

    public final <D> p1.b<D> e(int i10, Bundle bundle, o1.a.InterfaceC0233a<D> interfaceC0233a, p1.b<D> bVar) {
        try {
            this.f13617b.k();
            p1.b<D> bVarB = interfaceC0233a.b(i10, bundle);
            if (bVarB == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (bVarB.getClass().isMemberClass() && !Modifier.isStatic(bVarB.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + bVarB);
            }
            a aVar = new a(i10, bundle, bVarB, bVar);
            if (f13615c) {
                Log.v("LoaderManager", "  Created new loader " + aVar);
            }
            this.f13617b.j(i10, aVar);
            this.f13617b.e();
            return aVar.s(this.f13616a, interfaceC0233a);
        } catch (Throwable th) {
            this.f13617b.e();
            throw th;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        o0.b.a(this.f13616a, sb2);
        sb2.append("}}");
        return sb2.toString();
    }
}
