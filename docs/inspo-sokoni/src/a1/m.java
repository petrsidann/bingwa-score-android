package a1;

import gd.m0;
import gd.x;
import gd.z;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.t;
import mc.w;

/* JADX INFO: loaded from: classes.dex */
public final class m<T> implements a1.f<T> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f233k = new a(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Set<String> f234l = new LinkedHashSet();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f235m = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xc.a<File> f236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a1.k<T> f237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a1.b<T> f238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m0 f239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final jd.d<T> f240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final lc.f f242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final jd.n<a1.n<T>> f243h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<? extends xc.p<? super a1.i<T>, ? super oc.e<? super lc.q>, ? extends Object>> f244i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a1.l<b<T>> f245j;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final Set<String> a() {
            return m.f234l;
        }

        public final Object b() {
            return m.f235m;
        }
    }

    public static abstract class b<T> {

        public static final class a<T> extends b<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final a1.n<T> f246a;

            public a(a1.n<T> nVar) {
                super(null);
                this.f246a = nVar;
            }

            public a1.n<T> a() {
                return this.f246a;
            }
        }

        /* JADX INFO: renamed from: a1.m$b$b, reason: collision with other inner class name */
        public static final class C0003b<T> extends b<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final xc.p<T, oc.e<? super T>, Object> f247a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final x<T> f248b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final a1.n<T> f249c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final oc.i f250d;

            public final x<T> a() {
                return this.f248b;
            }

            public final oc.i b() {
                return this.f250d;
            }

            public a1.n<T> c() {
                return this.f249c;
            }

            public final xc.p<T, oc.e<? super T>, Object> d() {
                return this.f247a;
            }
        }

        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public static final class c extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FileOutputStream f251a;

        public c(FileOutputStream fileOutputStream) {
            kotlin.jvm.internal.k.e(fileOutputStream, "fileOutputStream");
            this.f251a = fileOutputStream;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f251a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            this.f251a.write(i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] b10) throws IOException {
            kotlin.jvm.internal.k.e(b10, "b");
            this.f251a.write(b10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bytes, int i10, int i11) throws IOException {
            kotlin.jvm.internal.k.e(bytes, "bytes");
            this.f251a.write(bytes, i10, i11);
        }
    }

    public static final class d extends kotlin.jvm.internal.l implements xc.l<Throwable, lc.q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m<T> f252a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(m<T> mVar) {
            super(1);
            this.f252a = mVar;
        }

        public final void a(Throwable th) {
            if (th != null) {
                this.f252a.f243h.setValue(new a1.h(th));
            }
            a aVar = m.f233k;
            Object objB = aVar.b();
            m<T> mVar = this.f252a;
            synchronized (objB) {
                aVar.a().remove(mVar.q().getAbsolutePath());
                lc.q qVar = lc.q.f12711a;
            }
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ lc.q invoke(Throwable th) {
            a(th);
            return lc.q.f12711a;
        }
    }

    public static final class e extends kotlin.jvm.internal.l implements xc.p<b<T>, Throwable, lc.q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f253a = new e();

        public e() {
            super(2);
        }

        public final void a(b<T> msg, Throwable th) {
            kotlin.jvm.internal.k.e(msg, "msg");
            if (msg instanceof b.C0003b) {
                x<T> xVarA = ((b.C0003b) msg).a();
                if (th == null) {
                    th = new CancellationException("DataStore scope was cancelled before updateData could complete");
                }
                xVarA.E(th);
            }
        }

        @Override // xc.p
        public /* bridge */ /* synthetic */ lc.q invoke(Object obj, Throwable th) {
            a((b) obj, th);
            return lc.q.f12711a;
        }
    }

    @qc.f(c = "androidx.datastore.core.SingleProcessDataStore$actor$3", f = "SingleProcessDataStore.kt", l = {239, 242}, m = "invokeSuspend")
    public static final class f extends qc.l implements xc.p<b<T>, oc.e<? super lc.q>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m<T> f256c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(m<T> mVar, oc.e<? super f> eVar) {
            super(2, eVar);
            this.f256c = mVar;
        }

        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(b<T> bVar, oc.e<? super lc.q> eVar) {
            return ((f) create(bVar, eVar)).invokeSuspend(lc.q.f12711a);
        }

        @Override // qc.a
        public final oc.e<lc.q> create(Object obj, oc.e<?> eVar) {
            f fVar = new f(this.f256c, eVar);
            fVar.f255b = obj;
            return fVar;
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = pc.c.c();
            int i10 = this.f254a;
            if (i10 == 0) {
                lc.k.b(obj);
                b bVar = (b) this.f255b;
                if (bVar instanceof b.a) {
                    this.f254a = 1;
                    if (this.f256c.r((b.a) bVar, this) == objC) {
                        return objC;
                    }
                } else if (bVar instanceof b.C0003b) {
                    this.f254a = 2;
                    if (this.f256c.s((b.C0003b) bVar, this) == objC) {
                        return objC;
                    }
                }
            } else {
                if (i10 != 1 && i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lc.k.b(obj);
            }
            return lc.q.f12711a;
        }
    }

    @qc.f(c = "androidx.datastore.core.SingleProcessDataStore$data$1", f = "SingleProcessDataStore.kt", l = {117}, m = "invokeSuspend")
    public static final class g extends qc.l implements xc.p<jd.e<? super T>, oc.e<? super lc.q>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m<T> f259c;

        @qc.f(c = "androidx.datastore.core.SingleProcessDataStore$data$1$1", f = "SingleProcessDataStore.kt", l = {}, m = "invokeSuspend")
        public static final class a extends qc.l implements xc.p<a1.n<T>, oc.e<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f260a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f261b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a1.n<T> f262c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(a1.n<T> nVar, oc.e<? super a> eVar) {
                super(2, eVar);
                this.f262c = nVar;
            }

            @Override // xc.p
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(a1.n<T> nVar, oc.e<? super Boolean> eVar) {
                return ((a) create(nVar, eVar)).invokeSuspend(lc.q.f12711a);
            }

            @Override // qc.a
            public final oc.e<lc.q> create(Object obj, oc.e<?> eVar) {
                a aVar = new a(this.f262c, eVar);
                aVar.f261b = obj;
                return aVar;
            }

            @Override // qc.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                pc.c.c();
                if (this.f260a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lc.k.b(obj);
                a1.n<T> nVar = (a1.n) this.f261b;
                a1.n<T> nVar2 = this.f262c;
                boolean z10 = false;
                if (!(nVar2 instanceof a1.c) && !(nVar2 instanceof a1.h) && nVar == nVar2) {
                    z10 = true;
                }
                return qc.b.a(z10);
            }
        }

        public static final class b implements jd.d<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ jd.d f263a;

            public static final class a implements jd.e<a1.n<T>> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ jd.e f264a;

                /* JADX INFO: renamed from: a1.m$g$b$a$a, reason: collision with other inner class name */
                @qc.f(c = "androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2", f = "SingleProcessDataStore.kt", l = {137}, m = "emit")
                public static final class C0004a extends qc.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public /* synthetic */ Object f265a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public int f266b;

                    public C0004a(oc.e eVar) {
                        super(eVar);
                    }

                    @Override // qc.a
                    public final Object invokeSuspend(Object obj) {
                        this.f265a = obj;
                        this.f266b |= Integer.MIN_VALUE;
                        return a.this.b(null, this);
                    }
                }

                public a(jd.e eVar) {
                    this.f264a = eVar;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // jd.e
                public Object b(Object obj, oc.e eVar) throws Throwable {
                    C0004a c0004a;
                    if (eVar instanceof C0004a) {
                        c0004a = (C0004a) eVar;
                        int i10 = c0004a.f266b;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            c0004a.f266b = i10 - Integer.MIN_VALUE;
                        } else {
                            c0004a = new C0004a(eVar);
                        }
                    } else {
                        c0004a = new C0004a(eVar);
                    }
                    Object obj2 = c0004a.f265a;
                    Object objC = pc.c.c();
                    int i11 = c0004a.f266b;
                    if (i11 == 0) {
                        lc.k.b(obj2);
                        jd.e eVar2 = this.f264a;
                        a1.n nVar = (a1.n) obj;
                        if (nVar instanceof a1.j) {
                            throw ((a1.j) nVar).a();
                        }
                        if (nVar instanceof a1.h) {
                            throw ((a1.h) nVar).a();
                        }
                        if (!(nVar instanceof a1.c)) {
                            if (nVar instanceof a1.o) {
                                throw new IllegalStateException("This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542".toString());
                            }
                            throw new lc.h();
                        }
                        Object objB = ((a1.c) nVar).b();
                        c0004a.f266b = 1;
                        if (eVar2.b(objB, c0004a) == objC) {
                            return objC;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        lc.k.b(obj2);
                    }
                    return lc.q.f12711a;
                }
            }

            public b(jd.d dVar) {
                this.f263a = dVar;
            }

            @Override // jd.d
            public Object a(jd.e eVar, oc.e eVar2) {
                Object objA = this.f263a.a(new a(eVar), eVar2);
                return objA == pc.c.c() ? objA : lc.q.f12711a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(m<T> mVar, oc.e<? super g> eVar) {
            super(2, eVar);
            this.f259c = mVar;
        }

        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(jd.e<? super T> eVar, oc.e<? super lc.q> eVar2) {
            return ((g) create(eVar, eVar2)).invokeSuspend(lc.q.f12711a);
        }

        @Override // qc.a
        public final oc.e<lc.q> create(Object obj, oc.e<?> eVar) {
            g gVar = new g(this.f259c, eVar);
            gVar.f258b = obj;
            return gVar;
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = pc.c.c();
            int i10 = this.f257a;
            if (i10 == 0) {
                lc.k.b(obj);
                jd.e eVar = (jd.e) this.f258b;
                a1.n nVar = (a1.n) this.f259c.f243h.getValue();
                if (!(nVar instanceof a1.c)) {
                    this.f259c.f245j.e(new b.a(nVar));
                }
                b bVar = new b(jd.f.b(this.f259c.f243h, new a(nVar, null)));
                this.f257a = 1;
                if (jd.f.d(eVar, bVar, this) == objC) {
                    return objC;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lc.k.b(obj);
            }
            return lc.q.f12711a;
        }
    }

    public static final class h extends kotlin.jvm.internal.l implements xc.a<File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m<T> f268a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(m<T> mVar) {
            super(0);
            this.f268a = mVar;
        }

        @Override // xc.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            File file = (File) this.f268a.f236a.invoke();
            String it = file.getAbsolutePath();
            a aVar = m.f233k;
            synchronized (aVar.b()) {
                if (!(!aVar.a().contains(it))) {
                    throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                }
                Set<String> setA = aVar.a();
                kotlin.jvm.internal.k.d(it, "it");
                setA.add(it);
            }
            return file;
        }
    }

    @qc.f(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {276, 281, 284}, m = "handleUpdate")
    public static final class i extends qc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f272d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ m<T> f273e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f274f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(m<T> mVar, oc.e<? super i> eVar) {
            super(eVar);
            this.f273e = mVar;
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f272d = obj;
            this.f274f |= Integer.MIN_VALUE;
            return this.f273e.s(null, this);
        }
    }

    @qc.f(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {322, 348, 505}, m = "readAndInit")
    public static final class j extends qc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f276b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f277c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f278d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f279e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f280f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f281l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ m<T> f282m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f283n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(m<T> mVar, oc.e<? super j> eVar) {
            super(eVar);
            this.f282m = mVar;
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f281l = obj;
            this.f283n |= Integer.MIN_VALUE;
            return this.f282m.t(this);
        }
    }

    public static final class k implements a1.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pd.a f284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t<T> f286c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ m<T> f287d;

        @qc.f(c = "androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1", f = "SingleProcessDataStore.kt", l = {503, 337, 339}, m = "updateData")
        public static final class a extends qc.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f288a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f289b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object f290c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f291d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f292e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public /* synthetic */ Object f293f;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public int f295m;

            public a(oc.e<? super a> eVar) {
                super(eVar);
            }

            @Override // qc.a
            public final Object invokeSuspend(Object obj) {
                this.f293f = obj;
                this.f295m |= Integer.MIN_VALUE;
                return k.this.a(null, this);
            }
        }

        public k(pd.a aVar, s sVar, t<T> tVar, m<T> mVar) {
            this.f284a = aVar;
            this.f285b = sVar;
            this.f286c = tVar;
            this.f287d = mVar;
        }

        /* JADX WARN: Code duplicated, block: B:38:0x00ba A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:21:0x0052, B:36:0x00b2, B:38:0x00ba), top: B:53:0x0052 }] */
        /* JADX WARN: Code duplicated, block: B:40:0x00c8 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:41:0x00c9  */
        /* JADX WARN: Code duplicated, block: B:43:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // a1.i
        public Object a(xc.p<? super T, ? super oc.e<? super T>, ? extends Object> pVar, oc.e<? super T> eVar) throws Throwable {
            a aVar;
            pd.a aVar2;
            m mVar;
            s sVar;
            t<T> tVar;
            pd.a aVar3;
            pd.a aVar4;
            m mVar2;
            T t10;
            t<T> tVar2;
            if (eVar instanceof a) {
                aVar = (a) eVar;
                int i10 = aVar.f295m;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    aVar.f295m = i10 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(eVar);
                }
            } else {
                aVar = new a(eVar);
            }
            Object obj = aVar.f293f;
            Object objC = pc.c.c();
            int i11 = aVar.f295m;
            try {
                if (i11 == 0) {
                    lc.k.b(obj);
                    aVar2 = this.f284a;
                    s sVar2 = this.f285b;
                    t<T> tVar3 = this.f286c;
                    mVar = this.f287d;
                    aVar.f288a = pVar;
                    aVar.f289b = aVar2;
                    aVar.f290c = sVar2;
                    aVar.f291d = tVar3;
                    aVar.f292e = mVar;
                    aVar.f295m = 1;
                    if (aVar2.b(null, aVar) == objC) {
                        return objC;
                    }
                    sVar = sVar2;
                    tVar = tVar3;
                } else {
                    if (i11 != 1) {
                        if (i11 != 2) {
                            if (i11 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            t10 = (T) aVar.f290c;
                            tVar2 = (t) aVar.f289b;
                            aVar3 = (pd.a) aVar.f288a;
                            try {
                                lc.k.b(obj);
                                tVar2.f12381a = t10;
                                tVar = tVar2;
                                T t11 = tVar.f12381a;
                                aVar3.a(null);
                                return t11;
                            } catch (Throwable th) {
                                th = th;
                                aVar3.a(null);
                                throw th;
                            }
                        }
                        m mVar3 = (m) aVar.f290c;
                        tVar = (t) aVar.f289b;
                        aVar4 = (pd.a) aVar.f288a;
                        try {
                            lc.k.b(obj);
                            mVar2 = mVar3;
                            if (kotlin.jvm.internal.k.a(obj, tVar.f12381a)) {
                                aVar3 = aVar4;
                            } else {
                                aVar.f288a = aVar4;
                                aVar.f289b = tVar;
                                aVar.f290c = obj;
                                aVar.f295m = 3;
                                if (mVar2.z(obj, aVar) == objC) {
                                    return objC;
                                }
                                t10 = (T) obj;
                                tVar2 = tVar;
                                aVar3 = aVar4;
                                tVar2.f12381a = t10;
                                tVar = tVar2;
                            }
                            T t12 = tVar.f12381a;
                            aVar3.a(null);
                            return t12;
                        } catch (Throwable th2) {
                            th = th2;
                            aVar3 = aVar4;
                            aVar3.a(null);
                            throw th;
                        }
                    }
                    m mVar4 = (m) aVar.f292e;
                    tVar = (t) aVar.f291d;
                    sVar = (s) aVar.f290c;
                    pd.a aVar5 = (pd.a) aVar.f289b;
                    xc.p<? super T, ? super oc.e<? super T>, ? extends Object> pVar2 = (xc.p) aVar.f288a;
                    lc.k.b(obj);
                    aVar2 = aVar5;
                    mVar = mVar4;
                    pVar = pVar2;
                }
                if (sVar.f12380a) {
                    throw new IllegalStateException("InitializerApi.updateData should not be called after initialization is complete.");
                }
                T t13 = tVar.f12381a;
                aVar.f288a = aVar2;
                aVar.f289b = tVar;
                aVar.f290c = mVar;
                aVar.f291d = null;
                aVar.f292e = null;
                aVar.f295m = 2;
                Object objInvoke = pVar.invoke(t13, aVar);
                if (objInvoke == objC) {
                    return objC;
                }
                aVar4 = aVar2;
                obj = objInvoke;
                mVar2 = mVar;
                if (kotlin.jvm.internal.k.a(obj, tVar.f12381a)) {
                    aVar.f288a = aVar4;
                    aVar.f289b = tVar;
                    aVar.f290c = obj;
                    aVar.f295m = 3;
                    if (mVar2.z(obj, aVar) == objC) {
                        return objC;
                    }
                    t10 = (T) obj;
                    tVar2 = tVar;
                    aVar3 = aVar4;
                    tVar2.f12381a = t10;
                    tVar = tVar2;
                } else {
                    aVar3 = aVar4;
                }
                T t14 = tVar.f12381a;
                aVar3.a(null);
                return t14;
            } catch (Throwable th3) {
                th = th3;
                aVar3 = aVar2;
                aVar3.a(null);
                throw th;
            }
        }
    }

    @qc.f(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {302}, m = "readAndInitOrPropagateAndThrowFailure")
    public static final class l extends qc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m<T> f298c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f299d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(m<T> mVar, oc.e<? super l> eVar) {
            super(eVar);
            this.f298c = mVar;
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f297b = obj;
            this.f299d |= Integer.MIN_VALUE;
            return this.f298c.u(this);
        }
    }

    /* JADX INFO: renamed from: a1.m$m, reason: collision with other inner class name */
    @qc.f(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {311}, m = "readAndInitOrPropagateFailure")
    public static final class C0005m extends qc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m<T> f302c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f303d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0005m(m<T> mVar, oc.e<? super C0005m> eVar) {
            super(eVar);
            this.f302c = mVar;
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f301b = obj;
            this.f303d |= Integer.MIN_VALUE;
            return this.f302c.v(this);
        }
    }

    @qc.f(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {381}, m = "readData")
    public static final class n extends qc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f305b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f306c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f307d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ m<T> f308e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f309f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(m<T> mVar, oc.e<? super n> eVar) {
            super(eVar);
            this.f308e = mVar;
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f307d = obj;
            this.f309f |= Integer.MIN_VALUE;
            return this.f308e.w(this);
        }
    }

    @qc.f(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {359, 362, 365}, m = "readDataOrHandleCorruption")
    public static final class o extends qc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ m<T> f313d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f314e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(m<T> mVar, oc.e<? super o> eVar) {
            super(eVar);
            this.f313d = mVar;
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f312c = obj;
            this.f314e |= Integer.MIN_VALUE;
            return this.f313d.x(this);
        }
    }

    @qc.f(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {402, 410}, m = "transformAndWrite")
    public static final class p extends qc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f317c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f318d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ m<T> f319e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f320f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(m<T> mVar, oc.e<? super p> eVar) {
            super(eVar);
            this.f319e = mVar;
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f318d = obj;
            this.f320f |= Integer.MIN_VALUE;
            return this.f319e.y(null, null, this);
        }
    }

    @qc.f(c = "androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1", f = "SingleProcessDataStore.kt", l = {402}, m = "invokeSuspend")
    public static final class q extends qc.l implements xc.p<m0, oc.e<? super T>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ xc.p<T, oc.e<? super T>, Object> f322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ T f323c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public q(xc.p<? super T, ? super oc.e<? super T>, ? extends Object> pVar, T t10, oc.e<? super q> eVar) {
            super(2, eVar);
            this.f322b = pVar;
            this.f323c = t10;
        }

        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(m0 m0Var, oc.e<? super T> eVar) {
            return ((q) create(m0Var, eVar)).invokeSuspend(lc.q.f12711a);
        }

        @Override // qc.a
        public final oc.e<lc.q> create(Object obj, oc.e<?> eVar) {
            return new q(this.f322b, this.f323c, eVar);
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = pc.c.c();
            int i10 = this.f321a;
            if (i10 == 0) {
                lc.k.b(obj);
                xc.p<T, oc.e<? super T>, Object> pVar = this.f322b;
                T t10 = this.f323c;
                this.f321a = 1;
                obj = pVar.invoke(t10, this);
                if (obj == objC) {
                    return objC;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lc.k.b(obj);
            }
            return obj;
        }
    }

    @qc.f(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {426}, m = "writeData$datastore_core")
    public static final class r extends qc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f325b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f326c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f327d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f328e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public /* synthetic */ Object f329f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ m<T> f330l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f331m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(m<T> mVar, oc.e<? super r> eVar) {
            super(eVar);
            this.f330l = mVar;
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f329f = obj;
            this.f331m |= Integer.MIN_VALUE;
            return this.f330l.z(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(xc.a<? extends File> produceFile, a1.k<T> serializer, List<? extends xc.p<? super a1.i<T>, ? super oc.e<? super lc.q>, ? extends Object>> initTasksList, a1.b<T> corruptionHandler, m0 scope) {
        kotlin.jvm.internal.k.e(produceFile, "produceFile");
        kotlin.jvm.internal.k.e(serializer, "serializer");
        kotlin.jvm.internal.k.e(initTasksList, "initTasksList");
        kotlin.jvm.internal.k.e(corruptionHandler, "corruptionHandler");
        kotlin.jvm.internal.k.e(scope, "scope");
        this.f236a = produceFile;
        this.f237b = serializer;
        this.f238c = corruptionHandler;
        this.f239d = scope;
        this.f240e = jd.f.g(new g(this, null));
        this.f241f = ".tmp";
        this.f242g = lc.g.a(new h(this));
        this.f243h = jd.t.a(a1.o.f332a);
        this.f244i = w.L(initTasksList);
        this.f245j = new a1.l<>(scope, new d(this), e.f253a, new f(this, null));
    }

    @Override // a1.f
    public jd.d<T> a() {
        return this.f240e;
    }

    public final void p(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            throw new IOException(kotlin.jvm.internal.k.j("Unable to create parent directories of ", file));
        }
    }

    public final File q() {
        return (File) this.f242g.getValue();
    }

    public final Object r(b.a<T> aVar, oc.e<? super lc.q> eVar) throws Throwable {
        a1.n<T> value = this.f243h.getValue();
        if (!(value instanceof a1.c)) {
            if (value instanceof a1.j) {
                if (value == aVar.a()) {
                    Object objV = v(eVar);
                    return objV == pc.c.c() ? objV : lc.q.f12711a;
                }
            } else {
                if (kotlin.jvm.internal.k.a(value, a1.o.f332a)) {
                    Object objV2 = v(eVar);
                    return objV2 == pc.c.c() ? objV2 : lc.q.f12711a;
                }
                if (value instanceof a1.h) {
                    throw new IllegalStateException("Can't read in final state.".toString());
                }
            }
        }
        return lc.q.f12711a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [a1.m] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [a1.m, a1.m<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [a1.m$b$b, a1.m$b$b<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15, types: [a1.m$b$b] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [gd.x] */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v35 */
    /* JADX WARN: Type inference failed for: r9v36 */
    /* JADX WARN: Type inference failed for: r9v6 */
    public final Object s(b.C0003b<T> c0003b, oc.e<? super lc.q> eVar) throws Throwable {
        i iVar;
        Object objB;
        ?? r10;
        x xVarA;
        ?? r11;
        Object objY;
        ?? r12;
        x xVar;
        if (eVar instanceof i) {
            iVar = (i) eVar;
            int i10 = iVar.f274f;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                iVar.f274f = i10 - Integer.MIN_VALUE;
            } else {
                iVar = new i(this, eVar);
            }
        } else {
            iVar = new i(this, eVar);
        }
        Object obj = iVar.f272d;
        Object objC = pc.c.c();
        int i11 = iVar.f274f;
        boolean z10 = true;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    xVar = (x) iVar.f269a;
                } else if (i11 == 2) {
                    x xVar2 = (x) iVar.f271c;
                    m mVar = (m) iVar.f270b;
                    b.C0003b c0003b2 = (b.C0003b) iVar.f269a;
                    lc.k.b(obj);
                    xVarA = xVar2;
                    r11 = mVar;
                    r12 = (b.C0003b<T>) c0003b2;
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    xVar = (b.C0003b<T>) ((x) iVar.f269a);
                }
                lc.k.b(obj);
                c0003b = xVar;
                objB = lc.j.b(obj);
                r10 = c0003b;
                z.c(r10, objB);
                return lc.q.f12711a;
            }
            lc.k.b(obj);
            xVarA = c0003b.a();
            try {
                lc.j.a aVar = lc.j.f12703b;
                a1.n<T> value = this.f243h.getValue();
                if (value instanceof a1.c) {
                    xc.p pVarD = c0003b.d();
                    oc.i iVarB = c0003b.b();
                    iVar.f269a = xVarA;
                    iVar.f274f = 1;
                    objY = y(pVarD, iVarB, iVar);
                    if (objY == objC) {
                        return objC;
                    }
                } else {
                    if (!(value instanceof a1.j)) {
                        z10 = value instanceof a1.o;
                    }
                    if (!z10) {
                        if (value instanceof a1.h) {
                            throw ((a1.h) value).a();
                        }
                        throw new lc.h();
                    }
                    if (value != c0003b.c()) {
                        throw ((a1.j) value).a();
                    }
                    iVar.f269a = c0003b;
                    iVar.f270b = this;
                    iVar.f271c = xVarA;
                    iVar.f274f = 2;
                    if (u(iVar) == objC) {
                        return objC;
                    }
                    r11 = this;
                    r12 = c0003b;
                }
                x xVar3 = xVarA;
                obj = objY;
                c0003b = xVar3;
                objB = lc.j.b(obj);
                r10 = c0003b;
            } catch (Throwable th) {
                th = th;
                c0003b = xVarA;
                lc.j.a aVar2 = lc.j.f12703b;
                objB = lc.j.b(lc.k.a(th));
                r10 = c0003b;
            }
            z.c(r10, objB);
            return lc.q.f12711a;
            xc.p pVarD2 = r12.d();
            oc.i iVarB2 = r12.b();
            iVar.f269a = xVarA;
            iVar.f270b = null;
            iVar.f271c = null;
            iVar.f274f = 3;
            objY = r11.y(pVarD2, iVarB2, iVar);
            if (objY == objC) {
                return objC;
            }
            x xVar4 = xVarA;
            obj = objY;
            c0003b = xVar4;
            objB = lc.j.b(obj);
            r10 = c0003b;
        } catch (Throwable th2) {
            th = th2;
        }
        z.c(r10, objB);
        return lc.q.f12711a;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:42:0x0116 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x0117  */
    /* JADX WARN: Code duplicated, block: B:47:0x0128  */
    /* JADX WARN: Code duplicated, block: B:58:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:? A[LOOP:0: B:34:0x00da->B:60:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [a1.m, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [a1.m] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [a1.m] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r13v0, types: [a1.m, a1.m<T>, java.lang.Object] */
    public final Object t(oc.e<? super lc.q> eVar) throws Throwable {
        j jVar;
        pd.a aVarB;
        t tVar;
        ?? r10;
        t tVar2;
        ?? r12;
        t tVar3;
        k kVar;
        Iterator<T> it;
        pd.a aVar;
        s sVar;
        pd.a aVar2;
        ?? r11;
        t tVar4;
        s sVar2;
        xc.p pVar;
        ?? r13;
        if (eVar instanceof j) {
            jVar = (j) eVar;
            int i10 = jVar.f283n;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                jVar.f283n = i10 - Integer.MIN_VALUE;
            } else {
                jVar = new j(this, eVar);
            }
        } else {
            jVar = new j(this, eVar);
        }
        T t10 = (T) jVar.f281l;
        Object objC = pc.c.c();
        int i11 = jVar.f283n;
        if (i11 != 0) {
            if (i11 == 1) {
                tVar = (t) jVar.f278d;
                tVar2 = (t) jVar.f277c;
                aVarB = (pd.a) jVar.f276b;
                m mVar = (m) jVar.f275a;
                lc.k.b(t10);
                r10 = mVar;
            } else if (i11 == 2) {
                it = (Iterator) jVar.f280f;
                kVar = (k) jVar.f279e;
                sVar = (s) jVar.f278d;
                tVar3 = (t) jVar.f277c;
                aVar = (pd.a) jVar.f276b;
                m mVar2 = (m) jVar.f275a;
                lc.k.b(t10);
                r12 = mVar2;
                while (it.hasNext()) {
                    pVar = (xc.p) it.next();
                    jVar.f275a = r12;
                    jVar.f276b = aVar;
                    jVar.f277c = tVar3;
                    jVar.f278d = sVar;
                    jVar.f279e = kVar;
                    jVar.f280f = it;
                    jVar.f283n = 2;
                    if (pVar.invoke(kVar, jVar) == objC) {
                        return objC;
                    }
                }
                tVar2 = tVar3;
                aVar2 = aVar;
                r11 = r12;
                r11.f244i = null;
                jVar.f275a = r11;
                jVar.f276b = tVar2;
                jVar.f277c = sVar;
                jVar.f278d = aVar2;
                jVar.f279e = null;
                jVar.f280f = null;
                jVar.f283n = 3;
                if (aVar2.b(null, jVar) == objC) {
                    return objC;
                }
                tVar4 = tVar2;
                sVar2 = sVar;
                r13 = r11;
            } else {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aVar2 = (pd.a) jVar.f278d;
                sVar2 = (s) jVar.f277c;
                tVar4 = (t) jVar.f276b;
                m mVar3 = (m) jVar.f275a;
                lc.k.b(t10);
                r13 = mVar3;
            }
            try {
                sVar2.f12380a = true;
                lc.q qVar = lc.q.f12711a;
                aVar2.a(null);
                jd.n<a1.n<T>> nVar = r13.f243h;
                T t11 = tVar4.f12381a;
                nVar.setValue(new a1.c(t11, t11 != null ? t11.hashCode() : 0));
                return lc.q.f12711a;
            } catch (Throwable th) {
                aVar2.a(null);
                throw th;
            }
        }
        lc.k.b(t10);
        if (!(kotlin.jvm.internal.k.a(this.f243h.getValue(), a1.o.f332a) || (this.f243h.getValue() instanceof a1.j))) {
            throw new IllegalStateException("Check failed.".toString());
        }
        aVarB = pd.c.b(false, 1, null);
        tVar = new t();
        jVar.f275a = this;
        jVar.f276b = aVarB;
        jVar.f277c = tVar;
        jVar.f278d = tVar;
        jVar.f283n = 1;
        t10 = (T) x(jVar);
        if (t10 == objC) {
            return objC;
        }
        r10 = this;
        tVar2 = tVar;
        tVar.f12381a = t10;
        s sVar3 = new s();
        k kVar2 = new k(aVarB, sVar3, tVar2, r10);
        List<? extends xc.p<? super a1.i<T>, ? super oc.e<? super lc.q>, ? extends Object>> list = r10.f244i;
        if (list == null) {
            aVar2 = aVarB;
            sVar = sVar3;
            r11 = r10;
        } else {
            r12 = r10;
            tVar3 = tVar2;
            kVar = kVar2;
            it = list.iterator();
            aVar = aVarB;
            sVar = sVar3;
            while (it.hasNext()) {
                pVar = (xc.p) it.next();
                jVar.f275a = r12;
                jVar.f276b = aVar;
                jVar.f277c = tVar3;
                jVar.f278d = sVar;
                jVar.f279e = kVar;
                jVar.f280f = it;
                jVar.f283n = 2;
                if (pVar.invoke(kVar, jVar) == objC) {
                    return objC;
                }
            }
            tVar2 = tVar3;
            aVar2 = aVar;
            r11 = r12;
        }
        r11.f244i = null;
        jVar.f275a = r11;
        jVar.f276b = tVar2;
        jVar.f277c = sVar;
        jVar.f278d = aVar2;
        jVar.f279e = null;
        jVar.f280f = null;
        jVar.f283n = 3;
        if (aVar2.b(null, jVar) == objC) {
            return objC;
        }
        tVar4 = tVar2;
        sVar2 = sVar;
        r13 = r11;
        sVar2.f12380a = true;
        lc.q qVar2 = lc.q.f12711a;
        aVar2.a(null);
        jd.n<a1.n<T>> nVar2 = r13.f243h;
        T t12 = tVar4.f12381a;
        nVar2.setValue(new a1.c(t12, t12 != null ? t12.hashCode() : 0));
        return lc.q.f12711a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object u(oc.e<? super lc.q> eVar) throws Throwable {
        l lVar;
        m mVar;
        if (eVar instanceof l) {
            lVar = (l) eVar;
            int i10 = lVar.f299d;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                lVar.f299d = i10 - Integer.MIN_VALUE;
            } else {
                lVar = new l(this, eVar);
            }
        } else {
            lVar = new l(this, eVar);
        }
        Object obj = lVar.f297b;
        Object objC = pc.c.c();
        int i11 = lVar.f299d;
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mVar = (m) lVar.f296a;
            try {
                lc.k.b(obj);
                return lc.q.f12711a;
            } catch (Throwable th) {
                th = th;
                mVar.f243h.setValue(new a1.j(th));
                throw th;
            }
        }
        lc.k.b(obj);
        try {
            lVar.f296a = this;
            lVar.f299d = 1;
            if (t(lVar) == objC) {
                return objC;
            }
            return lc.q.f12711a;
        } catch (Throwable th2) {
            th = th2;
            mVar = this;
            mVar.f243h.setValue(new a1.j(th));
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object v(oc.e<? super lc.q> eVar) throws Throwable {
        C0005m c0005m;
        m mVar;
        if (eVar instanceof C0005m) {
            c0005m = (C0005m) eVar;
            int i10 = c0005m.f303d;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0005m.f303d = i10 - Integer.MIN_VALUE;
            } else {
                c0005m = new C0005m(this, eVar);
            }
        } else {
            c0005m = new C0005m(this, eVar);
        }
        Object obj = c0005m.f301b;
        Object objC = pc.c.c();
        int i11 = c0005m.f303d;
        if (i11 == 0) {
            lc.k.b(obj);
            try {
                c0005m.f300a = this;
                c0005m.f303d = 1;
                if (t(c0005m) == objC) {
                    return objC;
                }
            } catch (Throwable th) {
                th = th;
                mVar = this;
                mVar.f243h.setValue(new a1.j(th));
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mVar = (m) c0005m.f300a;
            try {
                lc.k.b(obj);
            } catch (Throwable th2) {
                th = th2;
                mVar.f243h.setValue(new a1.j(th));
            }
        }
        return lc.q.f12711a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [a1.m] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2, types: [a1.m$n, oc.e] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [a1.m] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream, java.io.InputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r6v9, types: [a1.k, a1.k<T>] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object w(oc.e<? super T> eVar) throws Throwable {
        ?? nVar;
        ?? fileInputStream;
        Throwable th;
        ?? r10;
        if (eVar instanceof n) {
            n nVar2 = (n) eVar;
            int i10 = nVar2.f309f;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                nVar2.f309f = i10 - Integer.MIN_VALUE;
                nVar = nVar2;
            } else {
                nVar = new n(this, eVar);
            }
        } else {
            nVar = new n(this, eVar);
        }
        Object objC = nVar.f307d;
        Object objC2 = pc.c.c();
        int i11 = nVar.f309f;
        try {
            if (i11 != 0) {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) nVar.f306c;
                fileInputStream = (Closeable) nVar.f305b;
                nVar = (m) nVar.f304a;
                try {
                    lc.k.b(objC);
                    r10 = fileInputStream;
                    vc.b.a(r10, th);
                    return objC;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        vc.b.a(fileInputStream, th);
                        throw th3;
                    }
                }
            }
            lc.k.b(objC);
            try {
                fileInputStream = new FileInputStream(q());
                try {
                    a1.k<T> kVar = this.f237b;
                    nVar.f304a = this;
                    nVar.f305b = fileInputStream;
                    nVar.f306c = null;
                    nVar.f309f = 1;
                    objC = kVar.c(fileInputStream, nVar);
                    if (objC == objC2) {
                        return objC2;
                    }
                    th = null;
                    r10 = fileInputStream;
                    vc.b.a(r10, th);
                    return objC;
                } catch (Throwable th4) {
                    th = th4;
                    nVar = this;
                    throw th;
                }
            } catch (FileNotFoundException e10) {
                e = e10;
                nVar = this;
                if (nVar.q().exists()) {
                    throw e;
                }
                return nVar.f237b.a();
            }
        } catch (FileNotFoundException e11) {
            e = e11;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0074 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:39:0x0085 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x0086  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [a1.m, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [a1.m] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [a1.m] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r7v0, types: [a1.m, a1.m<T>, java.lang.Object] */
    public final Object x(oc.e<? super T> eVar) throws Throwable {
        o oVar;
        ?? r10;
        Object objA;
        a1.a aVar;
        ?? r11;
        a1.a aVar2;
        if (eVar instanceof o) {
            oVar = (o) eVar;
            int i10 = oVar.f314e;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                oVar.f314e = i10 - Integer.MIN_VALUE;
            } else {
                oVar = new o(this, eVar);
            }
        } else {
            oVar = new o(this, eVar);
        }
        Object objW = oVar.f312c;
        Object objC = pc.c.c();
        int i11 = oVar.f314e;
        if (i11 == 0) {
            lc.k.b(objW);
            try {
                oVar.f310a = this;
                oVar.f314e = 1;
                objW = w(oVar);
                return objW == objC ? objC : objW;
            } catch (a1.a e10) {
                e = e10;
                r10 = this;
                a1.b<T> bVar = r10.f238c;
                oVar.f310a = r10;
                oVar.f311b = e;
                oVar.f314e = 2;
                objA = bVar.a(e, oVar);
                if (objA == objC) {
                    return objC;
                }
                ?? r12 = r10;
                aVar = e;
                objW = objA;
                r11 = r12;
                oVar.f310a = aVar;
                oVar.f311b = objW;
                oVar.f314e = 3;
                if (r11.z(objW, oVar) == objC) {
                    return objC;
                }
                return objW;
            }
        }
        if (i11 != 1) {
            if (i11 == 2) {
                aVar = (a1.a) oVar.f311b;
                m mVar = (m) oVar.f310a;
                lc.k.b(objW);
                r11 = mVar;
            } else {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj = oVar.f311b;
                aVar2 = (a1.a) oVar.f310a;
                try {
                    lc.k.b(objW);
                    return obj;
                } catch (IOException e11) {
                    e = e11;
                }
            }
            lc.a.a(aVar2, e);
            throw aVar2;
        }
        r10 = (m) oVar.f310a;
        try {
            lc.k.b(objW);
        } catch (a1.a e12) {
            e = e12;
            a1.b<T> bVar2 = r10.f238c;
            oVar.f310a = r10;
            oVar.f311b = e;
            oVar.f314e = 2;
            objA = bVar2.a(e, oVar);
            if (objA == objC) {
                return objC;
            }
            ?? r13 = r10;
            aVar = e;
            objW = objA;
            r11 = r13;
            oVar.f310a = aVar;
            oVar.f311b = objW;
            oVar.f314e = 3;
            if (r11.z(objW, oVar) == objC) {
                return objC;
            }
            return objW;
        }
        try {
            oVar.f310a = aVar;
            oVar.f311b = objW;
            oVar.f314e = 3;
            if (r11.z(objW, oVar) == objC) {
                return objC;
            }
            return objW;
        } catch (IOException e13) {
            e = e13;
            aVar2 = aVar;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0094  */
    /* JADX WARN: Code duplicated, block: B:30:0x0099  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object y(xc.p<? super T, ? super oc.e<? super T>, ? extends Object> pVar, oc.i iVar, oc.e<? super T> eVar) throws Throwable {
        p pVar2;
        a1.c cVar;
        Object obj;
        m mVar;
        m mVar2;
        int iHashCode;
        if (eVar instanceof p) {
            pVar2 = (p) eVar;
            int i10 = pVar2.f320f;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                pVar2.f320f = i10 - Integer.MIN_VALUE;
            } else {
                pVar2 = new p(this, eVar);
            }
        } else {
            pVar2 = new p(this, eVar);
        }
        Object obj2 = pVar2.f318d;
        Object objC = pc.c.c();
        int i11 = pVar2.f320f;
        if (i11 != 0) {
            if (i11 == 1) {
                obj = pVar2.f317c;
                cVar = (a1.c) pVar2.f316b;
                m mVar3 = (m) pVar2.f315a;
                lc.k.b(obj2);
                mVar = mVar3;
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = pVar2.f316b;
                m mVar4 = (m) pVar2.f315a;
                lc.k.b(obj2);
                mVar2 = mVar4;
            }
            jd.n<a1.n<T>> nVar = mVar2.f243h;
            if (obj != null) {
                iHashCode = obj.hashCode();
            } else {
                iHashCode = 0;
            }
            nVar.setValue(new a1.c(obj, iHashCode));
            return obj;
        }
        lc.k.b(obj2);
        a1.c cVar2 = (a1.c) this.f243h.getValue();
        cVar2.a();
        Object objB = cVar2.b();
        q qVar = new q(pVar, objB, null);
        pVar2.f315a = this;
        pVar2.f316b = cVar2;
        pVar2.f317c = objB;
        pVar2.f320f = 1;
        Object objG = gd.i.g(iVar, qVar, pVar2);
        if (objG == objC) {
            return objC;
        }
        cVar = cVar2;
        obj2 = objG;
        obj = objB;
        mVar = this;
        cVar.a();
        if (!kotlin.jvm.internal.k.a(obj, obj2)) {
            pVar2.f315a = mVar;
            pVar2.f316b = obj2;
            pVar2.f317c = null;
            pVar2.f320f = 2;
            if (mVar.z(obj2, pVar2) == objC) {
                return objC;
            }
            obj = obj2;
            mVar2 = mVar;
            jd.n<a1.n<T>> nVar2 = mVar2.f243h;
            if (obj != null) {
                iHashCode = obj.hashCode();
            } else {
                iHashCode = 0;
            }
            nVar2.setValue(new a1.c(obj, iHashCode));
        }
        return obj;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileOutputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.lang.StringBuilder] */
    public final Object z(T t10, oc.e<? super lc.q> eVar) throws Throwable {
        r rVar;
        ?? file;
        ?? fileOutputStream;
        m<T> mVar;
        ?? r10;
        Throwable th;
        if (eVar instanceof r) {
            rVar = (r) eVar;
            int i10 = rVar.f331m;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                rVar.f331m = i10 - Integer.MIN_VALUE;
            } else {
                rVar = new r(this, eVar);
            }
        } else {
            rVar = new r(this, eVar);
        }
        Object obj = rVar.f329f;
        Object objC = pc.c.c();
        int i11 = rVar.f331m;
        ?? r11 = 1;
        try {
            if (i11 == 0) {
                lc.k.b(obj);
                p(q());
                file = new File(kotlin.jvm.internal.k.j(q().getAbsolutePath(), this.f241f));
                try {
                    fileOutputStream = new FileOutputStream((File) file);
                    try {
                        a1.k<T> kVar = this.f237b;
                        c cVar = new c(fileOutputStream);
                        rVar.f324a = this;
                        rVar.f325b = file;
                        rVar.f326c = fileOutputStream;
                        rVar.f327d = null;
                        rVar.f328e = fileOutputStream;
                        rVar.f331m = 1;
                        if (kVar.b(t10, cVar, rVar) == objC) {
                            return objC;
                        }
                        mVar = this;
                        r11 = file;
                        r10 = fileOutputStream;
                        th = null;
                        fileOutputStream = fileOutputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        r11 = file;
                        throw th;
                    }
                } catch (IOException e10) {
                    e = e10;
                    if (file.exists()) {
                        file.delete();
                    }
                    throw e;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                FileOutputStream fileOutputStream2 = (FileOutputStream) rVar.f328e;
                th = (Throwable) rVar.f327d;
                fileOutputStream = (Closeable) rVar.f326c;
                r11 = (File) rVar.f325b;
                mVar = (m) rVar.f324a;
                try {
                    lc.k.b(obj);
                    fileOutputStream = fileOutputStream;
                    r11 = r11;
                    r10 = fileOutputStream2;
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        vc.b.a(fileOutputStream, th);
                        throw th4;
                    }
                }
            }
            r10.getFD().sync();
            lc.q qVar = lc.q.f12711a;
            vc.b.a(fileOutputStream, th);
            if (r11.renameTo(mVar.q())) {
                return lc.q.f12711a;
            }
            throw new IOException("Unable to rename " + r11 + ".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file.");
        } catch (IOException e11) {
            e = e11;
            file = r11;
            if (file.exists()) {
                file.delete();
            }
            throw e;
        }
    }
}
