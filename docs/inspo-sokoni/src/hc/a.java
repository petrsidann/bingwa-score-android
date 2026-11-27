package hc;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import fb.c;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.internal.k;
import lc.i;
import lc.m;
import mc.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f9936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Timer f9937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f9938c;

    /* JADX INFO: renamed from: hc.a$a, reason: collision with other inner class name */
    public static final class C0163a implements c.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ic.a f9939a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ xa.a.b f9941c;

        /* JADX INFO: renamed from: hc.a$a$a, reason: collision with other inner class name */
        public static final class C0164a extends ic.a {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ c.b f9943g;

            public C0164a(c.b bVar) {
                this.f9943g = bVar;
            }

            @Override // ic.a, android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                super.onReceive(context, intent);
                if (c() == jc.a.CALL_STARTED) {
                    C0163a.this.d(this.f9943g);
                } else if (c() == jc.a.CALL_ENDED) {
                    C0163a.this.e();
                }
                c.b bVar = this.f9943g;
                if (bVar != null) {
                    bVar.a(e0.f(m.a("status", c().name()), m.a("phoneNumber", b()), m.a("callDuration", Integer.valueOf((int) a()))));
                }
            }
        }

        /* JADX INFO: renamed from: hc.a$a$b */
        public static final class b extends TimerTask {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f9945b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c.b f9946c;

            public b(a aVar, c.b bVar) {
                this.f9945b = aVar;
                this.f9946c = bVar;
            }

            public static final void b(c.b bVar, C0163a c0163a) {
                if (bVar != null) {
                    i[] iVarArr = new i[3];
                    ic.a aVar = c0163a.f9939a;
                    ic.a aVar2 = null;
                    if (aVar == null) {
                        k.o("receiver");
                        aVar = null;
                    }
                    iVarArr[0] = m.a("status", aVar.c().name());
                    ic.a aVar3 = c0163a.f9939a;
                    if (aVar3 == null) {
                        k.o("receiver");
                        aVar3 = null;
                    }
                    iVarArr[1] = m.a("phoneNumber", aVar3.b());
                    ic.a aVar4 = c0163a.f9939a;
                    if (aVar4 == null) {
                        k.o("receiver");
                    } else {
                        aVar2 = aVar4;
                    }
                    iVarArr[2] = m.a("callDuration", Integer.valueOf((int) aVar2.a()));
                    bVar.a(e0.f(iVarArr));
                }
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ic.a aVar = C0163a.this.f9939a;
                ic.a aVar2 = null;
                if (aVar == null) {
                    k.o("receiver");
                    aVar = null;
                }
                if (aVar.c() == jc.a.CALL_STARTED) {
                    ic.a aVar3 = C0163a.this.f9939a;
                    if (aVar3 == null) {
                        k.o("receiver");
                    } else {
                        aVar2 = aVar3;
                    }
                    aVar2.g();
                    Handler handler = this.f9945b.f9938c;
                    final c.b bVar = this.f9946c;
                    final C0163a c0163a = C0163a.this;
                    handler.post(new Runnable() { // from class: hc.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.C0163a.b.b(bVar, c0163a);
                        }
                    });
                }
            }
        }

        public C0163a(xa.a.b bVar) {
            this.f9941c = bVar;
        }

        public final void d(c.b bVar) {
            Timer timer = a.this.f9937b;
            if (timer != null) {
                timer.cancel();
            }
            a.this.f9937b = new Timer();
            Timer timer2 = a.this.f9937b;
            if (timer2 != null) {
                timer2.schedule(new b(a.this, bVar), 0L, 1000L);
            }
        }

        public final void e() {
            Timer timer = a.this.f9937b;
            if (timer != null) {
                timer.cancel();
            }
            a.this.f9937b = null;
        }

        @Override // fb.c.d
        public void onCancel(Object obj) {
            e();
            Context contextA = this.f9941c.a();
            ic.a aVar = this.f9939a;
            if (aVar == null) {
                k.o("receiver");
                aVar = null;
            }
            contextA.unregisterReceiver(aVar);
        }

        @Override // fb.c.d
        public void onListen(Object obj, c.b bVar) {
            this.f9939a = new C0164a(bVar);
            Context contextA = this.f9941c.a();
            k.d(contextA, "getApplicationContext(...)");
            boolean z10 = f0.a.checkSelfPermission(contextA, "android.permission.READ_PHONE_STATE") == 0;
            boolean z11 = f0.a.checkSelfPermission(contextA, "android.permission.READ_CALL_LOG") == 0;
            ic.a aVar = null;
            if (z10 && z11) {
                ic.a aVar2 = this.f9939a;
                if (aVar2 == null) {
                    k.o("receiver");
                    aVar2 = null;
                }
                aVar2.d(contextA);
                if (bVar != null) {
                    i[] iVarArr = new i[3];
                    ic.a aVar3 = this.f9939a;
                    if (aVar3 == null) {
                        k.o("receiver");
                        aVar3 = null;
                    }
                    iVarArr[0] = m.a("status", aVar3.c().name());
                    ic.a aVar4 = this.f9939a;
                    if (aVar4 == null) {
                        k.o("receiver");
                        aVar4 = null;
                    }
                    iVarArr[1] = m.a("phoneNumber", aVar4.b());
                    ic.a aVar5 = this.f9939a;
                    if (aVar5 == null) {
                        k.o("receiver");
                        aVar5 = null;
                    }
                    iVarArr[2] = m.a("callDuration", Integer.valueOf((int) aVar5.a()));
                    bVar.a(e0.f(iVarArr));
                }
            }
            Context contextA2 = this.f9941c.a();
            ic.a aVar6 = this.f9939a;
            if (aVar6 == null) {
                k.o("receiver");
            } else {
                aVar = aVar6;
            }
            contextA2.registerReceiver(aVar, new IntentFilter("android.intent.action.PHONE_STATE"));
        }
    }

    public a(xa.a.b binding) {
        k.e(binding, "binding");
        this.f9936a = new c(binding.b(), "PHONE_STATE_STREAM");
        this.f9938c = new Handler(Looper.getMainLooper());
        this.f9936a.d(new C0163a(binding));
    }

    public final void d() {
        Timer timer = this.f9937b;
        if (timer != null) {
            timer.cancel();
        }
        this.f9937b = null;
        this.f9936a.d(null);
    }
}
