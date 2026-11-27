package fb;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface b {

    public interface a {
        void a(ByteBuffer byteBuffer, InterfaceC0141b interfaceC0141b);
    }

    /* JADX INFO: renamed from: fb.b$b, reason: collision with other inner class name */
    public interface InterfaceC0141b {
        void a(ByteBuffer byteBuffer);
    }

    public interface c {
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8270a = true;

        public boolean a() {
            return this.f8270a;
        }
    }

    default c a(d dVar) {
        throw new UnsupportedOperationException("makeBackgroundTaskQueue not implemented.");
    }

    default c b() {
        return a(new d());
    }

    default void c(String str, a aVar, c cVar) {
        if (cVar != null) {
            throw new UnsupportedOperationException("setMessageHandler called with nonnull taskQueue is not supported.");
        }
        d(str, aVar);
    }

    void d(String str, a aVar);

    void e(String str, ByteBuffer byteBuffer);

    void f(String str, ByteBuffer byteBuffer, InterfaceC0141b interfaceC0141b);
}
