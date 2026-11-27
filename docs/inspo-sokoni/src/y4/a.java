package y4;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.stats.zzb;
import com.google.android.gms.internal.stats.zzh;
import com.google.android.gms.internal.stats.zzi;
import j4.g;
import j4.q;
import j4.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f19354r = TimeUnit.DAYS.toMillis(366);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile ScheduledExecutorService f19355s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Object f19356t = new Object();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile e f19357u = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f19358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f19359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Future<?> f19361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f19362e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<f> f19363f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f19364g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19365h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public zzb f19366i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j4.d f19367j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WorkSource f19368k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f19369l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f19370m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f19371n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, d> f19372o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AtomicInteger f19373p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ScheduledExecutorService f19374q;

    public a(Context context, int i10, String str) {
        String packageName = context.getPackageName();
        this.f19358a = new Object();
        this.f19360c = 0;
        this.f19363f = new HashSet();
        this.f19364g = true;
        this.f19367j = g.d();
        this.f19372o = new HashMap();
        this.f19373p = new AtomicInteger(0);
        r.m(context, "WakeLock: context must not be null");
        r.g(str, "WakeLock: wakeLockName must not be empty");
        this.f19371n = context.getApplicationContext();
        this.f19370m = str;
        this.f19366i = null;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f19369l = str;
        } else {
            String strValueOf = String.valueOf(str);
            this.f19369l = strValueOf.length() != 0 ? "*gcore*:".concat(strValueOf) : new String("*gcore*:");
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            StringBuilder sb2 = new StringBuilder(29);
            sb2.append((CharSequence) "expected a non-null reference", 0, 29);
            throw new zzi(sb2.toString());
        }
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(i10, str);
        this.f19359b = wakeLockNewWakeLock;
        if (s.c(context)) {
            WorkSource workSourceB = s.b(context, q.b(packageName) ? context.getPackageName() : packageName);
            this.f19368k = workSourceB;
            if (workSourceB != null) {
                i(wakeLockNewWakeLock, workSourceB);
            }
        }
        ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = f19355s;
        if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
            synchronized (f19356t) {
                scheduledExecutorServiceUnconfigurableScheduledExecutorService = f19355s;
                if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
                    zzh.zza();
                    scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                    f19355s = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
                }
            }
        }
        this.f19374q = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
    }

    public static /* synthetic */ void e(a aVar) {
        synchronized (aVar.f19358a) {
            if (aVar.b()) {
                Log.e("WakeLock", String.valueOf(aVar.f19369l).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                aVar.g();
                if (aVar.b()) {
                    aVar.f19360c = 1;
                    aVar.h(0);
                }
            }
        }
    }

    public static void i(PowerManager.WakeLock wakeLock, WorkSource workSource) {
        try {
            wakeLock.setWorkSource(workSource);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e10) {
            Log.wtf("WakeLock", e10.toString());
        }
    }

    public void a(long j10) {
        this.f19373p.incrementAndGet();
        long jMax = Math.max(Math.min(Long.MAX_VALUE, f19354r), 1L);
        if (j10 > 0) {
            jMax = Math.min(j10, jMax);
        }
        synchronized (this.f19358a) {
            if (!b()) {
                this.f19366i = zzb.zza(false, null);
                this.f19359b.acquire();
                this.f19367j.b();
            }
            this.f19360c++;
            this.f19365h++;
            f(null);
            d dVar = this.f19372o.get(null);
            if (dVar == null) {
                dVar = new d(null);
                this.f19372o.put(null, dVar);
            }
            dVar.f19376a++;
            long jB = this.f19367j.b();
            long j11 = Long.MAX_VALUE - jB > jMax ? jB + jMax : Long.MAX_VALUE;
            if (j11 > this.f19362e) {
                this.f19362e = j11;
                Future<?> future = this.f19361d;
                if (future != null) {
                    future.cancel(false);
                }
                this.f19361d = this.f19374q.schedule(new Runnable() { // from class: y4.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.e(this.f19375a);
                    }
                }, jMax, TimeUnit.MILLISECONDS);
            }
        }
    }

    public boolean b() {
        boolean z10;
        synchronized (this.f19358a) {
            z10 = this.f19360c > 0;
        }
        return z10;
    }

    public void c() {
        if (this.f19373p.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f19369l).concat(" release without a matched acquire!"));
        }
        synchronized (this.f19358a) {
            f(null);
            if (this.f19372o.containsKey(null)) {
                d dVar = this.f19372o.get(null);
                if (dVar != null) {
                    int i10 = dVar.f19376a - 1;
                    dVar.f19376a = i10;
                    if (i10 == 0) {
                        this.f19372o.remove(null);
                    }
                }
            } else {
                Log.w("WakeLock", String.valueOf(this.f19369l).concat(" counter does not exist"));
            }
            h(0);
        }
    }

    public void d(boolean z10) {
        synchronized (this.f19358a) {
            this.f19364g = z10;
        }
    }

    public final String f(String str) {
        if (this.f19364g) {
            TextUtils.isEmpty(null);
        }
        return null;
    }

    public final void g() {
        if (this.f19363f.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f19363f);
        this.f19363f.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x005f A[Catch: all -> 0x00a2, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x000b, B:10:0x0010, B:16:0x001d, B:17:0x002a, B:19:0x0030, B:20:0x0039, B:22:0x0043, B:23:0x004c, B:26:0x005b, B:28:0x005f, B:45:0x00a0, B:44:0x008f, B:40:0x0088, B:42:0x008c, B:43:0x008e, B:36:0x0082, B:13:0x0019, B:15:0x001b, B:25:0x0056, B:33:0x0065, B:35:0x0071, B:39:0x0087), top: B:51:0x0003, inners: #0 }] */
    public final void h(int i10) {
        synchronized (this.f19358a) {
            if (b()) {
                if (this.f19364g) {
                    int i11 = this.f19360c - 1;
                    this.f19360c = i11;
                    if (i11 > 0) {
                        return;
                    }
                } else {
                    this.f19360c = 0;
                }
                g();
                Iterator<d> it = this.f19372o.values().iterator();
                while (it.hasNext()) {
                    it.next().f19376a = 0;
                }
                this.f19372o.clear();
                Future<?> future = this.f19361d;
                if (future != null) {
                    future.cancel(false);
                    this.f19361d = null;
                    this.f19362e = 0L;
                }
                this.f19365h = 0;
                try {
                    if (this.f19359b.isHeld()) {
                        try {
                            this.f19359b.release();
                            if (this.f19366i != null) {
                                this.f19366i = null;
                            }
                        } catch (RuntimeException e10) {
                            if (!e10.getClass().equals(RuntimeException.class)) {
                                throw e10;
                            }
                            Log.e("WakeLock", String.valueOf(this.f19369l).concat(" failed to release!"), e10);
                            if (this.f19366i != null) {
                                this.f19366i = null;
                            }
                        }
                    } else {
                        Log.e("WakeLock", String.valueOf(this.f19369l).concat(" should be held!"));
                    }
                } catch (Throwable th) {
                    if (this.f19366i != null) {
                        this.f19366i = null;
                    }
                    throw th;
                }
            }
        }
    }
}
