package z6;

import r6.t;
import z6.n;

/* JADX INFO: loaded from: classes.dex */
public abstract class j<ParametersT extends t, SerializationT extends n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<ParametersT> f20327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<SerializationT> f20328b;

    public class a extends j<ParametersT, SerializationT> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f20329c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class cls, Class cls2, b bVar) {
            super(cls, cls2, null);
            this.f20329c = bVar;
        }
    }

    public interface b<ParametersT extends t, SerializationT extends n> {
    }

    public j(Class<ParametersT> cls, Class<SerializationT> cls2) {
        this.f20327a = cls;
        this.f20328b = cls2;
    }

    public /* synthetic */ j(Class cls, Class cls2, a aVar) {
        this(cls, cls2);
    }

    public static <ParametersT extends t, SerializationT extends n> j<ParametersT, SerializationT> a(b<ParametersT, SerializationT> bVar, Class<ParametersT> cls, Class<SerializationT> cls2) {
        return new a(cls, cls2, bVar);
    }

    public Class<ParametersT> b() {
        return this.f20327a;
    }

    public Class<SerializationT> c() {
        return this.f20328b;
    }
}
