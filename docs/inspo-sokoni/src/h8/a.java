package h8;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a extends p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<p.c> f9728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p.b f9729f;

    public a(int i10, String str, List<p.c> list, p.b bVar) {
        this.f9726c = i10;
        if (str == null) {
            throw new NullPointerException("Null collectionGroup");
        }
        this.f9727d = str;
        if (list == null) {
            throw new NullPointerException("Null segments");
        }
        this.f9728e = list;
        if (bVar == null) {
            throw new NullPointerException("Null indexState");
        }
        this.f9729f = bVar;
    }

    @Override // h8.p
    public String d() {
        return this.f9727d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f9726c == pVar.f() && this.f9727d.equals(pVar.d()) && this.f9728e.equals(pVar.h()) && this.f9729f.equals(pVar.g());
    }

    @Override // h8.p
    public int f() {
        return this.f9726c;
    }

    @Override // h8.p
    public p.b g() {
        return this.f9729f;
    }

    @Override // h8.p
    public List<p.c> h() {
        return this.f9728e;
    }

    public int hashCode() {
        return ((((((this.f9726c ^ 1000003) * 1000003) ^ this.f9727d.hashCode()) * 1000003) ^ this.f9728e.hashCode()) * 1000003) ^ this.f9729f.hashCode();
    }

    public String toString() {
        return "FieldIndex{indexId=" + this.f9726c + ", collectionGroup=" + this.f9727d + ", segments=" + this.f9728e + ", indexState=" + this.f9729f + "}";
    }
}
