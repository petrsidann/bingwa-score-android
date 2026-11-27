package vb;

import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
public final class b1<ReqT, RespT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f17255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c<ReqT> f17258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c<RespT> f17259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f17260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f17261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f17262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f17263i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicReferenceArray<Object> f17264j;

    public static final class b<ReqT, RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c<ReqT> f17265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c<RespT> f17266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f17267c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f17268d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f17269e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f17270f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Object f17271g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f17272h;

        public b() {
        }

        public b1<ReqT, RespT> a() {
            return new b1<>(this.f17267c, this.f17268d, this.f17265a, this.f17266b, this.f17271g, this.f17269e, this.f17270f, this.f17272h);
        }

        public b<ReqT, RespT> b(String str) {
            this.f17268d = str;
            return this;
        }

        public b<ReqT, RespT> c(c<ReqT> cVar) {
            this.f17265a = cVar;
            return this;
        }

        public b<ReqT, RespT> d(c<RespT> cVar) {
            this.f17266b = cVar;
            return this;
        }

        public b<ReqT, RespT> e(boolean z10) {
            this.f17272h = z10;
            return this;
        }

        public b<ReqT, RespT> f(d dVar) {
            this.f17267c = dVar;
            return this;
        }
    }

    public interface c<T> {
        T a(InputStream inputStream);

        InputStream b(T t10);
    }

    public enum d {
        UNARY,
        CLIENT_STREAMING,
        SERVER_STREAMING,
        BIDI_STREAMING,
        UNKNOWN;

        public final boolean d() {
            return this == UNARY || this == SERVER_STREAMING;
        }
    }

    public b1(d dVar, String str, c<ReqT> cVar, c<RespT> cVar2, Object obj, boolean z10, boolean z11, boolean z12) {
        this.f17264j = new AtomicReferenceArray<>(2);
        this.f17255a = (d) j6.m.p(dVar, "type");
        this.f17256b = (String) j6.m.p(str, "fullMethodName");
        this.f17257c = a(str);
        this.f17258d = (c) j6.m.p(cVar, "requestMarshaller");
        this.f17259e = (c) j6.m.p(cVar2, "responseMarshaller");
        this.f17260f = obj;
        this.f17261g = z10;
        this.f17262h = z11;
        this.f17263i = z12;
    }

    public static String a(String str) {
        int iLastIndexOf = ((String) j6.m.p(str, "fullMethodName")).lastIndexOf(47);
        if (iLastIndexOf == -1) {
            return null;
        }
        return str.substring(0, iLastIndexOf);
    }

    public static String b(String str, String str2) {
        return ((String) j6.m.p(str, "fullServiceName")) + "/" + ((String) j6.m.p(str2, "methodName"));
    }

    public static <ReqT, RespT> b<ReqT, RespT> g() {
        return h(null, null);
    }

    public static <ReqT, RespT> b<ReqT, RespT> h(c<ReqT> cVar, c<RespT> cVar2) {
        return new b().c(cVar).d(cVar2);
    }

    public String c() {
        return this.f17256b;
    }

    public String d() {
        return this.f17257c;
    }

    public d e() {
        return this.f17255a;
    }

    public boolean f() {
        return this.f17262h;
    }

    public RespT i(InputStream inputStream) {
        return this.f17259e.a(inputStream);
    }

    public InputStream j(ReqT reqt) {
        return this.f17258d.b(reqt);
    }

    public String toString() {
        return j6.g.b(this).d("fullMethodName", this.f17256b).d("type", this.f17255a).e("idempotent", this.f17261g).e("safe", this.f17262h).e("sampledToLocalTracing", this.f17263i).d("requestMarshaller", this.f17258d).d("responseMarshaller", this.f17259e).d("schemaDescriptor", this.f17260f).m().toString();
    }
}
