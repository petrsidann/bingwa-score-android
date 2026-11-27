package b2;

import android.os.Bundle;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f2757d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f2758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f2759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2760c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final e a(f owner) {
            k.e(owner, "owner");
            return new e(owner, null);
        }
    }

    public e(f fVar) {
        this.f2758a = fVar;
        this.f2759b = new d();
    }

    public /* synthetic */ e(f fVar, kotlin.jvm.internal.g gVar) {
        this(fVar);
    }

    public static final e a(f fVar) {
        return f2757d.a(fVar);
    }

    public final d b() {
        return this.f2759b;
    }

    public final void c() {
        androidx.lifecycle.g gVarA = this.f2758a.a();
        if (!(gVarA.b() == androidx.lifecycle.g.b.INITIALIZED)) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        gVarA.a(new b(this.f2758a));
        this.f2759b.e(gVarA);
        this.f2760c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f2760c) {
            c();
        }
        androidx.lifecycle.g gVarA = this.f2758a.a();
        if (!gVarA.b().h(androidx.lifecycle.g.b.STARTED)) {
            this.f2759b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + gVarA.b()).toString());
    }

    public final void e(Bundle outBundle) {
        k.e(outBundle, "outBundle");
        this.f2759b.g(outBundle);
    }
}
