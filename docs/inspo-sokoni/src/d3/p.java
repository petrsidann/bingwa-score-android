package d3;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class p implements a3.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<a3.c> f6351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f6352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f6353c;

    public p(Set<a3.c> set, o oVar, s sVar) {
        this.f6351a = set;
        this.f6352b = oVar;
        this.f6353c = sVar;
    }

    @Override // a3.i
    public <T> a3.h<T> a(String str, Class<T> cls, a3.c cVar, a3.g<T, byte[]> gVar) {
        if (this.f6351a.contains(cVar)) {
            return new r(this.f6352b, str, cVar, gVar, this.f6353c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", cVar, this.f6351a));
    }
}
