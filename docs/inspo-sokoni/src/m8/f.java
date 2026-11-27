package m8;

import android.content.Context;
import android.util.Base64OutputStream;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import l0.o;
import org.json.JSONArray;
import org.json.JSONObject;
import q7.e0;
import q7.q;

/* JADX INFO: loaded from: classes.dex */
public class f implements i, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o8.b<k> f12975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f12976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o8.b<z8.i> f12977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<g> f12978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f12979e;

    public f(final Context context, final String str, Set<g> set, o8.b<z8.i> bVar, Executor executor) {
        this((o8.b<k>) new o8.b() { // from class: m8.e
            @Override // o8.b
            public final Object get() {
                return f.j(context, str);
            }
        }, set, executor, bVar, context);
    }

    public f(o8.b<k> bVar, Set<g> set, Executor executor, o8.b<z8.i> bVar2, Context context) {
        this.f12975a = bVar;
        this.f12978d = set;
        this.f12979e = executor;
        this.f12977c = bVar2;
        this.f12976b = context;
    }

    public static q7.c<f> g() {
        final e0 e0VarA = e0.a(l7.a.class, Executor.class);
        return q7.c.d(f.class, i.class, j.class).b(q.k(Context.class)).b(q.k(h7.f.class)).b(q.n(g.class)).b(q.m(z8.i.class)).b(q.l(e0VarA)).f(new q7.g() { // from class: m8.d
            @Override // q7.g
            public final Object a(q7.d dVar) {
                return f.h(e0VarA, dVar);
            }
        }).d();
    }

    public static /* synthetic */ f h(e0 e0Var, q7.d dVar) {
        return new f((Context) dVar.a(Context.class), ((h7.f) dVar.a(h7.f.class)).s(), (Set<g>) dVar.e(g.class), (o8.b<z8.i>) dVar.c(z8.i.class), (Executor) dVar.h(e0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String i() {
        String string;
        synchronized (this) {
            k kVar = this.f12975a.get();
            List<l> listC = kVar.c();
            kVar.b();
            JSONArray jSONArray = new JSONArray();
            for (int i10 = 0; i10 < listC.size(); i10++) {
                l lVar = listC.get(i10);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("agent", lVar.c());
                jSONObject.put("dates", new JSONArray((Collection) lVar.b()));
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("heartbeats", jSONArray);
            jSONObject2.put("version", "2");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                try {
                    gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                    gZIPOutputStream.close();
                    base64OutputStream.close();
                    string = byteArrayOutputStream.toString("UTF-8");
                } catch (Throwable th) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    base64OutputStream.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        }
        return string;
    }

    public static /* synthetic */ k j(Context context, String str) {
        return new k(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void k() {
        synchronized (this) {
            this.f12975a.get().k(System.currentTimeMillis(), this.f12977c.get().a());
        }
        return null;
    }

    @Override // m8.i
    public Task<String> a() {
        return o.a(this.f12976b) ^ true ? Tasks.forResult("") : Tasks.call(this.f12979e, new Callable() { // from class: m8.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f12970a.i();
            }
        });
    }

    @Override // m8.j
    public synchronized j.a b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        k kVar = this.f12975a.get();
        if (!kVar.i(jCurrentTimeMillis)) {
            return j.a.NONE;
        }
        kVar.g();
        return j.a.GLOBAL;
    }

    public Task<Void> l() {
        if (this.f12978d.size() > 0 && !(!o.a(this.f12976b))) {
            return Tasks.call(this.f12979e, new Callable() { // from class: m8.c
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f12971a.k();
                }
            });
        }
        return Tasks.forResult(null);
    }
}
