package ic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import kotlin.jvm.internal.k;
import lc.q;
import xc.l;

/* JADX INFO: loaded from: classes2.dex */
public class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jc.a f10569a = jc.a.NOTHING;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f10571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l<? super Long, q> f10572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f10573e;

    public final long a() {
        return this.f10573e;
    }

    public final String b() {
        return this.f10570b;
    }

    public final jc.a c() {
        return this.f10569a;
    }

    public final void d(Context context) {
        jc.a aVar;
        k.e(context, "context");
        Object systemService = context.getSystemService("phone");
        k.c(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        int callState = ((TelephonyManager) systemService).getCallState();
        if (callState == 0) {
            g();
            this.f10571c = 0L;
            aVar = jc.a.CALL_ENDED;
        } else if (callState == 1) {
            e();
            aVar = jc.a.CALL_INCOMING;
        } else if (callState != 2) {
            aVar = jc.a.NOTHING;
        } else {
            this.f10571c = System.currentTimeMillis();
            g();
            aVar = jc.a.CALL_STARTED;
        }
        this.f10569a = aVar;
        this.f10570b = null;
    }

    public final void e() {
        this.f10571c = 0L;
        f(0L);
    }

    public final void f(long j10) {
        if (this.f10573e != j10) {
            this.f10573e = j10;
            l<? super Long, q> lVar = this.f10572d;
            if (lVar != null) {
                lVar.invoke(Long.valueOf(j10));
            }
        }
    }

    public final void g() {
        if (this.f10571c > 0) {
            f((System.currentTimeMillis() - this.f10571c) / ((long) 1000));
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        jc.a aVar;
        if (intent != null) {
            try {
                stringExtra = intent.getStringExtra("state");
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        } else {
            stringExtra = null;
        }
        if (k.a(stringExtra, TelephonyManager.EXTRA_STATE_RINGING)) {
            e();
            aVar = jc.a.CALL_INCOMING;
        } else if (k.a(stringExtra, TelephonyManager.EXTRA_STATE_OFFHOOK)) {
            this.f10571c = System.currentTimeMillis();
            g();
            aVar = jc.a.CALL_STARTED;
        } else if (k.a(stringExtra, TelephonyManager.EXTRA_STATE_IDLE)) {
            g();
            this.f10571c = 0L;
            aVar = jc.a.CALL_ENDED;
        } else {
            aVar = jc.a.NOTHING;
        }
        this.f10569a = aVar;
        this.f10570b = intent != null ? intent.getStringExtra("incoming_number") : null;
    }
}
