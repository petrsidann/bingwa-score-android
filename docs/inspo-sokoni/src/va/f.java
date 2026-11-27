package va;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f17221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f17222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public va.b f17223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FlutterJNI f17224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ExecutorService f17225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Future<b> f17226g;

    public class a implements Callable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f17227a;

        public a(Context context) {
            this.f17227a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            f.this.f17224e.prefetchDefaultFontManager();
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b call() {
            String str;
            ub.e eVarZ = ub.e.z("FlutterLoader initTask");
            try {
                f.c(f.this, this.f17227a);
                try {
                    f.this.f17224e.loadLibrary(this.f17227a);
                    f.this.f17224e.updateRefreshRate();
                    f.this.f17225f.execute(new Runnable() { // from class: va.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f17219a.c();
                        }
                    });
                    b bVar = new b(ub.b.d(this.f17227a), ub.b.a(this.f17227a), ub.b.c(this.f17227a), null);
                    if (eVarZ != null) {
                        eVarZ.close();
                    }
                    return bVar;
                } catch (UnsatisfiedLinkError e10) {
                    if (!e10.toString().contains("couldn't find \"libflutter.so\"") && !e10.toString().contains("dlopen failed: library \"libflutter.so\" not found")) {
                        throw e10;
                    }
                    String property = System.getProperty("os.arch");
                    File file = new File(f.this.f17223d.f17207f);
                    String[] list = file.list();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Could not load libflutter.so this is possibly because the application is running on an architecture that Flutter Android does not support (e.g. x86) see https://docs.flutter.dev/deployment/android#what-are-the-supported-target-architectures for more detail.\nApp is using cpu architecture: ");
                    sb2.append(property);
                    sb2.append(", and the native libraries directory (with path ");
                    sb2.append(file.getAbsolutePath());
                    sb2.append(") ");
                    if (file.exists()) {
                        str = "contains the following files: " + Arrays.toString(list);
                    } else {
                        str = "does not exist.";
                    }
                    sb2.append(str);
                    throw new UnsupportedOperationException(sb2.toString(), e10);
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
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f17230b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f17231c;

        public b(String str, String str2, String str3) {
            this.f17229a = str;
            this.f17230b = str2;
            this.f17231c = str3;
        }

        public /* synthetic */ b(String str, String str2, String str3, a aVar) {
            this(str, str2, str3);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17232a;

        public String a() {
            return this.f17232a;
        }
    }

    public f() {
        this(qa.a.e().d().a());
    }

    public f(FlutterJNI flutterJNI) {
        this(flutterJNI, qa.a.e().b());
    }

    public f(FlutterJNI flutterJNI, ExecutorService executorService) {
        this.f17220a = false;
        this.f17224e = flutterJNI;
        this.f17225f = executorService;
    }

    public static /* synthetic */ g c(f fVar, Context context) {
        fVar.m(context);
        return null;
    }

    public static boolean o(Bundle bundle) {
        if (bundle == null) {
            return true;
        }
        return bundle.getBoolean("io.flutter.embedding.android.LeakVM", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(Context context, String[] strArr, Handler handler, Runnable runnable) {
        h(context.getApplicationContext(), strArr);
        handler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(final Context context, final String[] strArr, final Handler handler, final Runnable runnable) {
        try {
            this.f17226g.get();
            ub.a.a(Looper.getMainLooper()).post(new Runnable() { // from class: va.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17214a.p(context, strArr, handler, runnable);
                }
            });
        } catch (Exception e10) {
            qa.b.c("FlutterLoader", "Flutter initialization failed.", e10);
            throw new RuntimeException(e10);
        }
    }

    public boolean g() {
        return this.f17223d.f17208g;
    }

    public void h(Context context, String[] strArr) {
        if (this.f17220a) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (this.f17221b == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        try {
            ub.e eVarZ = ub.e.z("FlutterLoader#ensureInitializationComplete");
            try {
                b bVar = this.f17226g.get();
                ArrayList arrayList = new ArrayList();
                arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("--icu-native-lib-path=");
                sb2.append(this.f17223d.f17207f);
                String str = File.separator;
                sb2.append(str);
                sb2.append("libflutter.so");
                arrayList.add(sb2.toString());
                if (strArr != null) {
                    Collections.addAll(arrayList, strArr);
                }
                arrayList.add("--aot-shared-library-name=" + this.f17223d.f17202a);
                arrayList.add("--aot-shared-library-name=" + this.f17223d.f17207f + str + this.f17223d.f17202a);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("--cache-dir-path=");
                sb3.append(bVar.f17230b);
                arrayList.add(sb3.toString());
                if (this.f17223d.f17206e != null) {
                    arrayList.add("--domain-network-policy=" + this.f17223d.f17206e);
                }
                if (this.f17221b.a() != null) {
                    arrayList.add("--log-tag=" + this.f17221b.a());
                }
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                int i10 = bundle != null ? bundle.getInt("io.flutter.embedding.android.OldGenHeapSize") : 0;
                if (i10 == 0) {
                    ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    i10 = (int) ((memoryInfo.totalMem / 1000000.0d) / 2.0d);
                }
                arrayList.add("--old-gen-heap-size=" + i10);
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                arrayList.add("--resource-cache-max-bytes-threshold=" + (displayMetrics.widthPixels * displayMetrics.heightPixels * 12 * 4));
                arrayList.add("--prefetched-default-font-manager");
                if (bundle != null) {
                    if (bundle.containsKey("io.flutter.embedding.android.EnableImpeller")) {
                        arrayList.add(bundle.getBoolean("io.flutter.embedding.android.EnableImpeller") ? "--enable-impeller=true" : "--enable-impeller=false");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableVulkanValidation", false)) {
                        arrayList.add("--enable-vulkan-validation");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableOpenGLGPUTracing", false)) {
                        arrayList.add("--enable-opengl-gpu-tracing");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.EnableVulkanGPUTracing", false)) {
                        arrayList.add("--enable-vulkan-gpu-tracing");
                    }
                    if (bundle.getBoolean("io.flutter.embedding.android.DisableSurfaceControl", false)) {
                        arrayList.add("--disable-surface-control");
                    }
                    if (bundle.containsKey("io.flutter.embedding.android.EnableMergedPlatformUIThread")) {
                        arrayList.add(bundle.getBoolean("io.flutter.embedding.android.EnableMergedPlatformUIThread") ? "--enable-merged-platform-ui-thread" : "--no-enable-merged-platform-ui-thread");
                    }
                    String string = bundle.getString("io.flutter.embedding.android.ImpellerBackend");
                    if (string != null) {
                        arrayList.add("--impeller-backend=" + string);
                    }
                }
                arrayList.add("--leak-vm=" + (o(bundle) ? "true" : "false"));
                this.f17224e.init(context, (String[]) arrayList.toArray(new String[0]), null, bVar.f17229a, bVar.f17230b, SystemClock.uptimeMillis() - this.f17222c);
                this.f17220a = true;
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
        } catch (Exception e10) {
            qa.b.c("FlutterLoader", "Flutter initialization failed.", e10);
            throw new RuntimeException(e10);
        }
    }

    public void i(final Context context, final String[] strArr, final Handler handler, final Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (this.f17221b == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        if (this.f17220a) {
            handler.post(runnable);
        } else {
            this.f17225f.execute(new Runnable() { // from class: va.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17209a.q(context, strArr, handler, runnable);
                }
            });
        }
    }

    public String j() {
        return this.f17223d.f17205d;
    }

    public final String k(String str) {
        return this.f17223d.f17205d + File.separator + str;
    }

    public String l(String str) {
        return k(str);
    }

    public final g m(Context context) {
        return null;
    }

    public boolean n() {
        return this.f17220a;
    }

    public void r(Context context) {
        s(context, new c());
    }

    public void s(Context context, c cVar) {
        if (this.f17221b != null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
        ub.e eVarZ = ub.e.z("FlutterLoader#startInitialization");
        try {
            Context applicationContext = context.getApplicationContext();
            this.f17221b = cVar;
            this.f17222c = SystemClock.uptimeMillis();
            this.f17223d = va.a.e(applicationContext);
            io.flutter.view.f.f((DisplayManager) applicationContext.getSystemService("display"), this.f17224e).g();
            this.f17226g = this.f17225f.submit(new a(applicationContext));
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
}
