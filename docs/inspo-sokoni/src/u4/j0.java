package u4;

/* JADX INFO: loaded from: classes.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f16379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f16380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f16381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f16382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f16383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f16384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f16385i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f16386j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f16387k;

    public j0(String str, String str2, long j10, long j11, long j12, long j13, long j14, Long l10, Long l11, Long l12, Boolean bool) {
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.f(str2);
        com.google.android.gms.common.internal.r.a(j10 >= 0);
        com.google.android.gms.common.internal.r.a(j11 >= 0);
        com.google.android.gms.common.internal.r.a(j12 >= 0);
        com.google.android.gms.common.internal.r.a(j14 >= 0);
        this.f16377a = str;
        this.f16378b = str2;
        this.f16379c = j10;
        this.f16380d = j11;
        this.f16381e = j12;
        this.f16382f = j13;
        this.f16383g = j14;
        this.f16384h = l10;
        this.f16385i = l11;
        this.f16386j = l12;
        this.f16387k = bool;
    }

    public j0(String str, String str2, long j10, long j11, long j12, long j13, Long l10, Long l11, Long l12, Boolean bool) {
        this(str, str2, 0L, 0L, 0L, j12, 0L, null, null, null, null);
    }

    public final j0 a(long j10) {
        return new j0(this.f16377a, this.f16378b, this.f16379c, this.f16380d, this.f16381e, j10, this.f16383g, this.f16384h, this.f16385i, this.f16386j, this.f16387k);
    }

    public final j0 b(long j10, long j11) {
        return new j0(this.f16377a, this.f16378b, this.f16379c, this.f16380d, this.f16381e, this.f16382f, j10, Long.valueOf(j11), this.f16385i, this.f16386j, this.f16387k);
    }

    public final j0 c(Long l10, Long l11, Boolean bool) {
        return new j0(this.f16377a, this.f16378b, this.f16379c, this.f16380d, this.f16381e, this.f16382f, this.f16383g, this.f16384h, l10, l11, (bool == null || bool.booleanValue()) ? bool : null);
    }
}
