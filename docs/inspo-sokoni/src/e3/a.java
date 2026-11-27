package e3;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable<d3.i> f6963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f6964b;

    public static final class b extends f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterable<d3.i> f6965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f6966b;

        @Override // e3.f.a
        public f a() {
            String str = "";
            if (this.f6965a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.f6965a, this.f6966b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // e3.f.a
        public f.a b(Iterable<d3.i> iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f6965a = iterable;
            return this;
        }

        @Override // e3.f.a
        public f.a c(byte[] bArr) {
            this.f6966b = bArr;
            return this;
        }
    }

    public a(Iterable<d3.i> iterable, byte[] bArr) {
        this.f6963a = iterable;
        this.f6964b = bArr;
    }

    @Override // e3.f
    public Iterable<d3.i> b() {
        return this.f6963a;
    }

    @Override // e3.f
    public byte[] c() {
        return this.f6964b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f6963a.equals(fVar.b())) {
            if (Arrays.equals(this.f6964b, fVar instanceof a ? ((a) fVar).f6964b : fVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f6963a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f6964b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f6963a + ", extras=" + Arrays.toString(this.f6964b) + "}";
    }
}
