package tb;

import android.os.Bundle;
import android.util.Log;
import fb.i;
import fb.j;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements j.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f15909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f15910b;

    public a(b bVar) {
        this.f15909a = bVar;
    }

    public static Bundle a(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, map.get(str));
        }
        return bundle;
    }

    public final void b(j.d dVar, String str) {
        dVar.a(Boolean.valueOf(this.f15909a.a(str)));
    }

    public final void c(j.d dVar) {
        this.f15909a.b();
        dVar.a(null);
    }

    public final void d(i iVar, j.d dVar, String str) {
        b.a aVarC = this.f15909a.c(str, a((Map) iVar.a("headers")), ((Boolean) iVar.a("useWebView")).booleanValue(), ((Boolean) iVar.a("enableJavaScript")).booleanValue(), ((Boolean) iVar.a("enableDomStorage")).booleanValue());
        if (aVarC == b.a.NO_ACTIVITY) {
            dVar.b("NO_ACTIVITY", "Launching a URL requires a foreground activity.", null);
        } else if (aVarC == b.a.ACTIVITY_NOT_FOUND) {
            dVar.b("ACTIVITY_NOT_FOUND", String.format("No Activity found to handle intent { %s }", str), null);
        } else {
            dVar.a(Boolean.TRUE);
        }
    }

    public void e(fb.b bVar) {
        if (this.f15910b != null) {
            Log.wtf("MethodCallHandlerImpl", "Setting a method call handler before the last was disposed.");
            f();
        }
        j jVar = new j(bVar, "plugins.flutter.io/url_launcher_android");
        this.f15910b = jVar;
        jVar.e(this);
    }

    public void f() {
        j jVar = this.f15910b;
        if (jVar == null) {
            Log.d("MethodCallHandlerImpl", "Tried to stop listening when no MethodChannel had been initialized.");
        } else {
            jVar.e(null);
            this.f15910b = null;
        }
    }

    @Override // fb.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        String str = (String) iVar.a("url");
        String str2 = iVar.f8284a;
        str2.hashCode();
        switch (str2) {
            case "launch":
                d(iVar, dVar, str);
                break;
            case "canLaunch":
                b(dVar, str);
                break;
            case "closeWebView":
                c(dVar);
                break;
            default:
                dVar.c();
                break;
        }
    }
}
