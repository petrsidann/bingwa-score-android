package ca;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import d9.a0;
import d9.d0;
import ed.t;
import fb.j;
import fb.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.k;
import lc.q;
import mc.o;
import mc.p;

/* JADX INFO: loaded from: classes.dex */
public final class i extends BroadcastReceiver implements n, j.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f3456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ba.a f3457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j.d f3458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public da.d f3459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j f3460f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Activity f3461l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<String> f3462m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f3463n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<String> f3464o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f3465p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f3466q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f3467r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3468s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f3469t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f3470u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f3471v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3472w;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f3474b;

        static {
            int[] iArr = new int[da.a.values().length];
            try {
                iArr[da.a.GET_SMS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[da.a.SEND_SMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[da.a.BACKGROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[da.a.GET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[da.a.PERMISSION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[da.a.CALL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f3473a = iArr;
            int[] iArr2 = new int[da.d.values().length];
            try {
                iArr2[da.d.GET_INBOX.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[da.d.GET_SENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[da.d.GET_DRAFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[da.d.GET_CONVERSATIONS.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[da.d.SEND_SMS.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[da.d.SEND_MULTIPART_SMS.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[da.d.SEND_SMS_INTENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[da.d.START_BACKGROUND_SERVICE.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[da.d.BACKGROUND_SERVICE_INITIALIZED.ordinal()] = 9;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[da.d.DISABLE_BACKGROUND_SERVICE.ordinal()] = 10;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[da.d.IS_SMS_CAPABLE.ordinal()] = 11;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[da.d.GET_CELLULAR_DATA_STATE.ordinal()] = 12;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[da.d.GET_CALL_STATE.ordinal()] = 13;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[da.d.GET_DATA_ACTIVITY.ordinal()] = 14;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr2[da.d.GET_NETWORK_OPERATOR.ordinal()] = 15;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr2[da.d.GET_NETWORK_OPERATOR_NAME.ordinal()] = 16;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr2[da.d.GET_DATA_NETWORK_TYPE.ordinal()] = 17;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr2[da.d.GET_PHONE_TYPE.ordinal()] = 18;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr2[da.d.GET_SIM_OPERATOR.ordinal()] = 19;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr2[da.d.GET_SIM_OPERATOR_NAME.ordinal()] = 20;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr2[da.d.GET_SIM_STATE.ordinal()] = 21;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr2[da.d.IS_NETWORK_ROAMING.ordinal()] = 22;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr2[da.d.GET_SIGNAL_STRENGTH.ordinal()] = 23;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr2[da.d.GET_SERVICE_STATE.ordinal()] = 24;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr2[da.d.OPEN_DIALER.ordinal()] = 25;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr2[da.d.DIAL_PHONE_NUMBER.ordinal()] = 26;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr2[da.d.REQUEST_SMS_PERMISSIONS.ordinal()] = 27;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr2[da.d.REQUEST_PHONE_PERMISSIONS.ordinal()] = 28;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr2[da.d.REQUEST_PHONE_AND_SMS_PERMISSIONS.ordinal()] = 29;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr2[da.d.NO_SUCH_METHOD.ordinal()] = 30;
            } catch (NoSuchFieldError unused36) {
            }
            f3474b = iArr2;
        }
    }

    public i(Context context, h smsController, ba.a permissionsController) {
        k.e(context, "context");
        k.e(smsController, "smsController");
        k.e(permissionsController, "permissionsController");
        this.f3455a = context;
        this.f3456b = smsController;
        this.f3457c = permissionsController;
        this.f3469t = -1L;
        this.f3470u = -1L;
        this.f3472w = -1;
    }

    public final boolean a(da.d smsAction, int i10) {
        List<String> listE;
        k.e(smsAction, "smsAction");
        this.f3459e = smsAction;
        this.f3472w = i10;
        switch (a.f3474b[smsAction.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 27:
                listE = this.f3457c.e();
                break;
            case 11:
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
            case 13:
            case 14:
            case 15:
            case 16:
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 30:
                return true;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case 25:
            case 26:
            case 28:
                listE = this.f3457c.c();
                break;
            case 24:
                listE = this.f3457c.d();
                break;
            case 29:
                listE = p.n(o.i(this.f3457c.e(), this.f3457c.c()));
                break;
            default:
                throw new lc.h();
        }
        return b(listE, i10);
    }

    public final boolean b(List<String> list, int i10) {
        ba.a aVar = this.f3457c;
        if (this.f3461l == null) {
            return aVar.f(list);
        }
        if (aVar.f(list)) {
            return true;
        }
        Activity activity = this.f3461l;
        if (activity == null) {
            k.o("activity");
            activity = null;
        }
        aVar.g(activity, list, i10);
        return false;
    }

    public final void c(da.d dVar) {
        try {
            switch (a.f3473a[dVar.i().ordinal()]) {
                case 1:
                    g(dVar);
                    return;
                case 2:
                    i(dVar);
                    return;
                case 3:
                    d(dVar);
                    return;
                case 4:
                    f(dVar);
                    return;
                case 5:
                    j.d dVar2 = this.f3458d;
                    if (dVar2 == null) {
                        k.o("result");
                        dVar2 = null;
                    }
                    dVar2.a(Boolean.TRUE);
                    return;
                case 6:
                    e(dVar);
                    return;
                default:
                    throw new lc.h();
            }
        } catch (IllegalArgumentException unused) {
            j.d dVar3 = this.f3458d;
            if (dVar3 == null) {
                k.o("result");
                dVar3 = null;
            }
            dVar3.b("illegal_argument", "Incorrect method called on channel.", null);
        } catch (RuntimeException e10) {
            j.d dVar4 = this.f3458d;
            if (dVar4 == null) {
                k.o("result");
                dVar4 = null;
            }
            dVar4.b("failed_to_fetch_sms", e10.getMessage(), null);
        }
    }

    public final void d(da.d dVar) {
        switch (a.f3474b[dVar.ordinal()]) {
            case 8:
                this.f3455a.getSharedPreferences("com.shounakmulay.android_telephony_plugin", 0).edit().putBoolean("disable_background", false).apply();
                b bVar = b.f3447a;
                bVar.i(this.f3455a, this.f3469t);
                bVar.h(this.f3455a, this.f3470u);
                return;
            case 9:
                b bVar2 = b.f3447a;
                Context applicationContext = this.f3455a.getApplicationContext();
                k.d(applicationContext, "getApplicationContext(...)");
                bVar2.g(applicationContext);
                return;
            case 10:
                this.f3455a.getSharedPreferences("com.shounakmulay.android_telephony_plugin", 0).edit().putBoolean("disable_background", true).apply();
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final void e(da.d dVar) {
        int i10 = a.f3474b[dVar.ordinal()];
        String str = null;
        if (i10 == 25) {
            h hVar = this.f3456b;
            String str2 = this.f3471v;
            if (str2 == null) {
                k.o("phoneNumber");
            } else {
                str = str2;
            }
            hVar.u(str);
            return;
        }
        if (i10 != 26) {
            throw new IllegalArgumentException();
        }
        h hVar2 = this.f3456b;
        String str3 = this.f3471v;
        if (str3 == null) {
            k.o("phoneNumber");
        } else {
            str = str3;
        }
        hVar2.a(str);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    /* JADX WARN: Code duplicated, block: B:40:0x0096  */
    /* JADX WARN: Code duplicated, block: B:41:0x009a  */
    public final void f(da.d dVar) {
        boolean zT;
        int iC;
        Object objH;
        j.d dVar2;
        j.d dVar3;
        h hVar = this.f3456b;
        j.d dVar4 = null;
        switch (a.f3474b[dVar.ordinal()]) {
            case 11:
                zT = hVar.t();
                objH = Boolean.valueOf(zT);
                dVar3 = this.f3458d;
                if (dVar3 == null) {
                    k.o("result");
                } else {
                    dVar4 = dVar3;
                }
                dVar4.a(objH);
                return;
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                iC = hVar.c();
                objH = Integer.valueOf(iC);
                dVar3 = this.f3458d;
                if (dVar3 == null) {
                    k.o("result");
                } else {
                    dVar4 = dVar3;
                }
                dVar4.a(objH);
                return;
            case 13:
                iC = hVar.b();
                objH = Integer.valueOf(iC);
                dVar3 = this.f3458d;
                if (dVar3 == null) {
                    k.o("result");
                } else {
                    dVar4 = dVar3;
                }
                dVar4.a(objH);
                return;
            case 14:
                iC = hVar.d();
                objH = Integer.valueOf(iC);
                dVar3 = this.f3458d;
                if (dVar3 == null) {
                    k.o("result");
                } else {
                    dVar4 = dVar3;
                }
                dVar4.a(objH);
                return;
            case 15:
                objH = hVar.h();
                dVar3 = this.f3458d;
                if (dVar3 == null) {
                    k.o("result");
                } else {
                    dVar4 = dVar3;
                }
                dVar4.a(objH);
                return;
            case 16:
                objH = hVar.i();
                dVar3 = this.f3458d;
                if (dVar3 == null) {
                    k.o("result");
                } else {
                    dVar4 = dVar3;
                }
                dVar4.a(objH);
                return;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                iC = hVar.e();
                objH = Integer.valueOf(iC);
                dVar3 = this.f3458d;
                if (dVar3 == null) {
                    k.o("result");
                } else {
                    dVar4 = dVar3;
                }
                dVar4.a(objH);
                return;
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                iC = hVar.k();
                objH = Integer.valueOf(iC);
                dVar3 = this.f3458d;
                if (dVar3 == null) {
                    k.o("result");
                } else {
                    dVar4 = dVar3;
                }
                dVar4.a(objH);
                return;
            case 19:
                objH = hVar.n();
                dVar3 = this.f3458d;
                if (dVar3 == null) {
                    k.o("result");
                } else {
                    dVar4 = dVar3;
                }
                dVar4.a(objH);
                return;
            case 20:
                objH = hVar.o();
                dVar3 = this.f3458d;
                if (dVar3 == null) {
                    k.o("result");
                } else {
                    dVar4 = dVar3;
                }
                dVar4.a(objH);
                return;
            case 21:
                iC = hVar.p();
                objH = Integer.valueOf(iC);
                dVar3 = this.f3458d;
                if (dVar3 == null) {
                    k.o("result");
                } else {
                    dVar4 = dVar3;
                }
                dVar4.a(objH);
                return;
            case 22:
                zT = hVar.s();
                objH = Boolean.valueOf(zT);
                dVar3 = this.f3458d;
                if (dVar3 == null) {
                    k.o("result");
                } else {
                    dVar4 = dVar3;
                }
                dVar4.a(objH);
                return;
            case 23:
                if (Build.VERSION.SDK_INT >= 29) {
                    objH = hVar.m();
                    if (objH == null) {
                        dVar2 = this.f3458d;
                        if (dVar2 == null) {
                            k.o("result");
                            dVar2 = null;
                        }
                        dVar2.b("SERVICE_STATE_NULL", "Error getting service state", null);
                        objH = q.f12711a;
                    }
                } else {
                    j.d dVar5 = this.f3458d;
                    if (dVar5 == null) {
                        k.o("result");
                        dVar5 = null;
                    }
                    dVar5.b("INCORRECT_SDK_VERSION", "getServiceState() can only be called on Android Q and above", null);
                    objH = q.f12711a;
                }
                dVar3 = this.f3458d;
                if (dVar3 == null) {
                    k.o("result");
                } else {
                    dVar4 = dVar3;
                }
                dVar4.a(objH);
                return;
            case 24:
                objH = hVar.l();
                if (objH == null) {
                    dVar2 = this.f3458d;
                    if (dVar2 == null) {
                        k.o("result");
                        dVar2 = null;
                    }
                    dVar2.b("SERVICE_STATE_NULL", "Error getting service state", null);
                    objH = q.f12711a;
                }
                dVar3 = this.f3458d;
                if (dVar3 == null) {
                    k.o("result");
                } else {
                    dVar4 = dVar3;
                }
                dVar4.a(objH);
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final void g(da.d dVar) {
        da.c cVar;
        if (this.f3462m == null) {
            this.f3462m = dVar == da.d.GET_CONVERSATIONS ? da.b.f6664a.a() : da.b.f6664a.b();
        }
        int i10 = a.f3474b[dVar.ordinal()];
        if (i10 == 1) {
            cVar = da.c.f6670b;
        } else if (i10 == 2) {
            cVar = da.c.f6671c;
        } else if (i10 == 3) {
            cVar = da.c.f6672d;
        } else {
            if (i10 != 4) {
                throw new IllegalArgumentException();
            }
            cVar = da.c.f6673e;
        }
        h hVar = this.f3456b;
        List<String> list = this.f3462m;
        k.b(list);
        List<HashMap<String, String>> listF = hVar.f(cVar, list, this.f3463n, this.f3464o, this.f3465p);
        j.d dVar2 = this.f3458d;
        if (dVar2 == null) {
            k.o("result");
            dVar2 = null;
        }
        dVar2.a(listF);
    }

    public final void h(da.d dVar, int i10) {
        if (a(dVar, i10)) {
            c(dVar);
        }
    }

    public final void i(da.d dVar) {
        if (this.f3468s) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("plugins.shounakmulay.intent.ACTION_SMS_SENT");
            intentFilter.addAction("plugins.shounakmulay.intent.ACTION_SMS_DELIVERED");
            this.f3455a.getApplicationContext().registerReceiver(this, intentFilter);
        }
        int i10 = a.f3474b[dVar.ordinal()];
        if (i10 == 5) {
            h hVar = this.f3456b;
            String str = this.f3467r;
            if (str == null) {
                k.o("address");
                str = null;
            }
            String str2 = this.f3466q;
            if (str2 == null) {
                k.o("messageBody");
                str2 = null;
            }
            hVar.w(str, str2, this.f3468s);
        } else if (i10 == 6) {
            h hVar2 = this.f3456b;
            String str3 = this.f3467r;
            if (str3 == null) {
                k.o("address");
                str3 = null;
            }
            String str4 = this.f3466q;
            if (str4 == null) {
                k.o("messageBody");
                str4 = null;
            }
            hVar2.v(str3, str4, this.f3468s);
        } else {
            if (i10 != 7) {
                throw new IllegalArgumentException();
            }
            h hVar3 = this.f3456b;
            String str5 = this.f3467r;
            if (str5 == null) {
                k.o("address");
                str5 = null;
            }
            String str6 = this.f3466q;
            if (str6 == null) {
                k.o("messageBody");
                str6 = null;
            }
            hVar3.x(str5, str6);
        }
        j.d dVar2 = this.f3458d;
        if (dVar2 == null) {
            k.o("result");
            dVar2 = null;
        }
        dVar2.a(null);
    }

    public final void j(List<String> list) {
        j.d dVar = this.f3458d;
        if (dVar == null) {
            k.o("result");
            dVar = null;
        }
        dVar.b("permission_denied", "Permission Request Denied By User.", list);
    }

    public final void k(Activity activity) {
        k.e(activity, "activity");
        this.f3461l = activity;
    }

    public final void l(j channel) {
        k.e(channel, "channel");
        this.f3460f = channel;
    }

    @Override // fb.j.c
    public void onMethodCall(fb.i call, j.d result) {
        int i10;
        String str;
        k.e(call, "call");
        k.e(result, "result");
        this.f3458d = result;
        da.d.a aVar = da.d.f6677b;
        String method = call.f8284a;
        k.d(method, "method");
        da.d dVarA = aVar.a(method);
        this.f3459e = dVarA;
        da.d dVar = null;
        if (dVarA == null) {
            k.o("action");
            dVarA = null;
        }
        if (dVarA == da.d.NO_SUCH_METHOD) {
            result.c();
            return;
        }
        da.d dVar2 = this.f3459e;
        if (dVar2 == null) {
            k.o("action");
            dVar2 = null;
        }
        boolean z10 = true;
        switch (a.f3473a[dVar2.i().ordinal()]) {
            case 1:
                this.f3462m = (List) call.a("projection");
                this.f3463n = (String) call.a("selection");
                this.f3464o = (List) call.a("selection_args");
                this.f3465p = (String) call.a("sort_order");
                da.d dVar3 = this.f3459e;
                if (dVar3 == null) {
                    k.o("action");
                } else {
                    dVar = dVar3;
                }
                h(dVar, 1);
                return;
            case 2:
                if (call.c("message_body") && call.c("address")) {
                    String str2 = (String) call.a("message_body");
                    String str3 = (String) call.a("address");
                    if (!(str2 == null || t.F(str2))) {
                        if (str3 != null && !t.F(str3)) {
                            z10 = false;
                        }
                        if (!z10) {
                            this.f3466q = str2;
                            this.f3467r = str3;
                            Boolean bool = (Boolean) call.a("listen_status");
                            this.f3468s = bool != null ? bool.booleanValue() : false;
                        }
                    }
                    str = "Message body or Address cannot be null or blank.";
                    result.b("illegal_argument", str, null);
                    return;
                }
                da.d dVar4 = this.f3459e;
                if (dVar4 == null) {
                    k.o("action");
                } else {
                    dVar = dVar4;
                }
                i10 = 2;
                h(dVar, i10);
                return;
            case 3:
                if (call.c("setupHandle") && call.c("backgroundHandle")) {
                    Long l10 = (Long) call.a("setupHandle");
                    Long l11 = (Long) call.a("backgroundHandle");
                    if (l10 == null || l11 == null) {
                        str = "Setup handle or background handle missing";
                        result.b("illegal_argument", str, null);
                        return;
                    } else {
                        this.f3469t = l10.longValue();
                        this.f3470u = l11.longValue();
                    }
                }
                da.d dVar5 = this.f3459e;
                if (dVar5 == null) {
                    k.o("action");
                } else {
                    dVar = dVar5;
                }
                i10 = 31;
                h(dVar, i10);
                return;
            case 4:
                da.d dVar6 = this.f3459e;
                if (dVar6 == null) {
                    k.o("action");
                } else {
                    dVar = dVar6;
                }
                i10 = 41;
                h(dVar, i10);
                return;
            case 5:
                da.d dVar7 = this.f3459e;
                if (dVar7 == null) {
                    k.o("action");
                } else {
                    dVar = dVar7;
                }
                i10 = 51;
                h(dVar, i10);
                return;
            case 6:
                if (call.c("phoneNumber")) {
                    String str4 = (String) call.a("phoneNumber");
                    if (!(str4 == null || t.F(str4))) {
                        this.f3471v = str4;
                    }
                    da.d dVar8 = this.f3459e;
                    if (dVar8 == null) {
                        k.o("action");
                    } else {
                        dVar = dVar8;
                    }
                    i10 = 61;
                    h(dVar, i10);
                    return;
                }
                return;
            default:
                throw new lc.h();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        int iHashCode = action.hashCode();
        if (iHashCode != -666483546) {
            if (iHashCode == 1251987990 && action.equals("plugins.shounakmulay.intent.ACTION_SMS_SENT")) {
                j jVar = this.f3460f;
                if (jVar == null) {
                    k.o("foregroundChannel");
                    jVar = null;
                }
                jVar.c("smsSent", null);
                return;
            }
            return;
        }
        if (action.equals("plugins.shounakmulay.intent.ACTION_SMS_DELIVERED")) {
            j jVar2 = this.f3460f;
            if (jVar2 == null) {
                k.o("foregroundChannel");
                jVar2 = null;
            }
            jVar2.c("smsDelivered", null);
            this.f3455a.unregisterReceiver(this);
        }
    }

    @Override // fb.n
    public boolean onRequestPermissionsResult(int i10, String[] permissions, int[] grantResults) {
        k.e(permissions, "permissions");
        k.e(grantResults, "grantResults");
        this.f3457c.h(false);
        ArrayList arrayList = new ArrayList();
        if (i10 != this.f3472w && this.f3459e == null) {
            return false;
        }
        int length = grantResults.length;
        int i11 = 0;
        int i12 = 0;
        boolean z10 = true;
        while (i11 < length) {
            int i13 = grantResults[i11];
            int i14 = i12 + 1;
            if (i13 == -1) {
                arrayList.add(permissions[i12]);
            }
            z10 = z10 && i13 == 0;
            i11++;
            i12 = i14;
        }
        if (!z10) {
            j(arrayList);
            return false;
        }
        da.d dVar = this.f3459e;
        if (dVar == null) {
            k.o("action");
            dVar = null;
        }
        c(dVar);
        return true;
    }
}
