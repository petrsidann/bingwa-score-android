package e8;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h8.s f7317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i8.d f7318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<i8.e> f7319c;

    public s1(h8.s sVar, i8.d dVar, List<i8.e> list) {
        this.f7317a = sVar;
        this.f7318b = dVar;
        this.f7319c = list;
    }

    public i8.f a(h8.k kVar, i8.m mVar) {
        i8.d dVar = this.f7318b;
        return dVar != null ? new i8.l(kVar, this.f7317a, dVar, mVar, this.f7319c) : new i8.o(kVar, this.f7317a, mVar, this.f7319c);
    }
}
