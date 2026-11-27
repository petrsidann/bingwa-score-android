package je;

import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static n f11412e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f11413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f11414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f11415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f11416d;

    public n(g gVar, o oVar, d dVar, p pVar) {
        this.f11413a = gVar;
        this.f11414b = oVar;
        this.f11415c = dVar;
        this.f11416d = pVar;
    }

    public static n c() {
        if (f11412e == null) {
            f11412e = new n(g.a(), o.c(), d.g(), p.a());
        }
        return f11412e;
    }

    public Calendar a(String str) {
        return this.f11415c.a(str);
    }

    public TimeZone b(String str) {
        return this.f11416d.b(str);
    }

    public <T extends Calendar> Object d(T t10) {
        return this.f11415c.d(t10);
    }

    public <T extends TimeZone> Object e(T t10) {
        return this.f11416d.c(t10);
    }
}
