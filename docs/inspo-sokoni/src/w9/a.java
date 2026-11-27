package w9;

import android.content.Context;
import kotlin.jvm.internal.k;
import z9.c;

/* JADX INFO: loaded from: classes.dex */
public final class a implements xa.a, ya.a, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z9.b f17820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.pravera.flutter_foreground_task.service.a f17821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ya.c f17822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f17823d;

    @Override // z9.c
    public com.pravera.flutter_foreground_task.service.a a() {
        com.pravera.flutter_foreground_task.service.a aVar = this.f17821b;
        if (aVar != null) {
            return aVar;
        }
        k.o("foregroundServiceManager");
        return null;
    }

    @Override // z9.c
    public z9.b b() {
        z9.b bVar = this.f17820a;
        if (bVar != null) {
            return bVar;
        }
        k.o("notificationPermissionManager");
        return null;
    }

    @Override // ya.a
    public void onAttachedToActivity(ya.c binding) {
        k.e(binding, "binding");
        b bVar = this.f17823d;
        b bVar2 = null;
        if (bVar == null) {
            k.o("methodCallHandler");
            bVar = null;
        }
        bVar.d(binding.g());
        z9.b bVar3 = this.f17820a;
        if (bVar3 == null) {
            k.o("notificationPermissionManager");
            bVar3 = null;
        }
        binding.h(bVar3);
        b bVar4 = this.f17823d;
        if (bVar4 == null) {
            k.o("methodCallHandler");
        } else {
            bVar2 = bVar4;
        }
        binding.b(bVar2);
        this.f17822c = binding;
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b binding) {
        k.e(binding, "binding");
        this.f17820a = new z9.b();
        this.f17821b = new com.pravera.flutter_foreground_task.service.a();
        Context contextA = binding.a();
        k.d(contextA, "getApplicationContext(...)");
        b bVar = new b(contextA, this);
        this.f17823d = bVar;
        fb.b bVarB = binding.b();
        k.d(bVarB, "getBinaryMessenger(...)");
        bVar.c(bVarB);
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
        ya.c cVar = this.f17822c;
        if (cVar != null) {
            z9.b bVar = this.f17820a;
            if (bVar == null) {
                k.o("notificationPermissionManager");
                bVar = null;
            }
            cVar.f(bVar);
        }
        ya.c cVar2 = this.f17822c;
        if (cVar2 != null) {
            b bVar2 = this.f17823d;
            if (bVar2 == null) {
                k.o("methodCallHandler");
                bVar2 = null;
            }
            cVar2.d(bVar2);
        }
        this.f17822c = null;
        b bVar3 = this.f17823d;
        if (bVar3 == null) {
            k.o("methodCallHandler");
            bVar3 = null;
        }
        bVar3.d(null);
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b binding) {
        k.e(binding, "binding");
        b bVar = this.f17823d;
        if (bVar != null) {
            if (bVar == null) {
                k.o("methodCallHandler");
                bVar = null;
            }
            bVar.b();
        }
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(ya.c binding) {
        k.e(binding, "binding");
        onAttachedToActivity(binding);
    }
}
