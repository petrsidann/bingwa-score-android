package yb;

import xb.v2;

/* JADX INFO: loaded from: classes2.dex */
public class p implements v2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oe.d f19637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19639c;

    public p(oe.d dVar, int i10) {
        this.f19637a = dVar;
        this.f19638b = i10;
    }

    @Override // xb.v2
    public int a() {
        return this.f19639c;
    }

    @Override // xb.v2
    public int b() {
        return this.f19638b;
    }

    @Override // xb.v2
    public void c(byte b10) {
        this.f19637a.writeByte(b10);
        this.f19638b--;
        this.f19639c++;
    }

    public oe.d d() {
        return this.f19637a;
    }

    @Override // xb.v2
    public void release() {
    }

    @Override // xb.v2
    public void write(byte[] bArr, int i10, int i11) {
        this.f19637a.o0(bArr, i10, i11);
        this.f19638b -= i11;
        this.f19639c += i11;
    }
}
