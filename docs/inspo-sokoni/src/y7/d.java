package y7;

import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import w7.f;
import w7.g;
import w7.h;

/* JADX INFO: loaded from: classes.dex */
public final class d implements x7.b<d> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final w7.e<Object> f19412e = new w7.e() { // from class: y7.a
        @Override // w7.b
        public final void a(Object obj, f fVar) {
            d.l(obj, fVar);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g<String> f19413f = new g() { // from class: y7.b
        @Override // w7.b
        public final void a(Object obj, h hVar) {
            hVar.d((String) obj);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g<Boolean> f19414g = new g() { // from class: y7.c
        @Override // w7.b
        public final void a(Object obj, h hVar) {
            d.n((Boolean) obj, hVar);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f19415h = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, w7.e<?>> f19416a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, g<?>> f19417b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w7.e<Object> f19418c = f19412e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f19419d = false;

    public class a implements w7.a {
        public a() {
        }

        @Override // w7.a
        public void a(Object obj, Writer writer) {
            e eVar = new e(writer, d.this.f19416a, d.this.f19417b, d.this.f19418c, d.this.f19419d);
            eVar.h(obj, false);
            eVar.p();
        }
    }

    public static final class b implements g<Date> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DateFormat f19421a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f19421a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // w7.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Date date, h hVar) {
            hVar.d(f19421a.format(date));
        }
    }

    public d() {
        p(String.class, f19413f);
        p(Boolean.class, f19414g);
        p(Date.class, f19415h);
    }

    public static /* synthetic */ void l(Object obj, f fVar) {
        throw new w7.c("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public static /* synthetic */ void n(Boolean bool, h hVar) {
        hVar.e(bool.booleanValue());
    }

    public w7.a i() {
        return new a();
    }

    public d j(x7.a aVar) {
        aVar.a(this);
        return this;
    }

    public d k(boolean z10) {
        this.f19419d = z10;
        return this;
    }

    @Override // x7.b
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public <T> d a(Class<T> cls, w7.e<? super T> eVar) {
        this.f19416a.put(cls, eVar);
        this.f19417b.remove(cls);
        return this;
    }

    public <T> d p(Class<T> cls, g<? super T> gVar) {
        this.f19417b.put(cls, gVar);
        this.f19416a.remove(cls);
        return this;
    }
}
