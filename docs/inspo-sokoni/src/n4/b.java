package n4;

import android.os.Looper;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ClassLoader f13422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Thread f13423b;

    /* JADX WARN: Code duplicated, block: B:49:0x00a6 A[Catch: all -> 0x00d5, PHI: r1
  0x00a6: PHI (r1v4 java.lang.Thread) = (r1v3 java.lang.Thread), (r1v15 java.lang.Thread) binds: [B:7:0x000a, B:45:0x00a1] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000c, B:44:0x009f, B:57:0x00cc, B:12:0x001f, B:48:0x00a5, B:49:0x00a6, B:60:0x00d0, B:61:0x00d1, B:50:0x00a7, B:56:0x00cb, B:55:0x00b1, B:13:0x0020, B:15:0x002d, B:21:0x0042, B:22:0x0049, B:24:0x0054, B:30:0x0069, B:31:0x0070, B:41:0x0083, B:42:0x009d, B:18:0x003c), top: B:67:0x0003, inners: #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static synchronized ClassLoader a() {
        SecurityException e10;
        Thread thread;
        ThreadGroup threadGroup;
        if (f13422a == null) {
            Thread thread2 = f13423b;
            ClassLoader contextClassLoader = null;
            if (thread2 != null) {
                synchronized (thread2) {
                    try {
                        contextClassLoader = f13423b.getContextClassLoader();
                    } catch (SecurityException e11) {
                        Log.w("DynamiteLoaderV2CL", "Failed to get thread context classloader " + e11.getMessage());
                    }
                }
                f13422a = contextClassLoader;
            } else {
                ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
                if (threadGroup2 == null) {
                    thread2 = null;
                } else {
                    synchronized (Void.class) {
                        try {
                            int iActiveGroupCount = threadGroup2.activeGroupCount();
                            ThreadGroup[] threadGroupArr = new ThreadGroup[iActiveGroupCount];
                            threadGroup2.enumerate(threadGroupArr);
                            int i10 = 0;
                            int i11 = 0;
                            while (true) {
                                if (i11 >= iActiveGroupCount) {
                                    threadGroup = null;
                                    break;
                                }
                                threadGroup = threadGroupArr[i11];
                                if ("dynamiteLoader".equals(threadGroup.getName())) {
                                    break;
                                }
                                i11++;
                            }
                            if (threadGroup == null) {
                                threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                            }
                            int iActiveCount = threadGroup.activeCount();
                            Thread[] threadArr = new Thread[iActiveCount];
                            threadGroup.enumerate(threadArr);
                            while (true) {
                                if (i10 >= iActiveCount) {
                                    thread = null;
                                    break;
                                }
                                thread = threadArr[i10];
                                if ("GmsDynamite".equals(thread.getName())) {
                                    break;
                                }
                                i10++;
                            }
                            if (thread == null) {
                                try {
                                    a aVar = new a(threadGroup, "GmsDynamite");
                                    try {
                                        aVar.setContextClassLoader(null);
                                        aVar.start();
                                        thread = aVar;
                                    } catch (SecurityException e12) {
                                        e10 = e12;
                                        thread = aVar;
                                        Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e10.getMessage());
                                    }
                                } catch (SecurityException e13) {
                                    e10 = e13;
                                }
                            }
                        } catch (SecurityException e14) {
                            e10 = e14;
                            thread = null;
                        }
                    }
                    thread2 = thread;
                }
                f13423b = thread2;
                if (thread2 != null) {
                    synchronized (thread2) {
                        contextClassLoader = f13423b.getContextClassLoader();
                    }
                }
                f13422a = contextClassLoader;
            }
        }
        return f13422a;
    }
}
