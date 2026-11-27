package p9;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import fb.i;
import fb.j;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class e implements j.c, xa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f14412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p9.a f14413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HandlerThread f14414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f14415d;

    public static class a implements j.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j.d f14416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f14417b = new Handler(Looper.getMainLooper());

        public a(j.d dVar) {
            this.f14416a = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(String str, String str2, Object obj) {
            this.f14416a.b(str, str2, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(Object obj) {
            this.f14416a.a(obj);
        }

        @Override // fb.j.d
        public void a(final Object obj) {
            this.f14417b.post(new Runnable() { // from class: p9.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f14410a.g(obj);
                }
            });
        }

        @Override // fb.j.d
        public void b(final String str, final String str2, final Object obj) {
            this.f14417b.post(new Runnable() { // from class: p9.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f14406a.f(str, str2, obj);
                }
            });
        }

        @Override // fb.j.d
        public void c() {
            Handler handler = this.f14417b;
            final j.d dVar = this.f14416a;
            Objects.requireNonNull(dVar);
            handler.post(new Runnable() { // from class: p9.b
                @Override // java.lang.Runnable
                public final void run() {
                    dVar.c();
                }
            });
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f14418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j.d f14419b;

        public b(i iVar, j.d dVar) {
            this.f14418a = iVar;
            this.f14419b = dVar;
        }

        /* JADX WARN: Code duplicated, block: B:25:0x006b  */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // java.lang.Runnable
        public void run() {
            boolean zG;
            Exception e10;
            j.d dVar;
            Object objK;
            j.d dVar2;
            byte b10 = 0;
            try {
                try {
                    e.this.f14413b.f14399e = (Map) ((Map) this.f14418a.f8285b).get("options");
                    zG = e.this.g(this.f14418a);
                    try {
                        String str = this.f14418a.f8284a;
                        switch (str.hashCode()) {
                            case -1335458389:
                                if (!str.equals("delete")) {
                                    b10 = -1;
                                } else {
                                    b10 = 4;
                                }
                                break;
                            case -358737930:
                                if (!str.equals("deleteAll")) {
                                    b10 = -1;
                                } else {
                                    b10 = 5;
                                }
                                break;
                            case 3496342:
                                if (!str.equals("read")) {
                                    b10 = -1;
                                } else {
                                    b10 = 1;
                                }
                                break;
                            case 113399775:
                                if (!str.equals("write")) {
                                    b10 = -1;
                                }
                                break;
                            case 208013248:
                                if (!str.equals("containsKey")) {
                                    b10 = -1;
                                } else {
                                    b10 = 3;
                                }
                                break;
                            case 1080375339:
                                if (!str.equals("readAll")) {
                                    b10 = -1;
                                } else {
                                    b10 = 2;
                                }
                                break;
                            default:
                                b10 = -1;
                                break;
                        }
                        Map<String, String> mapL = null;
                        if (b10 == 0) {
                            String strF = e.this.f(this.f14418a);
                            String strH = e.this.h(this.f14418a);
                            if (strH == null) {
                                this.f14419b.b("null", null, null);
                                return;
                            } else {
                                e.this.f14413b.m(strF, strH);
                                dVar = this.f14419b;
                            }
                        } else if (b10 == 1) {
                            String strF2 = e.this.f(this.f14418a);
                            if (e.this.f14413b.b(strF2)) {
                                objK = e.this.f14413b.k(strF2);
                                dVar2 = this.f14419b;
                                dVar2.a(objK);
                                return;
                            }
                            dVar = this.f14419b;
                        } else if (b10 == 2) {
                            dVar = this.f14419b;
                            mapL = e.this.f14413b.l();
                        } else {
                            if (b10 == 3) {
                                boolean zB = e.this.f14413b.b(e.this.f(this.f14418a));
                                dVar2 = this.f14419b;
                                objK = Boolean.valueOf(zB);
                                dVar2.a(objK);
                                return;
                            }
                            if (b10 == 4) {
                                e.this.f14413b.d(e.this.f(this.f14418a));
                                dVar = this.f14419b;
                            } else if (b10 != 5) {
                                this.f14419b.c();
                                return;
                            } else {
                                e.this.f14413b.e();
                                dVar = this.f14419b;
                            }
                        }
                        dVar.a(mapL);
                    } catch (Exception e11) {
                        e10 = e11;
                        if (zG) {
                            e.this.f14413b.e();
                            this.f14419b.a("Data has been reset");
                        } else {
                            StringWriter stringWriter = new StringWriter();
                            e10.printStackTrace(new PrintWriter(stringWriter));
                            this.f14419b.b("Exception encountered", this.f14418a.f8284a, stringWriter.toString());
                        }
                    }
                } catch (FileNotFoundException e12) {
                    Log.i("Creating sharedPrefs", e12.getLocalizedMessage());
                }
            } catch (Exception e13) {
                zG = false;
                e10 = e13;
            }
        }
    }

    public final String e(String str) {
        return this.f14413b.f14398d + "_" + str;
    }

    public final String f(i iVar) {
        return e((String) ((Map) iVar.f8285b).get("key"));
    }

    public final boolean g(i iVar) {
        Map map = (Map) iVar.f8285b;
        return map.containsKey("resetOnError") && map.get("resetOnError").equals("true");
    }

    public final String h(i iVar) {
        return (String) ((Map) iVar.f8285b).get("value");
    }

    public void i(fb.b bVar, Context context) {
        try {
            this.f14413b = new p9.a(context);
            HandlerThread handlerThread = new HandlerThread("com.it_nomads.fluttersecurestorage.worker");
            this.f14414c = handlerThread;
            handlerThread.start();
            this.f14415d = new Handler(this.f14414c.getLooper());
            j jVar = new j(bVar, "plugins.it_nomads.com/flutter_secure_storage");
            this.f14412a = jVar;
            jVar.e(this);
        } catch (Exception e10) {
            Log.e("FlutterSecureStoragePl", "Registration failed", e10);
        }
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        i(bVar.b(), bVar.a());
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        if (this.f14412a != null) {
            this.f14414c.quitSafely();
            this.f14414c = null;
            this.f14412a.e(null);
            this.f14412a = null;
        }
        this.f14413b = null;
    }

    @Override // fb.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        this.f14415d.post(new b(iVar, new a(dVar)));
    }
}
