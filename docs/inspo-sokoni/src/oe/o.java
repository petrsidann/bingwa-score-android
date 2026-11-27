package oe;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f13887h = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f13888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o f13893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public o f13894g;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public o() {
        this.f13888a = new byte[8192];
        this.f13892e = true;
        this.f13891d = false;
    }

    public o(byte[] data, int i10, int i11, boolean z10, boolean z11) {
        kotlin.jvm.internal.k.e(data, "data");
        this.f13888a = data;
        this.f13889b = i10;
        this.f13890c = i11;
        this.f13891d = z10;
        this.f13892e = z11;
    }

    public final void a() {
        o oVar = this.f13894g;
        int i10 = 0;
        if (!(oVar != this)) {
            throw new IllegalStateException("cannot compact".toString());
        }
        kotlin.jvm.internal.k.b(oVar);
        if (oVar.f13892e) {
            int i11 = this.f13890c - this.f13889b;
            o oVar2 = this.f13894g;
            kotlin.jvm.internal.k.b(oVar2);
            int i12 = 8192 - oVar2.f13890c;
            o oVar3 = this.f13894g;
            kotlin.jvm.internal.k.b(oVar3);
            if (!oVar3.f13891d) {
                o oVar4 = this.f13894g;
                kotlin.jvm.internal.k.b(oVar4);
                i10 = oVar4.f13889b;
            }
            if (i11 > i12 + i10) {
                return;
            }
            o oVar5 = this.f13894g;
            kotlin.jvm.internal.k.b(oVar5);
            f(oVar5, i11);
            b();
            p.b(this);
        }
    }

    public final o b() {
        o oVar = this.f13893f;
        if (oVar == this) {
            oVar = null;
        }
        o oVar2 = this.f13894g;
        kotlin.jvm.internal.k.b(oVar2);
        oVar2.f13893f = this.f13893f;
        o oVar3 = this.f13893f;
        kotlin.jvm.internal.k.b(oVar3);
        oVar3.f13894g = this.f13894g;
        this.f13893f = null;
        this.f13894g = null;
        return oVar;
    }

    public final o c(o segment) {
        kotlin.jvm.internal.k.e(segment, "segment");
        segment.f13894g = this;
        segment.f13893f = this.f13893f;
        o oVar = this.f13893f;
        kotlin.jvm.internal.k.b(oVar);
        oVar.f13894g = segment;
        this.f13893f = segment;
        return segment;
    }

    public final o d() {
        this.f13891d = true;
        return new o(this.f13888a, this.f13889b, this.f13890c, true, false);
    }

    public final o e(int i10) {
        o oVarC;
        if (!(i10 > 0 && i10 <= this.f13890c - this.f13889b)) {
            throw new IllegalArgumentException("byteCount out of range".toString());
        }
        if (i10 >= 1024) {
            oVarC = d();
        } else {
            oVarC = p.c();
            byte[] bArr = this.f13888a;
            byte[] bArr2 = oVarC.f13888a;
            int i11 = this.f13889b;
            mc.j.f(bArr, bArr2, 0, i11, i11 + i10, 2, null);
        }
        oVarC.f13890c = oVarC.f13889b + i10;
        this.f13889b += i10;
        o oVar = this.f13894g;
        kotlin.jvm.internal.k.b(oVar);
        oVar.c(oVarC);
        return oVarC;
    }

    public final void f(o sink, int i10) {
        kotlin.jvm.internal.k.e(sink, "sink");
        if (!sink.f13892e) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i11 = sink.f13890c;
        if (i11 + i10 > 8192) {
            if (sink.f13891d) {
                throw new IllegalArgumentException();
            }
            int i12 = sink.f13889b;
            if ((i11 + i10) - i12 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.f13888a;
            mc.j.f(bArr, bArr, 0, i12, i11, 2, null);
            sink.f13890c -= sink.f13889b;
            sink.f13889b = 0;
        }
        byte[] bArr2 = this.f13888a;
        byte[] bArr3 = sink.f13888a;
        int i13 = sink.f13890c;
        int i14 = this.f13889b;
        mc.j.d(bArr2, bArr3, i13, i14, i14 + i10);
        sink.f13890c += i10;
        this.f13889b += i10;
    }
}
