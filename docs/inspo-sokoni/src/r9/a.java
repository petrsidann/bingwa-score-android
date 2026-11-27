package r9;

import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.util.Log;
import fb.i;
import fb.j;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class a implements xa.a, j.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f15169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f15170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<C0267a> f15171c = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15172d = false;

    /* JADX INFO: renamed from: r9.a$a, reason: collision with other inner class name */
    public static class C0267a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f15174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15175c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public j.d f15176d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f15177e;

        public C0267a(String str, String str2, Integer num, j.d dVar, int i10) {
            this.f15173a = str;
            this.f15174b = str2;
            this.f15175c = num != null ? num.intValue() : 0;
            this.f15176d = dVar;
            this.f15177e = i10;
        }
    }

    public static boolean b(String str) {
        for (char c10 : str.toCharArray()) {
            if ("@£$¥èéùìòÇ\nØø\rÅåΔ_ΦΓΛΩΠΨΣΘΞ !\"#¤%&'()*+,-./0123456789:;<=>?ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÑÜ§¿abcdefghijklmnopqrstuvwxyzäöñüà".indexOf(c10) == -1) {
                return false;
            }
        }
        return true;
    }

    public final void a(String str, String str2, Integer num, j.d dVar) {
        this.f15171c.add(new C0267a(str, str2, num, dVar, 0));
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001a  */
    public final void c(j.d dVar) {
        Boolean boolValueOf;
        boolean z10;
        SubscriptionManager subscriptionManager = (SubscriptionManager) this.f15170b.getSystemService("telephony_subscription_service");
        if (subscriptionManager != null) {
            List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();
            if (activeSubscriptionInfoList != null) {
                z10 = activeSubscriptionInfoList.size() > 1;
            }
            boolValueOf = Boolean.valueOf(z10);
        } else {
            boolValueOf = Boolean.FALSE;
        }
        dVar.a(boolValueOf);
    }

    public final void d() {
        this.f15172d = true;
        while (true) {
            C0267a c0267aPoll = this.f15171c.poll();
            if (c0267aPoll == null) {
                this.f15172d = false;
                return;
            }
            f(c0267aPoll);
        }
    }

    public final void e(C0267a c0267a) {
        int i10 = c0267a.f15177e;
        if (i10 < 5) {
            c0267a.f15177e = i10 + 1;
            this.f15171c.add(c0267a);
            return;
        }
        c0267a.f15176d.b("SMS_FAILED", "Failed to send after retries: " + c0267a.f15173a, null);
    }

    public final void f(C0267a c0267a) {
        j.d dVar;
        String str;
        String str2;
        String str3;
        ArrayList<String> arrayListDivideMessage;
        String str4;
        if (f0.a.checkSelfPermission(this.f15170b, "android.permission.SEND_SMS") != 0) {
            c0267a.f15176d.b("PERMISSION_DENIED", "SEND_SMS permission not granted", null);
            return;
        }
        SubscriptionManager subscriptionManager = (SubscriptionManager) this.f15170b.getSystemService("telephony_subscription_service");
        if (subscriptionManager != null) {
            List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();
            if (activeSubscriptionInfoList != null) {
                int size = activeSubscriptionInfoList.size();
                int i10 = c0267a.f15175c;
                if (size > i10) {
                    SmsManager smsManagerForSubscriptionId = SmsManager.getSmsManagerForSubscriptionId(activeSubscriptionInfoList.get(i10).getSubscriptionId());
                    try {
                        String str5 = c0267a.f15174b;
                        if (!b(str5)) {
                            str5 = new String(str5.getBytes(StandardCharsets.UTF_16), StandardCharsets.UTF_16);
                            if (c0267a.f15174b.length() > 70) {
                                arrayListDivideMessage = smsManagerForSubscriptionId.divideMessage(str5);
                                str4 = c0267a.f15173a;
                                smsManagerForSubscriptionId.sendMultipartTextMessage(str4, null, arrayListDivideMessage, null, null);
                            } else {
                                str3 = c0267a.f15173a;
                                smsManagerForSubscriptionId.sendTextMessage(str3, null, str5, null, null);
                            }
                        } else if (c0267a.f15174b.length() > 160) {
                            arrayListDivideMessage = smsManagerForSubscriptionId.divideMessage(str5);
                            str4 = c0267a.f15173a;
                            smsManagerForSubscriptionId.sendMultipartTextMessage(str4, null, arrayListDivideMessage, null, null);
                        } else {
                            str3 = c0267a.f15173a;
                            smsManagerForSubscriptionId.sendTextMessage(str3, null, str5, null, null);
                        }
                        c0267a.f15176d.a("SMS sent to " + c0267a.f15173a);
                        return;
                    } catch (Exception e10) {
                        Log.e("BackgroundSmsPlugin", "Error sending SMS: " + e10.getMessage());
                        e(c0267a);
                        return;
                    }
                }
            }
            dVar = c0267a.f15176d;
            str = "INVALID_SIM_SLOT";
            str2 = "Invalid SIM slot";
        } else {
            dVar = c0267a.f15176d;
            str = "SIM_MANAGER_ERROR";
            str2 = "SubscriptionManager is null";
        }
        dVar.b(str, str2, null);
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        this.f15170b = bVar.a();
        j jVar = new j(bVar.c().k(), "background_sms");
        this.f15169a = jVar;
        jVar.e(this);
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        this.f15169a.e(null);
    }

    @Override // fb.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        if (iVar.f8284a.equals("sendSms")) {
            String str = (String) iVar.a("phone");
            String str2 = (String) iVar.a("msg");
            Integer num = (Integer) iVar.a("simSlot");
            if (str == null || str2 == null) {
                dVar.b("INVALID_ARGUMENT", "Phone number or message is null", null);
                return;
            }
            a(str, str2, num, dVar);
            if (this.f15172d) {
                return;
            }
            d();
            return;
        }
        if (iVar.f8284a.equals("isSupportMultiSim")) {
            c(dVar);
            return;
        }
        if (!iVar.f8284a.equals("launchApp")) {
            dVar.c();
            return;
        }
        try {
            Intent launchIntentForPackage = this.f15170b.getPackageManager().getLaunchIntentForPackage((String) iVar.a("packageName"));
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(268435456);
                this.f15170b.startActivity(launchIntentForPackage);
                dVar.a(Boolean.TRUE);
            } else {
                dVar.b("NOT_FOUND", "App not found", null);
            }
        } catch (Exception e10) {
            dVar.b("ERROR", e10.getLocalizedMessage(), null);
        }
    }
}
