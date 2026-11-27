package z3;

import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f4.a f19782c = new f4.a("RevokeAccessOperation", new String[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.common.api.internal.u f19784b = new com.google.android.gms.common.api.internal.u(null);

    public f(String str) {
        this.f19783a = com.google.android.gms.common.internal.r.f(str);
    }

    public static com.google.android.gms.common.api.g a(String str) {
        if (str == null) {
            return com.google.android.gms.common.api.h.a(new Status(4), null);
        }
        f fVar = new f(str);
        new Thread(fVar).start();
        return fVar.f19784b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Status status = Status.f3657m;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/revoke?token=" + this.f19783a).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.f3655f;
            } else {
                f19782c.c("Unable to revoke access!", new Object[0]);
            }
            f19782c.a("Response Code: " + responseCode, new Object[0]);
        } catch (IOException e10) {
            f19782c.c("IOException when revoking access: ".concat(String.valueOf(e10.toString())), new Object[0]);
        } catch (Exception e11) {
            f19782c.c("Exception when revoking access: ".concat(String.valueOf(e11.toString())), new Object[0]);
        }
        this.f19784b.setResult(status);
    }
}
