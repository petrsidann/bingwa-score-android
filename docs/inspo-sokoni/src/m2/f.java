package m2;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.window.extensions.layout.WindowLayoutComponent;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12928a = a.f12929a;

    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final boolean f12930b = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f12929a = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f12931c = u.b(f.class).b();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final lc.f<n2.a> f12932d = lc.g.a(C0214a.f12934a);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static g f12933e = b.f12904a;

        /* JADX INFO: renamed from: m2.f$a$a, reason: collision with other inner class name */
        public static final class C0214a extends kotlin.jvm.internal.l implements xc.a<n2.a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0214a f12934a = new C0214a();

            public C0214a() {
                super(0);
            }

            @Override // xc.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final n2.a invoke() {
                WindowLayoutComponent windowLayoutComponentG;
                try {
                    ClassLoader loader = f.class.getClassLoader();
                    e eVar = loader != null ? new e(loader, new j2.d(loader)) : null;
                    if (eVar == null || (windowLayoutComponentG = eVar.g()) == null) {
                        return null;
                    }
                    o2.a.C0235a c0235a = o2.a.f13630a;
                    kotlin.jvm.internal.k.d(loader, "loader");
                    return c0235a.a(windowLayoutComponentG, new j2.d(loader));
                } catch (Throwable unused) {
                    if (!a.f12930b) {
                        return null;
                    }
                    Log.d(a.f12931c, "Failed to load WindowExtensions");
                    return null;
                }
            }
        }

        public final n2.a c() {
            return f12932d.getValue();
        }

        public final f d(Context context) {
            kotlin.jvm.internal.k.e(context, "context");
            n2.a aVarC = c();
            if (aVarC == null) {
                aVarC = androidx.window.layout.adapter.sidecar.b.f2717c.a(context);
            }
            return f12933e.a(new i(m.f12951b, aVarC));
        }
    }

    jd.d<j> a(Activity activity);
}
