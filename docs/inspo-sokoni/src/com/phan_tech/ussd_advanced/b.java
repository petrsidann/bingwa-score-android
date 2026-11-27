package com.phan_tech.ussd_advanced;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import ed.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.k;
import lc.q;
import xc.l;

/* JADX INFO: loaded from: classes.dex */
public final class b implements v9.b, com.phan_tech.ussd_advanced.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f6046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Context f6047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static HashMap<String, List<String>> f6048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a f6049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static l<? super AccessibilityEvent, q> f6050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Boolean f6051g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Boolean f6052h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static v9.b f6053i;

    public interface a {
        void a(String str);

        void b(AccessibilityEvent accessibilityEvent);
    }

    static {
        b bVar = new b();
        f6045a = bVar;
        f6046b = new String[]{"extra_asus_dial_use_dualsim", "com.android.phone.extra.slot", "slot", "simslot", "sim_slot", "subscription", "Subscription", "phone", "com.android.phone.DialingMode", "simSlot", "slot_id", "simId", "simnum", "phone_type", "slotId", "slotIdx"};
        f6048d = v9.a.a();
        Boolean bool = Boolean.FALSE;
        f6051g = bool;
        f6052h = bool;
        f6053i = bVar;
    }

    @Override // com.phan_tech.ussd_advanced.a
    public void a(AccessibilityEvent event) {
        k.e(event, "event");
        USSDServiceKT.b(event);
    }

    @Override // v9.b
    public void b(String text, AccessibilityEvent event) {
        k.e(text, "text");
        k.e(event, "event");
        USSDServiceKT.n(text, event);
    }

    @Override // com.phan_tech.ussd_advanced.a
    public void c(Context context, String ussdPhoneNumber, int i10, a callbackInvoke) {
        k.e(context, "context");
        k.e(ussdPhoneNumber, "ussdPhoneNumber");
        k.e(callbackInvoke, "callbackInvoke");
        f6052h = Boolean.FALSE;
        f6047c = context;
        o(callbackInvoke);
        if (q(h())) {
            d(ussdPhoneNumber, i10);
        } else {
            f().a("Check your accessibility");
        }
    }

    public final void d(String str, int i10) {
        a aVarF;
        String str2;
        if (f6048d.containsKey("KEY_LOGIN") && f6048d.containsKey("KEY_ERROR")) {
            if (!(str.length() == 0)) {
                String strEncode = Uri.encode("#");
                String strP = strEncode != null ? ed.q.p(str, "#", strEncode, false, 4, null) : null;
                f6051g = Boolean.TRUE;
                h().startActivity(e(Uri.parse("tel:" + strP), i10));
                return;
            }
            aVarF = f();
            str2 = "Bad ussd number";
        } else {
            aVarF = f();
            str2 = "Bad Mapping structure";
        }
        aVarF.a(str2);
    }

    public final Intent e(Uri uri, int i10) {
        List<PhoneAccountHandle> callCapablePhoneAccounts;
        Object systemService = h().getSystemService("telecom");
        TelecomManager telecomManager = systemService instanceof TelecomManager ? (TelecomManager) systemService : null;
        Intent intent = new Intent("android.intent.action.CALL", uri);
        String[] strArr = f6046b;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(intent.putExtra(str, i10));
        }
        intent.setFlags(268435456);
        intent.putExtra("com.android.phone.force.slot", true);
        intent.putExtra("Cdma_Supp", true);
        if (telecomManager != null && (callCapablePhoneAccounts = telecomManager.getCallCapablePhoneAccounts()) != null && callCapablePhoneAccounts.size() > i10) {
            intent.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", callCapablePhoneAccounts.get(i10));
        }
        return intent;
    }

    public final a f() {
        a aVar = f6049e;
        if (aVar != null) {
            return aVar;
        }
        k.o("callbackInvoke");
        return null;
    }

    public final l<AccessibilityEvent, q> g() {
        return f6050f;
    }

    public final Context h() {
        Context context = f6047c;
        if (context != null) {
            return context;
        }
        k.o("context");
        return null;
    }

    public final HashMap<String, List<String>> i() {
        return f6048d;
    }

    public final Boolean j() {
        return f6052h;
    }

    public final boolean k(Context context) {
        Object systemService = context.getSystemService("accessibility");
        AccessibilityManager accessibilityManager = systemService instanceof AccessibilityManager ? (AccessibilityManager) systemService : null;
        if (accessibilityManager != null) {
            List<AccessibilityServiceInfo> installedAccessibilityServiceList = accessibilityManager.getInstalledAccessibilityServiceList();
            k.d(installedAccessibilityServiceList, "getInstalledAccessibilityServiceList(...)");
            for (AccessibilityServiceInfo accessibilityServiceInfo : installedAccessibilityServiceList) {
                String id2 = accessibilityServiceInfo.getId();
                k.d(id2, "getId(...)");
                String packageName = context.getPackageName();
                k.d(packageName, "getPackageName(...)");
                if (t.v(id2, packageName, false, 2, null) && Settings.Secure.getInt(context.getApplicationContext().getContentResolver(), "accessibility_enabled") == 1) {
                    String string = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "enabled_accessibility_services");
                    if (string != null && t.b0(string, new char[]{':'}, false, 0, 6, null).contains(accessibilityServiceInfo.getId())) {
                        return true;
                    }
                } else {
                    String id3 = accessibilityServiceInfo.getId();
                    k.d(id3, "getId(...)");
                    String packageName2 = context.getPackageName();
                    k.d(packageName2, "getPackageName(...)");
                    if (t.v(id3, packageName2, false, 2, null)) {
                        String string2 = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "enabled_accessibility_services").toString();
                        String id4 = accessibilityServiceInfo.getId();
                        k.d(id4, "getId(...)");
                        if (t.v(string2, id4, false, 2, null)) {
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public final Boolean l() {
        return f6051g;
    }

    public final void m(Activity activity) {
        activity.startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), 1);
    }

    public void n(String text, AccessibilityEvent event, l<? super AccessibilityEvent, q> callbackMessage) {
        k.e(text, "text");
        k.e(event, "event");
        k.e(callbackMessage, "callbackMessage");
        f6050f = callbackMessage;
        f6052h = Boolean.TRUE;
        v9.b bVar = f6053i;
        if (bVar != null) {
            bVar.b(text, event);
        }
    }

    public final void o(a aVar) {
        k.e(aVar, "<set-?>");
        f6049e = aVar;
    }

    public void p() {
        f6051g = Boolean.FALSE;
    }

    public boolean q(Context context) {
        k.e(context, "context");
        boolean zK = k(context);
        if (!zK) {
            f6045a.m((Activity) context);
        }
        return zK;
    }
}
