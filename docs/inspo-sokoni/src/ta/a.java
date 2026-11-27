package ta;

import android.content.res.AssetManager;
import fb.r;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.FlutterCallbackInformation;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements fb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterJNI f15862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AssetManager f15863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ta.c f15864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fb.b f15865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f15867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final fb.b.a f15868g;

    /* JADX INFO: renamed from: ta.a$a, reason: collision with other inner class name */
    public class C0287a implements fb.b.a {
        public C0287a() {
        }

        @Override // fb.b.a
        public void a(ByteBuffer byteBuffer, fb.b.InterfaceC0141b interfaceC0141b) {
            a.this.f15867f = r.f8302b.b(byteBuffer);
            a.h(a.this);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AssetManager f15870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f15871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FlutterCallbackInformation f15872c;

        public b(AssetManager assetManager, String str, FlutterCallbackInformation flutterCallbackInformation) {
            this.f15870a = assetManager;
            this.f15871b = str;
            this.f15872c = flutterCallbackInformation;
        }

        public String toString() {
            return "DartCallback( bundle path: " + this.f15871b + ", library path: " + this.f15872c.callbackLibraryPath + ", function: " + this.f15872c.callbackName + " )";
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f15874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f15875c;

        public c(String str, String str2) {
            this.f15873a = str;
            this.f15874b = null;
            this.f15875c = str2;
        }

        public c(String str, String str2, String str3) {
            this.f15873a = str;
            this.f15874b = str2;
            this.f15875c = str3;
        }

        public static c a() {
            va.f fVarC = qa.a.e().c();
            if (fVarC.n()) {
                return new c(fVarC.j(), "main");
            }
            throw new AssertionError("DartEntrypoints can only be created once a FlutterEngine is created.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f15873a.equals(cVar.f15873a)) {
                return this.f15875c.equals(cVar.f15875c);
            }
            return false;
        }

        public int hashCode() {
            return (this.f15873a.hashCode() * 31) + this.f15875c.hashCode();
        }

        public String toString() {
            return "DartEntrypoint( bundle path: " + this.f15873a + ", function: " + this.f15875c + " )";
        }
    }

    public static class d implements fb.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ta.c f15876a;

        public d(ta.c cVar) {
            this.f15876a = cVar;
        }

        public /* synthetic */ d(ta.c cVar, C0287a c0287a) {
            this(cVar);
        }

        @Override // fb.b
        public fb.b.c a(fb.b.d dVar) {
            return this.f15876a.a(dVar);
        }

        @Override // fb.b
        public void c(String str, fb.b.a aVar, fb.b.c cVar) {
            this.f15876a.c(str, aVar, cVar);
        }

        @Override // fb.b
        public void d(String str, fb.b.a aVar) {
            this.f15876a.d(str, aVar);
        }

        @Override // fb.b
        public void e(String str, ByteBuffer byteBuffer) {
            this.f15876a.f(str, byteBuffer, null);
        }

        @Override // fb.b
        public void f(String str, ByteBuffer byteBuffer, fb.b.InterfaceC0141b interfaceC0141b) {
            this.f15876a.f(str, byteBuffer, interfaceC0141b);
        }
    }

    public interface e {
    }

    public a(FlutterJNI flutterJNI, AssetManager assetManager) {
        this.f15866e = false;
        C0287a c0287a = new C0287a();
        this.f15868g = c0287a;
        this.f15862a = flutterJNI;
        this.f15863b = assetManager;
        ta.c cVar = new ta.c(flutterJNI);
        this.f15864c = cVar;
        cVar.d("flutter/isolate", c0287a);
        this.f15865d = new d(cVar, null);
        if (flutterJNI.isAttached()) {
            this.f15866e = true;
        }
    }

    public static /* synthetic */ e h(a aVar) {
        aVar.getClass();
        return null;
    }

    @Override // fb.b
    @Deprecated
    public fb.b.c a(fb.b.d dVar) {
        return this.f15865d.a(dVar);
    }

    @Override // fb.b
    @Deprecated
    public void c(String str, fb.b.a aVar, fb.b.c cVar) {
        this.f15865d.c(str, aVar, cVar);
    }

    @Override // fb.b
    @Deprecated
    public void d(String str, fb.b.a aVar) {
        this.f15865d.d(str, aVar);
    }

    @Override // fb.b
    @Deprecated
    public void e(String str, ByteBuffer byteBuffer) {
        this.f15865d.e(str, byteBuffer);
    }

    @Override // fb.b
    @Deprecated
    public void f(String str, ByteBuffer byteBuffer, fb.b.InterfaceC0141b interfaceC0141b) {
        this.f15865d.f(str, byteBuffer, interfaceC0141b);
    }

    public void i(b bVar) {
        if (this.f15866e) {
            qa.b.g("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        ub.e eVarZ = ub.e.z("DartExecutor#executeDartCallback");
        try {
            qa.b.f("DartExecutor", "Executing Dart callback: " + bVar);
            FlutterJNI flutterJNI = this.f15862a;
            String str = bVar.f15871b;
            FlutterCallbackInformation flutterCallbackInformation = bVar.f15872c;
            flutterJNI.runBundleAndSnapshotFromLibrary(str, flutterCallbackInformation.callbackName, flutterCallbackInformation.callbackLibraryPath, bVar.f15870a, null);
            this.f15866e = true;
            if (eVarZ != null) {
                eVarZ.close();
            }
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void j(c cVar) {
        k(cVar, null);
    }

    public void k(c cVar, List<String> list) {
        if (this.f15866e) {
            qa.b.g("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        ub.e eVarZ = ub.e.z("DartExecutor#executeDartEntrypoint");
        try {
            qa.b.f("DartExecutor", "Executing Dart entrypoint: " + cVar);
            this.f15862a.runBundleAndSnapshotFromLibrary(cVar.f15873a, cVar.f15875c, cVar.f15874b, this.f15863b, list);
            this.f15866e = true;
            if (eVarZ != null) {
                eVarZ.close();
            }
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public fb.b l() {
        return this.f15865d;
    }

    public boolean m() {
        return this.f15866e;
    }

    public void n() {
        if (this.f15862a.isAttached()) {
            this.f15862a.notifyLowMemoryWarning();
        }
    }

    public void o() {
        qa.b.f("DartExecutor", "Attached to JNI. Registering the platform message handler for this Dart execution context.");
        this.f15862a.setPlatformMessageHandler(this.f15864c);
    }

    public void p() {
        qa.b.f("DartExecutor", "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
        this.f15862a.setPlatformMessageHandler(null);
    }
}
