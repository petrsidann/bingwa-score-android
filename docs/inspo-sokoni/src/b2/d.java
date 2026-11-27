package b2;

import android.os.Bundle;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f2751f = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f2754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2755d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p.b<String, c> f2752a = new p.b<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2756e = true;

    public interface a {
        void a(f fVar);
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public interface c {
        Bundle a();
    }

    public static final void d(d this$0, k kVar, androidx.lifecycle.g.a event) {
        boolean z10;
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(kVar, "<anonymous parameter 0>");
        kotlin.jvm.internal.k.e(event, "event");
        if (event == androidx.lifecycle.g.a.ON_START) {
            z10 = true;
        } else if (event != androidx.lifecycle.g.a.ON_STOP) {
            return;
        } else {
            z10 = false;
        }
        this$0.f2756e = z10;
    }

    public final Bundle b(String key) {
        kotlin.jvm.internal.k.e(key, "key");
        if (!this.f2755d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = this.f2754c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f2754c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f2754c;
        boolean z10 = false;
        if (bundle4 != null && !bundle4.isEmpty()) {
            z10 = true;
        }
        if (!z10) {
            this.f2754c = null;
        }
        return bundle2;
    }

    public final c c(String key) {
        kotlin.jvm.internal.k.e(key, "key");
        for (Map.Entry<String, c> components : this.f2752a) {
            kotlin.jvm.internal.k.d(components, "components");
            String key2 = components.getKey();
            c value = components.getValue();
            if (kotlin.jvm.internal.k.a(key2, key)) {
                return value;
            }
        }
        return null;
    }

    public final void e(androidx.lifecycle.g lifecycle) {
        kotlin.jvm.internal.k.e(lifecycle, "lifecycle");
        if (!(!this.f2753b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        lifecycle.a(new i() { // from class: b2.c
            @Override // androidx.lifecycle.i
            public final void c(k kVar, androidx.lifecycle.g.a aVar) {
                d.d(this.f2750a, kVar, aVar);
            }
        });
        this.f2753b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f2753b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!this.f2755d)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        this.f2754c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f2755d = true;
    }

    public final void g(Bundle outBundle) {
        kotlin.jvm.internal.k.e(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f2754c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        p.b<String, c>.d dVarI = this.f2752a.i();
        kotlin.jvm.internal.k.d(dVarI, "this.components.iteratorWithAdditions()");
        while (dVarI.hasNext()) {
            Map.Entry next = dVarI.next();
            bundle.putBundle((String) next.getKey(), ((c) next.getValue()).a());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
    }

    public final void h(String key, c provider) {
        kotlin.jvm.internal.k.e(key, "key");
        kotlin.jvm.internal.k.e(provider, "provider");
        if (!(this.f2752a.l(key, provider) == null)) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }
}
