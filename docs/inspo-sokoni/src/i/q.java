package i;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static q f10073d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LocationManager f10075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f10076c = new a();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f10077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f10078b;
    }

    public q(Context context, LocationManager locationManager) {
        this.f10074a = context;
        this.f10075b = locationManager;
    }

    public static q a(Context context) {
        if (f10073d == null) {
            Context applicationContext = context.getApplicationContext();
            f10073d = new q(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f10073d;
    }

    public final Location b() {
        Location locationC = f0.h.b(this.f10074a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location locationC2 = f0.h.b(this.f10074a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        if (locationC2 == null || locationC == null) {
            return locationC2 != null ? locationC2 : locationC;
        }
        return locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    public final Location c(String str) {
        try {
            if (this.f10075b.isProviderEnabled(str)) {
                return this.f10075b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e10) {
            Log.d("TwilightManager", "Failed to get last known location", e10);
            return null;
        }
    }

    public boolean d() {
        a aVar = this.f10076c;
        if (e()) {
            return aVar.f10077a;
        }
        Location locationB = b();
        if (locationB != null) {
            f(locationB);
            return aVar.f10077a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i10 = Calendar.getInstance().get(11);
        return i10 < 6 || i10 >= 22;
    }

    public final boolean e() {
        return this.f10076c.f10078b > System.currentTimeMillis();
    }

    public final void f(Location location) {
        long j10;
        long j11;
        a aVar = this.f10076c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        p pVarB = p.b();
        pVarB.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        pVarB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z10 = pVarB.f10072c == 1;
        long j12 = pVarB.f10071b;
        long j13 = pVarB.f10070a;
        pVarB.a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j14 = pVarB.f10071b;
        if (j12 == -1 || j13 == -1) {
            j10 = 43200000 + jCurrentTimeMillis;
        } else {
            if (jCurrentTimeMillis > j13) {
                j11 = j14 + 0;
            } else {
                j11 = jCurrentTimeMillis > j12 ? j13 + 0 : j12 + 0;
            }
            j10 = j11 + 60000;
        }
        aVar.f10077a = z10;
        aVar.f10078b = j10;
    }
}
