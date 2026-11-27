package xa;

import android.content.Context;
import io.flutter.plugin.platform.k;
import io.flutter.view.TextureRegistry;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: xa.a$a, reason: collision with other inner class name */
    public interface InterfaceC0323a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f18070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final io.flutter.embedding.engine.a f18071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final fb.b f18072c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextureRegistry f18073d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final k f18074e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final InterfaceC0323a f18075f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final io.flutter.embedding.engine.b f18076g;

        public b(Context context, io.flutter.embedding.engine.a aVar, fb.b bVar, TextureRegistry textureRegistry, k kVar, InterfaceC0323a interfaceC0323a, io.flutter.embedding.engine.b bVar2) {
            this.f18070a = context;
            this.f18071b = aVar;
            this.f18072c = bVar;
            this.f18073d = textureRegistry;
            this.f18074e = kVar;
            this.f18075f = interfaceC0323a;
            this.f18076g = bVar2;
        }

        public Context a() {
            return this.f18070a;
        }

        public fb.b b() {
            return this.f18072c;
        }

        @Deprecated
        public io.flutter.embedding.engine.a c() {
            return this.f18071b;
        }
    }

    void onAttachedToEngine(b bVar);

    void onDetachedFromEngine(b bVar);
}
