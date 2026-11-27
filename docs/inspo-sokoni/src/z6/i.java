package z6;

import z6.n;

/* JADX INFO: loaded from: classes.dex */
public abstract class i<SerializationT extends n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g7.a f20324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<SerializationT> f20325b;

    public class a extends i<SerializationT> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f20326c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g7.a aVar, Class cls, b bVar) {
            super(aVar, cls, null);
            this.f20326c = bVar;
        }
    }

    public interface b<SerializationT extends n> {
    }

    public i(g7.a aVar, Class<SerializationT> cls) {
        this.f20324a = aVar;
        this.f20325b = cls;
    }

    public /* synthetic */ i(g7.a aVar, Class cls, a aVar2) {
        this(aVar, cls);
    }

    public static <SerializationT extends n> i<SerializationT> a(b<SerializationT> bVar, g7.a aVar, Class<SerializationT> cls) {
        return new a(aVar, cls, bVar);
    }

    public final g7.a b() {
        return this.f20324a;
    }

    public final Class<SerializationT> c() {
        return this.f20325b;
    }
}
