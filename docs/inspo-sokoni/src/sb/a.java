package sb;

import android.util.Log;
import fb.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: sb.a$a, reason: collision with other inner class name */
    public static class C0282a extends RuntimeException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f15700b;
    }

    public interface b {
        static fb.h<Object> a() {
            return new p();
        }

        static /* synthetic */ void c(b bVar, Object obj, fb.a.e eVar) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, bVar.u((String) arrayList2.get(0), (Boolean) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = a.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void g(b bVar, Object obj, fb.a.e eVar) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, bVar.remove((String) ((ArrayList) obj).get(0)));
            } catch (Throwable th) {
                arrayList = a.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void k(b bVar, Object obj, fb.a.e eVar) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, bVar.f((String) arrayList2.get(0), (List) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = a.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void l(b bVar, Object obj, fb.a.e eVar) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, bVar.i((String) arrayList2.get(0), (List) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = a.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void o(b bVar, Object obj, fb.a.e eVar) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, bVar.j((String) arrayList2.get(0), (List) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = a.a(th);
            }
            eVar.a(arrayList);
        }

        static /* synthetic */ void r(b bVar, Object obj, fb.a.e eVar) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, bVar.v((String) arrayList2.get(0), (Double) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = a.a(th);
            }
            eVar.a(arrayList);
        }

        static void s(fb.b bVar, final b bVar2) {
            fb.a aVar = new fb.a(bVar, "dev.flutter.pigeon.SharedPreferencesApi.remove", a(), bVar.b());
            if (bVar2 != null) {
                aVar.e(new fb.a.d() { // from class: sb.b
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a.b.g(this.f15701a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            fb.a aVar2 = new fb.a(bVar, "dev.flutter.pigeon.SharedPreferencesApi.setBool", a(), bVar.b());
            if (bVar2 != null) {
                aVar2.e(new fb.a.d() { // from class: sb.c
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a.b.c(this.f15702a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            fb.a aVar3 = new fb.a(bVar, "dev.flutter.pigeon.SharedPreferencesApi.setString", a(), bVar.b());
            if (bVar2 != null) {
                aVar3.e(new fb.a.d() { // from class: sb.d
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a.b.y(this.f15703a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            fb.a aVar4 = new fb.a(bVar, "dev.flutter.pigeon.SharedPreferencesApi.setInt", a(), bVar.b());
            if (bVar2 != null) {
                aVar4.e(new fb.a.d() { // from class: sb.e
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a.b.w(this.f15704a, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
            fb.a aVar5 = new fb.a(bVar, "dev.flutter.pigeon.SharedPreferencesApi.setDouble", a(), bVar.b());
            if (bVar2 != null) {
                aVar5.e(new fb.a.d() { // from class: sb.f
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a.b.r(this.f15705a, obj, eVar);
                    }
                });
            } else {
                aVar5.e(null);
            }
            fb.a aVar6 = new fb.a(bVar, "dev.flutter.pigeon.SharedPreferencesApi.setStringList", a(), bVar.b());
            if (bVar2 != null) {
                aVar6.e(new fb.a.d() { // from class: sb.g
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a.b.o(this.f15706a, obj, eVar);
                    }
                });
            } else {
                aVar6.e(null);
            }
            fb.a aVar7 = new fb.a(bVar, "dev.flutter.pigeon.SharedPreferencesApi.clear", a(), bVar.b());
            if (bVar2 != null) {
                aVar7.e(new fb.a.d() { // from class: sb.h
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a.b.l(this.f15707a, obj, eVar);
                    }
                });
            } else {
                aVar7.e(null);
            }
            fb.a aVar8 = new fb.a(bVar, "dev.flutter.pigeon.SharedPreferencesApi.getAll", a(), bVar.b());
            if (bVar2 != null) {
                aVar8.e(new fb.a.d() { // from class: sb.i
                    @Override // fb.a.d
                    public final void a(Object obj, fb.a.e eVar) {
                        a.b.k(this.f15708a, obj, eVar);
                    }
                });
            } else {
                aVar8.e(null);
            }
        }

        static /* synthetic */ void w(b bVar, Object obj, fb.a.e eVar) {
            Long lValueOf;
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            String str = (String) arrayList2.get(0);
            Number number = (Number) arrayList2.get(1);
            if (number == null) {
                lValueOf = null;
            } else {
                try {
                    lValueOf = Long.valueOf(number.longValue());
                } catch (Throwable th) {
                    arrayList = a.a(th);
                }
            }
            arrayList.add(0, bVar.p(str, lValueOf));
            eVar.a(arrayList);
        }

        static /* synthetic */ void y(b bVar, Object obj, fb.a.e eVar) {
            ArrayList<Object> arrayList = new ArrayList<>();
            ArrayList arrayList2 = (ArrayList) obj;
            try {
                arrayList.add(0, bVar.q((String) arrayList2.get(0), (String) arrayList2.get(1)));
            } catch (Throwable th) {
                arrayList = a.a(th);
            }
            eVar.a(arrayList);
        }

        Map<String, Object> f(String str, List<String> list);

        Boolean i(String str, List<String> list);

        Boolean j(String str, List<String> list);

        Boolean p(String str, Long l10);

        Boolean q(String str, String str2);

        Boolean remove(String str);

        Boolean u(String str, Boolean bool);

        Boolean v(String str, Double d10);
    }

    public static ArrayList<Object> a(Throwable th) {
        Object obj;
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof C0282a) {
            C0282a c0282a = (C0282a) th;
            arrayList.add(c0282a.f15699a);
            arrayList.add(c0282a.getMessage());
            obj = c0282a.f15700b;
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            obj = "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th);
        }
        arrayList.add(obj);
        return arrayList;
    }
}
