package u4;

import com.google.android.gms.internal.measurement.zzdi;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public final class i7<V> extends FutureTask<V> implements Comparable<i7<V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f16351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f16352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d7 f16354d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i7(d7 d7Var, Runnable runnable, boolean z10, String str) {
        super(zzdi.zza().zza(runnable), null);
        this.f16354d = d7Var;
        com.google.android.gms.common.internal.r.l(str);
        long andIncrement = d7.f16099l.getAndIncrement();
        this.f16351a = andIncrement;
        this.f16353c = str;
        this.f16352b = z10;
        if (andIncrement == Long.MAX_VALUE) {
            d7Var.zzj().C().a("Tasks index overflow");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i7(d7 d7Var, Callable<V> callable, boolean z10, String str) {
        super(zzdi.zza().zza(callable));
        this.f16354d = d7Var;
        com.google.android.gms.common.internal.r.l(str);
        long andIncrement = d7.f16099l.getAndIncrement();
        this.f16351a = andIncrement;
        this.f16353c = str;
        this.f16352b = z10;
        if (andIncrement == Long.MAX_VALUE) {
            d7Var.zzj().C().a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        i7 i7Var = (i7) obj;
        boolean z10 = this.f16352b;
        if (z10 != i7Var.f16352b) {
            return z10 ? -1 : 1;
        }
        long j10 = this.f16351a;
        long j11 = i7Var.f16351a;
        if (j10 < j11) {
            return -1;
        }
        if (j10 > j11) {
            return 1;
        }
        this.f16354d.zzj().E().b("Two tasks share the same index. index", Long.valueOf(this.f16351a));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        this.f16354d.zzj().C().b(this.f16353c, th);
        super.setException(th);
    }
}
