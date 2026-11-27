package z7;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, w7.e<?>> f20369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, w7.g<?>> f20370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w7.e<Object> f20371c;

    public static final class a implements x7.b<a> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final w7.e<Object> f20372d = new w7.e() { // from class: z7.g
            @Override // w7.b
            public final void a(Object obj, w7.f fVar) {
                h.a.e(obj, fVar);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Class<?>, w7.e<?>> f20373a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Class<?>, w7.g<?>> f20374b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public w7.e<Object> f20375c = f20372d;

        public static /* synthetic */ void e(Object obj, w7.f fVar) {
            throw new w7.c("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public h c() {
            return new h(new HashMap(this.f20373a), new HashMap(this.f20374b), this.f20375c);
        }

        public a d(x7.a aVar) {
            aVar.a(this);
            return this;
        }

        @Override // x7.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public <U> a a(Class<U> cls, w7.e<? super U> eVar) {
            this.f20373a.put(cls, eVar);
            this.f20374b.remove(cls);
            return this;
        }
    }

    public h(Map<Class<?>, w7.e<?>> map, Map<Class<?>, w7.g<?>> map2, w7.e<Object> eVar) {
        this.f20369a = map;
        this.f20370b = map2;
        this.f20371c = eVar;
    }

    public static a a() {
        return new a();
    }

    public void b(Object obj, OutputStream outputStream) {
        new f(outputStream, this.f20369a, this.f20370b, this.f20371c).q(obj);
    }

    public byte[] c(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
