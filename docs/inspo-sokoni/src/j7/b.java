package j7;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.measurement.zzed;
import h7.f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f11302c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t4.a f11303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f11304b;

    public b(t4.a aVar) {
        r.l(aVar);
        this.f11303a = aVar;
        this.f11304b = new ConcurrentHashMap();
    }

    public static a c(f fVar, Context context, a8.d dVar) {
        r.l(fVar);
        r.l(context);
        r.l(dVar);
        r.l(context.getApplicationContext());
        if (f11302c == null) {
            synchronized (b.class) {
                if (f11302c == null) {
                    Bundle bundle = new Bundle(1);
                    if (fVar.y()) {
                        dVar.a(h7.b.class, new Executor() { // from class: j7.d
                            @Override // java.util.concurrent.Executor
                            public final void execute(Runnable runnable) {
                                runnable.run();
                            }
                        }, new a8.b() { // from class: j7.c
                            @Override // a8.b
                            public final void a(a8.a aVar) {
                                b.d(aVar);
                            }
                        });
                        bundle.putBoolean("dataCollectionDefaultEnabled", fVar.x());
                    }
                    f11302c = new b(zzed.zza(context, (String) null, (String) null, (String) null, bundle).zzb());
                }
            }
        }
        return f11302c;
    }

    public static /* synthetic */ void d(a8.a aVar) {
        boolean z10 = ((h7.b) aVar.a()).f9688a;
        synchronized (b.class) {
            ((b) r.l(f11302c)).f11303a.c(z10);
        }
    }

    @Override // j7.a
    public void a(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (k7.b.e(str) && k7.b.b(str2, bundle) && k7.b.d(str, str2, bundle)) {
            k7.b.a(str, str2, bundle);
            this.f11303a.a(str, str2, bundle);
        }
    }

    @Override // j7.a
    public void b(String str, String str2, Object obj) {
        if (k7.b.e(str) && k7.b.c(str, str2)) {
            this.f11303a.b(str, str2, obj);
        }
    }
}
