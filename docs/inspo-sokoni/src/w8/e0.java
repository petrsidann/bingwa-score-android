package w8;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h7.f f17717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0 f17718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b4.c f17719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o8.b<z8.i> f17720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o8.b<m8.j> f17721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p8.h f17722f;

    public e0(h7.f fVar, i0 i0Var, b4.c cVar, o8.b<z8.i> bVar, o8.b<m8.j> bVar2, p8.h hVar) {
        this.f17717a = fVar;
        this.f17718b = i0Var;
        this.f17719c = cVar;
        this.f17720d = bVar;
        this.f17721e = bVar2;
        this.f17722f = hVar;
    }

    public e0(h7.f fVar, i0 i0Var, o8.b<z8.i> bVar, o8.b<m8.j> bVar2, p8.h hVar) {
        this(fVar, i0Var, new b4.c(fVar.m()), bVar, bVar2, hVar);
    }

    public static String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public static boolean i(String str) {
        return "SERVICE_NOT_AVAILABLE".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "InternalServerError".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String j(Task task) {
        return h((Bundle) task.getResult(IOException.class));
    }

    public Task<?> c() {
        Bundle bundle = new Bundle();
        bundle.putString("delete", "1");
        return d(m(i0.c(this.f17717a), "*", bundle));
    }

    public final Task<String> d(Task<Bundle> task) {
        return task.continueWith(new x1.b(), new Continuation() { // from class: w8.d0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return this.f17711a.j(task2);
            }
        });
    }

    public final String e() {
        try {
            return b(MessageDigest.getInstance("SHA-1").digest(this.f17717a.q().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    public Task<b4.a> f() {
        return this.f17719c.a();
    }

    public Task<String> g() {
        return d(m(i0.c(this.f17717a), "*", new Bundle()));
    }

    public final String h(Bundle bundle) throws IOException {
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("unregistered");
        if (string2 != null) {
            return string2;
        }
        String string3 = bundle.getString("error");
        if ("RST".equals(string3)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string3 != null) {
            throw new IOException(string3);
        }
        Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    public final void k(String str, String str2, Bundle bundle) {
        m8.j.a aVarB;
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        bundle.putString("gmp_app_id", this.f17717a.r().c());
        bundle.putString("gmsv", Integer.toString(this.f17718b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f17718b.a());
        bundle.putString("app_ver_name", this.f17718b.b());
        bundle.putString("firebase-app-name-hash", e());
        try {
            String strB = ((p8.m) Tasks.await(this.f17722f.a(false))).b();
            if (TextUtils.isEmpty(strB)) {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", strB);
            }
        } catch (InterruptedException | ExecutionException e10) {
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e10);
        }
        bundle.putString("appid", (String) Tasks.await(this.f17722f.getId()));
        bundle.putString("cliv", "fcm-24.1.0");
        m8.j jVar = this.f17721e.get();
        z8.i iVar = this.f17720d.get();
        if (jVar == null || iVar == null || (aVarB = jVar.b("fire-iid")) == m8.j.a.NONE) {
            return;
        }
        bundle.putString("Firebase-Client-Log-Type", Integer.toString(aVarB.h()));
        bundle.putString("Firebase-Client", iVar.a());
    }

    public Task<Void> l(boolean z10) {
        return this.f17719c.d(z10);
    }

    public final Task<Bundle> m(String str, String str2, Bundle bundle) {
        try {
            k(str, str2, bundle);
            return this.f17719c.c(bundle);
        } catch (InterruptedException | ExecutionException e10) {
            return Tasks.forException(e10);
        }
    }

    public Task<?> n(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        return d(m(str, "/topics/" + str2, bundle));
    }

    public Task<?> o(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str2);
        bundle.putString("delete", "1");
        return d(m(str, "/topics/" + str2, bundle));
    }
}
