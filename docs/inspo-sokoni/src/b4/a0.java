package b4;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public abstract class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource f2785b = new TaskCompletionSource();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f2787d;

    public a0(int i10, int i11, Bundle bundle) {
        this.f2784a = i10;
        this.f2786c = i11;
        this.f2787d = bundle;
    }

    public abstract void a(Bundle bundle);

    public abstract boolean b();

    public final void c(b0 b0Var) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Failing " + toString() + " with " + b0Var.toString());
        }
        this.f2785b.setException(b0Var);
    }

    public final void d(Object obj) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Finishing " + toString() + " with " + String.valueOf(obj));
        }
        this.f2785b.setResult(obj);
    }

    public final String toString() {
        return "Request { what=" + this.f2786c + " id=" + this.f2784a + " oneWay=" + b() + "}";
    }
}
