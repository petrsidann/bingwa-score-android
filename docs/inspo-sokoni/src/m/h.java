package m;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import p0.v1;
import p0.w1;
import p0.x1;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Interpolator f12848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w1 f12849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f12850e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f12847b = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x1 f12851f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<v1> f12846a = new ArrayList<>();

    public class a extends x1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12852a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12853b = 0;

        public a() {
        }

        @Override // p0.w1
        public void b(View view) {
            int i10 = this.f12853b + 1;
            this.f12853b = i10;
            if (i10 == h.this.f12846a.size()) {
                w1 w1Var = h.this.f12849d;
                if (w1Var != null) {
                    w1Var.b(null);
                }
                d();
            }
        }

        @Override // p0.x1, p0.w1
        public void c(View view) {
            if (this.f12852a) {
                return;
            }
            this.f12852a = true;
            w1 w1Var = h.this.f12849d;
            if (w1Var != null) {
                w1Var.c(null);
            }
        }

        public void d() {
            this.f12853b = 0;
            this.f12852a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f12850e) {
            Iterator<v1> it = this.f12846a.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
            this.f12850e = false;
        }
    }

    public void b() {
        this.f12850e = false;
    }

    public h c(v1 v1Var) {
        if (!this.f12850e) {
            this.f12846a.add(v1Var);
        }
        return this;
    }

    public h d(v1 v1Var, v1 v1Var2) {
        this.f12846a.add(v1Var);
        v1Var2.j(v1Var.d());
        this.f12846a.add(v1Var2);
        return this;
    }

    public h e(long j10) {
        if (!this.f12850e) {
            this.f12847b = j10;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f12850e) {
            this.f12848c = interpolator;
        }
        return this;
    }

    public h g(w1 w1Var) {
        if (!this.f12850e) {
            this.f12849d = w1Var;
        }
        return this;
    }

    public void h() {
        if (this.f12850e) {
            return;
        }
        for (v1 v1Var : this.f12846a) {
            long j10 = this.f12847b;
            if (j10 >= 0) {
                v1Var.f(j10);
            }
            Interpolator interpolator = this.f12848c;
            if (interpolator != null) {
                v1Var.g(interpolator);
            }
            if (this.f12849d != null) {
                v1Var.h(this.f12851f);
            }
            v1Var.l();
        }
        this.f12850e = true;
    }
}
