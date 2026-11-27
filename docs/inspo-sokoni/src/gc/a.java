package gc;

import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements xa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hc.a f9131a;

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b flutterPluginBinding) {
        k.e(flutterPluginBinding, "flutterPluginBinding");
        this.f9131a = new hc.a(flutterPluginBinding);
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b binding) {
        k.e(binding, "binding");
        hc.a aVar = this.f9131a;
        if (aVar == null) {
            k.o("flutterHandler");
            aVar = null;
        }
        aVar.d();
    }
}
