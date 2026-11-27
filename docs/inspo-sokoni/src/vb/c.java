package vb;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f17279k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f17280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f17281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vb.b f17283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f17284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object[][] f17285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<k.a> f17286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f17287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f17288i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f17289j;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public u f17290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Executor f17291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f17292c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public vb.b f17293d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f17294e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object[][] f17295f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<k.a> f17296g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Boolean f17297h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Integer f17298i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Integer f17299j;

        public final c b() {
            return new c(this);
        }
    }

    /* JADX INFO: renamed from: vb.c$c, reason: collision with other inner class name */
    public static final class C0304c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f17301b;

        public C0304c(String str, T t10) {
            this.f17300a = str;
            this.f17301b = t10;
        }

        public static <T> C0304c<T> b(String str) {
            j6.m.p(str, "debugString");
            return new C0304c<>(str, null);
        }

        public String toString() {
            return this.f17300a;
        }
    }

    static {
        b bVar = new b();
        bVar.f17295f = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        bVar.f17296g = Collections.emptyList();
        f17279k = bVar.b();
    }

    public c(b bVar) {
        this.f17280a = bVar.f17290a;
        this.f17281b = bVar.f17291b;
        this.f17282c = bVar.f17292c;
        this.f17283d = bVar.f17293d;
        this.f17284e = bVar.f17294e;
        this.f17285f = bVar.f17295f;
        this.f17286g = bVar.f17296g;
        this.f17287h = bVar.f17297h;
        this.f17288i = bVar.f17298i;
        this.f17289j = bVar.f17299j;
    }

    public static b k(c cVar) {
        b bVar = new b();
        bVar.f17290a = cVar.f17280a;
        bVar.f17291b = cVar.f17281b;
        bVar.f17292c = cVar.f17282c;
        bVar.f17293d = cVar.f17283d;
        bVar.f17294e = cVar.f17284e;
        bVar.f17295f = cVar.f17285f;
        bVar.f17296g = cVar.f17286g;
        bVar.f17297h = cVar.f17287h;
        bVar.f17298i = cVar.f17288i;
        bVar.f17299j = cVar.f17289j;
        return bVar;
    }

    public String a() {
        return this.f17282c;
    }

    public String b() {
        return this.f17284e;
    }

    public vb.b c() {
        return this.f17283d;
    }

    public u d() {
        return this.f17280a;
    }

    public Executor e() {
        return this.f17281b;
    }

    public Integer f() {
        return this.f17288i;
    }

    public Integer g() {
        return this.f17289j;
    }

    public <T> T h(C0304c<T> c0304c) {
        j6.m.p(c0304c, "key");
        int i10 = 0;
        while (true) {
            Object[][] objArr = this.f17285f;
            if (i10 >= objArr.length) {
                return (T) c0304c.f17301b;
            }
            if (c0304c.equals(objArr[i10][0])) {
                return (T) this.f17285f[i10][1];
            }
            i10++;
        }
    }

    public List<k.a> i() {
        return this.f17286g;
    }

    public boolean j() {
        return Boolean.TRUE.equals(this.f17287h);
    }

    public c l(vb.b bVar) {
        b bVarK = k(this);
        bVarK.f17293d = bVar;
        return bVarK.b();
    }

    public c m(u uVar) {
        b bVarK = k(this);
        bVarK.f17290a = uVar;
        return bVarK.b();
    }

    public c n(Executor executor) {
        b bVarK = k(this);
        bVarK.f17291b = executor;
        return bVarK.b();
    }

    public c o(int i10) {
        j6.m.h(i10 >= 0, "invalid maxsize %s", i10);
        b bVarK = k(this);
        bVarK.f17298i = Integer.valueOf(i10);
        return bVarK.b();
    }

    public c p(int i10) {
        j6.m.h(i10 >= 0, "invalid maxsize %s", i10);
        b bVarK = k(this);
        bVarK.f17299j = Integer.valueOf(i10);
        return bVarK.b();
    }

    public <T> c q(C0304c<T> c0304c, T t10) {
        j6.m.p(c0304c, "key");
        j6.m.p(t10, "value");
        b bVarK = k(this);
        int i10 = 0;
        while (true) {
            Object[][] objArr = this.f17285f;
            if (i10 >= objArr.length) {
                i10 = -1;
                break;
            }
            if (c0304c.equals(objArr[i10][0])) {
                break;
            }
            i10++;
        }
        Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.f17285f.length + (i10 == -1 ? 1 : 0), 2);
        bVarK.f17295f = objArr2;
        Object[][] objArr3 = this.f17285f;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (i10 == -1) {
            bVarK.f17295f[this.f17285f.length] = new Object[]{c0304c, t10};
        } else {
            bVarK.f17295f[i10] = new Object[]{c0304c, t10};
        }
        return bVarK.b();
    }

    public c r(k.a aVar) {
        ArrayList arrayList = new ArrayList(this.f17286g.size() + 1);
        arrayList.addAll(this.f17286g);
        arrayList.add(aVar);
        b bVarK = k(this);
        bVarK.f17296g = Collections.unmodifiableList(arrayList);
        return bVarK.b();
    }

    public c s() {
        b bVarK = k(this);
        bVarK.f17297h = Boolean.TRUE;
        return bVarK.b();
    }

    public c t() {
        b bVarK = k(this);
        bVarK.f17297h = Boolean.FALSE;
        return bVarK.b();
    }

    public String toString() {
        j6.g.b bVarD = j6.g.b(this).d("deadline", this.f17280a).d("authority", this.f17282c).d("callCredentials", this.f17283d);
        Executor executor = this.f17281b;
        return bVarD.d("executor", executor != null ? executor.getClass() : null).d("compressorName", this.f17284e).d("customOptions", Arrays.deepToString(this.f17285f)).e("waitForReady", j()).d("maxInboundMessageSize", this.f17288i).d("maxOutboundMessageSize", this.f17289j).d("streamTracerFactories", this.f17286g).toString();
    }
}
