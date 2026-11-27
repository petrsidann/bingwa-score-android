package c3;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f3259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f3260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<l> f3262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p f3263g;

    public static final class b extends m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f3264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f3265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public k f3266c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f3267d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f3268e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<l> f3269f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public p f3270g;

        @Override // c3.m.a
        public m a() {
            String str = "";
            if (this.f3264a == null) {
                str = " requestTimeMs";
            }
            if (this.f3265b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new g(this.f3264a.longValue(), this.f3265b.longValue(), this.f3266c, this.f3267d, this.f3268e, this.f3269f, this.f3270g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // c3.m.a
        public m.a b(k kVar) {
            this.f3266c = kVar;
            return this;
        }

        @Override // c3.m.a
        public m.a c(List<l> list) {
            this.f3269f = list;
            return this;
        }

        @Override // c3.m.a
        public m.a d(Integer num) {
            this.f3267d = num;
            return this;
        }

        @Override // c3.m.a
        public m.a e(String str) {
            this.f3268e = str;
            return this;
        }

        @Override // c3.m.a
        public m.a f(p pVar) {
            this.f3270g = pVar;
            return this;
        }

        @Override // c3.m.a
        public m.a g(long j10) {
            this.f3264a = Long.valueOf(j10);
            return this;
        }

        @Override // c3.m.a
        public m.a h(long j10) {
            this.f3265b = Long.valueOf(j10);
            return this;
        }
    }

    public g(long j10, long j11, k kVar, Integer num, String str, List<l> list, p pVar) {
        this.f3257a = j10;
        this.f3258b = j11;
        this.f3259c = kVar;
        this.f3260d = num;
        this.f3261e = str;
        this.f3262f = list;
        this.f3263g = pVar;
    }

    @Override // c3.m
    public k b() {
        return this.f3259c;
    }

    @Override // c3.m
    public List<l> c() {
        return this.f3262f;
    }

    @Override // c3.m
    public Integer d() {
        return this.f3260d;
    }

    @Override // c3.m
    public String e() {
        return this.f3261e;
    }

    public boolean equals(Object obj) {
        k kVar;
        Integer num;
        String str;
        List<l> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f3257a == mVar.g() && this.f3258b == mVar.h() && ((kVar = this.f3259c) != null ? kVar.equals(mVar.b()) : mVar.b() == null) && ((num = this.f3260d) != null ? num.equals(mVar.d()) : mVar.d() == null) && ((str = this.f3261e) != null ? str.equals(mVar.e()) : mVar.e() == null) && ((list = this.f3262f) != null ? list.equals(mVar.c()) : mVar.c() == null)) {
            p pVar = this.f3263g;
            p pVarF = mVar.f();
            if (pVar == null) {
                if (pVarF == null) {
                    return true;
                }
            } else if (pVar.equals(pVarF)) {
                return true;
            }
        }
        return false;
    }

    @Override // c3.m
    public p f() {
        return this.f3263g;
    }

    @Override // c3.m
    public long g() {
        return this.f3257a;
    }

    @Override // c3.m
    public long h() {
        return this.f3258b;
    }

    public int hashCode() {
        long j10 = this.f3257a;
        long j11 = this.f3258b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003;
        k kVar = this.f3259c;
        int iHashCode = (i10 ^ (kVar == null ? 0 : kVar.hashCode())) * 1000003;
        Integer num = this.f3260d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f3261e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<l> list = this.f3262f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        p pVar = this.f3263g;
        return iHashCode4 ^ (pVar != null ? pVar.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f3257a + ", requestUptimeMs=" + this.f3258b + ", clientInfo=" + this.f3259c + ", logSource=" + this.f3260d + ", logSourceName=" + this.f3261e + ", logEvents=" + this.f3262f + ", qosTier=" + this.f3263g + "}";
    }
}
