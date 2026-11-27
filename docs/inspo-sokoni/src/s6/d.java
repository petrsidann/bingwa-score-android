package s6;

import com.google.crypto.tink.shaded.protobuf.q;
import e7.y;
import f7.p;
import f7.r;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public class d extends z6.d<e7.f> {

    public class a extends z6.k<f7.l, e7.f> {
        public a(Class cls) {
            super(cls);
        }

        @Override // z6.k
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public f7.l a(e7.f fVar) {
            return new f7.a(fVar.R().z(), fVar.S().P());
        }
    }

    public class b extends z6.d.a<e7.g, e7.f> {
        public b(Class cls) {
            super(cls);
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public e7.f a(e7.g gVar) {
            return e7.f.U().y(gVar.R()).x(com.google.crypto.tink.shaded.protobuf.i.k(p.c(gVar.Q()))).z(d.this.l()).build();
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public e7.g d(com.google.crypto.tink.shaded.protobuf.i iVar) {
            return e7.g.T(iVar, q.b());
        }

        @Override // z6.d.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(e7.g gVar) throws GeneralSecurityException {
            r.a(gVar.Q());
            d.this.o(gVar.R());
        }
    }

    public d() {
        super(e7.f.class, new a(f7.l.class));
    }

    @Override // z6.d
    public String d() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // z6.d
    public z6.d.a<e7.g, e7.f> f() {
        return new b(e7.g.class);
    }

    @Override // z6.d
    public y.c g() {
        return y.c.SYMMETRIC;
    }

    public int l() {
        return 0;
    }

    @Override // z6.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public e7.f h(com.google.crypto.tink.shaded.protobuf.i iVar) {
        return e7.f.V(iVar, q.b());
    }

    @Override // z6.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void j(e7.f fVar) {
        r.c(fVar.T(), l());
        r.a(fVar.R().size());
        o(fVar.S());
    }

    public final void o(e7.h hVar) throws GeneralSecurityException {
        if (hVar.P() < 12 || hVar.P() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }
}
