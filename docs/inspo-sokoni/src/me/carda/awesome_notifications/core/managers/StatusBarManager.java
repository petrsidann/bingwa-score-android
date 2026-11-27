package me.carda.awesome_notifications.core.managers;

import ae.b;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import e0.o0;
import e9.e;
import fe.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import je.o;
import xd.f;
import zd.j;

/* JADX INFO: loaded from: classes2.dex */
public class StatusBarManager extends NotificationListenerService {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static StatusBarManager f13320e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f13321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f13322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, List<String>> f13323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, List<String>> f13324d;

    public class a extends l9.a<HashMap<String, List<String>>> {
        public a() {
        }
    }

    public StatusBarManager() {
        o oVarC = o.c();
        this.f13321a = oVarC;
        this.f13322b = getSharedPreferences(rd.a.K(this) + "." + oVarC.a("CancellationManager"), 0);
        this.f13323c = q("group");
        this.f13324d = q("channel");
    }

    public StatusBarManager(Context context, o oVar) {
        this.f13321a = oVar;
        this.f13322b = context.getSharedPreferences(rd.a.K(context) + "." + oVar.a("CancellationManager"), 0);
        this.f13323c = q("group");
        this.f13324d = q("channel");
    }

    public static StatusBarManager k(Context context) {
        if (f13320e == null) {
            f13320e = new StatusBarManager(context, o.c());
        }
        return f13320e;
    }

    public final void A(SharedPreferences.Editor editor, String str, boolean z10) {
        editor.putBoolean("cl:" + str, z10);
    }

    public void B(Context context, l lVar, Notification notification) throws ae.a {
        r(lVar, lVar.f8412l.f8380l.intValue());
        m(context).notify(lVar.f8412l.f8380l.intValue(), notification);
    }

    public final List<String> C(String str) {
        List<String> listRemove;
        List<String> list;
        if (this.f13321a.e(str).booleanValue() || (listRemove = this.f13324d.remove(str)) == null) {
            return null;
        }
        SharedPreferences.Editor editorEdit = this.f13322b.edit();
        boolean z10 = false;
        for (String str2 : listRemove) {
            String strJ = j(str2);
            if (!strJ.equals("") && (list = this.f13323c.get(strJ)) != null) {
                list.remove(str2);
                if (list.isEmpty()) {
                    this.f13323c.remove(strJ);
                } else {
                    this.f13323c.put(str, list);
                }
                z10 = true;
            }
            t(editorEdit, str2);
        }
        F(editorEdit, "channel", this.f13324d);
        if (z10) {
            F(editorEdit, "group", this.f13323c);
        }
        editorEdit.apply();
        return listRemove;
    }

    public List<String> D(String str) {
        List<String> listRemove;
        List<String> list;
        if (this.f13321a.e(str).booleanValue() || (listRemove = this.f13323c.remove(str)) == null) {
            return null;
        }
        SharedPreferences.Editor editorEdit = this.f13322b.edit();
        boolean z10 = false;
        for (String str2 : listRemove) {
            String strI = i(str2);
            if (!strI.equals("") && (list = this.f13324d.get(strI)) != null) {
                list.remove(str2);
                if (list.isEmpty()) {
                    this.f13324d.remove(strI);
                } else {
                    this.f13324d.put(strI, list);
                }
                z10 = true;
            }
            t(editorEdit, str2);
        }
        F(editorEdit, "group", this.f13323c);
        if (z10) {
            F(editorEdit, "channel", this.f13324d);
        }
        editorEdit.apply();
        return listRemove;
    }

    public void E(Context context, int i10) throws ae.a {
        List<String> list;
        List<String> list2;
        SharedPreferences.Editor editorEdit = this.f13322b.edit();
        String strValueOf = String.valueOf(i10);
        String strJ = j(strValueOf);
        if (!strJ.equals("") && (list2 = this.f13323c.get(strJ)) != null && list2.remove(strValueOf)) {
            if (list2.isEmpty()) {
                this.f13323c.remove(strJ);
            } else {
                this.f13323c.put(strJ, list2);
            }
            F(editorEdit, "group", this.f13323c);
            if (!o(strJ) && list2.size() == 1) {
                d(context, Integer.valueOf(Integer.parseInt(list2.get(0))));
            }
        }
        String strI = i(strValueOf);
        if (!strI.equals("") && (list = this.f13324d.get(strI)) != null) {
            list.remove(strValueOf);
            if (list.isEmpty()) {
                this.f13324d.remove(strI);
            } else {
                this.f13324d.put(strI, list);
            }
            F(editorEdit, "channel", this.f13324d);
        }
        t(editorEdit, strValueOf);
        editorEdit.apply();
    }

    public final void F(SharedPreferences.Editor editor, String str, Map<String, List<String>> map) {
        editor.putString(str, new e().r(map));
    }

    public final List<Integer> a() {
        StatusBarNotification[] activeNotifications = ((NotificationManager) getSystemService("notification")).getActiveNotifications();
        ArrayList arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            arrayList.add(Integer.valueOf(statusBarNotification.getId()));
        }
        return arrayList;
    }

    public void b(Context context) {
        if (Build.VERSION.SDK_INT < 31) {
            context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }
    }

    public void c(Context context) {
        g(context).d();
        x();
    }

    public void d(Context context, Integer num) throws ae.a {
        String string = num.toString();
        int i10 = Integer.parseInt(string);
        NotificationManager notificationManagerM = m(context);
        notificationManagerM.cancel(string, i10);
        notificationManagerM.cancel(i10);
        String strJ = j(string);
        if (!strJ.equals("")) {
            try {
                f(context, strJ);
            } catch (ae.a unused) {
            }
        }
        E(context, num.intValue());
    }

    public boolean e(Context context, String str) throws ae.a {
        List<String> listC = C(str);
        if (listC != null) {
            Iterator<String> it = listC.iterator();
            while (it.hasNext()) {
                d(context, Integer.valueOf(Integer.parseInt(it.next())));
            }
        }
        return listC != null;
    }

    public boolean f(Context context, String str) throws ae.a {
        List<String> listD = D(str);
        if (listD != null) {
            Iterator<String> it = listD.iterator();
            while (it.hasNext()) {
                d(context, Integer.valueOf(Integer.parseInt(it.next())));
            }
        }
        return listD != null;
    }

    public final o0 g(Context context) throws ae.a {
        try {
            return o0.e(context);
        } catch (Exception e10) {
            throw b.e().d("CancellationManager", "MISSING_ARGUMENTS", "Notification Manager is not available", "arguments.required.notificationManager", e10);
        }
    }

    public Collection<Integer> h() {
        List<Integer> listA = a();
        return listA != null ? listA : f.C(this).v(this, "activeNotificationIds").values();
    }

    public final String i(String str) {
        return this.f13322b.getString("ic:" + str, "");
    }

    public final String j(String str) {
        return this.f13322b.getString("ig:" + str, "");
    }

    public final boolean l(int i10) {
        for (StatusBarNotification statusBarNotification : ((NotificationManager) getSystemService("notification")).getActiveNotifications()) {
            if (statusBarNotification.getId() == i10) {
                return true;
            }
        }
        return false;
    }

    public final NotificationManager m(Context context) throws ae.a {
        try {
            return (NotificationManager) context.getSystemService("notification");
        } catch (Exception e10) {
            throw b.e().d("CancellationManager", "MISSING_ARGUMENTS", "Notification Service is not available", "arguments.required.notificationService", e10);
        }
    }

    public boolean n(String str) {
        if (this.f13321a.e(str).booleanValue()) {
            return false;
        }
        List<String> list = this.f13323c.get(str);
        return list == null || list.size() == 0;
    }

    public final boolean o(String str) {
        return this.f13322b.getBoolean("cl:" + str, false);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        f fVarC = f.C(this);
        int i10 = statusBarNotification.getNotification().extras.getInt("id");
        fVarC.g0(this, "activeNotificationIds", Integer.toString(i10), i10);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        f.C(this).d0(this, "activeNotificationIds", Integer.toString(statusBarNotification.getNotification().extras.getInt("id")));
    }

    public boolean p(int i10) {
        return l(i10);
    }

    public final Map<String, List<String>> q(String str) {
        String string = this.f13322b.getString(str, null);
        return string == null ? new HashMap() : (Map) new e().h(string, new a().d());
    }

    public final void r(l lVar, int i10) throws ae.a {
        String strValueOf = String.valueOf(i10);
        String str = !this.f13321a.e(lVar.f8412l.f8388t).booleanValue() ? lVar.f8412l.f8388t : "";
        String str2 = !this.f13321a.e(lVar.f8412l.f8381m).booleanValue() ? lVar.f8412l.f8381m : "";
        SharedPreferences.Editor editorEdit = this.f13322b.edit();
        if (!str2.equals("")) {
            s(editorEdit, "channel", this.f13324d, str2, strValueOf);
            y(editorEdit, strValueOf, str2);
        }
        if (!str.equals("")) {
            s(editorEdit, "group", this.f13323c, str, strValueOf);
            z(editorEdit, strValueOf, str);
        }
        A(editorEdit, strValueOf, lVar.f8412l.V != j.Default);
        editorEdit.apply();
    }

    public final void s(SharedPreferences.Editor editor, String str, Map<String, List<String>> map, String str2, String str3) {
        List<String> arrayList = map.get(str2);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (!arrayList.contains(str3)) {
            arrayList.add(str3);
        }
        map.put(str2, arrayList);
        F(editor, str, map);
    }

    public final void t(SharedPreferences.Editor editor, String str) {
        u(editor, str);
        v(editor, str);
        w(editor, str);
    }

    public final void u(SharedPreferences.Editor editor, String str) {
        editor.remove("ic:" + str);
    }

    public final void v(SharedPreferences.Editor editor, String str) {
        editor.remove("ig:" + str);
    }

    public final void w(SharedPreferences.Editor editor, String str) {
        editor.remove("cl:" + str);
    }

    public final void x() {
        this.f13322b.edit().clear().apply();
        this.f13323c.clear();
        this.f13324d.clear();
    }

    public final void y(SharedPreferences.Editor editor, String str, String str2) throws ae.a {
        try {
            editor.putString("ic:" + str, str2);
        } catch (Exception e10) {
            throw b.e().d("CancellationManager", "MISSING_ARGUMENTS", "Shared preferences is not available", "arguments.required.sharedPreferences", e10);
        }
    }

    public final void z(SharedPreferences.Editor editor, String str, String str2) {
        editor.putString("ig:" + str, str2);
    }
}
