package eb;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f7589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f7590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fb.a<String> f7592d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7593a;

        static {
            int[] iArr = new int[b.values().length];
            f7593a = iArr;
            try {
                iArr[b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7593a[b.INACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7593a[b.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7593a[b.PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7593a[b.DETACHED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        DETACHED,
        RESUMED,
        INACTIVE,
        HIDDEN,
        PAUSED
    }

    public g(fb.a<String> aVar) {
        this.f7589a = null;
        this.f7590b = null;
        this.f7591c = true;
        this.f7592d = aVar;
    }

    public g(ta.a aVar) {
        this((fb.a<String>) new fb.a(aVar, "flutter/lifecycle", fb.r.f8302b));
    }

    public void a() {
        g(this.f7589a, true);
    }

    public void b() {
        g(b.DETACHED, this.f7591c);
    }

    public void c() {
        g(b.INACTIVE, this.f7591c);
    }

    public void d() {
        g(b.PAUSED, this.f7591c);
    }

    public void e() {
        g(b.RESUMED, this.f7591c);
    }

    public void f() {
        g(this.f7589a, false);
    }

    public final void g(b bVar, boolean z10) {
        b bVar2;
        b bVar3 = this.f7589a;
        if (bVar3 == bVar && z10 == this.f7591c) {
            return;
        }
        if (bVar == null && bVar3 == null) {
            this.f7591c = z10;
            return;
        }
        int i10 = a.f7593a[bVar.ordinal()];
        if (i10 != 1) {
            bVar2 = (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5) ? bVar : null;
        } else {
            bVar2 = z10 ? b.RESUMED : b.INACTIVE;
        }
        this.f7589a = bVar;
        this.f7591c = z10;
        if (bVar2 == this.f7590b) {
            return;
        }
        String str = "AppLifecycleState." + bVar2.name().toLowerCase(Locale.ROOT);
        qa.b.f("LifecycleChannel", "Sending " + str + " message.");
        this.f7592d.c(str);
        this.f7590b = bVar2;
    }
}
