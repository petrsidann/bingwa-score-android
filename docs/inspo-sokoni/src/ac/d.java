package ac;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final oe.g f445d = oe.g.i(":status");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final oe.g f446e = oe.g.i(":method");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final oe.g f447f = oe.g.i(":path");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final oe.g f448g = oe.g.i(":scheme");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final oe.g f449h = oe.g.i(":authority");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final oe.g f450i = oe.g.i(":host");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final oe.g f451j = oe.g.i(":version");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oe.g f452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final oe.g f453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f454c;

    public d(String str, String str2) {
        this(oe.g.i(str), oe.g.i(str2));
    }

    public d(oe.g gVar, String str) {
        this(gVar, oe.g.i(str));
    }

    public d(oe.g gVar, oe.g gVar2) {
        this.f452a = gVar;
        this.f453b = gVar2;
        this.f454c = gVar.y() + 32 + gVar2.y();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f452a.equals(dVar.f452a) && this.f453b.equals(dVar.f453b);
    }

    public int hashCode() {
        return ((527 + this.f452a.hashCode()) * 31) + this.f453b.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", this.f452a.C(), this.f453b.C());
    }
}
