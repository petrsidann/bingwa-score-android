package ha;

import android.app.Activity;
import android.content.Context;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import fb.b;
import fb.i;
import fb.j;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ya.c;

/* JADX INFO: loaded from: classes.dex */
public class a implements xa.a, j.c, ya.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f9928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f9929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f9930c;

    public final boolean a() {
        return f0.a.checkSelfPermission(this.f9928a, "android.permission.READ_PHONE_STATE") == 0;
    }

    public final JSONObject b() throws JSONException {
        SubscriptionManager subscriptionManager = (SubscriptionManager) this.f9928a.getSystemService("telephony_subscription_service");
        List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();
        JSONArray jSONArray = new JSONArray();
        for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
            int simSlotIndex = subscriptionInfo.getSimSlotIndex();
            CharSequence carrierName = subscriptionInfo.getCarrierName();
            String countryIso = subscriptionInfo.getCountryIso();
            int dataRoaming = subscriptionInfo.getDataRoaming();
            CharSequence displayName = subscriptionInfo.getDisplayName();
            String iccId = subscriptionInfo.getIccId();
            int mcc = subscriptionInfo.getMcc();
            int mnc = subscriptionInfo.getMnc();
            boolean zIsNetworkRoaming = subscriptionManager.isNetworkRoaming(simSlotIndex);
            String number = subscriptionInfo.getNumber();
            int subscriptionId = subscriptionInfo.getSubscriptionId();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("carrierName", carrierName.toString());
            jSONObject.put("countryCode", countryIso);
            jSONObject.put("displayName", displayName.toString());
            boolean z10 = true;
            if (dataRoaming != 1) {
                z10 = false;
            }
            jSONObject.put("isDataRoaming", z10);
            jSONObject.put("isNetworkRoaming", zIsNetworkRoaming);
            jSONObject.put("mcc", mcc);
            jSONObject.put("mnc", mnc);
            jSONObject.put("phoneNumber", number);
            jSONObject.put("serialNumber", iccId);
            jSONObject.put("slotIndex", simSlotIndex);
            jSONObject.put("subscriptionId", subscriptionId);
            jSONArray.put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("cards", jSONArray);
        return jSONObject2;
    }

    public final void c(b bVar, Context context) {
        this.f9928a = context;
        j jVar = new j(bVar, "com.vincentkammerer.sim_data/channel_name");
        this.f9930c = jVar;
        jVar.e(this);
    }

    public final void d() {
        e0.b.e(this.f9929b, new String[]{"android.permission.READ_PHONE_STATE"}, 0);
    }

    @Override // ya.a
    public void onAttachedToActivity(c cVar) {
        this.f9929b = cVar.g();
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        c(bVar.b(), bVar.a());
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
        this.f9929b = null;
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        this.f9929b = null;
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        this.f9930c.e(null);
        this.f9930c = null;
        this.f9928a = null;
    }

    @Override // fb.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        if (!a()) {
            d();
        }
        try {
            dVar.a(b().toString());
        } catch (Exception e10) {
            dVar.b("SimData_error", e10.getMessage(), e10.getStackTrace());
        }
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(c cVar) {
        this.f9929b = cVar.g();
    }
}
