package com.example.bingwa;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import gd.j;
import gd.m0;
import kotlin.jvm.internal.g;
import lc.k;
import lc.q;
import oc.e;
import qc.d;
import qc.f;
import qc.l;
import xc.p;

/* JADX INFO: loaded from: classes.dex */
public final class BootReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3521a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @f(c = "com.example.bingwa.BootReceiver", f = "BootReceiver.kt", l = {59}, m = "isBootFlagEnabled")
    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f3522a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3524c;

        public b(e<? super b> eVar) {
            super(eVar);
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) {
            this.f3522a = obj;
            this.f3524c |= Integer.MIN_VALUE;
            return BootReceiver.this.b(null, this);
        }
    }

    @f(c = "com.example.bingwa.BootReceiver$onReceive$shouldRunAfterBoot$1", f = "BootReceiver.kt", l = {35}, m = "invokeSuspend")
    public static final class c extends l implements p<m0, e<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3525a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f3527c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, e<? super c> eVar) {
            super(2, eVar);
            this.f3527c = context;
        }

        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(m0 m0Var, e<? super Boolean> eVar) {
            return ((c) create(m0Var, eVar)).invokeSuspend(q.f12711a);
        }

        @Override // qc.a
        public final e<q> create(Object obj, e<?> eVar) {
            return BootReceiver.this.new c(this.f3527c, eVar);
        }

        @Override // qc.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = pc.c.c();
            int i10 = this.f3525a;
            if (i10 == 0) {
                k.b(obj);
                BootReceiver bootReceiver = BootReceiver.this;
                Context context = this.f3527c;
                this.f3525a = 1;
                obj = bootReceiver.b(context, this);
                if (obj == objC) {
                    return objC;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                k.b(obj);
            }
            return obj;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(Context context, e<? super Boolean> eVar) throws Throwable {
        b bVar;
        if (eVar instanceof b) {
            bVar = (b) eVar;
            int i10 = bVar.f3524c;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar.f3524c = i10 - Integer.MIN_VALUE;
            } else {
                bVar = new b(eVar);
            }
        } else {
            bVar = new b(eVar);
        }
        Object objF = bVar.f3522a;
        Object objC = pc.c.c();
        int i11 = bVar.f3524c;
        if (i11 == 0) {
            k.b(objF);
            jd.d dVarA = x2.a.b(context).a();
            bVar.f3524c = 1;
            objF = jd.f.f(dVarA, bVar);
            if (objF == objC) {
                return objC;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b(objF);
        }
        Boolean bool = (Boolean) ((d1.d) objF).b(d1.f.a("boot_flag"));
        return qc.b.a(bool != null ? bool.booleanValue() : false);
    }

    public final void c(Context context) {
        Intent intent = new Intent(context, (Class<?>) MainActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("after_boot", true);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 201326592);
        Object systemService = context.getSystemService("alarm");
        kotlin.jvm.internal.k.c(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        ((AlarmManager) systemService).setExactAndAllowWhileIdle(2, System.currentTimeMillis() + ((long) 5000), activity);
    }

    public final void d(Context context) {
        context.startForegroundService(new Intent(context, (Class<?>) MyForegroundService.class));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            Log.e("BootReceiver", "Context or intent is null in BootReceiver");
            return;
        }
        if (kotlin.jvm.internal.k.a("android.intent.action.BOOT_COMPLETED", intent.getAction())) {
            Log.i("BootReceiver", "Device boot completed. Starting necessary services...");
            d(context);
            if (!((Boolean) j.b(null, new c(context, null), 1, null)).booleanValue()) {
                Log.i("BootReceiver", "boot_flag is disabled. MainActivity will not launch.");
            } else {
                Log.i("BootReceiver", "boot_flag is enabled. Scheduling MainActivity launch.");
                c(context);
            }
        }
    }
}
