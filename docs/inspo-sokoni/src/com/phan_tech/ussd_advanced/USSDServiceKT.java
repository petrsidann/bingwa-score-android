package com.phan_tech.ussd_advanced;

import android.accessibilityservice.AccessibilityService;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class USSDServiceKT extends AccessibilityService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AccessibilityEvent f6042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Context f6043c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f6044a = new ArrayList();

    public static void b(AccessibilityEvent accessibilityEvent) {
        d(accessibilityEvent, "close session");
    }

    public static void c(AccessibilityEvent accessibilityEvent) {
        for (AccessibilityNodeInfo accessibilityNodeInfo : h(accessibilityEvent)) {
            if (accessibilityNodeInfo.getClassName().toString().toLowerCase().contains("button") || accessibilityNodeInfo.getClassName().toString().toLowerCase().contains("textview")) {
                if (accessibilityNodeInfo.isClickable() && accessibilityNodeInfo.performAction(16)) {
                    return;
                }
            }
        }
        qa.b.b("USSDServiceKTB", "Fallback failed: No clickable button found at index 0.");
    }

    public static void d(AccessibilityEvent accessibilityEvent, String str) {
        List listAsList = Arrays.asList("Cancel", "Exit", "Close", "Stop");
        List listAsList2 = Arrays.asList("Send", "OK", "Yes", "Proceed");
        if (!"close session".equalsIgnoreCase(str)) {
            listAsList = listAsList2;
        }
        boolean z10 = false;
        for (AccessibilityNodeInfo accessibilityNodeInfo : h(accessibilityEvent)) {
            String lowerCase = accessibilityNodeInfo.getClassName().toString().toLowerCase();
            CharSequence text = accessibilityNodeInfo.getText();
            if (lowerCase.contains("button") || lowerCase.contains("textview") || accessibilityNodeInfo.isClickable()) {
                String strTrim = text != null ? text.toString().trim() : "";
                Iterator it = listAsList.iterator();
                while (it.hasNext()) {
                    if (strTrim.equalsIgnoreCase((String) it.next()) && accessibilityNodeInfo.performAction(1) && accessibilityNodeInfo.performAction(16)) {
                        z10 = true;
                        break;
                    }
                }
            }
            if (z10) {
                break;
            }
        }
        if (z10) {
            return;
        }
        qa.b.b("USSDServiceKTB", "No matching buttons found for action: " + str);
        c(accessibilityEvent);
    }

    public static void f(AccessibilityNodeInfo accessibilityNodeInfo, List<AccessibilityNodeInfo> list) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        if (accessibilityNodeInfo.getChildCount() == 0) {
            list.add(accessibilityNodeInfo);
            return;
        }
        for (int i10 = 0; i10 < accessibilityNodeInfo.getChildCount(); i10++) {
            f(accessibilityNodeInfo.getChild(i10), list);
        }
    }

    public static List<AccessibilityNodeInfo> h(AccessibilityEvent accessibilityEvent) {
        ArrayList arrayList = new ArrayList();
        AccessibilityNodeInfo source = accessibilityEvent.getSource();
        if (source != null) {
            f(source, arrayList);
        }
        return arrayList;
    }

    public static boolean k(AccessibilityEvent accessibilityEvent) {
        Iterator<AccessibilityNodeInfo> it = h(accessibilityEvent).iterator();
        while (it.hasNext()) {
            if (it.next().getClassName().equals("android.widget.EditText")) {
                return false;
            }
        }
        return true;
    }

    public static void m(Context context, String str) {
        if (context == null) {
            qa.b.b("SharedPreferences", "Context is null. Cannot save response.");
            return;
        }
        if (str == null || str.isEmpty()) {
            qa.b.b("SharedPreferences", "Response is null or empty. Nothing to save.");
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("USSD_PREFS", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("USSD_RESPONSE", str);
        editorEdit.apply();
        sharedPreferences.getString("USSD_RESPONSE", "No Response");
    }

    public static void n(String str, AccessibilityEvent accessibilityEvent) {
        o(accessibilityEvent, str);
        d(accessibilityEvent, str);
    }

    public static void o(AccessibilityEvent accessibilityEvent, String str) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", str);
        for (AccessibilityNodeInfo accessibilityNodeInfo : h(accessibilityEvent)) {
            if (accessibilityNodeInfo.getClassName().equals("android.widget.EditText") && !accessibilityNodeInfo.performAction(2097152, bundle)) {
                ClipboardManager clipboardManager = (ClipboardManager) f6043c.getSystemService("clipboard");
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("text", str));
                }
                accessibilityNodeInfo.performAction(32768);
            }
        }
    }

    public boolean a(AccessibilityEvent accessibilityEvent) {
        return i(accessibilityEvent) && b.f6045a.i().get("KEY_LOGIN").contains(accessibilityEvent.getText().get(0).toString());
    }

    public final boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isClickable() || accessibilityNodeInfo.isFocusable() || accessibilityNodeInfo.isCheckable()) {
            return true;
        }
        for (int i10 = 0; i10 < accessibilityNodeInfo.getChildCount(); i10++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i10);
            if (child != null && e(child)) {
                return true;
            }
        }
        return false;
    }

    public final String g(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (accessibilityNodeInfo.getText() != null) {
            sb2.append(accessibilityNodeInfo.getText().toString());
            sb2.append(" ");
        }
        for (int i10 = 0; i10 < accessibilityNodeInfo.getChildCount(); i10++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i10);
            if (child != null) {
                sb2.append(g(child));
            }
        }
        return sb2.toString().trim();
    }

    public final boolean i(AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo source;
        if (accessibilityEvent != null && accessibilityEvent.getClassName() != null) {
            String string = accessibilityEvent.getClassName().toString();
            qa.b.a("USSD_DIALOG_LOGGER", "Detected Dialog: " + string);
            j("USSD_DIALOG_LOGGER", "Detected Dialog: " + string);
            this.f6044a.add(string);
            String lowerCase = string.toLowerCase();
            if ((lowerCase.contains("dialog") || lowerCase.contains("ussd") || lowerCase.contains(".e") || lowerCase.contains(".n")) && (source = accessibilityEvent.getSource()) != null) {
                if (g(source).toLowerCase().contains("running")) {
                    qa.b.a("USSD_DIALOG_LOGGER", "Skipping: Dialog contains 'running'");
                    j("USSD_DIALOG_LOGGER", "Skipping: Dialog contains 'running'");
                    return false;
                }
                if (e(source)) {
                    qa.b.a("USSD_DIALOG_LOGGER", "Dialog contains interactive elements.");
                    j("USSD_DIALOG_LOGGER", "Dialog contains interactive elements.'");
                    return true;
                }
            }
        }
        return false;
    }

    public void j(String str, String str2) {
    }

    public boolean l(AccessibilityEvent accessibilityEvent) {
        return i(accessibilityEvent) && b.f6045a.i().get("KEY_ERROR").contains(accessibilityEvent.getText().get(0).toString());
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00cd A[PHI: r6
  0x00cd: PHI (r6v4 com.phan_tech.ussd_advanced.b$a) = (r6v1 com.phan_tech.ussd_advanced.b$a), (r6v2 com.phan_tech.ussd_advanced.b$a), (r6v5 com.phan_tech.ussd_advanced.b$a) binds: [B:40:0x00ca, B:33:0x00aa, B:21:0x0086] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        String strTrim;
        b.a aVar;
        if (f6043c == null) {
            f6043c = getApplicationContext();
        }
        f6042b = accessibilityEvent;
        b bVar = b.f6045a;
        if (bVar.l().booleanValue()) {
            if (accessibilityEvent.getText().isEmpty()) {
                strTrim = null;
            } else {
                List<CharSequence> text = accessibilityEvent.getText();
                text.remove("SEND");
                text.remove("CANCEL");
                StringBuilder sb2 = new StringBuilder();
                Iterator<CharSequence> it = text.iterator();
                while (it.hasNext()) {
                    sb2.append(it.next());
                    sb2.append("\n");
                }
                strTrim = sb2.toString().trim();
                m(f6043c, strTrim);
                f6043c.getSharedPreferences("USSD_PREFS", 0).getString("USSD_RESPONSE", "No Response");
            }
            if (a(accessibilityEvent) && k(accessibilityEvent)) {
                d(accessibilityEvent, "close session");
                bVar.p();
                aVar = b.f6049e;
                if (strTrim == null) {
                    strTrim = "";
                }
            } else if (l(accessibilityEvent) || a(accessibilityEvent)) {
                d(accessibilityEvent, "close session");
                aVar = b.f6049e;
                if (strTrim == null) {
                    strTrim = "";
                }
            } else {
                if (!i(accessibilityEvent)) {
                    return;
                }
                if (!k(accessibilityEvent)) {
                    if (bVar.j().booleanValue()) {
                        bVar.g().invoke(accessibilityEvent);
                        return;
                    } else {
                        b.f6049e.b(accessibilityEvent);
                        return;
                    }
                }
                d(accessibilityEvent, "close session");
                bVar.p();
                aVar = b.f6049e;
                if (strTrim == null) {
                    strTrim = "";
                }
            }
            aVar.a(strTrim);
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onServiceConnected() {
        super.onServiceConnected();
        if (f6043c == null) {
            f6043c = getApplicationContext();
        }
    }
}
