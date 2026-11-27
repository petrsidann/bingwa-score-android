package lb;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    public interface a {

        /* JADX INFO: renamed from: lb.o$a$a, reason: collision with other inner class name */
        public class C0209a implements g<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12640a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12641b;

            public C0209a(ArrayList arrayList, fb.a.e eVar) {
                this.f12640a = arrayList;
                this.f12641b = eVar;
            }

            @Override // lb.o.g
            public void b(Throwable th) {
                this.f12641b.a(o.a(th));
            }

            @Override // lb.o.g
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r10) {
                this.f12640a.add(0, null);
                this.f12641b.a(this.f12640a);
            }
        }

        public class b implements g<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12642a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12643b;

            public b(ArrayList arrayList, fb.a.e eVar) {
                this.f12642a = arrayList;
                this.f12643b = eVar;
            }

            @Override // lb.o.g
            public void b(Throwable th) {
                this.f12643b.a(o.a(th));
            }

            @Override // lb.o.g
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r10) {
                this.f12642a.add(0, null);
                this.f12643b.a(this.f12642a);
            }
        }

        public class c implements g<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12644a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12645b;

            public c(ArrayList arrayList, fb.a.e eVar) {
                this.f12644a = arrayList;
                this.f12645b = eVar;
            }

            @Override // lb.o.g
            public void b(Throwable th) {
                this.f12645b.a(o.a(th));
            }

            @Override // lb.o.g
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Void r10) {
                this.f12644a.add(0, null);
                this.f12645b.a(this.f12644a);
            }
        }

        static fb.h<Object> a() {
            return new fb.p();
        }

        static /* synthetic */ void j(a aVar, Object obj, fb.a.e eVar) {
            aVar.i((String) ((ArrayList) obj).get(0), new c(new ArrayList(), eVar));
        }

        static void l(fb.b bVar, final a aVar) {
            fb.a aVar2 = new fb.a(bVar, "dev.flutter.pigeon.FirebaseAppHostApi.setAutomaticDataCollectionEnabled", a());
            if (aVar != null) {
                aVar2.e(new fb.a.d() { // from class: lb.l
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        o.a.o(this.f12637a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            fb.a aVar3 = new fb.a(bVar, "dev.flutter.pigeon.FirebaseAppHostApi.setAutomaticResourceManagementEnabled", a());
            if (aVar != null) {
                aVar3.e(new fb.a.d() { // from class: lb.m
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        o.a.s(this.f12638a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            fb.a aVar4 = new fb.a(bVar, "dev.flutter.pigeon.FirebaseAppHostApi.delete", a());
            if (aVar != null) {
                aVar4.e(new fb.a.d() { // from class: lb.n
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        o.a.j(this.f12639a, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
        }

        static /* synthetic */ void o(a aVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            aVar.q((String) arrayList.get(0), (Boolean) arrayList.get(1), new C0209a(new ArrayList(), eVar));
        }

        static /* synthetic */ void s(a aVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            aVar.h((String) arrayList.get(0), (Boolean) arrayList.get(1), new b(new ArrayList(), eVar));
        }

        void h(String str, Boolean bool, g<Void> gVar);

        void i(String str, g<Void> gVar);

        void q(String str, Boolean bool, g<Void> gVar);
    }

    public interface b {

        public class a implements g<f> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12646a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12647b;

            public a(ArrayList arrayList, fb.a.e eVar) {
                this.f12646a = arrayList;
                this.f12647b = eVar;
            }

            @Override // lb.o.g
            public void b(Throwable th) {
                this.f12647b.a(o.a(th));
            }

            @Override // lb.o.g
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(f fVar) {
                this.f12646a.add(0, fVar);
                this.f12647b.a(this.f12646a);
            }
        }

        /* JADX INFO: renamed from: lb.o$b$b, reason: collision with other inner class name */
        public class C0210b implements g<List<f>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12648a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12649b;

            public C0210b(ArrayList arrayList, fb.a.e eVar) {
                this.f12648a = arrayList;
                this.f12649b = eVar;
            }

            @Override // lb.o.g
            public void b(Throwable th) {
                this.f12649b.a(o.a(th));
            }

            @Override // lb.o.g
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(List<f> list) {
                this.f12648a.add(0, list);
                this.f12649b.a(this.f12648a);
            }
        }

        public class c implements g<e> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f12650a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fb.a.e f12651b;

            public c(ArrayList arrayList, fb.a.e eVar) {
                this.f12650a = arrayList;
                this.f12651b = eVar;
            }

            @Override // lb.o.g
            public void b(Throwable th) {
                this.f12651b.a(o.a(th));
            }

            @Override // lb.o.g
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(e eVar) {
                this.f12650a.add(0, eVar);
                this.f12651b.a(this.f12650a);
            }
        }

        static fb.h<Object> a() {
            return c.f12652d;
        }

        static void c(fb.b bVar, final b bVar2) {
            fb.a aVar = new fb.a(bVar, "dev.flutter.pigeon.FirebaseCoreHostApi.initializeApp", a());
            if (bVar2 != null) {
                aVar.e(new fb.a.d() { // from class: lb.p
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        o.b.n(this.f12691a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            fb.a aVar2 = new fb.a(bVar, "dev.flutter.pigeon.FirebaseCoreHostApi.initializeCore", a());
            if (bVar2 != null) {
                aVar2.e(new fb.a.d() { // from class: lb.q
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        o.b.r(this.f12692a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            fb.a aVar3 = new fb.a(bVar, "dev.flutter.pigeon.FirebaseCoreHostApi.optionsFromResource", a());
            if (bVar2 != null) {
                aVar3.e(new fb.a.d() { // from class: lb.r
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        o.b.u(this.f12693a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
        }

        static /* synthetic */ void n(b bVar, Object obj, fb.a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            bVar.e((String) arrayList.get(0), (e) arrayList.get(1), new a(new ArrayList(), eVar));
        }

        static /* synthetic */ void r(b bVar, Object obj, fb.a.e eVar) {
            bVar.b(new C0210b(new ArrayList(), eVar));
        }

        static /* synthetic */ void u(b bVar, Object obj, fb.a.e eVar) {
            bVar.g(new c(new ArrayList(), eVar));
        }

        void b(g<List<f>> gVar);

        void e(String str, e eVar, g<f> gVar);

        void g(g<e> gVar);
    }

    public static class c extends fb.p {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f12652d = new c();

        @Override // fb.p
        public Object g(byte b10, ByteBuffer byteBuffer) {
            if (b10 != -128) {
                return b10 != -127 ? super.g(b10, byteBuffer) : f.a((ArrayList) f(byteBuffer));
            }
            return e.a((ArrayList) f(byteBuffer));
        }

        @Override // fb.p
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            ArrayList<Object> arrayListF;
            if (obj instanceof e) {
                byteArrayOutputStream.write(128);
                arrayListF = ((e) obj).x();
            } else if (!(obj instanceof f)) {
                super.p(byteArrayOutputStream, obj);
                return;
            } else {
                byteArrayOutputStream.write(129);
                arrayListF = ((f) obj).f();
            }
            p(byteArrayOutputStream, arrayListF);
        }
    }

    public static class d extends RuntimeException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f12654b;
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12656b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f12657c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f12658d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f12659e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f12660f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f12661g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f12662h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f12663i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f12664j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f12665k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f12666l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f12667m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f12668n;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f12669a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f12670b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f12671c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f12672d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f12673e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public String f12674f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public String f12675g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String f12676h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public String f12677i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public String f12678j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public String f12679k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public String f12680l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public String f12681m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public String f12682n;

            public e a() {
                e eVar = new e();
                eVar.k(this.f12669a);
                eVar.m(this.f12670b);
                eVar.t(this.f12671c);
                eVar.u(this.f12672d);
                eVar.n(this.f12673e);
                eVar.o(this.f12674f);
                eVar.v(this.f12675g);
                eVar.s(this.f12676h);
                eVar.w(this.f12677i);
                eVar.p(this.f12678j);
                eVar.j(this.f12679k);
                eVar.r(this.f12680l);
                eVar.q(this.f12681m);
                eVar.l(this.f12682n);
                return eVar;
            }

            public a b(String str) {
                this.f12669a = str;
                return this;
            }

            public a c(String str) {
                this.f12670b = str;
                return this;
            }

            public a d(String str) {
                this.f12674f = str;
                return this;
            }

            public a e(String str) {
                this.f12671c = str;
                return this;
            }

            public a f(String str) {
                this.f12672d = str;
                return this;
            }

            public a g(String str) {
                this.f12675g = str;
                return this;
            }

            public a h(String str) {
                this.f12677i = str;
                return this;
            }
        }

        public static e a(ArrayList<Object> arrayList) {
            e eVar = new e();
            eVar.k((String) arrayList.get(0));
            eVar.m((String) arrayList.get(1));
            eVar.t((String) arrayList.get(2));
            eVar.u((String) arrayList.get(3));
            eVar.n((String) arrayList.get(4));
            eVar.o((String) arrayList.get(5));
            eVar.v((String) arrayList.get(6));
            eVar.s((String) arrayList.get(7));
            eVar.w((String) arrayList.get(8));
            eVar.p((String) arrayList.get(9));
            eVar.j((String) arrayList.get(10));
            eVar.r((String) arrayList.get(11));
            eVar.q((String) arrayList.get(12));
            eVar.l((String) arrayList.get(13));
            return eVar;
        }

        public String b() {
            return this.f12655a;
        }

        public String c() {
            return this.f12656b;
        }

        public String d() {
            return this.f12659e;
        }

        public String e() {
            return this.f12660f;
        }

        public String f() {
            return this.f12657c;
        }

        public String g() {
            return this.f12658d;
        }

        public String h() {
            return this.f12661g;
        }

        public String i() {
            return this.f12663i;
        }

        public void j(String str) {
            this.f12665k = str;
        }

        public void k(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"apiKey\" is null.");
            }
            this.f12655a = str;
        }

        public void l(String str) {
            this.f12668n = str;
        }

        public void m(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"appId\" is null.");
            }
            this.f12656b = str;
        }

        public void n(String str) {
            this.f12659e = str;
        }

        public void o(String str) {
            this.f12660f = str;
        }

        public void p(String str) {
            this.f12664j = str;
        }

        public void q(String str) {
            this.f12667m = str;
        }

        public void r(String str) {
            this.f12666l = str;
        }

        public void s(String str) {
            this.f12662h = str;
        }

        public void t(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"messagingSenderId\" is null.");
            }
            this.f12657c = str;
        }

        public void u(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"projectId\" is null.");
            }
            this.f12658d = str;
        }

        public void v(String str) {
            this.f12661g = str;
        }

        public void w(String str) {
            this.f12663i = str;
        }

        public ArrayList<Object> x() {
            ArrayList<Object> arrayList = new ArrayList<>(14);
            arrayList.add(this.f12655a);
            arrayList.add(this.f12656b);
            arrayList.add(this.f12657c);
            arrayList.add(this.f12658d);
            arrayList.add(this.f12659e);
            arrayList.add(this.f12660f);
            arrayList.add(this.f12661g);
            arrayList.add(this.f12662h);
            arrayList.add(this.f12663i);
            arrayList.add(this.f12664j);
            arrayList.add(this.f12665k);
            arrayList.add(this.f12666l);
            arrayList.add(this.f12667m);
            arrayList.add(this.f12668n);
            return arrayList;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f12684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Boolean f12685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, Object> f12686d;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f12687a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public e f12688b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Boolean f12689c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Map<String, Object> f12690d;

            public f a() {
                f fVar = new f();
                fVar.c(this.f12687a);
                fVar.d(this.f12688b);
                fVar.b(this.f12689c);
                fVar.e(this.f12690d);
                return fVar;
            }

            public a b(Boolean bool) {
                this.f12689c = bool;
                return this;
            }

            public a c(String str) {
                this.f12687a = str;
                return this;
            }

            public a d(e eVar) {
                this.f12688b = eVar;
                return this;
            }

            public a e(Map<String, Object> map) {
                this.f12690d = map;
                return this;
            }
        }

        public static f a(ArrayList<Object> arrayList) {
            f fVar = new f();
            fVar.c((String) arrayList.get(0));
            Object obj = arrayList.get(1);
            fVar.d(obj == null ? null : e.a((ArrayList) obj));
            fVar.b((Boolean) arrayList.get(2));
            fVar.e((Map) arrayList.get(3));
            return fVar;
        }

        public void b(Boolean bool) {
            this.f12685c = bool;
        }

        public void c(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"name\" is null.");
            }
            this.f12683a = str;
        }

        public void d(e eVar) {
            if (eVar == null) {
                throw new IllegalStateException("Nonnull field \"options\" is null.");
            }
            this.f12684b = eVar;
        }

        public void e(Map<String, Object> map) {
            if (map == null) {
                throw new IllegalStateException("Nonnull field \"pluginConstants\" is null.");
            }
            this.f12686d = map;
        }

        public ArrayList<Object> f() {
            ArrayList<Object> arrayList = new ArrayList<>(4);
            arrayList.add(this.f12683a);
            e eVar = this.f12684b;
            arrayList.add(eVar == null ? null : eVar.x());
            arrayList.add(this.f12685c);
            arrayList.add(this.f12686d);
            return arrayList;
        }
    }

    public interface g<T> {
        void a(T t10);

        void b(Throwable th);
    }

    public static ArrayList<Object> a(Throwable th) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof d) {
            d dVar = (d) th;
            arrayList.add(dVar.f12653a);
            arrayList.add(dVar.getMessage());
            obj = dVar.f12654b;
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            obj = "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th);
        }
        arrayList.add(obj);
        return arrayList;
    }
}
