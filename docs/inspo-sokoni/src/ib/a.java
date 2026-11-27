package ib;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import eb.n;
import fb.j;
import fb.l;
import java.util.HashMap;
import java.util.Map;
import ya.c;

/* JADX INFO: loaded from: classes2.dex */
public class a implements xa.a, ya.a, l, n.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f10564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PackageManager f10565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f10566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, ResolveInfo> f10567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<Integer, j.d> f10568e = new HashMap();

    public a(n nVar) {
        this.f10564a = nVar;
        this.f10565b = nVar.f7701b;
        nVar.b(this);
    }

    @Override // eb.n.b
    public Map<String, String> a() {
        if (this.f10567d == null) {
            c();
        }
        HashMap map = new HashMap();
        for (String str : this.f10567d.keySet()) {
            map.put(str, this.f10567d.get(str).loadLabel(this.f10565b).toString());
        }
        return map;
    }

    @Override // eb.n.b
    public void b(String str, String str2, boolean z10, j.d dVar) {
        if (this.f10566c == null) {
            dVar.b("error", "Plugin not bound to an Activity", null);
            return;
        }
        Map<String, ResolveInfo> map = this.f10567d;
        if (map == null) {
            dVar.b("error", "Can not process text actions before calling queryTextActions", null);
            return;
        }
        ResolveInfo resolveInfo = map.get(str);
        if (resolveInfo == null) {
            dVar.b("error", "Text processing activity not found", null);
            return;
        }
        Integer numValueOf = Integer.valueOf(dVar.hashCode());
        this.f10568e.put(numValueOf, dVar);
        Intent intent = new Intent();
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent.setClassName(activityInfo.packageName, activityInfo.name);
        intent.setAction("android.intent.action.PROCESS_TEXT");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.PROCESS_TEXT", str2);
        intent.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", z10);
        this.f10566c.g().startActivityForResult(intent, numValueOf.intValue());
    }

    public final void c() {
        this.f10567d = new HashMap();
        int i10 = Build.VERSION.SDK_INT;
        Intent type = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        for (ResolveInfo resolveInfo : i10 >= 33 ? this.f10565b.queryIntentActivities(type, PackageManager.ResolveInfoFlags.of(0L)) : this.f10565b.queryIntentActivities(type, 0)) {
            String str = resolveInfo.activityInfo.name;
            resolveInfo.loadLabel(this.f10565b).toString();
            this.f10567d.put(str, resolveInfo);
        }
    }

    @Override // fb.l
    public boolean onActivityResult(int i10, int i11, Intent intent) {
        if (!this.f10568e.containsKey(Integer.valueOf(i10))) {
            return false;
        }
        this.f10568e.remove(Integer.valueOf(i10)).a(i11 == -1 ? intent.getStringExtra("android.intent.extra.PROCESS_TEXT") : null);
        return true;
    }

    @Override // ya.a
    public void onAttachedToActivity(c cVar) {
        this.f10566c = cVar;
        cVar.b(this);
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
        this.f10566c.d(this);
        this.f10566c = null;
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        this.f10566c.d(this);
        this.f10566c = null;
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(c cVar) {
        this.f10566c = cVar;
        cVar.b(this);
    }
}
