package fb;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.b f8271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f8273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fb.b.c f8274d;

    public interface b {
        void a(Object obj);

        void b(String str, String str2, Object obj);

        void c();
    }

    /* JADX INFO: renamed from: fb.c$c, reason: collision with other inner class name */
    public final class C0142c implements fb.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f8275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference<b> f8276b = new AtomicReference<>(null);

        /* JADX INFO: renamed from: fb.c$c$a */
        public final class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final AtomicBoolean f8278a;

            public a() {
                this.f8278a = new AtomicBoolean(false);
            }

            @Override // fb.c.b
            public void a(Object obj) {
                if (this.f8278a.get() || C0142c.this.f8276b.get() != this) {
                    return;
                }
                c.this.f8271a.e(c.this.f8272b, c.this.f8273c.c(obj));
            }

            @Override // fb.c.b
            public void b(String str, String str2, Object obj) {
                if (this.f8278a.get() || C0142c.this.f8276b.get() != this) {
                    return;
                }
                c.this.f8271a.e(c.this.f8272b, c.this.f8273c.e(str, str2, obj));
            }

            @Override // fb.c.b
            public void c() {
                if (this.f8278a.getAndSet(true) || C0142c.this.f8276b.get() != this) {
                    return;
                }
                c.this.f8271a.e(c.this.f8272b, null);
            }
        }

        public C0142c(d dVar) {
            this.f8275a = dVar;
        }

        @Override // fb.b.a
        public void a(ByteBuffer byteBuffer, fb.b.InterfaceC0141b interfaceC0141b) {
            i iVarB = c.this.f8273c.b(byteBuffer);
            if (iVarB.f8284a.equals("listen")) {
                d(iVarB.f8285b, interfaceC0141b);
            } else if (iVarB.f8284a.equals("cancel")) {
                c(iVarB.f8285b, interfaceC0141b);
            } else {
                interfaceC0141b.a(null);
            }
        }

        public final void c(Object obj, fb.b.InterfaceC0141b interfaceC0141b) {
            ByteBuffer byteBufferE;
            if (this.f8276b.getAndSet(null) != null) {
                try {
                    this.f8275a.onCancel(obj);
                    interfaceC0141b.a(c.this.f8273c.c(null));
                    return;
                } catch (RuntimeException e10) {
                    qa.b.c("EventChannel#" + c.this.f8272b, "Failed to close event stream", e10);
                    byteBufferE = c.this.f8273c.e("error", e10.getMessage(), null);
                }
            } else {
                byteBufferE = c.this.f8273c.e("error", "No active stream to cancel", null);
            }
            interfaceC0141b.a(byteBufferE);
        }

        public final void d(Object obj, fb.b.InterfaceC0141b interfaceC0141b) {
            a aVar = new a();
            if (this.f8276b.getAndSet(aVar) != null) {
                try {
                    this.f8275a.onCancel(null);
                } catch (RuntimeException e10) {
                    qa.b.c("EventChannel#" + c.this.f8272b, "Failed to close existing event stream", e10);
                }
            }
            try {
                this.f8275a.onListen(obj, aVar);
                interfaceC0141b.a(c.this.f8273c.c(null));
            } catch (RuntimeException e11) {
                this.f8276b.set(null);
                qa.b.c("EventChannel#" + c.this.f8272b, "Failed to open event stream", e11);
                interfaceC0141b.a(c.this.f8273c.e("error", e11.getMessage(), null));
            }
        }
    }

    public interface d {
        void onCancel(Object obj);

        void onListen(Object obj, b bVar);
    }

    public c(fb.b bVar, String str) {
        this(bVar, str, q.f8299b);
    }

    public c(fb.b bVar, String str, k kVar) {
        this(bVar, str, kVar, null);
    }

    public c(fb.b bVar, String str, k kVar, fb.b.c cVar) {
        this.f8271a = bVar;
        this.f8272b = str;
        this.f8273c = kVar;
        this.f8274d = cVar;
    }

    public void d(d dVar) {
        if (this.f8274d != null) {
            this.f8271a.c(this.f8272b, dVar != null ? new C0142c(dVar) : null, this.f8274d);
        } else {
            this.f8271a.d(this.f8272b, dVar != null ? new C0142c(dVar) : null);
        }
    }
}
