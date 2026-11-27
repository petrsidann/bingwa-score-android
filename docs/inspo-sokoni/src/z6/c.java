package z6;

import r6.f;
import z6.n;

/* JADX INFO: loaded from: classes.dex */
public abstract class c<KeyT extends r6.f, SerializationT extends n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<KeyT> f20303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<SerializationT> f20304b;

    public class a extends c<KeyT, SerializationT> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f20305c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class cls, Class cls2, b bVar) {
            super(cls, cls2, null);
            this.f20305c = bVar;
        }
    }

    public interface b<KeyT extends r6.f, SerializationT extends n> {
    }

    public c(Class<KeyT> cls, Class<SerializationT> cls2) {
        this.f20303a = cls;
        this.f20304b = cls2;
    }

    public /* synthetic */ c(Class cls, Class cls2, a aVar) {
        this(cls, cls2);
    }

    public static <KeyT extends r6.f, SerializationT extends n> c<KeyT, SerializationT> a(b<KeyT, SerializationT> bVar, Class<KeyT> cls, Class<SerializationT> cls2) {
        return new a(cls, cls2, bVar);
    }

    public Class<KeyT> b() {
        return this.f20303a;
    }

    public Class<SerializationT> c() {
        return this.f20304b;
    }
}
