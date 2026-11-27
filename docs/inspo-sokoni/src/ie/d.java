package ie;

import android.os.Handler;
import android.os.Looper;
import fe.l;
import java.util.concurrent.Executors;
import zd.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10676a = "NotificationThread";

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f10677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Handler f10678b;

        /* JADX INFO: renamed from: ie.d$a$a, reason: collision with other inner class name */
        public class RunnableC0178a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f10680a;

            public RunnableC0178a(Object obj) {
                this.f10680a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        try {
                            d.this.h(a.this.f10677a.e(this.f10680a), null);
                        } catch (Exception e10) {
                            d.this.h(null, ae.b.e().b("NotificationThread", "NOTIFICATION_THREAD_EXCEPTION", "unexpectedError", e10));
                        }
                    } catch (ae.a e11) {
                        d.this.h(null, e11);
                    }
                } catch (ae.a e12) {
                    e12.printStackTrace();
                }
            }
        }

        public a(d dVar, Handler handler) {
            this.f10677a = dVar;
            this.f10678b = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.f10678b.post(new RunnableC0178a(this.f10677a.a()));
                } catch (ae.a e10) {
                    e10.printStackTrace();
                }
            } catch (ae.a e11) {
                d.this.h(null, e11);
            } catch (Exception e12) {
                d.this.h(null, ae.b.e().b("NotificationThread", "NOTIFICATION_THREAD_EXCEPTION", "unexpectedError", e12));
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f10682a;

        public b(d dVar) {
            this.f10682a = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    try {
                        d.this.h(this.f10682a.e(this.f10682a.a()), null);
                    } catch (ae.a e10) {
                        d.this.h(null, e10);
                    }
                } catch (Exception e11) {
                    d.this.h(null, ae.b.e().b("NotificationThread", "NOTIFICATION_THREAD_EXCEPTION", "unexpectedError", e11));
                }
            } catch (ae.a e12) {
                e12.printStackTrace();
            }
        }
    }

    public abstract T a();

    public void b() {
        f();
    }

    public void c(l lVar) {
        if (d(lVar)) {
            f();
        } else {
            g();
        }
    }

    public final boolean d(l lVar) {
        je.b bVarK = je.b.k();
        g gVar = g.Network;
        return gVar == bVarK.b(lVar.f8412l.f8394z) || gVar == bVarK.b(lVar.f8412l.f8392x);
    }

    public abstract T e(T t10);

    public final void f() {
        Executors.newSingleThreadExecutor().execute(new a(this, new Handler(Looper.getMainLooper())));
    }

    public final void g() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new b(this));
            return;
        }
        try {
            try {
                h(e(a()), null);
            } catch (ae.a e10) {
                e10.printStackTrace();
            }
        } catch (ae.a e11) {
            h(null, e11);
        } catch (Exception e12) {
            h(null, ae.b.e().b("NotificationThread", "NOTIFICATION_THREAD_EXCEPTION", "unexpectedError", e12));
        }
    }

    public abstract void h(T t10, ae.a aVar);
}
