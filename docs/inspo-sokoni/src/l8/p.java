package l8;

import android.os.AsyncTask;
import com.google.android.gms.tasks.TaskExecutors;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Executor f12579a = TaskExecutors.MAIN_THREAD;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Executor f12580b = new x1.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Executor f12581c = new a0(4, AsyncTask.THREAD_POOL_EXECUTOR);
}
