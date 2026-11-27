package c1;

import androidx.datastore.preferences.protobuf.k0;
import androidx.datastore.preferences.protobuf.l0;
import androidx.datastore.preferences.protobuf.s0;
import androidx.datastore.preferences.protobuf.t1;
import androidx.datastore.preferences.protobuf.y;
import androidx.datastore.preferences.protobuf.z0;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f extends y<f, a> implements s0 {
    private static final f DEFAULT_INSTANCE;
    private static volatile z0<f> PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private l0<String, h> preferences_ = l0.d();

    public static final class a extends y.a<f, a> implements s0 {
        public a() {
            super(f.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(e eVar) {
            this();
        }

        public a x(String str, h hVar) {
            str.getClass();
            hVar.getClass();
            s();
            ((f) this.f2046b).M().put(str, hVar);
            return this;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k0<String, h> f3128a = k0.d(t1.b.f1944p, "", t1.b.f1946r, h.T());
    }

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        y.I(f.class, fVar);
    }

    public static a Q() {
        return DEFAULT_INSTANCE.t();
    }

    public static f R(InputStream inputStream) {
        return (f) y.G(DEFAULT_INSTANCE, inputStream);
    }

    public final Map<String, h> M() {
        return O();
    }

    public Map<String, h> N() {
        return Collections.unmodifiableMap(P());
    }

    public final l0<String, h> O() {
        if (!this.preferences_.i()) {
            this.preferences_ = this.preferences_.m();
        }
        return this.preferences_;
    }

    public final l0<String, h> P() {
        return this.preferences_;
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public final Object w(y.f fVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.f3127a[fVar.ordinal()]) {
            case 1:
                return new f();
            case 2:
                return new a(eVar);
            case 3:
                return y.F(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", b.f3128a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                z0<f> bVar = PARSER;
                if (bVar == null) {
                    synchronized (f.class) {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new y.b<>(DEFAULT_INSTANCE);
                            PARSER = bVar;
                        }
                        break;
                    }
                }
                return bVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
