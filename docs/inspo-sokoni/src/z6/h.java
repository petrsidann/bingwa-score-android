package z6;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import r6.t;
import r6.x;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f20322b = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<o> f20323a = new AtomicReference<>(new o.b().e());

    public static h a() {
        return f20322b;
    }

    public <SerializationT extends n> r6.f b(SerializationT serializationt, x xVar) {
        return this.f20323a.get().e(serializationt, xVar);
    }

    public r6.f c(l lVar, x xVar) {
        if (xVar == null) {
            throw new NullPointerException("access cannot be null");
        }
        try {
            try {
                return b(lVar, xVar);
            } catch (GeneralSecurityException e10) {
                throw new p("Creating a LegacyProtoKey failed", e10);
            }
        } catch (GeneralSecurityException unused) {
            return new e(lVar, xVar);
        }
    }

    public synchronized <SerializationT extends n> void d(b<SerializationT> bVar) {
        this.f20323a.set(new o.b(this.f20323a.get()).f(bVar).e());
    }

    public synchronized <KeyT extends r6.f, SerializationT extends n> void e(c<KeyT, SerializationT> cVar) {
        this.f20323a.set(new o.b(this.f20323a.get()).g(cVar).e());
    }

    public synchronized <SerializationT extends n> void f(i<SerializationT> iVar) {
        this.f20323a.set(new o.b(this.f20323a.get()).h(iVar).e());
    }

    public synchronized <ParametersT extends t, SerializationT extends n> void g(j<ParametersT, SerializationT> jVar) {
        this.f20323a.set(new o.b(this.f20323a.get()).i(jVar).e());
    }
}
