package d3;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f6304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f6305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f6306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f6307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f6308f;

    /* JADX INFO: renamed from: d3.b$b, reason: collision with other inner class name */
    public static final class C0111b extends i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f6310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h f6311c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f6312d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f6313e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map<String, String> f6314f;

        @Override // d3.i.a
        public i d() {
            String str = "";
            if (this.f6309a == null) {
                str = " transportName";
            }
            if (this.f6311c == null) {
                str = str + " encodedPayload";
            }
            if (this.f6312d == null) {
                str = str + " eventMillis";
            }
            if (this.f6313e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f6314f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new b(this.f6309a, this.f6310b, this.f6311c, this.f6312d.longValue(), this.f6313e.longValue(), this.f6314f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // d3.i.a
        public Map<String, String> e() {
            Map<String, String> map = this.f6314f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // d3.i.a
        public i.a f(Map<String, String> map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f6314f = map;
            return this;
        }

        @Override // d3.i.a
        public i.a g(Integer num) {
            this.f6310b = num;
            return this;
        }

        @Override // d3.i.a
        public i.a h(h hVar) {
            if (hVar == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.f6311c = hVar;
            return this;
        }

        @Override // d3.i.a
        public i.a i(long j10) {
            this.f6312d = Long.valueOf(j10);
            return this;
        }

        @Override // d3.i.a
        public i.a j(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f6309a = str;
            return this;
        }

        @Override // d3.i.a
        public i.a k(long j10) {
            this.f6313e = Long.valueOf(j10);
            return this;
        }
    }

    public b(String str, Integer num, h hVar, long j10, long j11, Map<String, String> map) {
        this.f6303a = str;
        this.f6304b = num;
        this.f6305c = hVar;
        this.f6306d = j10;
        this.f6307e = j11;
        this.f6308f = map;
    }

    @Override // d3.i
    public Map<String, String> c() {
        return this.f6308f;
    }

    @Override // d3.i
    public Integer d() {
        return this.f6304b;
    }

    @Override // d3.i
    public h e() {
        return this.f6305c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f6303a.equals(iVar.j()) && ((num = this.f6304b) != null ? num.equals(iVar.d()) : iVar.d() == null) && this.f6305c.equals(iVar.e()) && this.f6306d == iVar.f() && this.f6307e == iVar.k() && this.f6308f.equals(iVar.c());
    }

    @Override // d3.i
    public long f() {
        return this.f6306d;
    }

    public int hashCode() {
        int iHashCode = (this.f6303a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f6304b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f6305c.hashCode()) * 1000003;
        long j10 = this.f6306d;
        int i10 = (iHashCode2 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f6307e;
        return ((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f6308f.hashCode();
    }

    @Override // d3.i
    public String j() {
        return this.f6303a;
    }

    @Override // d3.i
    public long k() {
        return this.f6307e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f6303a + ", code=" + this.f6304b + ", encodedPayload=" + this.f6305c + ", eventMillis=" + this.f6306d + ", uptimeMillis=" + this.f6307e + ", autoMetadata=" + this.f6308f + "}";
    }
}
