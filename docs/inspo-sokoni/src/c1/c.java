package c1;

import android.content.Context;
import cd.i;
import gd.m0;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.k;
import xc.l;

/* JADX INFO: loaded from: classes.dex */
public final class c implements yc.a<Context, a1.f<d1.d>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<Context, List<a1.d<d1.d>>> f3120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m0 f3121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f3122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile a1.f<d1.d> f3123e;

    public static final class a extends kotlin.jvm.internal.l implements xc.a<File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f3124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f3125b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, c cVar) {
            super(0);
            this.f3124a = context;
            this.f3125b = cVar;
        }

        @Override // xc.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            Context applicationContext = this.f3124a;
            k.d(applicationContext, "applicationContext");
            return b.a(applicationContext, this.f3125b.f3119a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String name, b1.b<d1.d> bVar, l<? super Context, ? extends List<? extends a1.d<d1.d>>> produceMigrations, m0 scope) {
        k.e(name, "name");
        k.e(produceMigrations, "produceMigrations");
        k.e(scope, "scope");
        this.f3119a = name;
        this.f3120b = produceMigrations;
        this.f3121c = scope;
        this.f3122d = new Object();
    }

    @Override // yc.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public a1.f<d1.d> a(Context thisRef, i<?> property) {
        a1.f<d1.d> fVar;
        k.e(thisRef, "thisRef");
        k.e(property, "property");
        a1.f<d1.d> fVar2 = this.f3123e;
        if (fVar2 != null) {
            return fVar2;
        }
        synchronized (this.f3122d) {
            if (this.f3123e == null) {
                Context applicationContext = thisRef.getApplicationContext();
                d1.c cVar = d1.c.f6267a;
                l<Context, List<a1.d<d1.d>>> lVar = this.f3120b;
                k.d(applicationContext, "applicationContext");
                this.f3123e = cVar.a(null, lVar.invoke(applicationContext), this.f3121c, new a(applicationContext, this));
            }
            fVar = this.f3123e;
            k.b(fVar);
        }
        return fVar;
    }
}
