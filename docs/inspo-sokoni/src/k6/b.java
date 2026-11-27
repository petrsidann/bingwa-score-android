package k6;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<T> extends t0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EnumC0196b f11534a = EnumC0196b.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f11535b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11536a;

        static {
            int[] iArr = new int[EnumC0196b.values().length];
            f11536a = iArr;
            try {
                iArr[EnumC0196b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11536a[EnumC0196b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: k6.b$b, reason: collision with other inner class name */
    public enum EnumC0196b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public abstract T b();

    public final T c() {
        this.f11534a = EnumC0196b.DONE;
        return null;
    }

    public final boolean d() {
        this.f11534a = EnumC0196b.FAILED;
        this.f11535b = b();
        if (this.f11534a == EnumC0196b.DONE) {
            return false;
        }
        this.f11534a = EnumC0196b.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        j6.m.u(this.f11534a != EnumC0196b.FAILED);
        int i10 = a.f11536a[this.f11534a.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            return d();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f11534a = EnumC0196b.NOT_READY;
        T t10 = (T) g0.a(this.f11535b);
        this.f11535b = null;
        return t10;
    }
}
