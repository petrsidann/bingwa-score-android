package c1;

import androidx.datastore.preferences.protobuf.a0;
import androidx.datastore.preferences.protobuf.s0;
import androidx.datastore.preferences.protobuf.y;
import androidx.datastore.preferences.protobuf.z0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g extends y<g, a> implements s0 {
    private static final g DEFAULT_INSTANCE;
    private static volatile z0<g> PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private a0.i<String> strings_ = y.x();

    public static final class a extends y.a<g, a> implements s0 {
        public a() {
            super(g.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(e eVar) {
            this();
        }

        public a x(Iterable<String> iterable) {
            s();
            ((g) this.f2046b).M(iterable);
            return this;
        }
    }

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        y.I(g.class, gVar);
    }

    public static g O() {
        return DEFAULT_INSTANCE;
    }

    public static a Q() {
        return DEFAULT_INSTANCE.t();
    }

    public final void M(Iterable<String> iterable) {
        N();
        androidx.datastore.preferences.protobuf.a.j(iterable, this.strings_);
    }

    public final void N() {
        if (this.strings_.g()) {
            return;
        }
        this.strings_ = y.D(this.strings_);
    }

    public List<String> P() {
        return this.strings_;
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public final Object w(y.f fVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.f3127a[fVar.ordinal()]) {
            case 1:
                return new g();
            case 2:
                return new a(eVar);
            case 3:
                return y.F(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                z0<g> bVar = PARSER;
                if (bVar == null) {
                    synchronized (g.class) {
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
