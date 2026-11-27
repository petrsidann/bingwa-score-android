package m0;

import android.graphics.Typeface;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.c f12856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f12857b;

    /* JADX INFO: renamed from: m0.a$a, reason: collision with other inner class name */
    public class RunnableC0211a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.c f12858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f12859b;

        public RunnableC0211a(g.c cVar, Typeface typeface) {
            this.f12858a = cVar;
            this.f12859b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12858a.b(this.f12859b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.c f12861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12862b;

        public b(g.c cVar, int i10) {
            this.f12861a = cVar;
            this.f12862b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12861a.a(this.f12862b);
        }
    }

    public a(g.c cVar, Handler handler) {
        this.f12856a = cVar;
        this.f12857b = handler;
    }

    public final void a(int i10) {
        this.f12857b.post(new b(this.f12856a, i10));
    }

    public void b(f.e eVar) {
        if (eVar.a()) {
            c(eVar.f12885a);
        } else {
            a(eVar.f12886b);
        }
    }

    public final void c(Typeface typeface) {
        this.f12857b.post(new RunnableC0211a(this.f12856a, typeface));
    }
}
