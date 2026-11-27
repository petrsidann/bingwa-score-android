package x8;

import d9.a0;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f18014p = new C0321a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f18015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f18018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f18019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f18020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f18021g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f18022h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f18023i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f18024j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f18025k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f18026l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f18027m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f18028n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f18029o;

    /* JADX INFO: renamed from: x8.a$a, reason: collision with other inner class name */
    public static final class C0321a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f18030a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f18031b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f18032c = "";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f18033d = c.UNKNOWN;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d f18034e = d.UNKNOWN_OS;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f18035f = "";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f18036g = "";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f18037h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f18038i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f18039j = "";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f18040k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public b f18041l = b.UNKNOWN_EVENT;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f18042m = "";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f18043n = 0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f18044o = "";

        public a a() {
            return new a(this.f18030a, this.f18031b, this.f18032c, this.f18033d, this.f18034e, this.f18035f, this.f18036g, this.f18037h, this.f18038i, this.f18039j, this.f18040k, this.f18041l, this.f18042m, this.f18043n, this.f18044o);
        }

        public C0321a b(String str) {
            this.f18042m = str;
            return this;
        }

        public C0321a c(String str) {
            this.f18036g = str;
            return this;
        }

        public C0321a d(String str) {
            this.f18044o = str;
            return this;
        }

        public C0321a e(b bVar) {
            this.f18041l = bVar;
            return this;
        }

        public C0321a f(String str) {
            this.f18032c = str;
            return this;
        }

        public C0321a g(String str) {
            this.f18031b = str;
            return this;
        }

        public C0321a h(c cVar) {
            this.f18033d = cVar;
            return this;
        }

        public C0321a i(String str) {
            this.f18035f = str;
            return this;
        }

        public C0321a j(int i10) {
            this.f18037h = i10;
            return this;
        }

        public C0321a k(long j10) {
            this.f18030a = j10;
            return this;
        }

        public C0321a l(d dVar) {
            this.f18034e = dVar;
            return this;
        }

        public C0321a m(String str) {
            this.f18039j = str;
            return this;
        }

        public C0321a n(int i10) {
            this.f18038i = i10;
            return this;
        }
    }

    public enum b implements z7.c {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        MESSAGE_OPEN(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18049a;

        b(int i10) {
            this.f18049a = i10;
        }

        @Override // z7.c
        public int a() {
            return this.f18049a;
        }
    }

    public enum c implements z7.c {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18055a;

        c(int i10) {
            this.f18055a = i10;
        }

        @Override // z7.c
        public int a() {
            return this.f18055a;
        }
    }

    public enum d implements z7.c {
        UNKNOWN_OS(0),
        ANDROID(1),
        IOS(2),
        WEB(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18061a;

        d(int i10) {
            this.f18061a = i10;
        }

        @Override // z7.c
        public int a() {
            return this.f18061a;
        }
    }

    public a(long j10, String str, String str2, c cVar, d dVar, String str3, String str4, int i10, int i11, String str5, long j11, b bVar, String str6, long j12, String str7) {
        this.f18015a = j10;
        this.f18016b = str;
        this.f18017c = str2;
        this.f18018d = cVar;
        this.f18019e = dVar;
        this.f18020f = str3;
        this.f18021g = str4;
        this.f18022h = i10;
        this.f18023i = i11;
        this.f18024j = str5;
        this.f18025k = j11;
        this.f18026l = bVar;
        this.f18027m = str6;
        this.f18028n = j12;
        this.f18029o = str7;
    }

    public static C0321a p() {
        return new C0321a();
    }

    @z7.d(tag = 13)
    public String a() {
        return this.f18027m;
    }

    @z7.d(tag = 11)
    public long b() {
        return this.f18025k;
    }

    @z7.d(tag = 14)
    public long c() {
        return this.f18028n;
    }

    @z7.d(tag = 7)
    public String d() {
        return this.f18021g;
    }

    @z7.d(tag = 15)
    public String e() {
        return this.f18029o;
    }

    @z7.d(tag = a0.EXPECTED_COUNT_FIELD_NUMBER)
    public b f() {
        return this.f18026l;
    }

    @z7.d(tag = 3)
    public String g() {
        return this.f18017c;
    }

    @z7.d(tag = 2)
    public String h() {
        return this.f18016b;
    }

    @z7.d(tag = 4)
    public c i() {
        return this.f18018d;
    }

    @z7.d(tag = 6)
    public String j() {
        return this.f18020f;
    }

    @z7.d(tag = 8)
    public int k() {
        return this.f18022h;
    }

    @z7.d(tag = 1)
    public long l() {
        return this.f18015a;
    }

    @z7.d(tag = 5)
    public d m() {
        return this.f18019e;
    }

    @z7.d(tag = 10)
    public String n() {
        return this.f18024j;
    }

    @z7.d(tag = 9)
    public int o() {
        return this.f18023i;
    }
}
