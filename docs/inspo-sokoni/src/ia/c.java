package ia;

import android.content.Context;
import android.os.Handler;
import android.telephony.TelephonyManager;
import fb.i;
import fb.j;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public class c implements xa.a, j.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f10552c = "com.vincentkammerer.ussd_service/plugin_channel";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f10553d = "makeRequest";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f10554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f10555b;

    public class a extends TelephonyManager.UssdResponseCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletableFuture f10556a;

        public a(CompletableFuture completableFuture) {
            this.f10556a = completableFuture;
        }

        @Override // android.telephony.TelephonyManager.UssdResponseCallback
        public void onReceiveUssdResponse(TelephonyManager telephonyManager, String str, CharSequence charSequence) {
            this.f10556a.complete(charSequence.toString());
        }

        @Override // android.telephony.TelephonyManager.UssdResponseCallback
        public void onReceiveUssdResponseFailed(TelephonyManager telephonyManager, String str, int i10) {
            CompletableFuture completableFuture;
            b bVar;
            if (i10 == -2) {
                completableFuture = this.f10556a;
                bVar = new b("USSD_ERROR_SERVICE_UNAVAIL");
            } else if (i10 == -1) {
                completableFuture = this.f10556a;
                bVar = new b("USSD_RETURN_FAILURE");
            } else {
                completableFuture = this.f10556a;
                bVar = new b("unknown error");
            }
            completableFuture.completeExceptionally(bVar);
        }
    }

    public static class b extends Exception {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static String f10558b = "ussd_plugin_ussd_execution_failure";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10559a;

        public b(String str) {
            this.f10559a = str;
        }
    }

    /* JADX INFO: renamed from: ia.c$c, reason: collision with other inner class name */
    public static class C0176c extends Exception {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static String f10560b = "ussd_plugin_incorrect__parameters";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10561a;

        public C0176c(String str) {
            this.f10561a = str;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10563b;

        public d(i iVar) throws C0176c {
            Integer num = (Integer) iVar.a("subscriptionId");
            if (num == null) {
                throw new C0176c("Incorrect parameter type: `subscriptionId` must be an int");
            }
            int iIntValue = num.intValue();
            this.f10562a = iIntValue;
            if (iIntValue < 0) {
                throw new C0176c("Incorrect parameter value: `subscriptionId` must be >= 0");
            }
            String str = (String) iVar.a("code");
            this.f10563b = str;
            if (str == null) {
                throw new C0176c("Incorrect parameter type: `code` must be a String");
            }
            if (str.length() == 0) {
                throw new C0176c("Incorrect parameter value: `code` must not be an empty string");
            }
        }
    }

    public static /* synthetic */ String c(j.d dVar, Throwable th) {
        String str;
        String message;
        if (th instanceof b) {
            str = b.f10558b;
            message = ((b) th).f10559a;
        } else {
            str = b.f10558b;
            message = th.getMessage();
        }
        dVar.b(str, message, null);
        return null;
    }

    public final void b(Context context, fb.b bVar) {
        this.f10554a = context;
        j jVar = new j(bVar, f10552c);
        this.f10555b = jVar;
        jVar.e(this);
    }

    public final CompletableFuture<String> d(d dVar) throws b {
        if (f0.a.checkSelfPermission(this.f10554a, "android.permission.CALL_PHONE") != 0) {
            throw new b("CALL_PHONE permission missing");
        }
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        ((TelephonyManager) this.f10554a.getSystemService("phone")).createForSubscriptionId(dVar.f10562a).sendUssdRequest(dVar.f10563b, new a(completableFuture), new Handler());
        return completableFuture;
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        b(bVar.a(), bVar.b());
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        this.f10555b.e(null);
        this.f10555b = null;
        this.f10554a = null;
    }

    @Override // fb.j.c
    public void onMethodCall(i iVar, final j.d dVar) {
        String str;
        String message;
        if (!iVar.f8284a.equals(f10553d)) {
            dVar.c();
            return;
        }
        try {
            CompletableFuture<String> completableFutureExceptionally = d(new d(iVar)).exceptionally(new Function() { // from class: ia.a
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return c.c(dVar, (Throwable) obj);
                }
            });
            Objects.requireNonNull(dVar);
            completableFutureExceptionally.thenAccept(new Consumer() { // from class: ia.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    dVar.a((String) obj);
                }
            });
        } catch (b e10) {
            str = C0176c.f10560b;
            message = e10.f10559a;
            dVar.b(str, message, null);
        } catch (C0176c e11) {
            str = C0176c.f10560b;
            message = e11.f10561a;
            dVar.b(str, message, null);
        } catch (Exception e12) {
            str = "unknown_exception";
            message = e12.getMessage();
            dVar.b(str, message, null);
        }
    }
}
