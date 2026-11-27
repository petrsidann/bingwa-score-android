package ca;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.telephony.CellSignalStrength;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import mc.p;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3454a;

    public h(Context context) {
        k.e(context, "context");
        this.f3454a = context;
    }

    public final void a(String phoneNumber) {
        k.e(phoneNumber, "phoneNumber");
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:" + phoneNumber));
        intent.setFlags(268435456);
        if (intent.resolveActivity(this.f3454a.getPackageManager()) != null) {
            this.f3454a.getApplicationContext().startActivity(intent);
        }
    }

    public final int b() {
        TelephonyManager telephonyManagerR = r();
        return Build.VERSION.SDK_INT >= 31 ? telephonyManagerR.getCallStateForSubscription() : telephonyManagerR.getCallState();
    }

    public final int c() {
        return r().getDataState();
    }

    public final int d() {
        return r().getDataActivity();
    }

    public final int e() {
        TelephonyManager telephonyManagerR = r();
        return Build.VERSION.SDK_INT > 29 ? telephonyManagerR.getDataNetworkType() : telephonyManagerR.getNetworkType();
    }

    public final List<HashMap<String, String>> f(da.c contentUri, List<String> projection, String str, List<String> list, String str2) {
        k.e(contentUri, "contentUri");
        k.e(projection, "projection");
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = this.f3454a.getContentResolver().query(contentUri.h(), (String[]) projection.toArray(new String[0]), str, list != null ? (String[]) list.toArray(new String[0]) : null, str2);
        while (cursorQuery != null && cursorQuery.moveToNext()) {
            HashMap map = new HashMap(projection.size());
            Iterator itA = kotlin.jvm.internal.b.a(cursorQuery.getColumnNames());
            while (itA.hasNext()) {
                String str3 = (String) itA.next();
                int columnIndex = cursorQuery.getColumnIndex(str3);
                if (columnIndex >= 0) {
                    map.put(str3, cursorQuery.getString(columnIndex));
                }
            }
            arrayList.add(map);
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    public final lc.i<ArrayList<PendingIntent>, ArrayList<PendingIntent>> g(int i10) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i11 = 1;
        if (1 <= i10) {
            while (true) {
                lc.i<PendingIntent, PendingIntent> iVarJ = j();
                arrayList.add(iVarJ.c());
                arrayList2.add(iVarJ.d());
                if (i11 == i10) {
                    break;
                }
                i11++;
            }
        }
        return new lc.i<>(arrayList, arrayList2);
    }

    public final String h() {
        String networkOperator = r().getNetworkOperator();
        k.d(networkOperator, "getNetworkOperator(...)");
        return networkOperator;
    }

    public final String i() {
        String networkOperatorName = r().getNetworkOperatorName();
        k.d(networkOperatorName, "getNetworkOperatorName(...)");
        return networkOperatorName;
    }

    public final lc.i<PendingIntent, PendingIntent> j() {
        Intent intent = new Intent("plugins.shounakmulay.intent.ACTION_SMS_SENT");
        intent.setPackage(this.f3454a.getApplicationContext().getPackageName());
        intent.setFlags(1073741824);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f3454a, 21, intent, 1140850688);
        Intent intent2 = new Intent("plugins.shounakmulay.intent.ACTION_SMS_DELIVERED");
        intent2.setPackage(this.f3454a.getApplicationContext().getPackageName());
        intent2.setFlags(1073741824);
        return new lc.i<>(broadcast, PendingIntent.getBroadcast(this.f3454a, 22, intent2, 1140850688));
    }

    public final int k() {
        return r().getPhoneType();
    }

    public final Integer l() {
        ServiceState serviceState = r().getServiceState();
        if (serviceState != null) {
            return Integer.valueOf(serviceState.getState());
        }
        return null;
    }

    public final List<Integer> m() {
        List cellSignalStrengths;
        SignalStrength signalStrength = r().getSignalStrength();
        if (signalStrength == null || (cellSignalStrengths = signalStrength.getCellSignalStrengths()) == null) {
            return null;
        }
        List list = cellSignalStrengths;
        ArrayList arrayList = new ArrayList(p.m(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((CellSignalStrength) it.next()).getLevel()));
        }
        return arrayList;
    }

    public final String n() {
        String simOperator = r().getSimOperator();
        k.d(simOperator, "getSimOperator(...)");
        return simOperator;
    }

    public final String o() {
        String simOperatorName = r().getSimOperatorName();
        k.d(simOperatorName, "getSimOperatorName(...)");
        return simOperatorName;
    }

    public final int p() {
        return r().getSimState();
    }

    public final SmsManager q() {
        int defaultSmsSubscriptionId = SmsManager.getDefaultSmsSubscriptionId();
        SmsManager smsManager = (SmsManager) f0.a.getSystemService(this.f3454a, SmsManager.class);
        if (smsManager == null) {
            throw new RuntimeException("Flutter Telephony: Error getting SmsManager");
        }
        if (defaultSmsSubscriptionId == -1) {
            return smsManager;
        }
        SmsManager smsManagerCreateForSubscriptionId = Build.VERSION.SDK_INT >= 31 ? smsManager.createForSubscriptionId(defaultSmsSubscriptionId) : SmsManager.getSmsManagerForSubscriptionId(defaultSmsSubscriptionId);
        k.b(smsManagerCreateForSubscriptionId);
        return smsManagerCreateForSubscriptionId;
    }

    public final TelephonyManager r() {
        int defaultSmsSubscriptionId = SmsManager.getDefaultSmsSubscriptionId();
        Object systemService = this.f3454a.getSystemService("phone");
        k.c(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager telephonyManagerCreateForSubscriptionId = ((TelephonyManager) systemService).createForSubscriptionId(defaultSmsSubscriptionId);
        k.b(telephonyManagerCreateForSubscriptionId);
        return telephonyManagerCreateForSubscriptionId;
    }

    public final boolean s() {
        return r().isNetworkRoaming();
    }

    public final boolean t() {
        return r().isSmsCapable();
    }

    public final void u(String phoneNumber) {
        k.e(phoneNumber, "phoneNumber");
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + phoneNumber));
        intent.setFlags(268435456);
        this.f3454a.startActivity(intent);
    }

    public final void v(String destinationAddress, String messageBody, boolean z10) {
        String str;
        ArrayList<PendingIntent> arrayListC;
        ArrayList<PendingIntent> arrayListD;
        k.e(destinationAddress, "destinationAddress");
        k.e(messageBody, "messageBody");
        SmsManager smsManagerQ = q();
        ArrayList<String> arrayListDivideMessage = smsManagerQ.divideMessage(messageBody);
        if (z10) {
            lc.i<ArrayList<PendingIntent>, ArrayList<PendingIntent>> iVarG = g(arrayListDivideMessage.size());
            str = null;
            arrayListC = iVarG.c();
            arrayListD = iVarG.d();
        } else {
            str = null;
            arrayListC = null;
            arrayListD = null;
        }
        smsManagerQ.sendMultipartTextMessage(destinationAddress, str, arrayListDivideMessage, arrayListC, arrayListD);
    }

    public final void w(String destinationAddress, String messageBody, boolean z10) {
        String str;
        PendingIntent pendingIntentC;
        PendingIntent pendingIntentD;
        k.e(destinationAddress, "destinationAddress");
        k.e(messageBody, "messageBody");
        SmsManager smsManagerQ = q();
        if (z10) {
            lc.i<PendingIntent, PendingIntent> iVarJ = j();
            str = null;
            pendingIntentC = iVarJ.c();
            pendingIntentD = iVarJ.d();
        } else {
            str = null;
            pendingIntentC = null;
            pendingIntentD = null;
        }
        smsManagerQ.sendTextMessage(destinationAddress, str, messageBody, pendingIntentC, pendingIntentD);
    }

    public final void x(String destinationAddress, String messageBody) {
        k.e(destinationAddress, "destinationAddress");
        k.e(messageBody, "messageBody");
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("smsto:" + destinationAddress));
        intent.putExtra("sms_body", messageBody);
        intent.setFlags(268435456);
        this.f3454a.getApplicationContext().startActivity(intent);
    }
}
