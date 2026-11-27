package a7;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class c extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f395b;

    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f396b = new a("TINK");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f397c = new a("CRUNCHY");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f398d = new a("LEGACY");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f399e = new a("NO_PREFIX");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f400a;

        public a(String str) {
            this.f400a = str;
        }

        public String toString() {
            return this.f400a;
        }
    }

    public c(int i10, a aVar) {
        this.f394a = i10;
        this.f395b = aVar;
    }

    public static c a(int i10, a aVar) throws GeneralSecurityException {
        if (i10 >= 10 && 16 >= i10) {
            return new c(i10, aVar);
        }
        throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i10);
    }

    public int b() {
        return this.f394a;
    }

    public int c() {
        a aVar = this.f395b;
        if (aVar == a.f399e) {
            return b();
        }
        if (aVar == a.f396b || aVar == a.f397c || aVar == a.f398d) {
            return b() + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public a d() {
        return this.f395b;
    }

    public boolean e() {
        return this.f395b != a.f399e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return cVar.c() == c() && cVar.d() == d();
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f394a), this.f395b);
    }

    public String toString() {
        return "AES-CMAC Parameters (variant: " + this.f395b + ", " + this.f394a + "-byte tags)";
    }
}
