package d3;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class d extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f6326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a3.e f6327c;

    public static final class b extends o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f6329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a3.e f6330c;

        @Override // d3.o.a
        public o a() {
            String str = "";
            if (this.f6328a == null) {
                str = " backendName";
            }
            if (this.f6330c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new d(this.f6328a, this.f6329b, this.f6330c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // d3.o.a
        public o.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f6328a = str;
            return this;
        }

        @Override // d3.o.a
        public o.a c(byte[] bArr) {
            this.f6329b = bArr;
            return this;
        }

        @Override // d3.o.a
        public o.a d(a3.e eVar) {
            if (eVar == null) {
                throw new NullPointerException("Null priority");
            }
            this.f6330c = eVar;
            return this;
        }
    }

    public d(String str, byte[] bArr, a3.e eVar) {
        this.f6325a = str;
        this.f6326b = bArr;
        this.f6327c = eVar;
    }

    @Override // d3.o
    public String b() {
        return this.f6325a;
    }

    @Override // d3.o
    public byte[] c() {
        return this.f6326b;
    }

    @Override // d3.o
    public a3.e d() {
        return this.f6327c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f6325a.equals(oVar.b())) {
            if (Arrays.equals(this.f6326b, oVar instanceof d ? ((d) oVar).f6326b : oVar.c()) && this.f6327c.equals(oVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f6325a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f6326b)) * 1000003) ^ this.f6327c.hashCode();
    }
}
