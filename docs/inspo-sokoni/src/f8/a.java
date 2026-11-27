package f8;

import h8.k;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f8243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f8244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f8245d;

    public a(int i10, k kVar, byte[] bArr, byte[] bArr2) {
        this.f8242a = i10;
        if (kVar == null) {
            throw new NullPointerException("Null documentKey");
        }
        this.f8243b = kVar;
        if (bArr == null) {
            throw new NullPointerException("Null arrayValue");
        }
        this.f8244c = bArr;
        if (bArr2 == null) {
            throw new NullPointerException("Null directionalValue");
        }
        this.f8245d = bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f8242a == eVar.n() && this.f8243b.equals(eVar.l())) {
            boolean z10 = eVar instanceof a;
            if (Arrays.equals(this.f8244c, z10 ? ((a) eVar).f8244c : eVar.i())) {
                if (Arrays.equals(this.f8245d, z10 ? ((a) eVar).f8245d : eVar.k())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f8242a ^ 1000003) * 1000003) ^ this.f8243b.hashCode()) * 1000003) ^ Arrays.hashCode(this.f8244c)) * 1000003) ^ Arrays.hashCode(this.f8245d);
    }

    @Override // f8.e
    public byte[] i() {
        return this.f8244c;
    }

    @Override // f8.e
    public byte[] k() {
        return this.f8245d;
    }

    @Override // f8.e
    public k l() {
        return this.f8243b;
    }

    @Override // f8.e
    public int n() {
        return this.f8242a;
    }

    public String toString() {
        return "IndexEntry{indexId=" + this.f8242a + ", documentKey=" + this.f8243b + ", arrayValue=" + Arrays.toString(this.f8244c) + ", directionalValue=" + Arrays.toString(this.f8245d) + "}";
    }
}
