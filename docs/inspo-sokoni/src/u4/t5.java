package u4;

import android.content.Context;
import com.google.android.gms.tasks.OnFailureListener;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class t5 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static t5 f16822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Duration f16823e = Duration.ofMinutes(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k7 f16824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.common.internal.x f16825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f16826c = new AtomicLong(-1);

    public t5(Context context, k7 k7Var) {
        this.f16825b = com.google.android.gms.common.internal.w.b(context, com.google.android.gms.common.internal.y.a().b("measurement:api").a());
        this.f16824a = k7Var;
    }

    public static t5 a(k7 k7Var) {
        if (f16822d == null) {
            f16822d = new t5(k7Var.zza(), k7Var);
        }
        return f16822d;
    }

    public final synchronized void b(int i10, int i11, long j10, long j11, int i12) {
        final long jB = this.f16824a.zzb().b();
        if (this.f16826c.get() == -1 || jB - this.f16826c.get() > f16823e.toMillis()) {
            this.f16825b.a(new com.google.android.gms.common.internal.v(0, Arrays.asList(new com.google.android.gms.common.internal.o(36301, i11, 0, j10, j11, null, null, 0, i12)))).addOnFailureListener(new OnFailureListener() { // from class: u4.w5
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    this.f16926a.f16826c.set(jB);
                }
            });
        }
    }
}
