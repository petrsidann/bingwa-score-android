package pa;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import fb.i;
import fb.j;
import java.util.Map;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class a implements xa.a, j.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f14421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f14422b;

    public final boolean a(String str, String str2, Map<String, String> map) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (str != null && str2 != null) {
            intent.setClassName(str, str + '.' + str2);
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                intent.putExtra(entry.getKey(), entry.getValue());
            }
        }
        try {
            Context context = this.f14422b;
            if (context == null) {
                k.o("context");
                context = null;
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e10) {
            System.out.println(e10);
            return false;
        }
    }

    public final boolean b(String str, Map<String, String> map) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (str != null) {
            intent.setPackage(str);
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                intent.putExtra(entry.getKey(), entry.getValue());
            }
        }
        try {
            Context context = this.f14422b;
            if (context == null) {
                k.o("context");
                context = null;
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e10) {
            System.out.println(e10);
            return false;
        }
    }

    public final boolean c(String str, Map<String, String> map) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (str != null) {
            intent.setData(Uri.parse("market://details?id=" + str));
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                intent.putExtra(entry.getKey(), entry.getValue());
            }
        }
        try {
            Context context = this.f14422b;
            if (context == null) {
                k.o("context");
                context = null;
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e10) {
            System.out.println(e10);
            return false;
        }
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b flutterPluginBinding) {
        k.e(flutterPluginBinding, "flutterPluginBinding");
        j jVar = new j(flutterPluginBinding.b(), "app_activity_launcher");
        this.f14421a = jVar;
        jVar.e(this);
        this.f14422b = flutterPluginBinding.a();
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b binding) {
        k.e(binding, "binding");
        j jVar = this.f14421a;
        if (jVar == null) {
            k.o("channel");
            jVar = null;
        }
        jVar.e(null);
    }

    @Override // fb.j.c
    public void onMethodCall(i call, j.d result) {
        boolean zB;
        k.e(call, "call");
        k.e(result, "result");
        String str = call.f8284a;
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1263222921) {
                if (iHashCode != 159270694) {
                    if (iHashCode == 832344953 && str.equals("openActivity")) {
                        zB = a((String) call.a("appId"), (String) call.a("activity"), (Map) call.a("extras"));
                        result.a(Boolean.valueOf(zB));
                        return;
                    }
                } else if (str.equals("openMarket")) {
                    zB = c((String) call.a("appId"), (Map) call.a("extras"));
                    result.a(Boolean.valueOf(zB));
                    return;
                }
            } else if (str.equals("openApp")) {
                zB = b((String) call.a("appId"), (Map) call.a("extras"));
                result.a(Boolean.valueOf(zB));
                return;
            }
        }
        result.c();
    }
}
