package h8;

import d9.d0;

/* JADX INFO: loaded from: classes.dex */
public final class r implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f9759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f9760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v f9761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v f9762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s f9763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f9764g;

    public enum a {
        HAS_LOCAL_MUTATIONS,
        HAS_COMMITTED_MUTATIONS,
        SYNCED
    }

    public enum b {
        INVALID,
        FOUND_DOCUMENT,
        NO_DOCUMENT,
        UNKNOWN_DOCUMENT
    }

    public r(k kVar) {
        this.f9759b = kVar;
        this.f9762e = v.f9777b;
    }

    public r(k kVar, b bVar, v vVar, v vVar2, s sVar, a aVar) {
        this.f9759b = kVar;
        this.f9761d = vVar;
        this.f9762e = vVar2;
        this.f9760c = bVar;
        this.f9764g = aVar;
        this.f9763f = sVar;
    }

    public static r r(k kVar, v vVar, s sVar) {
        return new r(kVar).n(vVar, sVar);
    }

    public static r s(k kVar) {
        b bVar = b.INVALID;
        v vVar = v.f9777b;
        return new r(kVar, bVar, vVar, vVar, new s(), a.SYNCED);
    }

    public static r t(k kVar, v vVar) {
        return new r(kVar).o(vVar);
    }

    public static r u(k kVar, v vVar) {
        return new r(kVar).p(vVar);
    }

    @Override // h8.h
    public s a() {
        return this.f9763f;
    }

    @Override // h8.h
    public r b() {
        return new r(this.f9759b, this.f9760c, this.f9761d, this.f9762e, this.f9763f.clone(), this.f9764g);
    }

    @Override // h8.h
    public boolean c() {
        return this.f9760c.equals(b.FOUND_DOCUMENT);
    }

    @Override // h8.h
    public boolean d() {
        return this.f9764g.equals(a.HAS_COMMITTED_MUTATIONS);
    }

    @Override // h8.h
    public boolean e() {
        return this.f9764g.equals(a.HAS_LOCAL_MUTATIONS);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f9759b.equals(rVar.f9759b) && this.f9761d.equals(rVar.f9761d) && this.f9760c.equals(rVar.f9760c) && this.f9764g.equals(rVar.f9764g)) {
            return this.f9763f.equals(rVar.f9763f);
        }
        return false;
    }

    @Override // h8.h
    public boolean f() {
        return e() || d();
    }

    @Override // h8.h
    public v g() {
        return this.f9762e;
    }

    @Override // h8.h
    public k getKey() {
        return this.f9759b;
    }

    public int hashCode() {
        return this.f9759b.hashCode();
    }

    @Override // h8.h
    public boolean j() {
        return this.f9760c.equals(b.NO_DOCUMENT);
    }

    @Override // h8.h
    public boolean k() {
        return this.f9760c.equals(b.UNKNOWN_DOCUMENT);
    }

    @Override // h8.h
    public d0 l(q qVar) {
        return a().i(qVar);
    }

    @Override // h8.h
    public v m() {
        return this.f9761d;
    }

    public r n(v vVar, s sVar) {
        this.f9761d = vVar;
        this.f9760c = b.FOUND_DOCUMENT;
        this.f9763f = sVar;
        this.f9764g = a.SYNCED;
        return this;
    }

    public r o(v vVar) {
        this.f9761d = vVar;
        this.f9760c = b.NO_DOCUMENT;
        this.f9763f = new s();
        this.f9764g = a.SYNCED;
        return this;
    }

    public r p(v vVar) {
        this.f9761d = vVar;
        this.f9760c = b.UNKNOWN_DOCUMENT;
        this.f9763f = new s();
        this.f9764g = a.HAS_COMMITTED_MUTATIONS;
        return this;
    }

    public boolean q() {
        return !this.f9760c.equals(b.INVALID);
    }

    public String toString() {
        return "Document{key=" + this.f9759b + ", version=" + this.f9761d + ", readTime=" + this.f9762e + ", type=" + this.f9760c + ", documentState=" + this.f9764g + ", value=" + this.f9763f + '}';
    }

    public r v() {
        this.f9764g = a.HAS_COMMITTED_MUTATIONS;
        return this;
    }

    public r w() {
        this.f9764g = a.HAS_LOCAL_MUTATIONS;
        this.f9761d = v.f9777b;
        return this;
    }

    public r x(v vVar) {
        this.f9762e = vVar;
        return this;
    }
}
