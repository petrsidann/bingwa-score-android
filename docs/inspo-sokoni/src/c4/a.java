package c4;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class a implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3331a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BlockingQueue f3332b = new LinkedBlockingQueue();

    public IBinder a(long j10, TimeUnit timeUnit) throws TimeoutException {
        com.google.android.gms.common.internal.r.k("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f3331a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f3331a = true;
        IBinder iBinder = (IBinder) this.f3332b.poll(j10, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f3332b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
