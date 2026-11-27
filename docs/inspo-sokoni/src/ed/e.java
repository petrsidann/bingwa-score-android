package ed;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Iterator<String> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f7920f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f7921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7925e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public e(CharSequence string) {
        kotlin.jvm.internal.k.e(string, "string");
        this.f7921a = string;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f7922b = 0;
        int i10 = this.f7924d;
        int i11 = this.f7923c;
        this.f7923c = this.f7925e + i10;
        return this.f7921a.subSequence(i11, i10).toString();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i10;
        int i11;
        int i12 = this.f7922b;
        if (i12 != 0) {
            return i12 == 1;
        }
        if (this.f7925e < 0) {
            this.f7922b = 2;
            return false;
        }
        int length = this.f7921a.length();
        int length2 = this.f7921a.length();
        for (int i13 = this.f7923c; i13 < length2; i13++) {
            char cCharAt = this.f7921a.charAt(i13);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i10 = (cCharAt == '\r' && (i11 = i13 + 1) < this.f7921a.length() && this.f7921a.charAt(i11) == '\n') ? 2 : 1;
                length = i13;
                this.f7922b = 1;
                this.f7925e = i10;
                this.f7924d = length;
                return true;
            }
        }
        i10 = -1;
        this.f7922b = 1;
        this.f7925e = i10;
        this.f7924d = length;
        return true;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
