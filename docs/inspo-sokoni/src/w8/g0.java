package w8;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class g0 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final URL f17736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Future<?> f17737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Task<Bitmap> f17738c;

    public g0(URL url) {
        this.f17736a = url;
    }

    public static g0 t(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new g0(new URL(str));
        } catch (MalformedURLException unused) {
            Log.w("FirebaseMessaging", "Not downloading image, bad URL: " + str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(e());
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public void B(ExecutorService executorService) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f17737b = executorService.submit(new Runnable() { // from class: w8.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f17727a.z(taskCompletionSource);
            }
        });
        this.f17738c = taskCompletionSource.getTask();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f17737b.cancel(true);
    }

    public Bitmap e() throws IOException {
        if (Log.isLoggable("FirebaseMessaging", 4)) {
            Log.i("FirebaseMessaging", "Starting download of: " + this.f17736a);
        }
        byte[] bArrK = k();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrK, 0, bArrK.length);
        if (bitmapDecodeByteArray == null) {
            throw new IOException("Failed to decode image: " + this.f17736a);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Successfully downloaded image: " + this.f17736a);
        }
        return bitmapDecodeByteArray;
    }

    public final byte[] k() throws IOException {
        URLConnection uRLConnectionOpenConnection = this.f17736a.openConnection();
        if (uRLConnectionOpenConnection.getContentLength() > 1048576) {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        try {
            byte[] bArrD = b.d(b.b(inputStream, 1048577L));
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable("FirebaseMessaging", 2)) {
                Log.v("FirebaseMessaging", "Downloaded " + bArrD.length + " bytes from " + this.f17736a);
            }
            if (bArrD.length <= 1048576) {
                return bArrD;
            }
            throw new IOException("Image exceeds max size of 1048576");
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public Task<Bitmap> v() {
        return (Task) com.google.android.gms.common.internal.r.l(this.f17738c);
    }
}
