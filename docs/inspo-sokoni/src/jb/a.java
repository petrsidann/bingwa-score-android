package jb;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConnectivityManager f11330a;

    public a(ConnectivityManager connectivityManager) {
        this.f11330a = connectivityManager;
    }

    public ConnectivityManager a() {
        return this.f11330a;
    }

    public String b() {
        NetworkCapabilities networkCapabilities = this.f11330a.getNetworkCapabilities(this.f11330a.getActiveNetwork());
        if (networkCapabilities == null) {
            return "none";
        }
        if (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(3)) {
            return "wifi";
        }
        return networkCapabilities.hasTransport(0) ? "mobile" : c();
    }

    public final String c() {
        NetworkInfo activeNetworkInfo = this.f11330a.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "none";
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            return "mobile";
        }
        if (type == 1) {
            return "wifi";
        }
        if (type == 4 || type == 5) {
            return "mobile";
        }
        return (type == 6 || type == 9) ? "wifi" : "none";
    }
}
