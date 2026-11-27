package rb;

import android.util.Log;
import fb.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: rb.a$a, reason: collision with other inner class name */
    public static class C0268a extends RuntimeException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f15336b;
    }

    public interface b {
        static fb.h<Object> a() {
            return new p();
        }

        static /* synthetic */ void e(b bVar, Object obj, fb.a.e eVar) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, bVar.m());
            } catch (Throwable th) {
                arrayList = a.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void f(b bVar, Object obj, fb.a.e eVar) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, bVar.q());
            } catch (Throwable th) {
                arrayList = a.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void i(b bVar, Object obj, fb.a.e eVar) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, bVar.n());
            } catch (Throwable th) {
                arrayList = a.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void k(b bVar, Object obj, fb.a.e eVar) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, bVar.j());
            } catch (Throwable th) {
                arrayList = a.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void o(b bVar, Object obj, fb.a.e eVar) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, bVar.b());
            } catch (Throwable th) {
                arrayList = a.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void r(b bVar, Object obj, fb.a.e eVar) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, bVar.l(arrayList2.get(0) == null ? null : c.values()[((Integer) arrayList2.get(0)).intValue()]));
            } catch (Throwable th) {
                arrayList = a.a(th);
            }
            eVar.a(arrayList);
        }

        static void t(fb.b bVar, final b bVar2) {
            fb.a aVar = new fb.a(bVar, "dev.flutter.pigeon.PathProviderApi.getTemporaryPath", a(), bVar.b());
            if (bVar2 != null) {
                aVar.e(new fb.a.d() { // from class: rb.b
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a.b.e(this.f15350a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            fb.a aVar2 = new fb.a(bVar, "dev.flutter.pigeon.PathProviderApi.getApplicationSupportPath", a(), bVar.b());
            if (bVar2 != null) {
                aVar2.e(new fb.a.d() { // from class: rb.c
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a.b.f(this.f15351a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            fb.a aVar3 = new fb.a(bVar, "dev.flutter.pigeon.PathProviderApi.getApplicationDocumentsPath", a(), bVar.b());
            if (bVar2 != null) {
                aVar3.e(new fb.a.d() { // from class: rb.d
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a.b.i(this.f15352a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            fb.a aVar4 = new fb.a(bVar, "dev.flutter.pigeon.PathProviderApi.getExternalStoragePath", a(), bVar.b());
            if (bVar2 != null) {
                aVar4.e(new fb.a.d() { // from class: rb.e
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a.b.k(this.f15353a, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
            fb.a aVar5 = new fb.a(bVar, "dev.flutter.pigeon.PathProviderApi.getExternalCachePaths", a(), bVar.b());
            if (bVar2 != null) {
                aVar5.e(new fb.a.d() { // from class: rb.f
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a.b.o(this.f15354a, obj, eVar);
                    }
                });
            } else {
                aVar5.e(null);
            }
            fb.a aVar6 = new fb.a(bVar, "dev.flutter.pigeon.PathProviderApi.getExternalStoragePaths", a(), bVar.b());
            if (bVar2 != null) {
                aVar6.e(new fb.a.d() { // from class: rb.g
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a.b.r(this.f15355a, obj, eVar);
                    }
                });
            } else {
                aVar6.e(null);
            }
        }

        List<String> b();

        String j();

        List<String> l(c cVar);

        String m();

        String n();

        String q();
    }

    public enum c {
        ROOT(0),
        MUSIC(1),
        PODCASTS(2),
        RINGTONES(3),
        ALARMS(4),
        NOTIFICATIONS(5),
        PICTURES(6),
        MOVIES(7),
        DOWNLOADS(8),
        DCIM(9),
        DOCUMENTS(10);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15349a;

        c(int i10) {
            this.f15349a = i10;
        }
    }

    public static ArrayList<Object> a(Throwable th) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof C0268a) {
            C0268a c0268a = (C0268a) th;
            arrayList.add(c0268a.f15335a);
            arrayList.add(c0268a.getMessage());
            obj = c0268a.f15336b;
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            obj = "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th);
        }
        arrayList.add(obj);
        return arrayList;
    }
}
