package me.carda.awesome_notifications.core.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import ee.k;
import fe.l;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import wd.c;
import zd.d;

/* JADX INFO: loaded from: classes2.dex */
public class ForegroundService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, ForegroundService> f13326a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, b> f13327b = new HashMap();

    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13328a;

        public a(int i10) {
            this.f13328a = i10;
        }

        @Override // wd.c
        public void a(boolean z10, ae.a aVar) {
            if (z10) {
                return;
            }
            ForegroundService.f13326a.remove(Integer.valueOf(this.f13328a));
        }
    }

    public static class b implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f13330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f13331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final zd.c f13332c;

        public b(l lVar, d dVar, zd.c cVar) {
            this.f13330a = lVar;
            this.f13331b = dVar;
            this.f13332c = cVar;
        }

        public String toString() {
            return "StartParameter{notification=" + this.f13330a + ", startMode=" + this.f13331b + ", foregroundServiceType=" + this.f13332c + '}';
        }
    }

    public static void b(Context context, l lVar, d dVar, zd.c cVar) {
        b bVar = new b(lVar, dVar, cVar);
        int iIntValue = lVar.f8412l.f8380l.intValue();
        f13327b.put(Integer.valueOf(iIntValue), bVar);
        Intent intent = new Intent(context, (Class<?>) ForegroundService.class);
        intent.putExtra("me.carda.awesome_notifications.notifications.system.services.ForegroundService$StartParameter", iIntValue);
        context.startForegroundService(intent);
    }

    public static void c(Integer num) {
        StringBuilder sb2;
        String str;
        ForegroundService foregroundServiceRemove = f13326a.remove(num);
        if (foregroundServiceRemove != null) {
            foregroundServiceRemove.stopSelf();
            if (!rd.a.f15359i.booleanValue()) {
                return;
            }
            sb2 = new StringBuilder();
            sb2.append("Foreground service ");
            sb2.append(num);
            str = " id stopped";
        } else {
            if (!rd.a.f15359i.booleanValue()) {
                return;
            }
            sb2 = new StringBuilder();
            sb2.append("Foreground service ");
            sb2.append(num);
            str = " id not found";
        }
        sb2.append(str);
        de.a.a("ForegroundService", sb2.toString());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        int intExtra = intent.getIntExtra("me.carda.awesome_notifications.notifications.system.services.ForegroundService$StartParameter", -1);
        b bVarRemove = f13327b.remove(Integer.valueOf(intExtra));
        if (intExtra != -1 && bVarRemove != null) {
            int iIntValue = bVarRemove.f13330a.f8412l.f8380l.intValue();
            Map<Integer, ForegroundService> map = f13326a;
            ForegroundService foregroundServiceRemove = map.remove(Integer.valueOf(iIntValue));
            if (foregroundServiceRemove != null) {
                foregroundServiceRemove.stopSelf();
            }
            map.put(Integer.valueOf(iIntValue), this);
            try {
                ie.a.l(this, vd.b.m(), bVarRemove, k.h(), new a(iIntValue));
                return bVarRemove.f13331b.k();
            } catch (ae.a unused) {
            }
        }
        stopSelf();
        return d.notStick.k();
    }
}
