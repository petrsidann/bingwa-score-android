package pd;

import java.util.concurrent.atomic.AtomicReferenceArray;
import ld.e0;
import oc.i;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends e0<f> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReferenceArray f14568e;

    public f(long j10, f fVar, int i10) {
        super(j10, fVar, i10);
        this.f14568e = new AtomicReferenceArray(e.f14567f);
    }

    @Override // ld.e0
    public int n() {
        return e.f14567f;
    }

    @Override // ld.e0
    public void o(int i10, Throwable th, i iVar) {
        r().set(i10, e.f14566e);
        p();
    }

    public final AtomicReferenceArray r() {
        return this.f14568e;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f12721c + ", hashCode=" + hashCode() + ']';
    }
}
