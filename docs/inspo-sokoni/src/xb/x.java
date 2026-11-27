package xb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<a> f19030a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile vb.q f19031b = vb.q.IDLE;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f19032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f19033b;

        public a(Runnable runnable, Executor executor) {
            this.f19032a = runnable;
            this.f19033b = executor;
        }

        public void a() {
            this.f19033b.execute(this.f19032a);
        }
    }

    public vb.q a() {
        vb.q qVar = this.f19031b;
        if (qVar != null) {
            return qVar;
        }
        throw new UnsupportedOperationException("Channel state API is not implemented");
    }

    public void b(vb.q qVar) {
        j6.m.p(qVar, "newState");
        if (this.f19031b == qVar || this.f19031b == vb.q.SHUTDOWN) {
            return;
        }
        this.f19031b = qVar;
        if (this.f19030a.isEmpty()) {
            return;
        }
        ArrayList<a> arrayList = this.f19030a;
        this.f19030a = new ArrayList<>();
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void c(Runnable runnable, Executor executor, vb.q qVar) {
        j6.m.p(runnable, "callback");
        j6.m.p(executor, "executor");
        j6.m.p(qVar, "source");
        a aVar = new a(runnable, executor);
        if (this.f19031b != qVar) {
            aVar.a();
        } else {
            this.f19030a.add(aVar);
        }
    }
}
