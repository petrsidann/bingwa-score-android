package c3;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class f extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f3244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f3246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3247e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f3248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o f3249g;

    public static final class b extends l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f3250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f3251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f3252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f3253d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f3254e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Long f3255f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public o f3256g;

        @Override // c3.l.a
        public l a() {
            String str = "";
            if (this.f3250a == null) {
                str = " eventTimeMs";
            }
            if (this.f3252c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f3255f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new f(this.f3250a.longValue(), this.f3251b, this.f3252c.longValue(), this.f3253d, this.f3254e, this.f3255f.longValue(), this.f3256g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // c3.l.a
        public l.a b(Integer num) {
            this.f3251b = num;
            return this;
        }

        @Override // c3.l.a
        public l.a c(long j10) {
            this.f3250a = Long.valueOf(j10);
            return this;
        }

        @Override // c3.l.a
        public l.a d(long j10) {
            this.f3252c = Long.valueOf(j10);
            return this;
        }

        @Override // c3.l.a
        public l.a e(o oVar) {
            this.f3256g = oVar;
            return this;
        }

        @Override // c3.l.a
        public l.a f(byte[] bArr) {
            this.f3253d = bArr;
            return this;
        }

        @Override // c3.l.a
        public l.a g(String str) {
            this.f3254e = str;
            return this;
        }

        @Override // c3.l.a
        public l.a h(long j10) {
            this.f3255f = Long.valueOf(j10);
            return this;
        }
    }

    public f(long j10, Integer num, long j11, byte[] bArr, String str, long j12, o oVar) {
        this.f3243a = j10;
        this.f3244b = num;
        this.f3245c = j11;
        this.f3246d = bArr;
        this.f3247e = str;
        this.f3248f = j12;
        this.f3249g = oVar;
    }

    @Override // c3.l
    public Integer b() {
        return this.f3244b;
    }

    @Override // c3.l
    public long c() {
        return this.f3243a;
    }

    @Override // c3.l
    public long d() {
        return this.f3245c;
    }

    @Override // c3.l
    public o e() {
        return this.f3249g;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f3243a == lVar.c() && ((num = this.f3244b) != null ? num.equals(lVar.b()) : lVar.b() == null) && this.f3245c == lVar.d()) {
            if (Arrays.equals(this.f3246d, lVar instanceof f ? ((f) lVar).f3246d : lVar.f()) && ((str = this.f3247e) != null ? str.equals(lVar.g()) : lVar.g() == null) && this.f3248f == lVar.h()) {
                o oVar = this.f3249g;
                o oVarE = lVar.e();
                if (oVar == null) {
                    if (oVarE == null) {
                        return true;
                    }
                } else if (oVar.equals(oVarE)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // c3.l
    public byte[] f() {
        return this.f3246d;
    }

    @Override // c3.l
    public String g() {
        return this.f3247e;
    }

    @Override // c3.l
    public long h() {
        return this.f3248f;
    }

    public int hashCode() {
        long j10 = this.f3243a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f3244b;
        int iHashCode = num == null ? 0 : num.hashCode();
        long j11 = this.f3245c;
        int iHashCode2 = (((((i10 ^ iHashCode) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f3246d)) * 1000003;
        String str = this.f3247e;
        int iHashCode3 = str == null ? 0 : str.hashCode();
        long j12 = this.f3248f;
        int i11 = (((iHashCode2 ^ iHashCode3) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003;
        o oVar = this.f3249g;
        return i11 ^ (oVar != null ? oVar.hashCode() : 0);
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f3243a + ", eventCode=" + this.f3244b + ", eventUptimeMs=" + this.f3245c + ", sourceExtension=" + Arrays.toString(this.f3246d) + ", sourceExtensionJsonProto3=" + this.f3247e + ", timezoneOffsetSeconds=" + this.f3248f + ", networkConnectionInfo=" + this.f3249g + "}";
    }
}
