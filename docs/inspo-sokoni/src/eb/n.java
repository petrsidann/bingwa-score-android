package eb;

import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.j f7700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PackageManager f7701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f7702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fb.j.c f7703d;

    public class a implements fb.j.c {
        public a() {
        }

        @Override // fb.j.c
        public void onMethodCall(fb.i iVar, fb.j.d dVar) {
            if (n.this.f7702c == null) {
                return;
            }
            String str = iVar.f8284a;
            Object obj = iVar.f8285b;
            str.hashCode();
            try {
                if (str.equals("ProcessText.processTextAction")) {
                    ArrayList arrayList = (ArrayList) obj;
                    n.this.f7702c.b((String) arrayList.get(0), (String) arrayList.get(1), ((Boolean) arrayList.get(2)).booleanValue(), dVar);
                } else {
                    if (!str.equals("ProcessText.queryTextActions")) {
                        dVar.c();
                        return;
                    }
                    dVar.a(n.this.f7702c.a());
                }
            } catch (IllegalStateException e10) {
                dVar.b("error", e10.getMessage(), null);
            }
        }
    }

    public interface b {
        Map<String, String> a();

        void b(String str, String str2, boolean z10, fb.j.d dVar);
    }

    public n(ta.a aVar, PackageManager packageManager) {
        a aVar2 = new a();
        this.f7703d = aVar2;
        this.f7701b = packageManager;
        fb.j jVar = new fb.j(aVar, "flutter/processtext", fb.q.f8299b);
        this.f7700a = jVar;
        jVar.e(aVar2);
    }

    public void b(b bVar) {
        this.f7702c = bVar;
    }
}
