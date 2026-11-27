package c7;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import r6.j;
import r6.t;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f3412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<C0067c> f3413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f3414c;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<C0067c> f3415a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c7.a f3416b = c7.a.f3409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f3417c = null;

        public b a(j jVar, int i10, t tVar) {
            ArrayList<C0067c> arrayList = this.f3415a;
            if (arrayList == null) {
                throw new IllegalStateException("addEntry cannot be called after build()");
            }
            arrayList.add(new C0067c(jVar, i10, tVar));
            return this;
        }

        public c b() throws GeneralSecurityException {
            if (this.f3415a == null) {
                throw new IllegalStateException("cannot call build() twice");
            }
            Integer num = this.f3417c;
            if (num != null && !c(num.intValue())) {
                throw new GeneralSecurityException("primary key ID is not present in entries");
            }
            c cVar = new c(this.f3416b, Collections.unmodifiableList(this.f3415a), this.f3417c);
            this.f3415a = null;
            return cVar;
        }

        public final boolean c(int i10) {
            Iterator<C0067c> it = this.f3415a.iterator();
            while (it.hasNext()) {
                if (it.next().a() == i10) {
                    return true;
                }
            }
            return false;
        }

        public b d(c7.a aVar) {
            if (this.f3415a == null) {
                throw new IllegalStateException("setAnnotations cannot be called after build()");
            }
            this.f3416b = aVar;
            return this;
        }

        public b e(int i10) {
            if (this.f3415a == null) {
                throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
            }
            this.f3417c = Integer.valueOf(i10);
            return this;
        }
    }

    /* JADX INFO: renamed from: c7.c$c, reason: collision with other inner class name */
    public static final class C0067c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f3418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final t f3420c;

        public C0067c(j jVar, int i10, t tVar) {
            this.f3418a = jVar;
            this.f3419b = i10;
            this.f3420c = tVar;
        }

        public int a() {
            return this.f3419b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0067c)) {
                return false;
            }
            C0067c c0067c = (C0067c) obj;
            return this.f3418a == c0067c.f3418a && this.f3419b == c0067c.f3419b && this.f3420c.equals(c0067c.f3420c);
        }

        public int hashCode() {
            return Objects.hash(this.f3418a, Integer.valueOf(this.f3419b), Integer.valueOf(this.f3420c.hashCode()));
        }

        public String toString() {
            return String.format("(status=%s, keyId=%s, parameters='%s')", this.f3418a, Integer.valueOf(this.f3419b), this.f3420c);
        }
    }

    public c(c7.a aVar, List<C0067c> list, Integer num) {
        this.f3412a = aVar;
        this.f3413b = list;
        this.f3414c = num;
    }

    public static b a() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f3412a.equals(cVar.f3412a) && this.f3413b.equals(cVar.f3413b) && Objects.equals(this.f3414c, cVar.f3414c);
    }

    public int hashCode() {
        return Objects.hash(this.f3412a, this.f3413b);
    }

    public String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", this.f3412a, this.f3413b, this.f3414c);
    }
}
