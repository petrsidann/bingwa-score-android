package z6;

import r6.x;
import z6.n;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<SerializationT extends n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g7.a f20300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<SerializationT> f20301b;

    public class a extends b<SerializationT> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0342b f20302c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g7.a aVar, Class cls, InterfaceC0342b interfaceC0342b) {
            super(aVar, cls, null);
            this.f20302c = interfaceC0342b;
        }

        @Override // z6.b
        public r6.f d(SerializationT serializationt, x xVar) {
            return this.f20302c.a(serializationt, xVar);
        }
    }

    /* JADX INFO: renamed from: z6.b$b, reason: collision with other inner class name */
    public interface InterfaceC0342b<SerializationT extends n> {
        r6.f a(SerializationT serializationt, x xVar);
    }

    public b(g7.a aVar, Class<SerializationT> cls) {
        this.f20300a = aVar;
        this.f20301b = cls;
    }

    public /* synthetic */ b(g7.a aVar, Class cls, a aVar2) {
        this(aVar, cls);
    }

    public static <SerializationT extends n> b<SerializationT> a(InterfaceC0342b<SerializationT> interfaceC0342b, g7.a aVar, Class<SerializationT> cls) {
        return new a(aVar, cls, interfaceC0342b);
    }

    public final g7.a b() {
        return this.f20300a;
    }

    public final Class<SerializationT> c() {
        return this.f20301b;
    }

    public abstract r6.f d(SerializationT serializationt, x xVar);
}
