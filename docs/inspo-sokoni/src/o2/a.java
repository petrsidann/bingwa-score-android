package o2;

import androidx.window.extensions.layout.WindowLayoutComponent;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class a implements n2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0235a f13630a = new C0235a(null);

    /* JADX INFO: renamed from: o2.a$a, reason: collision with other inner class name */
    public static final class C0235a {
        public C0235a() {
        }

        public /* synthetic */ C0235a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final n2.a a(WindowLayoutComponent component, j2.d adapter) {
            k.e(component, "component");
            k.e(adapter, "adapter");
            int iA = j2.e.f11172a.a();
            if (iA >= 2) {
                return new e(component);
            }
            return iA == 1 ? new d(component, adapter) : new c();
        }
    }
}
