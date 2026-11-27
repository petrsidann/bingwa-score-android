package k8;

import g8.n4;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a1 extends c<d9.s, d9.t, a> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final com.google.protobuf.i f11646t = com.google.protobuf.i.f5753b;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final o0 f11647s;

    public interface a extends u0 {
        void e(h8.v vVar, y0 y0Var);
    }

    public a1(y yVar, l8.g gVar, o0 o0Var, a aVar) {
        super(yVar, d9.r.c(), gVar, l8.g.d.LISTEN_STREAM_CONNECTION_BACKOFF, l8.g.d.LISTEN_STREAM_IDLE, l8.g.d.HEALTH_CHECK_TIMEOUT, aVar);
        this.f11647s = o0Var;
    }

    @Override // k8.c
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public void s(d9.t tVar) {
        this.f11671l.f();
        y0 y0VarA = this.f11647s.A(tVar);
        ((a) this.f11672m).e(this.f11647s.z(tVar), y0VarA);
    }

    public void B(int i10) {
        l8.b.d(m(), "Unwatching targets requires an open stream", new Object[0]);
        y(d9.s.l0().H(this.f11647s.a()).I(i10).build());
    }

    public void C(n4 n4Var) {
        l8.b.d(m(), "Watching queries requires an open stream", new Object[0]);
        d9.s.b bVarF = d9.s.l0().H(this.f11647s.a()).F(this.f11647s.V(n4Var));
        Map<String, String> mapN = this.f11647s.N(n4Var);
        if (mapN != null) {
            bVarF.E(mapN);
        }
        y(bVarF.build());
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
    public /* bridge */ /* synthetic */ void v() {
        super.v();
    }

    @Override // k8.c
    public /* bridge */ /* synthetic */ void w() {
        super.w();
    }

    @Override // k8.c
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void r(d9.t tVar) {
        s(tVar);
    }
}
