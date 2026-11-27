package s2;

import android.content.Context;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class l implements fb.j.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f15420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f15421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f15422d;

    public l(Context context, a aVar, p pVar, t tVar) {
        this.f15419a = context;
        this.f15420b = aVar;
        this.f15421c = pVar;
        this.f15422d = tVar;
    }

    @Override // fb.j.c
    public void onMethodCall(fb.i iVar, final fb.j.d dVar) {
        String str = iVar.f8284a;
        str.hashCode();
        switch (str) {
            case "checkServiceStatus":
                int i10 = Integer.parseInt(iVar.f8285b.toString());
                t tVar = this.f15422d;
                Context context = this.f15419a;
                Objects.requireNonNull(dVar);
                tVar.a(i10, context, new t.a() { // from class: s2.c
                    @Override // s2.t.a
                    public final void a(int i11) {
                        dVar.a(Integer.valueOf(i11));
                    }
                }, new b() { // from class: s2.d
                    @Override // s2.b
                    public final void a(String str2, String str3) {
                        dVar.b(str2, str3, null);
                    }
                });
                break;
            case "shouldShowRequestPermissionRationale":
                int i11 = Integer.parseInt(iVar.f8285b.toString());
                p pVar = this.f15421c;
                Objects.requireNonNull(dVar);
                pVar.i(i11, new p.c() { // from class: s2.h
                    @Override // s2.p.c
                    public final void a(boolean z10) {
                        dVar.a(Boolean.valueOf(z10));
                    }
                }, new b() { // from class: s2.i
                    @Override // s2.b
                    public final void a(String str2, String str3) {
                        dVar.b(str2, str3, null);
                    }
                });
                break;
            case "checkPermissionStatus":
                int i12 = Integer.parseInt(iVar.f8285b.toString());
                p pVar2 = this.f15421c;
                Objects.requireNonNull(dVar);
                pVar2.c(i12, new p.a() { // from class: s2.e
                    @Override // s2.p.a
                    public final void a(int i13) {
                        dVar.a(Integer.valueOf(i13));
                    }
                });
                break;
            case "openAppSettings":
                a aVar = this.f15420b;
                Context context2 = this.f15419a;
                Objects.requireNonNull(dVar);
                aVar.a(context2, new a.InterfaceC0270a() { // from class: s2.j
                    @Override // s2.a.InterfaceC0270a
                    public final void a(boolean z10) {
                        dVar.a(Boolean.valueOf(z10));
                    }
                }, new b() { // from class: s2.k
                    @Override // s2.b
                    public final void a(String str2, String str3) {
                        dVar.b(str2, str3, null);
                    }
                });
                break;
            case "requestPermissions":
                List<Integer> list = (List) iVar.b();
                p pVar3 = this.f15421c;
                Objects.requireNonNull(dVar);
                pVar3.g(list, new p.b() { // from class: s2.f
                    @Override // s2.p.b
                    public final void a(Map map) {
                        dVar.a(map);
                    }
                }, new b() { // from class: s2.g
                    @Override // s2.b
                    public final void a(String str2, String str3) {
                        dVar.b(str2, str3, null);
                    }
                });
                break;
            default:
                dVar.c();
                break;
        }
    }
}
