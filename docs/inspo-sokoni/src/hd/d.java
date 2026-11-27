package hd;

import android.os.Handler;
import android.os.Looper;
import bd.h;
import gd.c1;
import gd.c2;
import gd.e1;
import gd.m2;
import gd.o;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import lc.q;
import oc.i;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends e {
    private volatile d _immediate;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f9951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f9953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f9954f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f9955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f9956b;

        public a(o oVar, d dVar) {
            this.f9955a = oVar;
            this.f9956b = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f9955a.i(this.f9956b, q.f12711a);
        }
    }

    public static final class b extends l implements xc.l<Throwable, q> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f9958b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Runnable runnable) {
            super(1);
            this.f9958b = runnable;
        }

        public final void a(Throwable th) {
            d.this.f9951c.removeCallbacks(this.f9958b);
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ q invoke(Throwable th) {
            a(th);
            return q.f12711a;
        }
    }

    public d(Handler handler, String str) {
        this(handler, str, false);
    }

    public /* synthetic */ d(Handler handler, String str, int i10, g gVar) {
        this(handler, (i10 & 2) != 0 ? null : str);
    }

    public d(Handler handler, String str, boolean z10) {
        super(null);
        this.f9951c = handler;
        this.f9952d = str;
        this.f9953e = z10;
        this._immediate = z10 ? this : null;
        d dVar = this._immediate;
        if (dVar == null) {
            dVar = new d(handler, str, true);
            this._immediate = dVar;
        }
        this.f9954f = dVar;
    }

    public static final void l0(d dVar, Runnable runnable) {
        dVar.f9951c.removeCallbacks(runnable);
    }

    @Override // gd.j0
    public void c0(i iVar, Runnable runnable) {
        if (this.f9951c.post(runnable)) {
            return;
        }
        j0(iVar, runnable);
    }

    @Override // gd.j0
    public boolean d0(i iVar) {
        return (this.f9953e && k.a(Looper.myLooper(), this.f9951c.getLooper())) ? false : true;
    }

    @Override // gd.v0
    public void e(long j10, o<? super q> oVar) {
        a aVar = new a(oVar, this);
        if (this.f9951c.postDelayed(aVar, h.d(j10, 4611686018427387903L))) {
            oVar.g(new b(aVar));
        } else {
            j0(oVar.getContext(), aVar);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && ((d) obj).f9951c == this.f9951c;
    }

    public int hashCode() {
        return System.identityHashCode(this.f9951c);
    }

    public final void j0(i iVar, Runnable runnable) {
        c2.c(iVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        c1.b().c0(iVar, runnable);
    }

    @Override // hd.e, gd.v0
    public e1 k(long j10, final Runnable runnable, i iVar) {
        if (this.f9951c.postDelayed(runnable, h.d(j10, 4611686018427387903L))) {
            return new e1() { // from class: hd.c
                @Override // gd.e1
                public final void d() {
                    d.l0(this.f9949a, runnable);
                }
            };
        }
        j0(iVar, runnable);
        return m2.f9235a;
    }

    @Override // gd.k2
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public d f0() {
        return this.f9954f;
    }

    @Override // gd.k2, gd.j0
    public String toString() {
        String strG0 = g0();
        if (strG0 != null) {
            return strG0;
        }
        String string = this.f9952d;
        if (string == null) {
            string = this.f9951c.toString();
        }
        if (!this.f9953e) {
            return string;
        }
        return string + ".immediate";
    }
}
