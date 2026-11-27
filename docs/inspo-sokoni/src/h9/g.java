package h9;

import e9.p;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class g extends m9.c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Writer f9820u = new a();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final p f9821v = new p("closed");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<e9.k> f9822r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f9823s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public e9.k f9824t;

    public class a extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    public g() {
        super(f9820u);
        this.f9822r = new ArrayList();
        this.f9824t = e9.m.f7445a;
    }

    @Override // m9.c
    public m9.c B() {
        if (this.f9822r.isEmpty() || this.f9823s != null) {
            throw new IllegalStateException();
        }
        if (!(r0() instanceof e9.n)) {
            throw new IllegalStateException();
        }
        List<e9.k> list = this.f9822r;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // m9.c
    public m9.c I(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f9822r.isEmpty() || this.f9823s != null) {
            throw new IllegalStateException();
        }
        if (!(r0() instanceof e9.n)) {
            throw new IllegalStateException();
        }
        this.f9823s = str;
        return this;
    }

    @Override // m9.c
    public m9.c L() {
        s0(e9.m.f7445a);
        return this;
    }

    @Override // m9.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f9822r.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f9822r.add(f9821v);
    }

    @Override // m9.c, java.io.Flushable
    public void flush() {
    }

    @Override // m9.c
    public m9.c j0(double d10) {
        if (E() || !(Double.isNaN(d10) || Double.isInfinite(d10))) {
            s0(new p(Double.valueOf(d10)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d10);
    }

    @Override // m9.c
    public m9.c k() {
        e9.h hVar = new e9.h();
        s0(hVar);
        this.f9822r.add(hVar);
        return this;
    }

    @Override // m9.c
    public m9.c k0(long j10) {
        s0(new p(Long.valueOf(j10)));
        return this;
    }

    @Override // m9.c
    public m9.c l0(Boolean bool) {
        if (bool == null) {
            return L();
        }
        s0(new p(bool));
        return this;
    }

    @Override // m9.c
    public m9.c m0(Number number) {
        if (number == null) {
            return L();
        }
        if (!E()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        s0(new p(number));
        return this;
    }

    @Override // m9.c
    public m9.c n0(String str) {
        if (str == null) {
            return L();
        }
        s0(new p(str));
        return this;
    }

    @Override // m9.c
    public m9.c o0(boolean z10) {
        s0(new p(Boolean.valueOf(z10)));
        return this;
    }

    public e9.k q0() {
        if (this.f9822r.isEmpty()) {
            return this.f9824t;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f9822r);
    }

    public final e9.k r0() {
        List<e9.k> list = this.f9822r;
        return list.get(list.size() - 1);
    }

    public final void s0(e9.k kVar) {
        if (this.f9823s != null) {
            if (!kVar.n() || C()) {
                ((e9.n) r0()).r(this.f9823s, kVar);
            }
            this.f9823s = null;
            return;
        }
        if (this.f9822r.isEmpty()) {
            this.f9824t = kVar;
            return;
        }
        e9.k kVarR0 = r0();
        if (!(kVarR0 instanceof e9.h)) {
            throw new IllegalStateException();
        }
        ((e9.h) kVarR0).r(kVar);
    }

    @Override // m9.c
    public m9.c t() {
        e9.n nVar = new e9.n();
        s0(nVar);
        this.f9822r.add(nVar);
        return this;
    }

    @Override // m9.c
    public m9.c z() {
        if (this.f9822r.isEmpty() || this.f9823s != null) {
            throw new IllegalStateException();
        }
        if (!(r0() instanceof e9.h)) {
            throw new IllegalStateException();
        }
        List<e9.k> list = this.f9822r;
        list.remove(list.size() - 1);
        return this;
    }
}
