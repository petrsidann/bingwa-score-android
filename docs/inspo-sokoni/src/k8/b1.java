package k8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b1 extends c<d9.f0, d9.g0, a> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final com.google.protobuf.i f11651v = com.google.protobuf.i.f5753b;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final o0 f11652s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f11653t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.google.protobuf.i f11654u;

    public interface a extends u0 {
        void c(h8.v vVar, List<i8.i> list);

        void d();
    }

    public b1(y yVar, l8.g gVar, o0 o0Var, a aVar) {
        super(yVar, d9.r.e(), gVar, l8.g.d.WRITE_STREAM_CONNECTION_BACKOFF, l8.g.d.WRITE_STREAM_IDLE, l8.g.d.HEALTH_CHECK_TIMEOUT, aVar);
        this.f11653t = false;
        this.f11654u = f11651v;
        this.f11652s = o0Var;
    }

    public boolean A() {
        return this.f11653t;
    }

    @Override // k8.c
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void r(d9.g0 g0Var) {
        this.f11654u = g0Var.g0();
        this.f11653t = true;
        ((a) this.f11672m).d();
    }

    @Override // k8.c
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void s(d9.g0 g0Var) {
        this.f11654u = g0Var.g0();
        this.f11671l.f();
        h8.v vVarY = this.f11652s.y(g0Var.e0());
        int iI0 = g0Var.i0();
        ArrayList arrayList = new ArrayList(iI0);
        for (int i10 = 0; i10 < iI0; i10++) {
            arrayList.add(this.f11652s.p(g0Var.h0(i10), vVarY));
        }
        ((a) this.f11672m).c(vVarY, arrayList);
    }

    public void D(com.google.protobuf.i iVar) {
        this.f11654u = (com.google.protobuf.i) l8.x.b(iVar);
    }

    public void E() {
        l8.b.d(m(), "Writing handshake requires an opened stream", new Object[0]);
        l8.b.d(!this.f11653t, "Handshake already completed", new Object[0]);
        y(d9.f0.k0().F(this.f11652s.a()).build());
    }

    public void F(List<i8.f> list) {
        l8.b.d(m(), "Writing mutations requires an opened stream", new Object[0]);
        l8.b.d(this.f11653t, "Handshake must be complete before writing mutations", new Object[0]);
        d9.f0.b bVarK0 = d9.f0.k0();
        Iterator<i8.f> it = list.iterator();
        while (it.hasNext()) {
            bVarK0.E(this.f11652s.O(it.next()));
        }
        bVarK0.H(this.f11654u);
        y(bVarK0.build());
    }

    @Override // k8.c
    public /* bridge */ /* synthetic */ void l() {
        super.l();
    }

    @Override // k8.c
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    @Override // k8.c
    public /* bridge */ /* synthetic */ boolean n() {
        return super.n();
    }

    @Override // k8.c
    public void v() {
        this.f11653t = false;
        super.v();
    }

    @Override // k8.c
    public /* bridge */ /* synthetic */ void w() {
        super.w();
    }

    @Override // k8.c
    public void x() {
        if (this.f11653t) {
            F(Collections.emptyList());
        }
    }

    public com.google.protobuf.i z() {
        return this.f11654u;
    }
}
