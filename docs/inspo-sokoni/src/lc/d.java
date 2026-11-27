package lc;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Comparable<d> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f12694e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f12695f = e.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12699d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public d(int i10, int i11, int i12) {
        this.f12696a = i10;
        this.f12697b = i11;
        this.f12698c = i12;
        this.f12699d = h(i10, i11, i12);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(d other) {
        kotlin.jvm.internal.k.e(other, "other");
        return this.f12699d - other.f12699d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        d dVar = obj instanceof d ? (d) obj : null;
        return dVar != null && this.f12699d == dVar.f12699d;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0020  */
    public final int h(int i10, int i11, int i12) {
        boolean z10;
        if (i10 >= 0 && i10 < 256) {
            if (i11 >= 0 && i11 < 256) {
                z10 = i12 >= 0 && i12 < 256;
            }
        }
        if (z10) {
            return (i10 << 16) + (i11 << 8) + i12;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i10 + '.' + i11 + '.' + i12).toString());
    }

    public int hashCode() {
        return this.f12699d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f12696a);
        sb2.append('.');
        sb2.append(this.f12697b);
        sb2.append('.');
        sb2.append(this.f12698c);
        return sb2.toString();
    }
}
