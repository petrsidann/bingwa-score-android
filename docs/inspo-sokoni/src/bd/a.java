package bd;

import mc.m;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Iterable<Character> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0055a f3061d = new C0055a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f3062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f3063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3064c;

    /* JADX INFO: renamed from: bd.a$a, reason: collision with other inner class name */
    public static final class C0055a {
        public C0055a() {
        }

        public /* synthetic */ C0055a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public a(char c10, char c11, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i10 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f3062a = c10;
        this.f3063b = (char) sc.c.b(c10, c11, i10);
        this.f3064c = i10;
    }

    public final char e() {
        return this.f3062a;
    }

    public final char h() {
        return this.f3063b;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public m iterator() {
        return new b(this.f3062a, this.f3063b, this.f3064c);
    }
}
