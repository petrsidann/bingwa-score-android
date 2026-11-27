package b8;

import android.app.Activity;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1 f2959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0 f2960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f2961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Activity f2962d;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c1 f2963a = c1.EXCLUDE;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public s0 f2964b = s0.DEFAULT;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Executor f2965c = l8.p.f12579a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Activity f2966d = null;

        public s1 e() {
            return new s1(this);
        }

        public b f(c1 c1Var) {
            l8.x.c(c1Var, "metadataChanges must not be null.");
            this.f2963a = c1Var;
            return this;
        }

        public b g(s0 s0Var) {
            l8.x.c(s0Var, "listen source must not be null.");
            this.f2964b = s0Var;
            return this;
        }
    }

    public s1(b bVar) {
        this.f2959a = bVar.f2963a;
        this.f2960b = bVar.f2964b;
        this.f2961c = bVar.f2965c;
        this.f2962d = bVar.f2966d;
    }

    public Activity a() {
        return this.f2962d;
    }

    public Executor b() {
        return this.f2961c;
    }

    public c1 c() {
        return this.f2959a;
    }

    public s0 d() {
        return this.f2960b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s1.class != obj.getClass()) {
            return false;
        }
        s1 s1Var = (s1) obj;
        return this.f2959a == s1Var.f2959a && this.f2960b == s1Var.f2960b && this.f2961c.equals(s1Var.f2961c) && this.f2962d.equals(s1Var.f2962d);
    }

    public int hashCode() {
        int iHashCode = ((((this.f2959a.hashCode() * 31) + this.f2960b.hashCode()) * 31) + this.f2961c.hashCode()) * 31;
        Activity activity = this.f2962d;
        return iHashCode + (activity != null ? activity.hashCode() : 0);
    }

    public String toString() {
        return "SnapshotListenOptions{metadataChanges=" + this.f2959a + ", source=" + this.f2960b + ", executor=" + this.f2961c + ", activity=" + this.f2962d + '}';
    }
}
