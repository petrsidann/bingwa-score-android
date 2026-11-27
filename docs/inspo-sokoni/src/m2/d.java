package m2;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
public final class d implements c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f12913d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j2.b f12914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f12915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.b f12916c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final void a(j2.b bounds) {
            kotlin.jvm.internal.k.e(bounds, "bounds");
            if (!((bounds.d() == 0 && bounds.a() == 0) ? false : true)) {
                throw new IllegalArgumentException("Bounds must be non zero".toString());
            }
            if (!(bounds.b() == 0 || bounds.c() == 0)) {
                throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features".toString());
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f12917b = new a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f12918c = new b("FOLD");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f12919d = new b("HINGE");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12920a;

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }

            public final b a() {
                return b.f12918c;
            }

            public final b b() {
                return b.f12919d;
            }
        }

        public b(String str) {
            this.f12920a = str;
        }

        public String toString() {
            return this.f12920a;
        }
    }

    public d(j2.b featureBounds, b type, c.b state) {
        kotlin.jvm.internal.k.e(featureBounds, "featureBounds");
        kotlin.jvm.internal.k.e(type, "type");
        kotlin.jvm.internal.k.e(state, "state");
        this.f12914a = featureBounds;
        this.f12915b = type;
        this.f12916c = state;
        f12913d.a(featureBounds);
    }

    @Override // m2.c
    public c.a a() {
        return (this.f12914a.d() == 0 || this.f12914a.a() == 0) ? c.a.f12906c : c.a.f12907d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.k.a(d.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        d dVar = (d) obj;
        return kotlin.jvm.internal.k.a(this.f12914a, dVar.f12914a) && kotlin.jvm.internal.k.a(this.f12915b, dVar.f12915b) && kotlin.jvm.internal.k.a(getState(), dVar.getState());
    }

    @Override // m2.a
    public Rect getBounds() {
        return this.f12914a.f();
    }

    @Override // m2.c
    public c.b getState() {
        return this.f12916c;
    }

    public int hashCode() {
        return (((this.f12914a.hashCode() * 31) + this.f12915b.hashCode()) * 31) + getState().hashCode();
    }

    public String toString() {
        return d.class.getSimpleName() + " { " + this.f12914a + ", type=" + this.f12915b + ", state=" + getState() + " }";
    }
}
