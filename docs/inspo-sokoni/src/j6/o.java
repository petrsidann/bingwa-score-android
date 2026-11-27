package j6;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j6.b f11281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f11283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11284d;

    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j6.b f11285a;

        public a(j6.b bVar) {
            this.f11285a = bVar;
        }
    }

    public interface b {
    }

    public o(b bVar) {
        this(bVar, false, j6.b.c(), com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER);
    }

    public o(b bVar, boolean z10, j6.b bVar2, int i10) {
        this.f11283c = bVar;
        this.f11282b = z10;
        this.f11281a = bVar2;
        this.f11284d = i10;
    }

    public static o a(char c10) {
        return b(j6.b.b(c10));
    }

    public static o b(j6.b bVar) {
        m.o(bVar);
        return new o(new a(bVar));
    }

    public o c() {
        return d(j6.b.e());
    }

    public o d(j6.b bVar) {
        m.o(bVar);
        return new o(this.f11283c, this.f11282b, bVar, this.f11284d);
    }
}
