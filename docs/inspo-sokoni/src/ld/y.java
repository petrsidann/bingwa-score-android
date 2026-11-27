package ld;

import gd.e1;
import gd.k2;
import gd.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends k2 implements v0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f12780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12781d;

    public y(Throwable th, String str) {
        this.f12780c = th;
        this.f12781d = str;
    }

    @Override // gd.j0
    public boolean d0(oc.i iVar) {
        i0();
        throw new lc.c();
    }

    @Override // gd.k2
    public k2 f0() {
        return this;
    }

    @Override // gd.j0
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public Void c0(oc.i iVar, Runnable runnable) {
        i0();
        throw new lc.c();
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0025  */
    public final Void i0() {
        String str;
        if (this.f12780c == null) {
            x.d();
            throw new lc.c();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Module with the Main dispatcher had failed to initialize");
        String str2 = this.f12781d;
        if (str2 != null) {
            str = ". " + str2;
            if (str == null) {
                str = "";
            }
        } else {
            str = "";
        }
        sb2.append(str);
        throw new IllegalStateException(sb2.toString(), this.f12780c);
    }

    @Override // gd.v0
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public Void e(long j10, gd.o<? super lc.q> oVar) {
        i0();
        throw new lc.c();
    }

    @Override // gd.v0
    public e1 k(long j10, Runnable runnable, oc.i iVar) {
        i0();
        throw new lc.c();
    }

    @Override // gd.k2, gd.j0
    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Dispatchers.Main[missing");
        if (this.f12780c != null) {
            str = ", cause=" + this.f12780c;
        } else {
            str = "";
        }
        sb2.append(str);
        sb2.append(']');
        return sb2.toString();
    }
}
